<?php
/**
 *
 * Controlador para la gestión de todas las tareas referentes
 * a la gestión de la identificación de los usuarios en el servidor
 * @author Jose A. Escobar
 *
 */
header('Content-Type: application/json');
require_once 'DB/SocioBD.php';
$socioBD = SocioBD::getInstancia();
if(isset($_COOKIE['hash']) && $socioBD->existeHash($_COOKIE['hash'])){
	exit('{"error":"Ya estas logeado"}');
} else {
	
	
	$usuario=htmlspecialchars(trim($_POST['username']));
	$password=htmlspecialchars(trim($_POST['password']));
	
	$socio=$socioBD->identificarse($usuario,$password);
	
	if($socio){
		$hash = md5(uniqid(microtime().rand()));
		if($socioBD->insertarHash($socio->OID,$hash)){
			setcookie("hash",$hash,time()+(86400*30));
			exit('{"estado":"OK"}');
		} else {
			exit('{"estado":"error","msg":"Ha ocurrido un problema durante la identificacion"}');
		}
			
	} else {
		exit('{"estado":"error","msg":"Nombre de usuario o contraseña incorrectos"}');
	}
}