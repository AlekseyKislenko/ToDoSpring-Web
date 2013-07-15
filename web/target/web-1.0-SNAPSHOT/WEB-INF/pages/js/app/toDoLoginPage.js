$(document).ready(function () {
      var toDoAJAX = new toDoAJAXController();
      var toDoEntity = new toDoEntityFunc();

    $("#registrationForm").fadeOut(0);
    $("#btn-register").click(function () {
        $("#loginForm").fadeOut(400);
        $("#loginCreate").fadeOut();
        $("#registrationForm").fadeIn(100);
    });

    //activated button btn-enter
    $(document).on("keyup", "#login", function () {
        if ((this.value.trim() != '')) {
            if ($("#password").val() != '') {
                $("#btn-enter").prop('disabled', false);
            }
        } else $("#btn-enter").prop('disabled', true);
    });

    $(document).on("keyup", "#password", function () {
        if ((this.value.trim() != '')) {
            if ($("#login").val() != '') {
                $("#btn-enter").prop('disabled', false);
            }
        } else $("#btn-enter").prop('disabled', true);
    });

    //activated button btn-create
    $(document).on("keyup", "#loginRegistration", function () {
        if ((this.value.trim() != '')) {
            if ($("#passwordRegistration").val() != '') {
                $("#btn-create").prop('disabled', false);
            }
        } else $("#btn-create").prop('disabled', true);
    });

    $(document).on("keyup", "#passwordRegistration", function () {
        if ((this.value.trim() != '')) {
            if ($("#loginRegistration").val() != '') {
                $("#btn-create").prop('disabled', false);
            }
        } else $("#btn-create").prop('disabled', true);
    });

    $(document).on("click", "#btn-create", function () {
        createNewUser();
    });

    function createNewUser() {
        var login = $("#loginRegistration").val();
        var password = $("#passwordRegistration").val();
        var user = new User (login, password);
        console.log("login: " + login);
        console.log("password: " + password);
        toDoEntity.createEntityUser(user);
        toDoAJAX.createUser(user, function(){
            console.log("login: " + user.getLogin());
            console.log("password: " + user.getPassword());
            $("#registrationForm").fadeOut(400);
            $("#loginForm").fadeIn(100);
            $("#loginCreate").fadeIn(100);
        })
    }
});