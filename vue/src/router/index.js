import {createRouter, createWebHistory} from 'vue-router'
import Layout from "@/layout/Layout";

const routes = [
    {
        path: '/',
        name: 'Layout',
        component: Layout,
        redirect: "/home",
        children: [
            {
                path: 'home',
                name: 'Home',
                component: () => import("@/views/Home"),
            },
            {
                path: '/person',
                name: 'Person',
                component: () => import("@/views/Person")
            },
            {
                path: '/upload',
                name: 'Upload',
                component: () => import("@/views/Upload")
            },
            {
                path: '/permission',
                name: 'Permission',
                component: () => import("@/views/Permission")
            },
            {
                path: '/role',
                name: 'Role',
                component: () => import("@/views/Role")
            },
            {
                path: '/category',
                name: 'Category',
                component: () => import("@/views/Category")
            },
            {
                path: '/search',
                name: 'Search',
                component: () => import("@/views/Search")
            },
            {
                path: '/note',
                name: 'Note',
                component: () => import("@/views/Note")
            },
            {
                path: '/changeProfile',
                name: 'ChangeProfile',
                component: () => import("@/views/ChangeProfile")
            },
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import("@/views/Login")
    },
    {
        path: '/register',
        name: 'Register',
        component: () => import("@/views/Register")
    },


]

const router = createRouter({
    //base: process.env.BASE_URL,
    history: createWebHistory(process.env.BASE_URL),
    routes
})

// activeRouter()
//
// function activeRouter() {
//     const userStr = sessionStorage.getItem("user")
//     if (userStr) {
//         const user = JSON.parse(userStr)
//         let root = {
//             path: '/',
//             name: 'Layout',
//             component: Layout,
//             redirect: "/home",
//             children: []
//         }
//         user.permissions.forEach(p => {
//             let obj = {
//                 path: p.path,
//                 name: p.name,
//                 component: () => import("@/views/" + p.name)
//             };
//             root.children.push(obj)
//         })
//         if (router) {
//             router.addRoute(root)
//         }
//     }
// }
export default router
