/**
 * Created by lenovo on 2016-05-09.
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
    var j = 1;
    for(var i = 0;i<data.single.dataInfo.length;i++){
        var isShow = formatIsShow(data.single.dataInfo[i].isShow);
        var isPass = formatIsPass(data.single.dataInfo[i].isPass);
        var showWord = '';
        if(data.single.dataInfo[i].isShow){
            showWord = '不显示';
        } else {
            showWord = '显示';
        }
        var newDate = new Date(data.single.dataInfo[i].createTime);
        var time1 = newDate.Format("yyyy-MM-dd");
        $('#tableData').append($('<tr>').append($('<td>').text(j))
            .append($('<td>').text(data.single.dataInfo[i].title))
            .append($('<td>').text(isShow))
            .append($('<td>').text(isPass))
            .append($('<td>').text(time1))
            .append($('<td>').append($('<a href="javascript:;" onclick="toShow(\''+data.single.dataInfo[i].id+'\',\''+showWord+'\');" >').text(showWord))
                .append(" ")
                .append($('<a href="javascript:;" onclick="toEdit(\''+data.single.dataInfo[i].id+'\');" >').text('编辑'))
                .append(" ")
                .append($('<a href="javascript:;" onclick="toLook(\''+data.single.dataInfo[i].id+'\');" >').text('查看'))
                .append(" ")
                .append($('<a href="javascript:;" onclick="toDelete(\''+data.single.dataInfo[i].id+'\');" >').text('删除'))
            )
        );
        j++;
    }
}

/**
 * 更改展示状态
 * @param id
 * @param isShow
 */
function toShow(id,isShow){
    var show = null;
    if(isShow === '不显示'){
        show = false;
    } else {
        show = true;
    }
    $.post('/personal/updateMyResumeToShow',{
        'id':id,
        'isShow':show
    },function(data){
        if(data.state){
            window.location.reload(true);
        }
    },'json');
}

/**
 * 编辑
 * @param id
 */
function toEdit(id){
    window.location.href = '/personal/updateMyResumeToEdit?id='+id;
}

/**
 * 查看
 * @param id
 */
function toLook(id){
    window.location.href = '/personal/updateMyResumeToLook?id='+id;
}

/**
 * 删除
 * @param id
 */
function toDelete(id){
    $.post('/personal/deleteMyResume',{
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

function formatIsShow(s){
    if(s){
        return '显示';
    } else {
        return '不显示';
    }
}

function formatIsPass(s){
    if(s == 0){
        return '未审核';
    } else if(s == 1){
        return '通过';
    } else if(s == 2){
        return '未通过';
    }
}

function sendAjax(page) {
    $.post('/personal/personalMyResumeData', {
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
    $.post('/personal/personalMyResumeData', {
        'page': page
    }, function (data) {
        if(data.single.dataInfo.length>0){
            showDatas(data);
        }
    }, 'json');
}
