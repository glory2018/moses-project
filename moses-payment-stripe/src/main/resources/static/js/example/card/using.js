$(function () {
    createPaymentIntent();
})

/*
 * Calls stripe.confirmCardPayment which creates a pop-up modal to
 * prompt the user to enter extra authentication details without leaving your page
 */
function pay(stripe, card, clientSecret) {
    changeLoadingState(true);
    // Initiate the payment.
    // If authentication is required, confirmCardPayment will automatically display a modal
    stripe.confirmCardPayment(clientSecret, {
        // setup_future_usage parameter helps optimize future payments made with the same card.
        // setup_future_usage: 'off_session',
        payment_method: {
            card: card
        }
    }).then(function (result) {
        if (result.error) {
            // Show error to your customer
            showError(result.error.message);
        } else {
            // The payment has been processed!
            orderComplete(clientSecret);
            // if (result.paymentIntent.status === 'succeeded') {
            //
            // }
        }
    });
};

