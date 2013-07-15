var ToDoModel = function () {
    var tasksNotReady = [];
    var tasksReady = [];

    var notifyController = function () {
        $('body').trigger('updateView');
    };
    // methods
    return  {
        addTodo: function (todo) {
            tasksNotReady.push(todo);
            notifyController();
        },
        editTodo: function (index, newTodo) {
            tasksNotReady[index] = newTodo;
            notifyController();
        },
        deleteTodo: function (index) {
            tasksNotReady.splice(index, 1);
            notifyController();
        },
        getDataNotReady: function () {
            return tasksNotReady;
        },
        getDataReady: function () {
            return tasksReady;
        },
        moveDataDown: function (todoNReady, index) {
            tasksReady.push(todoNReady);
            tasksNotReady.splice(index, 1)
            notifyController();
        },
        moveDataUp: function (todoReady, index) {
            tasksNotReady.push(todoReady);
            tasksReady.splice(index, 1)
            notifyController();
        },
        deleteAllReady: function(){
            tasksReady = [];
            notifyController();
        }
    };
};





