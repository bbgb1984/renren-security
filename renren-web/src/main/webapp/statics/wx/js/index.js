/**
 * Created by meng on 2017/5/16.
 */
$(function () {
    sideBar();
   var header = $('.header'),
       activeErweima = $('.activetop').find('.erweima'),
       activeTopLeft = $('.activetop').find('.active-title-right').find('.pull-left'),
       activeTable = $('.activetop').find('table'),
       activeTableTd = activeTable.find('td'),
       units = $('.units'),
       unitsTop = units.find('.units-top');
    
    activeTableTd.css({
        'height':activeTable.width()*0.11
    });
    activeErweima.css({
        'width':activeTopLeft.height(),
        'height':activeTopLeft.height()
    });
    
});