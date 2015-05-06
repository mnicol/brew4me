<!doctype html>
<html lang="en">
    <head>
        <title>Beer</title>
        
        <script src="jquery-1.11.2.min.js"></script>
		<script src="findBeer.js"></script>
		
		<script src="Metro-UI-CSS-master/docs/js/jquery/jquery.widget.min.js"></script>
		<script src="Metro-UI-CSS-master/docs/js/jquery/jquery.mousewheel.js"></script>
		<script src="Metro-UI-CSS-master/docs/js/metro.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="Metro-UI-CSS-master/docs/css/metro-bootstrap.css">
		<link rel="stylesheet" type="text/css" href="Metro-UI-CSS-master/docs/css/metro-bootstrap-responsive.css">
		<link rel="stylesheet" type="text/css" href="Metro-UI-CSS-master/docs/css/iconFont.css">
		
		<link rel="stylesheet" type="text/css" href="findBeer.css">
		
		<link rel="icon" type="image/png" href="beer_mug.png">
		
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		<script src="https://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
    </head>
    <body class="metro">
 		<div class="result">
 			<center>
	 			<h3>Does This Beer Look Good?</h3>
	 			<hr>
	 			<br/>
	 			<p>Name: ${name}</p>
	 			<p>Brewery: ${brewery}</p>
	 			<p>Style: ${style}</p>
	 			<p>Color: ${color}</p>
	 			<p>ABV: ${abv}</p>
	 			<p>Mouthfeel: ${mouthfeel}</p>
	 			<p>Price: ${price}</p>
	 			<p>Rating: ${rating}</p>
	 			<br/>
	 			<br/>
	 			<br/>
	 			<a id="findNewBeer" href="#">Find Me A Different Beer!</a>
	 			<br/>
	 			<br/>
	 			<a href="/brew4me/">Take Me Home!</a>
 			</center>
 		</div>
    </body>
</html>