<%--
  Created by IntelliJ IDEA.
  User: hanchao
  Date: 2018/1/17
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Object标签使用PDF插件嵌入PDF</title>
    <style>
        .div-left{float:left}
        .div-right{float:right}
    </style>
</head>
<body>
    <div class="div-left">
        <h3>1.标准浏览器</h3>
        <object data="../static/sysfiles/10.pdf" type="application/pdf" width="450" height="300" >
            alt : <a href="../static/sysfiles/10.pdf">test.pdf</a>
        </object>
    </div>
    <div class="div-left">
        <h3>2.IE7.0以上浏览器</h3>
        <object classid="clsid:CA8A9780-280D-11CF-A24D-444553540000" width="450" height="300" border="0">
            <param name="_Version" value="65539">
            <param name="_ExtentX" value="20108">
            <param name="_ExtentY" value="10866">
            <param name="_StockProps" value="0">
            <param name="SRC" value="../static/sysfiles/10.pdf">
            <object data="../static/sysfiles/10.pdf" type="application/pdf" width="450" height="300">
                alt : <a href="../static/sysfiles/10.pdf">test.pdf</a>
            </object>
        </object>
    </div>
    <div class="div-left" style="clear: both">
        <h3>3.IE7.0以下浏览器（方式一）</h3>
        <!--[if IE]>
        <object classid="clsid:CA8A9780-280D-11CF-A24D-444553540000" width="450" height="300" border="0">
            <param name="_Version" value="65539">
            <param name="_ExtentX" value="20108">
            <param name="_ExtentY" value="10866">
            <param name="_StockProps" value="0">
            <param name="SRC" value="../static/sysfiles/10.pdf">
        </object>
        <![endif]-->
        <!--[if !IE]> <!-->
        <object data="../static/sysfiles/10.pdf" type="application/pdf" width="450" height="300">
            alt : <a href='http://get.adobe.com/cn/reader'>Adobe Reader.pdf</a>
        </object>
        <!--<![endif]-->
    </div>
    <div class="div-left">
        <h3>4.IE7.0以下浏览器（方式二）</h3>
        <object classid="clsid:CA8A9780-280D-11CF-A24D-444553540000" width="450" height="300" border="0">
            <param name="_Version" value="65539">
            <param name="_ExtentX" value="20108">
            <param name="_ExtentY" value="10866">
            <param name="_StockProps" value="0">
            <param name="SRC" value="../static/sysfiles/10.pdf">
            <object data="../static/sysfiles/10.pdf" type="application/pdf" width="450" height="300" class="hiddenObjectForIE">
                alt : <a href="../static/sysfiles/10.pdf">test.pdf</a>
            </object>
        </object>
    </div>
</div>
</body>
</html>
