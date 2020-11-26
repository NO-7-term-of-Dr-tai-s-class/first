// pages/mycenter/mycenter.js
var config = require("../../utils/config.js");
Page({

  data: {
    imghost: config.host + "upload",
    currOpenId: wx.getStorageSync('user').openid,
  },

  onLoad: function (options) {
  },
  onShareAppMessage:function(){

  },
 
  ziwoceshibtn:function(){
    var that = this;
    wx.navigateTo({
      url: '/pages/ziwoceshi/ziwoceshi'
    })
  },

  yindaorushuibtn: function(){
    var that = this;
    wx.navigateTo({
      url: '/pages/yindaorushui/yindaorushui'
    })
  },

  musiczhiliaobtn: function(){
    var that = this;
    wx.navigateTo({
      url: '/pages/musicslist/musicslist'
    })
  },

  videolistbtn: function(){
    var that = this;
    wx.navigateTo({
      url: '/pages/videoslist/videoslist'
    })
  },

  manhuaanddonghuayindaobtn:function(){
    var that = this;
    wx.navigateTo({
      url: '/pages/manhuadonghualists/manhuadonghualists'
    })
  },

  wechatbtn: function(){
    var that = this;
    wx.navigateTo({
      url: '/pages/wechats/wechats'
    })
  }

  


})