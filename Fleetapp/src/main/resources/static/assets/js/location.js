$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(location ,status){
		$('#idEdit').val(location.id);
		$('#descriptionEdit').val(location.description);
		$('#cityEdit').val(location.city);
		$('#addressEdit').val(location.address);
		$('#ddlCountryEdit').val(location.countryid);
		$('#ddlStateEdit').val(location.stateid);
		$('#detailsEdit').val(location.details);
		
		
	});
    $('#editModal').modal('show');
  });
  
  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(location ,status){
		$('#idDetails').val(location.id);
		$('#descriptionDetails').val(location.description);
		$('#cityDetails').val(location.city);
		$('#addressDetails').val(location.address);
		$('#ddlCountryDetails').val(location.countryid);
		$('#ddlStateDetails').val(location.stateid);
		$('#detailsDetails').val(location.details);
		
		
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




