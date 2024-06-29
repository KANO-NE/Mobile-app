<template>
	<view>
		<view style="">
			<view style="padding: 40rpx 0rpx;font-size: 32rpx;background-color:#00aaff;text-align: center;color: #FFFFFF;">
				<view v-if="user.id" style="background-color: #FFFFFF;color: #00aaff;width: 30%;border-radius: 20rpx;margin-left: 65%;"  @click="goPage('/pages/addactivity/addactivity')">+ 创建活动</view>
			</view>
		</view>
		
		<view>
			<view class="box" style="margin: 30rpx 30rpx;" v-for="item in ActivityData" :key="item" @click="goActivityDetail(item.id)" >
				<view style="font-weight: 700;font-size: 35rpx;margin-bottom: 20rpx;">活动名称：{{item.name}}</view>
				<view style="margin-bottom: 20rpx;font-weight: 400;">
					<span style="color: #00aaff;">{{item.num}}</span>
					<span style="margin-left: 10rpx;">人参与讨论 </span> 
					<span style="margin: 0rpx 20rpx;">发布人：{{item.userName}}</span>
				</view>
				<view>发布时间：{{item.time}}</view>
				
			</view>
			
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:uni.getStorageSync('xm-user'),
				ActivityData:[],
			}
		},
		onShow() {
			this.loadActivity()

		},
		methods: {
			
			//获取话题
			loadActivity(){
				  this.$request.get('/activity/selectAll').then(res => {
					if (res.code === '200'){
					  this.ActivityData = res.data
					}else{
					  this.$message.error(res.msg)
					}
				  })
				},
			goActivityDetail(ActivityId){
				if(this.user.id){
					let params = {
						//设置参数
						contentId : ActivityId, 
						userId : this.user.id,//获取用户的ID
						plate:2
						}
						this.$request.post('/historyrecord/add',params).then(res =>{
							if (res.code === '200') {
									uni.showToast({
										icon: 'success',
										title: '查看成功'
									})
								} else {
									uni.showToast({
										icon: 'none',
										title: res.msg
									})
								}
						}) //
				}
				//后跳转页面
				uni.navigateTo({
					url:'/pages/activitydetail/activitydetail?ActivityId='+ ActivityId
				})
			},
			//跳转
			goPage(url){
				uni.navigateTo({
					url : url
				})
			},
			
		}
	}
</script>

<style>

</style>
