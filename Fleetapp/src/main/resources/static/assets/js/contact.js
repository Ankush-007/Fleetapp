$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//contacts/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(contact ,status){
		$('#idEdit').val(contact.id);
		$('#firstnameEdit').val(contact.firstname);
		$('#lastnameEdit').val(contact.lastname);
		$('#phoneEdit').val(contact.phone);
		$('#mobileEdit').val(contact.mobile);
		$('#emailEdit').val(contact.email);
		$('#remarksEdit').val(contact.remarks);
		
		
	});
    $('#editModal').modal('show');
  });
  
  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//contacts/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(contact ,status){
		$('#idDetails').val(contact.id);
		$('#firstnameDetails').val(contact.firstname);
		$('#lastnameDetails').val(contact.lastname);
		$('#phoneDetails').val(contact.phone);
		$('#mobileDetails').val(contact.mobile);
		$('#emailDetails').val(contact.email);
		$('#remarksDetails').val(contact.remarks);
		
		
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




