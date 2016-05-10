/**
 * Created by Administrator on 2016/5/10.
 */
$(document).ready(function(){
    sendAjax(1);
});

function createPage(data) {
    $('#light-pagination').pagination({
        pages: data.single.totalPages,
        displayedPages: data.single.buttons,
        onPageClick: function(pageNumber, event) {
            // Callback triggered when a page is clicked
            // Page number is given as an optional parameter
            nextPage(pageNumber);
        }
    });
}

function showDatas(data) {
    $('#tableData').empty();
    for(var i = 0;i<data.single.dataInfo.length;i++){
        var newDate = new Date(data.single.dataInfo[i].createTime);
        var time1 = newDate.Format("yyyy-MM-dd");
        $('#tableData').append($('<li class="list-group-item">')
            .append($('<span class="col-md-5" >').append($('<a href="javascript:;" onclick="toLook(\''+data.single.dataInfo[i].id+'\');" >').text(data.single.dataInfo[i].title)))
            .append($('<span class="col-md-4">').text(data.single.dataInfo[i].realName))
            .append(time1)
        );
    }
}

/**
 * 查看
 * @param id
 */
function toLook(id){
    window.location.href = '/resume?id='+id;
}


Date.prototype.Format = function(fmt)
{ //author: meizz
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}

function sendAjax(page) {
    $.post('/searchResumeData', {
        'page': page,
        'title':title
    }, function (data) {
        showDatas(data);
        $('#light-pagination').empty();
        if(data.single.dataInfo.length>0){
            createPage(data);
        }
    }, 'json');
}

function nextPage(page){
    $.post('/searchResumeData', {
        'page': page
    }, function (data) {
        if(data.single.dataInfo.length>0){
            showDatas(data);
        }
    }, 'json');
}