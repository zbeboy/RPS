/**
 * Created by Administrator on 2016/5/10.
 */

$(document).ready(function(){
    initMessageCount();
});

function initMessageCount(){
    $.get('/personal/isSeeMessage',function(data){
       if(data.state){
           $('#messageCount').text(data.obj);
       }
    });
}