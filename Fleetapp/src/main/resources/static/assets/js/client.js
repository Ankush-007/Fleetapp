



$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(client ,status){
		$('#idEdit').val(client.id);
		$('#nameEdit').val(client.name);
		$('#detailsEdit').val(client.details);
		$('#websiteEdit').val(client.website);
		$('#addressEdit').val(client.address);
		$('#ddlCountryEdit').val(client.countryid);
		$('#ddlStateEdit').val(client.stateid);
		$('#cityEdit').val(client.city);
		$('#phoneEdit').val(client.phone);
		$('#mobileEdit').val(client.mobile);
		$('#emailEdit').val(client.email);
		
		
	});
    $('#editModal').modal('show');
  });
  
  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(client ,status){
		$('#iddetails').val(client.id);
		$('#namedetails').val(client.name);
		$('#detailsdetails').val(client.details);
		$('#websitedetails').val(client.website);
		$('#addressdetails').val(client.address);
		$('#ddlCountrydetails').val(client.countryid);
		$('#ddlStatedetails').val(client.stateid);
		$('#citydetails').val(client.city);
		$('#phonedetails').val(client.phone);
		$('#mobiledetails').val(client.mobile);
		$('#emaildetails').val(client.email);
		
		
	});
    $('#detailsModal').modal('show');
  });

       $('.close').on('click', function(){
    $('#detailsModal').modal('hide');
  });







  // Hide modal when close button is clicked
  $('.close').on('click', function(){
    $('#editModal').modal('hide');
  });
  


  
});




