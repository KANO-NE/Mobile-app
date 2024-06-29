<template>
	<view style="background-color: white;height: 100%;min-height: 100vh">
		 <view style="height: 250rpx;width:750rpx;padding: 40rpx 0rpx;background-color: #00aaff;">

			 <view style="display: flex;margin: 0rpx 40rpx;">
				 <!-- 头像 -->
				 <view style="flex: 1;">
					<img :src="user.img || '/static/img/default_img.png'" alt="" 
					style="width: 170rpx;height: 170rpx;border-radius: 50%;">
				 </view>
				 <!-- 用户信息 -->
				<view style="flex: 2;margin: 30rpx 0rpx;">
					<view style="font-size: 36rpx;font-weight: 700;color: #ffffff;">{{user.name || '用户名'}}</view>
						<view style="margin-top: 20rpx;color: #00aaff;font-size: 32rpx;">
							<span style="background-color: #ffffff;border-radius: 10rpx;padding: 0rpx 20rpx;"><uni-icons type="vip-filled" size="20" color="#00aaff"></uni-icons> {{user.role == 'ADMIN'  ?  "管理员"  :  "普通用户"}}</span>
						</view>
				</view> 
			 </view>
			 
			 
			 
			 <view class="box" style="margin: 30rpx;font-size: 32rpx;font-weight: 500;">
			 	<view style="display: flex;text-align: center;padding: 10rpx;">
					<view style="flex: 1;" @click="goPage('/pages/mytopic/mytopic')">
						<view style="color: #00aaff;font-weight: 700;">{{topicData.length}}</view>
						<view>我的话题</view>
					</view>
					
					<view style="flex: 1;" @click="goPage('/pages/myactivity/myactivity')">
						<view style="color: #00aaff;font-weight: 700;">{{activityData.length}}</view>
						<view>我的活动</view>
					</view>
					
					<view style="flex: 1;" @click="goPage('/pages/collect/collect')">
						<view style="color: #00aaff;font-weight: 700;">{{collectData.length}}</view>
						<view>我的收藏</view>
					</view>
				</view>
			 </view>
			 
			 <view class="box" style="margin:20rpx 30rpx;display: flex;" @click="goPage('/pages/person/person')">
				 <view style="flex: 1;">
					 <img src="/static/icons/个人信息编辑.png" alt="" style="height: 50rpx;width: 50rpx;">
				 </view> 
				<view style="flex: 9;font-size: 32rpx;line-height: 50rpx;font-weight: 500;margin-left: 10rpx;">个人信息</view>
				<view style="flex: 1;font-size: 36rpx;line-height: 50rpx;font-weight: 500;"><uni-icons type="right" size="18"></uni-icons></view>
			 </view>
			 
			 
			 <view class="box" style="margin:20rpx 30rpx;display: flex;" @click="goPage('/pages/history/history')">
				 <view style="flex: 1;">
					 <img src="/static/icons/历史足迹.png" alt="" style="height: 50rpx;width: 50rpx;">
				 </view> 
				<view style="flex: 9;font-size: 32rpx;line-height: 50rpx;font-weight: 500;margin-left: 10rpx;">历史足迹</view>
				<view style="flex: 1;font-size: 36rpx;line-height: 50rpx;font-weight: 500;"><uni-icons type="right" size="18"></uni-icons></view>
			 </view>
			 
			 <view class="box" style="margin:20rpx 30rpx;display: flex;" @click="goPage('/pages/privacy/privacy')">
				 <view style="flex: 1;">
					 <img src="/static/icons/隐私保护.png" alt="" style="height: 50rpx;width: 50rpx;">
				 </view> 
				<view style="flex: 9;font-size: 32rpx;line-height: 50rpx;font-weight: 500;margin-left: 10rpx;">隐私设置</view>
				<view style="flex: 1;font-size: 36rpx;line-height: 50rpx;font-weight: 500;"><uni-icons type="right" size="18"></uni-icons></view>
			 </view>
			 
			 <view class="box" style="margin:20rpx 30rpx;display: flex;" @click="goPage('/pages/customer/customer')">
				 <view style="flex: 1;">
					 <img src="/static/icons/客服.png" alt="" style="height: 50rpx;width: 50rpx;">
				 </view> 
				<view style="flex: 9;font-size: 32rpx;line-height: 50rpx;font-weight: 500;margin-left: 10rpx;">客服帮助</view>
				<view style="flex: 1;font-size: 36rpx;line-height: 50rpx;font-weight: 500;"><uni-icons type="right" size="18"></uni-icons></view>
			 </view>
			
			<view class="box" style="margin:20rpx 30rpx;display: flex;" @click="logout" v-if="user.id">
				 <view style="flex: 1;">
					 <img src="/static/icons/退出.png" alt="" style="height: 50rpx;width: 50rpx;">
				 </view> 
				<view style="flex: 9;font-size: 32rpx;line-height: 50rpx;font-weight: 500;margin-left: 10rpx;">退出账号</view>
				<view style="flex: 1;font-size: 36rpx;line-height: 50rpx;font-weight: 500;"><uni-icons type="right" size="18"></uni-icons></view>
			</view>

		 </view>
		 
		 
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:uni.getStorageSync('xm-user'),//获取当前用户
				activityData:[],//活动数据
				topicData:[],//活动数据
				collectData:[],//活动数据
			}
		},
		onLaunch() {
			
		},
		onLoad() {
			this.updateUser()
			this.checkLogin()
			this.loadActivity()
			this.loadTopic()
			this.loadCollect()
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
			//搜索该用户的活动长度
			loadActivity(){
				this.$request.get('/activityrecords/selectByUserId?id='+ this.user.id).then(res =>{
					this.activityData = res.data || {}
				})
			},
			//搜索该用户的话题长度
			loadTopic(){
				this.$request.get('/topic/selectByUserName?name='+ this.user.name).then(res =>{
					this.topicData = res.data || {}
				})
			},
			//搜索该用户的收藏长度
			loadCollect(){
				this.$request.get('/collect/selectByUserId?id='+ this.user.id).then(res =>{
					this.collectData = res.data || {}
				})
			},
			//退出
			logout() {
				uni.removeStorageSync('xm-user')
				uni.removeStorageSync('orderStore')  // 清除所有订单缓存数据
				uni.reLaunch({
					url: '/pages/login/login'
				})
			},
			//跳转
			goPage(url){
				uni.navigateTo({
					url : url
				})
			},
			updateUser() {
			      this.user = uni.getStorageSync('xm-user') || '{}'    // 重新获取下用户的最新信息
			    },
		}
	}
</script>

<style>
	
</style>
