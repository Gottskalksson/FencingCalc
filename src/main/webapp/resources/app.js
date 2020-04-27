$(function () {
    var itemPrices = $(".itemPrice");
    var prices = $(".price");
    var pound = "£ ";

    var totalPrice = 0;

    for (var i = 0; i < itemPrices.length; i++) {
        totalPrice = totalPrice -  (-itemPrices[i].innerText);
        itemPrices[i].innerText = (pound + itemPrices[i].innerText);
    }

    prices[0].innerText = pound + totalPrice.toFixed(2);
    prices[1].innerText = pound + (totalPrice * 0.2).toFixed(2);
    prices[2].innerText = pound + (totalPrice * 1.2).toFixed(2);

});