<template lang="html">
    <div>
        <h1>Update User</h1>
        <div>
            <label>id:</label>
            <input type="text" v-model="user.id">
        </div>
        <div>
            <label>用户名:</label>
            <input type="text" v-model="user.username">
        </div>
        <div>
            <label>密码:</label>
            <input type="password" v-model="user.password">
        </div>
        <button @click="updateUser">更新</button>
    </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

const router = useRouter();

const user = ref({
    id: null,
    username: '',
    password: ''
});

const updateUser = () => {
    axios.post(`http://127.0.0.1:8080/user/update`, {
        id: user.value.id,
        username: user.value.username,
        password: user.value.password
    })
        .then(() => {
            // 更新成功后跳转回用户列表页
            router.push('/');
        })
        .catch(error => {
            console.error('Error updating user:', error);
        });
}

</script>

<style lang="">

  </style>