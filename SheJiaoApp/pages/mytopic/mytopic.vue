<template>
	<view>
		<view style="text-align: center;font-size: 32rpx;margin: 20rpx 20rpx;">参加的话题</view>
		<view class="box" style="margin: 20rpx;" v-for="item in topicData" :key="item.id" @click="goTopicDetail(item.id)">
			<view style="font-weight: 700;font-size: 35rpx;margin-bottom: 20rpx;">#{{item.title}}</view>
			<view style="margin-bottom: 20rpx;font-weight: 400;">
				<span style="color: #3CB371;">{{item.reply}}</span>
				<span style="margin-left: 10rpx;">人参与讨论 </span> 
				<span style="margin-left: 20rpx;">浏览<span style="color: #3CB371;margin: 0rpx 10rpx;">{{item.num}}</span>次</span>
				<span style="margin: 0rpx 20rpx;">发布人：{{item.name}}</span>
			</view>
			<view>发布时间：{{item.time}}</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:uni.getStorageSync('xm-user'),//获取当前用户
				topicData:{},//话题数据
			}
		},
		onLoad() {
			this.loadTopic()
		},
		methods: {
			//搜索该用户的话题
			loadTopic(){
				this.$request.get('/topic/selectByUserName?name='+ this.user.name).then(res =>{
					this.topicData = res.data || {}
				})
			},
			goTopicDetail(TopicId){
				if(this.user.id){
					let params = {
						//设置参数
						contentId : TopicId, 
						userId : this.user.id,//获取用户的ID
						plate:1
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
					url:'/pages/topicdetail/topicdetail?TopicId='+ TopicId
				})
			},
		}
	}
</script>

<style>

</style>
