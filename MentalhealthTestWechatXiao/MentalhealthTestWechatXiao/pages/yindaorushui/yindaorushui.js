// pages/mycenter/mycenter.js
var config = require("../../utils/config.js");
Page({

  data: {
    imghost: config.host + "upload",
    currOpenId: wx.getStorageSync('user').openid,
   
  },

  onLoad: function (options) {
  },

  ziwozhiyuyindaobtn: function(){
    var that = this;
    let obj = {
      dataUrl: that.data.imghost + "/one.mp3"
    }

    console.log(obj)

    wx.playBackgroundAudio(obj)
  },

  shenaizijiyindaobtn: function(){
    let obj = {
      dataUrl: that.data.imghost + "/two.mp3"
    }
    wx.playBackgroundAudio(obj)
  },

  caoyuanyindaobtn: function () {
    let obj = {
      dataUrl: that.data.imghost + "/one.mp3"
    }
    wx.playBackgroundAudio(obj)
  },
 
  goIndex: function () {
    var that = this;
    wx.switchTab({
      url: "/pages/index/index"
    });
  },

  


})