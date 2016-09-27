<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<%@ taglib prefix="t" uri="../WEB-INF/tags/" %>

<html>
<head>
    <title>Operation history</title>
</head>

<t:genericscape>
    <jsp:attribute name="header">
        <h1>You are logged in as, Mr. <s:property value="username"/>.
            Your network id = <s:property value="networkId"/><br>Operation History:
        </h1>
    </jsp:attribute>

    <jsp:attribute name="nav">
            <li><a href="requests.action">View requests</a> </li>
            <li><a href="/user/info">My credentials</a></li></li>
            <li> <a href="pharmacists.action">Pharmacists</a></li>
            <li> <a href="welcome.action">Dashboard</a></li>
            <li> <a href="logout.action">logout</a></li>
    </jsp:attribute>

    <jsp:body>
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
            <s:url id="delURL" action="histRemove">
                <s:param name="id" value="%{phId}"></s:param>
            </s:url>
            <s:a href="%{delURL}">Delete all</s:a>
        </s:if>
        <s:if test="hslist.size() = 0">
            <h1>The list is empty yet.</h1>
        </s:if>

        <s:actionerror/>
    </jsp:body>

    <jsp:attribute name="footer">
         <p id="copyright">Copyright 2016, Loosers inc.</p>
    </jsp:attribute>

</t:genericscape>

<body>





</body>
</html>
