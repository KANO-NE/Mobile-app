<template>
	<view>
		<view style="text-align: center;font-size: 32rpx;margin: 20rpx 20rpx;">参加的活动</view>
		<view class="box" style="margin: 20rpx;" v-for="item in activityData" :key="item.id">
			<view style="display: flex;" @click="goActivityShow(item.activityId,item.id)">
				<view style="flex: 1;">
					<img style="height: 100rpx;width: 100rpx;;" :src="item.activityImg" alt="" />
				</view>
				<view style="flex: 9;margin-left: 20rpx;font-size: 32rpx;font-weight: 700;">
					{{item.activityName}}
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:uni.getStorageSync('xm-user'),//获取当前用户
				activityData:{},//活动数据
			}
		},
		onLoad() {
			this.loadCollect()
		},
		methods: {
			//搜索该用户的活动
			loadCollect(){
				this.$request.get('/activityrecords/selectByUserId?id='+ this.user.id).then(res =>{
					this.activityData = res.data || {}
				})
			},
			goActivityShow(ActivityId,ActivityRecordsId){
				uni.navigateTo({
					url:'/pages/activityshow/activityshow?ActivityId='+ ActivityId +'&ActivityRecordsId=' +ActivityRecordsId
					
				});
			},
		}
	}
</script>

<style>

</style>
