



$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(invoicestatus ,status){
		$('#idEdit').val(invoicestatus.id);
		$('#descriptionEdit').val(invoicestatus.description);

		$('#detailsEdit').val(invoicestatus.details);
		
		
	});
    $('#editModal').modal('show');
  });
  
  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(invoicestatus ,status){
		$('#idDetails').val(invoicestatus.id);
		$('#descriptionDetails').val(invoicestatus.description);

		$('#detailsDetails').val(invoicestatus.details);
		
		
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




