//Function that is called when the new user form is submitted. 
// Return false if there are any issues to prevent the submission
function validateForm()
{
	checkEmail();
	if(!checkEmailMatch())
	{
		$(".submitError").show(); 
		return false;
		
	}
	$(".submitError").hide();
	
	return true;
	
}

function checkEmailMatch()
{
	if($("#email").val() != $("#emailMatch").val())
		{
			$("#emailHighlight").addClass("error-state");
			$("#emailMatchHighlight").addClass("error-state");
			$(".emailMatchError").show();
			return false;
		}
	else
		{
			$("#emailHighlight").removeClass("error-state");
			$("#emailMatchHighlight").removeClass("error-state");
			$(".emailMatchError").hide();
			return true;
		}
}

function checkEmail()
{
	$.ajax({
	    url : 'validateEmail',
	    type: "POST",
	    data : 
	    {
	    	email : $("#email").val()
	    },
	    success : function(responseText) 
	    {
	    	console.debug(responseText);
	    	console.debug(responseText.emailExists);
	    	if(responseText.emailExists)
	    		{
	    			$("#emailHighlight").addClass("error-state");
	    			$(".emailError").show();
	    			return false;
	    		}
	    	else
	    		{
	    			$("#emailHighlight").removeClass("error-state");
	    			$(".emailError").hide();
	    			return true;
	    		}
	    }
	});
}