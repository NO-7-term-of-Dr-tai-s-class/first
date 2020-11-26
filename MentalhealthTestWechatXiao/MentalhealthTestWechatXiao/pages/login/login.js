// pages/login/login.js
var config = require("../../utils/config.js");
var GJson = require("../../utils/json2Form.js");
const app = getApp();
Page({
  data: {
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    userName:'',
    userOpenId:'',
    userImgUrl:''
  },
  onLoad: function () {
    var that = this;
    wx.getSetting({
      success: function (res) {
        if (res.authSetting['scope.userInfo']) {
          wx.getUserInfo({
            success: function (res) {
              console.log(wx.getStorageSync('user').openid);
              that.checkUserByOpenId(wx.getStorageSync('user').openid);
            }
          });
        }
      }
    })
  },

  checkUserByOpenId: function(openid){
    console.log(openid);
    wx.request({
      url: config.host + 'MentalhealthTestWechatWeb/checkUserByOpenIdForXiao',
      data: {
        openId: openid
      },
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded;charset=utf-8"
      },
      success: function (res) {
        if (res.data.result) {
          wx.switchTab({
            url: "/pages/index/index"
          });
        }

      }
    })
  },

  bindGetUserInfo: function (e) {
    if (e.detail.userInfo) {//如果能获取到用户信息的话，执行if语句里的内容
      var that = this;
      app.globalData.userInfo = e.detail.userInfo;
      console.log(e.detail.userInfo);

      this.data.userName = e.detail.userInfo.nickName;
      this.data.userOpenId = wx.getStorageSync('user').openid;
      this.data.userImgUrl = e.detail.userInfo.avatarUrl;
      wx.request({
        url: config.host + 'MentalhealthTestWechatWeb/AddUserInfoDbForXiao',
        data: {
          uname: this.data.userName,
          openId: this.data.userOpenId,
          imgUrl: this.data.userImgUrl

        },
        method: 'POST',
        header: {
          "Content-Type": "application/x-www-form-urlencoded;charset=utf-8"
        },
        success: function (res) {//跳到index页面
            wx.switchTab({
              url: "/pages/index/index"
            });
       
        }
      })
    } else {//如果获取不了用户信息，执行else后面的语句
      wx.showModal({//弹窗
        title: '警告',
        content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
        showCancel: false,
        confirmText: '返回授权',
        success: function (res) {
          if (res.confirm) {
            console.log('用户点击了“返回授权”')
          }
        }
      })
    }
  }


})
