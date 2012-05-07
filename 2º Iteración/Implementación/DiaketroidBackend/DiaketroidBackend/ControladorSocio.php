<?php
/**
 *
 * Controlador para la gestión de todas las tareas referentes
 * a la gestión de los datos personales de los socios
 * @author Jose A. Escobar
 *
 */
header('Content-Type: application/json');
require_once 'DB/SocioBD.php';
$socioBD = SocioBD::getInstancia();
if(isset($_COOKIE['hash']) && $socioOID=$socioBD->existeHash($_COOKIE['hash'])){
	$tarea=htmlspecialchars(trim($_POST['tarea']));
	if($tarea=="consultar"){
		if($datos=$socioBD->obtenerDatos($socioOID)){
			$datos->estado="OK";
			exit(json_encode($datos));
		} else {
			exit('{"estado":"error","msg":"Ha ocurrido un error al obtener los datos del socio"}');
		}
		
	} else if($tarea=="modificar"){
		
		$datos=stripslashes($_POST['datos']);
		$socio = json_decode(utf8_encode($datos));
		if($socio!=NULL)
			if($socioBD->modificarDatos($socioOID,$socio))
				exit('{"estado":"OK"}');
			else
				exit('{"estado":"error","msg":"Problema al actualizar los datos en la BD"}');
		else
			exit('{"estado":"error","msg":"Error de decodificación de datos"}');
	}
	
} else {
	exit('{"estado":"error","msg":"No estas identificado en el sistema"}');
}