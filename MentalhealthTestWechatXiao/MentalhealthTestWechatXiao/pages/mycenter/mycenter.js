// pages/mycenter/mycenter.js
var config = require("../../utils/config.js");
Page({

  data: {
    usernaem: wx.getStorageSync('userInfo').nickName,
    userImgUrl: wx.getStorageSync('userInfo').avatarUrl,
    userLoca: wx.getStorageSync('userInfo').province + wx.getStorageSync('userInfo').city
  },

  onLoad: function (options) {
    
  },

  myInfosBtn: function (e) {
    var openId = wx.getStorageSync('user').openid;
    wx.navigateTo({
      url: '../myinfoss/myinfoss?openId=' + openId
    })
  },

 


})