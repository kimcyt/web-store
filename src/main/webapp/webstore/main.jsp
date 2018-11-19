<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>main</title>
<link href="main.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<%@ include file="header.jsp"%>
		
		<div class="row" >
			<div id="carouselIndicators" class="carousel slide col-md-12 ads"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselIndicators" data-slide-to="1"></li>
					<li data-target="#carouselIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100"
							src="/webstorepractise/images/u=547447817,3063273168&fm=200&gp=0.jpg"
							alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100"
							src=".../800x400?auto=yes&bg=666&fg=444&text=Second slide"
							alt="Second slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>

		<div class="on_sale" >
			<div class="title row">
				<h2>Items On Sale</h2> 
			</div>
				<ul class="row">
					<li class="items col-3 h-60">
						<a href=""> <img src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg"></a>
						<p class="item-name">Name</p>
						<p class="item-price">$ price</p>
					</li>
					<li class="items col-3 h-60">
						<a href=""> <img src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg"></a>
						<p class="item-name">Name</p>
						<p class="item-price">$ price</p>
					</li>
					<li class="items col-3 h-60">
						<a href=""> <img src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg"></a>
						<p class="item-name">Name</p>
						<p class="item-price">$ price</p>
					</li>
					<li class="items col-3 h-60">
						<a href=""> <img src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg"></a>
						<p class="item-name">Name</p>
						<p class="item-price">$ price</p>
					</li>
				</ul>
		</div>

		<div class="regular-items">
			<div class="title row">
				<h2>Regular Items</h2>
			</div>
			<ul class="items row">
				<li class="items col-3 h-60">
						<a href=""> <img src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg"></a>
						<p class="item-name">Name</p>
						<p class="item-price">$ price</p>
				</li>
				<li class="items col-3 h-60">
						<a href=""> <img src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg"></a>
						<p class="item-name">Name</p>
						<p class="item-price">$ price</p>
				</li>
				<li class="items col-3 h-60">
						<a href=""> <img src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg"></a>
						<p class="item-name">Name</p>
						<p class="item-price">$ price</p>
				</li>
				
			</ul>
		</div>

		<%@ include file="footer.jsp"%>

	</div>
	
	<script>
		//todo: create apis to retrive images and item info, use js to dynamiclly display them
	</script>

</body>
</html>