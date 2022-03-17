<template>
  <div>
    <div style="margin: 10px 0">
      首页广告展示
      <!--      轮播图-->
      <el-carousel height="450px" :interval="10000">
        <el-carousel-item v-for="item in imgs" :key="item">
          <img :src="item" alt="" style="width: 100%">
        </el-carousel-item>
      </el-carousel>
    </div>

    <div>
      <h1 style="color: #409EFF ;margin-bottom: 30px"> 消息速报：</h1>
      <el-col :span="23">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>流动人口服务管理条例</span>
            <el-button style="float: right; padding: 3px 0" type="text">查看</el-button>
          </div>
          <div>
            第一章 总则<br>
            第二章 居住登记<br>
            第三章 居住证申领<br>
            第四章 权益保障和公共服务<br>
            第五章 法律责任<br>
            第六章 附则<br>
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>流动人口计划生育管理和服务工作若干规定</span>
            <el-button style="float: right; padding: 3px 0" type="text">查看</el-button>
          </div>

        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>流动人口登记管理条例</span>
            <el-button style="float: right; padding: 3px 0" type="text">查看</el-button>
          </div>

          <div>
            <br><br><br><br><br><br><br><br><br><br><br> <br><br><br><br><br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
          </div>
        </el-card>
      </el-col>
    </div>


  </div>
</template>

<script>
export default {
  name: "FrontHome",
  data() {
    return {
      imgs: [
        'http://8.141.48.181:8081/api/file/7abebd69c0ae48b1839cfe1711866490.png',
        'http://8.141.48.181:8081/api/file/3be99304ca0746e89ef03b3f0e3c6b14.jpg'
      ],
      files: []
    }
  }, created() {
    this.request.get("/file/front/all").then(res => {
      console.log(res.data)
      this.files = res.data.filter(v => v.type === 'png' || v.type === 'jpg')
    })
  }
}
</script>

<style scoped>
.box-card {
  margin-top: 30px;
}
</style>