/**
 * Created by Administrator on 2016/5/10.
 */

$(document).ready(function(){
    initImg();
});

function initImg(){
    $($('.carousel-inner').children()[0]).addClass('active');

    for(var i = 0;i<$('.carousel-inner').children().length;i++){
        $('.carousel-indicators').append($('<li data-target="#carousel-example-generic" data-slide-to="'+i+'">'));
    }

    $($('.carousel-indicators').children()[0]).addClass('active');
}

function toMore(){
    window.location.href = '/searchResume';
}

function search(){
    window.location.href = '/searchResume?title='+$('#search').val();
}