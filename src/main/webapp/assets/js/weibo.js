

var WEIBO = {
	url: {
		weibo:"/u/weibo",
		my:function(index){
			return "/u/my/weibo/" + index;
		}
	},
	init:function(){
		
		$("#send").click(function( e ){
			
			var c =  $("#content");
			if( $.trim(c.val()) ){
				WEIBO.send( c );
			}
			
		});
		
		$(".pi").on("click", 'a', function( e ){
			e.preventDefault();
			
			var a = $( this );
			var index = a.attr("href");
			
			$.get(WEIBO.url.my(index),function(data){
				
				var list = $("#list").empty();
				
				$.each( data.list, function(i, weibo){
					
					var weibo = WEIBO.create( weibo );
					list.append( weibo  );
				});
				
				WEIBO.initPi( data );
				
				
			}, "json");
			
		});
	},
	send: function(content){
		var c = $.trim(content.val() );
		$.post( WEIBO.url.weibo, {"content": c}, function( data ){
			
			if( data.code == 200 ){
				var list = $("#list");
				var weibo = WEIBO.create( data.obj );
				list.prepend( weibo );
				content.val("");
			}
			
			
		}, "json" );
		
	},
	create:function(obj){
		
		var weibo = $('<div class="weibo"></div>');
		var content = $('<div class="content"></div>');
		var img = $('<img class="h" />').attr("src", "/assets/image/" + obj.account.pic);
		var dl = $('<dl></dl>');
		var dt = $('<dt></dt>');
			var a = $('<a href="javascript:void(0);"></a>').html( obj.account.name);
			dt.append(a);
		var dd = $('<dd></dd>');
			var i = $('<i></i>').html( obj.wdatetime );
			dd.append(i);
		var dd2 = $('<dd></dd>');
			var p = $('<p></p>').html( obj.content );
			dd2.append( p );
		dl.append( dt ).append( dd ).append( dd2 );
		content.append( img ).append( dl );
		
		
		var foot = $('<div class="foot"></div>');
		var ul = $('<ul class="clearfix"></ul>');
		var li = $('<li class="first"></li>');
			var comment = $('<a href="javascript:void(0);"></a>').html( "评论(" + obj.comment +  ")" );
			li.append( comment);
		var li2 = $('<li></li>');
			var liked = $('<a href="javascript:void(0);"></a>').html( "赞(" + obj.liked +  ")" );
			li2.append( liked );
		ul.append( li ).append( li2 ).appendTo( foot );
		
		weibo.append( content ).append( foot );
		
		return weibo;
	},
	initPi:function( obj ){
		var pi = $(".pi").empty();
		
		if( obj.current > 1 ){
			var prev = $('<a></a>').attr("href", obj.current - 1).html("上一页");
			pi.append( prev);
		}
		if( obj.current < obj.total ){
			var next = $('<a></a>').attr("href", obj.current + 1).html("下一页");
			pi.append( next );
		}
	}
		
		
};