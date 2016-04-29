// JavaScript Document
$(document).ready(function() {
    $(".header_right_hide").hide();
	$(".header_right_person").mouseenter(function(){
			$('.header_right_hide').show();
		}).mouseleave(function(){
			$('.header_right_hide').hide();
			});  
});
	