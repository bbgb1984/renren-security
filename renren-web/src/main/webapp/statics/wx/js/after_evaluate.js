/**
 * Created by meng on 2017/5/17.
 */
$(function () {
    sideBar();
    
    var rankSwiper = new Swiper('.swiper-container', {
        autoplay: 5000,//可选选项，自动滑动
        pagination : '.swiper-pagination',
        prevButton:'.swiper-button-prev',
        nextButton:'.swiper-button-next',
    });
    
    function render(newData) {
        var tbody = '';
        for (var key in newData) {
            if(key == 'count'){
                var html = template('sortrank-count',{
                    data:sortRank('value',newData[key])
                });
                tbody = '.rank .rank-table .rank-table-count tbody';
                $(tbody).append(html);
                $(tbody).find('tr').each(function (i,e) {
                    if(i%2 !=0){
                        $(e).css({
                            'backgroundColor':'#f0f0f0'
                        })
                    }
                })
            }else{
                var html = template('sortrank-type',{
                    data:sortRank('value',newData[key])
                });
                tbody = '.rank .rank-table .rank-table-'+key+' tbody';
                $(tbody).append(html);
                $(tbody).find('tr').each(function (i,e) {
                    if(i%2 !=0){
                        $(e).css({
                            'backgroundColor':'#f0f0f0'
                        })
                    }
                })
            }
        }
    }
    function getRandomRankData(min,max,index) {
        var data = [];
        for (var i = 0; i < index; i++) {
            data.push(
                {
                    id:i+1,
                    name:'单位名称'+(i+1),
                    count:Math.floor(Math.random()*(20000-1000+1)+1000),
                    zhiliang:Math.floor(Math.random()*(max-min+1)+min),
                    taidu:Math.floor(Math.random()*(max-min+1)+min),
                    xiaolv:Math.floor(Math.random()*(max-min+1)+min),
                    suyang:Math.floor(Math.random()*(max-min+1)+min),
                    lianjie:Math.floor(Math.random()*(max-min+1)+min)
                }
            )
        }
        return data;
    }
    function sortRank(odds,data) {
        var newData = data.sort(function (a,b) {
            return b[odds] - a[odds]
        })
        return newData
    }

})


