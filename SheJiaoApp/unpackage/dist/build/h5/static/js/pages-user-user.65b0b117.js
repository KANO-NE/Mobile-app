(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-user-user"],{"0e409":function(t,i,e){"use strict";e.d(i,"b",(function(){return n})),e.d(i,"c",(function(){return a})),e.d(i,"a",(function(){}));var n=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("v-uni-view",[e("v-uni-view",{staticClass:"box",staticStyle:{margin:"20rpx 20rpx"}},[e("v-uni-view",{staticStyle:{display:"flex"}},[e("v-uni-view",{staticStyle:{flex:"2"}},[e("img",{staticStyle:{height:"150rpx",width:"150rpx"},attrs:{src:t.UserData.img,alt:""}})]),e("v-uni-view",{staticStyle:{flex:"8"}},[e("v-uni-view",{staticStyle:{"font-size":"32rpx","font-weight":"700","margin-left":"20rpx"}},[t._v("用户名称："+t._s(t.UserData.username))]),e("v-uni-view",{staticStyle:{"font-size":"28rpx",margin:"10rpx 20rpx"}},[t._v("用户介绍："+t._s(t.UserData.introduce))])],1)],1)],1),e("v-uni-view",{staticClass:"box",staticStyle:{margin:"20rpx"}},[e("v-uni-button",{on:{click:function(i){arguments[0]=i=t.$handleEvent(i),t.collect(t.UserData.id)}}},[t._v("关注他")])],1),e("v-uni-view",{staticClass:"box",staticStyle:{margin:"20rpx"}},[t._v("该用户参加过的话题")]),t._l(t.topicData,(function(i){return e("v-uni-view",{key:i.id,staticClass:"box",staticStyle:{margin:"20rpx"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.goTopicDetail(i.id)}}},[t._v("话题标题："+t._s(i.title))])}))],2)},a=[]},"167d":function(t,i,e){"use strict";e.r(i);var n=e("0e409"),a=e("c5a5");for(var s in a)["default"].indexOf(s)<0&&function(t){e.d(i,t,(function(){return a[t]}))}(s);var o=e("f0c5"),c=Object(o["a"])(a["default"],n["b"],n["c"],!1,null,"dba24534",null,!1,n["a"],void 0);i["default"]=c.exports},"7ab4":function(t,i,e){"use strict";e("7a82"),Object.defineProperty(i,"__esModule",{value:!0}),i.default=void 0;var n={data:function(){return{user:uni.getStorageSync("xm-user"),UserData:[],topicData:[]}},onLoad:function(t){var i=t.UserId;this.load(i),console.log(i),this.loadTopic()},methods:{collect:function(){if(this.user.id!==this.UserData.id)if(this.user.id){var t={userId:this.user.id,targetId:this.UserData.id};this.$request.post("/usercollect/add",t).then((function(t){"200"===t.code?uni.showToast({icon:"success",title:"收藏成功"}):uni.showToast({icon:"none",title:t.msg})}))}else uni.showToast({icon:"none",title:"请登录后收藏！"});else uni.showToast({icon:"none",title:"您不能关注自己！"})},load:function(t){var i=this;this.$request.get("/user/selectById?id="+t).then((function(t){i.UserData=t.data||{}}))},loadTopic:function(){var t=this;this.$request.get("/topic/selectByUserName?name="+this.user.name).then((function(i){t.topicData=i.data||{}}))},goTopicDetail:function(t){uni.navigateTo({url:"/pages/topicdetail/topicdetail?TopicId="+t})}}};i.default=n},c5a5:function(t,i,e){"use strict";e.r(i);var n=e("7ab4"),a=e.n(n);for(var s in n)["default"].indexOf(s)<0&&function(t){e.d(i,t,(function(){return n[t]}))}(s);i["default"]=a.a}}]);