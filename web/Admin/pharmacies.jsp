<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Drugs</title>
</head>
<body>
<h1>All Pharmacies in your network, Mr. <s:property value="username"/>.
Your network id = <s:property value="networkId"/>
</h1>
<s:if test="list.size() > 0">
    <div>
        <table cellpadding="5px" border="1">
            <tr>
                <th>Number</th>
                <th>Pharmacist</th>
                <th>Address</th>
            </tr>

            <s:iterator value="list">
                <tr>
                    <td><s:property value="number"/></td>
                    <td><s:property value="pharcistId"/></td>
                    <td><s:property value="address"/></td>
                    <td><s:url id="deleteURL" action="">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{deleteURL}" onclick="return confirm('Are you sure?')">Delete</s:a></td>

                    <td><s:url id="histURL" action="">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{histURL}">Operation history</s:a></td>

                    <td><s:url id="contentURL" action="">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{histURL}">View Stock Content</s:a></td>

                    <td><s:url id="editURL" action="">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{editURL}">Edit address</s:a></td>
                </tr>
            </s:iterator>
        </table>
        <a href="/admin/createph.action">Create New</a>
    </div>
</s:if>
</body>
</html>