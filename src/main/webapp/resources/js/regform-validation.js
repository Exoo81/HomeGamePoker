// Wait for the DOM to be ready
$(function() {
  // Registration form
  $("form[name='registrationForm']").validate({
    // Specify validation rules
    rules: {
      username:{
    	required: true,
  		minlength:3,
  		// check if username exist
  		remote:{
    		url: "usernameAvailable.html",
    		type: "get",
    		data: { 
    			username: function(){
    				return $("#username").val();
    			}
    		}
    	  },
      }, 
      email: {
        required: true,
        email: true,
        // check if email exist
        remote:{
    		url: "emailAvailable.html",
    		type: "get",
    		data: { 
    			username: function(){
    				return $("#email").val();
    			}
    		}
    	  },
      },
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
      username: {
    	  required: "This field is required",
    	  minlength: "Your password must be at least 3 characters long",
    	  remote: "Usename already exist."
      },
      email: {
    	  required:"Please enter email address",
    	  email: "Please enter a valid email address",
    	  remote: "Email already exist."
      },
      password: {
        required: "This field is required",
        minlength: "Your password must be at least 5 characters long"
      },
      repeatPassword:{
    	  required: "This field is required",
    	  equalTo: "Confirm your password"
      }
     
      
      
    },
    submitHandler: function(form) {
      form.submit();
    }
  });
});