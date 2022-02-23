<template>
  <div style="color: #666;font-size: 14px;">
    <div style="padding-bottom: 20px">
      <b>欢迎你！{{ user.nickname }}</b>
    </div>
    <el-card>
      青哥出手，马上拥有
      <el-divider/>
      虎虎生威，虎年大吉
    </el-card>
    <div style="height: 1px; background: #ddd; margin: 20px 0"/>


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
