<template>
	<view>
		<view style="text-align: center;font-size: 32rpx;margin: 20rpx 20rpx;">我的收藏</view>
		<view class="box" style="margin: 20rpx;" v-for="item in collectData" :key="item" @click="goTopicDetail(item.topicId)">
			<view style="margin: 10rpx 10rpx;">收藏话题：{{item.topicTitle}}</view>
			<view style="margin: 10rpx 10rpx;">收藏时间：{{item.time}}</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:uni.getStorageSync('xm-user'),//获取当前用户
				collectData:{},//活动数据
			}
		},
		onLoad() {
			this.loadCollect()
		},
		methods: {
			//搜索该用户的收藏
			loadCollect(){
				this.$request.get('/collect/selectByUserId?id='+ this.user.id).then(res =>{
					this.collectData = res.data || {}
				})
			},
			goTopicDetail(TopicId){
				uni.navigateTo({
					url:'/pages/topicdetail/topicdetail?TopicId='+ TopicId
				})
				
			},
		}
	}
</script>

<style>

</style>
