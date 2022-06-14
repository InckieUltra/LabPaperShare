<template>
  <div>
    <el-select v-model="value" placeholder='value' style="width: 10%; padding: 5px; border-radius: 50px;margin-left: 7%">
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
    <div>
    <el-table
        :data="tabledata1"
        style="width: 100%"
        v-show="show"
        v-loading="loading"
        border>
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
          prop="field"
          label="方向"
      >
      </el-table-column>
      <el-table-column
          label="操作"
      >
        <template v-slot="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
        <el-button type="text" size="small" @click="changpath()">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
      <el-pagination @size-change="sizeChange" @current-change="currentChange"
                     :current-page="page" :page-size="size" :page-sizes="pageSizes" v-show="show1"
                     layout="total, sizes, prev, pager, next, jumper" :total="total" style="margin-left:37%">
      </el-pagination>
      </div>
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
      page: 1, //第几页
      size: 3, //一页多少条
      total: 0, //总条目数
      pageSizes: [1,3, 5, 10, 20, 50, 100, 200, 300, 400, 500, 1000], //可选择的一页多少条
      show:false,
      show1:false,
      loading:true,
      tabledata1:[],
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
          field:'',
        }
      ],
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
      this.show1=false
      this.param.paper_id1 = this.state
      this.param.value1 = this.value
      this.loading=true
      console.log("aaaaaa")
      request.post("/api/search",this.param).then((res) => {
        console.log(res)
        this.$message({
          duration:700,
          type: "success",
          message: "搜索成功"
        })
            this.tableData = res
            this.getTabelData()
            this.loading=false
            this.show=true
            this.show1=true
          }
      )
    },
    handleClick(row){
      this.$router.push({path:'/detail',query:{paper_id:row.paper_id}})
    },
    changpath(){
      this.$router.push('/');
    },
    getTabelData() {
      //allData为全部数据
      var data = JSON.parse(JSON.stringify(this.tableData))

      if(data == null){
        data=[]
      }
      this.tabledata1 = data.slice(
          (this.page - 1) * this.size,
          this.page * this.size
      );
      this.total=this.tableData.length
    },

    //page改变时的回调函数，参数为当前页码
    currentChange(val) {
      console.log("翻页，当前为第几页", val);
      this.page = val;
      this.getTabelData();
    },
    //size改变时回调的函数，参数为当前的size
    sizeChange(val) {
      console.log("改变每页多少条，当前一页多少条数据", val);
      this.size = val;
      this.page = 1;
      this.getTabelData();
    },
  created() {
    this.getTabelData();
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
