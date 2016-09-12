<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Drugs</title>
</head>
<body>
<h1>All drugs</h1> <br>
<s:if test="list.size() > 0">
    <div>
        <table cellpadding="5px" border="1">
            <tr>
                <th>Id</th>
                <th>Type id</th>
                <th>Name</th>
                <th>Instruction</th>
                <th>Age Restriction</th>
            </tr>

            <s:iterator value="list">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="typeId"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:property value="instruction"/></td>
                    <td><s:property value="ageRestrict"/>+</td>
                </tr>
            </s:iterator>
        </table>
    </div>
</s:if>
</body>
</html>
