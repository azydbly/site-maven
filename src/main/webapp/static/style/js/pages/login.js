$(window).load(function(){
    var message  = document.getElementById("message").value;
    if(message != ""){
        $.Modalalert(message,1000);
    }
});

//获取cookie值设置到文本框
function setValue(){
    var namevalue = $("#idnumber").val();
    if(undefined != namevalue && "" != namevalue){
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
    var cookiePassword = $.cookie("password");
    var data;
    var type;
    /**
     *  判断cookie中 password 是否有值
     *  true 判断password input中的值是否跟cookie中password相同，相同密码直接进行比较， type = 0; 不相同使用盐值进行加密验证。type = 1
     *  false cookie中的password 不存在直接使用盐值进行验证
     *  type = 0 表示cookie中有值，并且password input的值与之相同，直接和数据库中的密码值进行计较即可
     *  type = 1 表示cookie中没有值或者password input的值与cookie的值不相同，需要使用盐值进行加密判断
     */
    if(undefined != cookiePassword && "" != cookiePassword){
        if(cookiePassword == password){
            type = 0;
        }else{
            type = 1;
        }
    }
    if(undefined == cookiePassword || "" == cookiePassword){
        type = 1;
    }
    data = "idnumber=" + idnumber + "&password=" + password + "&type=" + type;
    $(".z-loading-wrap").show();
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
                $(".z-loading-wrap").hide();
                //$.Modalalert(req.retmsg,1000);
                layer.msg(req.retmsg, {time: 2000, icon:5});
            }else{
                var remenber = $("#setcheck").is(":checked");
                var cookieName = idnumber + ":userinfo";
                if(remenber){
                    var cookieValue = idnumber + "&" + req.data;
                    //设置cookie值有效期30天
                    $.cookie(cookieName, cookieValue, {expires:30});
                    $.cookie("idnumber", idnumber, {expires:30});
                    $.cookie("password", req.data, {expires:30});
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
            //$.Modalalert('系统异常！',1000);
            layer.msg('系统异常！', {time: 2000, icon:5});
        }
    });
}
// 回车登录实现
$(function (){
    $("#loginForm").keydown(function(e){
        var e = e || event, keycode = e.which || e.keyCode;
        if (keycode == 13) {
            login();
        }
    })
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
