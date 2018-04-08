
/*

			
	 //settings for slider
    var width = 720;
    var animationSpeed = 1000;
    var pause = 3000;
    var currentSlide = 1;

    //cache DOM elements
    var $slider = $('#slider');
    var $slideContainer = $('.slides', $slider);
    var $slides = $('.slide', $slider);

    var interval;

    function startSlider() {
        interval = setInterval(function() {
            $slideContainer.animate({'margin-left': '-='+width}, animationSpeed, function() {
                if (++currentSlide === $slides.length) {
                    currentSlide = 1;
                    $slideContainer.css('margin-left', 0);
                }
            });
        }, pause);
    }
    function pauseSlider() {
        clearInterval(interval);
    }

    $slideContainer
        .on('mouseenter', pauseSlider)
        .on('mouseleave', startSlider);

    startSlider();
	
jQuery(document).ready(function($){

var path = window.location.pathname.split("/").pop();

if (path == ''){
	path='website.php';
}
var target = $('div a[href="'+path+'"]');

target.addClass('active');
});
/**/
			



//eto yung jq function para isang file na lang lahat ng jq mo

$(function(){
	alert('tite');
	$('#invi').on('click', function(){
		$('.sad').fadeToggle(2000);

	});
	$('#big').on('click', function(){
		$( ".sad" ).css({height:'150px', width:'120px'});
				});

	$('#speed').on('click', function(){
		$( "#sadboy" ).attr("scrollamount", '70');
			}); 


		
	});		
	
	
	/*
	jQuery(document).ready(function ($) {

    //cache DOM
    var $slider = $('#slider');
    var $slideContainer = $slider.find('.slides');
    var $slides = $slideContainer.find('.slide');
    var $slideImg = $slides.find('img');
    var $toggleLeft = $slider.find('#toggle-left');
    var $toggleRight = $slider.find('#toggle-right');
    var $pauseBtn = $slider.find('#pause-btn');
    var $playBtn = $slider.find('#play-btn');
    var $sliderPaging = $('#slider-paging');
    var $sliderPages = $sliderPaging.find('.slider-pages');
    var $sliderPage = $sliderPages.find('.slider-page');

    //configuration
    var width = $slider.width();
    var animationSpeed = 1500;
    var pause = 6000;
    var currentSlide = 1;

    var interval;

    $slideContainer.css('width', width * $slides.length);
    $slideImg.css('width', width);

    $pauseBtn.click(function () {
        stopSlider();
        $pauseBtn.toggle();
        $playBtn.toggle();
    });
    $playBtn.click(function () {
        startSlider();
        $playBtn.toggle();
        $pauseBtn.toggle();
    });
    $toggleLeft.click(function () {
        stopSlider();
        if (currentSlide === 1) {
            currentSlide = $slides.length;
            $slideContainer.css({
                'margin-left': '-' + width * ($slides.length - 1) + 'px'
            });
            $slideContainer.animate({
                'margin-left': '+=' + width
            }, animationSpeed, function () {
                currentSlide--;
            });
        } else {
            $slideContainer.animate({
                'margin-left': '+=' + width
            }, animationSpeed, function () {
                currentSlide--;
            });
        }
        startSlider();
    });
    $toggleRight.click(function () {
        stopSlider();
        $slideContainer.animate({
            'margin-left': '-=' + width
        }, animationSpeed, function () {
            currentSlide++;
            if (currentSlide === $slides.length) {
                currentSlide = 1;
                $slideContainer.css('margin-left', 0);
            }
        });
        startSlider();
    });
    $sliderPage.click(function (){
        var pageId = $(this).attr('id');
        var pageNum = pageId.split('-').pop().trim();
        stopSlider();
        $slideContainer.animate({'margin-left': '-'+(width * (pageNum - 1))}, animationSpeed, function(){
            currentSlide = pageNum;
            if (currentSlide === $slides.length) {
                currentSlide = 1
                $slideContainer.css('margin-left', 0);
            };
        });
        startSlider();
    });
    function startSlider() {
        interval = setInterval(function () {
            $slideContainer.animate({
                'margin-left': '-=' + width
            }, animationSpeed, function () {
                currentSlide++;
                if (currentSlide === $slides.length) {
                    currentSlide = 1;
                    $slideContainer.css('margin-left', 0);
                }
            });
        }, pause);
    }
    function stopSlider() {
        clearInterval(interval);
    }
    startSlider();		
	
	*/
	
