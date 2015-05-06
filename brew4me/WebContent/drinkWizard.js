/* * * * * * * * * *
 * Status : Used
 * * * * * * * * * */

$(document).ready(function() 
{
	var message = ["Try Again.", "Lol you clicked what?", "Very Funny, now choose one", "So You're one of those people eh?"];
	//Q1 : beer or wine
	$(".beerQuestion").click(function()
	{
		$(".question").hide();
		$(".q2").show();
		$('#wizardStep').stepper('next');
	});
	
	$(".wineQuestion").click(function()
	{
		$(".question").hide();
		$(".q2").show();
		$('#wizardStep').stepper('next');
	});
	
	//Q2 : sweet middle or bitter
	$(".sweetQ").click(function()
	{
		$(".question").hide();
		$(".q3").show();
		$('#wizardStep').stepper('next');
	});
	
	$(".mediumQ").click(function()
	{
		$(".question").hide();
		$(".q3").show();
		$('#wizardStep').stepper('next');
	});
	
	$(".bitterQ").click(function()
	{
		$(".question").hide();
		$(".q3").show();
		$('#wizardStep').stepper('next');
	});
	
	//Q3 : cats or dogs
	$(".dogQ").click(function()
	{
		$(".question").hide();
		$(".q4").show();
		$('#wizardStep').stepper('next');
	});
	
	$(".catQ").click(function()
	{
		$(".question").hide();
		$(".q4").show();
		$('#wizardStep').stepper('next');
	});
	
	$(".noneQ").click(function()
	{
		console.debug(Math.floor(Math.random() * 4));
		console.debug(message[0]);
		console.debug(message[1]);
		console.debug(message[2]);
		console.debug(message[3]);
		$("#wrongChoice").text(message[Math.floor(Math.random() * 4)]);
	});
	
	//Q4
	$(".yolo").click(function()
	{
		$(".question").hide();
		$(".q5").show();
		$('#wizardStep').stepper('next');
	});
	
	$(".calm").click(function()
	{
		$(".question").hide();
		$(".q5").show();
		$('#wizardStep').stepper('next');
	});
	$(".crazy").click(function()
	{
		$(".question").hide();
		$(".q5").show();
		$('#wizardStep').stepper('next');
	});
	$(".casual").click(function()
	{
		$(".question").hide();
		$(".q5").show();
		$('#wizardStep').stepper('next');
	});
	
	
	
});