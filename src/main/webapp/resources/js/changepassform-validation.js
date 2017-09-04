// Wait for the DOM to be ready
$(function() {
  // Registration form
  $("form[name='newPasswordForm']").validate({
    // Specify validation rules
    rules: {   
      password: {
        required: true,
        minlength: 5
      },
      repeatPassword: {
    	required: true,
        equalTo: "#password"
      }
    },
    // Specify validation error messages
    messages: {
     
      password: {
        required: "This field is required.",
        minlength: "Your password must be at least 5 characters long"
      },
      repeatPassword:{
    	  required: "This field is required.",
    	  equalTo: "Confirm your password"
      }
      
    },
    submitHandler: function(form) {
      form.submit();
    }
  });
});