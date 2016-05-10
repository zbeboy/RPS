/**
 * Created by Administrator on 2016/5/10.
 */
$(document).ready(function(){
    initNavActive();
    sendAjax(1);
});

function initNavActive(){
    $('#resumeExamine').addClass('active');
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
        var isPass = formatIsPass(data.single.dataInfo[i].isPass);
        var newDate = new Date(data.single.dataInfo[i].createTime);
        var time1 = newDate.Format("yyyy-MM-dd");
        $('#tableData').append($('<tr>').append($('<td>').text(j))
            .append($('<td>').text(data.single.dataInfo[i].title))
            .append($('<td>').text(isPass))
            .append($('<td>').text(time1))
            .append($('<td>')
                .append(" ")
                .append($('<a href="javascript:;" onclick="toLook(\''+data.single.dataInfo[i].id+'\');" >').text('查看'))
                .append(" ")
                .append($('<a href="javascript:;" onclick="toPass(\''+data.single.dataInfo[i].id+'\');" >').text('通过'))
                .append(" ")
                .append($('<a href="javascript:;" onclick="toDelete(\''+data.single.dataInfo[i].id+'\');" >').text('删除'))
            )
        );
        j++;
    }
}

/**
 * 通过
 * @param id
 */
function toPass(id){
    $.post('/admin/updateResumeToPass',{
        'id':id,
        'isPass':1
    },function(data){
        if(data.state){
            window.location.reload(true);
        }
    },'json');
}

/**
 * 查看
 * @param id
 */
function toLook(id){
    window.location.href = '/admin/adminLook?id='+id;
}

/**
 * 删除
 * @param id
 */
function toDelete(id){
    $.post('/admin/deleteResume',{
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
    $.post('/admin/adminExamineData', {
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
    $.post('/admin/adminExamineData', {
        'page': page
    }, function (data) {
        if(data.single.dataInfo.length>0){
            showDatas(data);
        }
    }, 'json');
}
