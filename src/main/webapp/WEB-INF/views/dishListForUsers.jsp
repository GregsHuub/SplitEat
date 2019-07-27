<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
    <link rel="stylesheet" href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
</head>
<style>
    button:focus {
        outline: 0;
    }
    body {
        background: url("https://www.coho.in/blog/wp-content/uploads/2015/12/Broker-Free-Shared-Apartments-in-Delhi.jpg")center;
    }

    .navbar .dropdown-menu .form-control {
        width: 200px;
    }
</style>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
    <div class="container">
        <a class="navbar-brand" href="/mainPage">SplitEat</a>
        <button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
            &#9776;
        </button>
        <div class="collapse navbar-collapse" id="exCollapsingNavbar">
            <ul class="nav navbar-nav">
                <li class="nav-item"><a href="/api/dish/dishList" class="nav-link">Meals list</a></li>
                <li class="nav-item"><a href="/api/user/addForm" class="nav-link">Create account</a></li>
                <form:form method="get" modelAttribute="makePdf">
                <li class="nav-item"><button class="btn" type="submit"></button></li>
                </form:form>
                <%--                <sec:authorize access=""--%>
                <%--                <li class="nav-item"><a href="#" class="nav-link">Link</a></li>--%>
                <%--                <li class="nav-item"><a href="#" class="nav-link">Service</a></li>--%>
                <%--                <li class="nav-item"><a href="#" class="nav-link">More</a></li>--%>
            </ul>
        </div>
    </div>
</nav>

<div id="modalPassword" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3>Forgot password</h3>
                <button type="button" class="close font-weight-light" data-dismiss="modal" aria-hidden="true">×</button>
            </div>
            <div class="modal-body">
                <p>Reset your password..</p>
            </div>
            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                <button class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

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
                <form:form method="post" action="/list">
                <div class="table100-body js-pscroll">
                    <table>
                        <tbody>
                        <c:forEach items="${dishes}" var="dish">
                        <tr class="row100 body">

<%--                            <td>${dish.id}</td>--%>
                            <td class="cell100 column1">${dish.nameOfDish}</td>
                            <td class="cell100 column2">${dish.description}</td>
                            <td class="cell100 column3">${dish.calories} kcal</td>
                            <td class="cell100 column4">${dish.price} zł</td>
                            <td class="cell100 column5">${dish.category}</td>
                            </c:forEach>
                        </tr>
                        </form:form>

                        </tbody>
                    </table>
                </div>
            </div>


        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


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