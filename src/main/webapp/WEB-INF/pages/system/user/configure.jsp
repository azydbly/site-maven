<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/layouts/ztree.jsp" %>
<html>
<head>
    <title>用户配置数据</title>
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

        $(document).ready(function(){
            $.ajax({
                type: "post",
                url: baselocation + "/areas/getAreas",
                success: function (msg) {
                    $.fn.zTree.init($("#treeRegion"), setting, msg);
                }
            });
        });
    </script>
</head>
<body>
<div class="content_wrap">
    <form class="form form-horizontal" id="form-member-add">
        <div class="zTreeDemoBackground left">
            <ul id="treeRegion" class="ztree"></ul>
        </div>
        <div class="hide-ztree">
            <input type="submit" value="提交">
        </div>
    </form>
</div>
</body>
</html>