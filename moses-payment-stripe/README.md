java -jar links-payment-stripe-1.0.0-SNAPSHOT.jar

Your pairing code is: quaint-goood-assure-marvel
This pairing code verifies your authentication with Stripe.
Press Enter to open the browser (^C to quit)
> Done! The Stripe CLI is configured for your account with account id acct_1GY1U3Chx93PucYp

Please note: this key will expire after 90 days, at which point you'll need to re-authenticate.
stripe listen --forward-to http://localhost:5551/payments/webhook
PS C:\Windows\system32> stripe listen --forward-to http://localhost:5551/payments/webhook
A newer version of the Stripe CLI is available, please update to: v1.3.11
> Ready! Your webhook signing secret is whsec_uKr7IpVxChSMW2HCZYXKTu1eFVrOVgin (^C to quit)
>
ngrok http 5551

https://44883d8e.ngrok.io 

t=1588133081,v1=c3a9cbef3330f356649e7c772c9f5b5180f37344545efbc95a591aa9f7bdc06d,v0=51c1c85d63c6dec89916443bef9e89e72a30cc1e76d07d15a1f30332d89fc0a1

http://localhost:5551/swagger-ui.html
