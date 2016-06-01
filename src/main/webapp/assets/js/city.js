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
		//查看city的相关信息
		$(".cityname").click(function()
		{
			
			CITY.findcityinfo($(this));
		});
		//展开
		
	},
	//city相关
	citycreate:function(obj)
	{
		var city = $('<li class="city"></li>');
		var cityId = $('<a class="hidden"></a>').html(obj.cityId);
		var cityName = $('<a class="cityname"></a>').html(obj.cityName);
		cityName.click(function()
		{
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
		$(".cityinfo").removeClass("hidden");
		$(".citypage").addClass("hidden");
		var thiscity = $( element ).parent();
		var a = thiscity.children().first().html();
		
		$.get("/city/findcitybyid/"+a,function(city){
			
			var cityinfo = $(".cityinfo").find("li");
			
			cityinfo.first().children().val(city.cityId);
			cityinfo.first().next().children().val(city.cityName);
			cityinfo.first().next().next().children().val(city.parentCityId);
			cityinfo.first().next().next().next().children().val(city.remark);
			
			var a = cityinfo.first().children().val();
			
			
			$.get("/area/findareabycityid/"+a,function(data)
			{
				
				var areatable = $(".areapage").children().first();
				areatable.empty();
				areatable.append('<tr><td>区域编号</td><td>区域名称</td><td>包含片区</td><td>区域简介</td></tr>')
				$.each( data , function( i , area )
				{
					
					var Area = CITY.createarea( area );
					
					areatable.append( Area );
					
				});
				
			},"json")
			
		},"json");
	},
	//area相关
	createarea:function( area )
	{
		
		var Area = $('<tr></tr>');
		
		var areaId = $('<td></td>').html(area.areaId);
		
		var areaName = $('<td></td>').html(area.areaName);
		var buttondisspread = $('<input value="展开" type="button">');
		var buttondisputaway = $('<input value="收起" class = "hidden" type="button">');
		var district = $('<td></td>').append(buttondisspread).append(buttondisputaway);
		buttondisspread.click(function()
		{
			var areaId = $(this).parent().parent().children().first().html();
			
			var uldis = CITY.createuldis(areaId);
			
			$(this).parent().append(uldis);
			$(this).addClass("hidden");
			$(this).next().removeClass("hidden");
		});
		buttondisputaway.click(function()
		{
			$(this).next().remove();
			$(this).addClass("hidden");
			$(this).prev().removeClass("hidden");
		});
		var remark = $('<td></td>').html(area.remark);
		Area.append(areaId).append(areaName).append(district).append(remark);
		
		return  Area;
	},
	//district相关
	createuldis:function(areaId)
	{
		var uldis = $('<ul></ul>');
		uldis.css("padding-left","0");
		$.get("/district/finddistrictbyareaid/"+areaId,function(data)
		{
			$.each(data,function(i,district){
				var districtName=$('<li></li>').html(district.districtName);
				
				uldis.append(districtName);
			});	
		},"json");
		return uldis;
	}
};