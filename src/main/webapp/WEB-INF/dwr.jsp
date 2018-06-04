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
    <script type='text/javascript' src="/dwr/engine.js"></script>

    <script type="text/javascript" src="/dwr/util.js"></script>
    <script type='text/javascript' src='/dwr/interface/helloService.js'></script>
    <script>
        helloService.send(function (str) {
            console.log(str);
        //    alert(str);
        });
    </script>
    <script type="text/javascript" src="/jquery-1.9.1.js"></script>

    <script type="text/javascript">

        $(function(){

            dwr.engine.setActiveReverseAjax(true);

         //   alert(dwr.util.getValue("a"));
          /*  $("#send").click(function(){

                SendMsg.sendMsg($("#msg").val());

            });*/

        });

    </script>
</head>
<body>
    <button id="send">ggg</button>
<input id="a">

</body>
</html>
