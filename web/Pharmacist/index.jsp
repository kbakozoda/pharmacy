<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock Content</title>

</head>
<body>
<h1>You are logged in as, Mr. <s:property value="username"/>.
    Your pharmacy's id = <s:property value="phId"/> <a href="logout.action">Logout</a>
    <a href="/user/info">My credentials</a>
    <br>Stock content:
</h1>
<s:if test="list.size() > 0">
    <div>
        <table cellpadding="5px" border="1">
            <tr>
                <th>Drug ID</th>
                <th>Cost</th>
                <th>Amount</th>
            </tr>

            <s:iterator value="list">
                <tr>
                    <td><s:number name="drugId"/></td>
                    <td><s:number name="priceOfSingle"/></td>
                    <td><s:number name="amount"/></td>
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

