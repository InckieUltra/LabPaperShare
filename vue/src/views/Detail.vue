<template>
  <div>
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
          <el-link href='{{form.link}}'>{{form.link}}</el-link>
          </div>
        <el-divider></el-divider>
        <div style="font-size: 15px;">笔记内容：
        <div v-html="this.form.content"></div>
        </div>

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
  inject:['reload'],
  components:{
    comment
  },
  data(){
    return{
      field_name:'',
      paper_id:'',
      lastPath:'',
      form:{
        field:String
      }
    }
  },
  created() {
    this.paper_id = this.$route.query.paper_id
    console.log("jiazai详情")
    request.post("/api/paper?paper_id="+this.paper_id).then(res => {
      if (res.code === 0){

        this.form = res.data
        console.log(this.form)
        var temp
        for (var i = 0;i<res.data.fields.length;i++){
          console.log(res.data.fields[i].field_name)
          if (i===0){
            temp = res.data.fields[i].field_name
          }else{
            temp= temp + ','+ res.data.fields[i].field_name
          }
        }
        this.form.field=temp
      }else{
        this.$message.error("加载失败")
        console.log(res.msg)
      }
    })
  },

}
</script>

<style scoped>

</style>
