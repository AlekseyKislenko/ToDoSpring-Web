var ToDoController = function (view, model) {

    var _view = view;
    var _model = model;
    var body = "body";

    // event binding
    $(body).bind('addItem', function (e) {
        _model.addTodo(e.todo);
    });
    $(body).bind('deleteItem', function (e) {
        _model.deleteTodo(e.index);
    });
    $(body).bind('updateView', function () {
        _view.updateView(_model.getDataNotReady(), _model.getDataReady());
    });
    $(body).bind('editItem', function (e) {
        _model.editTodo(e.index, e.todo);
    });
    $(body).bind('moveItemDown', function (e) {
        _model.moveDataDown(e.todo, e.index);
    });
    $(body).bind('moveItemUp', function (e) {
        _model.moveDataUp(e.todo, e.index);
    });
    $(body).bind('deleteAllReadyItem', function (e) {
        _model.deleteAllReady();
    });

    // methods
    return  {
    };
};





