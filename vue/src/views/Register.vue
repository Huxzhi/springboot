<template>
  <div class="wrapper">
    <div
        style="margin: 100px auto; background-color: #fff; width: 350px; height: 520px; padding: 20px; border-radius: 10px">
      <div style="margin: 20px 0; text-align: center; font-size: 24px"><b>注 册</b></div>
      <el-form :model="user" :rules="rules" ref="userForm">
        <el-form-item prop="username">
          <el-input placeholder="请输入账号" size="medium" style="margin: 5px 0" prefix-icon="el-icon-user"
                    v-model="user.username"></el-input>
        </el-form-item>
        <el-form-item prop="nickname">
          <el-input placeholder="请输入昵称" size="medium" style="margin: 5px 0" prefix-icon="el-icon-edit-outline"
                    v-model="user.nickname"></el-input>
        </el-form-item>
        <el-form-item prop="email">
          <el-input placeholder="请输入邮箱" size="medium" style="margin: 5px 0" prefix-icon="el-icon-message"
                    v-model="user.email"></el-input>
        </el-form-item>
        <el-form-item prop="phone">
          <el-input placeholder="请输入手机" size="medium" style="margin: 5px 0" prefix-icon="el-icon-message"
                    v-model="user.phone"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input placeholder="请输入密码" size="medium" style="margin: 5px 0" prefix-icon="el-icon-lock" show-password
                    v-model="user.password"></el-input>
        </el-form-item>
        <el-form-item prop="confirmPassword">
          <el-input placeholder="请确认密码" size="medium" style="margin: 5px 0" prefix-icon="el-icon-lock" show-password
                    v-model="user.confirmPassword"></el-input>
        </el-form-item>
        <el-form-item style="margin: 5px 0; text-align: right">
          <el-button type="primary" size="small" autocomplete="off" @click="register">注册</el-button>
          <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/login')">返回登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>

export default {
  name: "Register",
  data() {
    return {
      user: {},
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur'}
        ],
        nickname: [
          {required: true, message: '请输入昵称', trigger: 'blur'},
          {min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur'}
        ],
        email: [
          {required: true, message: '请输入邮件', trigger: 'blur'},
          {
            type: 'email',
            message: '请输入正确的邮箱地址', trigger: 'blur'
          }
        ],

        phone: [
          {required: true, message: '请输入手机号', trigger: 'blur'},
          {
            pattern: /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/,
            min: 11, max: 11, message: '请输入正确的手机号', trigger: 'blur'
          }
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 5, max: 20, message: '长度在 5 到 20 个字符', trigger: 'blur'}
        ],
        confirmPassword: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 5, max: 20, message: '长度在 5 到 20 个字符', trigger: 'blur'}
        ],
      }
    }
  },
  methods: {

    register() {
      this.request.post("/user/register", this.user).then(res => {
        if (res.code === '200') {
          this.$message.success("注册成功")
          this.router.push("/login")
        } else {
          this.$message.error("error:" + res.code + "\nmsg:" + res.msg)
        }
      })
    }

  }
}
</script>

<style>
.wrapper {
  height: 100vh;
  background-image: linear-gradient(to bottom right, #FC466B, #3F5EFB);
  overflow: hidden;
}
</style>
