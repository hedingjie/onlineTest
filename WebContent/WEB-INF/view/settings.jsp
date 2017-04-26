<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/4/25
  Time: 下午8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线考试系统</title>
</head>
<body>
<form action="test.action" method="get">
    <table align="center">
        <tr>
            <td>考试题型：</td>
            <td>
                <ul>
                    <li><input type="radio" name="type" value="0">单选题</li>
                    <li><input type="radio" name="type" value="0">多选题</li>
                    <li><input type="radio" name="type" value="0">判断题</li>
                </ul>
            </td>
        </tr>
        <tr>
            <td>考题数目：</td>
            <td><input type="text" name="num" value="10"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="开始考试"></td>
            <td></td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
