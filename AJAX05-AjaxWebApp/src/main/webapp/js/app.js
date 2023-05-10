$(document).ready(function(){
	$.ajax({
		url : "countryServlet",
		cache : false,
		dataType : "json",
		success : function(result){
			$.each(result,function(key,value){
				$("<option>").val(key).text(value).appendTo("#country");
			});
		}
	});	
});

$(document).on("change","#country",function(){
	$("#state").find("option").remove();
	$("<option>").val("").text("---select state---").appendTo("#state");
	$("#city").find("option").remove();
	$("<option>").val("").text("---select city---").appendTo("#city");
	
	var selectedCountryId=$("#country").val();
	
	$.ajax({
		url : "stateServlet",
		data :{
			countryId : selectedCountryId
		},
		dataType : "json",
		success : function(result){
			$.each(result,function(key,value){
				$("<option>").val(key).text(value).appendTo("#state");
			});
		}
	});
});

$(document).on("change","#state",function(){
	$("#city").find("option").remove();
	$("<option>").val("").text("---select city---").appendTo("#city");
	
	var selectedStateId=$("#state").val();
	
	$.ajax({
		url : "cityServlet",
		data : {
			stateId : selectedStateId
		},
		dataType : "json",
		success : function(result){
			$.each(result,function(key,value){
				$("<option>").val(key).text(value).appendTo("#city");
			});
		}
	});
});