
$(document).ready(function(){
	show()
	
	
	
});

function show(){
	var folderManager = $('.folderManager')
	var data = $('.data')
	
	
	$("<li>").text("Add").addClass("Add").appendTo(data);
	$.get("ObjectServlet", function(responseJson) {      
        $.each(responseJson, function(index, Object) {    
        	$("<li>").text(Object.name).addClass("Type"+Object.type).attr("id",""+Object.id).appendTo(data);
        });
    });
	
	
	
}

$(document).on("click", ".Type0, .Type1, .Type2", function (ev) {
	var folderManager = $('.folderManager')
	var data = $('.data')
	data.empty()
	$("<li>").text("Add").addClass("Add1").attr("id",ev.target.id).appendTo(data);
	$("<li>").text("Back").addClass("Back").appendTo(data);
});

$(document).on("click", ".Back", function (ev) {
	var data = $('.data')
	data.empty()
	show()
});



$(document).on("click", ".Add", function (ev) {
	window.location.href = ("http://localhost:8080/CommunalProject/AddObject.jsp");
});

$(document).on("click", ".Add1", function (ev) {
	window.location.href = ("http://localhost:8080/CommunalProject/AddTicket.jsp?id=" + ev.target.id);
});



