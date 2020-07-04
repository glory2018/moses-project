$(function () {
    getPublicKey();
})

function getPublicKey() {
    $.get("/keys/publicKey", function (response) {
        stripe = Stripe(response.data.publishableKey);
        post("/payments/createSetupIntent?id=cus_HJLKjValYWhoFA",null, stripeElements);
    });
};


function stripeElements(setupIntent) {

    var elements = stripe.elements();

    // Element styles
    var style = {
        base: {
            fontSize: "16px",
            color: "#32325d",
            fontFamily:
                "-apple-system, BlinkMacSystemFont, Segoe UI, Roboto, sans-serif",
            fontSmoothing: "antialiased",
            "::placeholder": {
                color: "rgba(0,0,0,0.4)"
            }
        }
    };

    var card = elements.create("card", {style: style});

    card.mount("#card-element");

    // Element focus ring
    card.on("focus", function () {
        var el = document.getElementById("card-element");
        el.classList.add("focused");
    });

    card.on("blur", function () {
        var el = document.getElementById("card-element");
        el.classList.remove("focused");
    });

    // Handle payment submission when user clicks the pay button.
    var button = document.getElementById("submit");
    button.addEventListener("click", function (event) {
        event.preventDefault();
        changeLoadingState(true);
        var email = document.getElementById("email").value;

        stripe.confirmCardSetup(setupIntent.data.clientSecret, {
            payment_method: {
                card: card,
                billing_details: {email: email}
            }
        }).then(function (result) {
            if (result.error) {
                changeLoadingState(false);
                var displayError = document.getElementById("card-errors");
                displayError.textContent = result.error.message;
            } else {
                // The PaymentMethod was successfully set up
                orderComplete(stripe, setupIntent.data.clientSecret);
            }
        });
    });
};

// Show a spinner on payment submission
function changeLoadingState(isLoading) {
    if (isLoading) {
        document.querySelector("button").disabled = true;
        document.querySelector("#spinner").classList.remove("hidden");
        document.querySelector("#button-text").classList.add("hidden");
    } else {
        document.querySelector("button").disabled = false;
        document.querySelector("#spinner").classList.add("hidden");
        document.querySelector("#button-text").classList.remove("hidden");
    }
};

/* Shows a success / error message when the payment is complete */
function orderComplete(stripe, clientSecret) {
    stripe.retrieveSetupIntent(clientSecret).then(function (result) {
        var setupIntent = result.setupIntent;
        var setupIntentJson = JSON.stringify(setupIntent, null, 2);

        document.querySelector(".sr-payment-form").classList.add("hidden");
        document.querySelector(".sr-result").classList.remove("hidden");
        document.querySelector("pre").textContent = setupIntentJson;
        setTimeout(function () {
            document.querySelector(".sr-result").classList.add("expand");
        }, 200);

        changeLoadingState(false);
    });
};


