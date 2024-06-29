<template>
	<view style="min-height: 100vh;">
		<view style="background-color:#00aaff;padding: 30rpx;">
			<view style="font-size: 38rpx;font-weight: 700;color: #ffffff;">#{{topicdata.title}}</view>
			<view style="display: flex;text-align: left;margin-top: 30rpx;font-size: 30rpx;color: #ffffff">
				<view style="flex: 1;">{{topicdata.reply}} 条回复</view>
				<view style="flex: 1;">{{topicdata.num}} 浏览</view>
				<view style="flex: 1;"></view>
				<view style="flex: 1;text-align: right;" @click="collect"></uni-icons>+收藏</view>
				
			</view>
			<view style="text-align: left;margin-top: 30rpx;font-size: 30rpx;color: #ffffff">发布时间：{{topicdata.time}}</view>
			<view style="text-align: left;margin-top: 10rpx;font-size: 30rpx;color: #ffffff">发布者：{{topicdata.name}}</view>
		</view>
		
		<view class="box">
			<view v-if="this.topicreplydata.length == 0 ">快来抢板凳吧！</view>
			<view class="box" style="margin-top: 20rpx;" v-for="item in topicreplydata" :key="item.id">
				<view style="display: flex;">
					<view style="flex: 2;">
						<img style="height: 100rpx;width: 100rpx;" :src="item.userImg" alt="">
					</view>
					<view style="flex: 8;">
						<view style="margin-bottom: 10rpx;font-weight: 700;font-size: 38rpx;">{{item.userName}}</view>
						<view></view>
					</view>
				</view>
				<view style="margin-top: 20rpx;">
					留言内容：{{item.content}}
				</view>
				<view style="margin-top: 20rpx;">
					<span style="">留言时间：{{item.time || ''}}</span>  <span v-if="item.userId === user.id" style="margin-left: 20rpx;text-align: right;"@click.native.stop="handleDel(item.id)">删除</span>
				</view>
			</view>
		</view>
		<button class="button" style="position: fixed;bottom: 0rpx;width: 95%;margin: 10rpx 20rpx;background-color: #00aaff;" type="primary" @click="inputDialogToggle">
			<text class="button-text">评 论</text></button>
		<view>
		<!-- 输入框示例 -->
			<uni-popup ref="inputDialog" type="dialog">
				<uni-popup-dialog ref="inputClose"  mode="input" title="输入内容" value=""
					placeholder="请输入内容" @confirm="dialogInputConfirm"></uni-popup-dialog>
			</uni-popup>
		</view>
		
		<view>
			<!-- 提示窗示例 -->
			<uni-popup ref="alertDialog" type="dialog">
				<uni-popup-dialog :type="msgType" cancelText="取消" confirmText="确认" title="删除确认" content="您确认删除评论吗？" 
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
				topicdata:[],
				par:{},
				topicreplydata:{}
			}
		},
		
		onLoad(option) {
			const TopicId = option.TopicId
			this.load(TopicId)
			this.loadTopicReply(TopicId)
		},
		
		methods: {
			collect(){
				if(!this.user.id){
				  uni.showToast({
						icon: 'none',
						title: '请登录后评论！'
				  })
				}else{
					let data = {
					  userId:this.user.id,
					  topicId:this.topicdata.id,
					}
								
					this.$request.post('/collect/add',data).then(res =>{
					  if (res.code === '200') {
						  uni.showToast({
						  	icon: 'success',
						  	title: '收藏成功',
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
			handleDel(topicId) {
			this.topicId = topicId
			this.$refs.alertDialog.open()
				
			},
			del() {
				var topicId = this.topicdata.id
				this.$request.del('/topicreply/delete/' + this.topicId).then(res => {
					if (res.code === '200') {
						uni.showToast({
							icon: 'success',
							title: '操作成功'
						})
						uni.reLaunch({
						     url: '/pages/topicdetail/topicdetail?TopicId='+ topicId
						   });
					} else {
						uni.showToast({
							icon: 'none',
							title: res.msg
						})
					}
				})
			},
			favClick(index) {
				this.checkList[index] = !this.checkList[index]
				console.log(this.checkList[index]);
				this.$forceUpdate()
			},
					
			load(TopicId){
				this.$request.get('/topic/selectById?id='+ TopicId).then(res =>{
					this.topicdata = res.data || {}
				})
			},
			loadTopicReply(TopicId){
				this.$request.get('/topicreply/selectByTopicId?id='+ TopicId).then(res =>{
					this.topicreplydata = res.data || {}
				})
			},
			
			inputDialogToggle() {
						this.$refs.inputDialog.open()
					},
			dialogInputConfirm(val) {	
				if(!this.user.id){
				  uni.showToast({
						icon: 'none',
						title: '请登录后评论！'
				  })
				}else{
					var topicId = this.topicdata.id
					let params = {
						//设置参数
						topicId : this.topicdata.id, 
						userId : this.user.id,//获取用户的ID
						content : val
						}
						this.$request.post('/topicreply/add',params).then(res =>{
							if (res.code === '200') {
									uni.showToast({
										icon: 'success',
										title: '操作成功'
									})
									console.log(topicId)
									 uni.reLaunch({
									      url: '/pages/topicdetail/topicdetail?TopicId='+ topicId
									    });
									//this.load(topicId)
								} else {
									uni.showToast({
										icon: 'none',
										title: res.msg
									})
								}
						})
				}
				
			},
								
				}
			}
</script>

<style>

</style>
