<template>
  <div style="height: 70px; line-height: 50px; border-bottom: 1px solid #ccc; display: flex">
    <div style="display: flex">
      <div>
        <el-icon :size="40" style="color:dodgerblue;margin-left: 10px;margin-top:14px;"><sunrise /></el-icon>
      </div>
      <div style="width: 200px; padding-left: 10px; font-weight: bold; color: dodgerblue;font-size: 20px;margin-top: 10px;">论文管理平台</div>

    </div>
    <div style="flex: 1"></div>
    <div>
      <el-badge :value="200" :max="99" class="item">
        <el-button size="small">评论</el-button>
      </el-badge>
      <el-badge :value="100" :max="10" class="item">
        <el-button size="small">消息</el-button>
      </el-badge>

    </div>
    <div style="width: 100px ">
      <el-dropdown style="margin-top: 10px;">
        <span class="el-dropdown-link">
          <el-avatar :size="30" :src="user.avatar" style="position: relative; top: 10px"></el-avatar>
           {{ user.nickName }}
          <i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="$router.push('/person')">个人信息</el-dropdown-item>
            <el-dropdown-item @click="$router.push('/changeProfile')">修改信息</el-dropdown-item>
            <el-dropdown-item @click="$router.push('/login')">退出系统</el-dropdown-item>
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

    }
  },
  created() {
  },
  components: {
    Sunrise,

  }
}
</script>

<style>
.item {
  margin-top: 10px;
  margin-right: 40px;
}
</style>
