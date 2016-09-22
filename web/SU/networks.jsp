<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.09.2016
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Networks</title>
</head>
<body>
<h1>Pharmacy Networks</h1> <br>
<s:if test="list.size() > 0">
    <div>
        <table cellpadding="5px" border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>AdminId</th>
            </tr>

            <s:iterator value="list">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:property value="adminId"/></td>
                    <td><s:url id="deleteURL" action="delnetwork">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{deleteURL}" onclick="return confirm('Are you sure?')">Delete</s:a></td>
                    <td><s:url id="editURL" action="editnetwork">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{editURL}">Edit</s:a></td>
                </tr>
            </s:iterator>
        </table>
        <a href="/superuser/createnet.action">Create New</a>
    </div>
</s:if>
</body>
</html>
