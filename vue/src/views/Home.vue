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
    <div>

      <el-row :gutter="10" style="margin-bottom: 40px;">
        <el-col :span="6">
          <el-card>
            <div style="color: #409EFF"><i class="el-icon-user-solid"/>用户总数</div>
            <div style="padding: 10px 0; text-align: center;font-weight: bold">
              100
            </div>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card>2</el-card>
        </el-col>
        <el-col :span="6">
          <el-card>3</el-card>
        </el-col>
        <el-col :span="6">
          <el-card>4</el-card>
        </el-col>


      </el-row>
      <el-row>
        <el-col :span="12">
          <div id="main" style="width: 500px ; height: 400px"></div>
        </el-col>
        <el-col :span="12">
          <div id="pie" style="width: 500px ; height: 400px"></div>
        </el-col>
      </el-row>
    </div>
    <el-row :gutter="30">
      <el-col :span="12">
        <div style="padding: 20px 0; font-size: 20px">小白做毕设专用框架</div>
        <div>
          这是一款专门针对毕设系统设计的框架，代码简单，结构清晰，如果你是小白，一定不要错过哦
        </div>
        <div class="m-10">
          <el-button type="danger"><i class="el-icon-coin"></i> 免费开源</el-button>
        </div>
        <div class="m-10">
          <el-button type="primary"><i class="el-icon-s-custom"></i> 交流QQ群：529910361</el-button>
        </div>
        <div class="m-10">
          <el-button type="primary"><i class="el-icon-link"></i> <a style="color: #fff"
                                                                    href="https://gitee.com/xqnode/pure-design">Gitee源码</a>
          </el-button>
          <el-button type="primary"><i class="el-icon-link"></i> <a style="color: #fff"
                                                                    href="https://www.bilibili.com/video/BV1U44y1W77D">B站视频讲解</a>
          </el-button>
        </div>
      </el-col>
      <el-col :span="12">
        <div style="padding: 20px 0; font-size: 20px">技术栈</div>
        <el-row>
          <el-col :span="12" style="line-height: 30px">
            <div><b>后端</b></div>
            <div>SpringBoot2</div>
            <div>Hutool</div>
            <div>Poi</div>
            <div>Lombok</div>
            <div>Mybatis/Mybatis-plus</div>
          </el-col>
          <el-col :span="12" style="line-height: 30px">
            <b>前端</b>
            <div>Vue2</div>
            <div>Vue-Router</div>
            <div>VueX</div>
            <div>ElementUI</div>
            <div>Axios</div>
          </el-col>
        </el-row>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="6">
        <el-card>
          <div slot="header" class="clearfix">
            <span>喝杯咖啡</span>
          </div>
          <div style="text-align: center">
            <img src="https://img-blog.csdnimg.cn/9250639d4fc74eb385e5975f58bef0da.png" alt="">
            <div class="pd-10">您可以请作者喝杯咖啡以资鼓励</div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from 'echarts';

export default {
  name: "Home",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  },
  mounted() { //页面元素渲染之后再触发

    var chartDom = document.getElementById('main');
    var myChart = echarts.init(chartDom);
    var option = {
      title: {
        text: '趋势图'
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        orient: 'vertical',
        left: 'right'
      },
      xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: [150, 230, 224, 218, 135, 147, 260],
          type: 'line'
        }
      ]
    };

    this.request.get("/echarts/example").then(res => {
      //填空
      option.xAxis.data = res.data.x
      option.series[0].data = res.data.y;
      //   option.series[1].data = res.data.y;
      //数据准备完毕之后再set
      myChart.setOption(option);
    })


    var pieDom = document.getElementById('pie');
    var pieChart = echarts.init(pieDom);
    var pieOption = {
      legend: {
        top: 'bottom'
      },
      toolbox: {
        show: true,
        feature: {
          mark: {show: true},
          dataView: {show: true, readOnly: false},
          restore: {show: true},
          saveAsImage: {show: true}
        }
      },
      series: [
        {
          name: 'Nightingale Chart',
          type: 'pie',
          radius: [50, 250],
          center: ['50%', '50%'],
          roseType: 'area',
          itemStyle: {
            borderRadius: 8
          },
          data: [
            {value: 40, name: 'rose 1'},
            {value: 38, name: 'rose 2'},
            {value: 32, name: 'rose 3'},
            {value: 30, name: 'rose 4'},
            {value: 28, name: 'rose 5'},
            {value: 26, name: 'rose 6'},
            {value: 22, name: 'rose 7'},
            {value: 18, name: 'rose 8'}
          ]
        }
      ]
    };

    pieChart.setOption(pieOption);
  }
}
</script>
