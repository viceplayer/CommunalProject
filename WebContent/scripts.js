
$(document).ready(function(){
	show()
	
	
	
});

function show(){
	var folderManager = $('.folderManager')
	var data = $('.data')
	
	

	$.get("ObjectServlet", function(responseJson) {      
        $.each(responseJson, function(index, Object) {    
        	$("<li>").text(Object.name).addClass("Type"+Object.type).attr("id",""+Object.id).appendTo(data);
        });
        $("<li>").text("Add").addClass("Add").appendTo(data);
    });
	
	
	
	
}

function ticketStyle(ticket,user,dedalaini,company,money){
	var text = '<li class=ticket><div><div class=title1>ქვითრის ნომერი:</div><div class = number>';
	text+=ticket;
	text+='</div><div class = title2>გადახდის ვადა</div></div><div><div class = title1>მომხმარებელი:</div><div class = number>';
	text+=user;
	text+='</div><div class = dedaline>';
	text+=dedalaini;
	text+='</div></div><div><div class = title1>';
	text+=company;
	text+='</div><div class = number>';
	text+=money;
	text+='</div><button class = pay>ადახდა</button></li>';
	return text;
}

$(document).on("click", ".Type0, .Type1, .Type2", function (ev) {
	var folderManager = $('.folderManager')
	var data = $('.data')
	data.empty()
	
	$("<li>").text("Add").addClass("Add1").attr("id",ev.target.id).appendTo(data);
	$("<li>").text("Back").addClass("Back").appendTo(data);
	$.get("TicketServlet",{id: ev.target.id}, function(responseJson) {      
        $.each(responseJson, function(index, Ticket) { 
        	$.get("InfoServlet",{ticket: Ticket.ticket,companyId: Ticket.companyId}, function(responseJson) { 
        		
        		var temp = ticketStyle(Ticket.ticket,responseJson[3],responseJson[2],responseJson[0],responseJson[1]);
        		$(temp).appendTo(data);
        		
        	});
        	
        });
      
    });
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



