<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" type="text/css" href="../style.css">

<html>
<head>
    <title>Requests</title>
</head>
<body>
<div class="flex-container">
<header>
    <h1>Requests for registration</h1>
</header>
<nav class="nav">
    <ul>
        <li>
            <a href="/admin/welcome.action">Menu</a>
        </li>
        <li>
            <a href="/admin/logout.action">Logout</a>
        </li>
    </ul>
</nav>
<article class="article">
    <s:if test="list.size() > 0">
        <div>
            <table cellpadding="5px" border="1">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Pharmacy id</th>
                    <th>Username</th>
                </tr>

                <s:iterator value="list">
                    <tr>
                        <td><s:property value="id"/></td>
                        <td><s:property value="name"/></td>
                        <td><s:property value="surname"/></td>
                        <td><s:property value="pharmacyId"/></td>
                        <td><s:property value="username"/></td>
                        <td> <s:url id="approveURL" action="approve">
                            <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                            <s:a href="%{approveURL}">Approve</s:a>
                        </td>
                        <td>
                            <s:url id="declineURL" action="decline">
                                <s:param name="id" value="%{id}"></s:param>
                            </s:url>
                            <s:a href="%{declineURL}">Decline</s:a>
                        </td>
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

<footer id="copyright">
    Copyright 2016, Loosers inc.
</footer>
</div>
</body>
</html>