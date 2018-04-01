(function() {
	var btn = document.querySelector('.btn-login');
	
	var emailInput = document.querySelector('.email-input');
	var passwordInput = document.querySelector('.password-input');

	var emailValue = emailInput.value;
	var passwordValue = passwordInput.value;
	
	function validateEmail(email) {
	  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  return re.test(email);
	}
	
	function checkButton () {
		if(passwordValue.length > 0 && validateEmail(emailValue)) {
			btn.disabled = false;
		} else {
			btn.disabled = true;
		}
	}

	emailInput.addEventListener('input', function(event) {
		emailValue = event.target.value;
		checkButton();
	});
	
	passwordInput.addEventListener('input', function(event) {
		passwordValue = event.target.value;
		checkButton();
	});
	
	checkButton();
}());