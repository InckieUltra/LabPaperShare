<template>
  <el-button type="primary" style="margin-left: 16px" @click="drawer = true">
    open
  </el-button>

  <el-drawer v-model="drawer" title="I am the title" :with-header="false">
    <span>Hi there!</span>
  </el-drawer>
</template>
<script>
export default {
  name: "Note",
  data() {
    return {
      drawer: false,
    };
  }
}
</script>

<style scoped>

</style>
