<template>
  <div>
    <el-collapse v-model="activeNames" @change="handleChange">

      <el-collapse-item title="查看生育记录信息" name="1">

        <template slot="title">
          <h1> 查看生育记录信息</h1><i class="header-icon el-icon-info"></i>
        </template>
        <el-row :gutter="10" style="margin-bottom: 40px;">
          <el-col v-for="(form ,index) in births" :span="12">
            <el-card shadow="always" style="margin-bottom: 30px">
              <div slot="header" class="clearfix">
                <span>订单号:  {{ form.orderId }}</span>
                <el-button style="float: right; padding: 3px 0" type="text"
                           @click="postBirth(index)">申请修改
                </el-button>
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
    <el-dialog title="生育记录信息" :visible.sync="dialogFormVisible" width="30%">
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
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
export default {
  name: "FrontBirth",
  data() {
    return {
      activeNames: ['1'],
      id: "",
      births: [],
      dialogFormVisible: false,
      form: {},
      index: 0,
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
        this.births = res.data.births
      })
    },

    postBirth(index) {
      this.dialogFormVisible = true
      this.form = JSON.parse(JSON.stringify(this.births[index]))
    },

    save() {
      console.log(this.form)
      this.request.post("/birth", this.form).then(res => {
        if (res.code === '200') {
          this.$message.success("保存成功")
          this.dialogFormVisible = false
          this.load()
        } else {
          this.$message.error("保存失败")
        }
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