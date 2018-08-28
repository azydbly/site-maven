$(window).load(function(){
    var message  = document.getElementById("message").value;
    if(message != ""){
        $.Modalalert(message,1000);
    }
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
                window.location.href = baselocation + "/admin/success"
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
