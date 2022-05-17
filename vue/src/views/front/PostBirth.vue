<template>
  <el-collapse-item title="查看生育记录信息" name="4">
    <template slot="title">
      <h1> 查看生育记录信息</h1><i class="header-icon el-icon-info"></i>
    </template>
    <div v-if=" births.length > 0">

      <el-row :gutter="10" style="margin-bottom: 40px;">
        <el-col v-for="form in births" :span="12">
          <el-card shadow="always" style="margin-bottom: 30px">
            <div slot="header" class="clearfix">
              <span>订单号:  {{ form.name }}</span>
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
    </div>
    <div v-else>
      <h3>非常抱歉！！！数据库未查到该数据</h3>
    </div>

  </el-collapse-item>
</template>

<script>
export default {
  name: "PostBirth"
}
</script>

<style scoped>

</style>