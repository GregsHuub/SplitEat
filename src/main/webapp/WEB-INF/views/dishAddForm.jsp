<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order form</title>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>

    <style>
        html, body {
            height: 100%;
        }
        body, input, select {
            padding: 0;
            margin: 0;
            outline: none;
            font-family: Roboto, Arial, sans-serif;
            font-size: 16px;
            color: #eee;
        }
        h1, h3 {
            font-weight: 400;
        }
        h1 {
            font-size: 32px;
        }
        h3 {
            color: #1c87c9;
        }
        .main-block, .info {
            display: flex;
            flex-direction: column;
        }
        .main-block {
            justify-content: center;
            align-items: center;
            width: 100%;
            min-height: 100%;
            background: url("https://cdn.vox-cdn.com/thumbor/dW3P3MttdEHLG4ECQQvnhTlFQog=/0x0:1162x630/1220x813/filters:focal(417x201:601x385):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/60395473/food_emoji.0.jpg") no-repeat center;
            background-size: cover;
        }
        form {
            width: 80%;
            padding: 25px;
            margin-bottom: 20px;
            background: rgba(0, 0, 0, 0.9);
        }
        input, select {
            padding: 5px;
            margin-bottom: 20px;
            background: transparent;
            border: none;
            border-bottom: 1px solid #eee;
        }
        input::placeholder {
            color: #eee;
        }
        option {
            background: black;
            border: none;
        }
        .metod {
            display: flex;
        }
        input[type=radio] {
            display: none;
        }
        label.radio {
            position: relative;
            display: inline-block;
            margin-right: 20px;
            text-indent: 32px;
            cursor: pointer;
        }
        label.radio:before {
            content: "";
            position: absolute;
            top: -1px;
            left: 0;
            width: 17px;
            height: 17px;
            border-radius: 50%;
            border: 2px solid #1c87c9;
        }
        label.radio:after {
            content: "";
            position: absolute;
            width: 8px;
            height: 4px;
            top: 5px;
            left: 5px;
            border-bottom: 3px solid #1c87c9;
            border-left: 3px solid #1c87c9;
            transform: rotate(-45deg);
            opacity: 0;
        }
        input[type=radio]:checked + label:after {
            opacity: 1;
        }
        button {
            display: block;
            width: 200px;
            padding: 10px;
            margin: 20px auto 0;
            border: none;
            border-radius: 5px;
            background: #1c87c9;
            font-size: 14px;
            font-weight: 600;
            color: #fff;
        }
        button:hover {
            background: #095484;
        }
        @media (min-width: 568px) {
            .info {
                flex-flow: row wrap;
                justify-content: space-between;
            }
            input {
                width: 46%;
            }
            input.fname {
                width: 100%;
            }
            select {
                width: 48%;
            }
        }
        /*button:focus {*/
        /*    outline: 0;*/
        /*}*/
        /*body {*/
        /*    background: url("https://previews.123rf.com/images/weedezign/weedezign1508/weedezign150800268/44444122-finger-click-screen-with-order-food-online-word-with-keyboard-on-wooden-table-food-business-design-c.jpg") center;*/
        /*}*/

        .navbar .dropdown-menu .form-control {
            width: 200px;
        }
        .logged {
            padding-left: 100px;
            color: white;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
    <div class="container">
        <a class="navbar-brand" href="/mainPageAfterLogin">SplitEat</a>
        <button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
            &#9776;
        </button>
        <div class="collapse navbar-collapse" id="exCollapsingNavbar">
            <ul class="nav navbar-nav">
                <li class="nav-item"><a href="https://www.theworlds50best.com/about" class="nav-link">About</a></li>
                <li class="nav-item"><a href="/api/dish/list" class="nav-link">Meals list</a></li>
                <li class="nav-item"><a href="/api/dish/addForm" class="nav-link">Add your own meal!</a></li>
                <li class="nav-item"><a href="/api/user/addForm" class="nav-link">Add new User</a></li>
                <li class="nav-item"><a href="/api/order/form" class="nav-link">Create order</a></li>
                <li class="logged" class="nav-item"><a href="#" class="nav-link">Witaj <sec:authentication property="principal.username"/></a></li>
            </ul>
            <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                <li class="nav-item order-2 order-md-1"><a href="#" class="nav-link" title="settings"><i class="fa fa-cog fa-fw fa-lg"></i></a></li>
                <li class="dropdown order-1">
                    <button type="button" id="dropdownMenu1" data-toggle="dropdown" class="btn btn-outline-secondary dropdown-toggle">I want to quit!<span class="caret"></span></button>
                    <ul class="dropdown-menu dropdown-menu-right mt-2">
                        <li class="px-3 py-2">
                            <form action="<c:url value="/logout"/>" method="post">
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">Logout</button>
                                </div>
                            </form>
                        </li>
                    </ul>
                </li>
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
<div class="main-block">
    <h1 style="color: #e0a800; font-size: 45px;">Add receipe to Database</h1>
    <form:form method="post" action="./saveForm" modelAttribute="dishDto">
        <div class="info">
            <form:input path="nameOfDish" type="text" name="nameOfDish" placeholder="Name of Dish" />
            <form:input path="description" type="text" name="description" placeholder="Description"/>
            <form:input path="category" type="text" name="categories" placeholder="Category: 1-FastFood, 2-VegeFood, 3-Domowe" />
            <form:input path="calories" type="text" name="calories" placeholder="Calories :)"/>
            <form:input path="price" type="text" name="price" placeholder="Price $$$"/>
        </div>
        <button type="submit" >Save receipe</button>
    </form:form>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
