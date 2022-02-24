<template>
  <div>
    <div style="margin: 10px 0">
      <el-input style="width: 200px" placeholder="请输入违法地点" suffix-icon="el-icon-search"
                v-model="illegalPlace"></el-input>
      <el-input style="width: 200px" placeholder="请输入违法行为" suffix-icon="el-icon-edit" class="ml-5"
                v-model="illegalActivities"></el-input>
      <el-input style="width: 200px" placeholder="请输入违法人员" suffix-icon="el-icon-edit" class="ml-5"
                v-model="illegalPerson"></el-input>


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
      <el-upload :action=importServer :show-file-list="false" accept="xlsx"
                 :on-success="handleExcelImportSuccess" style="display: inline-block">
        <el-button type="primary" class="ml-5">导入 <i class="el-icon-bottom"></i></el-button>
      </el-upload>
      <el-button type="primary" @click="exp" class="ml-5">导出 <i class="el-icon-top"></i></el-button>
    </div>

    <el-table :data="tableData" border stripe :header-cell-class-name="'headerBg'"
              @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="orderId" label="订单号" width="80"></el-table-column>
      <el-table-column prop="punishmentAuhority" label="处罚机关"></el-table-column>
      <el-table-column prop="illegalTime" label="违法时间" width="80"></el-table-column>
      <el-table-column prop="illegalPlace" label="违法地点"></el-table-column>
      <el-table-column prop="illegalActivities" label="违法行为"></el-table-column>
      <el-table-column prop="illegalPerson" label="违法人员"></el-table-column>
      <el-table-column prop="illegalIdCard" label="违法人员身份证号"></el-table-column>
      <el-table-column prop="forfeit" label="罚款金额"></el-table-column>
      <el-table-column prop="otherMeasures" label="其他措施"></el-table-column>
      <el-table-column prop="penaltyTime" label="处罚时间"></el-table-column>
      <el-table-column prop="isAccepted" label="是否受理">
        <template slot-scope="scope">
          <el-switch v-model="scope.row.isAccepted" active-color="#13ce66" inactive-color="#ccc"
                     @change="changeEnable(scope.row)"></el-switch>
        </template>
      </el-table-column>
      <el-table-column prop="receiver" label="受理人"></el-table-column>
      <el-table-column prop="acceptanceTime" label="受理时间" width="140">
      </el-table-column>
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


    <el-dialog title="违法记录信息" :visible.sync="dialogFormVisible" width="30%">
      <el-form label-width="100px" size="small">
        <el-form-item label="订单号">
          <el-input v-model="form.orderId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="处罚机关">
          <el-input v-model="form.punishmentAuhority" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="违法时间">
          <el-input v-model="form.illegalTime" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="违法地点">
          <el-input v-model="form.illegalPlace" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="违法行为">
          <el-input v-model="form.illegalActivities" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="违法人员">
          <el-input v-model="form.illegalPerson" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="违法人员身份证号">
          <el-input v-model="form.illegalIdCard" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="罚款金额">
          <el-input v-model="form.forfeit" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="其他措施">
          <el-input v-model="form.otherMeasures" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="处罚时间">
          <el-input v-model="form.penaltyTime" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否受理">
          <el-radio v-model="form.isAccepted" :label=true>是</el-radio>
          <el-radio v-model="form.isAccepted" :label=false>否</el-radio>
        </el-form-item>
        <el-form-item label="受理人">
          <el-input v-model="form.receiver" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="受理时间">
          <el-input v-model="form.acceptanceTime" autocomplete="off"></el-input>
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
  name: "Illegal",
  data() {
    return {
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 10,
      illegalPlace: "",
      illegalActivities: "",
      illegalPerson: "",

      form: {},
      dialogFormVisible: false,

      importServer: "http://" + serverIpPort + "/illegal/import"
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      this.request.get("/illegal/page", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          illegalPlace: this.illegalPlace,
          illegalActivities: this.illegalActivities,
          illegalPerson: this.illegalPerson,
        }
      }).then(res => {
        this.tableData = res.data.records
        this.total = res.data.total

      })

    },
    save() {

      console.log(this.form)
      this.request.post("/illegal", this.form).then(res => {
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
      this.request.delete("/illegal/" + id).then(res => {
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
      this.request.post("/illegal/del/batch", ids).then(res => {
        if (res.code === '200') {
          this.$message.success("批量删除成功")
          this.load()
        } else {
          this.$message.error("批量删除失败")
        }
      })
    },
    changeEnable(row) {
      this.request.post("/illegal/update", row).then(res => {
        if (res.code === '200') {
          this.$message.success("操作成功")
        } else {
          this.$message.error("操作失败")
        }
      })
    },
    reset() {
      this.illegalPlace = ""
      this.illegalActivities = ""
      this.illegalPerson = ""

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
      window.open("http://" + serverIpPort + "/illegal/export")
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
