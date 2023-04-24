



$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(jobtitle ,status){
		$('#idEdit').val(jobtitle.id);
		$('#descriptionEdit').val(jobtitle.description);

		$('#detailsEdit').val(jobtitle.details);
		
		
	});
    $('#editModal').modal('show');
  });
  
  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(jobtitle ,status){
		$('#idDetails').val(jobtitle.id);
		$('#descriptionDetails').val(jobtitle.description);

		$('#detailsDetails').val(jobtitle.details);
		
		
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




