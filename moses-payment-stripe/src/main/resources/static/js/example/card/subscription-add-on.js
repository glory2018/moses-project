var stripe;
var checkoutSessionId;

var setupElements = function () {
    fetch("/keys/publicKey", {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(function (result) {
            return result.json();
        })
        .then(function (data) {
            stripe = Stripe(data.publicKey);
        });
};

var createCheckoutSession = function (isBuyingSticker) {
    fetch("/subscription-add-on/create-checkout-session", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({isBuyingSticker})
    })
        .then(function (result) {
            return result.json();
        })
        .then(function (data) {
            checkoutSessionId = data.checkoutSessionId;
        });
};
setupElements();
createCheckoutSession(false);

function change(checked) {
    if (checked) {
        createCheckoutSession(true);
        document.querySelector(".order-total").textContent = "$17.00"; // Because they are buying the extra item
    } else {
        createCheckoutSession(false);
        document.querySelector(".order-total").textContent = "$14.00"; // Not buying the extra item
    }
}

function checkout(evt) {
    evt.preventDefault();
    // Initiate payment
    stripe.redirectToCheckout({sessionId: checkoutSessionId})
        .then(function (result) {
            console.log("error");
            // If `redirectToCheckout` fails due to a browser or network
            // error, display the localized error message to your customer
            // using `result.error.message`.
        })
        .catch(function (err) {
            console.log(err);
        });
}
