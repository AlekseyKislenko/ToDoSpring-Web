function toDoAJAXController() {
    this.createUser = function (user, callback)     {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'},
            url: "/users/create",
            method: "POST",
            data: JSON.stringify(user)
        }).done (function (result) {
            callback(result);
        });
    };

    this.findCurrentUser = function (callback) {
        $.ajax({
            url: "/users/currentUser",
            method: "GET"
        }).done(function (result) {
                callback(result);
            });
    };
}