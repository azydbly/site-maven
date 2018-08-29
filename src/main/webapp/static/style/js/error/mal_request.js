$(window).load(function(){
    //禁止f5刷新
    document.onkeydown = function (e) {
        var ev = window.event || e;
        var code = ev.keyCode || ev.which;
        if (code == 116) {
            ev.keyCode ? ev.keyCode = 0 : ev.which = 0;
            cancelBubble = true;
            return false;
        }
    }

    //禁止右键菜单
    document.oncontextmenu = function(){return false}

    //防止页面后退
    history.pushState(null, null, document.URL);
    window.addEventListener('popstate', function () {
        history.pushState(null, null, document.URL);
    });

    window.onbeforeunload = function () {
        if(!flag){
            console.log('关闭操作');
        }
        else{
            console.log('刷新操作');
        }
    };
    var loginUser  = document.getElementById("loginUser").value;
    var userId  = document.getElementById("userId").value;
    if(loginUser != ""){
        $(".error-description").html("不好意思，您的访问访问过于频繁~~已被管理员进行拦截，账户锁定，请于10分钟后登录！");
        var data = "idnumber=" + loginUser + "&userId=" + userId;
        $.ajax({
            url : baselocation + '/admin/lock',
            type : "post",
            dataType : "json",
            data: data,
        });
    }else{
        $(".error-description").html("不好意思，您的访问访问过于频繁~~已被管理员进行拦截，请退出浏览器重新打开网站！");
    }

});
