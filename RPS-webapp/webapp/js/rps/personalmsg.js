/**
 * Created by Administrator on 2016/5/10.
 */
$(document).ready(function(){
    initNavActive();
    sendAjax(1);
});

function initNavActive(){
    $('#myResume').addClass('active');
}

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
       $('#tableData').append($('<tr>')
           .append($('<td>').append($('<input type="checkbox" name="check" />').val(data.single.dataInfo[i].id)))
           .append($('<td>').text(data.single.dataInfo[i].messageTitle))
           .append($('<td>').text(data.single.dataInfo[i].message_content))
           .append($('<td>').text(time1))
           .append($('<td>').append($('<a href="javascript:;" onclick="toDelete(\''+data.single.dataInfo[i].id+'\');" >').text('删除')))
       );
    }

    // 全选
    $.fn.check({
        checkall_name : "checkall",
        checkbox_name : "check"
    });
}

function toDelete(id){
    $.post('/personal/deleteMessage',{
        'id':id
    },function(data){
        if(data.state){
            window.location.reload(true);
        }
    },'json');
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
    $.post('/personal/acceptMessage', {
        'page': page
    }, function (data) {
        showDatas(data);
        $('#light-pagination').empty();
        if(data.single.dataInfo.length>0){
            createPage(data);
        }
    }, 'json');
}

function nextPage(page){
    $.post('/personal/acceptMessage', {
        'page': page
    }, function (data) {
        if(data.single.dataInfo.length>0){
            showDatas(data);
        }
    }, 'json');
}


/**
 * 批量删除
 */
function batchDelete() {
    var data = $("input[name ='check']:checked");

    var ids = new Array();

    for (var i = 0; i < data.length; i++) {
        ids.push($($(data)[i]).val());
    }

    $.post("/personal/batchDeleteMessage", {
        'ids' : ids.join(',')
    }, function(data) {
       if(data.state){
           window.location.reload(true);
       }
    });

}