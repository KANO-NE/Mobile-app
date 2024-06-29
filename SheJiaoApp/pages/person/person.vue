<template>
	<view style="padding: 20rpx;">
		<view class="box" style="padding: 40rpx 20rpx;">
			<uni-forms :modelValue="form" :rules="rules" ref="formRef" label-width="140rpx" label-align="right">
				<uni-forms-item label="头像" name="img">
					<uni-file-picker limit="1" :image-styles="imageStyles" :del-icon="false" :disable-preview="true" 
						fileMediatype="image" v-model="img"  @select="handleImgUploadSuccess"></uni-file-picker>
				</uni-forms-item>
				<uni-forms-item label="账号" name="username">
					<uni-easyinput type="text" v-model="form.username" placeholder="" disabled />
				</uni-forms-item>
				<!-- <uni-forms-item label="密码" name="password" required>
					<uni-easyinput type="password" v-model="form.password" placeholder="请输入密码" />
				</uni-forms-item> -->
				<uni-forms-item label="姓名" name="name" required>
					<uni-easyinput type="text" v-model="form.name" placeholder="请输入姓名" />
				</uni-forms-item>
				<uni-forms-item label="介绍" name="phone">
					<uni-easyinput type="text" v-model="form.introduce" placeholder="请输入个人简介" />
				</uni-forms-item>
				<uni-forms-item label="性别" name="gender">
					<uni-data-checkbox style="position: relative; top: 10rpx;" v-model="form.gender"
						:localdata="range"></uni-data-checkbox>
				</uni-forms-item>
				<uni-forms-item label="电话" name="phone">
					<uni-easyinput type="text" v-model="form.phone" placeholder="请输入电话" />
				</uni-forms-item>
				<view>
					<button type="primary" @click="save" class="my-button-primary" style="background-color: #00aaff;">保 存</button>
				</view>
			</uni-forms>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
				form: {},
				rules: {
				  password: {
				    rules: [{
				      required: true,
				      errorMessage: '请填写密码',
				    }]
				  },
				  name: {
				    rules: [{
				      required: true,
				      errorMessage: '请填写名称',
				    }]
				  },
				},
				img: [],  
				imageStyles: {
				  "height": 80,	// 边框高度
				  "width": 80,	// 边框宽度
				  "border":{ // 如果为 Boolean 值，可以控制边框显示与否
				    "color":"#eee",		// 边框颜色
				    "width":"1px",		// 边框宽度
				    "style":"solid", 	// 边框样式
				    "radius":"50%" 		// 边框圆角，支持百分比
				  }
				},
				range: [
					{ text: '男', value: '男' },
					{ text: '女', value: '女' },
				]
			}
		},
		onShow() {
			this.form = uni.getStorageSync('xm-user')
			//如果没有值
			if(this.form.img){
				//this.imgs.push({ url: this.form.avatar })
				this.img[0] = { url: this.form.img }
			}
			
		},
		methods: {
			//检测跳转
			checkLogin(){
				let loginValue = uni.getStorageSync("xm-user");
				if (!loginValue) {
					//跳转进入登录页
					uni.reLaunch({
						url: "/pages/login/login",
					})
				} 
			},
			save() {
				//更新
				if(this.form.role == "ADMIN"){
					this.$request.put('/admin/update', this.form).then(res => {
						if (res.code === '200') {
							uni.showToast({
								icon: 'success',
								title: '操作成功',
							})
							
							uni.reLaunch({
								url: '/pages/me/me'
							})
							//更新一个缓存
							uni.setStorageSync('xm-user', this.form)
						} else {
							uni.showToast({
								icon: 'none',
								title: res.msg
							})
						}
					})
				}else{
					this.$request.put('/user/update', this.form).then(res => {
						if (res.code === '200') {
							uni.showToast({
								icon: 'success',
								title: '操作成功',
							})
							
							uni.reLaunch({
								url: '/pages/me/me'
							})
							//更新一个缓存
							uni.setStorageSync('xm-user', this.form)
						} else {
							uni.showToast({
								icon: 'none',
								title: res.msg
							})
						}
					})
				}
				
			},
			handleImgUploadSuccess(e) {
			  let _this = this
			  const filePath = e.tempFilePaths[0]
			  uni.uploadFile({
			    url: _this.$baseUrl +'/files/upload', 
			    filePath: filePath,
			    name:"file",  
			    success(res) {
			      let url = JSON.parse(res.data || '{}').data  // 获取返回的图像链接
			      _this.form.img = url    // 给表单图像属性赋值
			    }
			  })
			},    
		}
	}
</script>

<style>
	
</style>