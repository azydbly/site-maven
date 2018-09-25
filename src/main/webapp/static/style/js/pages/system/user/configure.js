var setting = {
    check: {
        enable: true
    },
    data: {
        simpleData: {
            enable: true
        }
    }
};

$(document).ready(function(){
    $.ajax({
        type: "post",
        url: baselocation + "/areas/getAreas",
        success: function (msg) {
            $.fn.zTree.init($("#treeRegion"), setting, msg);
        }
    });
});

