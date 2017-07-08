<!DOCTYPE html>
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
								<h1>
									<span class="red">Home</span>
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
												<i class="ace-icon fa fa-hand-o-right poker-green" aria-hidden="true"></i>
												Sign In
											</h3>

											<div class="space-6"></div>
											
											<!-- Login Form -->
											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Username" />
															<i class="ace-icon-poker-green fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Password" />
															<i class="ace-icon-poker-green fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix text-center">
														<button type="button" class="width-65 btn btn-lg btn-primary btn-poker-green">
															<i class="ace-icon fa fa-lock fa-lg"></i>
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
													<i class="ace-icon fa fa-question"></i>
												</a>
											</div>

											<div>
												<a href="#" data-target="#signup-box" class="user-signup-link">
													Create account
													<i class="ace-icon fa fa-sign-in"></i>
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
												<i class="ace-icon fa fa-key poker-red"></i>
												Retrieve Password
											</h3>
											<!-- Forgot Form -->
											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Enter your email to receive instructions" />
															<i class="ace-icon-poker-red fa fa-envelope"></i>
														</span>
													</label>
													
													<div class="space"></div>

													<div class="clearfix text-center">
														<button type="button" class="width-65 btn btn-lg btn-primary btn-poker-red">
															<i class="ace-icon fa fa-paper-plane fa-lg"></i>
															<span class="bigger-110">Send Me !</span>
														</button>
													</div>
												</fieldset>
											</form>
										</div><!-- /.widget-main -->

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												Back to login
												<i class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.forgot-box -->

								<!-- Registration Frame -->
								<div id="signup-box" class="signup-box widget-box poker-blue no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h3 class="header poker-blue lighter bigger">
												<i class="ace-icon fa fa-users poker-blue"></i>
												New User Registration
											</h3>

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Email" />
															<i class="ace-icon-poker-blue fa fa-envelope"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="Username" />
															<i class="ace-icon-poker-blue fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Password" />
															<i class="ace-icon-poker-blue fa fa-lock"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="Repeat password" />
															<i class="ace-icon-poker-blue fa fa-retweet"></i>
														</span>
													</label>


													<div class="clearfix text-center">
														<button type="button" class="width-65 btn btn-lg btn-primary btn-poker-blue">
															<i class="ace-icon fa fa-sign-in fa-lg"></i>
															<span class="bigger-110">Sign in</span>
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												<i class="ace-icon fa fa-arrow-left"></i>
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
			
			
		</script>
	</body>
</html>
