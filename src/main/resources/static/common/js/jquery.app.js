

(function ($) {

    'use strict';
	$(window).on('load', function () {

		//Pre Loader
		if ($(".spinner").length > 0)
		{
			$(".spinner").fadeOut("slow");
		}
	});
    function initNavbar() {
        $('.navbar-toggle').on('click', function (event) {
            $(this).toggleClass('open');
            $('#navigation').slideToggle(400);
        });

        $('.navigation-menu>li').slice(-2).addClass('last-elements');

        $('.navigation-menu li.has-submenu a[href="#"]').on('click', function (e) {
            if ($(window).width() < 992) {
                e.preventDefault();
                $(this).parent('li').toggleClass('open').find('.submenu:first').toggleClass('open');
            }
        });
    }
    function initScrollbar() {
        $('.slimscroll').slimscroll({
            height: 'auto',
            position: 'right',
            size: "8px",
            color: '#9ea5ab'
        });
    }
    // === following js will activate the menu in left side bar based on url ====
    function initMenuItem() {
        $(".navigation-menu a").each(function () {
            if (this.href == window.location.href) {
                $(this).parent().addClass("active"); // add active to li of the current link
                $(this).parent().parent().parent().addClass("active"); // add active class to an anchor
                $(this).parent().parent().parent().parent().parent().addClass("active"); // add active class to an anchor
            }
        });
    }
    function initRightbar() {
        $(".right-bar-toggle").click(function () {
            $(".right-bar").toggle();
            $('.wrapper').toggleClass('right-bar-enabled');
        });
    }
    function init() {
        initNavbar();
        initScrollbar();
        initMenuItem();
        initRightbar();
    }

    init();

})(jQuery);
