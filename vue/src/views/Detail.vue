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
        <el-divider></el-divider>
        <div style="font-size: 15px;">发布会议：{{form.conference}}</div>
        <el-divider></el-divider>
        <div style="font-size: 15px;">发布日期：{{form.date}}</div>
        <el-divider></el-divider>
        <div style="font-size: 15px;">所属领域：{{form.field}}</div>
        <el-divider></el-divider>
        <div style="font-size: 15px;">论文链接：
          <el-link href={{form.link}}>{{form.link}}</el-link>
          </div>
        <el-divider></el-divider>
        <div style="font-size: 15px;">笔记内容：{{form.content}}</div>

        <el-divider></el-divider>
        <comment style="width: 100%" :paperid =this.paper_id>
        </comment>

      </el-main>
    </el-container>

  </div>

</template>

<script>
import comment from "@/components/Comment";
import request from "@/utils/request";
export default {
  name: "Detail",
  components:{
    comment
  },
  data(){
    return{
      field_name:'',
      paper_id:'',
      lastPath:'',
      form:{
      }
    }
  },
  created() {
    this.paper_id = this.$route.query.paper_id
    console.log("jiazai详情")
    request.post("/api/paper?paper_id="+this.paper_id).then(res => {
      if (res.code === 0){
        console.log(res.data)
        this.form = res.data
        console.log(res.data)

      }else{
        this.$message.error("加载失败")
      }
    })
  },

}
</script>

<style scoped>

</style>
