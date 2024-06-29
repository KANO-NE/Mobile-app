"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[698],{8698:function(e,t,a){a.r(t),a.d(t,{default:function(){return c}});var l=function(){var e=this,t=e._self._c;return t("div",[t("div",{staticClass:"search"},[t("el-input",{staticStyle:{width:"200px"},attrs:{placeholder:"请输入关键字查询"},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}}),t("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"info",plain:""},on:{click:function(t){return e.load(1)}}},[e._v("查询")]),t("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"warning",plain:""},on:{click:e.reset}},[e._v("重置")])],1),t("div",{staticClass:"operation"},[t("el-button",{attrs:{type:"primary",plain:""},on:{click:e.handleAdd}},[e._v("新增")]),t("el-button",{attrs:{type:"danger",plain:""},on:{click:e.delBatch}},[e._v("批量删除")])],1),t("div",{staticClass:"table"},[t("el-table",{attrs:{data:e.tableData,strip:""},on:{"selection-change":e.handleSelectionChange}},[t("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),t("el-table-column",{attrs:{prop:"id",label:"序号",width:"70",align:"center",sortable:""}}),t("el-table-column",{attrs:{prop:"title",label:"标题"}}),t("el-table-column",{attrs:{label:"图片"},scopedSlots:e._u([{key:"default",fn:function(a){return[t("div",{staticStyle:{display:"flex","align-items":"center"}},[a.row.img?t("el-image",{staticStyle:{width:"40px",height:"40px","border-radius":"50%"},attrs:{src:a.row.img,"preview-src-list":[a.row.img]}}):e._e()],1)]}}])}),t("el-table-column",{attrs:{prop:"url",label:"跳转地址"}}),t("el-table-column",{attrs:{prop:"username",label:"发布者"}}),t("el-table-column",{attrs:{prop:"time",label:"发布时间"}}),t("el-table-column",{attrs:{label:"操作",align:"center",width:"180"},scopedSlots:e._u([{key:"default",fn:function(a){return[t("el-button",{attrs:{size:"mini",type:"primary",plain:""},on:{click:function(t){return e.handleEdit(a.row)}}},[e._v("编辑")]),t("el-button",{attrs:{size:"mini",type:"danger",plain:""},on:{click:function(t){return e.del(a.row.id)}}},[e._v("删除")])]}}])})],1),t("div",{staticClass:"pagination"},[t("el-pagination",{attrs:{background:"","current-page":e.pageNum,"page-sizes":[5,10,20],"page-size":e.pageSize,layout:"total, prev, pager, next",total:e.total},on:{"current-change":e.handleCurrentChange}})],1)],1),t("el-dialog",{attrs:{title:"海报",visible:e.fromVisible,width:"40%","close-on-click-modal":!1,"destroy-on-close":""},on:{"update:visible":function(t){e.fromVisible=t}}},[t("el-form",{ref:"formRef",staticStyle:{"padding-right":"50px"},attrs:{model:e.form,"label-width":"100px",rules:e.rules}},[t("el-form-item",{attrs:{label:"标题",prop:"title"}},[t("el-input",{attrs:{placeholder:"标题"},model:{value:e.form.title,callback:function(t){e.$set(e.form,"title",t)},expression:"form.title"}})],1),t("el-form-item",{attrs:{label:"图片地址"}},[t("el-upload",{staticClass:"avatar-uploader",attrs:{action:e.$baseUrl+"/files/upload",headers:{token:e.user.token},"list-type":"picture","on-success":e.handleAvatarSuccess}},[t("el-button",{attrs:{type:"primary"}},[e._v("上传图片")])],1)],1),t("el-form-item",{attrs:{label:"跳转地址",prop:"url"}},[t("el-input",{attrs:{placeholder:"跳转地址"},model:{value:e.form.url,callback:function(t){e.$set(e.form,"url",t)},expression:"form.url"}})],1),t("el-form-item",{attrs:{label:"发布者",prop:"username"}},[t("el-input",{attrs:{placeholder:"发布者"},model:{value:e.form.username,callback:function(t){e.$set(e.form,"username",t)},expression:"form.username"}})],1),t("el-form-item",{attrs:{label:"发布时间",prop:"time"}},[t("el-input",{attrs:{placeholder:"发布时间"},model:{value:e.form.time,callback:function(t){e.$set(e.form,"time",t)},expression:"form.time"}})],1)],1),t("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(t){e.fromVisible=!1}}},[e._v("取 消")]),t("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("确 定")])],1)],1)],1)},s=[],r={name:"Banner",data(){return{tableData:[],pageNum:1,pageSize:10,total:0,name:null,fromVisible:!1,form:{},user:JSON.parse(localStorage.getItem("xm-user")||"{}"),rules:{},ids:[]}},created(){this.load(1)},methods:{handleAdd(){this.form={},this.fromVisible=!0},handleEdit(e){this.form=JSON.parse(JSON.stringify(e)),this.fromVisible=!0},save(){this.$refs.formRef.validate((e=>{e&&this.$request({url:this.form.id?"/banner/update":"/banner/add",method:this.form.id?"PUT":"POST",data:this.form}).then((e=>{"200"===e.code?(this.$message.success("保存成功"),this.load(1),this.fromVisible=!1):this.$message.error(e.msg)}))}))},del(e){this.$confirm("您确定删除吗？","确认删除",{type:"warning"}).then((t=>{this.$request.delete("/banner/delete/"+e).then((e=>{"200"===e.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(e.msg)}))})).catch((()=>{}))},handleSelectionChange(e){this.ids=e.map((e=>e.id))},delBatch(){this.ids.length?this.$confirm("您确定批量删除这些数据吗？","确认删除",{type:"warning"}).then((e=>{this.$request.delete("/banner/delete/batch",{data:this.ids}).then((e=>{"200"===e.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(e.msg)}))})).catch((()=>{})):this.$message.warning("请选择数据")},load(e){e&&(this.pageNum=e),this.$request.get("/banner/selectPage",{params:{pageNum:this.pageNum,pageSize:this.pageSize,name:this.name}}).then((e=>{"200"===e.code?(this.tableData=e.data?.list,this.total=e.data?.total):this.$message.error(e.msg)}))},reset(){this.name=null,this.load(1)},handleCurrentChange(e){this.load(e)},handleAvatarSuccess(e,t,a){this.form.img=e.data}}},i=r,n=a(7778),o=(0,n.Z)(i,l,s,!1,null,"e45f1552",null),c=o.exports}}]);
//# sourceMappingURL=698.d6226f50.js.map