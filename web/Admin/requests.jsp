<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Requests</title>
</head>
<body>
<h1>Requests for registration</h1> <br>

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
<a href="/admin/welcome.action">Menu</a>
</body>
</html>

