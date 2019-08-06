<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <jsp:include page="../fragments/header.jsp" />
<body>
    <c:if test="${requestScope.status}">
        <table class="table table-hover", border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Filling</th>
                    <th>Energy</th>
                    <th colspan="5">Vanilla, Sugar, Fructose, Water, Chocolatetype</th>
                    <th colspan="3">Fats, Proteins, Carbohydrates</th>
                    <th>production</th>
                </tr>
            </thead>
        <c:forEach var="candy" items="${candies}">
            <tbody>
                <tr>
                    <td><c:out value="${candy.id}"/></td>
                    <td><c:out value="${candy.name}"/></td>
                    <td><c:out value="${candy.type}"/></td>
                    <td><c:out value="${candy.filling}"/></td>
                    <td><c:out value="${candy.energy}"/></td>
                    <td><c:out value="${candy.ingredients.vanilla}"/></td>
                    <td><c:out value="${candy.ingredients.sugar}"/></td>
                    <td><c:out value="${candy.ingredients.fructose}"/></td>
                    <td><c:out value="${candy.ingredients.water}"/></td>
                    <td><c:out value="${candy.ingredients.chocolateType}"/></td>
                    <td><c:out value="${candy.value.fats}"/></td>
                    <td><c:out value="${candy.value.proteins}"/></td>
                    <td><c:out value="${candy.value.carbohydrates}"/></td>
                    <td><c:out value="${candy.production}"/></td>
                </tr>
            </tbody>
        </c:forEach>
</table>
    </c:if>
    <c:if test="${!requestScope.status}">
        <h2 style="color:red"> This file is not valid !!! </h2>
        <h3> Please , press XMLParsing label</h3>
    </c:if>
    <jsp:include page="../fragments/footer.jsp" />
</body>
</html>
