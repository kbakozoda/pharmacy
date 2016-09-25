<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operation history</title>

</head>
<body>
<h1>You are logged in as, Mr. <s:property value="username"/>.
    Your network id = <s:property value="networkId"/><br>Operation History:
</h1>
<s:if test="hslist.size() > 0">
    <div>
        <table cellpadding="5px" border="1">
            <tr>
                <th>Date</th>
                <th>Expense in $</th>
                <th>Drug ID</th>
            </tr>

            <s:iterator value="hslist">
                <tr>
                    <td><s:date name="date" format="dd/MM/yyyy"/></td>
                    <td><s:property value="totalExpense"/></td>
                    <td><s:property value="drugId"/></td>
                </tr>
            </s:iterator>
        </table>
        <a href="/admin/pharmacies.action">Back</a>
    </div>
</s:if>
<s:if test="hslist.size() = 0">
    <h1>The list is empty yet.</h1>
</s:if>
<s:actionerror/>
</body>
</html>
