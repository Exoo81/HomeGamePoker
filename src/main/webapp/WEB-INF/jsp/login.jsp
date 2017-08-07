<!DOCTYPE html>
<%@ include file="../tiles/taglib.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

	</head>

	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1 class="great">
									<span class="poker-red">Home</span>
									<span class="white" id="id-text2">Game Poker</span>
								</h1>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
							
								<!-- Login Frame -->
								<div id="login-box" class="login-box visible widget-box poker-green no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h3 class="header poker-green lighter bigger">
												<i class="poker-green-icon fa fa-hand-o-right poker-green" aria-hidden="true"></i>
												Sign In
											</h3>

											<div class="space-6"></div>
											
											<!-- Login Form -->
											<form action="<spring:url value="/login" />" method="POST" name="loginForm">
											
											<c:if test="${'fail' eq param.auth}">
       											 <div class="alert alert-danger poker-red">
               											 	Login Failed !
         										</div>
    										</c:if>
    										
											<c:if test="${param.registration eq true}">
												<div class="alert alert-success poker-green">Registration successful !<br> Please check your <b>email</b> to activate account. </div>
											</c:if>
												<fieldset>
													<label class="block clearfix" for="inputUsername">
														<span class="block input-icon input-icon-right">
															<input class="form-control txtFieldBigger" type="text" name="username" id="inputUsername" placeholder="Username" required autofocus />
															<i class="poker-green-icon fa fa-user fa-lg"></i>
														</span>
													</label>

													<label class="block clearfix" for="inputPassword">
														<span class="block input-icon input-icon-right">
															<input class="form-control txtFieldBigger" type="password" name="password" id="inputPassword" placeholder="Password" required/>
															<i class="poker-green-icon fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix text-center">
														<button type="submit" class="width-65 btn btn-xlg btn-primary btn-poker-green">
															<i class="poker-green-icon fa fa-lock fa-lg"></i>
															<span class="bigger-110">Login</span>
														</button>
													</div>

												</fieldset>
											</form>

											<div class="space-6"></div>

										</div><!-- /.widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="#" data-target="#forgot-box" class="forgot-password-link">
													Forgot password
													<i class="fa fa-question"></i>
												</a>
											</div>

											<div>
												<a href="#" data-target="#signup-box" class="user-signup-link">
													Create account
													<i class="fa fa-sign-in"></i>
												</a>
											</div>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->


								<!-- Forgot Frame -->
								<div id="forgot-box" class="forgot-box widget-box poker-red no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h3 class="header poker-red lighter bigger">
												<i class="poker-red-icon fa fa-key poker-red"></i>
												Retrieve Password
											</h3>
											<!-- Forgot Form -->
											<form:form commandName="userRegistrationForm" method="POST" name="forgotForm"> <!-- odsyla do registration form naraZIE -->
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="email" type="email" class="form-control txtFieldBigger" name="email" placeholder="Enter your email" />
															<i class="poker-red-icon fa fa-envelope"></i>
														</span>
													</label>
													
													<div class="space"></div>

													<div class="clearfix text-center">
														<button type="submit" class="width-65 btn btn-xlg btn-primary btn-poker-red">
															<i class="poker-red-icon fa fa-paper-plane fa-lg"></i>
															<span class="bigger-110">Send Me !</span>
														</button>
													</div>
												</fieldset>
											</form:form>
										</div><!-- /.widget-main -->

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												Back to login
												<i class="poker-green-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.forgot-box -->

								<!-- Registration Frame -->
								
								<div id="signup-box" class="signup-box widget-box poker-blue no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h3 class="header poker-blue lighter bigger">
												<i class="poker-blue-icon fa fa-users poker-blue"></i>
												New User Registration
											</h3>
											
											<form:form commandName="userRegistrationForm" method="POST" name="registrationForm">
												<fieldset>
													
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="username" type="text" class="form-control txtFieldBigger" id="username" name="username" placeholder="Player name, nick ..." />
															<i class="poker-blue-icon fa fa-user"></i>
														</span>
													</label>
													
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="email" type="email" class="form-control txtFieldBigger" name="email" placeholder="Email" />
															<i class="poker-blue-icon fa fa-envelope"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="password" type="password" class="form-control txtFieldBigger" name="password" placeholder="Password" />
															<i class="poker-blue-icon fa fa-lock"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="repeatPassword" type="password" class="form-control txtFieldBigger" name="repeatPassword" placeholder="Confirm password" />
															<i class="poker-blue-icon fa fa-retweet"></i>
														</span>
													</label>

													<div class="space"></div>
													
													<div class="clearfix text-center">
														<button type="submit" value="ghfg" class="width-65 btn btn-xlg btn-primary btn-poker-blue">
															<i class="poker-blue-icon fa fa-sign-in fa-lg"></i>
															<span class="bigger-110">Sign in</span>
														</button>
													</div>
												</fieldset>
											</form:form>
										</div>

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												<i class="poker-green-icon fa fa-arrow-left"></i>
												Back to login
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.signup-box -->
							</div><!-- /.position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->


		<!--[if IE]>
<script src="resources/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script src="resources/js/regform-validation.js"></script>
		<script src="resources/js/loginform-validation.js"></script>
		<script src="resources/js/forgotform-validation.js"></script>
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			});
			
			// alert Fade Out 
			$(".alert").delay(5000).slideUp(200, function() {
			    $(this).alert('close');
			});
			
		</script>
		
		
	</body>
</html>
