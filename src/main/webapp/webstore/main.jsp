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
					<div class="carousel-item">
						<img class="d-block w-100"
							src=".../800x400?auto=yes&bg=555&fg=333&text=Third slide"
							alt="Third slide">
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


		<div class="on_sale">
			<div class="top">
				<span id="h1">Goodies On Sale</span> <span id="h2">All items
					50% - 70% OFF</span><br>
			</div>
			<div class="body">
				<ul class="sale_items">
					<li><a href=""> <img
							src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg">
							<p>item description</p>
							<p>$ price</p>
					</a></li>
					<li><a href=""> <img
							src="/webstorepractise/images/TB2bYIncwvD8KJjy0FlXXagBFXa_!!0-saturn_solar.jpg_200x200.jpg_.webp">
							<p>item description</p>
							<p>$ price</p>
					</a></li>
					<li><a href=""> <img
							src="/webstorepractise/images/fruits/TB2l3bjrH1YBuNjSszhXXcUsFXa_!!228955765.jpg_400x400q90.jpg">
							<p>item description</p>
							<p>$ price</p>
					</a></li>
					<li><a href=""> <img
							src="/webstorepractise/images/fruits/TB2rlMvcQomBKNjSZFqXXXtqVXa_!!2196633500.jpg_400x400q90.jpg">
							<p>item description</p>
							<p>$ price</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="hot_items">
			<div class="title">
				<span>Hot Items</span>
			</div>
			<ul class="items">
				<li><a href=""> <img
						src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg">
						<p>item description</p>
						<p>$ price</p>
				</a></li>
				<li><a href=""> <img
						src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg">
						<p>item description</p>
						<p>$ price</p>
				</a></li>
				<li><a href=""> <img
						src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg">
						<p>item description</p>
						<p>$ price</p>
				</a></li>
				<li><a href=""> <img
						src="/webstorepractise/images/TB2gHW.hnqWBKNjSZFxXXcpLpXa_!!0-saturn_solar.jpg_220x220.jpg">
						<p>item description</p>
						<p>$ price</p>
				</a></li>
			</ul>
		</div>

		<%@ include file="footer.jsp"%>

	</div>

</body>
</html>