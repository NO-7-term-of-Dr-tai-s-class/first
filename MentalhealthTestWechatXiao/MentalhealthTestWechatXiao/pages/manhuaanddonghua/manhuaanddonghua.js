// pages/mycenter/mycenter.js
var config = require("../../utils/config.js");
Page({

  data: {
    imghost: config.host + "upload",
    currOpenId: wx.getStorageSync('user').openid,
  },

  onLoad: function (options) {
  },

  manhaubtn:function(){
    var that = this;
    wx.navigateTo({
      url: '/pages/manhuadonghualists/manhuadonghualists'
    })
  },

  donghuabtn: function(){
    var that = this;
    wx.navigateTo({
      url: '/pages/manhuadonghualists2/manhuadonghualists2'
    })
  }

  


})