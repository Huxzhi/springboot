<template>
  <div>
    <div style="margin: 10px 0">
      <el-input style="width: 200px" placeholder="请输入姓名" suffix-icon="el-icon-search"
                v-model="name"></el-input>
      <el-input style="width: 200px" placeholder="请输入身份证号" suffix-icon="el-icon-edit" class="ml-5"
                v-model="idCard"></el-input>
      <el-input style="width: 200px" placeholder="请输入暂住地址" suffix-icon="el-icon-edit" class="ml-5"
                v-model="place"></el-input>


      <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
      <el-button type="warning" @click="reset">重置</el-button>
    </div>

    <div style="margin: 10px 0">
      <el-button type="primary" @click="handleAdd">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
      <el-popconfirm
          class="ml-5"
          confirm-button-text='确定'
          cancel-button-text='我再想想'
          icon="el-icon-info"
          icon-color="red"
          title="您确定批量删除这些数据吗？"
          @confirm="delBatch"
      >
        <el-button type="danger" slot="reference">批量删除 <i class="el-icon-remove-outline"></i></el-button>
      </el-popconfirm>
      <el-upload :action=importService :show-file-list="false" accept="xlsx"
                 :on-success="handleExcelImportSuccess" style="display: inline-block">
        <el-button type="primary" class="ml-5">导入 <i class="el-icon-bottom"></i></el-button>
      </el-upload>
      <el-button type="primary" @click="exp" class="ml-5">导出 <i class="el-icon-top"></i></el-button>
    </div>

    <el-table :data="tableData" border stripe :header-cell-class-name="'headerBg'"
              @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="name" label="姓名" width="80"></el-table-column>
      <el-table-column prop="idCard" label="身份证号" width="150"></el-table-column>

      <el-table-column prop="gender" label="性别" width="80"></el-table-column>
      <el-table-column prop="occupation" label="从业学位及职业" width="120"></el-table-column>
      <el-table-column prop="work" label="原工作单位" width="100"></el-table-column>
      <el-table-column prop="landlord" label="房东" width="80"></el-table-column>
      <el-table-column prop="place" label="暂住地址" width="120"></el-table-column>
      <el-table-column prop="timeStart" label="有效日期开始" width="190"></el-table-column>
      <el-table-column prop="timeEnd" label="有效日期结束" width="190"></el-table-column>


      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <el-button type="success" @click="handleEdit(scope.row)">编辑 <i class="el-icon-edit"></i></el-button>
          <el-popconfirm
              class="ml-5"
              confirm-button-text='确定'
              cancel-button-text='我再想想'
              icon="el-icon-info"
              icon-color="red"
              title="您确定删除吗？"
              @confirm="del(scope.row.id)"
          >
            <el-button type="danger" slot="reference">删除 <i class="el-icon-remove-outline"></i></el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="padding: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[5, 10, 15, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>

    <el-dialog title="暂住证记录信息" :visible.sync="dialogFormVisible" width="40%">
      <el-form label-width="100px" size="small">
        <el-form-item label="姓名">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio v-model="form.gender" label="男" value="男">男</el-radio>
          <el-radio v-model="form.gender" label="女" value="女">女</el-radio>
        </el-form-item>
        <el-form-item label="身份证号">
          <el-input v-model="form.idCard" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="从业学位及职业">
          <el-input v-model="form.occupation" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="原工作单位">
          <el-input v-model="form.work" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房东">
          <el-input v-model="form.landlord" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="暂住地址">
          <el-input v-model="form.place" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="有效日期开始">
          <el-input v-model="form.timeStart" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="有效日期结束">
          <el-input v-model="form.timeEnd" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {serverIpPort} from "../../public/config";

export default {
  name: "Residence",
  data() {
    return {
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 10,
      name: "",
      idCard: "",
      place: "",

      form: {},
      dialogFormVisible: false,

      importService: "http://" + serverIpPort + "/residence/import"
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      this.request.get("/residence/page", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          name: this.name,
          idCard: this.idCard,
          place: this.place,
        }
      }).then(res => {
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    save() {
      console.log(this.form)
      this.request.post("/residence", this.form).then(res => {
        if (res.code === '200') {
          this.$message.success("保存成功")
          this.dialogFormVisible = false
          this.load()
        } else {
          this.$message.error("保存失败")
        }
      })
    },
    handleAdd() {
      this.dialogFormVisible = true
      this.form = {}
    },
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogFormVisible = true
    },
    del(id) {
      this.request.delete("/residence/" + id).then(res => {
        if (res.code === '200') {
          this.$message.success("删除成功")
          this.load()
        } else {
          this.$message.error("删除失败")
        }
      })
    },
    handleSelectionChange(val) {
      console.log(val)
      this.multipleSelection = val
    },
    delBatch() {
      let ids = this.multipleSelection.map(v => v.id)  // [{}, {}, {}] => [1,2,3]
      this.request.post("/residence/del/batch", ids).then(res => {
        if (res.code === '200') {
          this.$message.success("批量删除成功")
          this.load()
        } else {
          this.$message.error("批量删除失败")
        }
      })
    },
    changeEnable(row) {
      this.request.post("/residence/update", row).then(res => {
        if (res.code === '200') {
          this.$message.success("操作成功")
        } else {
          this.$message.error("操作失败")
        }
      })
    },
    reset() {
      this.name = ""
      this.idCard = ""
      this.place = ""
      this.load()
    },
    handleSizeChange(pageSize) {
      console.log(pageSize)
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      console.log(pageNum)
      this.pageNum = pageNum
      this.load()
    },
    exp() {
      window.open("http://" + serverIpPort + "/residence/export")
    },
    handleExcelImportSuccess() {
      this.$message.success("导入成功")
      this.load()
    }
  }
}
</script>


<style>
.headerBg {
  background: #eee !important;
}
</style>
