(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-addtopic-addtopic"],{b1e1:function(t,e,n){"use strict";n.r(e);var i=n("fedf"),r=n("e789");for(var u in r)["default"].indexOf(u)<0&&function(t){n.d(e,t,(function(){return r[t]}))}(u);var a=n("f0c5"),o=Object(a["a"])(r["default"],i["b"],i["c"],!1,null,"f71b4730",null,!1,i["a"],void 0);e["default"]=o.exports},cf4f:function(t,e,n){"use strict";n("7a82"),Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var i={data:function(){return{user:uni.getStorageSync("xm-user"),form:{},rules:{title:{rules:[{required:!0,errorMessage:"请填写话题名称"}]}}}},onShow:function(){},methods:{save:function(){this.form.name=this.user.name,this.form.reply=0,this.form.num=0,this.$request.post("/topic/add",this.form).then((function(t){"200"===t.code?(uni.showToast({icon:"success",title:"活动创建成功"}),uni.reLaunch({url:"/pages/topic/topic"})):uni.showToast({icon:"none",title:t.msg})}))}}};e.default=i},e789:function(t,e,n){"use strict";n.r(e);var i=n("cf4f"),r=n.n(i);for(var u in i)["default"].indexOf(u)<0&&function(t){n.d(e,t,(function(){return i[t]}))}(u);e["default"]=r.a},fedf:function(t,e,n){"use strict";n.d(e,"b",(function(){return r})),n.d(e,"c",(function(){return u})),n.d(e,"a",(function(){return i}));var i={uniForms:n("9625").default,uniFormsItem:n("3423").default,uniEasyinput:n("ce35").default},r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-uni-view",[n("v-uni-view",{staticClass:"box",staticStyle:{margin:"20rpx 20rpx"}},[n("v-uni-view",{staticStyle:{margin:"20rpx"}},[n("uni-forms",{ref:"formRef",attrs:{modelValue:t.form,rules:t.rules,"label-width":"140rpx","label-align":"right"}},[n("uni-forms-item",{attrs:{label:"话题名称",name:"title"}},[n("uni-easyinput",{attrs:{type:"text",placeholder:"请输入话题名称"},model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1),n("v-uni-view",[n("v-uni-button",{staticClass:"my-button-primary",attrs:{type:"primary"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.save.apply(void 0,arguments)}}},[t._v("创建话题")])],1)],1)],1)],1)],1)},u=[]}}]);