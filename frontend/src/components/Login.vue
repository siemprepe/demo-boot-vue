<template>
<div class="container-fluid h-100">
    <div class="row justify-content-center align-items-center h-100">
        <div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">
        <div v-if="errors.length">
           <b-alert show variant="danger" v-for="error in errors" :key="error">{{ error }}</b-alert>
        </div>

          <b-form @submit="login">
            <b-form-group id="usernameGroup">
              <b-form-input id="username" v-model="input.username" required placeholder="Username"></b-form-input>
            </b-form-group>
            <b-form-group id="passwordGroup">
              <b-form-input id="password" v-model="input.password" type="password" required placeholder="Password"></b-form-input>
            </b-form-group>
            <b-button variant="primary" type="submit">Login</b-button>
          </b-form>
        </div>
    </div>
</div>
</template>

<script>
  import {AXIOS} from './http-common'

    export default {
        name: 'Login',
        data() {
            return {
                input: {
                    username: "",
                    password: ""
                },
                errors: []
            }
        },
        methods: {
            login(evt) {
              evt.preventDefault();
              this.errors = [];
              if(this.input.username != "" && this.input.password != "") {
                var params = new URLSearchParams()
                params.append('username', this.input.username)
                params.append('password', this.input.password)

                AXIOS.post(`/checkuser`, params)
                  .then(response => {
                      console.log(response.data)
                      if(response.data === true){
                        this.$emit("authenticated", true);
                        this.$emit("authuser", this.input.username);
                        this.$store.commit("global/setUser", { user: this.input.username })
                        this.$router.replace({ name: "Home" });
                      } else {
                          console.log("The username and / or password is incorrect");
                          this.errors.push("Username and / or password is incorrect");
                      }
                  })
                  .catch(e => {
                    this.errors.push(e)
                  })
                  } else{
                     console.log("A username and password must be present");
                     this.errors.push("A username and password must be present");
                  }
              },
        }
    }
</script>

<style scoped>

</style>
