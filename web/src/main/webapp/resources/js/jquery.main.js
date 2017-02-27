$(document).ready(function () {

    $("#slider").slider({
        min: 0,
        max: 2000,
        values: [0, 2000],
        range: true,
        stop: function (event, ui) {
            var value1 = $("input#minCost").val($("#slider").slider("values", 0));
            var value2 = $("input#maxCost").val($("#slider").slider("values", 1));
            commitChange($("#slider").slider("values", 0), $("#slider").slider("values", 1));
        },
        slide: function (event, ui) {
            var value1 = $("input#minCost").val($("#slider").slider("values", 0));
            var value2 = $("input#maxCost").val($("#slider").slider("values", 1));
            /*commitChange($("#slider").slider("values", 0), $("#slider").slider("values", 1));   */     }
    });

    $("input#minCost").change(function () {

        var value1 = $("input#minCost").val();
        var value2 = $("input#maxCost").val();

        if (parseInt(value1) > parseInt(value2)) {
            value1 = value2;
            $("input#minCost").val(value1);
        }
        $("#slider").slider("values", 0, value1);
        commitChange(value1, value2);
    });


    $("input#maxCost").change(function () {

        var value1 = $("input#minCost").val();
        var value2 = $("input#maxCost").val();

        if (value2 > 2000) {
            value2 = 2000;
            $("input#maxCost").val(2000)
        }

        if (parseInt(value1) > parseInt(value2)) {
            value2 = value1;
            $("input#maxCost").val(value2);
        }
        $("#slider").slider("values", 1, value2);
        commitChange(value1, value2);
    });
});

function commitChange(minCost, maxCost) {
    var commandHidden = jQuery("#commandHidden").val();
    $.post('/catalog/' + commandHidden, {minCost: minCost, maxCost: maxCost},
        function (data) {
            /*$('#content').html(data.substring(data.indexOf('<div id=\"department'),data.length-180))*/;
        });
}

