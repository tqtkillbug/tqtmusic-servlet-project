<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="css-login/style-login.css">
<!------ Include the above in your HEAD tag ---------->
<!DOCTYPE html>
<html>

<head>
  <title>Login TQT Music</title>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
  <style>
    .hide{
      display: none;
    }
  </style>
</head>
<!--Coded with love by Mutiullah Samim-->
<body>
<div class="container h-80">
  <h4  id="message" style="margin-left:405px; margin-top: 20px; color: rgb(141, 5, 141); background-color: wheat; width: 300px; text-align: center; font-style: oblique; font-size: 14px; border-radius: 4px; " >${message}</h4>
  <div class="d-flex justify-content-center h-100">
    <div class="user_card">
      <div class="d-flex justify-content-center">
        <div class="brand_logo_container">
          <img src="https://i.imgur.com/cjxfwiS.png" class="brand_logo" alt="Logo">
        </div>
      </div>
      <div class="d-flex justify-content-center form_container">
        <form action="login"  method="post">
          <div class="input-group mb-3">
            <div class="input-group-append">
              <span class="input-group-text"><i class="fas fa-user"></i></span>
            </div>
            <input id="username" type="text" name="username" class="form-control input_user" value="" placeholder="username" required >
          </div>
          <div class="input-group mb-2">
            <div class="input-group-append">
              <span class="input-group-text"><i class="fas fa-key"></i></span>
            </div>
            <input id="password" type="password" name="password" class="form-control input_pass" value="" placeholder="password" required>
          </div>
          <div class="form-group">
            <div class="custom-control custom-checkbox">
              <input type="checkbox" class="custom-control-input" id="customControlInline">
              <label class="custom-control-label" for="customControlInline">Remember me</label>
            </div>
          </div>
          <div class="d-flex justify-content-center mt-3 login_container">
            <button type="submit" name="button" onclick="validateLogin()" class="btn login_btn">Login</button>
          </div>
        </form>
      </div>
      
      <div class="mt-4">
        <div class="d-flex justify-content-center links">
          Don't have an account? <a href="register.jsp" class="ml-2">Sign Up</a>
        </div>
        <div class="d-flex justify-content-center links">
          <a href="#">Forgot your password?</a>
        </div>
      </div>
    </div>
  </div>
  <div id="right-box">
    <div id="loginalert" class="alert alert-danger ">
      <strong>Attention!</strong> The "username" and "password" fields cannot be left empty!
    </div>
  </div>
  <script src="js-login/login.js"></script>
  <script>
    setTimeout(hideelment,4000)
    function hideelment(){
      document.getElementById("message").classList.add("hide");
    }
  </script>
</div>
</body>
</html>
