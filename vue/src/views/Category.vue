<template>
  <div style="padding: 10px">

    <el-table
        v-loading="loading"
        :data="this.tableData"
        border
        stripe
        style="width: 100%;margin-top: 10px"
        row-key="field_id"
        default-expand-all>

      <el-table-column
          prop="field_name"
          label="领域名称">
      </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="mini" @click="handleJump(scope.row)" >查看论文</el-button>
        </template>
      </el-table-column>
    </el-table>
    </div>
</template>

<script>


import request from "@/utils/request";

export default {
  name: 'Category',
  components: {

  },
  data() {
    return {
      user: {},
      loading: true,
      form: {},
      dialogVisible: false,
      tableData:[],

    }
  },

  created() {

    this.load()
  },
  methods: {
    handleJump(row) {
      //console.log(row)
      this.$router.push({path: '/paperList',query:{field_id:row.field_id,field_name:row.field_name }})
    },
    load() {
      this.loading = true
      request.post("/api/allfield").then(res => {
        this.loading = false
        this.tableData = res.data
        //console.log(this.tableData)
      })
    },

  }
}
</script>
<style>
.custom-tree-node {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 14px;
  padding-right: 8px;
}
</style>
