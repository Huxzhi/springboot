<template>
  <div class="bg" style="height: 100%;width: 100%">
    <div style="color: #666;font-size: 14px;padding-top: 30px ;">

      <el-card style=" margin-left: 20px;padding: 10px;width: 600px">
        <h1> 欢迎你！{{ user.nickname }}</h1>
        <el-divider/>
        祝您 虎虎生威，虎年大吉！
      </el-card>
      <div style="height: 1px; background: #ddd; margin: 20px 0;width: 620px"/>
    </div>


  </div>
</template>

<script>

export default {
  name: "Home",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }

  },

}
</script>
<style>
.bg {

  background-image: url(../assets/homebg.png);
  -moz-background-size: 100% 100%;
  -webkit-background-size: 100% 100%;

}

</style>