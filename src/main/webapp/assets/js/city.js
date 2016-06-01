var CITY = {
	init:function()
	{
		
		
		//设置展开收起按钮的事件
		$(".opspread").click(function()
		{
			CITY.cityspread($(this));
		});
		$(".opputaway").click(function()
		{
			CITY.cityputaway($(this));
		});
		$(".cityname").click(function()
		{
			
			CITY.findcityinfo($(this));
		});
	},
	citycreate:function(obj)
	{
		var city = $('<li class="city"></li>');
		var cityId = $('<a class="hidden"></a>').html(obj.cityId);
		var cityName = $('<a class="cityname"></a>').html(obj.cityName);
		cityName.click(function(){
			CITY.findcityinfo($(this));
		}
		);
		var buttonspread = $('<input type="button" class="opspread" value="展开"/>');
		buttonspread.click(function()
		{
			CITY.cityspread($(this));
		});
		var buttonputaway = $('<input type="button" class="opputaway hidden" value="收起"/>')
		buttonputaway.click(function()
		{
			CITY.cityputaway($(this));
		});
		city.append(cityId).append(cityName).append(buttonspread).append(buttonputaway);		
		return city;
	},
	cityspread:function( element )
	{
		var thiscity = $( element ).parent();
		var a = thiscity.children().first().html();
		$.get("/city/findchildrenbyid/"+a,function(data){
			var ccitylist = $('<ul class="citylist"></ul>');
			$.each( data, function(i, city){
				var city = CITY.citycreate(city);
				ccitylist.append(city);
			});
			thiscity.append(ccitylist);
		}, "json");
		$(element).addClass("hidden");
		var opp = $(element).next();
		opp.removeClass("hidden");
	},
	cityputaway:function( element )
	{
		var thiscity = $(element).parent();
		thiscity.children().last().addClass("hidden");
		$(element).addClass("hidden");
		var ops = $(element).prev();
		ops.removeClass("hidden");
	},
	findcityinfo:function( element )
	{
		//获得选中城市的id
		var thiscity = $( element ).parent();
		var a = thiscity.children().first().html();
		
		$.get("/city/findcitybyid/"+a,function(city){
			
			var cityinfo = $(".cityinfo").find("input");
			cityinfo.first().val(city.cityId);
			cityinfo.first().next().val(city.cityName);
			cityinfo.first().next().next().val(city.parentCityId);
			cityinfo.first().next().next().next().val(city.remark);
			
		},"json");
	}
};