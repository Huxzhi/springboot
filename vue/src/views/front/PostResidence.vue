<template>
  <div>
    <el-row>
      <el-col :span="20">
        <el-card :body-style="{ padding: '0px' }" style="margin-left: auto;margin-right: auto;padding: 20px">
          <div slot="header" class="clearfix">
            申请注意事项
          </div>

          <h2>　一、暂住证主要功能和待遇</h2>
          <br/>
          　　(一)子女在居住地就读，享受居住地常住户口同等待遇；<br/>
          　　(二)可以缴纳公积金、养老金、医疗保险金等相关事项；<br/>
          　　(三)享受居住地创业辅导及申请非正规就业(可免税3年，可提供贷款)；<br/>
          　　(四)可在居住地办理签证等；<br/>
          　　(五)享受其他居住地常住户口的同等待遇；<br/>
          　　(六)暂住证可以方便居住地政府管理外来流动人口；<br/>
          　　(七)居住地政府可以利用暂住证的优惠政策吸引优秀人才。<br/>
          <br/>
          　<h2>　二、暂住证怎么办理</h2><br/>
          　　(一)离开常住户口所在地，拟在暂住地居住一个月以上年满16周岁的下列人员，应主动到暂住地辖区公安派出所或指定地点申办暂住证；<br/>
          　　(二)申领暂住证应当持暂住人的居民身份证，及近期正面免冠1寸照片3张，并按以下规定办理：<br/>
          　　　 1、暂住在居民家中的，由本人携带户主的户口簿到暂住地公安派出所或者其委托的管理站申领暂住证；<br/>
          　　　 2、暂住在机关、团体、部队、企业、事业单位内部或者工地、工场的，由单位或者雇主将暂住人员登记造册，到暂住地公安派出所申领暂住证；<br/>
          　　　 3、暂住在出租房屋的，由房主携带租赁合同，带领其到暂住地公安派出所申领暂住证。<br/>
          　　(三)暂住人在暂住地办理劳务许可证，工商营业执照等证照时应当出示居民身份证和暂住证。<br/>
          　　(四)暂住人遇有查验暂住证时，应当主动出示，不得拒绝；离开暂住地时，应当到当地公安派出所办理注销暂住手续，交回暂住证。<br/>
          　　(五)暂住证的合法权益受法律保护，除公安机关依照规定可以收缴或者吊销暂住证以外，任何单位和个人不得扣押公民的暂住证和其他身份证明。<br/>
          <br/>
          　<h2>　三、极速办理条件</h2><br/>
          　　(一)不存在违法记录即可
          <br><br><br>
          <el-button type="primary" @click="handleAdd" class="button bottom">

            <i class="el-icon-circle-plus-outline"></i>
            申请暂住证
          </el-button>
        </el-card>
      </el-col>
    </el-row>
    <el-dialog title="暂住证记录信息" :visible.sync="dialogFormVisible" width="40%">
      <el-form label-width="100px" size="small" :model="form" :rules="rules">
        <el-form-item label="姓名">
          <el-input v-model="form.name" autocomplete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio v-model="form.gender" label="男" value="男" :disabled="true">男</el-radio>
          <el-radio v-model="form.gender" label="女" value="女" :disabled="true">女</el-radio>
        </el-form-item>
        <el-form-item label="身份证号">
          <el-input v-model="form.idCard" autocomplete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="form.age" autocomplete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="从业学位及职业">
          <el-input v-model="form.occupation" autocomplete="off" minlength="2"></el-input>
        </el-form-item>
        <el-form-item label="原工作单位">
          <el-input v-model="form.work" autocomplete="off" minlength="2"></el-input>
        </el-form-item>
        <el-form-item label="房东">
          <el-input v-model="form.landlord" autocomplete="off" minlength="2"></el-input>
        </el-form-item>
        <el-form-item label="暂住地址">
          <el-input v-model="form.place" autocomplete="off" minlength="2"></el-input>
        </el-form-item>
        <el-form-item label="有效日期开始">
          <el-input v-model="form.timeStart" autocomplete="off" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="有效日期结束">
          <el-input v-model="form.timeEnd" autocomplete="off" :disabled="true"></el-input>
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
  name: "PostResidence",
  data() {
    return {
      form: {},
      dialogFormVisible: false,
      timeStart: '',
      timeEnd: '',
      rules: {
        name: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur'}
        ],
      }
    }
  },
  mounted() {
  },
  methods: {
    handleAdd() {

      this.form = {}
      this.form.userId = JSON.parse(localStorage.getItem("user")).id
      this.request.get("/info/" + this.form.userId).then(res => {
        if (res.code === '200') {
          this.$message.success("读取成功")
          this.form.name = res.data.infoname
          this.form.gender = res.data.gender
          this.form.idCard = res.data.idCard
          this.form.age = res.data.age
          this.dialogFormVisible = true
        } else {
          this.$message.error("错误代码" + res.code + "\n读取失败," + res.msg)
        }
      })


      this.form.timeStart = this.formatTime()
      this.form.timeEnd = this.formatTime(new Date().valueOf() + 180 * 24 * 60 * 60 * 1000)

    },


    save() {
      this.request.post("/my/postresidence", this.form).then(res => {
        if (res.code === '200') {
          this.$message.success("保存成功")
          this.dialogFormVisible = false
          this.load()
        } else {
          this.$message.error("错误代码" + res.code + "\n保存失败," + res.msg)
        }
      })
    },

    //格式化时间戳
    formatTime(timestamp) {
      var Y, m, d, H, i, s, sresult;
      console.log(timestamp + "123")
      if (timestamp) {
        var date = new Date(timestamp);
      } else {
        var date = new Date();
      }
      ;
      Y = date.getFullYear(),
          m = date.getMonth() + 1,
          d = date.getDate(),
          H = date.getHours(),
          i = date.getMinutes(),
          s = date.getSeconds();
      if (m < 10) {
        m = '0' + m;
      }
      if (d < 10) {
        d = '0' + d;
      }
      if (H < 10) {
        H = '0' + H;
      }
      if (i < 10) {
        i = '0' + i;
      }
      if (s < 10) {
        s = '0' + s;
      }
      sresult = Y + '-' + m + '-' + d + ' ' + H + ':' + i + ':' + s;
      // console.log(sresult);
      return sresult;
    }
  }
}
</script>

<style scoped>
.text {
  font-size: 14px;
}

.bottom {
  margin-top: 13px;
  line-height: 20px;
}

.button {
  margin: 20px;
  padding: 5px;
  float: right;
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