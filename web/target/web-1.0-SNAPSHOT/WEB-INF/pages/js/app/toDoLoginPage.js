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
    $(document).on("keyup", "#username", function () {
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


    //createNewUser
    function createNewUser() {
        var id;
        var username = $("#loginRegistration").val();
        var password = $("#passwordRegistration").val();
        var authority = "ROLE_USER";
        var enabled = true;
        var user = new User (id, username, password, authority, enabled);
        console.log("username: " + username);
        console.log("password: " + password);
        console.log("authority: " + authority);
        console.log("enabled: " + enabled);

        toDoEntity.createEntityUser(user);
        toDoAJAX.createUser(user, function(){
            //console.log("userId: " + user.getId());
            console.log("username: " + user.getUsername());
            console.log("password: " + user.getPassword());
            $("#registrationForm").fadeOut(400);
            $("#loginForm").fadeIn(100);
            $("#loginCreate").fadeIn(100);
        })
    }
});