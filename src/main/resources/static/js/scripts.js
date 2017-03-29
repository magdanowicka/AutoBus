$(function () {
    $('.map').maphilight();
});
$.fn.maphilight.defaults = {
    fill: true,
    fillColor: '5ada5a',
    fillOpacity: 0.2,
    stroke: false,
    strokeColor: 'ff0000',
    strokeOpacity: 1,
    strokeWidth: 1,
    fade: true,
    alwaysOn: true,
    neverOn: false,
    groupBy: false,
    wrapClass: true,
    shadow: false,
    shadowX: 0,
    shadowY: 0,
    shadowRadius: 6,
    shadowColor: '000000',
    shadowOpacity: 0.8,
    shadowPosition: 'outside',
    shadowFrom: false
}

$(document).ready(function () {
    $('area').click(function (e) {
        e.preventDefault();

        var data = $(this).data('maphilight') || {};
        data.fillColor = 'FFFF00'; // Sample color

        $(this).data('maphilight', data).trigger('alwaysOn.maphilight');

        $('#chosen_placeholder').text($('#chosen_placeholder').text() + ' ' + $(this).attr("id"));

    });
});

$('.carousel').carousel({
    interval: 5000 //changes the speed
})