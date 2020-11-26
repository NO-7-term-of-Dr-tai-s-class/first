// pages/mycenter/mycenter.js
var config = require("../../utils/config.js");
Page({

  data: {
    imghost: config.host + "upload",
    currOpenId: wx.getStorageSync('user').openid,
    items:[],
    endindex: 1,
    showView: true,
    showView2: false,
    endtotal: 0,
    changevalue: null,
    checked: false
  }, 

  onLoad: function (options) {
    this.requestData(this.data.endindex);
  },

  radioChange(e) {
    console.log('单选:', e.detail.value)
    this.data.changevalue = e.detail.value;
    this.data.endtotal = parseInt(this.data.endtotal) + parseInt(e.detail.value);//parseInt将数据类型转化为整型

    console.log("最后得分:"+this.data.endtotal)
  },

  nextselftestbtn:function(){

    var checked = this.data.checked;

    if (this.data.changevalue != null){
      var endindex = this.data.endindex + 1;
      if (endindex == 21) {
        this.setData({
          showView: (!this.data.showView)
        })

        this.setData({
          showView2: (!this.data.showView2)
        })
      }

      console.log(endindex);

      this.requestData(endindex);
      this.data.endindex = endindex;

      this.setData({
        "checked": false
      });

      this.setData({
        "changevalue": null
      });

    }else{
      wx.showToast({
        title: '请选择',
        icon: 'succes',
        duration: 1000,
        mask: true
      });
    }

    

  },

  commitselftestbtn(){
    console.log("this.data.endtotal="+this.data.endtotal);

    var that = this;
    wx.request({
      url: config.host + 'MentalhealthTestWechatWeb/AddProfessionalselftestscoresInfoForXiao',
      method: 'post',
      data: {
        scores: this.data.endtotal,
        openId: this.data.currOpenId
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded;charset=utf-8"
      },
      success: function (res) {

        wx.navigateTo({
          url: '/pages/professionalselftestsresults/professionalselftestsresults'
        })

      }
    });

  },
  
  requestData(sindex) {
    var that = this;
    wx.request({
      url: config.host + 'MentalhealthTestWechatWeb/GetSindexProfessionalselftestsInfoForXiao',
      method: 'post',
      data: {
        sindex: sindex
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