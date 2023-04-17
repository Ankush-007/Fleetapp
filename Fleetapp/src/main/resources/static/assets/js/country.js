$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//Countries/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(country,status){
		$('#idEdit').val(country.id);
		$('#capitalEdit').val(country.capital);
		$('#codeEdit').val(country.code);
		$('#continentEdit').val(country.continent);
		$('#descriptionEdit').val(country.description);
		$('#nationalityEdit').val(country.nationality);
		
	});
    $('#editModal').modal('show');
  });
  
   // Show modal when button is clicked
  $('table #deleteButton').on('click', function(event){
	event.preventDefault();
	
	$('#deleteModal').modal();
  });
  
  
  
  
  
  // Hide modal when close button is clicked
  $('.close').on('click', function(){
    $('#addModal').modal('hide');
  });
});