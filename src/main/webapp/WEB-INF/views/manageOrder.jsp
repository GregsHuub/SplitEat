<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Your order</title>
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
    <style>
        .approveButton {
            width: 100%;
            padding: 10px 0;
            margin: 10px auto;
            border-radius: 5px;
            border: none;
            background: #8ebf42;
            font-size: 20px;
            font-weight: 600;
            color: #fff;
        }
        .approveButton:hover {
            background: black;
            /*background: #82b534;*/
        }
        .toCopyInput{
            color: white;
            font-size: 1px;
        }
        .buttonDelete{
            color:white;
            border: 1px solid white;
            text-align: center;
        }
    </style>

</head>

<body>

<div class="table100 ver3 m-b-110">
    <div class="table100-head">
        <table>
            <thead>
            <tr class="row100 head">
                <th class="cell100 column1">Your order</th>
                <th class="cell100 column2">Create time</th>
                <th class="cell100 column3">Status</th>
                <th class="cell100 column4">Price</th>
                <th class="cell100 column5">Update time</th>
            </tr>
            </thead>
        </table>
    </div>

    <div class="table100-body js-pscroll">
        <table>
            <tbody>
            <c:forEach items="${orders}" var="order">
                <tr class="row100 body">
                    <td class="cell100 column1">${order.orderContent}</td>
                    <td class="cell100 column2">${order.createdOn}</td>
                    <td class="cell100 column3">${order.statusOfOrder}</td>
                    <td class="cell100 column4">${order.sumValue}</td>
                    <td class="cell100 column5">${order.updatedOn}</td>
                    <td>
                        <form method="post" action="/api/order/delete/${order.id}">
                            <button class="buttonDelete" style="padding-right: 10px" type="submit">Delete</button>
                        </form></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<!-- The button used to copy the text -->
<%--<button class="approveButton" onclick="myFunction()">Click on me! and start share the order with your friends</button>--%>
<%--<input class="toCopyInput" type="text" value="http://localhost:8080/api/order/formFriends" id="myInput">--%>

<%--<script>--%>
<%--    function myFunction() {--%>

<%--        var copyText = document.getElementById("myInput");--%>
<%--        copyText.select();--%>
<%--        document.execCommand("copy");--%>
<%--        alert("Link for your friends is ready :)");--%>
<%--    }--%>
<%--</script>--%>



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