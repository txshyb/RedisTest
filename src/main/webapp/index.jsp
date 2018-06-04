<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/25
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/jquery-1.9.1.js"></script>
    <script type="text/javascript" >
        function click() {
            alert("1");
            console.log("ss");
            /*$.ajax({
                url: "ehcache.do",
                type: "POST",
                async: false,
                dataType: "json",
                success: function (date) {
                    alert(date);
                }
            });*/
        }
    </script>
</head>
<body>
    index
    <button onclick="click()">click</button>



</body>
</html>
