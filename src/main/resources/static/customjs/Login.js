   function openLogin(){
      window.location.href='login'
    }
    function showSignupForm() {
        document.getElementById("loginForm").style.display = "none";
        document.getElementById("signupForm").style.display = "block";
    }

    function showLoginForm() {
        document.getElementById("signupForm").style.display = "none";
        document.getElementById("loginForm").style.display = "block";
    }


function SignUp() {
    var username = $('#signupUsername').val();
    var password = $('#signupPassword').val();
    var role = $('#userRole').val();

    var SignupData = {
        username: username,
        password: password,
        role: role
    };

    var jsonData = JSON.stringify(SignupData);

    $.ajax({
        type: "POST",
        url: "/SignUp",
        contentType: "application/json",
        data: jsonData,
        success: function(response) {
            alert(response);
            window.location.href = '/login';
        },
        error: function(xhr, status, error) {
            console.error(xhr.responseText);
            window.location.href = '/login';
        }
    });
    event.preventDefault();
}

function Login() {
    var loginUsername = $('#loginUsername').val();
    var loginPassword = $('#loginPassword').val();
    var loginuserRole = $('#loginuserRole').val();

    var loginData = {
        loginUsername: loginUsername,
        loginPassword: loginPassword,
        loginuserRole: loginuserRole
    };

    $.ajax({
        type: "POST",
        url: "/login",
        contentType: "application/json",
        data: JSON.stringify(loginData),
        success: function(role) {
          if(loginuserRole == role){
            if (role === "1") {
                window.location.href = 'AddVehicle';
            } else if (role === "2") {
                window.location.href = 'ServiceTicket';
            } else if (role === "3") {
                window.location.href = 'DriverServiceTickets';
            } else if (role === "4") {
                window.location.href = 'ManagerInterface';
            }
            }else{
            alert("User Role not Found")
            }
        },
        error: function(xhr, status, error) {
            console.error(xhr.responseText);
            alert("Error: " + xhr.responseText);
        }
    });

    event.preventDefault();
}
