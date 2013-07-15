function toDoEntityFunc(){

    this.createEntityUser = function(JSON){
        var username = JSON["username"];
        var password = JSON["password"];
        var authority = JSON["authority"];
        var enabled = JSON["enabled"];
        return new User(username, password, authority, enabled)
    };
}