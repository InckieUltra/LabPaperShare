(function(e){function t(t){for(var c,r,u=t[0],i=t[1],s=t[2],l=0,f=[];l<u.length;l++)r=u[l],Object.prototype.hasOwnProperty.call(a,r)&&a[r]&&f.push(a[r][0]),a[r]=0;for(c in i)Object.prototype.hasOwnProperty.call(i,c)&&(e[c]=i[c]);b&&b(t);while(f.length)f.shift()();return o.push.apply(o,s||[]),n()}function n(){for(var e,t=0;t<o.length;t++){for(var n=o[t],c=!0,r=1;r<n.length;r++){var u=n[r];0!==a[u]&&(c=!1)}c&&(o.splice(t--,1),e=i(i.s=n[0]))}return e}var c={},r={app:0},a={app:0},o=[];function u(e){return i.p+"js/"+({}[e]||e)+"."+{"chunk-0926493a":"a1b8e61d","chunk-2d0cf3bf":"e727fec9","chunk-330fa289":"218db112","chunk-5fff63aa":"5e1be177","chunk-6777d40a":"84e27646","chunk-6c65bfa2":"703c821b","chunk-6fd60b51":"48b90d55","chunk-7b4b674c":"135e6469","chunk-89e4a92e":"1acafa4f","chunk-91a43310":"f3ed4b75","chunk-97a9cf8c":"3a4bcc64","chunk-ae9ad570":"9b87c92e","chunk-cc5bd61a":"7d56bee6"}[e]+".js"}function i(t){if(c[t])return c[t].exports;var n=c[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,i),n.l=!0,n.exports}i.e=function(e){var t=[],n={"chunk-330fa289":1,"chunk-5fff63aa":1,"chunk-6777d40a":1,"chunk-6c65bfa2":1,"chunk-7b4b674c":1,"chunk-89e4a92e":1,"chunk-91a43310":1,"chunk-97a9cf8c":1,"chunk-ae9ad570":1};r[e]?t.push(r[e]):0!==r[e]&&n[e]&&t.push(r[e]=new Promise((function(t,n){for(var c="css/"+({}[e]||e)+"."+{"chunk-0926493a":"31d6cfe0","chunk-2d0cf3bf":"31d6cfe0","chunk-330fa289":"7e1c9188","chunk-5fff63aa":"da313f37","chunk-6777d40a":"0c216947","chunk-6c65bfa2":"c12b6111","chunk-6fd60b51":"31d6cfe0","chunk-7b4b674c":"a0b93234","chunk-89e4a92e":"13985e84","chunk-91a43310":"da313f37","chunk-97a9cf8c":"10067b22","chunk-ae9ad570":"a0b93234","chunk-cc5bd61a":"31d6cfe0"}[e]+".css",a=i.p+c,o=document.getElementsByTagName("link"),u=0;u<o.length;u++){var s=o[u],l=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(l===c||l===a))return t()}var f=document.getElementsByTagName("style");for(u=0;u<f.length;u++){s=f[u],l=s.getAttribute("data-href");if(l===c||l===a)return t()}var b=document.createElement("link");b.rel="stylesheet",b.type="text/css",b.onload=t,b.onerror=function(t){var c=t&&t.target&&t.target.src||a,o=new Error("Loading CSS chunk "+e+" failed.\n("+c+")");o.code="CSS_CHUNK_LOAD_FAILED",o.request=c,delete r[e],b.parentNode.removeChild(b),n(o)},b.href=a;var d=document.getElementsByTagName("head")[0];d.appendChild(b)})).then((function(){r[e]=0})));var c=a[e];if(0!==c)if(c)t.push(c[2]);else{var o=new Promise((function(t,n){c=a[e]=[t,n]}));t.push(c[2]=o);var s,l=document.createElement("script");l.charset="utf-8",l.timeout=120,i.nc&&l.setAttribute("nonce",i.nc),l.src=u(e);var f=new Error;s=function(t){l.onerror=l.onload=null,clearTimeout(b);var n=a[e];if(0!==n){if(n){var c=t&&("load"===t.type?"missing":t.type),r=t&&t.target&&t.target.src;f.message="Loading chunk "+e+" failed.\n("+c+": "+r+")",f.name="ChunkLoadError",f.type=c,f.request=r,n[1](f)}a[e]=void 0}};var b=setTimeout((function(){s({type:"timeout",target:l})}),12e4);l.onerror=l.onload=s,document.head.appendChild(l)}return Promise.all(t)},i.m=e,i.c=c,i.d=function(e,t,n){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(i.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var c in e)i.d(n,c,function(t){return e[t]}.bind(null,c));return n},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="/",i.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],l=s.push.bind(s);s.push=t,s=s.slice();for(var f=0;f<s.length;f++)t(s[f]);var b=l;o.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"46dd":function(e,t,n){"use strict";n("d7b4")},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var c=n("7a23"),r=Object(c["n"])("div",{id:"app",class:"body"},null,-1);function a(e,t,n,a,o,u){var i=Object(c["S"])("router-view"),s=Object(c["S"])("el-config-provider");return Object(c["J"])(),Object(c["m"])(c["b"],null,[r,Object(c["q"])(s,{locale:o.locale},{default:Object(c["ib"])((function(){return[Object(c["q"])(i)]})),_:1},8,["locale"])],64)}var o=n("ade3"),u=(n("b0c0"),n("7864")),i=n("3ef0"),s=n.n(i),l={name:"App",components:Object(o["a"])({},u["a"].name,u["a"]),data:function(){return{locale:s.a}}};n("c49f");l.render=a;var f=l,b=n("a18c"),d=n("5502"),h=Object(d["a"])({state:{user:{}},mutations:{SET_USER:function(e,t){e.user=t}},actions:{SET_USER:function(e,t){e.commit;this.state.user=t}},getters:{getUser:function(e){return e.user}}}),p=(n("7dd6"),n("4ca3")),m=(n("9378"),n("bc3a"),n("313e")),O=(n("aede"),n("fdf1")),j=Object(c["j"])(f).use(h).use(b["a"]).use(p["a"]).use(O["a"],{echarts:m,h:c["t"]}).use(u["b"],{size:"small"}).mount("#app");j.echarts=m},"9dac":function(e,t,n){var c={"./Category":["4886","chunk-5fff63aa"],"./Category.vue":["4886","chunk-5fff63aa"],"./ChangeProfile":["cb55","chunk-89e4a92e"],"./ChangeProfile.vue":["cb55","chunk-89e4a92e"],"./Detail":["c84b","chunk-7b4b674c"],"./Detail.vue":["c84b","chunk-7b4b674c"],"./Field":["ec20","chunk-91a43310"],"./Field.vue":["ec20","chunk-91a43310"],"./Home":["bb51","chunk-6777d40a"],"./Home.vue":["bb51","chunk-6777d40a"],"./Login":["a55b","chunk-97a9cf8c"],"./Login.vue":["a55b","chunk-97a9cf8c"],"./Note":["639e","chunk-2d0cf3bf"],"./Note.vue":["639e","chunk-2d0cf3bf"],"./PaperList":["fcac","chunk-ae9ad570"],"./PaperList.vue":["fcac","chunk-ae9ad570"],"./Register":["73cf","chunk-6c65bfa2"],"./Register.vue":["73cf","chunk-6c65bfa2"],"./Role":["c338","chunk-0926493a"],"./Role.vue":["c338","chunk-0926493a"],"./Search":["2d3b","chunk-cc5bd61a"],"./Search.vue":["2d3b","chunk-cc5bd61a"],"./Upload":["2679","chunk-330fa289"],"./Upload.vue":["2679","chunk-330fa289"],"./User":["1511","chunk-6fd60b51"],"./User.vue":["1511","chunk-6fd60b51"]};function r(e){if(!n.o(c,e))return Promise.resolve().then((function(){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}));var t=c[e],r=t[0];return n.e(t[1]).then((function(){return n(r)}))}r.keys=function(){return Object.keys(c)},r.id="9dac",e.exports=r},a18c:function(e,t,n){"use strict";n("d3b7"),n("3ca3"),n("ddb0"),n("159b"),n("b0c0"),n("7db0");var c=n("6c02"),r=n("ac48"),a=[{path:"/",name:"Layout",component:r["a"],redirect:"/home",children:[{path:"home",name:"Home",component:function(){return n.e("chunk-6777d40a").then(n.bind(null,"bb51"))}}]},{path:"/login",name:"Login",component:function(){return n.e("chunk-97a9cf8c").then(n.bind(null,"a55b"))}},{path:"/register",name:"Register",component:function(){return n.e("chunk-6c65bfa2").then(n.bind(null,"73cf"))}}],o=Object(c["a"])({history:Object(c["b"])("/"),routes:a});function u(){var e=sessionStorage.getItem("userPermission");if(e){var t=JSON.parse(e),c={path:"/",name:"Layout",component:r["a"],redirect:"/home",children:[]};t.forEach((function(e){var t={path:e.path,name:e.name,component:function(){return n("9dac")("./"+e.name)}};c.children.push(t)})),o&&o.addRoute(c)}}u(),o.beforeEach((function(e,t,n){if("/login"!==e.path&&"/register"!==e.path){var c=sessionStorage.getItem("userPermission")?JSON.parse(sessionStorage.getItem("userPermission")):{};c&&c.length&&c.find((function(t){return t.path===e.path}))?n():n("/login")}else n()})),t["a"]=o},ac48:function(e,t,n){"use strict";var c=n("7a23"),r={style:{display:"flex"}};function a(e,t,n,a,o,u){var i=Object(c["S"])("Header"),s=Object(c["S"])("Aside"),l=Object(c["S"])("router-view");return Object(c["J"])(),Object(c["m"])("div",null,[Object(c["q"])(i,{user:o.user},null,8,["user"]),Object(c["n"])("div",r,[Object(c["q"])(s),Object(c["q"])(l,{style:{flex:"1"}})])])}var o={style:{height:"70px","line-height":"50px","border-bottom":"1px solid #ccc",display:"flex"}},u={style:{display:"flex"}},i=Object(c["n"])("div",{style:{width:"200px","padding-left":"10px","font-weight":"bold",color:"#545c64","font-size":"20px","margin-top":"10px"}},"论文管理平台",-1),s=Object(c["n"])("div",{style:{flex:"1"}},null,-1),l=Object(c["p"])("评论"),f=Object(c["p"])("消息"),b={style:{width:"100px"}},d={class:"el-dropdown-link"},h=Object(c["n"])("i",{class:"el-icon-arrow-down el-icon--right"},null,-1),p=Object(c["p"])("修改信息"),m=Object(c["p"])("退出系统");function O(e,t,n,r,a,O){var j=this,v=Object(c["S"])("sunrise"),g=Object(c["S"])("el-icon"),k=Object(c["S"])("el-button"),y=Object(c["S"])("el-badge"),S=Object(c["S"])("el-avatar"),x=Object(c["S"])("el-dropdown-item"),w=Object(c["S"])("el-dropdown-menu"),_=Object(c["S"])("el-dropdown");return Object(c["J"])(),Object(c["m"])("div",o,[Object(c["n"])("div",u,[Object(c["n"])("div",null,[Object(c["q"])(g,{size:40,style:{color:"#545c64","margin-left":"10px","margin-top":"14px"}},{default:Object(c["ib"])((function(){return[Object(c["q"])(v)]})),_:1})]),i]),s,Object(c["n"])("div",null,[Object(c["q"])(y,{class:"item"},{default:Object(c["ib"])((function(){return[Object(c["q"])(k,{size:"small"},{default:Object(c["ib"])((function(){return[l]})),_:1})]})),_:1}),Object(c["q"])(y,{class:"item"},{default:Object(c["ib"])((function(){return[Object(c["q"])(k,{size:"small"},{default:Object(c["ib"])((function(){return[f]})),_:1})]})),_:1})]),Object(c["n"])("div",b,[Object(c["q"])(_,{style:{"margin-top":"10px"}},{dropdown:Object(c["ib"])((function(){return[Object(c["q"])(w,null,{default:Object(c["ib"])((function(){return[Object(c["q"])(x,{onClick:t[0]||(t[0]=function(t){return e.$router.push("/changeProfile")})},{default:Object(c["ib"])((function(){return[p]})),_:1}),Object(c["q"])(x,{onClick:O.loginOut},{default:Object(c["ib"])((function(){return[m]})),_:1},8,["onClick"])]})),_:1})]})),default:Object(c["ib"])((function(){return[Object(c["n"])("span",d,[Object(c["q"])(S,{size:30,src:a.circleUrl,style:{position:"relative",top:"10px"}},null,8,["src"]),Object(c["p"])(" "+Object(c["W"])(j.theName)+" ",1),h])]})),_:1})])])}var j=n("8600"),v={name:"Header",props:["user"],data:function(){return{circleUrl:"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",theName:""}},created:function(){var e=sessionStorage.getItem("user")||"{}";this.theName=JSON.parse(e).userName},components:{Sunrise:j["a"]},methods:{loginOut:function(){sessionStorage.removeItem("user"),sessionStorage.removeItem("userPermission"),this.$router.push("/login")}}};n("46dd");v.render=O;var g=v;n("b0c0");function k(e,t,n,r,a,o){var u=Object(c["S"])("el-menu-item"),i=Object(c["S"])("el-menu");return Object(c["J"])(),Object(c["m"])("div",null,[Object(c["q"])(i,{style:{width:"220px","min-height":"calc(100vh - 50px)",height:"100%"},"default-active":e.$route.path,"background-color":"#545c64","text-color":"#fff","active-text-color":"#ffd04b",router:""},{default:Object(c["ib"])((function(){return[(Object(c["J"])(!0),Object(c["m"])(c["b"],null,Object(c["Q"])(a.permissionList,(function(e){return Object(c["J"])(),Object(c["m"])("div",{key:e.permission_id},["ChangeProfile"!==e.name&&"PaperList"!==e.name&&"Detail"!==e.name?(Object(c["J"])(),Object(c["k"])(u,{key:0,index:e.path},{default:Object(c["ib"])((function(){return[Object(c["n"])("i",{class:Object(c["z"])(e.icon)},null,2),Object(c["p"])(" "+Object(c["W"])(e.comment),1)]})),_:2},1032,["index"])):Object(c["l"])("",!0)])})),128))]})),_:1},8,["default-active"])])}n("b775");var y={name:"Aside",data:function(){return{user:{},permissionList:{},data:{}}},created:function(){var e=sessionStorage.getItem("userPermission")||"{}";this.permissionList=JSON.parse(e)}};y.render=k;var S=y,x=n("a18c"),w={name:"Layout",components:{Header:g,Aside:S},data:function(){return{user:{}}},created:function(){this.refreshUser()},methods:{refreshUser:function(){var e=sessionStorage.getItem("user");e||x["a"].push("/login")}}};w.render=a;t["a"]=w},aede:function(e,t,n){},b443:function(e,t,n){},b775:function(e,t,n){"use strict";n("caad"),n("d3b7");var c=n("bc3a"),r=n.n(c),a=n("a18c"),o={baseUrl:{dev:"/api/",pro:""}},u=(o.baseUrl.pro,r.a.create({timeout:1e4})),i=["/api/login","/api/register","/api/register/sendemail"];u.interceptors.request.use((function(e){console.log("拦截器1");var t=sessionStorage.getItem("user");if(!i.includes(e.url))if(t){var n=JSON.parse(t);e.headers["token"]=n.token}else a["a"].push("/login");return e}),(function(e){return Promise.reject(e)})),u.interceptors.response.use((function(e){var t=e.data;return"blob"===e.config.responseType||("string"===typeof t&&(t=t?JSON.parse(t):t),"401"===t.code&&(console.error("token过期，重新登录"),a["a"].push("/login"))),t}),(function(e){return console.log("err"+e),Promise.reject(e)}));t["a"]=u},c49f:function(e,t,n){"use strict";n("b443")},d7b4:function(e,t,n){}});
//# sourceMappingURL=app.5df6daed.js.map