/* * * * * * * * * *
 * Status : Used
 * * * * * * * * * */

$(document).ready(function() 
{
	$(".allPages").hide();
	$(".adminElement").hide();
	$(".home").show();
	
	$(".question").hide();
	$(".q1").show();
	
	$.ajax({
	    url : 'getUser',
	    type: "POST",
	    success : function(responseText) 
	    {
	    	$.ajax({
	    	    url : 'getUserRole',
	    	    type: "POST",
	    	    data : 
			    {
			        email : responseText
			    },
	    	    success : function(user_role) 
	    	    {
	    	    	if(user_role == "admin")
    	    		{
	    	    		$(".adminElement").show();
    	    		}
	    	        console.debug("User role: " + user_role);
	    	    }
	    	});
	    	
	    	$("#username").text(responseText);
	        console.debug("Current User: " + responseText);
	    }
	});
	
	$(".homeNav").click(function()
	{
		$(".allPages").hide();
		$(".home").show();
		console.debug("homeNav");
	});
	
	$(".searchBeerNav").click(function()
	{
		$(".allPages").hide();
		$(".searchBeer").show();
		console.debug("searchBeerNav");
	});
	
	$(".searchWineNav").click(function()
	{
		$(".allPages").hide();
		$(".searchWine").show();
		console.debug("searchWineNav");
	});
	
	$(".drinkWizardNav").click(function()
	{
		$(".allPages").hide();
		$(".drinkWizard").show();
		
		$(".question").hide();
		$(".q1").show();
		$('#wizardStep').stepper('first');
		
		console.debug("drinkWizardNav");
	});
	
	$(".recommendNav").click(function()
	{
		$(".allPages").hide();
		$(".recommend").show();
		console.debug("recommendNav");
	});
	
	$("#advanceSearchLink").click(function()
	{
		$(".advancedSearch").toggle(100);
		$(".home").toggleClass("marginHome");
		console.debug("advancedSettings");
	});
	
	$(".userProfile").click(function()
	{
		$(".allPages").hide();
		$(".userProfile").show();
		console.debug("userProfile");
	});
	
	$(".deleteAccount").click(function()
	{
		if($("#username").text() != 'guest')
		{
			if (confirm("Do you want to delete your account?\nThis can not be undone!") == true)
			{
				$.ajax({
		    	    url : 'deleteUser',
		    	    type: "POST",
		    	    data : 
				    {
				        email : $("#username").text()
				    },
		    	    success : function(user_role) 
		    	    {
		    	    	window.location.href = '/brew4me/logout.jsp';
		    	    }
				});
			}
		}
	});
	
	$("#rating1").rating(
	{
		score: 0,
        half: false,
        stars: 5,
        static: false,
        click: function(value, rating)
        {
        	rating.rate(value);
        	console.debug("Value: " + value + "\nRating: " + rating);
        }
    });
	
	$("#favHeart").click(function(){
		$("#favHeart").toggleClass("icon-heart-2 icon-heart");
	});
	
	$("#favorite").rating(
			{
				score: 0,
		        half: false,
		        stars: 5,
		        static: false,
		        click: function(value, rating)
		        {
		        	rating.rate(value);
		        	console.debug("Value: " + value + "\nRating: " + rating);
		        }
		    });
	
	
	$("#clickMe").click(function()
			{
				$.ajax({
				    url : 'QueryBeer',
				    type: "POST",
				    data : 
				    {
				        userName : $('#userName').val()
				    },
				    success : function(responseText) 
				    {
				        $('#ajaxGetUserServletResponse').append(responseText);
				    }
				});
			});
	
	
	var colors = ["#FEE799", "#FDD978", "#FDCB5A", "#FCC143", "#F7B324", "#F5A800",
	              "#EE9E00", "#E69100", "#E38901", "#DA7E01", "#D37400", "#CB6C00", 
	              "#C66401", "#BF5C01", "#B65300", "#B04F00", "#AC4701", "#A24001", 
	              "#9C3900", "#963500", "#912F00", "#8C2D01", "#832501", "#7E1F01", 
	              "#771C01", "#721B00", "#6C1501", "#670F01", "#620F01", "#5B0D01",
	              "#560C03", "#5D0A02", "#500A08", "#4A0605", "#440706", "#420807", 
	              "#3C0908", "#390708", "#39080B", "#35090A"];
	
	for(i = 0; i < 40; i++)
	{
		$("#colorAppend").append("<span class='colorElement' style='background-color: " + colors[i] + ";'></span>");
		//console.debug("Color: " + getBeerColor(i));
	}
	
	
	$("#colorAppend").on("click", ".colorElement", function(e)
	{
		var inputColor = $(this).attr("style").substr($(this).attr("style").indexOf("#"), 7 )
		console.debug(inputColor);
		$(".colorElement").removeClass("colorSelected");
		$(this).addClass("colorSelected");
		
		for(i = 0; i < 40; i++)
		{
			if(inputColor == colors[i] )
			{
				$("#colorCode").val(i + 1);
				console.debug("Color Number: " + i);
				break;
			}
		}
	});
	
	$( "#slider-range" ).slider(
	{
		range: true,
		min: 0,
		max: 20,
		values: [ 0, 20 ],
		slide: function( event, ui ) 
		{
			$( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
			$("#minPrice").val(ui.values[ 0 ]);
			$("#maxPrice").val(ui.values[ 1 ]);
		}
    });
	
	$("#minPrice").val($("#slider-range").slider( "values", 0 ));
	$("#maxPrice").val($("#slider-range").slider( "values", 1 ));
	
    $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
	      " - $" + $( "#slider-range" ).slider( "values", 1 ) );
    
    
    	
	
});

