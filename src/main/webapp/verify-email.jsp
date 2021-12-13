<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Verify-Email</title>
    <link rel="stylesheet" href="css-login/verify-email.css">
</head>
<body>
    <div class="container">
        <h3>Verify Email To Register TQT Music</h3>
        <form action="ServletVerifyEmail" method="post">
        <fieldset>
            <label id="verify-email" for="password-input">Enter Code is sent to email: <span
                    id="email-verify"> </span> </label>
            <input type="text" name="code-input" id="password-input" inputmode="numeric" minlength="6"
                maxlength="6" size="6" value="">
            <span class="hint">New pin must be 6 digit number only</span>
        </fieldset>
        <button type="submit" >Verify</button>
    </form>
    </div>
</body>
</html>