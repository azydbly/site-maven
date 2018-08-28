<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.InetAddress"%>
<html>
<head>
    <title>我的桌面</title>
</head>
<body>
<div class="page-container">
    <div class="panel panel-default-skin" style="width: 20%; margin: 20px 0px 20px 0px ">
        <div class="panel-header">个人信息</div>
        <div class="panel-body">
            <table class="table">
                <tbody>
                    <tr class="active">
                        <td class="right">用户名：</td>
                        <td>${loginUser.fullname }</td>
                    </tr>
                    <tr>
                        <td>角色：</td>
                        <td>${loginUser.roleid }</td>
                    </tr>
                    <tr class="active">
                        <td>电子邮箱：</td>
                        <td>${loginUser.email }</td>
                    </tr>
                    <tr>
                        <td>最后登录时间：</td>
                        <td>${loginUser.loginTime }</td>
                    </tr>
                    <tr class="active">
                        <td>最后登录IP：</td>
                        <td>${loginUser.loginIp }</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <table class="table table-border table-bordered mt-20 table-bg-skin">
        <thead>
            <tr>
                <th colspan="2" scope="col">服务器信息</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td width="30%">服务器计算机名</td>
                <td><%=System.getenv().get("USERDOMAIN")%></td>
            </tr>
            <tr>
                <td>服务器IP地址</td>
                <td><%=InetAddress.getLocalHost().getHostAddress()%></td>
            </tr>
            <tr>
                <td>服务器域名</td>
                <td>${pageContext.request.serverName}</td>
            </tr>
            <tr>
                <td>服务器端口 </td>
                <td><%=request.getServerPort() %></td>
            </tr>
            <tr>
                <td>运行环境版本 </td>
                <td><%=System.getProperty("java.class.version")%></td>
            </tr>
            <tr>
                <td>JDK路径</td>
                <td><%=System.getProperty("java.home")%></td>
            </tr>
            <tr>
                <td>Tomcat的地址 </td>
                <td><%=System.getProperty("user.dir")%></td>
            </tr>
            <tr>
                <td>服务器操作系统 </td>
                <td><%=System.getProperty("os.name")%></td>
            </tr>
            <tr>
                <td>操作系统架构 </td>
                <td><%=System.getProperty("os.arch")%></td>
            </tr>
            <tr>
                <td>操作系统版本</td>
                <td><%=System.getProperty("os.version")%></td>
            </tr>
            <tr>
                <td>浏览器的版本号、类型</td>
                <td><%=request.getHeader("User-agent") %></td>
            </tr>
            <tr>
                <td>当前SessionID </td>
                <td><%=request.getSession().hashCode()%></td>
            </tr>
            <tr>
                <td>当前系统用户名 </td>
                <td><%=System.getProperty("user.name")%></td>
            </tr>
        </tbody>
    </table>
</div>
<footer class="footer mt-20">
    <div class="container">
        <!-- <p>联系方式:
            <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=614749555&site=qq&menu=yes">
                <img border="0" src="http://wpa.qq.com/pa?p=2:614749555:51" alt="点击这里给我发消息" title="点击这里给我发消息"/>
            </a>
        </p> -->
        <p>维护信息：<a href="http://www.baidu.com" target="_blank">****有限公司</a></p>
    </div>
</footer>
</body>
</html>
