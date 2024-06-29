<template>
	<view style="background-color: white;min-height: 100vh">
		<view style="text-align: center;padding: 90rpx 20rpx;">
			<image style="width: 300rpx;height: 200rpx;border-radius: 30rpx;" src="/static/logo.png" alt=""   />
		</view>
		<!-- 登录块 -->
		<view style="margin: 0rpx 60rpx;">
			<uni-forms ref="formRef" :modelValue="form" :rules="rules" validateTrigger="blur">
				<uni-forms-item name="username">
					<uni-easyinput prefixIcon="person" v-model="form.username" placeholder="请输入账号" />
				</uni-forms-item>
				
				<uni-forms-item name="password">
					<uni-easyinput type="password" prefixIcon="locked" v-model="form.password" placeholder="请输入密码" />
				</uni-forms-item>
				
				<uni-forms-item name="name">
					<uni-easyinput prefixIcon="person" v-model="form.name" placeholder="请输入姓名" />
				</uni-forms-item>
				
				<uni-forms-item name="phone">
					<uni-easyinput prefixIcon="person" v-model="form.phone" placeholder="请输入手机号" />
				</uni-forms-item>
				
				<uni-forms-item name="role">
				<uni-data-select v-model="form.role" :localdata="roleData" placeholder="请输入角色登录"></uni-data-select>
				</uni-forms-item>
				
				<uni-forms-item>
					<button @click="register" type="primary" style="width: 100%; height: 80rpx; line-height: 70rpx; background-color: #00aaff; border-color: #006eff;">注 册</button>
				</uni-forms-item>
			</uni-forms>
			<view style="text-align: center;font-size: 32rpx;font-weight: 500;margin-bottom: 40rpx;color: #00aaff;" @click="goPage('/pages/login/login')"><span>已有账号，我要登录</span></view>
		</view>
		

	</view>
</template>

<script>
	export default {
		data() {
			return {
				form: { role:'USER' }, //角色
				//codeImg: '', //验证码
				rules: {
					// 对字段进行必填验证
					username: {
						rules:[
							// 校验不能为空
							{
								required: true,
								errorMessage: '请输入账号',
							}
						],
					},
					password: {
						rules:[
							// 校验不能为空
							{
								required: true,
								errorMessage: '请输入密码',
							}
						],
					},
				},
				roleData: [
				    { value: "USER", text: "用户" },
				],
			}
		},
		mounted() {
			
		},
		methods: {
			 register() {
				 this.$refs.formRef.validate().then(valid => {
					 
			     
			        if (valid) {
			          // 验证通过
			          this.$request.post('/register', this.form).then(res => {
			            if (res.code === '200') {
			              setTimeout(() => {
			              	 	uni.reLaunch({
			              	 		url: '/pages/login/login'
			              	})
			              }, 500)
			             uni.showToast({
			             	icon: 'success',
			             	title: '注册成功'
			             })
			            } else {
			              uni.showToast({
			              	icon: 'none',
			              	title: res.msg
			              })
			            }
			          })
			        }
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
		//uuid
	function generateUUID() {
	  let d = new Date().getTime();
	  // if (window.performance && typeof window.performance.now === "function") {
	  //   d += performance.now(); //use high-precision timer if available
	  // }
	  let uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
	    let r = (d + Math.random() * 16) % 16 | 0;
	    d = Math.floor(d / 16);
	    return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
	  });
	  return uuid;
	}
</script>

<style>

</style>
