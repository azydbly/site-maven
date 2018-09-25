<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/layouts/base.jsp" %>
<html>
<head>
    <title>角色配置权限</title>
    <link rel="stylesheet" type="text/css" href="${ctxstc}/styles/ztree/css/zTreeStyle/zTreeStyle.css" />
    <script src="${ctxstc}/styles/ztree/js/jquery.ztree.core.js"></script>
    <script src="${ctxstc}/styles/ztree/js/jquery.ztree.excheck.js"></script>
    <script>
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

        var zNode;
        $.ajax({
            type: "post",
            url: baselocation + "/areas/getAreas",
            success: function (msg) {
                zNode = msg;
                console.log(zNode);
            }
        });

        var zNodes =[
            { id:1, pId:0, name:"随意勾选 1", open:false},
            { id:1, pId:0, name:"随意勾选 1", open:false},
            { id:1, pId:0, name:"随意勾选 1", open:false}
          /*  { id:11, pId:1, name:"随意勾选 1-1", open:false},
            { id:111, pId:11, name:"随意勾选 1-1-1", open:false},
            { id:112, pId:11, name:"随意勾选 1-1-2", open:false},
            { id:12, pId:1, name:"随意勾选 1-2", open:false},
            { id:121, pId:12, name:"随意勾选 1-2-1", open:false},
            { id:122, pId:12, name:"随意勾选 1-2-2", open:false},
            { id:2, pId:0, name:"随意勾选 2", open:false},
            { id:21, pId:2, name:"随意勾选 2-1", open:false},
            { id:22, pId:2, name:"随意勾选 2-2", open:false},
            { id:221, pId:22, name:"随意勾选 2-2-1", open:false},
            { id:222, pId:22, name:"随意勾选 2-2-2", open:false},
            { id:23, pId:2, name:"随意勾选 2-3", open:false}*/
        ];
        console.log(zNodes);

        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting, zNode);

        });
    </script>
</head>
<body>
<div class="content_wrap">
    <div class="zTreeDemoBackground left">
        <ul id="treeDemo" class="ztree"></ul>
    </div>
</div>
</body>
</html>