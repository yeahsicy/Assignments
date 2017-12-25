
var all_images = new Array();  // the image.


all_images[0] = "images/0.jpg";
all_images[1] = "images/1.jpg";
all_images[2] = "images/4.jpg";
all_images[3] = "images/3.jpg";

var start_image = -1;

    function order_rotate(){
    start_image++;
    if(start_image>all_images.length-1){start_image=0}
    setTimeout("order_rotate()",5000); // milliseconds
    window.document.all['views'].src = all_images[start_image];
    }

window.onload = order_rotate;