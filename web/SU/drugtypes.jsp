<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Drug Types</title>
</head>
<body>
<h1>All existing types</h1> <br>
<s:if test="list.size() > 0">
    <div>
        <table cellpadding="5px" border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>

            <s:iterator value="list">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:url id="deleteURL" action="deletedrugtype">
                        <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{deleteURL}">Delete</s:a></td>
                    <td><s:url id="editURL" action="editdrugtype">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{editURL}">Edit</s:a></td>
                    <td><a href="#">Info</a></td>
                </tr>
            </s:iterator>
        </table>
        <a href="/superuser/newdrugtype.action">Create New</a>
    </div>
</s:if>
</body>
</html>
