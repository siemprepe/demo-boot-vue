<template>
  <div id="app">

  <b-navbar toggleable="md" fixed="top" sticky type="dark" variant="warning" id="navbar">
    <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
    <b-navbar-brand href="#">Demo-Boot-Vue</b-navbar-brand>
    <b-collapse is-nav id="nav_collapse">

      <b-navbar-nav>
        <b-nav-item v-if="authenticated" :to="{ name: 'Home' }">Home</b-nav-item>
      </b-navbar-nav>

      <b-navbar-nav>
        <b-nav-item v-if="authenticated" :to="{ name: 'Claims' }">Claims</b-nav-item>
      </b-navbar-nav>

      <b-navbar-nav>
        <b-nav-item v-if="authenticated" :to="{ name: 'Notifications' }">Notifications</b-nav-item>
      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">

        <b-nav-item-dropdown right>
          <!-- Using button-content slot -->
          <template slot="button-content">
            <em>{{authUser}}</em>
          </template>
          <b-dropdown-item v-if="authenticated" to="/login" v-on:click.native="logout()" replace>
            Logout
          </b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>

    </b-collapse>
  </b-navbar>
    <router-view @authenticated="setAuthenticated" @authuser="setAuthUser"/>

     <b-navbar toggleable="md" fixed="bottom" type="dark" variant="danger" id="navbar">
        <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
        <b-navbar-brand href="#">Siemprepe</b-navbar-brand>
      </b-navbar>
  </div>
</template>

<script>

export default {
  name: 'app',
  data() {
      return {
          authenticated: false,
          authUser: "none"
      }
  },
  mounted() {
      if(!this.authenticated) {
          this.$router.replace({ name: "Login" });
      }
  },
  methods: {
      setAuthenticated(status) {
          this.authenticated = status;
      },
      setAuthUser(user) {
          this.authUser = user;
      },
      logout() {
          this.authenticated = false;
          this.authUser = "none";
      }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  height: 100%;
}
body,html {
    height: 100%;
}
#navbar{
  color: #000;
}
</style>
