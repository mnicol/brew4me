<title>Successful logout</title>
<link rel="icon" type="image/png" href="/images/beer_mug.png">
<link rel="stylesheet" type="text/css" href="logout.css">


<div class="center">
	<%@ page session="true"%>
	
	User '<%=request.getRemoteUser()%>' has been logged out.
	
	<% session.invalidate(); %>
	
	<br/><br/>
	<a href="/brew4me/">Click here to return to Brew4me</a>
</div>