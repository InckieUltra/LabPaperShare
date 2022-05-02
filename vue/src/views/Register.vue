<template>
  <div class = "video-container">
    <div style="width: 100%; height: 100vh; overflow: hidden">
      <div style="width: 600px; margin: 100px auto;background-color: white;border-radius: 20px;box-shadow: 0 10px 20px  rgba(0, 0, 0, .05);">
        <div style="width: 400px; margin: 100px auto">
          <div style="font-size: 30px; text-align: center; padding: 30px 0">欢迎注册</div>
          <el-form ref="form" :model="form" size="normal" :rules="rules">
            <el-form-item  prop="username" >
              <el-input prefix-icon="el-icon-user-solid" v-model="form.username" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item prop="email">
              <el-input prefix-icon="el-icon-message" v-model="form.email" placeholder="请输入邮箱"></el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input prefix-icon="el-icon-lock" v-model="form.password" show-password placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item prop="confirm">
              <el-input prefix-icon="el-icon-lock" v-model="form.confirm" show-password placeholder="请确认密码"></el-input>
            </el-form-item>
            <div style="display: flex">
              <el-form-item prop="identify" style="width: 50%">
                <el-input prefix-icon="el-icon-caret-right" v-model="form.identify" placeholder="请输入验证码" ></el-input>
              </el-form-item>
              <el-form-item>
                <el-button v-if="disabled" type="primary" size="mini" style="width: 200px; height: 40px;margin-left: 12px" @click="verification" plain>
                  发送邮箱验证码
                </el-button>
                <el-button v-if="!disabled" type="info" disabled size="mini" style="width: 200px;height: 40px;margin-left: 12px">
                 <div>
                   {{ timer }}秒后重试
                 </div>
                </el-button>
              </el-form-item>
            </div>

            <el-form-item>
              <el-button  style="width: 100%" type="primary" @click="register" >注册</el-button>
            </el-form-item>
            <el-form-item><el-button type="text" @click="$router.push('/login')">&lt;&lt;返回登录 </el-button></el-form-item>
          </el-form>
        </div>
      </div>
    </div>

  </div>

</template>

<script>
import request from "@/utils/request";

export default {
  name: "Register",

  data() {
    return {
      disabled: true,
      timer: 11,
      form: {},
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
        email: [
          {required: true, message: '请输入邮箱', trigger: 'blur'},
          {
            pattern: /^([a-zA-Z0-9]+[-_\.]?)+@[a-zA-Z0-9]+\.[a-z]+$/,
            message: "请输入正确的邮箱格式",
            trigger: "blur"
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
        confirm: [
          {required: true, message: '请确认密码', trigger: 'blur'},
        ],
        identify: [
          {required: true, message: '请输入邮箱验证码', trigger: 'blur'},
        ],
      }
    }
  },
  methods: {
    send() {
      request.post("/api/register/sendemail", this.form).then(res => {
        console.log("发送验证码")
      })

    },
    verification() {

      this.disabled = false
      this.send()// 调获取验证码接口
      const authTimer = setInterval(() => {
        this.timer--
        if (this.timer <= 0) {
          this.disabled = true
          this.timer = 11
          clearInterval(authTimer)
        }
      }, 1000)
    },

    register() {

      if (this.form.password !== this.form.confirm) {
        this.$message({
          type: "error",
          message: '2次密码输入不一致！'
        })
        return
      }

      this.$refs['form'].validate((valid) => {
        if (valid) {
          request.post("/api/register", this.form).then(res => {
            if (res.code === 0) {
              this.$message({
                type: "success",
                message: "注册成功"
              })
              //this.$router.push("/login")  //登录成功之后进行页面的跳转，跳转到主页
            } else {
              this.$message({
                type: "error",
                message: res.msg
              })
            }
          })


        }
      })
    }
  }
}
</script>

<style scoped>
.video-container {
  position: relative;
  height: 100vh;
  overflow: hidden;
  background: url("../assets/background2.svg");
}

</style>
