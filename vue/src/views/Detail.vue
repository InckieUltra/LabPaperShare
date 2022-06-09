<template>
  <div>
    <el-breadcrumb separator="/" style="padding: 10px">
      <el-breadcrumb-item :to="{ path: '/category' }">浏览论文</el-breadcrumb-item>
      <el-breadcrumb-item>{{field_name}}</el-breadcrumb-item>
      <el-breadcrumb-item>{{lastPath}}</el-breadcrumb-item>
    </el-breadcrumb>

    <el-container>
      <el-header>
        <h1 style="text-align: center">{{form.title}}</h1>
        <div v-for="a in form.authors" style="text-align: center;white-space: nowrap;color: #545c64">{{a}}</div>
      </el-header>
      <el-main style="margin-top: 10px">
        <div style="font-size: 15px;">摘要：{{form.summary}}</div>
        <br>
        <div style="font-size: 15px;">发布会议：{{form.conference}}</div>
        <br>
        <div style="font-size: 15px;">发布日期：{{form.time}}</div>
        <br>
        <div style="font-size: 15px;">所属领域：{{form.field}}</div>
        <comment style="width: 100%">
        </comment>

      </el-main>
    </el-container>

  </div>

</template>

<script>
import comment from "@/components/Comment";
export default {
  name: "Detail",
  components:{
    comment
  },
  data(){
    return{
      field_name:'',
      lastPath:'',
      form:{
        title:"How to be a nerd pro plus",
        conference:'conference',
        summary:"针对带有同步自脱（SSS）离合器单轴布置的燃气—蒸汽联合循环机组，其SSS离合器处轴振偏大的问" +
            "题，利用SSS离合器啮合相位角控制装置，分别选取了0°、60°、180°、280°作为啮合相位角，记录SSS离" +
            "合器在瞬间啮合和整个带负荷过程中轴振的变化数据。结果表明：180°作为啮合相位角时，SSS离合器处轴振小，可作为其最佳啮合相位角.",
        authors:["haha","zuozhe2"],
        time:'1999-1-23'
      }
    }
  },
  created() {
    this.field_name = this.$route.query.field_name
    this.lastPath = this.$route.query.lastPath
  },

}
</script>

<style scoped>

</style>
