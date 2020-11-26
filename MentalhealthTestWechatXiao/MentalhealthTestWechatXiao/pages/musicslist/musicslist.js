
var config = require("../../utils/config.js");
var searchValue = ''
Page({

  data: {
    list: [],
    imghost: config.host + "upload",
    currOpenId: wx.getStorageSync('user').openid
  },

  onLoad: function (options) {
    this.requestsData();
  },

  playMusic(e) {
    var that = this;
    var mpath = e.currentTarget.dataset.id;

    let obj = {
      dataUrl: that.data.imghost + mpath
    }
    wx.playBackgroundAudio(obj)
  },

  requestsData() {
    var that = this;
    wx.request({
      url: config.host + 'MentalhealthTestWechatWeb/GetAllMusicssInfoForXiao',
      data: {
      },
      header: {
        'content-type': 'application/json'
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