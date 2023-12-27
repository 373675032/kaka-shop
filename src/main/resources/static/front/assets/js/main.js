(function($) {
    'use strict';

    /*-------------------------------------------------------------------------------
    Cookies
    -------------------------------------------------------------------------------*/
    function setCookie(cname, cvalue, days) {

        if (days) {
            var date = new Date();
            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
            var expires = "; expires=" + date.toGMTString();
        } else {
            var expires = "";
        }
        document.cookie = cname + "=" + cvalue + expires + "; path=/";
    }

    //Return a particular cookie
    function getCookie(cname) {
        var name = cname + "=";
        var decodedCookie = decodeURIComponent(document.cookie);
        var ca = decodedCookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    }

    //Checks if a cookie exists
    function checkCookie(cookieToCheck) {
        var cookie = getCookie(cookieToCheck);
        if (cookie != "") {
            return true;
        }
        return false;
    }

    //Delet an existing cookie
    function deleteCookie(name) {
        document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    }

    /*-------------------------------------------------------------------------------
    Newsletter popup close and set cookie
    -------------------------------------------------------------------------------*/
    $(".newsletter-popup-trigger").on('click', function() {
        setCookie('newsletter_popup_viewed', 'true');
    });

    $('#androNewsletterPopup').on('hidden.bs.modal', function() {
        setCookie('newsletter_popup_viewed', 'true');
    });

    /*-------------------------------------------------------------------------------
  Preloader
  -------------------------------------------------------------------------------*/
    $(window).on('load', function() {
        $('.andro_preloader').addClass('hidden');

        //if (!checkCookie('newsletter_popup_viewed')) {
        //    setTimeout(function() {
        //        $("#androNewsletterPopup").modal('show');
        //    }, 3000);
        //}

    });

    /*-------------------------------------------------------------------------------
  Aside Menu
  -------------------------------------------------------------------------------*/
    $(".aside-trigger-right").on('click', function() {
        var $el = $(".andro_aside-right")
        $el.toggleClass('open');
        if ($el.hasClass('open')) {
            setTimeout(function() {
                $el.find('.sidebar').fadeIn();
            }, 300);
        } else {
            $el.find('.sidebar').fadeOut();
        }
    });

    $(".aside-trigger-left").on('click', function() {
        $(".andro_aside-left").toggleClass('open');
    });

    $(".andro_aside .menu-item-has-children > a").on('click', function(e) {
        var submenu = $(this).next(".sub-menu");
        e.preventDefault();

        submenu.slideToggle(200);
    });

    /*-------------------------------------------------------------------------------
    Custom scroll bars
    -------------------------------------------------------------------------------*/
    $('.andro_dropdown-scroll').slimScroll({
        height: 300,
        position: "right",
        size: "5px",
        color: "#dcdcdc",
        opacity: 1,
        wheelStep: 5,
        touchScrollStep: 50,
    });

    /*-------------------------------------------------------------------------------
  Sticky Header
  -------------------------------------------------------------------------------*/
    var header = $(".can-sticky");
    var headerHeight = header.innerHeight();

    function doSticky() {
        if (window.pageYOffset > headerHeight) {
            header.addClass("sticky");
        } else {
            header.removeClass("sticky");
        }
    }
    doSticky();

    /*-------------------------------------------------------------------------------
    Tooltips
    -------------------------------------------------------------------------------*/
    $('[data-toggle="tooltip"]').tooltip();

    /*-------------------------------------------------------------------------------
    Magnific Popup
    -------------------------------------------------------------------------------*/
    $('.popup-youtube').magnificPopup({
        type: 'iframe'
    });
    $('.popup-vimeo').magnificPopup({
        type: 'iframe'
    });
    $('.popup-video').magnificPopup({
        type: 'iframe'
    });
    $('.gallery-thumb').magnificPopup({
        type: 'image',
        gallery: {
            enabled: true
        },
    });

    /*-------------------------------------------------------------------------------
    ion Range Sliders (Price filter)
    -------------------------------------------------------------------------------*/
    $(".js-range-slider").ionRangeSlider();

    $('.andro_product-single-thumb')
        .wrap('<span style="display:inline-block" class="andro_product-single-zoom"></span>')
        .css('display', 'block')
        .parent()
        .zoom();

    /*-------------------------------------------------------------------------------
    Countdown
    -------------------------------------------------------------------------------*/
    $(".andro_countdown-timer").each(function() {
        var $this = $(this);
        $this.countdown($this.data('countdown'), function(event) {
            $(this).text(
                event.strftime('%D days %H:%M:%S')
            );
        });
    });

    $(".andro_countdown-timer-2").each(function() {
        var $this = $(this);
        $this.countdown($this.data('countdown'), function(event) {
            $(this).html(
                event.strftime('<li>%D</li><li>%H</li><li>%M</li><li>%S</li>')
            );
        });
    });

    /*-------------------------------------------------------------------------------
    Checkout Notices
    -------------------------------------------------------------------------------*/
    $(".andro_notice a").on('click', function(e) {
        e.preventDefault();

        $(this).closest('.andro_notice').next().slideToggle();
    });

    /*-------------------------------------------------------------------------------
    Open/Close Category Bar
    -------------------------------------------------------------------------------*/
    $(".andro_category-mm").on('click', function() {
        $(this).toggleClass('open');
    })

    /*-------------------------------------------------------------------------------
    Daily deals slider
    -------------------------------------------------------------------------------*/
    $(".deals-slider, .andro_testimonials").slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        dots: true,
        autoplay: true,
        responsive: [{
                breakpoint: 991,
                settings: {
                    slidesToShow: 2,
                }
            },
            {
                breakpoint: 575,
                settings: {
                    slidesToShow: 1,
                }
            }
        ]
    });

    /*-------------------------------------------------------------------------------
    Daily deals slider
    -------------------------------------------------------------------------------*/
    $(".andro_grid-slider").slick({
        slidesToShow: 4,
        slidesToScroll: 1,
        arrows: true,
        dots: false,
        autoplay: false,
        responsive: [{
                breakpoint: 991,
                settings: {
                    slidesToShow: 3,
                    autoplay: true,
                    arrows: false,
                }
            },
            {
                breakpoint: 768,
                settings: {
                    slidesToShow: 2,
                    arrows: false,
                }
            },
            {
                breakpoint: 575,
                settings: {
                    slidesToShow: 1,
                    arrows: false,
                }
            }
        ]
    });

    /*-------------------------------------------------------------------------------
    Other mentions slider
    -------------------------------------------------------------------------------*/
    $(".andro_other-mentions-slider").slick({
        slidesToShow: 4,
        slidesToScroll: 1,
        arrows: true,
        prevArrow: $('.andro_other-mentions .slider-prev'),
        nextArrow: $('.andro_other-mentions .slider-next'),
        dots: false,
        autoplay: false,
        responsive: [{
                breakpoint: 991,
                settings: {
                    slidesToShow: 3,
                }
            },
            {
                breakpoint: 768,
                settings: {
                    slidesToShow: 2,
                }
            },
            {
                breakpoint: 450,
                settings: {
                    slidesToShow: 1,
                }
            }
        ]
    });

    /*-------------------------------------------------------------------------------
    Banner slider (Home v1)
    -------------------------------------------------------------------------------*/
    $(".banner-1 .andro_banner-slider").slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        dots: true,
        autoplay: true
    });

    /*-------------------------------------------------------------------------------
    Banner slider (Home v2)
    -------------------------------------------------------------------------------*/
    $(".banner-2 .andro_banner-slider").slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        dots: false,
        autoplay: true,
    });

    /*-------------------------------------------------------------------------------
    Banner slider (Home v3)
    -------------------------------------------------------------------------------*/
    $(".banner-3 .andro_banner-slider").slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: true,
        dots: false,
        autoplay: true,
        prevArrow: $('.banner-3 .slider-prev'),
        nextArrow: $('.banner-3 .slider-next'),
    });

    /*-------------------------------------------------------------------------------
    New Arrivals
    -------------------------------------------------------------------------------*/
    $(".andro_fresh-arrivals-slider").slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        arrows: true,
        dots: false,
        autoplay: true,
        prevArrow: $('.andro_fresh-arrivals .slider-prev'),
        nextArrow: $('.andro_fresh-arrivals .slider-next'),
        responsive: [{
                breakpoint: 991,
                settings: {
                    slidesToShow: 2,
                }
            },
            {
                breakpoint: 575,
                settings: {
                    slidesToShow: 1,
                }
            }
        ]
    });
    /*-------------------------------------------------------------------------------
    New Deals
    -------------------------------------------------------------------------------*/
    $(".andro_deals-arrivals-slider").slick({
        slidesToShow: 4,
        slidesToScroll: 1,
        arrows: true,
        dots: false,
        autoplay: true,
        prevArrow: $('.andro_fresh-arrivals .slider-prev'),
        nextArrow: $('.andro_fresh-arrivals .slider-next'),
        responsive: [{
                breakpoint: 991,
                settings: {
                    slidesToShow: 3,
                }
            },
            {
                breakpoint: 767,
                settings: {
                    slidesToShow: 2,
                }
            },
            {
                breakpoint: 575,
                settings: {
                    slidesToShow: 1,
                }
            }
        ]
    });
    /*-------------------------------------------------------------------------------
    garage-small-slider
    -------------------------------------------------------------------------------*/
    $(".garage-small-slider").slick({
        slidesToShow: 2,
        slidesToScroll: 1,
        arrows: false,
        dots: true,
        autoplay: true,
        responsive: [
            {
                breakpoint: 991,
                settings: {
                    dots: false,
                }
            },
            {
                breakpoint: 575,
                settings: {
                    slidesToShow: 1,
                }
            }
        ]
    });
    /*-------------------------------------------------------------------------------
    Main Banner
    -------------------------------------------------------------------------------*/
    $(".main-slider").slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: true,
        dots: false,
        autoplay: true
    });

    /*-------------------------------------------------------------------------------
    Upsells
    -------------------------------------------------------------------------------*/
    $(".andro_upsells-slider").slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: true,
        dots: false,
        autoplay: true,
        prevArrow: $('.andro_upsells .slider-prev'),
        nextArrow: $('.andro_upsells .slider-next'),
    });

    /*-------------------------------------------------------------------------------
    Related Products / Posts
    -------------------------------------------------------------------------------*/
    $(".andro_related-posts-slider").slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        arrows: true,
        dots: false,
        autoplay: true,
        prevArrow: $('.andro_related-posts .slider-prev'),
        nextArrow: $('.andro_related-posts .slider-next'),
        responsive: [{
                breakpoint: 991,
                settings: {
                    slidesToShow: 2,
                }
            },
            {
                breakpoint: 575,
                settings: {
                    slidesToShow: 1,
                }
            }
        ]
    });

    /*-------------------------------------------------------------------------------
    Masonry
    -------------------------------------------------------------------------------*/
    $('.masonry').imagesLoaded(function() {
        var isotopeContainer = $('.masonry');
        isotopeContainer.isotope({
            itemSelector: '.masonry-item',
        });
    });

    /*-------------------------------------------------------------------------------
    Add / Subtract Quantity
    -------------------------------------------------------------------------------*/
    $(".qty span").on('click', function() {
        var qty = $(this).closest('.qty').find('input');
        var qtyVal = parseInt(qty.val());
        if ($(this).hasClass('qty-add')) {
            qty.val(qtyVal + 1);
        } else {
            return qtyVal > 1 ? qty.val(qtyVal - 1) : 0;
        }
    })

    /*-----------------------------------
      Back to Top
      -----------------------------------*/
    $('.andro_back-to-top').on('click', function() {
        $("html, body").animate({
            scrollTop: 0
        }, 600);
        return false;
    })

    //On scroll events
    $(window).on('scroll', function() {

        doSticky();

    });

    //On resize events
    $(window).on('resize', function() {


    });

})(jQuery);