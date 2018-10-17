var setting = {
    check: {
        enable: true
    },
    data: {
        simpleData: {
            enable: true
        }
    },
};

$(document).ready(function(){
    var roleid = document.getElementById("roleid").value;
    $.ajax({
        type: "post",
        url: baselocation + "/xst/menu/getZtreeMenu/" + roleid,
        success: function (msg) {
            $.fn.zTree.init($("#treeJurisdiction"), setting, msg);
        }
    });
});