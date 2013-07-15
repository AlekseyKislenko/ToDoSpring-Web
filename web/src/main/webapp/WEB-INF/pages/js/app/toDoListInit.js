$(document).ready(function () {
    var model = new ToDoModel();
    var view = new ToDoView();
    var controller = new ToDoController(view, model);
});



