<template>
	<view>
		<view class="box" style="display: flex;">
			<view style="flex: 3;background-color: beige;"><input style="margin-top: 10rpx;font-size: 30rpx;margin: 20rpx 20rpx;"  placeholder="请输入用户名称" v-model="name"></input></view>
			<view style="flex: 1;"><button style="height: 80rpx;font-size: 30rpx;" @click="navTosearch">搜索</button></view>
		</view>
		<view style="margin-top: 0rpx;">
			<view class="box" style="margin: 20rpx 20rpx; " v-for="item in userData" :key="item.id" @click="goUserDetail(item.id)">
				<view style="display: flex;">
					<view style="flex: 2;"><img style="height: 150rpx;width: 150rpx;" :src="item.img" alt=""></view>
					<view style="flex: 8;">
						<view style="font-size: 32rpx;font-weight: 700;margin-left: 20rpx;">用户名称：{{item.name}}</view>
						<view style="font-size: 28rpx;margin: 10rpx 20rpx;">用户介绍：{{item.introduce}}</view>
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
				userData:{},
				searchValue: '',
				name:''
			}
		},
		onLoad() {
			this.loadUser()
		},
		methods: {
			goUserDetail(UserId){
				//后跳转页面
				uni.navigateTo({
					url:'/pages/user/user?UserId='+ UserId
				})
			},
			loadUser(){
				this.$request.get('/user/selectAll').then(res =>{
					this.userData = res.data || {}
				})
			},
			navTosearch(){
				if(this.name == '' ){
					this.$request.get('/user/selectAll').then(res =>{
						this.userData = res.data || {}
					})
				}else{
					this.$request.get('/user/selectByName?name='+ this.name).then(res => {
						if (res.code === '200'){
						  this.userData = res.data
						}else{
						  this.$message.error(res.msg)
						}
					})
				}
			},
		}
	}
</script>

<style>

</style>
