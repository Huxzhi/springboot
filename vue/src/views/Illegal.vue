<template>
  <div>
    <div style="margin: 10px 0">
      <el-input style="width: 200px" placeholder="请输入真实姓名" suffix-icon="el-icon-search" v-model="orderId"></el-input>
      <el-input style="width: 200px" placeholder="请输入身份证号" suffix-icon="el-icon-edit" class="ml-5"
                v-model="idCard"></el-input>
      <el-input style="width: 200px" placeholder="请输入身份证号" suffix-icon="el-icon-edit" class="ml-5"
                v-model="idCard"></el-input>


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
      <el-upload action="http://localhost:8081/illegal/import" :show-file-list="false" accept="xlsx"
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


    <el-dialog title="流动人口信息" :visible.sync="dialogFormVisible" width="30%">
      <el-form label-width="100px" size="small">
        <el-form-item label="真实姓名">
          <el-input v-model="form.infoname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="form.age" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio v-model="form.gender" label="男" value="男">男</el-radio>
          <el-radio v-model="form.gender" label="女" value="女">女</el-radio>
        </el-form-item>
        <el-form-item label="民族">
          <el-input v-model="form.nation" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="身份证号">
          <el-input v-model="form.idCard" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="政治面貌">
          <el-select clearable v-model="form.politicalOutlook" placeholder="请选择政治面貌" style="width: 100%">
            <el-option v-for="item in politicalOutlooks" :key="item" :label="item" :value="item"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="婚姻状况">
          <el-select clearable v-model="form.marital" placeholder="请选择角色" style="width: 100%">
            <el-option v-for="item in maritals" :key="item" :label="item" :value="item"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="现居地">
          <el-input v-model="form.currentSidence" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="手机号">
          <el-input v-model="form.phone" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="是否为高级技术人才">

          <el-radio-group v-model="form.isSeniorTechnician">
            <el-radio :label=true>是</el-radio>
            <el-radio :label=false>否</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="是否残疾">
          <el-radio v-model="form.isDisability" :label=true value="是">是</el-radio>
          <el-radio v-model="form.isDisability" :label=false value="是">否</el-radio>
        </el-form-item>
        <el-form-item label="是否军人">
          <el-radio v-model="form.isSoldier" :label=true>是</el-radio>
          <el-radio v-model="form.isSoldier" :label=false>否</el-radio>
        </el-form-item>
        <el-form-item label="是否外国人">
          <el-radio v-model="form.isForeigner" :label=true>是</el-radio>
          <el-radio v-model="form.isForeigner" :label=false>否</el-radio>
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
export default {
  name: "Illegal",
  data() {
    return {
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 10,
      infoname: "",
      idCard: "",


      form: {},
      dialogFormVisible: false,


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
          // infoname: this.infoname,
          // idCard: this.idCard,
        }
      }).then(res => {
        this.tableData = res.data.records
        this.total = res.data.total
        // console.log(this.form)
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
      this.infoname = ""
      this.idCard = ""

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
      window.open("http://localhost:8081/illegal/export")
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
