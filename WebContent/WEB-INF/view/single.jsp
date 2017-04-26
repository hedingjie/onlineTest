<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/4/26
  Time: 下午8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>单选题</title>
</head>
<body>
<h1 align="center">欢迎进入在线考试系统</h1>
<form action="/test.action" method="post">
    <ol id="question">
        <li>
            这是题目这是题目这是题目这是题目这是题目（   ）<br/>
            <input type="radio" name="qId" value="A">选项A<br/>
            <input type="radio" name="qId" value="B">选项B<br/>
            <input type="radio" name="qId" value="C">选项C<br/>
            <input type="radio" name="qId" value="D">选项D<br/>
            <input type="radio" name="qId" value="E">选项E<br/>
            <input type="radio" name="qId" value="F">选项F<br/>
        </li>
    </ol>
    <input type="submit" value="提交">
</form>
</body>
</html>
