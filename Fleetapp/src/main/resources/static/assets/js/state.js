$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(state ,status){
		$('#idEdit').val(state.id);
		$('#ddlCountryEdit').val(state.countryid);
		$('#nameEdit').val(state.name);
		$('#codeEdit').val(state.code);
		$('#capitalEdit').val(state.capital);
		$('#detailsEdit').val(state.details);
		
		
	});
    $('#editModal').modal('show');
  });
  
  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(state ,status){
		$('#idDetails').val(state.id);
		$('#ddlCountryDetails').val(state.countryid);
		$('#nameDetails').val(state.name);
		$('#codeDetails').val(state.code);
		$('#capitalDetails').val(state.capital);
		$('#detailsDetails').val(state.details);
		
		
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




