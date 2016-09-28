<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Drugs</title>
</head>
<body>
<div class="flex-container">
    <header><h1>All drugs</h1> </header>
    <nav class="nav">
        <ul>
            <li><a href="/superuser/createdrug.action">Create New</a></li>
            <li><a href="/superuser/welcome.action">Dashboard</a> </li>
            <li><a href="/superuser/logout.action">Logout</a> </li>
        </ul>
    </nav>
    <article class="article">
        <s:if test="list.size() > 0">
            <div>
                <table cellpadding="5px" border="1">
                    <tr>
                        <th>Id</th>
                        <th>Type id</th>
                        <th>Name</th>
                        <th>Instruction</th>
                        <th>Age Restriction</th>
                    </tr>

                    <s:iterator value="list">
                        <tr>
                            <td><s:property value="id"/></td>
                            <td><s:property value="typeId"/></td>
                            <td><s:property value="name"/></td>
                            <td><s:property value="instruction"/></td>
                            <td><s:property value="ageRestrict"/>+</td>
                            <td><s:url id="deleteURL" action="deletedrug">
                                <s:param name="id" value="%{id}"></s:param>
                            </s:url>
                                <s:a href="%{deleteURL}" onclick="return confirm('Are you sure?')">Delete</s:a></td>
                            <td><s:url id="editURL" action="drugedit">
                                <s:param name="id" value="%{id}"></s:param>
                            </s:url>
                                <s:a href="%{editURL}">Edit</s:a></td>
                        </tr>
                    </s:iterator>
                </table>

            </div>
        </s:if>
        <s:if test="list.size() = 0">
            <h1>The list is empty yet.</h1>
        </s:if>
        <s:actionerror/>
    </article>
    <footer id="copyright"> Copyright 2016, Loosers inc. </footer>
</div>


</body>
</html>
