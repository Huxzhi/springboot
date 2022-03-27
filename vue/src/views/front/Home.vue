<template>
  <div>
    <div style="margin: 10px 0">

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
            <span>人口流动是城乡发展强大力量</span>
            <el-button style="float: right; padding: 3px 0" type="text"
                       @click="$router.push('/front/articleDetail?id=3')">查看
            </el-button>
          </div>
          <div>
            国家统计局近日发布的《经济社会发展统计图表：第七次全国人口普查超大、特大城市人口基本情况》显示，我国人口向大城市及城市群集聚的趋势更加明显。在深入推进以人为核心的新型城镇化背景下，下一步该如何更好地尊重人在城市发展中的主体地位，切实提升城市发展质量，保障全体居民共享城镇化发展成果，值得各地重视。为此，本报特推出“推进以人为核心的新型城镇化”系列评论，邀请中国城市和小城镇改革发展中心研究员冯奎作相关解读。
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>全国流动人口十年间增长将近70% 人口流向了哪里？</span>
            <el-button style="float: right; padding: 3px 0" type="text"
                       @click="$router.push('/front/articleDetail?id=4')">查看
            </el-button>
          </div>
          <div>
            第七次人口普查数据已于近日发布。数据蕴含着丰富的信息，反映了中国经济社会和人口发展的历史进程。除了人口总量变动这样的“宏大”数据，区域人口、家庭人口、不同年龄段人口的形态特征等分类信息同样受到广泛关注，传递着经济社会发展变化的新信号。本报今起连续推出“透过‘七人普’看变化”报道，围绕“七人普”部分数据展开分析，探讨人口变动背后的原因及其所代表的意义。
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>我市流动人口调查报告发布</span>
            <el-button style="float: right; padding: 3px 0" type="text"
                       @click="$router.push('/front/articleDetail?id=5')">查看
            </el-button>
          </div>
          <div>
            昨天，市流动人口管理办委托国家统计局宁波调查队对全市流动人口的抽样调查报告发布。调查显示，流动人口最关注的问题是工资待遇、生活成本、就业、社会保障等；最满意的是交通便利、社会治安好、找工作比较容易等。
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
        'http://www.xuanchuanpianpaishe.com/uploads/allimg/180904/1-1PZ4115303W5.jpg',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbRPzYGVHTOe0y0eiZ7nv1CQVlje5eeRCA_ZTzoRUxB-FYoU-O17ZQcOsvLPDnPK7QDm0&usqp=CAU'
      ],
      files: []
    }
  }, created() {
    this.request.get("/file/front/all").then(res => {
      console.log(res.data)
      this.files = res.data.filter(v => v.type === 'png' || v.type === 'jpg')
    })
  },

  handle(url) {
    window.open('url', '_blank')
  }

}
</script>

<style scoped>
.box-card {
  margin-top: 30px;
}
</style>