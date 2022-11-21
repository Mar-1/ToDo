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

function logout(){
firebase.auth().signOut().then(() => {
      window.location.href = "index.html";
		alert('Deslogado');
  }).catch(() => {
      alert('Erro ao fazer logout');
 })
}

