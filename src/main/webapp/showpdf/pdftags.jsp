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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <title>Title</title>
    <script for="window" event="onload">
        window.onload = function () {
            var pdf = document.getElementById('PDFNotKnown');
            if (pdf) {
                document.getElementById('IfNoAcrobat').style.display = 'block';
            } else {
                document.getElementById('IfAcrobat').style.display = 'block';
            }
        }
    </script>
</head>
<body>
<noscript>
    Cannot determine if you have Acrobat Reader (or the full Acrobat) installed <font size="-1">(because JavaScript is unavailable or turned off)</font>.
</noscript>
<div id="IfNoAcrobat" style="display:none;position: absolute; z-index: 99999;">
    <a href="http://get.adobe.com/cn/reader/" target="_blank">你需要先安装Adobe Reader才能正常浏览文件，请点击这里下载Adobe Reader.</a>
</div>
<object type="application/pdf" width=0 height=0 style="display:none">
    <div id="PDFNotKnown" style="display:none">&nbsp;</div>
</object>
<div id=showdiv style="z-index: 0; left:10px; width: 990px; position: absolute; top: -8px; height: 10px">
    <object classid="clsid:CA8A9780-280D-11CF-A24D-444553540000" width="990" height="700" border="0" top="-10" name="pdf">
        <param name="toolbar" value="false">
        <param name="_Version" value="65539">
        <param name="_ExtentX" value="20108">
        <param name="_ExtentY" value="10866">
        <param name="_StockProps" value="0">
        <param name="SRC" value="../static/sysfiles/10.pdf">
    </object>
</div>
</body>
</html>
