<template>
	<view>
		<view style="margin-bottom: 20rpx;">
		 <uni-segmented-control :current="current" :values="items" @clickItem="onClickItem" styleType="text"
		    activeColor="#00aaff"></uni-segmented-control>
		</view>
		
		<view v-for="item in DataList" :key="item.id" class="box" style="margin: 20rpx;">
			<view >
				<view v-if="item.topicId !== null" style="margin-top: 20rpx;" @click="goTopicDetail(item.contentId)">话题标题：{{item.topicTitle}}</view>
				<view v-if="item.activityId !== null" style="margin-top: 20rpx;" @click="goActivityDetail(item.contentId)">活动名称：{{item.activityName}}</view>
				<view style="margin: 20rpx 0rpx;">浏览时间：{{item.time}}</view>
			</view>
			
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user: uni.getStorageSync('xm-user'),
				items: ['话题', '活动'],
				current: '话题',
				DataList: [],
			}
		},
		onShow() {
			this.load()
		},
		methods: {
			onClickItem(e) { // 点击菜单的时候触发
				this.current = this.items[e.currentIndex]
				this.load()
				console.log(this.current)
			},
			load() {
				let params = {
					userId: this.user.id
				}
				if (this.current == '话题') {
					params.plate = 1
					//userId: this.user.id
					this.$request.get('/historyrecord/selectUserTopic', params).then(res => {
						this.DataList = res.data || []
					})
				}else{
					params.plate = 2
					this.$request.get('/historyrecord/selectUserActivity', params).then(res => {
						this.DataList = res.data || []
					})
				}
			},
			goTopicDetail(TopicId){
				uni.navigateTo({
					url:'/pages/topicdetail/topicdetail?TopicId='+ TopicId
				})
				
			},
			goActivityDetail(ActivityId){
				uni.navigateTo({
					url:'/pages/activitydetail/activitydetail?ActivityId='+ ActivityId
				})
			},	
		}
	}
</script>

<style>

</style>
