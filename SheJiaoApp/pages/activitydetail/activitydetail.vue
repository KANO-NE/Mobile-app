<template>
	<view style="background-image: linear-gradient(to bottom, #00aaff, #ffffff);min-height: 100vh;">
		<view style="">
			<view style="padding: 60rpx 0rpx;font-size: 32rpx;font-weight: 700;text-align: center;color: #FFFFFF;">{{activityData.name}}</view>
		</view>
		<view class="box" style="margin: 0rpx 30rpx;">
			<view style="display: flex;">
				<view style="flex: 1;">
					<img style="height: 200rpx;width: 200rpx;" :src="activityData.img || 'http://localhost:9090/files/default.png'" alt="">
				</view>
				<view style="flex: 3;margin-left: 20rpx;">
					<view><span style="font-weight: 700;font-size: 32rpx;">活动发起人：</span>{{activityData.userName}}</view>
					<view style="margin-top: 10rpx;"><span style="font-weight: 700;font-size: 32rpx;">活动编号：</span>{{activityData.id}}</view>
				</view>
				
			</view>
			<view style="margin-top: 10rpx;overflow: hidden;text-overflow: ellipsis; display: -webkit-box; -webkit-line-clamp: 2;-webkit-box-orient: vertical;"><span style="font-weight: 700;">活动简介：</span>{{activityData.introduce}}</view>
			<view style="margin: 20rpx 0rpx;"><span style="font-weight: 700;">活动时间：</span>{{activityData.time}}</view>
			<view><span style="font-weight: 700;">活动人数：</span>{{activityData.num}}</view>
			
		</view>
		<view class="box" style="margin: 20rpx 30rpx;">
			<view style="font-weight: 700;font-size: 28rpx;">活动成员：</view>
			
			
			<view style="display: flex;" >
			
				
				<view style="flex: 1;" v-for="item in activitymember" :key="item.id">
					<view style="margin-top: 10rpx;">
						<img style="height: 100rpx;width: 100rpx;border-radius: 20rpx;" :src="item.userImg || 'http://localhost:9090/files/default_img.png'" alt="">
					</view>
					<view>{{item.userName}}</view>
					
				</view>
				
			</view>
			
			
			
		</view>
		<view style="margin: 30rpx;">
			<uni-forms-item>
				<button @click="addActivity" type="primary" style="width: 100%; height: 80rpx; line-height: 70rpx; background-color: #00aaff; border-color: #006eff;">加 入</button>
			</uni-forms-item>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:uni.getStorageSync('xm-user'),//获取当前用户
				activityData:[],
				activitymember:{},
			}
		},
		onLoad(option) {
			const ActivityId = option.ActivityId
			this.load(ActivityId)
			this.loadActivityMember(ActivityId)
		},
		methods: {
			loadActivityMember(ActivityId){
				this.$request.get('/activityrecords/selectByActivityId?id='+ ActivityId).then(res =>{
					this.activitymember = res.data || {}
				})
			},
			load(ActivityId){
				this.$request.get('/activity/selectById?id='+ ActivityId).then(res =>{
					this.activityData = res.data || {}
				})
			},
			addActivity(){
				if(!this.user.id){
				  uni.showToast({
						icon: 'none',
						title: '请登录后加入！'
				  })
				}else{
				var activityId = this.activityData.id
				let params = {
					//设置参数
					activityId : this.activityData.id, //获取活动编号
					userId : this.user.id,//获取用户编号
					}
					this.$request.post('/activityrecords/add',params).then(res =>{
						if (res.code === '200') {
								uni.showToast({
									icon: 'success',
									title: '操作成功'
								})
								console.log(activityId)
								 uni.reLaunch({
									  url: '/pages/activitydetail/activitydetail?ActivityId='+ activityId
									});
								//this.load(topicId)
							} else {
								uni.showToast({
									icon: 'none',
									title: res.msg
								})
							}
					})
				}
				
			},
		}
	}
</script>

<style>

</style>
