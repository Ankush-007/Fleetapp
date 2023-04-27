$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//Countries/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(vehiclemaintainance,status){
		$('#idEdit').val(vehiclemaintainance.id);
		$('#vehicleEdit').val(vehiclemaintainance.vehicleid);
		$('#startdateEdit').val(vehiclemaintainance.startdate);
		$('#remarksEdit').val(vehiclemaintainance.remarks);
		$('#enddateEdit').val(vehiclemaintainance.enddate);
		$('#supplierEdit').val(vehiclemaintainance.supplierid);
		$('#priceEdit').val(vehiclemaintainance.price);
		
	});
    $('#editModal').modal('show');
  });


  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//Countries/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(vehiclemaintainance,status){
		$('#idDetails').val(vehiclemaintainance.id);
		$('#vehicleDetails').val(vehiclemaintainance.vehicleid);
		$('#startdateDetails').val(vehiclemaintainance.startdate);
		$('#remarksDetails').val(vehiclemaintainance.remarks);
		$('#enddateAdd').val(vehiclemaintainance.enddate);
		$('#supplierDetails').val(vehiclemaintainance.supplierid);
		$('#priceDetails').val(vehiclemaintainance.price);
		
	});
    $('#detailsModal').modal('show');
  });




  

  // Hide modal when close button is clicked
  $('.close').on('click', function(){
    $('#editModal').modal('hide');
  });
});




