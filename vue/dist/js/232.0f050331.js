"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[232],{2232:function(t,e,a){a.r(e),a.d(e,{default:function(){return c}});var i=function(){var t=this,e=t._self._c;return e("div",[e("div",{staticClass:"search"},[e("el-input",{staticStyle:{width:"200px"},attrs:{placeholder:"请输入关键字查询"},model:{value:t.name,callback:function(e){t.name=e},expression:"name"}}),e("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"info",plain:""},on:{click:function(e){return t.load(1)}}},[t._v("查询")]),e("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"warning",plain:""},on:{click:t.reset}},[t._v("重置")])],1),e("div",{staticClass:"operation"},[e("el-button",{attrs:{type:"primary",plain:""},on:{click:t.handleAdd}},[t._v("新增")]),e("el-button",{attrs:{type:"danger",plain:""},on:{click:t.delBatch}},[t._v("批量删除")])],1),e("div",{staticClass:"table"},[e("el-table",{attrs:{data:t.tableData,strip:""},on:{"selection-change":t.handleSelectionChange}},[e("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),e("el-table-column",{attrs:{prop:"id",label:"序号",width:"70",align:"center",sortable:""}}),e("el-table-column",{attrs:{prop:"value",label:"数值"}}),e("el-table-column",{attrs:{prop:"text",label:"文本"}}),e("el-table-column",{attrs:{label:"操作",align:"center",width:"180"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-button",{attrs:{size:"mini",type:"primary",plain:""},on:{click:function(e){return t.handleEdit(a.row)}}},[t._v("编辑")]),e("el-button",{attrs:{size:"mini",type:"danger",plain:""},on:{click:function(e){return t.del(a.row.id)}}},[t._v("删除")])]}}])})],1),e("div",{staticClass:"pagination"},[e("el-pagination",{attrs:{background:"","current-page":t.pageNum,"page-sizes":[5,10,20],"page-size":t.pageSize,layout:"total, prev, pager, next",total:t.total},on:{"current-change":t.handleCurrentChange}})],1)],1),e("el-dialog",{attrs:{title:"活动类型",visible:t.fromVisible,width:"40%","close-on-click-modal":!1,"destroy-on-close":""},on:{"update:visible":function(e){t.fromVisible=e}}},[e("el-form",{ref:"formRef",staticStyle:{"padding-right":"50px"},attrs:{model:t.form,"label-width":"100px",rules:t.rules}},[e("el-form-item",{attrs:{label:"数值",prop:"value"}},[e("el-input",{attrs:{placeholder:"数值"},model:{value:t.form.value,callback:function(e){t.$set(t.form,"value",e)},expression:"form.value"}})],1),e("el-form-item",{attrs:{label:"文本",prop:"text"}},[e("el-input",{attrs:{placeholder:"文本"},model:{value:t.form.text,callback:function(e){t.$set(t.form,"text",e)},expression:"form.text"}})],1)],1),e("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(e){t.fromVisible=!1}}},[t._v("取 消")]),e("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("确 定")])],1)],1)],1)},l=[],s={name:"Activitytype",data(){return{tableData:[],pageNum:1,pageSize:10,total:0,name:null,fromVisible:!1,form:{},user:JSON.parse(localStorage.getItem("xm-user")||"{}"),rules:{},ids:[]}},created(){this.load(1)},methods:{handleAdd(){this.form={},this.fromVisible=!0},handleEdit(t){this.form=JSON.parse(JSON.stringify(t)),this.fromVisible=!0},save(){this.$refs.formRef.validate((t=>{t&&this.$request({url:this.form.id?"/activitytype/update":"/activitytype/add",method:this.form.id?"PUT":"POST",data:this.form}).then((t=>{"200"===t.code?(this.$message.success("保存成功"),this.load(1),this.fromVisible=!1):this.$message.error(t.msg)}))}))},del(t){this.$confirm("您确定删除吗？","确认删除",{type:"warning"}).then((e=>{this.$request.delete("/activitytype/delete/"+t).then((t=>{"200"===t.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(t.msg)}))})).catch((()=>{}))},handleSelectionChange(t){this.ids=t.map((t=>t.id))},delBatch(){this.ids.length?this.$confirm("您确定批量删除这些数据吗？","确认删除",{type:"warning"}).then((t=>{this.$request.delete("/activitytype/delete/batch",{data:this.ids}).then((t=>{"200"===t.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(t.msg)}))})).catch((()=>{})):this.$message.warning("请选择数据")},load(t){t&&(this.pageNum=t),this.$request.get("/activitytype/selectPage",{params:{pageNum:this.pageNum,pageSize:this.pageSize,name:this.name}}).then((t=>{"200"===t.code?(this.tableData=t.data?.list,this.total=t.data?.total):this.$message.error(t.msg)}))},reset(){this.name=null,this.load(1)},handleCurrentChange(t){this.load(t)}}},r=s,n=a(7778),o=(0,n.Z)(r,i,l,!1,null,"2c085b40",null),c=o.exports}}]);
//# sourceMappingURL=232.0f050331.js.map