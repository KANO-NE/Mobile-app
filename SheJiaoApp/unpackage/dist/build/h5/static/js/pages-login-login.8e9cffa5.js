(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-login-login"],{"05e7":function(e,t,i){"use strict";i.d(t,"b",(function(){return n})),i.d(t,"c",(function(){return o})),i.d(t,"a",(function(){return a}));var a={uniForms:i("9625").default,uniFormsItem:i("3423").default,uniEasyinput:i("ce35").default,uniDataSelect:i("2d07").default},n=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("v-uni-view",{staticStyle:{"background-color":"white","min-height":"100vh"}},[i("v-uni-view",{staticStyle:{"text-align":"center",padding:"90rpx 20rpx"}},[i("v-uni-image",{staticStyle:{width:"300rpx",height:"200rpx","border-radius":"30rpx"},attrs:{src:"/static/logo.png",alt:""}})],1),i("v-uni-view",{staticStyle:{margin:"0rpx 60rpx"}},[i("uni-forms",{ref:"formRef",attrs:{modelValue:e.form,rules:e.rules,validateTrigger:"blur"}},[i("uni-forms-item",{attrs:{name:"username"}},[i("uni-easyinput",{attrs:{prefixIcon:"person",placeholder:"请输入账号"},model:{value:e.form.username,callback:function(t){e.$set(e.form,"username",t)},expression:"form.username"}})],1),i("uni-forms-item",{attrs:{name:"password"}},[i("uni-easyinput",{attrs:{type:"password",prefixIcon:"locked",placeholder:"请输入密码"},model:{value:e.form.password,callback:function(t){e.$set(e.form,"password",t)},expression:"form.password"}})],1),i("uni-forms-item",{attrs:{name:"role"}},[i("uni-data-select",{attrs:{localdata:e.roleData,placeholder:"请输入角色登录"},model:{value:e.form.role,callback:function(t){e.$set(e.form,"role",t)},expression:"form.role"}})],1),i("v-uni-view",{staticStyle:{"text-align":"right","font-size":"32rpx","font-weight":"500","margin-bottom":"40rpx",color:"#06CC8A"},on:{click:function(t){arguments[0]=t=e.$handleEvent(t),e.goPage("/pages/register/register")}}},[i("span",[e._v("注册账户")])]),i("uni-forms-item",[i("v-uni-button",{staticStyle:{width:"100%",height:"80rpx","line-height":"70rpx","background-color":"#06CC8A","border-color":"#006eff"},attrs:{type:"primary"},on:{click:function(t){arguments[0]=t=e.$handleEvent(t),e.login.apply(void 0,arguments)}}},[e._v("登 录")])],1)],1)],1)],1)},o=[]},"2d07":function(e,t,i){"use strict";i.r(t);var a=i("b1ff"),n=i("f835");for(var o in n)["default"].indexOf(o)<0&&function(e){i.d(t,e,(function(){return n[e]}))}(o);i("ef81");var r=i("f0c5"),c=Object(r["a"])(n["default"],a["b"],a["c"],!1,null,"daed2cc6",null,!1,a["a"],void 0);t["default"]=c.exports},4941:function(e,t,i){var a=i("984c");a.__esModule&&(a=a.default),"string"===typeof a&&(a=[[e.i,a,""]]),a.locals&&(e.exports=a.locals);var n=i("4f06").default;n("3821b0ca",a,!0,{sourceMap:!1,shadowMode:!1})},"5ae1":function(e,t,i){"use strict";i.r(t);var a=i("c869"),n=i.n(a);for(var o in a)["default"].indexOf(o)<0&&function(e){i.d(t,e,(function(){return a[e]}))}(o);t["default"]=n.a},"7f05":function(e,t,i){"use strict";i.r(t);var a=i("05e7"),n=i("5ae1");for(var o in n)["default"].indexOf(o)<0&&function(e){i.d(t,e,(function(){return n[e]}))}(o);var r=i("f0c5"),c=Object(r["a"])(n["default"],a["b"],a["c"],!1,null,"77b3e386",null,!1,a["a"],void 0);t["default"]=c.exports},"984c":function(e,t,i){var a=i("24fb");t=a(!1),t.push([e.i,'@charset "UTF-8";\r\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\r\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\r\n/* 颜色变量 */\r\n/* 行为相关颜色 */\r\n/* 文字基本颜色 */\r\n/* 背景颜色 */\r\n/* 边框颜色 */\r\n/* 尺寸变量 */\r\n/* 文字尺寸 */\r\n/* 图片尺寸 */\r\n/* Border Radius */\r\n/* 水平间距 */\r\n/* 垂直间距 */\r\n/* 透明度 */\r\n/* 文章场景相关 */@media screen and (max-width:500px){.hide-on-phone[data-v-daed2cc6]{display:none}}.uni-stat__select[data-v-daed2cc6]{display:flex;align-items:center;cursor:pointer;width:100%;flex:1;box-sizing:border-box}.uni-stat-box[data-v-daed2cc6]{width:100%;flex:1}.uni-stat__actived[data-v-daed2cc6]{width:100%;flex:1}.uni-label-text[data-v-daed2cc6]{font-size:14px;font-weight:700;color:#6a6a6a;margin:auto 0;margin-right:5px}.uni-select[data-v-daed2cc6]{font-size:14px;border:1px solid #e5e5e5;box-sizing:border-box;border-radius:4px;padding:0 5px;padding-left:10px;position:relative;display:flex;-webkit-user-select:none;user-select:none;flex-direction:row;align-items:center;border-bottom:solid 1px #e5e5e5;width:100%;flex:1;height:35px}.uni-select--disabled[data-v-daed2cc6]{background-color:#f5f7fa;cursor:not-allowed}.uni-select__label[data-v-daed2cc6]{font-size:16px;height:35px;padding-right:10px;color:#909399}.uni-select__input-box[data-v-daed2cc6]{height:35px;position:relative;display:flex;flex:1;flex-direction:row;align-items:center}.uni-select__input[data-v-daed2cc6]{flex:1;font-size:14px;height:22px;line-height:22px}.uni-select__input-plac[data-v-daed2cc6]{font-size:14px;color:#909399}.uni-select__selector[data-v-daed2cc6]{box-sizing:border-box;position:absolute;top:calc(100% + 12px);left:0;width:100%;background-color:#fff;border:1px solid #ebeef5;border-radius:6px;box-shadow:0 2px 12px 0 rgba(0,0,0,.1);z-index:3;padding:4px 0}.uni-select__selector-scroll[data-v-daed2cc6]{max-height:200px;box-sizing:border-box}@media (min-width:768px){.uni-select__selector-scroll[data-v-daed2cc6]{max-height:600px}}.uni-select__selector-empty[data-v-daed2cc6],\r\n.uni-select__selector-item[data-v-daed2cc6]{display:flex;cursor:pointer;line-height:35px;font-size:14px;text-align:center;\r\n  /* border-bottom: solid 1px $uni-border-3; */padding:0 10px}.uni-select__selector-item[data-v-daed2cc6]:hover{background-color:#f9f9f9}.uni-select__selector-empty[data-v-daed2cc6]:last-child,\r\n.uni-select__selector-item[data-v-daed2cc6]:last-child{border-bottom:none}.uni-select__selector__disabled[data-v-daed2cc6]{opacity:.4;cursor:default}\r\n/* picker 弹出层通用的指示小三角 */.uni-popper__arrow[data-v-daed2cc6],\r\n.uni-popper__arrow[data-v-daed2cc6]::after{position:absolute;display:block;width:0;height:0;border-color:transparent;border-style:solid;border-width:6px}.uni-popper__arrow[data-v-daed2cc6]{-webkit-filter:drop-shadow(0 2px 12px rgba(0,0,0,.03));filter:drop-shadow(0 2px 12px rgba(0,0,0,.03));top:-6px;left:10%;margin-right:3px;border-top-width:0;border-bottom-color:#ebeef5}.uni-popper__arrow[data-v-daed2cc6]::after{content:" ";top:1px;margin-left:-6px;border-top-width:0;border-bottom-color:#fff}.uni-select__input-text[data-v-daed2cc6]{width:100%;color:#333;white-space:nowrap;text-overflow:ellipsis;-o-text-overflow:ellipsis;overflow:hidden}.uni-select__input-placeholder[data-v-daed2cc6]{color:#6a6a6a;font-size:12px}.uni-select--mask[data-v-daed2cc6]{position:fixed;top:0;bottom:0;right:0;left:0;z-index:2}',""]),e.exports=t},b1d8:function(e,t,i){"use strict";(function(e){i("7a82"),Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,i("a9e3"),i("7db0"),i("d3b7"),i("159b"),i("ac1f"),i("5319"),i("4d63"),i("c607"),i("2c3e"),i("25f0"),i("c975"),i("99af");var a={name:"uni-data-select",mixins:[e.mixinDatacom||{}],props:{localdata:{type:Array,default:function(){return[]}},value:{type:[String,Number],default:""},modelValue:{type:[String,Number],default:""},label:{type:String,default:""},placeholder:{type:String,default:"请选择"},emptyTips:{type:String,default:"无选项"},clear:{type:Boolean,default:!0},defItem:{type:Number,default:0},disabled:{type:Boolean,default:!1},format:{type:String,default:""}},data:function(){return{showSelector:!1,current:"",mixinDatacomResData:[],apps:[],channels:[],cacheKey:"uni-data-select-lastSelectedValue"}},created:function(){var e=this;this.debounceGet=this.debounce((function(){e.query()}),300),this.collection&&!this.localdata.length&&this.debounceGet()},computed:{typePlaceholder:function(){var e=this.placeholder,t={"opendb-stat-app-versions":"版本","opendb-app-channels":"渠道","opendb-app-list":"应用"}[this.collection];return t?e+t:e},valueCom:function(){return this.value}},watch:{localdata:{immediate:!0,handler:function(e,t){Array.isArray(e)&&t!==e&&(this.mixinDatacomResData=e)}},valueCom:function(e,t){this.initDefVal()},mixinDatacomResData:{immediate:!0,handler:function(e){e.length&&this.initDefVal()}}},methods:{debounce:function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:100,i=null;return function(){for(var a=this,n=arguments.length,o=new Array(n),r=0;r<n;r++)o[r]=arguments[r];i&&clearTimeout(i),i=setTimeout((function(){e.apply(a,o)}),t)}},query:function(){this.mixinDatacomEasyGet()},onMixinDatacomPropsChange:function(){this.collection&&this.debounceGet()},initDefVal:function(){var e="";if(!this.valueCom&&0!==this.valueCom||this.isDisabled(this.valueCom)){var t;if(this.collection&&(t=this.getCache()),t||0===t)e=t;else{var i="";this.defItem>0&&this.defItem<=this.mixinDatacomResData.length&&(i=this.mixinDatacomResData[this.defItem-1].value),e=i}(e||0===e)&&this.emit(e)}else e=this.valueCom;var a=this.mixinDatacomResData.find((function(t){return t.value===e}));this.current=a?this.formatItemName(a):""},isDisabled:function(e){var t=!1;return this.mixinDatacomResData.forEach((function(i){i.value===e&&(t=i.disable)})),t},clearVal:function(){this.emit(""),this.collection&&this.removeCache()},change:function(e){e.disable||(this.showSelector=!1,this.current=this.formatItemName(e),this.emit(e.value))},emit:function(e){this.$emit("input",e),this.$emit("update:modelValue",e),this.$emit("change",e),this.collection&&this.setCache(e)},toggleSelector:function(){this.disabled||(this.showSelector=!this.showSelector)},formatItemName:function(e){var t=e.text,i=e.value,a=e.channel_code;if(a=a?"(".concat(a,")"):"",this.format){var n="";for(var o in n=this.format,e)n=n.replace(new RegExp("{".concat(o,"}"),"g"),e[o]);return n}return this.collection.indexOf("app-list")>0?"".concat(t,"(").concat(i,")"):t||"未命名".concat(a)},getLoadData:function(){return this.mixinDatacomResData},getCurrentCacheKey:function(){return this.collection},getCache:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:this.getCurrentCacheKey(),t=uni.getStorageSync(this.cacheKey)||{};return t[e]},setCache:function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:this.getCurrentCacheKey(),i=uni.getStorageSync(this.cacheKey)||{};i[t]=e,uni.setStorageSync(this.cacheKey,i)},removeCache:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:this.getCurrentCacheKey(),t=uni.getStorageSync(this.cacheKey)||{};delete t[e],uni.setStorageSync(this.cacheKey,t)}}};t.default=a}).call(this,i("a9ff")["default"])},b1ff:function(e,t,i){"use strict";i.d(t,"b",(function(){return n})),i.d(t,"c",(function(){return o})),i.d(t,"a",(function(){return a}));var a={uniIcons:i("e273").default},n=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("v-uni-view",{staticClass:"uni-stat__select"},[e.label?i("span",{staticClass:"uni-label-text hide-on-phone"},[e._v(e._s(e.label+"："))]):e._e(),i("v-uni-view",{staticClass:"uni-stat-box",class:{"uni-stat__actived":e.current}},[i("v-uni-view",{staticClass:"uni-select",class:{"uni-select--disabled":e.disabled}},[i("v-uni-view",{staticClass:"uni-select__input-box",on:{click:function(t){arguments[0]=t=e.$handleEvent(t),e.toggleSelector.apply(void 0,arguments)}}},[e.current?i("v-uni-view",{staticClass:"uni-select__input-text"},[e._v(e._s(e.current))]):i("v-uni-view",{staticClass:"uni-select__input-text uni-select__input-placeholder"},[e._v(e._s(e.typePlaceholder))]),e.current&&e.clear&&!e.disabled?i("v-uni-view",{on:{click:function(t){t.stopPropagation(),arguments[0]=t=e.$handleEvent(t),e.clearVal.apply(void 0,arguments)}}},[i("uni-icons",{attrs:{type:"clear",color:"#c0c4cc",size:"24"}})],1):i("v-uni-view",[i("uni-icons",{attrs:{type:e.showSelector?"top":"bottom",size:"14",color:"#999"}})],1)],1),e.showSelector?i("v-uni-view",{staticClass:"uni-select--mask",on:{click:function(t){arguments[0]=t=e.$handleEvent(t),e.toggleSelector.apply(void 0,arguments)}}}):e._e(),e.showSelector?i("v-uni-view",{staticClass:"uni-select__selector"},[i("v-uni-view",{staticClass:"uni-popper__arrow"}),i("v-uni-scroll-view",{staticClass:"uni-select__selector-scroll",attrs:{"scroll-y":"true"}},[0===e.mixinDatacomResData.length?i("v-uni-view",{staticClass:"uni-select__selector-empty"},[i("v-uni-text",[e._v(e._s(e.emptyTips))])],1):e._l(e.mixinDatacomResData,(function(t,a){return i("v-uni-view",{key:a,staticClass:"uni-select__selector-item",on:{click:function(i){arguments[0]=i=e.$handleEvent(i),e.change(t)}}},[i("v-uni-text",{class:{"uni-select__selector__disabled":t.disable}},[e._v(e._s(e.formatItemName(t)))])],1)}))],2)],1):e._e()],1)],1)],1)},o=[]},c869:function(e,t,i){"use strict";i("7a82"),Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,i("ac1f"),i("5319"),i("d401"),i("d3b7"),i("25f0");var a={data:function(){return{form:{role:"USER"},rules:{username:{rules:[{required:!0,errorMessage:"请输入账号"}]},password:{rules:[{required:!0,errorMessage:"请输入密码"}]}},roleData:[{value:"USER",text:"用户"}]}},mounted:function(){},methods:{login:function(){var e=this;this.form.key=this.uuid,this.$refs.formRef.validate().then((function(t){e.$request.post("/login",e.form).then((function(e){"200"===e.code?(uni.setStorageSync("xm-user",e.data),uni.showToast({icon:"success",title:"登录成功"}),setTimeout((function(){uni.reLaunch({url:"/pages/me/me"})}),500)):uni.showToast({icon:"none",title:e.msg})}))})).catch((function(e){console.log("err",e)}))},goPage:function(e){uni.navigateTo({url:e})}}};t.default=a},ef81:function(e,t,i){"use strict";var a=i("4941"),n=i.n(a);n.a},f835:function(e,t,i){"use strict";i.r(t);var a=i("b1d8"),n=i.n(a);for(var o in a)["default"].indexOf(o)<0&&function(e){i.d(t,e,(function(){return a[e]}))}(o);t["default"]=n.a}}]);