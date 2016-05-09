/**
 * Created by Administrator on 2016/5/9.
 */
$(document).ready(function(){
    initNavActive();
    initUpload();
});

function initNavActive(){
    $('#modifyData').addClass('active');
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
                $('#headImgUrl').val(lastPath);
            }
        }
    });
}