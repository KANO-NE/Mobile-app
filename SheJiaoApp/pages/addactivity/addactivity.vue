<template>
	<view>
			<view class="box" style="margin: 20rpx 20rpx;">
				<view style="margin: 20rpx;">
					<uni-forms :modelValue="form" :rules="rules" ref="formRef" label-width="140rpx" label-align="right">
						  
						<uni-forms-item label="活动名称" name="name">
							<uni-easyinput type="text" v-model="form.name" placeholder="请输入活动名称" />
						</uni-forms-item>
						  
						<uni-forms-item label="活动介绍" name="introduce">
						  					<uni-easyinput type="text" v-model="form.introduce" placeholder="请输入活动介绍" />
						</uni-forms-item>
							
						<uni-forms-item label="活动头像" name="img">
							<uni-file-picker limit="1" :image-styles="imageStyles" :del-icon="false" :disable-preview="true" 
								fileMediatype="image" v-model="img"  @select="handleImgUploadSuccess"></uni-file-picker>
						</uni-forms-item>
						<uni-forms-item label="选择类型" name="type">
							<uni-data-select v-model="form.type" :localdata="TypeData"></uni-data-select>
						</uni-forms-item>
						<view>
							<button type="primary" @click="save" class="my-button-primary">创建活动</button>
						</view>
					</uni-forms>
				</view>
			</view>
			
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:uni.getStorageSync('xm-user'),//获取当前用户
				form: {},
				rules: {
				  name: {
				    rules: [{
				      required: true,
				      errorMessage: '请填写名称',
				    }]
				  }
				},
				TypeData: [],  // 类型的数据
				
			}
		},
		onShow() {
			this.loadtypes()
		},
		methods: {
			loadtypes(){
			      this.$request.get('/activitytype/selectAll').then(res => {
			        if (res.code === '200'){
			          this.TypeData = res.data
			        }else{
			          this.$message.error(res.msg)
			        }
			      })
			    },
			handleImgUploadSuccess(e) {
			  let _this = this
			  const filePath = e.tempFilePaths[0]
			  uni.uploadFile({
				url: _this.$baseUrl +'/files/upload', //自己的后端接口（默认发送post请求） 注意 _this.$baseUrl需要在全局变量定义
				filePath: filePath,
				name:"file",  //这里应为自己后端文件形参的名字
				success(res) {
				  let url = JSON.parse(res.data || '{}').data  // 获取返回的图像链接
				  _this.form.img = url    // 给表单图像属性赋值
				}
			  })
			},    
			save(){
				this.form.userId  = this.user.id//获取用户编号
				this.form.type  = this.form.type
				this.form.num  = 0
				
				this.$request.post('/activity/add',this.form).then(res =>{
					if (res.code === '200') {
						//成功后
						uni.showToast({
							icon: 'success',
							title: '活动创建成功'
						})
						
						 uni.reLaunch({
							url: '/pages/activity/activity'
						});
						
					}else {
						uni.showToast({
						icon: 'none',
						title: res.msg
						})
					}
					})
				}
			},	
		}
</script>

<style>

</style>
