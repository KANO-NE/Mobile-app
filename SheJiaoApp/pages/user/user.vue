<template>
	<view>
		<view class="box" style="margin: 20rpx 20rpx; ">
			<view style="display: flex;">
				<view style="flex: 2;"><img style="height: 150rpx;width: 150rpx;" :src="UserData.img" alt=""></view>
				<view style="flex: 8;">
					<view style="font-size: 32rpx;font-weight: 700;margin-left: 20rpx;">用户名称：{{UserData.username}}</view>
					<view style="font-size: 28rpx;margin: 10rpx 20rpx;">用户介绍：{{UserData.introduce}}</view>
				</view>
			</view>
		</view>
		<view class="box" style="margin: 20rpx;">
			<button @click="collect(UserData.id)">关注他</button>
		</view>
		<view class="box" style="margin: 20rpx;">
			该用户参加过的话题
		</view>
		<view class="box" style="margin: 20rpx;" v-for="item in topicData" :key="item.id"  @click="goTopicDetail(item.id)">
			话题标题：{{item.title}}
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
			user:uni.getStorageSync('xm-user'),//获取当前用户
			UserData:[],
			topicData:[],//活动数据
			}
		},
		onLoad(option) {
			const UserId = option.UserId
			this.load(UserId)
			console.log(UserId)
			this.loadTopic()
		},
		methods: {
			collect(){
				if (this.user.id === this.UserData.id ){
					uni.showToast({
						icon: 'none',
						title: '您不能关注自己！'
					})
				  return
				}
			      if(!this.user.id){
					  uni.showToast({
					    	icon: 'none',
					    	title: '请登录后关注！'
					  })
			      }else {
			        let data = {
			          userId:this.user.id,
			          targetId:this.UserData.id
			        }
			
			        this.$request.post('/usercollect/add',data).then(res =>{
			          if (res.code === '200') {
						  uni.showToast({
						  	icon: 'success',
						  	title: '关注成功',
						  })
						  //this.onLoad()
			          } else {
						  uni.showToast({
						  	icon: 'none',
						  	title: res.msg
						  })
			          }
			        })
			      }
			    },
			load(UserId){
				this.$request.get('/user/selectById?id='+ UserId).then(res =>{
					this.UserData = res.data || {}
				})
			},
			//搜索该用户的话题长度
			loadTopic(){
				this.$request.get('/topic/selectByUserName?name='+ this.user.name).then(res =>{
					this.topicData = res.data || {}
				})
			},
			goTopicDetail(TopicId){
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
