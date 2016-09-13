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
                    <td><a href="#">Delete</a></td>
                    <td><a href="#">Edit</a></td>
                    <td><a href="#">Info</a></td>
                </tr>
            </s:iterator>
        </table>
        <a href="#">Create New</a>
    </div>
</s:if>
</body>
</html>
