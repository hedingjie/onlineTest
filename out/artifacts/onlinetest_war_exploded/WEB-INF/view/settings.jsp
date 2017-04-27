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
    <table align="center" border="1">
        <tr>
            <td>考试题型：</td>
            <td>
                <ul>
                    <li><input type="radio" name="type" value="0">单选题</li>
                    <li><input type="radio" name="type" value="1">多选题</li>
                    <li><input type="radio" name="type" value="2">判断题</li>
                </ul>
            </td>
        </tr>
        <tr>
            <td>考试内容：</td>
            <td>
                <ul>
                    <li><input type="radio" name="content" value="0">内务条令条例</li>
                    <li><input type="radio" name="content" value="1">纪律条令条例</li>
                    <li><input type="radio" name="content" value="2">队列条令条例</li>
                    <li><input type="radio" name="content" value="3">军队基层建设纲要</li>
                    <li><input type="radio" name="content" value="4">军兵种知识</li>
                    <li><input type="radio" name="content" value="5">军事高技术知识</li>
                    <li><input type="radio" name="content" value="6">军事理论导论</li>
                    <li><input type="radio" name="content" value="7">作战基础知识</li>
                    <li><input type="radio" name="content" value="8">训练基础理论</li>
                </ul>
            </td>
        </tr>
        <tr>
            <td>考题数目：</td>
            <td><input type="text" name="num" value="10"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="开始考试">
            </td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
