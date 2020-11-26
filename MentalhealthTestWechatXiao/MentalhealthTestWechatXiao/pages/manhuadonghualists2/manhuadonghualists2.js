
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

  goDetails: function (event){
    var aid = event.currentTarget.dataset.id;

    wx.navigateTo({
      url: '/pages/donghuadetails/donghuadetails?aid=' + aid
    })

   
  },

  requestsData() {
    var that = this;
    wx.request({
      url: config.host + 'MentalhealthTestWechatWeb/GetAllCartoonanimatss2InfoForXiao',
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