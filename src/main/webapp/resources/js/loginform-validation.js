// Wait for the DOM to be ready
$(function() {
  // Registration form
  $("form[name='loginForm']").validate({
    // Specify validation rules
    rules: {
      username:{
    	required: true,
  		minlength:3,
      }, 
      password: {
        required: true,
        minlength: 5
      },
    },
    // Specify validation error messages
    messages: {
      username: {
    	  required: "This field is required",
    	  minlength: "Your password must be at least 3 characters long",
      },
      password: {
        required: "This field is required",
        minlength: "Your password must be at least 5 characters long"
      },
    },
    submitHandler: function(form) {
      form.submit();
    }
  });
});