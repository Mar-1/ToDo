<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="estilo.css">
	<title>To-Do</title>
</head>

<body>

	<div id="area-cabecalho">
		<h1>To Do</h1>
		<h3>Organize suas atividades de uma forma muito mais simples!</h3>
	</div>
		
	<div id="login-container">
			<h2>Login</h2>
			<form>
				<label for="email">E-mail</label>
				<input type="email" name="email" id="email" placeholder="Digite seu email" autocomplete="off">
				<label for="password">Senha</label>
				<input type="password" name="password" id="password" placeholder="Digite a sua senha">
				<a href="#" id="forgot-pass">Esqueceu a senha?</a>
				
				<a href="inicio.html" style="text-decoration: none;">
					<input type="button" value="login">
				</a>
				
				
				
			</form>

			<div id="register-container">
				<p>Ainda nao tem uma conta?</p>
				<a href="criar-conta.html">Registrar</a>
			</div>

	
	</div>

</body>
</html>