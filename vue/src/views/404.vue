<template>
  <div style="overflow: hidden; height: 100vh">
    <img src="../assets/404.png" class="bgImg" alt="404" style="width: 100%; height: 100% ">


  </div>

</template>

<script>
export default {
  name: "NotFound"
}
</script>

<style>
.bgImg {
  background: url("../assets/404.png") no-repeat;
  background-size: 100% 100vh;
  width: 100%;
  height: 0;
  padding-bottom: 100%;
  overflow: hidden;


}

</style>
