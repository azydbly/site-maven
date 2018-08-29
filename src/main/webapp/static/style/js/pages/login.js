$(window).load(function(){
    var message  = document.getElementById("message").value;
    if(message != ""){
        $.Modalalert(message,1000);
    }
});

//获取cookie值设置到文本框
function setValue(){
    var namevalue = $("#idnumber").val();
    if("" != namevalue){
        var cookieName = namevalue + "userinfo";
        var userinfo = $.cookie(cookieName);
        if(undefined != userinfo && "" != userinfo){
            var infos = userinfo.split("&");
            for(var i in infos){
                if(0 == i){
                    $("#idnumber").val(infos[i]);
                }else if(1 == i){
                    $("#password").val(infos[i]);
                }
            }
        }
    }else{
        var idnumber = $.cookie("idnumber");
        if(undefined != idnumber && "" != idnumber){
            $("#idnumber").val(idnumber);
        }
        var password = $.cookie("password");
        if(undefined != password && "" != password){
            $("#password").val(password);
        }
    }
}
setValue();

$("#idnumber").blur(function(){
    setValue();
});


// 用户登录
function login(){
    var idnumber = $("input[name='idnumber']").val();
    if (idnumber.length <= 0) {
        $("input[name='idnumber']").attr("placeholder", "请输入身份证号");
        return false;
    }
    var password = $("input[name='password']").val();
    if (password.length <= 0) {
        $("input[name='password']").attr("placeholder", "请输入密码");
        return false;
    }
    /* if(password.length <= 20){
         password = hex_md5(password);
     }*/
    var data = "idnumber=" + idnumber + "&password=" + password;
    $.ajax({
        url: baselocation + "/admin/login",
        data: data,
        type: "post",
        dataType: "json",
        beforeSend: function(xhr){
            xhr.setRequestHeader("vcode","1");
        },

        success: function(req){
            if(req.retcode == 0){
                $.Modalalert(req.retmsg,1000);
            }else{
                var remenber = $("#setcheck").is(":checked");
                var cookieName = idnumber + ":userinfo";
                if(remenber){
                    var cookieValue = username + "&" + password;
                    //设置cookie值有效期30天
                    $.cookie(cookieName, cookieValue, {expires:30});
                    $.cookie("idnumber", idnumber, {expires:30});
                    $.cookie("password", password, {expires:30});
                }else{
                    $.cookie(cookieName, "");
                    $.cookie("idnumber", "");
                    $.cookie("password", "");
                }
                window.location.href = baselocation + "/admin/welcome"
            }
        },
        error: function(req){
            $(".z-loading-wrap").hide();
           /* $("#vcode").select();
            $("#vimg").attr("src", baselocation + "/getVcode?random=" + Math.random());*/
            $.Modalalert('系统异常！',1000);
        }
    });
}
// 回车登录实现
$(document).keyup(function (event) {
    if (event.keyCode == 13) {
        $(".z-login-btn").trigger("click");
    }
});


//错误信息弹出层
!function($) {
    $.Modalalert = function(info, speed) {
        if ($(".modal-alert").length > 0) {
            $(".modal-alert").remove();
        }
        if (speed == 0 || typeof(speed) == "undefined") {
            $(document.body).append('<div id="modal-alert" class="modal modal-alert radius">' + '<div class="modal-alert-info">' + info + '</div>' + '<div class="modal-footer"> <button class="btn btn-primary radius" onClick="$.Huimodal_alert.hide()">确定</button></div>' + '</div>');
            $("#modal-alert").fadeIn();
        } else {
            $(document.body).append('<div id="modal-alert" class="modal modal-alert radius">' + '<div class="modal-alert-info">' + info + '</div>' + '</div>');
            $("#modal-alert").fadeIn();
            setTimeout($.Modalalert.hide, speed);
        }
    }
    $.Modalalert.hide = function() {
        $("#modal-alert").fadeOut("normal",
            function() {
                $("#modal-alert").remove();
            });
    }
} (window.jQuery);
