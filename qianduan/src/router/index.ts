import { createRouter, createWebHistory } from "vue-router";
import UserCreate from "../components/UserCreate.vue";
import UserList from "../components/UserList.vue";
import UserUpdate from "../components/UserUpdate.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/",
            component: UserList
        },
        {
            path: "/create",
            component: UserCreate,
        },
        {
            path: "/update",
            component: UserUpdate
        }
    ]
})

export default router;