var config = require("../../utils/config.js");
var GJson = require("../../utils/json2Form.js");
var WxParse = require('../../wxParse/wxParse.js');
Page({

  data: {
    list: [],
    imghost: config.host + "upload",
    currOpenId: wx.getStorageSync('user').openid,
    inputuname: "",
    inputupwd: "",
    inputtel: "",
    inputsex:"",
    inputage:""
  },

  onLoad: function (options) {
    this.requestData(this.data.currOpenId);
  },

  et_input_inputuname: function (event) {
    this.setData({ inputuname: event.detail.value })
  },

  et_input_inputupwd: function (event) {
    this.setData({ inputupwd: event.detail.value })
  },

  et_input_inputtel: function (event) {
    this.setData({ inputtel: event.detail.value })
  },

  et_input_inputusex: function (event) {
    this.setData({ inputsex: event.detail.value })
  },

  et_input_inputage: function (event) {
    this.setData({ inputage: event.detail.value })
  },

  upUserInfoBtn: function () {
    var that = this;
    var inputuname = that.data.inputuname;
    var inputupwd = that.data.inputupwd;
    var inputtel = that.data.inputtel;
    var openid = this.data.currOpenId;
    var inpusex = this.data.inputsex;
    var inpuage = this.data.inputage;

    this.requestDataAddChatopics(openid, inputuname, inputupwd, inputtel, inpusex, inpuage);
  },

  requestDataAddChatopics(openid, inputuname, inputupwd, inputtel, inpusex, inpuage) {
    var that = this;
    wx.request({
      url: config.host + 'MentalhealthTestWechatWeb/UpdateMyOneInfosByOpenidForXiao',
      data: {
        "inputuname": inputuname,
        "inputupwd": inputupwd,
        "inputtel": inputtel,
        "inpusex": inpusex,
        "inpuage": inpuage,
        "openId": openid
      },
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        if (res.data.result) {
          wx.showToast({
            title: '成功',
            icon: 'succes',
            duration: 1000,
            mask: true
          })

          that.onLoad();

        } else {
          wx.showToast({
            title: '失败!',
            duration: 1000,
            mask: true
          })
        }
      }
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