<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Form-v6 by Colorlib</title>
	<!-- Latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">

	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- Font-->
	<link rel="stylesheet" type="text/css" href="css/nunito-font.css">
	<!-- Main Style Css -->
	<link rel="stylesheet" href="css-login/register-style.css" />
	<style>
		#box-messenger{
			height: 80px;
			width: 250px;
			margin-right: -300px;
			margin-left: 100px;
			margin-top: -300px;
		}
		.hide{
			display: none;
		}
		.logo-form{
			height: 640px !important;
		}
	</style>
</head>

<body class="form-v6">



<div id="form-regis" class="page-content">
	<div class="form-v6-content">
		<div class="form-left">
			<div class="logo-form">

				<img src="css-login/images/logo.png" alt="logo-form">
			</div>
		</div>
		<form class="form-detail" action="/ServletRegister" method="post">
			<h2>TQT Music Register</h2>
			<div class="form-row">
				<input type="text" name="fullname" id="fullname" class="input-text" placeholder="Full Name"
					   required>
			</div>
			<div class="form-row">
				<input type="text" name="username" id="username" class="input-text" placeholder="Username" required>
			</div>
			<div class="form-row">
				<input type="text" name="email" id="email" class="input-text" placeholder="Email Address" required
					   pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}">
			</div>
			<div class="form-row">
				<input type="password" name="password" id="password" class="input-text" placeholder="Password"
					   required onchange="checkmatch()">
			</div>
			<div class="form-row">
				<input type="password" name="re-password" id="re-password" class="input-text"
					   placeholder="Re-Password" required onchange="checkmatch()">
			</div>
			<div class="form-row-last">
				<button id="submit-btn" type="submit" name="register" class="register" value="Register"
						data-bs-toggle="modal" data-bs-target="#verifyModal" onclick="clickregister()"> Register </button>
			</div>
			<div class="form-row-label">
				<label>Have already an account? <a href="index.jsp"> Login here</a></label>
			</div>
		</form>
	</div>
	<div id="box-messenger">
		<h4 id="message" style="color: rgb(141, 5, 141); background-color: wheat; width: 322px; text-align: center; font-style: oblique; font-size: 14px; border-radius: 4px;" >${message}</h4>
	</div>
	<div id="right-box">
		<div id="loginalert" class="alert alert-danger ">
			<strong>Attention!</strong> <span id="alert-content" > The "password" and "re-password" fields not match! </span>
		</div>
	</div>
</div>
<script src="js-login/register.js"></script>
<script>
	setTimeout(hideelment,4000)
	function hideelment(){
		document.getElementById("message").classList.add("hide");
	}
</script>
</body>

</html>