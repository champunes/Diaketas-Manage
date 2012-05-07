<?php
/**
 *
 * Controlador para la gestión de todas las tareas referentes
 * a la gestión del historial de pagos y colaboracioens de los socios
 * @author Jose A. Escobar
 *
 */
header('Content-Type: application/json');
require_once 'DB/SocioBD.php';
require_once 'DB/HistorialBD.php';
$socioBD = SocioBD::getInstancia();
if(isset($_COOKIE['hash']) && $socioOID=$socioBD->existeHash($_COOKIE['hash'])){
	$tarea=htmlspecialchars(trim($_POST['tarea']));
	
	if($tarea=="consultar"){
		$historialBD=HistorialBD::getInstancia();
		$fechaIni=htmlspecialchars(trim($_POST['fechaIni']));
		$fechaFin=htmlspecialchars(trim($_POST['fechaFin']));
		if($datos=$historialBD->obtenerDatos($socioOID,$fechaIni,$fechaFin)){
			$res->estado="OK";
			$res->datos=$datos;
			exit(json_encode($res));
		} else {
			exit('{"estado":"error","msg":"No existen movimientos asociados a este periodo"}');
		}
	} 
} else {
	exit('{"estado":"error","msg":"No estas identificado en el sistema"}');
}