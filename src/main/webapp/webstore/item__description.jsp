<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>item</title>
    <link href="item_styles.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp" %>

    <div class="middle">
        <div class="bread_crumb">
            <div class="bread_center">
                <a href="">main page</a> <small>&gt</small> <a href="">category</a>
            </div>
        </div>

        <div class="item_display">
            <div id="item_pic">
                <img src="images/fruits/TB2rlMvcQomBKNjSZFqXXXtqVXa_!!2196633500.jpg_400x400q90.jpg">
            </div>
            <div class="item_select">
                <h3>Item Title</h3>
                <br>
                <div class="price">
                    <span id="old">Before: 1000</span> <em></em>
                    <span id="now">Now: 500</span>
                </div>
                <form>
                    Quantity:
                    <input type="text" value="1" name="quantity">
                    <br>
                    <div id="button">
                        <input type="button" value="Add to cart" onclick="">
                    </div>
                </form>
            </div>
        </div>

        <div class="item_description">
            <h3>Item description</h3>
            <ul class="pics">
                <li>
                    <img src="images/fruits/TB2BtYLqVXXXXcrXpXXXXXXXXXX_!!1702170473.jpg">
                </li>
                <li>
                    <img src="images/fruits/TB2GojSqVXXXXbqXpXXXXXXXXXX_!!1702170473.jpg">
                </li>
                <li>
                    <img src="images/fruits/TB2qjIqqVXXXXb2XXXXXXXXXXXX_!!1702170473.jpg">
                </li>
                <li>
                    <img src="images/fruits/TB2q7oAqVXXXXaeXXXXXXXXXXXX_!!1702170473.jpg">
                </li>
            </ul>

        </div>
        
		<%@ include file="footer.jsp" %>
    </div>



</body>
</html>