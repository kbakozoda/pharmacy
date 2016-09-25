<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Requests to God</title>
</head>
<body>
<h1>Requests to your Majesty, Admin of all admins</h1> <br>

<s:if test="reqList.size() > 0">
    <div>
        <table cellpadding="5px" border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Network id</th>
                <th>Username</th>
            </tr>

            <s:iterator value="reqList">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="name"/></td>
                    <td><s:property value="surname"/></td>
                    <td><s:property value="networkId"/></td>
                    <td><s:property value="username"/></td>
                    <td> <s:url id="approveURL" action="approve">
                        <s:param name="id" value="%{id}"></s:param>
                    </s:url>
                    <s:a href="%{approveURL}">Approve</s:a>
                    </td>
                    <td>
                        <s:url id="declineURL" action="decline">
                            <s:param name="id" value="%{id}"></s:param>
                        </s:url>
                        <s:a href="%{declineURL}">Decline</s:a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </div>
</s:if>
<s:if test="reqList.size() = 0">
    <h1>The list is empty yet.</h1>
</s:if>
<s:actionerror/>
</body>
</html>
