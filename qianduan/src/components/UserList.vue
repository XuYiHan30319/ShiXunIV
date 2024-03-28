<template lang="html">
    <div>
        <button @click="jumpCreate">创建用户</button>
        <h1>User List</h1>
        <ul>
            <li v-for="user in userLists" :key="user.id">
                ID: {{ user.id }} - Username: {{ user.username }} - Password: {{ user.password }}
                <button @click="updateUser(user)">更新</button>
                <button @click="deleteUser(user.username)">删除用户</button>
            </li>
        </ul>
    </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

const userLists = ref<any[]>([]);
const router = useRouter();

onMounted(() => {
    axios.get('http://127.0.0.1:8080/user/findAll')
        .then(response => {
            userLists.value = response.data.data;
            console.log(userLists.value);
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
});

const deleteUser = (username: string) => {
    axios.delete(`http://127.0.0.1:8080/user/delete`, { params: { username: username } })
        .then(() => {
            fetchUserList(); // 删除成功后重新获取用户列表
        })
        .catch(error => {
            console.error('Error deleting user:', error);
        });
}

const updateUser = (user: any) => {
    router.push('/update'); // 跳转到更新页并传递用户 ID
}

const jumpCreate = () => {
    router.push('/create'); // 跳转到更新页
};

const fetchUserList = () => {
    axios.get('http://127.0.0.1:8080/user/findAll')
        .then(response => {
            userLists.value = response.data.data;
            console.log(userLists.value);
        })
        .catch(error => {
            console.error('Error fetching user data:', error);
        });
}
</script>

<style lang="">

  </style>