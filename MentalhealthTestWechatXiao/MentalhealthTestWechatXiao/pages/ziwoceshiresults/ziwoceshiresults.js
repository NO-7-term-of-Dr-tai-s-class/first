// pages/mycenter/mycenter.js
var config = require("../../utils/config.js");
Page({

  data: {
    imghost: config.host + "upload",
    currOpenId: wx.getStorageSync('user').openid,
    items:[]
  },

  onLoad: function (options) {
    this.requestData();
  },

  goIndex: function(){
    var that = this;
    wx.switchTab({
      url: "/pages/index/index"
    });
  },

  onShareAppMessage: function () {
    var that = this;
    return {
      title: '分享转发',
      path: '/page/ziwoceshiresults',
      success: function (res) {
      },
      fail: function (res) {
      }
    }
  },

  requestData() {
    var that = this;
    wx.request({
      url: config.host + 'MentalhealthTestWechatWeb/GetSelftestScoreInfoForXiao',
      method: 'post',
      data: {
        openId: this.data.currOpenId
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded;charset=utf-8"
      },
      success: function (res) {

        that.setData({
          items: res.data.object
        })

      }
    });
  },

  


})