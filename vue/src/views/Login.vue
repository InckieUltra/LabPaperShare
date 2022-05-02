<template>
  <div class="homepage-hero-module">
    <div class="video-container">
      <div :style="fixStyle" class="filter">
        <div class="mainlogin" style="width: 600px; margin: 100px auto;background-color: white;border-radius: 20px;box-shadow: 0 10px 20px  rgba(0, 0, 0, .05);">
          <div style="width: 400px; margin: 100px auto">
            <div style="font-size: 40px; text-align: center; padding: 30px 0; color: #333;font-family:ziti">论文管理系统</div>
            <el-form ref="form" :model="form" size="normal" :rules="rules">
              <el-form-item prop="username">
                <el-input prefix-icon="el-icon-user-solid" v-model="form.username" placeholder="请输入账号"></el-input>
              </el-form-item>
              <el-form-item prop="password">
                <el-input prefix-icon="el-icon-lock" v-model="form.password" show-password placeholder="请输入密码"></el-input>
              </el-form-item>
              <el-form-item>
                <div style="display: flex">
                  <el-input prefix-icon="el-icon-key" v-model="form.validCode" style="width: 50%" placeholder="请输入验证码"></el-input>
                  <ValidCode @input="createValidCode" style="margin-left: 40px" />
                </div>
              </el-form-item>
              <!--            <el-form-item>-->
              <!--              <el-radio v-model="form.role" :label="1" style="color: white">管理员</el-radio>-->
              <!--              <el-radio v-model="form.role" :label="2" style="color: white">普通用户</el-radio>-->
              <!--            </el-form-item>-->
              <el-form-item>
                <el-button style="width: 100%" type="primary" @click="login()">登 录</el-button>
              </el-form-item>
              <el-form-item><el-button type="text" @click="$router.push('/register')">前往注册 >> </el-button></el-form-item>
            </el-form>
          </div>

        </div>

      </div>
      <div class="login-container"
           v-bind:style="{backgroundImage:'url(' + bg + ')',
        backgroundRepeat:'no-repeat',
        backgroundSize:'100% 100%'}">
      </div>
    </div>
  </div>

</template>

<script>
import request from "@/utils/request";
import ValidCode from "@/components/ValidCode";
import {activeRouter} from "@/utils/permission";
import md5 from "js-md5"
export default {
  name: "Login",
  components: {
    ValidCode,
  },
  data() {
    return {
      data: {

      },
      form: {

      },
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
        ],
      },
      validCode: '',
      bg: {
        backgroundImage: "url(" + require("@/assets/bcg.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100% 100%"
      }
    }
  },
  mounted() {

    sessionStorage.removeItem("user")

  },
  methods: {
    // 接收验证码组件提交的 4位验证码
    createValidCode(data) {
      this.validCode = data
    },

    login () {
      this.$refs['form'].validate((valid) => {
        if (valid) {
          if (!this.form.validCode) {
            this.$message.error("请填写验证码")
            return
          }
          if(this.form.validCode.toLowerCase() !== this.validCode.toLowerCase()) {
            this.$message.error("验证码错误")
            return
          }
          // request.post("/api/login", this.form).then(res=>{
          //   console.log("khkhkasgdiuqwgadjagdvjasdfjqa")
          // })
          //request.post("/api/login","hhh")
          request.post("/api/login", this.form).then(res => {
            console.log(res)
            if (res.code === 0) {
              console.log(3333)
              this.$message({
                type: "success",
                message: "登录成功"
              })
              //activeRouter()
              sessionStorage.setItem("user", JSON.stringify(res.data))  // 缓存用户信息
              this.$router.push("/")  //登录成功之后进行页面的跳转，跳转到主页


              // 登录成功的时候更新当前路由



            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          }).catch(failRes=>{
            this.$message({
              type: "error",
              message: "寄"
            })
          })
        }
      })
    }
  }
}
</script>

<style>
.homepage-hero-module,
.video-container {
  position: relative;
  height: 100vh;
  overflow: hidden;
  background: url("../assets/background2.svg");
}

.video-container .poster img{
  z-index: 0;
  position: absolute;
}

.video-container .filter {
  z-index: 1;
  position: absolute;
  /*background: rgba(0, 0, 0, 0.4);*/
  width: 100%;

}

.fillWidth {
  width: 100%;
}
</style>
