$(document).ready(function(){
  // Show modal when button is clicked
  $('table #editButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(invoice ,status){
		$('#idEdit').val(invoice.id);
		$('#ddlClientEdit').val(invoice.clientid);
		$('#invoiceDateEdit').val(invoice.invoiceDate);
		$('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);
		$('#remarksEdit').val(invoice.remarks);
		
		
	});
    $('#editModal').modal('show');
  });
  
  $('table #detailButton').on('click', function(event){
	event.preventDefault();
	
	//states/findById
	
	var href = $(this).attr('href');
	
	$.get(href,function(invoice ,status){
		$('#idDetails').val(invoice.id);
		$('#ddlClientDetails').val(invoice.clientid);
		$('#invoiceDateDetails').val(invoice.invoiceDate);
		$('#ddlInvoiceStatusDetails').val(invoice.invoicestatusid);
		$('#remarksDetails').val(invoice.remarks);
		
		
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




