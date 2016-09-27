<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<html>
<head>
    <title>Pharmacists</title>
</head>
<body>

<header>Pharmacists</header>
<nav class="nav">
    <ul>
        <li>

        </li>
    </ul>
</nav>

<article class="article">
<s:if test="list.size() > 0">
    <div>
        <table cellpadding="5px" border="1">
            <tr>
                <th>Username</th>
                <th>Name</th>
                <th>Surname</th>
            </tr>

            <s:iterator value="list">
                <tr>
                    <td><s:property value="username"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:property value="surname"/></td>

                    <td><s:url id="delURL" action="phstDel">
                        <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{delURL}">Delete</s:a>
                    </td>

                    <td><s:url id="editURL" action="phstEdit">
                        <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{editURL}">Edit</s:a></td>
                </tr>
            </s:iterator>
        </table>
        <a href="/admin/createPhst.action">Create new</a>
        <a href="/admin/welcome.action">Back</a><br>
    </div>
</s:if>
<s:if test="list.size() = 0">
    <h1>No pharmacists.</h1>
</s:if>
<s:actionerror/>
</article>
<footer id="copyright">Copyright 2016, Loosers inc.</footer>
</body>
</html>
