// pages/mycenter/mycenter.js
var config = require("../../utils/config.js");
Page({

  data: {
    imghost: config.host + "upload",
    currOpenId: wx.getStorageSync('user').openid,
  },

  onLoad: function (options) {
  },

  selftestceshibtn:function(){
    var that = this;
    wx.navigateTo({
      url: '/pages/selftestceshi/selftestceshi'
    })
  },

  professionalselftestsbtn: function(){
    var that = this;
    wx.navigateTo({
      url: '/pages/professionalselftests/professionalselftests'
    })
  }

  


})