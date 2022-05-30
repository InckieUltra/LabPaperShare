<template>


      <div id="treeChart" :style="{width: '750px', height: '900px'}"></div>


</template>


<script>
import request from "@/utils/request";

export default {
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
    append(data) {
      const newChild = { name: 'testtest', children: [] };
      if (!data.children) {
        this.$set(data, 'children', []);
      }
      data.children.push(newChild);
    },
    showChart() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$root.echarts.init(document.getElementById('treeChart'))
      myChart.on('click',function (params){
        console.log("dianji")
        this.append(data)
      })
      // 指定图表的配置项和数据
      let option = {
        tooltip: {
          trigger: 'item',
          triggerOn: 'mousemove',

        },
        title:{
          textStyle:{
            fontSize: 40
          },
        },
        series: [
          {
            type: 'tree',
            id: 0,
            name: 'tree1',
            data: [this.treedata],
            top: '10%',
            left: '8%',
            bottom: '22%',
            right: '20%',
            symbolSize: 7,
            edgeShape: 'polyline',
            edgeForkPosition: '63%',
            initialTreeDepth: 3,
            lineStyle: {
              width: 2
            },
            label: {
              backgroundColor: '#fff',
            textStyle:{
              fontSize: 16,
              color: '#545c64'
            },
              position: 'left',
              verticalAlign: 'middle',
              align: 'right'
            },
            leaves: {
              label: {
                position: 'right',
                verticalAlign: 'middle',
                align: 'left',
              }
            },

            emphasis: {
              focus: 'descendant',
            },
            expandAndCollapse: false,
            animationDuration: 550,
            animationDurationUpdate: 750
          }
        ]
      };
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    }
  },
  mounted() {
    this.showChart();
  },
  data() {
    return {
      treedata: {//一定一定要注意这里有[]
        name: 'flare',
        children: [
          {
            name: 'data',
            children: [
              {
                name: 'converters',
                children: [
                  { name: 'Converters', value: 721 },
                  { name: 'DelimitedTextConverter', value: 4294 }
                ]
              },
              {
                name: 'DataUtil',
                value: 3322
              }
            ]
          },
          {
            name: 'display',
            children: [
              { name: 'DirtySprite', value: 8833 },
              { name: 'RectSprite', value: 3623 }
            ]
          },
          {
            name: 'flex',
            children: [{ name: 'FlareVis', value: 4116 }]
          },
          {
            name: 'query',
            children: [

              { name: 'DateUtil', value: 4141 },
              { name: 'Distinct', value: 933 },

              {
                name: 'methods',
                children: [
                  { name: 'xor', value: 354 },
                  { name: 'x_x', value: 264 }
                ]
              },

              { name: 'Xor', value: 1101 }
            ]
          },
          {
            name: 'scale',
            children: [
              { name: 'ScaleType', value: 1821 },
              { name: 'TimeScale', value: 5833 }
            ]
          }
        ]
    }
  }
}
}
</script>
<style>

</style>
