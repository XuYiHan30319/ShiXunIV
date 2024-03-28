<template lang="">
    <div>
        <form @submit.prevent="register">
            <div>
                <label for="username">用户名:</label>
                <input type="text" id="username" v-model="username" required>
            </div>
            <div>
                <label for="password">密码:</label>
                <input type="password" id="password" v-model="password" required>
            </div>
            <button type="submit">注册</button>
        </form>
    </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';
import router from '../router';

const username = ref('');
const password = ref('');

const register = () => {
    axios.post("http://127.0.0.1:8080/user/register", {
        username: username.value,
        password: password.value
    })
        .then(response => {
            router.push('/')
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}
</script>

<style lang="">

</style>
