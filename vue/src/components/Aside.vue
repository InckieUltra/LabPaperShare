
<template>
  <div>
    <el-menu
        style="width: 200px; min-height: calc(100vh - 50px)"
        :default-active="$route.path"
        router
    >
      <div  v-for="m in data.list" :key="m.id">
        <el-menu-item :index="m.path" v-if="m.name !== 'Person' && m.name !== 'Password' ">
          <i :class="m.icon"></i>  {{ m.comment }}
        </el-menu-item>
      </div>
    </el-menu>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Aside",
  data() {
    return {
      data: {
        list:[{
          id:1,
          path:'/home',
          name:'Home',
          icon:'el-icon-house',
          comment:'首页'
        },

          {
            id:2,
            path:'/upload',
            name:'Upload',
            icon:'el-icon-upload',
            comment:'上传论文'
          },
          {
            id:3,
            path:'/search',
            name:'Search',
            icon:'el-icon-search',
            comment:'搜索论文'
          },
          {
            id:4,
            path:'/permission',
            name:'Permission',
            icon:'el-icon-menu',
            comment:'权限管理'
          },
          {
            id:5,
            path:'/role',
            name:'Role',
            icon:'el-icon-s-custom',
            comment:'角色管理'
          },
          {
            id:6,
            path:'/category',
            name:'Category',
            icon:'el-icon-position',
            comment:'研究方向'
          },
          {
            id:7,
            path:'/note',
            name:'Note',
            icon:'el-icon-edit-outline',
            comment:'笔记管理'
          },
        ]
      },
    }
  },
  created() {
    let userStr = sessionStorage.getItem("user") || "{}"
    this.user = JSON.parse(userStr)

    // 请求服务端，确认当前登录用户的 合法信息
    // request.get("/user/" + this.user.id).then(res => {
    //   if (res.code === '0') {
    //     this.user = res.data
    //   }
    // })
  }
}
</script>

<style scoped>

</style>
