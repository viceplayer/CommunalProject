
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

function ticketStyle(ticket,user,dedalaini,company,money,companyId,objectId){
	var text = '<li class=ticket id='
	text+=objectId;
	text+='><div><div class=title1>ქვითრის ნომერი:</div><div class = number>';
	text+=ticket;
	text+='</div><div class = title2>გადახდის ვადა</div></div><div><div class = title1>მომხმარებელი:</div><div class = number>';
	text+=user;
	text+='</div><div class = dedaline>';
	text+=dedalaini;
	text+='</div></div><div><div class = title1>';
	text+=company;
	text+='</div><div class = number>';
	text+=money;
	text+='</div><button class = pay id =';
	text+=companyId;
	text+='>ადახდა</button><button class = delTic id ='
	text+=companyId;
	text+='>ქვითრის წაშლა</button></li>';
	return text;
}

$(document).on("click", ".Type0, .Type1, .Type2", function (ev) {
	var folderManager = $('.folderManager')
	var data = $('.data')
	data.empty()
	
	$("<li>").text("Add").addClass("Add1").attr("id",ev.target.id).appendTo(data);
	$("<li>").text("Back").addClass("BackNot").appendTo(data);
	$("<li>").text("Delete Object").addClass("Delete").attr("id",ev.target.id).appendTo(data);
	
	jQuery.ajaxSetup({async:false});
	$.get("TicketServlet",{id: ev.target.id}, function(responseJson) {      
        $.each(responseJson, function(index, Ticket) { 
        	$.get("InfoServlet",{ticket: Ticket.ticket,companyId: Ticket.companyId}, function(responseJson) { 
        		
        		var temp = ticketStyle(Ticket.ticket,responseJson[3],responseJson[2],responseJson[0],responseJson[1],Ticket.companyId,ev.target.id);
        		$(temp).appendTo(data);
        		
        	});
        	
        });
        
      
    });
	$(".BackNot").toggleClass('Back');
	
	
});

$(document).on("click", ".Back", function (ev) {
	var data = $('.data')
	data.empty()
	show()
});

$(document).on("click", ".pay", function (ev) {
	var path = "Pay.jsp"
	path+="?companyId="
	path+=ev.target.id;
	path+="&objectId="
	path+=ev.target.parentNode.parentNode.id
	
	
	paymentWindow = window.open(path, "paymentWindow", "location=no,width=500,height=300"); 
});




$(document).on("click", ".Add", function (ev) {
	window.location.href = ("http://localhost:8080/CommunalProject/AddObject.jsp");
});

$(document).on("click", ".Add1", function (ev) {
	window.location.href = ("http://localhost:8080/CommunalProject/AddTicket.jsp?id=" + ev.target.id);
});

$(document).on("click", "#close", function (ev) {
	if(window.opener && !window.opener.closed){
		window.opener.location.href = window.opener.location.href;
	}
	window.close();
});

$(document).on("click", ".Delete", function (ev) {
	if (confirm('Delete object?')) {
		$.get("DeleteObjectServlet",{objectId:ev.target.id}, function(responseJson) {      
			var data = $('.data')
			data.empty()
			show()
	        	
	        	
	    });
	} 
	
	
	
});


$(document).on("click", ".delTic", function (ev) {
	if (confirm('Delete ticket?')) {
		$.get("DeleteTicketServlet",{objectId:ev.target.parentNode.parentNode.id,companyId:ev.target.id}, function(responseJson) {      
			var data = $('.data')
			data.empty()
			show()
	        	
	        	
	    });
	} 
	
	
	
});





