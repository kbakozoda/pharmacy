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
                <th>isActive?</th>
            </tr>

            <s:iterator value="list">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:property value="adminId"/></td>
                    <td><s:property value="active"/></td>
                </tr>
            </s:iterator>
        </table>
    </div>
</s:if>
</body>
</html>
