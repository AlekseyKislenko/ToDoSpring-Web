function toDoEntityFunc(){

    this.createEntityUser = function(JSON){
        var id = JSON["id"];
        var username = JSON["username"];
        var password = JSON["password"];
        var authority = JSON["authority"];
        var enabled = JSON["enabled"];
        return new User(id, username, password, authority, enabled);
    };

    this.createEntityTask = function (JSON) {
        var id = JSON["id"];
        var taskText = JSON["taskText"];
        var taskDate = JSON["taskDate"];
        var taskUser = this.createEntityUser(JSON["taskUser"]);
        var taskState = JSON["taskState"];
        var taskAssignee = this.createEntityUser(JSON["taskAssignee"]);
            return new Task(id, taskText, taskDate, taskUser, taskState, taskAssignee);
        };
}
