$(function () {
    publicKey();
})


/*
 * Collect card details and pay for the order
 */
function pay(stripe, card, clientSecret) {
    changeLoadingState(true);
    // Collects card details and creates a PaymentMethod
    stripe.createPaymentMethod("card", card).then(function (result) {
        if (result.error) {
            showError(result.error.message);
        } else {
            orderData.paymentMethodId = result.paymentMethod.id;
            return fetch("/without/pay", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(orderData)
            });
        }
    }).then(function (result) {
        return result.json();
    }).then(function (response) {
        if (response.error) {
            showError(response.error);
        } else if (response.requiresAction) {
            // Request authentication
            handleAction(response.clientSecret);
        } else {
            orderComplete(response.clientSecret);
        }
    });
};

function handleAction(clientSecret) {
    stripe.handleCardAction(clientSecret).then(function (data) {
        if (data.error) {
            showError("Your card was not authenticated, please try again");
        } else if (data.paymentIntent.status === "requires_confirmation") {
            fetch("/without/pay", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    paymentIntentId: data.paymentIntent.id
                })
            })
                .then(function (result) {
                    return result.json();
                })
                .then(function (json) {
                    if (json.error) {
                        showError(json.error);
                    } else {
                        orderComplete(clientSecret);
                    }
                });
        }
    });
};