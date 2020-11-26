// pages/mycenter/mycenter.js
var config = require("../../utils/config.js");//引入模块。返回模块通过 module.exports 或 exports 暴露的接口。

Page({

  data: {
    imghost: config.host + "upload",
    currOpenId: wx.getStorageSync('user').openid,//wx.getStorageSync是一个同步接口,获取本地缓存中的user
    items:[],
    hiddenModal2: true,
    input: '',
    contlist:[]
  },

  onLoad: function (options) {
    this.requestsData();//requestsData()是一个函数，在后面有具体的定义
  },

  input: function (e) {
    this.setData({ input: e.detail.value })//e.detail.value动态获取input中的value
  },

  model2confirm: function (e) {
    this.setData({ hiddenModal2: true })

    if (this.data.input) {
      this.addConts(this.data.currOpenId, this.data.input);
    } else {
      wx.showModal({//wx.showModal为跳出的弹窗
        title: '提示',
        content: '内容信息都不能为空',
        success: function (res) {
          if (res.confirm) {
            console.log('确定')
          } else if (res.cancel) {
            console.log('取消')
          }
        }
      });
    }
  },

  model2cancel: function (e) {
    this.setData({ hiddenModal2: true })
  },

  addfayan: function (event) {
    var that = this;//this是javascript语言的一个关键字，他代表函数运行时，自动生成的一个内部对象，this代表的是当前对象，只能在函数内部使用，会随着程序的执行过程的上下文改变，var that=this就是将当前的this对象复制一份到that变量中
    this.setData({ hiddenModal2: false })

  },

  addConts(openId, wecont) {
    var that = this;
    wx.request({
      url: config.host + 'MentalhealthTestWechatWeb/AddWechatInfoForXiao',
      data: {
        "openId": openId,
        "wecont": wecont
      },
      method: 'POST',//向客户端发起post请求
      header: {
        "Content-Type": "application/x-www-form-urlencoded"//设置请求的header
      },
      success: function (res) {
        console.log(res.data);
        if (res.data.result) {

          that.setData({
            items: res.data.object
          })

          wx.showToast({//wx.showToast是微信提供的API,其作用是显示消息提示框
            title: '发言成功',//提示的内容
            icon: 'success',//图标，只支持success,loading
            duration: 1000,//提示的延迟时间
            mask: true//是否显示透明蒙层，防止触摸穿透
          })
        } else {
          wx.showToast({
            title: '失败!',
            duration: 1000,
            mask: true
          })
        }
      }
    })
  },

  requestsData() {//在页面刚加载完成后调用这个函数
    var that = this;
    wx.request({//接口调用
      url: config.host + 'MentalhealthTestWechatWeb/GetAllWechatsInfoForXiao',
      data: {
      },
      header: {
        'content-type': 'application/json'//默认写法
      },
      success: function (res) {
        console.log(res.data);

        that.setData({
          items: res.data.object
        })
      }
    })
  }


  


})