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
                        <s:a href="%{deleteURL}" onclick="return confirm('Are you sure?')">Delete</s:a></td>
                    <td><s:url id="editURL" action="editdrugtype">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{editURL}">Edit</s:a></td>
                </tr>
            </s:iterator>
        </table>
        <a href="/superuser/newdrugtype.action">Create New</a>
        <a target="_blank" href="typesPDF.action">Generate PDF</a>
        <a target="_blank" href="typesXLS.action">Generate XLS</a>
        <a target="_blank" href="typesCSV.action">Generate CSV</a>
    </div>
</s:if>
<s:if test="list.size() = 0">
    <h1>The list is empty yet.</h1>
</s:if>
<s:actionerror/>
</body>
</html>
