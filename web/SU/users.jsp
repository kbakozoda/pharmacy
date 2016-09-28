<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<html>
<head>
    <title>Users</title>
</head>
<body>
<div class="flex-container">
<header><h1>All users</h1></header>
<nav class="nav">
    <ul>
        <li>
            <a href="welcome.action">Dashboard</a>
        </li>
        <li>
            <a href="/superuser/logout.action">Logout</a>
        </li>
    </ul>
</nav>
<article class="article">
    <s:if test="list.size() > 0">
        <div>
            <table cellpadding="5px" border="1">
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Username</th>
                    <th>Role</th>
                </tr>

                <s:iterator value="list">
                    <tr>
                        <td><s:property value="name"/></td>
                        <td><s:property value="surname"/></td>
                        <td><s:property value="username"/></td>
                        <td><s:property value="role"/></td>
                        <td><s:url id="deleteURL" action="usdelete">
                            <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                            <s:a href="%{deleteURL}" onclick="return confirm('Are you sure?')">Delete</s:a></td>
                        </tr>
                </s:iterator>
            </table>
        </div>
    </s:if>
    <s:if test="list.size() = 0">
        <h1>The list is empty yet.</h1>
    </s:if>
    <s:actionerror/>
</article>
    <footer id="copyright">Copyright 2016, Loosers inc.</footer>
</div>
</body>
</html>
