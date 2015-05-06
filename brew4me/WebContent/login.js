$(function() {
	
	$(".errorText").hide();
	
	$(".panel-content").css("height", "350px");
	
	//Function that logs in as the guest account when the icon is clicked
	$("#guestLogin").click(function()
			{
				$("#usernameHidden").val("guest");
				$("#passwordHidden").val("Guest");
				$("#loginFormHidden").submit();
			});
	
	$("#close").click(function()
			{
				$(".infoPopup").addClass("hidden");
			});
	$("#whyAccount").click(function()
			{
				$(".infoPopup").removeClass("hidden");
			});

  });
