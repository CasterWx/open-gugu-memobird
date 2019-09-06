<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<h1 type="button" class="btn btn-primary btn-lg center-block" style="text-shadow: black 5px 3px 3px;">
    <span class="glyphicon glyphicon-user"></span> GuGu 快来给我写信吧!
</h1>
<%
    request.setCharacterEncoding("utf-8");
%>
<blockquote class="blockquote">
    <p>从前车马很慢，书信很远。
        (服务器那边打印队列有延迟，我收到消息可能是几个小时之后了)</p>
    <footer class="blockquote-footer">公众号:肥宅与画家</footer>
</blockquote>


<form class="center-block" style="margin:5px 50px auto 50px" action="send" onsubmit="return doAlert();" method="post">
    Name:
    <input type="text" class="form-control" placeholder="您的姓名或联系方式" name="name">
    <br>
    Content:
    <textarea class="form-control" rows="6" placeholder="需要发送的内容" name="content"></textarea>
    <br><br>
    <input type="submit" style="margin: 0px auto;display: table;" class="btn btn-primary btn-lg btn-block" value="Submit">
</form>
<%
    if (request.getAttribute("result")!=null){
%>
    <%=request.getAttribute("result")%>
<%
    }
%>

</body>

<script type="text/javascript">
function doAlert() {
    if (document.getElementsByName("name")[0].value == "") {
        alert("姓名不要空着哦！");
        return false ;
    }else if(document.getElementsByName("content")[0].value == ""){
        alert("请输入内容！");
        return false ;
    }else{
        alert("发送完毕！");
        return true ;
    }
}
</script>
</html>
