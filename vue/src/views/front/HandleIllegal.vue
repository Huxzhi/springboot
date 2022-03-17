<template>
  <div>
    <el-collapse v-model="activeNames" @change="handleChange">

      <el-collapse-item title="查看违法记录信息" name="1">

        <template slot="title">
          <h1> 查看未处理的违法记录信息</h1><i class="header-icon el-icon-info"></i>
        </template>
        <el-row :gutter="10" style="margin-bottom: 40px;">
          <el-col v-for="form in illegals" :span="12">
            <el-card shadow="always" style="margin-bottom: 30px">
              <div slot="header" class="clearfix">
                <span>订单号:  {{ form.orderId }}</span>
                <el-button style="float: right; padding: 3px 0" type="text"
                           @click="handleIllegal(form.id,form.orderId,form.forfeit)">申请处理
                </el-button>
              </div>

              <el-form label-width="100px" size="small">

                <el-form-item label="处罚机关">
                  <el-input v-model="form.punishmentAuhority" autocomplete="off" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="违法时间">
                  <el-input v-model="form.illegalTime" autocomplete="off" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="违法地点">
                  <el-input v-model="form.illegalPlace" autocomplete="off" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="违法行为">
                  <el-input v-model="form.illegalActivities" autocomplete="off" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="违法人员">
                  <el-input v-model="form.illegalPerson" autocomplete="off" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="违法人员身份证号">
                  <el-input v-model="form.illegalIdCard" autocomplete="off" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="罚款金额">
                  <el-input v-model="form.forfeit" autocomplete="off" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="其他措施">
                  <el-input v-model="form.otherMeasures" autocomplete="off" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="处罚时间">
                  <el-input v-model="form.penaltyTime" autocomplete="off" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="是否受理">
                  <el-radio v-model="form.isAccepted" :label=true :disabled="true">是</el-radio>
                  <el-radio v-model="form.isAccepted" :label=false :disabled="true">否</el-radio>
                </el-form-item>
                <el-form-item label="受理人">
                  <el-input v-model="form.receiver" autocomplete="off" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="受理时间">
                  <el-input v-model="form.acceptanceTime" autocomplete="off" :disabled="true"></el-input>
                </el-form-item>
              </el-form>

            </el-card>
          </el-col>
        </el-row>
      </el-collapse-item>


    </el-collapse>

    <el-dialog title="处理违法记录订单" :visible.sync="dialogFormVisible" width="350px">

      <el-form label-width="100px" size="small">
        <el-form-item label="订单号">
          <el-input v-model="orderId" autocomplete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="缴纳金额">
          <el-input v-model="forfeit" autocomplete="off" :disabled="true"></el-input>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click=" submitIllegal(id)">缴 纳</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "HandleIllegal",
  data() {
    return {
      activeNames: ['1'],
      id: "",
      orderId: "",
      forfeit: "",
      illegals: [],
      dialogFormVisible: false
    };
  },
  created() {


    this.load()
  },
  methods: {
    handleChange(val) {
      // console.log(val);
    },
    //申请处理按钮
    handleIllegal(id, orderId, forfeit) {
      this.id = id
      this.orderId = orderId
      this.forfeit = forfeit
      this.dialogFormVisible = true

    },
    submitIllegal(id) {
      this.request.post("/illegal/accept", id).then(res => {
        if (res.code === '200') {
          this.$message.success("处理成功")
          this.dialogFormVisible = false
          this.load()
        } else {
          this.$message.error("错误代码" + res.code + "\n处理失败," + res.msg)
        }
      })
    }
    ,
    load() {
      this.request.get("/illegal/mishandle/" + JSON.parse(localStorage.getItem("user")).id).then(res => {
        this.illegals = res.data
      })
    }
  }
}
</script>

<style scoped>

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.box-card {
  width: 480px;
}
</style>