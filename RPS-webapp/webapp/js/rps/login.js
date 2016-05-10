/**
 * Created by Administrator on 2016/5/10.
 */

/**
 * 登录
 */
function toLogin(){
    if($('#j_username').val().trim().length>0){
        $.post('/validateActive',{
            'username':$('#j_username').val().trim()
        },function(data){
            if(data.state){
                $('#loginForm').submit();
            } else {
                $('#error').append(data.msg).append($('<a href="javascript:;" onclick="againActive();" >').text('重新激活'));
            }
        },'json');
    } else {
        $('#error').text('请填写账号!');
    }
}

/**
 * 重新激活
 */
function againActive(){
    if($('#j_username').val().trim().length>0){
        $.post('/againActive',{
            'username':$('#j_username').val().trim()
        },function(data){
            if(data.state){
                alert("已发送激活邮件至您的邮箱!");
            } else {
                $('#error').text(data.msg);
            }
        },'json');
    } else {
        $('#error').text('请填写账号!');
    }
}