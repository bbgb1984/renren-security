/**
 * Created by meng on 2017/5/17.
 */

$(function () {
    var header = $('.header');
    header.css({
        'height':header.width()*0.366
    });
})

function sideBar() {
    $(document.body).append('<a id="eval-btn-more" class="eval-btn" name="more" href="javascript:void(0)">+</a>'+
        '<a id="eval-btn-index" class="eval-btn fa fa-home hidden" name="index" href="javascript:void(0)"></a>'+
        '<a id="eval-btn-top" class="eval-btn fa fa-chevron-up hidden" name="top" href="javascript:void(0)"></a>'+
        '<a id="eval-btn-rank" class="eval-btn fa fa-bar-chart hidden" name="rank" href="javascript:void(0)"></a>');

    var evalBtns = $('.eval-btn'),
        morebtn = $('#eval-btn-more'),
        indexBtn = $('#eval-btn-index'),
        topBtn = $('#eval-btn-top'),
        rankBtn = $('#eval-btn-rank');
    evalBtns.on('tap', function () {
        if ($(this).attr('name') == 'more' && indexBtn.css('display') == 'none') {
            rankBtn.removeClass('hidden').animate({
                bottom:'95px',
                rotateX:'360deg'
            },200, function () {
                topBtn.removeClass('hidden').css({
                    bottom:'95px',
                    rotateX:'180deg'
                }).animate({
                    bottom:'140px',
                    rotateX:'360deg'
                },200, function () {
                    indexBtn.removeClass('hidden').css({
                        bottom:'140px',
                        rotateX:'180deg'
                    }).animate({
                        bottom:'185px',
                        rotateX:'360deg'
                    },200)
                })
            })
        }else if($(this).attr('name') == 'more'&& indexBtn.css('display') != 'none'){
            indexBtn.animate({
                bottom:'140px',
                rotateX:'180deg'
            },200, function () {
                indexBtn.addClass('hidden');
                topBtn.animate({
                    bottom:'95px',
                    rotateX:'180deg'
                },200, function () {
                    topBtn.addClass('hidden');
                    rankBtn.animate({
                        bottom:'50px',
                        rotateX:'180deg'
                    },200, function () {
                        rankBtn.addClass('hidden');
                    })
                })
            })
        }
        else if($(this).attr('name') == 'index'){
            window.location.href = '/';
        }else if($(this).attr('name') == 'top'){
            window.location.href = '#header';
        }else if($(this).attr('name') == 'rank'){
            window.location.href = 'activity_ranking.html';
        }

    });
}
