<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Developers</title>
</head>
<body>
    <h1>DEVELOPERS:</h1> <br>
<s:if test="devList.size() > 0">
    <div>
        <table cellpadding="5px">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
            </tr>

            <s:iterator value="devList">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:property value="surname"/></td>
                </tr>
            </s:iterator>
        </table>
    </div>
</s:if>
    <s:if test="list.size() = 0">
        <h1>The list is empty yet.</h1>
    </s:if>
    <s:actionerror/>
</body>
</html>
