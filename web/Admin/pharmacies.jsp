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
                    <td><s:property value="pharmacistId"/></td>
                    <td><s:property value="address"/></td>
                    <td><s:url id="deleteURL" action="phdelete">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{deleteURL}" onclick="return confirm('Are you sure?')">Delete</s:a></td>

                    <td><s:url id="histURL" action="history">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{histURL}">Operation history</s:a></td>

                    <td><s:url id="contentURL" action="stock">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{contentURL}">View Stock Content</s:a></td>

                    <td><s:url id="editURL" action="edit">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{editURL}">Edit</s:a></td>

                    <td><s:url id="infoURL" action="info">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                        <s:a href="%{infoURL}">Info</s:a></td>
                </tr>
            </s:iterator>
        </table>
        <a href="/admin/createph.action">Create New</a><br>
        <a href="/admin/welcome">Menu</a>
    </div>
</s:if>
<s:if test="hslist.size() = 0">
    <h1>The list is empty yet.</h1>
</s:if>
<s:actionerror/>
</body>
</html>