var callBack = true;
$(function () {
    $("button").click(function () {
        callBack = !callBack;
        if (!callBack)
            $("h1").load("ajax_info.txt");
        else {
            $("h1").load("demo_test.txt", function (resp, status) {
                alert("Callback function\r\n" + status);
            });
        }
    });
});