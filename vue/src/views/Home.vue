<template>
  <div style="padding: 10px">


    <div>
      <el-card>
        <div id="main" :style="{width: '750px', height: '600px'}"></div>
      </el-card>
    </div>

  </div>

  <div style="padding: 10px">
  <el-card>
    <div id="myChart" :style="{width: '750px', height: '600px'}"></div>
  </el-card>
  </div>

</template>

<script>
import request from "@/utils/request";

export default {
  name: "Home",
  data() {
    return {}
  },
  mounted() {
    this.drawLine();
    this.drawLine1();
  },
  // created() {
  //   let userStr = sessionStorage.getItem("user") || "{}"
  //   this.user = JSON.parse(userStr)
  //   // 请求服务端，确认当前登录用户的 合法信息
  //   request.get("/user/" + this.user.id).then(res => {
  //     if (res.code === 0) {
  //       this.user = res.data
  //     }
  //   })
  //
  //   this.load()
  // },
  methods: {
    drawLine1(){

      let myChart = this.$root.echarts.init(document.getElementById('main'))

      let option = {
        title: {
          text: '我的上传 vs 全组上传',
          subtext: 'Fake Data'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['我的上传', '全组上传']
        },
        toolbox: {
          show: true,
          feature: {
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ['line', 'bar'] },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        calculable: true,
        xAxis: [
          {
            type: 'category',
            // prettier-ignore
            data: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ],
        series: [
          {
            name: '我的上传',
            type: 'bar',
            data: [
              3, 0, 1, 8, 14, 2, 16, 11, 2, 10, 6, 3
            ],
            markPoint: {
              data: [
                { type: 'max', name: 'Max' },
                { type: 'min', name: 'Min' }
              ]
            },
            markLine: {
              data: [{ type: 'average', name: '平均上传数' }]
            }
          },
          {
            name: '全组上传',
            type: 'bar',
            data: [
              6, 9, 10, 26, 28, 31, 17, 18, 48, 18, 8, 7
            ],
            markPoint: {
              data: [
                { type: 'max', name: 'Max' },
                { type: 'min', name: 'Min' }
              ]
            },
            markLine: {
              data: [{ type: 'average', name: '平均上传数' }]
            }
          }
        ]
      }
      myChart.setOption(option);
    },
    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$root.echarts.init(document.getElementById('myChart'))
      let option = {
        title: {
          text: '我的上传论文比例统计图',
          subtext: '虚拟数据',
          left: 'left',
          bottom:'bottom'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          trigger: 'item'
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
            name: '用户比例',
            type: 'pie',
            radius: [50, 250],
            center: ['50%', '50%'],
            roseType: 'area',
            itemStyle: {
              borderRadius: 8
            },
            data: [{name :"哲学",value : 2},
              {name :"语言文学",value : 1},
              {name :"历史学",value : 4},
              {name :"法学",value : 8},
              {name :"管理学",value : 2},
              {name :"教育学",value : 3},
              {name :"医学",value : 5},
              {name :"工程学",value : 3 },
            ]
          }
        ]
      }
      myChart.setOption(option);
      // request.get("/user/count").then(res => {
      //   if (res.code === '0') {
      //     res.data.forEach(item => {
      //       option.series[0].data.push({name: item.address, value: item.count})
      //     })
      //     // 绘制图表
      //     myChart.setOption(option);
      //   }
      // })

    }
  }
}
</script>

<style scoped>

</style>
