<template>
  <div>
    <el-collapse v-model="activeNames" @change="handleChange">

      <el-collapse-item title="查看暂住证记录信息" name="1">
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


    </el-collapse>

  </div>

</template>

<script>
export default {
  name: "FrontResidence",
  data() {
    return {
      activeNames: ['1'],
      id: "",

      residences: [],
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
        this.residences = res.data.residences
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