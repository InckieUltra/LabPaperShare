
<template>
  <div>
    <el-menu
        style="width: 220px; min-height: calc(100vh - 50px);height: 100%"
        :default-active="$route.path"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
        router
    >
      <div  v-for="m in permissionList" :key="m.permission_id">
      <el-menu-item :index="m.path"  v-if="m.name !== 'ChangeProfile'&& m.name!=='PaperList'">
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
      user:{
      },
      permissionList:{

      },
      data: {
      },
    }
  },
  created() {
    let userStr = sessionStorage.getItem("userPermission") || "{}"
    this.permissionList = JSON.parse(userStr)
    //console.log(this.permissionList)
    //请求服务端，确认当前登录用户的 合法信息
    //alert("/api/permission?user_id=" + this.user.user_id)
    // request.post("/api/permission?user_id=" + this.user.user_id).then(res => {
    //     console.log(res)
    //     console.log("permission Get")
    //     this.permissionList = res.data
    //     sessionStorage.setItem("userPermission", JSON.stringify(res))  // 缓存用户信息
    //     console.log(res.data)
    //     let userStrr = sessionStorage.getItem("userPermission") || "{}"
    //     this.permissionList = JSON.parse(userStrr)
    // })
  }
}
</script>

<style scoped>

</style>
