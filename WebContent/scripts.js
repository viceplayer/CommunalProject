
$(document).ready(function(){
	var folderManager = $('.folderManager')
	var data = $('.data')
	
	
	$("<li>").text("Add").addClass("Add").attr("href", "http://localhost:8080/CommunalProject/Add.jsp").appendTo(data);
	$.get("ObjectServlet", function(responseJson) {      
        $.each(responseJson, function(index, Object) {    
        	$("<li>").text(Object.name).addClass(""+Object.type).appendTo(data);
        });
    });
	
	
	
	$( ".Add" ).on( "click", function() {
		window.location.href = ("http://localhost:8080/CommunalProject/Add.jsp");
	});
	
	
});

