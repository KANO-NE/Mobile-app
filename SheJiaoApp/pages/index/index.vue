<template>
	<view style="background-color: #FFFFFF;min-height: 100vh;;">
		<view style="background-image: linear-gradient(to bottom, #00aaff, #ffffff);padding-top: 30rpx;"> <!-- 颜色框 -->
			<!-- 搜索框 -->
			<view class="search" @click="goPage('/pages/search/search')">
				<view style="display: flex;">
					<view style="flex: 6;">
						<view style="margin: 10rpx 10rpx 0rpx 20rpx"><uni-icons type="search" size="30" color="#bababa;"></uni-icons>
						<span style="font-size: 36rpx;color: #bebebe;line-height: 80rpx;">请输入相关内容</span></view>	
						
					</view>
					<view style="flex: 1;margin-top: 8rpx;">
						
					</view>
					<view style="flex: 1;">
						<view style="background-color: #00aaff;border-radius: 50rpx;height:80rpx;width: 120rpx;margin-right: 10rpx;
						margin-top: 5rpx;text-align: center;line-height: 80rpx;color: white;font-size: 32rpx;">搜友</view>
					</view>
				</view>
			</view>
			
			<!-- 滚动海报 -->
			<view style="margin: 30rpx 30rpx;">
				<swiper circular autoplay :interval="3000" :duration="500" indicator-dots 
				  indicator-color="rgba(255, 255, 255, 0.6)" indicator-active-color="#ffffff" style="height: 300rpx;" >
				  <swiper-item v-for="item in imgs" :key="item" >
					<image style="width: 100%;height: 300rpx;border-radius: 30rpx;" :src="item.img" alt=""   />
				  </swiper-item>
				</swiper>
			</view>
		</view>
		
		<view style="display: flex;margin: 20rpx 30rpx;" class="box">
			<view style="flex: 1;text-align: center;" @click="goPage('/pages/topic/topic')">
				<image src="../../static/img/icon1.png" style="width: 100rpx;height: 100rpx;"></image>
				<view>话题推荐</view>
			</view>
			<view style="flex: 1;text-align: center;" @click="goPage('/pages/activity/activity')">
				<image src="../../static/img/icon2.png" style="width: 100rpx;height: 100rpx;"></image>
				<view>热门活动</view>
			</view>
			<view style="flex: 1;text-align: center;" @click="goPage('/pages/mytopic/mytopic')">
				<image src="../../static/img/icon3.png" style="width: 100rpx;height: 100rpx;"></image>
				<view>我的话题</view>
			</view>
			<view style="flex: 1;text-align: center;" @click="goPage('/pages/collect/collect')">
				<image src="../../static/img/icon4.png" style="width: 100rpx;height: 100rpx;"></image>
				<view>我的收藏</view>
			</view>
		</view>
		
		<!-- 今日话题 -->
		<view  style="margin:30rpx;">
			<view style="display: flex;margin-bottom: 30rpx;">
				<view style="flex: 1;color: #000000;font-size: 35rpx;font-weight: 700">话题推荐</view>
				<view style="flex: 1;"></view>
				<view style="flex: 1;color: #000000;font-size: 30rpx;text-align: right" @click="goPage('/pages/topic/topic')">更多话题 <uni-icons type="right" size="15"></uni-icons></view>
			</view>
			
			<view class="box" v-for="item in TopicHotData" :key="item.id" style="background-color: #ffffff;border-radius: 10rpx;margin-top: 20rpx;" @click="goTopicDetail(item.id)">
				<view style="font-weight: 700;font-size: 32rpx;"><span style="color: red;text-align: right;"><uni-icons color="red" type="fire-filled" size="20"></uni-icons>热门话题</span>#{{item.title}}</view>
			</view>
		</view>

		<!-- 搭子活动 -->
		<view style="margin: 30rpx;">
			<view style="display: flex;margin-bottom: 30rpx;">
				<view style="flex: 1;color: #000000;font-size: 35rpx;font-weight: 700">热门活动</view>
				<view style="flex: 1;"></view>
				<view style="flex: 1;color: #000000;font-size: 30rpx;text-align: right" @click="goPage('/pages/activity/activity')">更多活动 <uni-icons type="right" size="15"></uni-icons></view>
			</view>
			<view>
				<view v-for="item in activityData" :key="item.id" style="width: 100%;border-radius: 20rpx;margin-bottom: 10rpx;" @click="goActivityDetail(item.id)">
					<view class="box" style="display: flex;">
						<view style="flex: 1;">
							<img style="height: 180rpx;width: 180rpx;margin: 10rpx;border-radius: 10rpx;" :src="item.img" alt="">
						</view>
						<view style="flex: 3;margin: 10rpx;">
							<view style="font-weight: 600;font-size: 30rpx;">活动名称：{{item.name}}</view>
							<view style="margin: 10rpx 0rpx;overflow: hidden;text-overflow: ellipsis; display: -webkit-box; -webkit-line-clamp: 1;-webkit-box-orient: vertical;">活动介绍：{{item.introduce}}</view>
							<view>活动人数：{{item.num}}人</view>
							<view></view>
						</view>
					</view>
					
				</view>
				
			</view>
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
			activityData:[],
			TopicHotData:[],
			imgs: {}
			}
		},
		onShow() {
			this.loadTopicHot()
			this.loadActivity()
			this.loadBanner()
		},
		methods: {
		//获取最多人点击的话题
		loadTopicHot(){
			  this.$request.get('/topic/selectHot').then(res => {
				if (res.code === '200'){
				  this.TopicHotData = res.data
				}else{
				  this.$message.error(res.msg)
				}
			  })
			},
		//获取人最多的两个活动
		loadActivity(){
			  this.$request.get('/activity/selectHot').then(res => {
				if (res.code === '200'){
				  this.activityData = res.data
				}else{
				  this.$message.error(res.msg)
				}
			  })
			},
		//获取图片海报
		loadBanner(){
			  this.$request.get('/banner/selectAll').then(res => {
				if (res.code === '200'){
				  this.imgs = res.data
				}else{
				  this.$message.error(res.msg)
				}
			  })
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
	.search {
			border-radius: 50rpx;
			height: 90rpx;
			margin: 0rpx 30rpx;
			background-color: white;
		}

</style>
