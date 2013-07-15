<!DOCTYPE html>
<html>
<head>
    <title>To-Do List Aleksey Kislenko</title>
    <link rel="stylesheet" href="/pages/css/bootstrap-responsive.min.css" type="text/css"/>
    <link rel="stylesheet" href="/pages/css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="/pages/css/app/basestyles.css" type="text/css"/>
</head>
<body>
<header>
    <h2>Enter to To-Do List</h2>
    <script src="/pages/js/lib/jquery-1.9.1.min.js"></script>
    <script src="/pages/js/app/toDoLoginPage.js"></script>
    <script src="/pages/js/app/toDoEntity.js"></script>
    <script src="/pages/js/app/toDoEntityFunc.js"></script>
    <script src="/pages/js/app/toDoAJAXController.js"></script>

</header>
<div class="container">
    <div class="row span4">
        <div class="well" id="loginForm">
            <p><input type="text" class="span3" id="username" placeholder="Enter your username"><i class="icon-hand-left"></i></p>
            <p><input type="password" class="span3" id="password" placeholder="Enter your password"><i class="icon-hand-left"></i></p>
            <p><button class="btn" id="btn-enter" disabled><i class="icon-ok-sign"></i> Enter</button></p>
        </div>
        <div class="well" id="loginCreate">
        <p><a  id="btn-register"><i class="icon-user"></i> Register a new user</a></p>
        </div>
    </div>
</div>
<div class="container">
    <div class="row span4">
        <div class="well" id="registrationForm">
            <p><input type="text" class="span3" id="loginRegistration" placeholder="Enter your username"><i class="icon-hand-left"></i></p>
            <p><input type="password" class="span3" id="passwordRegistration" placeholder="Enter your password"><i class="icon-hand-left"></i></p>
            <p><button class="btn" id="btn-create" disabled><i class="icon-ok-sign"></i> Create new user</button></p>
        </div>
    </div>
</div>


</body>
</html>