function logout() {
    layer.confirm('确认要退出吗？',function(index){
        $.ajax({
            url : baselocation + '/admin/logout',
            type : "post",
            dataType : "json",
            success : function(req) {
                if (req.retcode == 1) {
                    window.location.href = baselocation + "/";
                } else {
                    $.Err("退出失败！");
                }
            },
            error : function() {
                $.Err("系统异常！");
            }
        });
    });
}

function druid(){
    window.open(baselocation + "/druid/login.html");
}
