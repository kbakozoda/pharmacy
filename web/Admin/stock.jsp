<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock Content</title>

</head>
<body>
<h1>You are logged in as, Mr. <s:property value="username"/>.
    Your network id = <s:property value="networkId"/><br>Stock content:
</h1>
<s:if test="stlist.size() > 0">
    <div>
        <table cellpadding="5px" border="1">
            <tr>
                <th>Drug ID</th>
                <th>Cost</th>
                <th>Amount</th>
            </tr>

            <s:iterator value="stlist">
                <tr>
                    <td><s:property value="drugId"/></td>
                    <td><s:property value="priceOfSingle"/></td>
                    <td><s:property value="amount"/></td>
                </tr>
            </s:iterator>
        </table>
        <a href="/admin/pharmacies.action">Back</a>
    </div>
</s:if>
<s:if test="stlist.size() = 0">
    <h1>The list is empty yet.</h1>
</s:if>
<s:actionerror/>
</body>
</html>
