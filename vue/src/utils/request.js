import axios from 'axios'
import router from "@/router";
import config from "../config"

const baseUrl = process.env.NODE_ENV === 'development' ? config.baseUrl.dev : config.baseUrl.pro
const request = axios.create({
    baseURL: "/api",
    timeout: 5000
})

// 请求白名单，如果请求在白名单里面，将不会被拦截校验权限
const whiteUrls = ["/", ]


export default request

