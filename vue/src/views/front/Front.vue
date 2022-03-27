<template>
  <div>
    <!--  回到顶部-->
    <template>

      <el-backtop></el-backtop>
    </template>
    <!--    头部-->
    <div style="display: flex;height: 60px;line-height: 60px;border-bottom: 1px solid #ccc;margin-bottom: 30px">

      <div style="width: 350px;display: flex;padding-left: 30px">
        <div style="width: 70px">
          <img src="../../assets/logo.png" style="width: 50px;position: relative;top: 5px;right: 0"/>
        </div>
        <div style="flex : 1"> 欢迎来到流动人口管理系统</div>

      </div>
      <!--      中间导航栏-->
      <div style="flex: 1; width: 500px;">
        <!-- 导航菜单-->
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect"
                 active-text-color="#409EFF"
                 router>
          <!-- 开启 router index里面的值为网页路由-->
          <el-menu-item index="/front/home">
            主页
          </el-menu-item>
          <el-submenu index="2">
            <template slot="title">城市风貌</template>
            <el-menu-item index="/front/cityinfo">城市介绍</el-menu-item>
            <el-menu-item index="2-2">最新政策</el-menu-item>
          </el-submenu>

          <el-submenu index="3">
            <template slot="title">个人信息查询</template>
            <el-menu-item index="/front/info">人口基本信息</el-menu-item>
            <el-menu-item index="/front/illegal">违法记录信息</el-menu-item>
            <el-menu-item index="/front/residence">暂住证记录信息</el-menu-item>
            <el-menu-item index="/front/birth">生育记录信息</el-menu-item>
          </el-submenu>

          <el-submenu index="4">
            <template slot="title">申请处理</template>
            <el-menu-item index="/front/postresidence">申请暂住证</el-menu-item>
            <el-menu-item index="/front/handleillegal">处理违法记录</el-menu-item>
          </el-submenu>


          <el-menu-item index="/front/article">文章列表</el-menu-item>
          <!--          <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>-->
        </el-menu>
        <div class="line"></div>


      </div>

      <!--      昵称-->
      <div style="width: 200px">
        <div v-if="!user.username" style="text-align: right; padding-right: 30px">
          <el-button @click="$router.push('/login')">登录</el-button>
          <el-button @click="$router.push('/register')">注册</el-button>

        </div>

        <div v-else>
          <el-dropdown style="width: 150px; cursor: pointer; text-align: right">
            <div style="display: inline-block">
              <img :src="user.avatarUrl" alt=""
                   style="width: 30px; border-radius: 50%; position: relative; top: 10px; right: 5px">
              <span>{{ user.nickname }}</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
            </div>
            <el-dropdown-menu slot="dropdown" style="width: 100px; text-align: center">
              <el-dropdown-item style="font-size: 14px; padding: 5px 0">
                <router-link to="/front/person">个人信息</router-link>
              </el-dropdown-item>
              <el-dropdown-item style="font-size: 14px; padding: 5px 0">
                <router-link to="/front/password">修改密码</router-link>
              </el-dropdown-item>
              <el-dropdown-item style="font-size: 14px; padding: 5px 0">
                <span style="text-decoration: none" @click="logout">退出</span>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>


      </div>
    </div>

    <div style="width: 1000px; margin: 0 auto">
      <router-view/>
    </div>

  </div>
</template>

<script>
export default {
  name: "Front",
  data() {
    return {
      activeIndex: '/front',
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    logout() {
      this.$store.commit("logout")
      this.$message.success("退出成功")
    }
  }
}
</script>

<style scoped>

</style>