/*
 *
 */

// make table style sheet
(function ($) {
    $.fn.leoStyleTable = function (options) {
        var defaults = {
            css: 'leoStyleTable'
        };
        options = $.extend(defaults, options);
        var oddRowColor = options.oddRowColor;
        var isChangeOddRowColor = true;
        if (oddRowColor != null) {
            if (oddRowColor == false) {
                isChangeOddRowColor = false;
            }
        }

        return this.each(function () {

            eachTable = $(this);
            eachTable.addClass(options.css);
            eachTable.css({
                'border-collapse': 'separate'
            });

            eachTable.find("tr").on('mouseover', function () {
                //$(this).children("td").addClass("ui-state-hover");
                $(this).children("td").addClass("ui-state-highlight");
                $(this).css({
                    'cursor': 'pointer'
                });
            });
            eachTable.find("tr").on('mouseout', function () {
                //$(this).children("td").removeClass("ui-state-hover");
                $(this).children("td").removeClass("ui-state-highlight");
            });
            //eachTable.find("tr").on('click', function () {
                //$(this).children("td").toggleClass("ui-state-highlight");
            //});
            //eachTable.find("tr").hover(
            //    function () {
            //        $(this).append($("<span> ***</span>"));
            //    },
            //    function () {
            //        $(this).find("span:last").remove();
            //    }
            //);

            if (isChangeOddRowColor) {
                eachTable.find("tr:nth-child(2n+1)").each(function(){
                    $(this).children("td").css({
                        //'background': '#f1f6fc'
                        'background': '#B3F6FC'
                    });
                    //$(this).children("td").addClass("ui-widget-overlay");
                });
            }

            eachTable.find("th").addClass("ui-state-default");
            eachTable.find("th").css({
                'text-align': 'center',
                'padding': '.8em .4em'
            });

            eachTable.find("td").addClass("ui-widget-content");
            eachTable.find("td").css({
                'font-weight': 'normal !important',
                'padding': '.4em',
                'border-top-width': '0px !important'
            });

            //eachTable.find("tr").each(function () {
            //    $(this).children("td:not(:first)").addClass("first");
            //    $(this).children("th:not(:first)").addClass("first");
            //});
        });
    };
})(jQuery);

//make title style sheet
(function ($) {
    $.fn.leoStyleTitle = function (options) {
        var defaults = {
            css: 'leoStyleTitle'
        };
        options = $.extend(defaults, options);

        return this.each(function () {

            eachTitle = $(this);
            eachTitle.addClass("ui-state-default");
            eachTitle.css({
                'font-size': '16px',
                'font-weight': 'bold',
                'height': '22px',
                'text-align': 'left',
                'vertical-align': 'middle',
                'padding-top': '8px',
                'padding-left': '10px',
                'margin-top': '0px',
                'margin-bottom': '15px',
                'width': '95%'
            });

        });
    };
})(jQuery);

//make menu style sheet
(function ($) {
    $.fn.leoStyleMenu = function (options) {
        var defaults = {
            css: 'leoStyleMenu'
        };
        options = $.extend(defaults, options);

        return this.each(function () {

            eachMenu = $(this);
            eachMenu.find("li").addClass("ui-state-default");

            eachMenu.find("li").hover(function() {
                $(this).addClass('ui-state-hover');
            }, function() {
                $(this).removeClass('ui-state-hover');
            });
        });
    };
})(jQuery);
