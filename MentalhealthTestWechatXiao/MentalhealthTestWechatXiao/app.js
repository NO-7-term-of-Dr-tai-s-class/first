 //app.js
App({
  onLaunch: function () { 
    var that = this
    var user = wx.getStorageSync('user') || {};
    var userInfo = wx.getStorageSync('userInfo') || {};
    if ((!user.openid || (user.expires_in || Date.now()) < (Date.now() + 600)) && (!userInfo.nickName)) {
      wx.login({
        success: function (res) {
          if (res.code) {
            wx.getUserInfo({
              success: function (res) {
                var objz = {}; 

                objz.avatarUrl = res.userInfo.avatarUrl;
                objz.nickName = res.userInfo.nickName;
                objz.province = res.userInfo.province;
                objz.city = res.userInfo.city;

                //console.log(objz);
                wx.setStorageSync('userInfo', objz);//存储userInfo
              }
            });
            var d = that.globalData;//这里存储了appid、secret、token串  
            var l = 'https://api.weixin.qq.com/sns/jscode2session?appid=' + d.appid + '&secret=' + d.secret + '&js_code=' + res.code + '&grant_type=authorization_code';
            wx.request({
              url: l,
              data: {},
              method: 'GET',  
              success: function (res) {
                var obj = {};
                obj.openid = res.data.openid;
                obj.expires_in = Date.now() + res.data.expires_in;
                wx.setStorageSync('user', obj);//存储openid  
                console.log("sfd");
              }
            });
          } else {
            console.log('获取用户登录态失败！' + res.errMsg)
          }
        }
      });
    }
  },

  globalData: {
    appid: 'wxd58a3704e50b4e49',//appid需自己提供，此处的appid我随机编写
    secret: 'd39b48d4adeb3ab257e85e4cb926e99f',//secret需自己提供，此处的secret我随机编写
    userInfo: null,
    urlPath: "",
    openid: ''
  }
})  