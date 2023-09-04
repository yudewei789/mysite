<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  这个样配置，index可以直接访问<%= new Date().toLocaleString()%><br/>
  <img src="img.png" style="height: 300px">
</body>
</html>
