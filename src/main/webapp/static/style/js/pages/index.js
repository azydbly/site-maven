/*self.opener.location.reload();*/

function logout() {
    layer.confirm('确认要退出吗？',function(index){
        $.ajax({
            url : baselocation + '/xst/admin/logout',
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

$(function(){
    $("#min_title_list li").contextMenu('Huiadminmenu', {
        bindings: {
            'closethis': function(t) {
                console.log(t);
                if(t.find("i")){
                    t.find("i").trigger("click");
                }
            },
            'closeall': function(t) {
                layer.msg('没有更多的标签了！', {time: 2000, icon:5});

            },
        }
    });
});
