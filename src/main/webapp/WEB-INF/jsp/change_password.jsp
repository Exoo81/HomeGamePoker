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
							
							<!-- New password Frame -->
								<div class="forgot-box visible widget-box poker-red no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h3 class="header poker-red lighter bigger">
												<i class="poker-red-icon fa fa-ban" aria-hidden="true"></i>
												Hi ${user.username}. Change your password
											</h3>

											<div class="space-6"></div>
											
											<!-- Change password Form -->
											<form action='<spring:url value="/change_password/${user.id}/${token}.html" />' method="POST" name="newPasswordForm">
											
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input class="form-control txtFieldBigger" type="password" name="password" id="password" placeholder="Enter new password" required autofocus />
															<i class="poker-red-icon fa fa-lock"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input class="form-control txtFieldBigger" type="password" name="repeatPassword" placeholder="Repeat password" required/>
															<i class="poker-red-icon fa fa-retweet"></i>
														</span>
													</label>
													
													<div class="space"></div>

													<div class="clearfix text-center">
														<button type="submit" class="width-65 btn btn-xlg btn-primary btn-poker-red">
															<i class="poker-red-icon fa fa-floppy-o fa-lg"></i>
															<span class="bigger-110"> Save</span>
														</button>
													</div>

												</fieldset>
											</form>

											<div class="space-6"></div>

										</div><!-- /.widget-main -->

										<div class="toolbar center">
											<a href="<spring:url value="/login.html" />" data-target="#login-box" class="back-to-login-link">
												Back to login
												<i class="poker-green-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->
								
								
								
								
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->


<!--[if IE]>
<script src="resources/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		
		<script type="text/javascript" src="<c:url value="/resources/js/changepassform-validation.js"/>"></script>
		
		
		<!-- inline scripts related to this page -->
		<script type="text/javascript">	
			// alert Fade Out 
			$(".alert").delay(5000).slideUp(200, function() {
			    $(this).alert('close');
			});	
		</script>
		
	
		
		
	</body>
</html>