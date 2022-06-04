<template>
  <el-card style="width: 50%;margin: 10px" >
    <div s>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="论文标题" style="width: 50%">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="研究领域" style="width: 50%">

        <div class="block">
            <el-cascader
                ref="cserve"
                v-model="form.field"
                :options="options"
                :props="props"
                clearable></el-cascader>
        </div>
        </el-form-item>

        <el-form-item label="发布会议" style="width: 50%">
          <el-input v-model="form.conference"></el-input>
        </el-form-item>
        <div style="display: inline-block">
          <el-form-item label="论文作者" style="width: 100%;">
            <el-tag
                :key="author"
                v-for="author in form.Authors"
                closable
                :disable-transitions="false"
                @close="handleClose(author)" style="">
              {{author}}
            </el-tag>
          </el-form-item>
        </div>

        <el-input
            class="input-new-tag"
            v-if="inputVisible"
            v-model="inputValue"
            ref="saveTagInput"
            size="small"
            @keyup.enter.native="handleInputConfirm"
            @blur="handleInputConfirm"
        >
        </el-input>
        <el-button v-else class="button-new-tag" size="small" @click="showInput">+新增作者</el-button>


        <el-form-item label="发布时间">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择论文发表日期" v-model="form.date" style="width: 100%;"></el-date-picker>
          </el-col>

        </el-form-item>

        <el-form-item label="论文类型" >
          <el-select v-model="form.type" placeholder="请选择论文类型" >
            <el-option label="理论证明型" value="理论证明型" ></el-option>
            <el-option label="综述型" value="综述型"></el-option>
            <el-option label="实验型" value="实验型"></el-option>
            <el-option label="工具型" value="工具型"></el-option>
            <el-option label="数据集型" value="数据集型"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="引用文献" >
        <el-select
            v-model="form.references"
            multiple
            collapse-tags

            placeholder="请选择">
          <el-option
              v-for="item in refOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>
        </el-form-item>

        <el-form-item label="笔记内容">
          <div id="div1" style="position:relative; z-index: 0">
          </div>
        </el-form-item>

        <el-form-item label="附加文件">
          <el-upload
              class="upload-demo"
              action="http://localhost:9090/user/import"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :before-upload="beforeUpload"
              :before-remove="beforeRemove"
              multiple
              :limit="1"
              :on-exceed="handleExceed"
              :file-list="form.fileList">
            <el-button size="small" >点击上传</el-button>
          </el-upload>

        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即创建</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-card>


</template>

<script>
import request from "@/utils/request";

let editor;
import E from 'wangeditor'
export default {
  name: "Upload",
  components:{
  },
  data() {
    return {
      props: { multiple: true,
        checkStrictly: true,
        value:'field_id',
      label: 'field_name'
      },
      inputVisible: false,
      inputValue: '',
      tableData:[],
      form: {
        name: '',
        date: '',
        conference:'',
        type: '',
        content:'',
        Authors: [],
        references:[],
        field: [],
        fileList: [{
          name: 'food.jpeg',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        }, {
          name: 'food2.jpeg',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        }]

      },

      options: [],
      refOptions:[]
    }
  },
  created() {
    request.post("/api/allfield").then(res => {
      this.options = res.data
      console.log("res.data")
      console.log(this.options)
      console.log("seccessQ!!")
    })

    //this.getTreeData(this.tableData)
  },
  mounted() {
    this.init()

  },
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    beforeUpload(file) {
      let fileSize = file.size
      const FIVE_M= 5*1024*1024;
      //大于5M，不允许上传
      if(fileSize>FIVE_M){
        this.$message.error("最大上传5M")
        return  false
      }
      //判断文件类型，必须是xlsx格式

      return true
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${ file.name }？`);
    },
    onSubmit() {
      // this.form.content = JSON.parse(JSON.stringify(this.BasicEditor.getHtml()))
      // console.log(this.form.content)
      request.post("/api/upload").then(res=>{

      })
      this.form.content = editor.txt.html()  // 获取 编辑器里面的值，然后赋予到实体当中
      console.log(this.form)
      console.log(this.options)
      console.log('submit!');
    },
    init(){
      editor = new E('#div1')
      // 或者 const editor = new E( document.getElementById('div1') )
      editor.create()
      editor.txt.html("")

    },
  handleChange(value) {
      console.log(value);
    },
    handleClose(author) {
      this.form.Authors.splice(this.form.Authors.indexOf(author), 1);
    },
    showInput() {
      this.inputVisible = true;
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    },

    handleInputConfirm() {
      let inputValue = this.inputValue;
      if (inputValue) {
        this.form.Authors.push(inputValue);
      }
      this.inputVisible = false;
      this.inputValue = '';
    }
  }
}
</script>

<style scoped>
.el-tag + .el-tag {
  margin-left: 10px;
}
.button-new-tag {
  margin-left: 10px;
  height: 32px;
  line-height: 30px;
  padding-top: 0;
  padding-bottom: 0;
}
.input-new-tag {
  width: 90px;
  margin-left: 10px;
  vertical-align: bottom;
}
</style>
