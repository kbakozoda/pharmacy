<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.09.2016
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pharmacists</title>
</head>
<body>
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
</body>
</html>
