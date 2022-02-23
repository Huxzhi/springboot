<template>
  <div>

    <el-row :gutter="10" style="margin-bottom: 40px;">
      <el-col :span="6">
        <el-card>
          <div style="color: #409EFF"><i class="el-icon-user-solid"/>
            流动人口记录总数
          </div>
          <div style="padding: 10px 0; text-align: center;font-weight: bold">
            {{ total.infoCount }}
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <div style="color: #67C23A"><i class="el-icon-user-solid"/>
            暂住证记录总数
          </div>
          <div style="padding: 10px 0; text-align: center;font-weight: bold">
            {{ total.residenceCount }}
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <div style="color: #F56C6C"><i class="el-icon-user-solid"/>
            违法信息记录总数
          </div>
          <div style="padding: 10px 0; text-align: center;font-weight: bold">
            {{ total.illegalCount }}
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <div style="color: #E6A23C"><i class="el-icon-user-solid"/>
            生育信息记录总数
          </div>
          <div style="padding: 10px 0; text-align: center;font-weight: bold">
            {{ total.birthCount }}
          </div>
        </el-card>
      </el-col>


    </el-row>
    <el-row>
      <el-col :span="12">
        <div id="pie" style="width: 500px ; height: 400px"></div>
      </el-col>
      <el-col :span="12">
        <div id="main" style="width: 500px ; height: 400px"></div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from "echarts";

export default {
  name: "Dashboard",
  data() {
    return {
      total: {},
      age_range: []
    }
  },
  created() {
    this.load()
  },

  mounted() { //页面元素渲染之后再触发

    this.request.get("/echarts/total").then(res => {
      this.total = res.data
    })


    var chartDom = document.getElementById('main');
    var myChart = echarts.init(chartDom);
    var option = {
      title: {
        text: '违法案件数量统计',
        subtext: '趋势图',
        left: 'center'
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
        data: ["第一季度", "第二季度", "第三季度", "第四季度"]
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          type: 'line'
        },
        {
          type: 'bar'
        }
      ]
    };

    this.request.get("/echarts/illegalRecord").then(res => {


      option.series[0].data = res.data;
      option.series[1].data = res.data;
      //数据准备完毕之后再set
      myChart.setOption(option);
    })


    //饼图 流动人口年龄结构图
    this.request.get("/echarts/age_range").then(res => {
      this.age_range = res.data

      var pieDom = document.getElementById('pie');
      var pieChart = echarts.init(pieDom);
      var pieOption = {
        title: {
          text: '流动人口年龄结构图'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '10%',
          left: 'center'
        },

        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: ['40%', '60%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: false,
                fontSize: '40',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },

            // data: this.age_range  //被自己蠢哭了
          }
        ]
      };
      pieOption.series[0].data = [
        {name: "少年人口", value: res.data[0]},
        {name: "青年人口", value: res.data[1]},
        {name: "中年人口", value: res.data[2]},
        {name: "退休人口", value: res.data[3]},
      ]

      pieChart.setOption(pieOption);

    })

  },

  methods: {
    load() {
    }
  }
}
</script>

<style scoped>

</style>