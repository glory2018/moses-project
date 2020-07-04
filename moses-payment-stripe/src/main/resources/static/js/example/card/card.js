var stripe;
var orderData = {
    items: [{id: "photo-subscription"}],
    amount: 1001,
    currency: "usd",
    description: "this is a test",
    receiptEmail: "bjfansr@ibm.com.cn"
};

function createPaymentIntent() {
    post("/payments/createPaymentIntent", orderData, callback_setup);
}

function publicKey() {
    $.get("/keys/publicKey", function (data) {
        callback_setup(data);
    });
}

function callback_setup(result) {
    stripe = Stripe(result.data.publishableKey);
    var card = setupElements(stripe);
    // Handle form submission.
    var form = document.getElementById("payment-form");
    form.addEventListener("submit", function (event) {
        event.preventDefault();
        // Initiate payment when the submit button is clicked
        pay(stripe, card, result.data.clientSecret);
    });
    $("#submit-btn").show();
}

// 结帐页面创建Elements实例
function setupElements(stripe) {
    var elements = stripe.elements();
    var style = {
        base: {
            color: "#32325d",
            fontFamily: '"Helvetica Neue", Helvetica, sans-serif',
            fontSmoothing: "antialiased",
            fontSize: "16px",
            "::placeholder": {
                color: "#aab7c4"
            }
        },
        invalid: {
            color: "#fa755a",
            iconColor: "#fa755a"
        }
    };

    var card = elements.create("card", {style: style});
    card.mount("#card-element");
    return card;
}


/* ------- Post-payment helpers ------- */

/* Shows a success / error message when the payment is complete */
function orderComplete(clientSecret) {
    // Just for the purpose of the sample, show the PaymentIntent response object
    stripe.retrievePaymentIntent(clientSecret).then(function (result) {
        var paymentIntent = result.paymentIntent;
        var paymentIntentJson = JSON.stringify(paymentIntent, null, 2);

        document.querySelector(".sr-payment-form").classList.add("hidden");
        document.querySelector("pre").textContent = paymentIntentJson;

        document.querySelector(".sr-result").classList.remove("hidden");
        setTimeout(function () {
            document.querySelector(".sr-result").classList.add("expand");
        }, 200);

        changeLoadingState(false);
    });
};

function showError(errorMsgText) {
    changeLoadingState(false);
    // var errorMsg = document.querySelector(".sr-field-error");
    errorMsg.textContent = errorMsgText;
    setTimeout(function () {
        errorMsg.textContent = "";
    }, 4000);
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
