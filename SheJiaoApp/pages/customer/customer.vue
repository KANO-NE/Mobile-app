<template>
	<view style="min-height: 100vh;">
		<view style="margin: 70rpx 20rpx;background-color: #ffffff;height: 160rpx;width: 70%;font-size: 36rpx;border-radius: 20rpx;">
			<view style="padding: 30rpx 30rpx;">Hi,我是您的客服助手，您有什么问题随时回复~</view>
		</view>
		
		
		<view class="box" style="margin: 20rpx;" v-for="item in contentData" :key="item">
			<view style="display: flex;">
				<view style="flex: 2;" v-if="item.acceptId">
					<img style="height: 100rpx;width: 100rpx;" :src="'/static/img/default_img.png'" alt="">
				</view>
				<view style="flex: 8;">
					<view style="margin: 10rpx 10rpx;">内容：{{item.content}}</view>
					<view style="margin: 10rpx 10rpx;">发送时间：{{item.time}}</view>
				</view>
				<view style="flex: 2;" v-if="!item.acceptId">
					<img style="height: 100rpx;width: 100rpx;" :src="item.userImg || '/static/img/default_img.png'" alt="">
				</view>
			</view>
			
		</view>
		
		
		<view class="box" style="position: fixed;bottom: 0rpx;width: 95%;margin: 20rpx 20rpx;">
			<view style="display: flex;">
				<view style="flex: 6;">
					<input class="uni-input" focus placeholder="请输入您的问题" v-model="content"/>
				</view>
				<view style="flex: 2;">
					<button class="mini-btn" type="primary" size="mini" @click="addContent">发送</button>
				</view>
			</view>
		</view>
		
	</view>
	
</template>

<script>
	export default {
		data() {
			return {
				user: uni.getStorageSync('xm-user'),
				content:'',
				contentData:{},
			}
		},
		onShow() {
			this.loadContent()
		},
		methods: {
			loadContent(){
				this.$request.get('/customer/selectByUserId?id='+ this.user.id).then(res =>{
					this.contentData = res.data || {}
				})
			},
			addContent(){
				if(this.content == '' ){
					uni.showToast({
						icon: 'error',
						title: '内容为空'
					})
				}else{
					//var activityId = this.activityData.id
					let params = {
						//设置参数
						content : this.content, //获取活动编号
						userId : this.user.id,//获取用户编号
						}
						this.$request.post('/customer/add',params).then(res =>{
							if (res.code === '200') {
									uni.showToast({
										icon: 'success',
										title: '发送成功'
									})
									this.loadContent()
									this.content = ''
									//console.log(activityId)
									//  uni.reLaunch({
									// 	  url: '/pages/activitydetail/activitydetail?ActivityId='+ activityId
									// 	});
									// this.load(topicId)
								} else {
									uni.showToast({
										icon: 'none',
										title: res.msg
									})
								}
						})
				}
			},
		},
				
		}
</script>

<style>

</style>
