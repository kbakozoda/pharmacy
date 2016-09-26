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
                <th>Drug</th>
                <th>Cost</th>
                <th>Amount</th>
                <th>INDeX</th>
            </tr>

            <s:iterator value="listwithnames" status="stat">
                <tr>
                    <td><s:property value="key"/></td>
                    <td><s:number name="value.priceOfSingle"/></td>
                    <td><s:property value="value.amount"/></td>

                    <td>
                        <s:url id="deleteURL" action="">
                        <s:param name="id" value="%{value.id}"></s:param>
                        </s:url>
                        <s:a href="%{deleteURL}" onclick="return confirm('Are you sure?')">Delete</s:a>
                    </td>
                    <td>
                        <s:url id="editURL" action="">
                        <s:param name="id" value="%{value.id}"></s:param>
                        </s:url>
                        <s:a href="%{editURL}">Edit</s:a>
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
</body>
</html>

