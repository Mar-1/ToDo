// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyCiwUbk4tGby87XPnJPN8CpZwXP8kEe1us",
  authDomain: "loginprogweb-8fb0c.firebaseapp.com",
  projectId: "loginprogweb-8fb0c",
  storageBucket: "loginprogweb-8fb0c.appspot.com",
  messagingSenderId: "520334860471",
  appId: "1:520334860471:web:3ea4949974aa653d1b6d32"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);
// Initialize variables
const auth = firebase.auth()
const database = firebase.database()

// Set up our register function
function register () {
  // Get all our input fields
  email = document.getElementById('email').value
  password = document.getElementById('password').value
  full_name = document.getElementById('full_name').value
  apelido_user = document.getElementById('apelido_user').value
  

  // Validate input fields
  if (validate_email(email) == false || validate_password(password) == false) {
    alert('E-mail ou senha inválido!!')
    return
    // Don't continue running the code
  }
  if (validate_field(full_name) == false || validate_field(apelido_user) == false) {
    alert('Uma ou mais campos não preenchido!')
    return
  }
 
  // Move on with Auth
  auth.createUserWithEmailAndPassword(email, password)
  .then(function() {
    // Declare user variable
    var user = auth.currentUser

    // Add this user to Firebase Database
    var database_ref = database.ref()

    // Create User data
    var user_data = {
      email : email,
      full_name : full_name,
      apelido_user : apelido_user,
      last_login : Date.now()
    }

    // Push to Firebase Database
    database_ref.child('users/' + user.uid).set(user_data)

    // DOne
    
    window.location.href = "creater_task.html";
  })
  .catch(function(error) {
    // Firebase will use this to alert of its errors
    var error_code = error.code
    var error_message = error.message

    alert(error_message)
  })
}

// Set up our login function
function login () {
  
  // Get all our input fields
  email = document.getElementById('email').value
  password = document.getElementById('password').value

  // Validate input fields
  if (validate_email(email) == false || validate_password(password) == false) {
    alert('E-mail ou senha não preenchido!!')
    return
    // Don't continue running the code
  }

  auth.signInWithEmailAndPassword(email, password)
  .then(function() {
    // Declare user variable
    var user = auth.currentUser

    // Add this user to Firebase Database
    var database_ref = database.ref()

    // Create User data
    var user_data = {
      last_login : Date.now()
    }

    // Push to Firebase Database
    database_ref.child('users/' + user.uid).update(user_data)
  
  
	
  })
  .catch(function(error) {
    // Firebase will use this to alert of its errors
    var error_code = error.code
    var error_message = error.message

    alert(error_message)
  })
}

//resetar senha
function sendPasswordReset() {
  
  // const email = "marcelosoaresantunes@hotmail.com";
  // [START auth_send_password_reset]
  firebase.auth().sendPasswordResetEmail(email)
    .then(() => {
      // Password reset email sent!
      // ..
      alert('Troca de senha enviado para o E-mail')
    })
    .catch((error) => {
      var errorCode = error.code;
      var errorMessage = error.message;
      // ..
      alert('Preencha o E-mail para resetar')
    });
  // [END auth_send_password_reset]
}

// Validate Functions
function validate_email(email) {
  expression = /^[^@]+@\w+(\.\w+)+\w$/
  if (expression.test(email) == true) {
    // Email is good
    return true
  } else {
    // Email is not good
    return false
  }
}

function validate_password(password) {
  // Firebase only accepts lengths greater than 6
  if (password < 6) {
    return false
  } else {
    return true
  }
}

function validate_field(field) {
  if (field == null) {
    return false
  }

  if (field.length <= 0) {
    return false
  } else {
    return true
  }
}

firebase.auth().onAuthStateChanged(user => {
  if (user) {
      window.location.href = "creater_task.html";
  alert('Você já esta Logado!!')
  }
})








