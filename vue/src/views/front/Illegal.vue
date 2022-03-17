<template>
  <el-collapse v-model="activeNames" @change="handleChange">

    <el-collapse-item title="查看违法记录信息" name="1">

      <template slot="title">
        <h1> 查看违法记录信息</h1><i class="header-icon el-icon-info"></i>
      </template>
      <el-row :gutter="10" style="margin-bottom: 40px;">
        <el-col v-for="form in illegals" :span="12">
          <el-card shadow="always" style="margin-bottom: 30px">
            <div slot="header" class="clearfix">
              <span>订单号:  {{ form.orderId }}</span>
              <!--              <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>-->
            </div>

            <el-form label-width="100px" size="small">

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

          </el-card>
        </el-col>
      </el-row>
    </el-collapse-item>


  </el-collapse>
</template>

<script>
export default {
  name: "FrontIllegal",
  data() {
    return {
      activeNames: ['1'],
      id: "",

      illegals: [],


    };
  },
  created() {


    this.load()
  },
  methods: {
    handleChange(val) {
      // console.log(val);
    },
    load() {
      this.request.get("/my", {
        params: {
          id: JSON.parse(localStorage.getItem("user")).id
        }
      }).then(res => {
        this.illegals = res.data.illegals

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