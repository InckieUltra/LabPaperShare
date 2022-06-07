<template>
  <div style="padding: 10px">
    <el-table
        v-loading="loading"
        :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
        border
        stripe
        style="width: 1100px">
      <el-table-column
          prop="role_id"
          label="论文标题"
          sortable
      >
      </el-table-column>
      <el-table-column
          prop="comment"
          label="论文作者">
      </el-table-column>

      <el-table-column
          prop="comment"
          label="所属领域">
      </el-table-column>
      <el-table-column
          prop="comment"
          label="发布时间">
      </el-table-column>
      <el-table-column label="操作" >
        <template #default="scope">
          <el-button size="mini" type="primary" @click="seeDetail(scope.row)">详情</el-button>
          <el-button size="mini" @click="seeFile(scope.row)">附件</el-button>
          <el-button size="mini" @click="seeComment(scope.row)">评论</el-button>
        </template>
      </el-table-column>
    </el-table>

    <div style="margin: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>

  </div>
  <el-drawer v-model="drawer" title="I am the title" :with-header="false" size="55%">
    <span>
      <comment style="width: 220%"></comment>
    </span>
  </el-drawer>
</template>

<script>


import request from "@/utils/request";
import {activeRouter} from "@/utils/permission";
import comment from "@/components/Comment";
export default {
  name: 'Role',
  components: {
    comment
  },
  data() {
    return {
      drawer:false,
      loading: true,
      form: {},
      dialogVisible: false,
      bookVis: false,
      search: '',
      currentPage: 1,
      pageSize: 10,
      total: 0,
      totalPage:1,
      tableData: [],
      permissions: [],
      changePermissions:{
        role_id:'',
        permission_id:[]
      }
    }
  },
  created() {
    this.load()
    //this.setCurrentPageData()
  },
  methods: {
    load() {
      this.loading = true
      request.post("/api/admin/allroleinfo").then(res => {
        if (res.code === 0){
          console.log(res.data.length)
          console.log("打印tableData: ")

          this.loading = false
          this.tableData = res.data
          for(let i=0;i<this.tableData.length;i++){
            let arr = new Array()
            for (let j = 0;j<this.tableData[i].permissions.length;j++){
              arr.push(this.tableData[i].permissions[j].permission_id)
            }
            this.tableData[i].permissions = arr;
          }
          console.log(this.tableData)
          this.total = res.data.length
        }else if (res.code === 1){
          this.$message({
            type: "error",
            message: res.msg,
          })

          this.$router.push("/login")
        }else{
          this.$message({
            type: "error",
            message: res.msg,
          })
        }

      })
    },

    seeDetail(row) {
    },
    seeFile(row) {
    },
    seeComment(row) {
      this.drawer=true;
        //console.log(row)
        this.$router.push({path: '/paperList',query:{field_id:row.field_id,field_name:row.field_name }})

    },
    handleSizeChange(pageSize) {   // 改变当前每页的个数触发
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {  // 改变当前页码触发
      this.currentPage = pageNum
      this.load()
    }
  }
}
</script>
