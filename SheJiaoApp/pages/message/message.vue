<template>
	<view>
		<view style="margin-bottom: 20rpx;">
			<!--scrollable speed="50" 滚动 -->
			<uni-notice-bar show-icon  v-if="content" 
				:text="content" />
		</view>
		
		<view class="box" style="margin: 20rpx;font-size: 38rpx;font-weight: 700;">我的活动</view>
		<view v-if="this.activityData.length === 0" class="box" style="margin: 20rpx;font-size: 32rpx;"@click="goPage('/pages/activity/activity')">您还没加入任何活动，快去寻找吧</view>
		
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
		
		<view class="box" style="margin: 20rpx;font-size: 38rpx;font-weight: 700;">我的好友</view>
		<view v-if="this.usercollectData.length === 0" class="box" style="margin: 20rpx;font-size: 32rpx;"@click="goPage('/pages/search/search')">您还没搭子，快去寻找吧</view>
		
		<view class="box" style="margin: 20rpx;" v-for="item in usercollectData" :key="item.id" @click="goUserDetail(item.targetId)">
			<view style="display: flex;">
				<view style="flex: 1;">
					<img style="height: 100rpx;width: 100rpx;;" :src="item.userImg" alt="" />
				</view>
				<view style="flex: 9;margin-left: 20rpx;font-size: 32rpx;font-weight: 700;">
					{{item.userName}}
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
				content:'',
				noticeList:[],
				activityData:[], //活动数据
				usercollectData:[], //用户数据
			}
		},
		onShow() {
			this.loadNotice()
			this.loadActivity()
			this.loadUserCollect()
			
		},
		methods: {
		loadActivity(){
			this.$request.get('/activityrecords/selectByUserId?id='+ this.user.id).then(res =>{
				this.activityData = res.data || {}
			})
		},
		loadUserCollect(){
			this.$request.get('/usercollect/selectByUserId?id='+ this.user.id).then(res =>{
				this.usercollectData = res.data || {}
			})
		},
		loadNotice(){
			this.$request.get('/notice/selectAll').then(res =>{
				this.noticeList = res.data || []
				
				let i = 0
				this.content = this.noticeList.length ? this.noticeList[i].content : ''
				
				//定时器
				if(this.noticeList.length > 1){
				 this.inter = setInterval(()=>{
						i++
						if(i === this.noticeList.length){
							i = 0
						}
						this.content = this.noticeList[i].content
					},5000)
				}
			})
		},
		//跳转
		goPage(url){
			uni.navigateTo({
				url : url
			})
		},
		goActivityShow(ActivityId,ActivityRecordsId){
			uni.navigateTo({
				url:'/pages/activityshow/activityshow?ActivityId='+ ActivityId +'&ActivityRecordsId=' +ActivityRecordsId
				
			});
		},
		goUserDetail(UserId){
			//后跳转页面
			uni.navigateTo({
				url:'/pages/user/user?UserId='+ UserId
			})
		},
		
		}
	}
</script>

<style>

</style>
