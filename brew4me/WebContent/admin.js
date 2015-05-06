$(document).ready(function() 
{
	$(".all").hide();
	
	$(".getTable").click(function(e)
	{
		alert($(e.target).attr('id'));
		
		/*$.ajax({
		    url : 'requestTable',
		    type: "POST",
		    data : 
		    {
		    	table : $(e.target).attr('id');
		    },
		    success : function(responseText) 
		    {
		        $('#console_out').append(responseText);
		    }
		});*/
	});
	
	$("#viewTable").click(function()
	{
			$(".all").hide();
			$(".viewTable").show();
	});
	$("#editBeer").click(function()
	{
			$(".all").hide();
			$(".editBeer").show();
	});
	$("#beerFlavor").click(function()
	{
			$(".all").hide();
			$(".beerFlavor").show();
	});
	$("#beerHas").click(function()
	{
			$(".all").hide();
			$(".beerHas").show();
	});
	$("#beerRate").click(function()
	{
			$(".all").hide();
			$(".beerRate").show();
	});
	$("#brewery").click(function()
	{
			$(".all").hide();
			$(".brewery").show();
	});
	$("#person").click(function()
	{
			$(".all").hide();
			$(".person").show();
	});
	$("#userRoles").click(function()
	{
			$(".all").hide();
			$(".userRoles").show();
	});
	$("#vineyard").click(function()
	{
			$(".all").hide();
			$(".vineyard").show();
	});
	$("#wine").click(function()
	{
			$(".all").hide();
			$(".wine").show();
	});
	$("#wineFlavor").click(function()
	{
			$(".all").hide();
			$(".wineFlavor").show();
	});
	$("#wineHas").click(function()
	{
			$(".all").hide();
			$(".wineHas").show();
	});
	$("#wineRates").click(function()
	{
			$(".all").hide();
			$(".wineRates").show();
	});
	$("#query").click(function()
	{
			$(".all").hide();
			$(".query").show();
	});
	
	
	//Clicking on row to edit it
	$(document).on("click", "tr.tableClick",  function()
	{
	    var tableData = $(this).children("td").map(function()
	    {
	        return $(this).text();
	    }).get();

	    console.debug(tableData);
	});
	
	/*$( "table" ).delegate( "td", "click", function() {
		  $( this ).toggleClass( "chosen" );
		});*/
	
	
});