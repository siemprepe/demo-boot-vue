<template>
  <div>
         <h1>demo {{testing}}</h1>
         <button @click="doIt()">Retrieve user</button>
  </div>
</template>

<script>
export default {
  name: 'Home',
  props: {},
  data() {
      return {
          testing: ""
      }
  },
  methods: {
    mounted() {
     this.testing = this.$store.getters['global/getUser'];
    },
    doIt() {
      console.log("doit");
      this.testing = this.$store.getters['global/getUser'];
    }
  }
}

</script>
