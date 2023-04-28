$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//Countries/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(vehiclemovement,status){
		$('#idEdit').val(vehiclemovement.id);
		$('#vehicleEdit').val(vehiclemovement.vehicleid);
		$('#location1Edit').val(vehiclemovement.locationid1);
		$('#date1Edit').val(vehiclemovement.date1);
		$('#location2Edit').val(vehiclemovement.locationid2);
		$('#date2Edit').val(vehiclemovement.date2);
		$('#remarksEdit').val(vehiclemovement.remarks);
		
	});
    $('#editModal').modal('show');
  });


  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//Countries/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(vehiclemovement,status){
		$('#idDetails').val(vehiclemovement.id);
		$('#vehicleDetails').val(vehiclemovement.vehicleid);
		$('#location1Details').val(vehiclemovement.locationid1);
		$('#date1Details').val(vehiclemovement.date1);
		$('#location2Details').val(vehiclemovement.locationid2);
		$('#date2Details').val(vehiclemovement.date2);
		$('#remarksDetails').val(vehiclemovement.remarks);
		
	});
    $('#detailsModal').modal('show');
  });




  

  // Hide modal when close button is clicked
  $('.close').on('click', function(){
    $('#editModal').modal('hide');
  });
});




