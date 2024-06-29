<template>
	<view class="box">
		<view style="text-align: center;font-weight: 700;font-size: 36rpx;margin: 20rpx 0rpx;">系统隐私管理</view>
		<view style="font-size: 32rpx;margin: 20rpx 20rpx;">广告关闭<uni-icons style="margin-left: 20rpx;" type="right" size="20"></uni-icons></view>
		<view style="font-size: 32rpx;margin: 20rpx 20rpx;">位置信息<uni-icons style="margin-left: 20rpx;" type="right" size="20"></uni-icons></view>
		<view style="font-size: 32rpx;margin: 20rpx 20rpx;">麦克风<uni-icons style="margin-left: 20rpx;" type="right" size="20"></uni-icons></view>
		<view style="font-size: 32rpx;margin: 20rpx 20rpx;">相机权限<uni-icons style="margin-left: 20rpx;" type="right" size="20"></uni-icons></view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		onShow() {
			uni.showModal({
				title: '提示',
					content: '系统隐私不做管理',
					success: function (res) {
						if (res.confirm) {
							console.log('用户点击确定');
						} else if (res.cancel) {
							console.log('用户点击取消');
						}
					}
			})
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
