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
    var zNodes;
    $.ajax({
        type: "post",
        url: baselocation + "/xst/areas/getAreas",
        success: function (msg) {
            zNodes = msg;
            $.fn.zTree.init($("#treeJurisdiction"), setting, zNodes);
        }
    });
});