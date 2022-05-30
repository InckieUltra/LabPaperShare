<template>
  <div>
    <el-select v-model="value" placeholder='value' style="width: 4%; padding: 5px; border-radius: 50px;margin-left: 7%">
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
      >
      </el-option>
    </el-select>
    <el-input
        v-model="state"
        placeholder="请输入内容"
        style="width: 70%; padding: 10px; border-radius: 50px;"
    ></el-input>
    <el-button v-on:click="loadData()" type="primary" icon="el-icon-search">搜索</el-button>
    <el-table
        :data="tableData"
        style="width: 100%"
        v-show="show"
        v-loading="loading">
      <el-table-column
          prop="paper_id"
          label="编号"
      >
      </el-table-column>
      <el-table-column
          prop="title"
          label="篇名"
      >
      </el-table-column>
      <el-table-column
          prop="conference"
          label="期刊"
      >
      </el-table-column>
      <el-table-column
          prop="summary"
          label="简介"
      >
      </el-table-column>
      <el-table-column
          prop="role_name"
          label="作者"
      >
      </el-table-column>
      <el-table-column
          prop="type"
          label="领域"
      >
      </el-table-column>
      <el-table-column
          label="操作"
      >
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
        <el-button type="text" size="small">编辑</el-button>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import VueSimpleSpinner from 'vue-simple-spinner'
import request from "@/utils/request";
export default {
  components: {
    VueSimpleSpinner
  },
  name: "Search",
  data(){
    return {
      show:false,
      loading:true,
      options: [{
        value: '版号',
        label: '版号'
      }, {
        value: '2',
        label: '篇名'
      }, {
        value: '3',
        label: '作者'
      }, {
        value: '4',
        label: '简介'
      }, {
        value: '5',
        label: '领域'
      }],
      value: '版号',
      tableData:[
        {
          paper_id:123,
          title:'',
          conference:'',
          summary:'',
          role_name:'',
          type:'',
        }
      ],
      total:[],
      restaurants: [],
      state: '',
      timeout: null,
      param:{

        value1:'',
        paper_id1:'',
      }
    }
  },
  mounted() {

  },
  methods: {
    loadData(){
      this.param.paper_id1 = this.state
      this.param.value1 = this.value
      this.loading=true
      request.post("/api/search",this.param).then((res) => {
            console.log(res)
        this.$message({
          duration:700,
          type: "success",
          message: "搜索成功"
        })
            this.tableData = res
            this.loading=false
            this.show=true

          }
      )
    },
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
    },
    querySearchAsync(queryString, cb) {
      var restaurants = this.restaurants;
      var results = queryString ? restaurants.filter(this.createStateFilter(queryString)) : restaurants;

      clearTimeout(this.timeout);
      this.timeout = setTimeout(() => {
        cb(results);
      }, 3000 * Math.random());
    },
    createStateFilter(queryString) {
      return (state) => {
        return (state.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
      };
    },
    handleSelect(item) {
      console.log(item);
    }
  },
}
</script>

<style scoped>

</style>
