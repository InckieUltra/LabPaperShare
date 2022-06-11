<template>
  <div style="height: 70px; line-height: 50px; border-bottom: 1px solid #ccc; display: flex">
    <div style="display: flex">
      <div>
        <el-icon :size="40" style="color:#545c64;margin-left: 10px;margin-top:14px;"><sunrise /></el-icon>
      </div>
      <div style="width: 200px; padding-left: 10px; font-weight: bold; color: #545c64;font-size: 20px;margin-top: 10px;">论文管理平台</div>

    </div>
    <div style="flex: 1"></div>

    <div>
      <el-badge class="item">
        <el-button size="small">评论</el-button>
      </el-badge>
      <el-badge  class="item">
        <el-button size="small">消息</el-button>
      </el-badge>

    </div>
    <div style="width: 100px ">
      <el-dropdown style="margin-top: 10px;">
        <span class="el-dropdown-link">
          <el-avatar :size="30" :src="circleUrl" style="position: relative; top: 10px"></el-avatar>
           {{ this.theName }}
          <i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="$router.push('/changeProfile')">修改信息</el-dropdown-item>
            <el-dropdown-item @click="loginOut">退出系统</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import {Sunrise} from "@element-plus/icons";

export default {
  name: "Header",
  props: ['user'],
  data() {
    return {
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      theName:''
    }
  },
  created() {
    let users = sessionStorage.getItem("user") || "{}"
    this.theName =  JSON.parse(users).userName

  },
  components: {
    Sunrise,

  },
  methods:{
    loginOut() {
      sessionStorage.removeItem("user")
      sessionStorage.removeItem("userPermission")
      this.$router.push('/login')
    }
  }
}
</script>

<style>
.item {
  margin-top: 10px;
  margin-right: 40px;
}
</style>
