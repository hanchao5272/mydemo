<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>首页</head>
<body>
<h2>Hello World!</h2>

<a href="showpdf/index.jsp">JSP页面显示PDF</a><br/>
<a href="jspinclude/index.jsp">jsp:include示例</a><br/>
<a href="html/basic001.html">基本HTML</a><br/>
<%--拦截器--%>
<h3>拦截器</h3><hr/>
<a href="/hello">hello</a><br/>

<input type="button" onclick="world()" value="world"/>

<form action="/logout" method="post">
    <input type="submit" value="登出"/>
</form>

</body>
<script type="application/javascript" src="static/js/jquery.js"></script>
<script type="application/javascript">
    function world() {
        $.ajax({
            url:"/world",
            type:"post",
            data:JSON.stringify({
                username:'0001',password:'zhangsan'
            }),
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                alert("hello world!");
                location.href = "/interceptor/hello.jsp";
            },
            error:function (data) {
                if (-1 == data.code){
                    alert(data.message);
                    location.href = "/login.jsp";
                }
            }
        });
    }
</script>
</html>
