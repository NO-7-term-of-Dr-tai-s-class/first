var config = require("../../utils/config.js");
var GJson = require("../../utils/json2Form.js");
var WxParse = require('../../wxParse/wxParse.js');


Page({

  data: {
    list: [],
    imghost: config.host + "upload",
    currOpenId: wx.getStorageSync('user').openid,
  },

  onLoad: function (options) {
    this.requestData(options.openId);
  },

  upUserInfoBtn: function () {
    var that = this;
    wx.navigateTo({
      url: '../upmyinfoss/upmyinfoss'
    })
  },

  requestData(id) {
    var that = this;
    wx.request({
      url: config.host + 'MentalhealthTestWechatWeb/GetMyOneInfosByOpenidForXiao',
      data: {
        "openId": id
      },
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        console.log(res.data);

        that.setData({
          list: res.data.object
        })
      }
    })
  }

})