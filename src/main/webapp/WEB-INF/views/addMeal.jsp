<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Table V04</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" type="image/png" href="<c:url value="/resources/images/icons/favicon.ico"/>"/>
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/animate/animate.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/select2/select2.min.css"/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/resources/vendor/perfect-scrollbar/perfect-scrollbar.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/util.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>"/>
</head>
<style>
    .lastButton {
        width: 100%;
        padding: 10px 0;
        margin: 10px auto;
        border-radius: 5px;
        border: none;
        background: #8ebf42;
        font-size: 14px;
        font-weight: 600;
        color: #fff;
    }
</style>
<body>

<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100 ver1 m-b-110">
                <div class="table100-head">
                    <table>
                        <thead>
                        <tr class="row100 head">
                            <th class="cell100 column1">Name of Dish</th>
                            <th class="cell100 column2">Description</th>
                            <th class="cell100 column3">Calories</th>
                            <th class="cell100 column4">Price</th>
                            <th class="cell100 column5">Category</th>
                        </tr>
                        </thead>
                    </table>
                </div>

                    <div class="table100-body js-pscroll">
                        <table>
                            <tbody>

                            <c:forEach items="${dishes}" var="dish">
                            <tr class="row100 body">

                                <td class="cell100 column1">${dish.nameOfDish}</td>
                                <td class="cell100 column2">${dish.description}</td>
                                <td class="cell100 column3">${dish.calories} kcal</td>
                                <td class="cell100 column4">${dish.price} zł</td>
                                <td class="cell100 column5">${dish.category}</td>

                                    <td>
                                        <form method="post" action="/api/order/add/${dish.id}">
                                            <button style="padding-right: 30px" type="submit">Add</button>
                                        </form>
                                    </td>
                                </c:forEach>

                            </tr>

                            </tbody>
                        </table>

<%--                </form>--%>
            </div>
        </div>


    </div>
</div>
</div>

<form method="get" action="/api/order/orderReady">
<button class="lastButton" type="submit" href="/api/order/orderReady">Order it! and look what you got!</button>
</form>

<script src="/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="/resources/vendor/bootstrap/js/popper.js"></script>
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/vendor/select2/select2.min.js"></script>
<script src="/resources/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    $('.js-pscroll').each(function () {
        var ps = new PerfectScrollbar(this);

        $(window).on('resize', function () {
            ps.update();
        })
    });


</script>
<script src="/resources/js/main.js"></script>

</body>
</html>