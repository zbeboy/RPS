/**
 * Created by Administrator on 2016/5/10.
 */
$(document).ready(function(){
    initNavActive();
    dealData();
    initUpload();
});

function initNavActive(){
    $('#myResume').addClass('active');
}

function dealData(){
    if(resumeDto.sex == 1){
        $('#man').attr("checked",true);
    } else {
        $('#woman').attr("checked",true);
    }

    for(var i = 0;i<$("#education").children().length;i++){
        if($($("#education").children()[i]).text() === resumeDto.education ){
            $($("#education").children()[i]).attr('selected',true);
            break;
        }
    }
}

function initUpload(){
    $('#fileupload').fileupload({
        url:'/personal/uploadPhoto',
        dataType: 'json',
        add: function (e, data) {
            data.submit();
        },
        done: function (e, data) {
            var lastPath = data.result.single.lastPath;
            if (!/\.(gif|jpg|jpeg|png|bmp|GIF|JPG|PNG|JPEG|BMP)$/.test(lastPath)) {
                alert("请上传gif,jpg,png,bmp格式的图像!");
            } else {
                $('#personalPhoto').attr('src',lastPath);
                $('#resumeImg').val(lastPath);
            }
        }
    });
}