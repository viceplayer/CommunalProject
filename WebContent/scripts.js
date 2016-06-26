
$(document).ready(function(){
	var folderManager = $('.folderManager')
	var data = $('.data')

	$.get("ObjectServlet", function(responseJson) {      
        $.each(responseJson, function(index, Object) {    
        	$("<li>").text(Object.name).addClass(""+Object.type).appendTo(data);
        });
    });
	
});