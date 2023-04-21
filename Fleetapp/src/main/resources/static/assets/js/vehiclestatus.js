



$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(vehiclestatus ,status){
		$('#idEdit').val(vehiclestatus.id);
		$('#descriptionEdit').val(vehiclestatus.description);

		$('#detailsEdit').val(vehiclestatus.details);
		
		
	});
    $('#editModal').modal('show');
  });
  
  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(vehiclestatus ,status){
		$('#idDetails').val(vehiclestatus.id);
		$('#descriptionDetails').val(vehiclestatus.description);

		$('#detailsDetails').val(vehiclestatus.details);
		
		
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




