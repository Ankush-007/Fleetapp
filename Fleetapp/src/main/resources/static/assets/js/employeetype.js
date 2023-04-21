



$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(employeetype ,status){
		$('#idEdit').val(employeetype.id);
		$('#descriptionEdit').val(employeetype.description);

		$('#detailsEdit').val(employeetype.details);
		
		
	});
    $('#editModal').modal('show');
  });
  
  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(employeetype ,status){
		$('#idDetails').val(employeetype.id);
		$('#descriptionDetails').val(employeetype.description);

		$('#detailsDetails').val(employeetype.details);
		
		
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




