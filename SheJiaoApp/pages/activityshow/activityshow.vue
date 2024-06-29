<template>
	<view>
		<view >
			<view class="box" style="text-align: center;">
				<uni-row :gutter="0">
					<uni-col :span="6" v-for="item in activitymember" :key="item.id">
						<view class="demo-uni-col dark_deep" style="margin-top: 20rpx;">
							<img style="height: 100rpx;width: 100rpx;" :src="item.userImg ||  'http://localhost:9090/files/default_img.png' " alt="">
							<view>{{item.userName}}</view>
						</view>
					</uni-col>
				</uni-row>
			</view>
		
			<view class="box" style="margin-top: 20rpx;">
				<view style="margin: 30rpx 30rpx;font-size: 32rpx;">
					<span style="margin-left: 20rpx;font-weight: 700;">活动名称</span><span style="float: right;">{{activityData.name}}</span>
				</view>
				<view style="margin: 30rpx 30rpx;font-size: 32rpx;">
					<span style="margin-left: 20rpx;font-weight: 700;">活动人数</span><span style="float: right;">{{activityData.num}}</span>
				</view>
				<view style="margin: 30rpx 30rpx;font-size: 32rpx;">
					<span style="margin-left: 20rpx;font-weight: 700;">活动类型</span><span style="float: right;">{{activityData.type}}</span>
				</view>
				<view style="margin: 30rpx 30rpx;font-size: 32rpx;">
					<span style="margin-left: 20rpx;font-weight: 700;">创建时间</span><span style="float: right;">{{activityData.time}}</span>
				</view>
			</view>
			
			<view class="box" style="margin-top: 20rpx;text-align: center;">
				<view v-if="activityData.userId != user.id" style="font-size: 32rpx;color: red" @click.native.stop="handleDel(ActivityRecordsId)">退出活动</view>
				<view v-if="activityData.userId == user.id" style="font-size: 32rpx;color: red" @click="DelActivity(activityData.id)">解散活动</view>
			</view>
		</view>
		
		<view>
			<!-- 提示窗示例 -->
			<uni-popup ref="alertDialog" type="dialog">
				<uni-popup-dialog :type="msgType" cancelText="取消" confirmText="确认" title="删除确认" content="您确认退出该活动吗？" 
					@confirm="del"></uni-popup-dialog>
			</uni-popup>
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
			this.ActivityRecordsId = option.ActivityRecordsId
			this.load(ActivityId)
			this.loadActivityMember(ActivityId)
			
			console.log("活动编号："+ ActivityId)
			console.log("当前记录：" + this.ActivityRecordsId)
		},
		methods: {
			handleDel(ActivityRecordsId) {
				console.log("打开以后：" + ActivityRecordsId)
				// this.activityId = ActivityId
				this.$refs.alertDialog.open()
			},
			DelActivity(ActivityId){
				console.log("删除活动：" + ActivityId)
				this.$request.del('/activity/delete/' + ActivityId).then(res => {
					if (res.code === '200') {
						uni.showToast({
							icon: 'success',
							title: '退出成功'
						})
						uni.reLaunch({
						     url: '/pages/message/message'
						   });
					} else {
						uni.showToast({
							icon: 'none',
							title: res.msg
						})
					}
				})
			},
			del(ActivityRecordsId) {
				console.log("删除以前：" + this.ActivityRecordsId)
				this.$request.del('/activityrecords/delete/' + this.ActivityRecordsId).then(res => {
					if (res.code === '200') {
						uni.showToast({
							icon: 'success',
							title: '操作成功'
						})
						uni.reLaunch({
						     url: '/pages/message/message'
						   });
					} else {
						uni.showToast({
							icon: 'none',
							title: res.msg
						})
					}
				})
			},
			load(ActivityId){
				this.$request.get('/activity/selectById?id='+ ActivityId).then(res =>{
					this.activityData = res.data || {}
				})
			},
			loadActivityMember(ActivityId){
				this.$request.get('/activityrecords/selectByActivityId?id='+ ActivityId).then(res =>{
					this.activitymember = res.data || {}
				})
			},
		}
	}
</script>

<style>

</style>
