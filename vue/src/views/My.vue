<template>
  <el-collapse v-model="activeNames" @change="handleChange">
    <el-collapse-item title="查看个人信息" name="1">
      <template slot="title">
        <h1> 查看个人信息</h1><i class="header-icon el-icon-info"></i>
      </template>
      <el-card shadow="always">
        <div slot="header" class="clearfix">
          <span>个人信息表</span>
          <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
        </div>

        <el-form label-width="100px" size="small">
          <el-form-item label="真实姓名">
            <el-input v-model="info.infoname" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="年龄">
            <el-input v-model="info.age" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio v-model="info.gender" label="男" value="男">男</el-radio>
            <el-radio v-model="info.gender" label="女" value="女">女</el-radio>
          </el-form-item>
          <el-form-item label="民族">
            <el-input v-model="info.nation" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="身份证号">
            <el-input v-model="info.idCard" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label="政治面貌">
            <el-select clearable v-model="info.politicalOutlook" placeholder="请选择政治面貌" style="width: 100%">
              <el-option v-for="item in politicalOutlooks" :key="item" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="婚姻状况">
            <el-select clearable v-model="info.marital" placeholder="请选择角色" style="width: 100%">
              <el-option v-for="item in maritals" :key="item" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="现居地">
            <el-input v-model="info.currentSidence" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label="手机号">
            <el-input v-model="info.phone" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label="是否为高级技术人才">

            <el-radio-group v-model="info.isSeniorTechnician">
              <el-radio :label=true>是</el-radio>
              <el-radio :label=false>否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="是否残疾">
            <el-radio v-model="info.isDisability" :label=true value="是">是</el-radio>
            <el-radio v-model="info.isDisability" :label=false value="是">否</el-radio>
          </el-form-item>
          <el-form-item label="是否军人">
            <el-radio v-model="info.isSoldier" :label=true>是</el-radio>
            <el-radio v-model="info.isSoldier" :label=false>否</el-radio>
          </el-form-item>
          <el-form-item label="是否外国人">
            <el-radio v-model="info.isForeigner" :label=true>是</el-radio>
            <el-radio v-model="info.isForeigner" :label=false>否</el-radio>
          </el-form-item>


        </el-form>

      </el-card>


    </el-collapse-item>
    <el-collapse-item title="查看违法记录信息" name="2">

      <template slot="title">
        <h1> 查看违法记录信息</h1><i class="header-icon el-icon-info"></i>
      </template>
      <el-row :gutter="10" style="margin-bottom: 40px;">
        <el-col v-for="form in illegals" :span="12">
          <el-card shadow="always" style="margin-bottom: 30px">
            <div slot="header" class="clearfix">
              <span>订单号:  {{ form.orderId }}</span>
              <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
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
    <el-collapse-item title="查看暂住证记录信息" name="3">
      <template slot="title">
        <h1> 查看暂住证记录信息</h1><i class="header-icon el-icon-info"></i>
      </template>
      <el-row :gutter="10" style="margin-bottom: 40px;">
        <el-col v-for="form in residences" :span="12">
          <el-card shadow="always" style="margin-bottom: 30px">
            <div slot="header" class="clearfix">
              <span>订单号:  {{ form.orderId }}</span>
              <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
            </div>

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
              <el-form-item label="年龄">
                <el-input v-model="form.age" autocomplete="off"></el-input>
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

          </el-card>
        </el-col>
      </el-row>

    </el-collapse-item>
    <el-collapse-item title="查看生育记录信息" name="4">

      <template slot="title">
        <h1> 查看生育记录信息</h1><i class="header-icon el-icon-info"></i>
      </template>
      <el-row :gutter="10" style="margin-bottom: 40px;">
        <el-col v-for="form in births" :span="12">
          <el-card shadow="always" style="margin-bottom: 30px">
            <div slot="header" class="clearfix">
              <span>订单号:  {{ form.orderId }}</span>
              <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
            </div>

            <el-form label-width="100px" size="small">
              <el-form-item label="姓名">
                <el-input v-model="form.name" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="身份证号">
                <el-input v-model="form.idCard" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="年龄">
                <el-input v-model="form.age" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="性别">
                <el-input v-model="form.gender" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="在读学校">
                <el-input v-model="form.school" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="父亲角色id">
                <el-input v-model="form.fatherId" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="母亲角色id">
                <el-input v-model="form.motherId" autocomplete="off"></el-input>
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
  name: "My",
  data() {
    return {
      activeNames: ['1'],
      id: "17",
      info: "",  //接受从后端获取的数据,一共4个
      illegals: [],
      residences: [],
      births: [],


      politicalOutlooks: ['群众', '中国共产党党员', '中国共产党预备党员', '中国共产主义青年团团员', '中国国民党革命委员会会员',
        '中国民主同盟盟员', '中国民主建国会会员', '中国民主促进会会员', '中国农工民主党党员', '中国致公党党员', '九三学社社员',
        '台湾民主自治同盟盟员', '无党派民主人士'],
      maritals: ['未婚', '已婚', '丧偶', '离婚'],

      pfs: [],
      mfs: [],

    };
  },
  created() {
    this.politicalOutlooks.forEach(row => {
      this.pfs.push({'text': row, 'value': row})
    })
    this.maritals.forEach(row => {
      this.mfs.push({'text': row, 'value': row})
    })

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
        this.info = res.data.info
        this.illegals = res.data.illegals
        this.residences = res.data.residences
        this.births = res.data.births
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