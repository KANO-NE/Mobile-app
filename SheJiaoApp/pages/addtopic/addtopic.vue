<template>
	<view>
			<view class="box" style="margin: 20rpx 20rpx;">
				<view style="margin: 20rpx;">
					<uni-forms :modelValue="form" :rules="rules" ref="formRef" label-width="140rpx" label-align="right">
						  
						<uni-forms-item label="话题名称" name="title">
							<uni-easyinput type="text" v-model="form.title" placeholder="请输入话题名称" />
						</uni-forms-item>
						  
						<view>
							<button type="primary" @click="save" class="my-button-primary">创建话题</button>
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
				  title: {
				    rules: [{
				      required: true,
				      errorMessage: '请填写话题名称',
				    }]
				  }
				},
				
				
			}
		},
		onShow() {

		},
		methods: {
 
			save(){
				this.form.name  = this.user.name//获取用户编号
				this.form.reply  = 0
				this.form.num  = 0
				
				this.$request.post('/topic/add',this.form).then(res =>{
					if (res.code === '200') {
						//成功后
						uni.showToast({
							icon: 'success',
							title: '活动创建成功'
						})
						
						 uni.reLaunch({
							url: '/pages/topic/topic'
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
