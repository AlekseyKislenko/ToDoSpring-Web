function toDoEntityFunc(){
    this.createEntityUser = function(JSON){
        var login = JSON["login"];
        var password = JSON["password"];
        return new User(login, password);
    };
}