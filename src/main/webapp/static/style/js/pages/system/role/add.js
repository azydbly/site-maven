$(function() {
    $('.skin-minimal input').iCheck({
        checkboxClass: 'icheckbox_flat-green',
        radioClass: 'iradio_flat-green',
        increaseArea: '20%'
    });
});
$("#form-member-add").validate({
    rules:{
        rolename:{
            required:true,
            remote:{
                url: baselocation + "/xst/roles/rolename/validate",
                type:"post",
                data: {
                    rolename: function(){
                        return $("#rolename").val();
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
            url: baselocation + "/xst/roles/addUpdate",
            data: $(form).serialize(),
            dataType: "json",
            success: function(data) {
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