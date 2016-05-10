/**
 * Created by Administrator on 2016/5/10.
 */
function sendInterview(){
    $.post('/enterprise/sendInterview',{
        'resumeId':$('#resumeId').val().trim()
    },function(data){
        alert(data.msg);
    },'json');
}