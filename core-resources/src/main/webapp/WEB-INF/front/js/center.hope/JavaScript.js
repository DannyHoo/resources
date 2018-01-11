/*鼠标移过，左右按钮显示*/
$(".slidebox").hover(function() {
	jQuery(this).find(".prev,.next").stop(true, true).fadeTo("show", 0.8)
}, function() {
	jQuery(this).find(".prev,.next").fadeOut()
});
/*SuperSlide图片切换*/
$(".slidebox").slide({
	titCell: ".hd ul",
	mainCell: ".bd ul",
	autoPlay: true,
	autoPage: true,
	delayTime: 1000
});
$(".multipleColumn").slide({
	titCell: ".hd ul",
	mainCell: ".bd .ulWrap",
	autoPage: true,
	effect: "leftLoop",
	autoPlay: true,
	vis: 3
});

$(".hope_f ul li img.top_t1").mouseenter(function() {
	$(this).stop().animate({
		top: "30px"
	}, 300, function() {
		$(this).stop().animate({
			top: "50px"
		}, 300)
	});

})

$(".title_lv").mouseover(function() {
	$(".title_tl").show()
})
$(".title_lv").mouseout(function() {
	$(".title_tl").hide()
})
$(".title_lv1").mouseover(function() {
	$(".title_t2").show()
})
$(".title_lv1").mouseout(function() {
	$(".title_t2").hide()
})
$(document).ready(function() {
	$("#rightsead a").hover(function() {
		if ($(this).prop("className") == "hui") {
			$(this).children("img.hides").show();
		} else {
			$(this).children("img.hides").show();
			$(this).children("img.shows").hide();
			$(this).children("img.hides").animate({
				marginRight: '0px'
			}, 'slow');
		}
	}, function() {
		if ($(this).prop("className") == "hui") {
			$(this).children("img.hides").hide('slow');
		} else {
			$(this).children("img.hides").animate({
				marginRight: '-50px'
			}, 'slow', function() {
				$(this).hide();
				$(this).next("img.shows").show();
			});
		}
	});
});

$(".closs").click(function(){
	$(".login").remove();
})
$(".lgn_img").click(function(){
	$(".login2").remove();
})
$(document).ready(function() {
				$(".side ul li").hover(function() {
					$(this).find(".sidebox").stop().animate({
						"width": "120px"
					}, 200).css({
						"opacity": "1",
						"filter": "Alpha(opacity=100)",
						"background": "#ED5446"
					})
				}, function() {
					$(this).find(".sidebox").stop().animate({
						"width": "40px"
					}, 200).css({
						"opacity": "1",
						"filter": "Alpha(opacity=80)",
						"background": "#333"
					})
				});
			});
			//回到顶部
			function goTop() {
				$('html,body').animate({
					'scrollTop': 0
				}, 1000);
			}
			$(".outBox .hd ul li").click(function(){
				$(this).style.color="red";
			})
			
			$("#slideBox").hover(function(){
				$(this).find(".mousshow a").show();
			},function(){
				$(this).find(".mousshow a").hide();
				
			})
			$("#index_zhifu>span").click(function(){
					$(this).addClass("payon").siblings().removeClass("payon");
				})