<template>

  <div>
    <el-card style="width: 45%; margin: 10px">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item style="text-align: center" label-width="0">
            <el-upload
                class="avatar-uploader"
                action="http://localhost:9090/files/upload"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
            >
              <img v-if="form.avatar" :src="form.avatar" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item label="用户名">
            <el-input v-model="form.username"></el-input>
          </el-form-item>

          <el-form-item label="年龄">
            <el-input v-model="form.age"></el-input>
          </el-form-item>
          <!--        <el-form-item label="密码">-->
          <!--          <el-input v-model="form.password" show-password></el-input>-->
          <!--        </el-form-item>-->
        <el-form-item label="原密码" prop="password">
          <el-input v-model="form.password" show-password></el-input>
        </el-form-item>
        <el-form-item label="新密码" prop="newPass">
          <el-input v-model="form.newPass" show-password></el-input>
        </el-form-item>
        <el-form-item label="再次确认" prop="confirmPass">
          <el-input v-model="form.confirmPass" show-password></el-input>
        </el-form-item>
      </el-form>

      <div style="text-align: center">
        <el-button type="primary" @click="update">保存</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "ChangeProfile",
  data() {
    return {
     form: {
       username: "",
       nickName: "",
       password: '',
       newPass: '',
       confirmPass: ''
     },
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'}
          ,{
            min: 3,
            max: 20,
            message: '长度在 3 到 20 个字符',
            trigger: 'blur'
          }
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {
            min: 6,
            message: '请大于6个字符',
            trigger: 'blur'
          }
        ],
        newPass: [
          {required: true, message: '请输入新密码', trigger: 'blur'},
        ],
        confirmPass: [
          {required: true, message: '请输入确认新密码', trigger: 'blur'},
        ],
      },
    }
  },
  methods: {
    handleAvatarSuccess(res) {
      this.form.avatar = res.data
      this.$message.success("上传成功")
      // this.update()
    },
    update() {

      this.$refs['form'].validate((valid) => {
        if (valid) {
          if (!this.form.newPass === this.form.confirmPass) {
            this.$message.error('2次输入新密码必须一致')
            return
          }
          let user = JSON.parse(sessionStorage.getItem("user"))

          request.put("api/profile", this.form).then(res => {
            console.log(res)
            if (res.code === 0) {
              this.$message({
                type: "success",
                message: "更新成功",

              })
              sessionStorage.setItem("user", JSON.stringify(this.form))
              // 触发Layout更新用户信息
              this.$emit("userInfo")
            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          })
          // request.put("/user/pass", this.form).then(res => {
          //   if (res.code === 0) {
          //     this.$message.success('修改成功')
          //     this.$router.push("/login")
          //   } else {
          //     this.$message.error(res.msg)
          //   }
          // })
        }
      })

    }
  }
}
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 120px;
  height: 120px;
  line-height: 120px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
