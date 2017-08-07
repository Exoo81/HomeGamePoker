// Wait for the DOM to be ready
$(function() {
  // Registration form
  $("form[name='forgotForm']").validate({
    // Specify validation rules
    rules: {
    	email: {
            required: true,
            email: true,
            // check if email exist
            remote:{
        		url: "emailAvailableForgot.html",
        		type: "get",
        		data: { 
        			username: function(){
        				return $("#email").val();
        			}
        		}
        	  },
          },
    },
    // Specify validation error messages
    messages: {
    	email: {
      	  required:"Please enter email address",
      	  email: "Please enter a valid email address",
      	  remote: "This email does not exist"
        },
    },
    submitHandler: function(form) {
      form.submit();
    }
  });
});