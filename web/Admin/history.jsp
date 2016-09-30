<<<<<<< Updated upstream
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../style.css">

<html>
<head>
    <title>Operation history</title>
</head>
<body>
<div class="flex-container">
    <header>
        <h1>You are logged in as, Mr. <s:property value="username"/>.
            Your network id = <s:property value="networkId"/><br>Operation History:
        </h1>
    <header/>

    <nav class="nav">
            <li><a href="requests.action">View requests</a> </li>
            <li><a href="/user/info">My credentials</a></li></li>
            <li> <a href="pharmacists.action">Pharmacists</a></li>
            <li> <a href="welcome.action">Dashboard</a></li>
            <li> <a href="logout.action">logout</a></li>
    </nav>

    <article class="article">
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
    </article>
    <footer>
         <p id="copyright">Copyright 2016, Loosers inc.</p>
    </footer>

</div>
</body>
</html>
=======
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
</body>
</html>
>>>>>>> Stashed changes
