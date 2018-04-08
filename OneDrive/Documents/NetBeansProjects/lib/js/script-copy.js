
$(function ($) {
	alert('tite');
    //cache DOM
    var $sliderWrap = $('#slider-wrap');
    var $slider = $('#slider');
    var $slideContainer = $slider.find('.slides');
    var $slides = $slideContainer.find('.slide');
    var $slideCount = $slides.length;
    var $slideImg = $slides.find('img');
    var $toggleLeft = $sliderWrap.find('#toggle-left');
    var $toggleRight = $sliderWrap.find('#toggle-right');

    var $sliderPaging = $('#slider-paging');
    var $sliderPages = $sliderPaging.find('.slider-pages');
    var $sliderPage = $sliderPages.find('.slider-page');

    //configuration
    var slide;
    var animation = slide;
    var animationSpeed = 1000;
    var toggleClickSpeed = 800;
    var pagingClickSpeed = 400;
    var animationEasing = "swing";
    var toggleClickEasing = "swing";
    var pagingClickEasing = "linear";
    var animationQueue = false;
    var toggleClickQueue = false;
    var pagingClickQueue = false;


    //initialize global variables
    var $activePage;
    var $activeSlide;
    var currentSlide = 1;
    var interval;
    var maxHeight;
    var $nextSlide;
    var width = $slider.width();

    var setHeight = function () {
        if ( $(window).width() > 767 ) {
            maxHeight = 0;
            $slides.find('.span6').each(function() {
                var h = $(this).outerHeight();
                if ( h > maxHeight) {
                    maxHeight = h;
                }
            });
        } else {
            maxHeight = 0;
            $slides.each(function() {
                var h = 0;
                $(this).find('.span6').each(function() {
                    h = h + $(this).outerHeight();
                });
                if ( h > maxHeight) {
                    maxHeight = h;
                }
            });
        }
        $slideContainer.css({'height': maxHeight});
    }
    setHeight();
	/*Height*/
	
    var setWidth = function() {
        width = $slider.width();
    }
    $(window).resize(function() {
        setHeight();
        setWidth();
    });
	
    var addActive = function () {
        $activePage = $('.slider-page:nth-of-type(' + currentSlide + ')').addClass('active');
        $activeSlide = $('.slide:nth-of-type(' + currentSlide + ')').addClass('active');
    }
    addActive();
	
    var removeActive = function () {
        $activePage.removeClass('active');
        $activeSlide.removeClass('active');
    }
    var showSlides = function (slides) {
        slides.each(function () {
            $(this).css({'opacity': 1})
        });
    }
    var hideSlides = function (slides) {
        slides.each(function () {
            $(this).css({'opacity': 0})
        });
    }
    $i = $slideCount;
    $slides.each(function( index ) {
        $(this).css({'z-index': $i--});
        if ( !$(this).hasClass('active') ) {
            hideSlides($(this));
        }
    });

   
  
  
 
    var moveUp = function (itemArr) {
        itemArr.each(function() {
            var zIndex = $(this).css('z-index');
            if ( zIndex == $slideCount ) {
                $(this).css({'z-index': 1});
            } else {
                $(this).css({'z-index': ++zIndex});
            }
        });
    }
    var moveDown = function (itemArr) {
        itemArr.each(function () {
            var zIndex = $(this).css('z-index');
            if ( zIndex == 1 ) {
                $(this).css({'z-index': $slideCount});
            } else {
                $(this).css({'z-index': --zIndex});
            }
        });
    }
    var slideLeft = function (slideLength, speed, easing, queue) {
        var dfd = $.Deferred();
        if ( currentSlide === 1 ) {
            $nextSlide = $('.slide:nth-of-type(' + $slideCount + ')');
        } else {
            $nextSlide = $('.slide:nth-of-type(' + (currentSlide - 1) + ')');
        }
        $nextSlide.css({'margin-left': -slideLength, 'opacity': 1});
        $activeSlide.add($nextSlide).addClass('animating');
        moveDown($slides);
        $activeSlide.add($nextSlide).stop().animate({'margin-left': '+=' + slideLength}, {"duration": speed, "easing": easing, "queue": queue}).promise().then(function () {
            $activeSlide.css({'margin-left': 0, 'opacity': 0});
            $activeSlide.add($nextSlide).removeClass('animating');
            if (currentSlide === 1) {
                currentSlide = $slideCount;
            } else {
                currentSlide--;
            }
            removeActive();
            addActive();
            dfd.resolve();
        });
        return dfd.promise();
    }
    $toggleLeft.click(function(){
        if ( $activeSlide.add($nextSlide).hasClass('animating') ) {
            return;
        } else {
           
            $.when(slideLeft(width, toggleClickSpeed, toggleClickEasing, toggleClickQueue)).then(function () {
                
            });
        }
    });
    var slideRight = function (slideLength, speed, easing, queue) {
        var dfd = $.Deferred();
        if ( currentSlide === $slideCount ) {
            $nextSlide = $('.slide:nth-of-type(1)');
        } else {
            $nextSlide = $('.slide:nth-of-type(' + (currentSlide + 1) + ')');
        }
        $nextSlide.css({'margin-left': slideLength, 'opacity': 1});
        $activeSlide.add($nextSlide).addClass('animating');
        $activeSlide.add($nextSlide).stop().animate({'margin-left': '-=' + slideLength}, {"duration": speed, "easing": easing, "queue": queue}).promise().then(function () {
            $activeSlide.css({'margin-left': 0, 'opacity': 0});
            $activeSlide.add($nextSlide).removeClass('animating');
            moveUp($slides);
            if (currentSlide === $slideCount) {
                currentSlide = 1;
            } else {
                currentSlide++;
            }
            removeActive();
            addActive();
            dfd.resolve();
        });
        return dfd.promise();
    }
    $toggleRight.click(function (){
        if ( $activeSlide.add($nextSlide).hasClass('animating') ) {
            return;
        } else {
            $.when(slideRight(width, toggleClickSpeed, toggleClickEasing, toggleClickQueue)).then(function () {
            });
        }
    });
	/*
    var keepSlidingLeft = function (count, speed, easing, queue) {
        if ( count <= 0 ) {
            return;
        }
        $.when(slideLeft(width, speed, easing, queue)).then(function () {
            keepSlidingLeft(count - 1, speed, easing, queue);
        })
    }
    var keepSlidingRight = function (count, speed, easing, queue) {
        if ( count <= 0 ) {
            return;
        }
        $.when(slideRight(width, speed, easing, queue)).then(function () {
            keepSlidingRight(count - 1, speed, easing, queue);
        })
    }*/
    $sliderPage.click(function (){
        if ( $activeSlide.add($nextSlide).hasClass('animating') ) {
            return;
        } else {
            var pageId = $(this).attr('id');
            var pageNum = pageId.split('-').pop().trim();
 
            if ( pageNum < currentSlide ) {
                var count = currentSlide - pageNum;
                keepSlidingLeft(count, pagingClickSpeed, pagingClickEasing, pagingClickQueue);
            } else {
                var count = pageNum - currentSlide;
                keepSlidingRight(count, pagingClickSpeed, pagingClickEasing, pagingClickQueue);
            }
        }
    });

});