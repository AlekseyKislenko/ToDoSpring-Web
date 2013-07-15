var ToDoView = function () {
    var updateView = function (tasksNReady, tasksReady) {
        var listNReadyId = $("#list-not-ready");
        var listReadyId = $("#list-ready");
        $(listNReadyId).find('li').remove();
        $(listNReadyId).find('a').remove();
        $(listNReadyId).find('p').remove();
        $(listNReadyId).find('input').remove();
        $(listReadyId).find('li').remove();
        $(listReadyId).find('p').remove();
        $(listReadyId).find('input').remove();
        //list #list-not-ready

        var date = new Date().toDateString();
        var author = "Aleksey";

        for (var i = 0, length = tasksNReady.length; i < length; i++) {
            var li = $("<li>" + tasksNReady[i] + "</li>");

            $(listNReadyId).append(li).append("<p>"+"<i class='icon-hand-up'> </i>"+date+" author: "+author+"</p>");


            //hover cb and btn
            (function (i) {
                var checkBox = $("<input id='checkBoxUp' type='checkbox' data-index='" + i + "' />");
                var btnRemove = $("<a class='btn btn-mini' id='del' data-index='" + i + "'><i class='icon-remove'></i> remove</a>");

                $($(listNReadyId).find('li').last()).hover(
                    function () {
                        $(this).append(checkBox).append(btnRemove);
                    },
                    function () {
                        $(this).find("#del").remove();
                        $(this).find("#checkBoxUp").remove();
                    }
                );
            })(i);

            //inline edit
            (function (i) {
                var dataset = $(listNReadyId).find('li').last();
                $(dataset).on("dblclick", function () {
                    var tArea = $("<textarea id='textArea' data-index='" + i + "' type='text'>" + tasksNReady[i] + "</textarea>");
                    var btnSave = $("<button id='save' class='btn btn-small' data-index='" + i + "'><i class='icon-ok'></i> save</button>");
                    dataset.empty();
                    $(dataset).append(tArea).append(btnSave);
                    $(listNReadyId).find("li").mouseover(function () {
                        $(this).find("#del").remove();
                        $(this).find("#checkBoxUp").remove();
                    });
                });
            })(i);
        }

        //list #list-ready
        for (var i = 0, length = tasksReady.length; i < length; i++) {
            var li = $("<li>" + tasksReady[i] + "</li>");

            $(listReadyId).append(li).append("<p>"+date+" author: "+author+"</p>");

            (function(i){
                $($(listReadyId).find('li').last()).hover(
                    function () {
                        var checkBox = $("<input id='checkBoxDown' checked='checked' type='checkbox' data-index='" + i + "'/>");
                        $(this).append(checkBox);
                        $("#btn-remove-completed").prop('disabled', true);
                    },
                    function () {
                        $("#btn-remove-completed").removeAttr('disabled');
                        $(this).find("#checkBoxDown").remove();
                    }
                );
            })(i);
        }
    };

    //set the handlers for the view
    var initView = function () {
        //moveDownList
        $(document).on("click","#checkBoxUp", function (e) {
            var $task = e.currentTarget;
            var event = jQuery.Event("moveItemDown");
            event.index = $($task).attr('data-index');
            var str = $(e.target).parent().get(0).textContent;
            event.todo = (str).substr(0,(str).length-6);
            $('body').trigger(event);
        });

        //moveUpList
        $(document).on("click","#checkBoxDown", function (e) {
            var $task = e.currentTarget;
            var event = jQuery.Event("moveItemUp");
            event.index = $($task).attr('data-index');
            event.todo = $(e.target).parent().get(0).textContent;
            $('body').trigger(event);
        });



        //activated button side by side #new-todo
        $(document).on("keyup", "#new-todo", function(){
            if (this.value.trim() != '') {
                $("#btn-add").removeAttr('disabled');
            } else $("#btn-add").prop('disabled', true);
        });

        //add
        $(document).on("click", "#btn-add", function () {
            $("#btn-add").prop('disabled', true);
            var event = jQuery.Event("addItem");
            var newToDo = ("#new-todo");
            event.todo = $(newToDo)[0].value;
            $('body').trigger(event);
            $(newToDo)[0].value = '';
        });

        //delete
        $(document).on("click", "#del", function (e) {
            var answer = confirm ("Are you sure?")
            if (answer){
                var $task = e.currentTarget;
                var event = jQuery.Event("deleteItem");
                event.index = $($task).attr('data-index');
                $('body').trigger(event);
            }
            else {};
        });

        //deleteAllReady
        $(document).on("click", "#btn-remove-completed", function (e) {
            var event = jQuery.Event("deleteAllReadyItem");
            $('body').trigger(event);
            $("#btn-remove-completed").prop('disabled', true);
        });


        //activated button side by side #edit-todo
        $(document).on("keyup", "#textArea", function(){
            if (this.value.trim() != '') {
                $("#save").removeAttr('disabled');
            } else $("#save").prop('disabled', true);
        });

        // edit
        $(document).on("click", "#save", function (e) {
            var $task = e.currentTarget;
            var event = jQuery.Event("editItem");
            event.index = $($task).attr('data-index');
            event.todo = document.getElementById('textArea').value;
            $('body').trigger(event);
        });

        // track enter key | edit
        $(document).on("keypress", "#textArea", function (e) {
            if (e.which == 13) {
                var $task = e.currentTarget;
                var event = jQuery.Event("editItem");
                event.index = $($task).attr('data-index');
                event.todo = document.getElementById('textArea').value;
                $('body').trigger(event);
            }
        });
    };
    initView();

    // public methods
    return  {
        updateView: function (tasksNReady, tasksReady) {
            updateView(tasksNReady, tasksReady);
        }
    };
};





