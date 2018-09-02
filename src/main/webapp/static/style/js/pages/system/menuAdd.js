$("#form-member-add").validate({
    rules:{
        menuname:{
            required:true,
            remote:{
                url: baselocation + "/menu/menuname/validate",
                type:"post",
                data: {
                    menuname: function(){
                        return $("#menuname").val();
                    },
                },
                dataType: "html",
                dataFilter: function(data, type) {
                    if (data == "true"){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        },
        url:{
            remote:{
                url: baselocation + "/menu/url/validate",
                type:"post",
                data: {
                    url: function(){
                        return $("#url").val();
                    },
                },
                dataType: "html",
                dataFilter: function(data, type) {
                    if (data == "true"){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        },
    },
    onkeyup:false,
    focusCleanup:true,
    success:"valid",
    submitHandler:function(form){
        $(form).ajaxSubmit({
            type: "post",
            url: baselocation + "/menu/addUpdate",
            data: $(form).serialize(),
            dataType: "json",
            success: function(data) {
                alert(data.retcode);
                if(data.retcode == 0) {
                    showFailMessage(data.retmsg);
                    parent.showFailMessage(data.retmsg);
                }else{
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引,隐藏layer层和shade
                    parent.$('#layui-layer'+index).css({'display':'none'});
                    parent.$('#layui-layer-shade'+index).css({'display':'none'});
                    parent.reloadTable(); //再刷新DT
                    parent.showSuccessMessage("添加成功", null, function() {
                        parent.layer.close(index); //然后执行关闭
                    });
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                layer.alert(errorThrown + '服务器端异常', {
                    closeBtn: 1,    // 是否显示关闭按钮
                    anim: 1, //动画类型
                    btn: ['确定'], //按钮
                    icon: 5,    // icon
                });
                return false;
            }
        });
    }
});