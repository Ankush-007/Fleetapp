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


  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//Countries/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(country,status){
		$('#idDetails').val(country.id);
		$('#capitalDetails').val(country.capital);
		$('#codedetails').val(country.code);
		$('#continentdetails').val(country.continent);
		$('#descriptiondetails').val(country.description);
		$('#nationalitydetails').val(country.nationality);
		
	});
    $('#detailsModal').modal('show');
  });




  

  // Hide modal when close button is clicked
  $('.close').on('click', function(){
    $('#editModal').modal('hide');
  });
});




