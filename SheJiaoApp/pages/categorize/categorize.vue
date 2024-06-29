<template>
	<view style="background-color: #FFFFFF;min-height: 100vh;">
		<view class="box" style="display: flex;padding: 20rpx;background-color: #ffffff;">
			<view style="flex: 3;background-color: #00aaff;border-radius: 10rpx;">
				<input style="font-size: 32rpx;margin: 20rpx 20rpx;color: #FFFFFF;" placeholder="请输入活动关键词" v-model="name"></input>
			</view>
			<view style="flex: 1;">
				<button style="height: 80rpx;font-size: 30rpx;;margin-left: 5px;font-weight: 700;" @click="navTosearch">搜索</button>
			</view>
		</view>
		
		
		
		<view style="display: flex;margin: 0rpx 10rpx;text-align: center;font-weight: 500;">
			<view style="flex: 2;">
				<view class="sidebar-menu">
					<view class="sidebar-item" v-for="(item, index) in items" :key="index" 
						@click="handleSidebarItemClick(item)">
						{{ item.text }}
					</view>
				</view>
				
				
			</view>
			<view style="flex: 6;margin: 0rpx 20rpx;">
				<view v-for="item in TopicList" :key="item.id" class="box" style="margin-top: 20rpx;"@click="goActivityDetail(item.id)">
					<view style="display: flex;">
						<view style="flex: 1;">
							<img style="height: 150rpx;width: 150rpx;" :src="item.img || 'http://localhost:9090/files/default.png'" alt="">
						</view>
						<view style="flex: 9;text-align: left;margin-left: 20rpx;">
							<view>活动名称：{{item.name}}</view>
							<view>活动人数：{{item.num}}</view>
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
				user: uni.getStorageSync('xm-user'),
				items:[],//活动类型
				current:'全部',
				TopicList:{}, //相关活动
				name:''
			};
		},
		onShow() {
			this.loadActivitytype()
			this.load()
		
		},
		methods: {
		//获取类型
		loadActivitytype(){
			  this.$request.get('/activitytype/selectAll').then(res => {
				if (res.code === '200'){
				  this.items = res.data
				}else{
				  this.$message.error(res.msg)
				}
			  })
			},
		handleSidebarItemClick(item) {
				// 处理侧边栏菜单项点击事件
				//console.log('点击了菜单项:', item.text);
				this.current = item.text
				//console.log(this.current);
				this.load()
			},
		load() {
			let params = {
				//type: this.user.id
			}
			if (this.current !== '全部') {
				params.type = this.current
			}
			this.$request.get('/activity/selectAll', params).then(res => {
				this.TopicList = res.data || []
			})
		},
		goActivityDetail(ActivityId){
			uni.navigateTo({
				url:'/pages/activitydetail/activitydetail?ActivityId='+ ActivityId
			})
		},
		navTosearch(){
			if(this.name == '' ){
				this.$request.get('/activity/selectAll').then(res =>{
					this.TopicList = res.data || {}
				})
			}else{
				this.$request.get('/activity/selectByName?name='+ this.name).then(res => {
					if (res.code === '200'){
					  this.TopicList = res.data
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
	
 
	.sidebar-menu {
		margin-top: 10px;
		font-size: 30rpx;
		border-right: 2px solid  #00aaff;
	}
 
	.sidebar-item {
		padding: 20rpx 0rpx;
		cursor: pointer;
		transition: background-color 0.3s;
	}
 
	.sidebar-item:hover {
		background-color: #00aaff;
		border-radius: 20rpx;
		
	}
 


</style>
