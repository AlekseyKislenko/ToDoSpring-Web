<!DOCTYPE html>
<html>
<head>
    <title>To-Do List Aleksey Kislenko</title>
    <link rel="stylesheet" href="pages/css/bootstrap-responsive.min.css" type="text/css"/>
    <link rel="stylesheet" href="pages/css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="pages/css/app/basestyles.css" type="text/css"/>
</head>
<body>
<header>
    <h2>To-Do List</h2>
    <script src="pages/js/lib/jquery-1.9.1.min.js"></script>
    <script src="pages/js/app/toDoView.js"></script>
    <script src="pages/js/app/toDoController.js"></script>
    <script src="pages/js/app/toDoListModel.js"></script>
    <script src="pages/js/app/toDoListInit.js"></script>
</header>
<div class="container">
    <div class="row">
        <div class="well form-inline">
            <label for="new-todo">Tasks:</label>
            <i class="icon-tasks"></i>
            <textarea type="text" class="span8" id="new-todo" placeholder="Enter new task here"></textarea>
            <input type="text" class="span2" id="assignee" placeholder="Assignee.."></textarea>
            <button class="btn" id="btn-add" disabled><i class="icon-plus-sign"></i> Add</button>
        </div>
    </div>
    <div class="row">
        <div class="span8">
            <ol id="list-not-ready">
            </ol>
        </div>
    </div>
    <div class="row">
        <div class="span8">
            <ul id="list-ready">
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="span4">
            <button class="btn" id="btn-remove-completed" disabled><i class="icon-trash"></i> Remove completed</button>
        </div>
    </div>

</div>
</body>
</html>