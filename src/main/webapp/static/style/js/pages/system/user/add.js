$(function () {
    $('.skin-minimal input').iCheck({
        checkboxClass: 'icheckbox_flat-green',
        radioClass: 'iradio_flat-green',
        increaseArea: '20%'
    });
});

$("#form-member-add").validate({
    rules: {
        fullname: {
            required: true,
        },
        idnumber: {
            required: true,
            isIdCardNo: true,
            remote: {
                url: baselocation + "/user/idnumber/validate",
                type: "post",
                data: {
                    idnumber: function () {
                        return $("#idnumber").val();
                    },
                },
                dataType: "html",
                dataFilter: function (data, type) {
                    if (data == "true") {
                        return true;
                    } else {
                        return false;
                    }
                }
            },
        },
        email: {
            required: true,
            email: true,
        },
        tel: {
            required: true,
            isMobile: true,
        },
        province: {
            required: true,
        },
        city: {
            required: true,
        },
        county: {
            required: true,
        },
        nation: {
            required: true,
        },
        political: {
            required: true,
        },
        roleid: {
            required: true,
        },
    },
    onkeyup: false,
    focusCleanup: true,
    success: "valid",
    submitHandler: function (form) {
        $(form).ajaxSubmit({
            type: "post",
            url: baselocation + "/user/addUpdate",
            data: $(form).serialize(),
            dataType: "json",
            success: function (data) {
                if (data.retcode == 0) {
                    showFailMessage(data.retmsg);
                    parent.showFailMessage(data.retmsg);
                } else {
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引,隐藏layer层和shade
                    parent.$('#layui-layer' + index).css({'display': 'none'});
                    parent.$('#layui-layer-shade' + index).css({'display': 'none'});
                    parent.reloadTable(); //再刷新DT
                    parent.showSuccessMessage("添加成功", null, function () {
                        parent.layer.close(index); //然后执行关闭
                    });
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
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


function getProvince(a) {
    var province = $("#province").val();
    var level = $(a).find(":selected").attr("data-level");
    level = parseInt(level) + 1;
    $.ajax({
        type: "post",
        url: baselocation + "/areas/getAreasByPid",
        data: "pid=" + province + "&level=" + level,
        success: function (msg) {
            //存到文本域方便职位的级联操作
            $("#list").val(msg);
           // var list = eval("(" + msg + ")");
            var html = "";
            for (var i = 0; i < msg.length; i++) {
                html += "<option value='" + msg[i].number + "' data-level='" + msg[i].level + "'>" + msg[i].name + "</option>";
            }
            $("#city").html(html);
        }
    });
}

function getCity(a) {
    var city = $("#city").val();
    var level = $(a).find(":selected").attr("data-level");
    level = parseInt(level) + 1;
    $.ajax({
        type: "post",
        url: baselocation + "/areas/getAreasByPid",
        data: "pid=" + city + "&level=" + level,
        success: function (msg) {
            //存到文本域方便职位的级联操作
            $("#list").val(msg);
            // var list = eval("(" + msg + ")");
            var html = "";
            for (var i = 0; i < msg.length; i++) {
                html += "<option value='" + msg[i].number + "' data-level='" + msg[i].level + "'>" + msg[i].name + "</option>";
            }
            $("#county").html(html);
        }
    });
}