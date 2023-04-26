$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//suppliers/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(supplier ,status){
		$('#idEdit').val(supplier.id);
		$('#nameEdit').val(supplier.name);
		$('#detailsEdit').val(supplier.details);
		$('#websiteEdit').val(supplier.website);
		$('#addressEdit').val(supplier.address);
		$('#ddlStateEdit').val(supplier.stateid);
		$('#ddlCountryEdit').val(supplier.countryid);
		$('#cityEdit').val(supplier.city);
		$('#phoneEdit').val(supplier.phone);
		$('#mobileEdit').val(supplier.mobile);
		$('#emailEdit').val(supplier.email);
		
		
	});
    $('#editModal').modal('show');
  });
  
  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//suppliers/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(supplier ,status){
		$('#idDetails').val(supplier.id);
		$('#nameDetails').val(supplier.name);
		$('#detailsDetails').val(supplier.details);
		$('#websiteDetails').val(supplier.website);
		$('#addressDetails').val(supplier.address);
		$('#ddlStateDetails').val(supplier.stateid);
		$('#ddlCountryDetails').val(supplier.countryid);
		$('#cityDetails').val(supplier.city);
		$('#phoneDetails').val(supplier.phone);
		$('#mobileDetails').val(supplier.mobile);
		$('#emailDetails').val(supplier.email);
		
		
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




