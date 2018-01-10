<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="date_heure.js"></script>
<title>Projet Web Services REST</title>
</head>
<body>
	<header>
		<h1>Projet Web Services Cinéma (REST)</h1>
		
		<div class="menu">
			<ul>
				<li><a href="index.html">Accueil</a></li>
				<li><a href="movie.html" target="_blank_">Films</a></li>
				<li><a href="city.html" target="_blank_">Villes</a></li>
				<li><a href="login.html" target="_blank_">Connexion</a></li>
	   			<li class="welcome">Welcome guest</li>
	   		</ul>
		</div>
	</header>
	
	<div class="login">
		<table class="loginbox">
			<form action="../WebServicesProjectCinema/rest/users" method="POST">
				<tr>
					<td id="name"><label for="id">ID: </label><sup id="required">*</sup></td>
					<td id="input"><input type="text" name="id"/><br></td>
				</tr>
				
				<tr>
					<td id="name"><label for="email">E-mail: </label><sup id="required">*</sup></td>
					<td id="input"><input type="text" name="email"/><br></td>
				</tr>

				<tr>
					<td id="name"><label for="password">Mot de passe <sup id="required">*</sup></label></td>
					<td id="input"><input type="password" name="password" placeholder="6 characters minimum" required/></td>
				</tr>

				<tr>
					<td id="name">Identité (Prénom, Nom): <sup id="required">*</sup></td>
					<td id="input"><input type="text" name="identite"/></td>
				</tr>
				
				<tr>
					<td><br><input type="submit" value="Connexion" title="Click on this button to check your identifiers and log into your account"/></td>
					<td><br><input type="reset" value="Reset" title="Click on this button to clear the form"/></td>
				</tr>
			</form>
		</table>	
	</div>
	
	<footer>
		<span id="date_heure"></span>
	    <script type="text/javascript">window.onload = date_heure('date_heure');</script>&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp;
	    Copyright Koussaïla BEN MAMAR, Ibrahim EL KARRAT et Arthur SCHICKEL, Janvier 2018, tous droits réservés
	</footer>
</body>
</html>