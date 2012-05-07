<?php
/**
 *
 * Controlador para la gestión de todas las tareas referentes
 * a la gestión de las cuotas de los socios
 * @author Jose A. Escobar
 *
 */
header('Content-Type: application/json');
require_once 'DB/SocioBD.php';
require_once 'DB/CuotaBD.php';
$socioBD = SocioBD::getInstancia();
if(isset($_COOKIE['hash']) && $socioOID=$socioBD->existeHash($_COOKIE['hash'])){
	$tarea=htmlspecialchars(trim($_POST['tarea']));
	$cuotaBD = CuotaBD::getInstancia();
	if($tarea=="consultar"){
		if($datos=$cuotaBD->obtenerDatos($socioOID)){
			$datos->estado="OK";
			exit(json_encode($datos));
		} else {
			exit('{"estado":"error","msg":"No hay ninguna cuota en curso"}');
		}
		
	} else if ($tarea=="modificar"){
		$datos=stripslashes($_POST['datos']);
		$cuota = json_decode(utf8_encode($datos));
		if($cuota!=NULL)
			if($cuotaBD->modificarCuota($socioOID,$cuota->OID,$cuota->cantidad,$cuota->intervaloPagos,$cuota->fechaFin))
				exit('{"estado":"OK"}');
			else
				exit('{"estado":"error","msg":"Error al modificar los datos de la cuota en la BD"}');
		else
			exit('{"estado":"error","msg":"Error de decodificación de datos"}');
	} else if ($tarea=="cancelar"){
		if($cuotaBD->cancelarCuota($socioOID))
			exit('{"estado":"OK"}');
		else
			exit('{"estado":"error","msg":"Error al cancelar la cuota en la BD"}');
	}
	
} else {
	exit('{"estado":"error","msg":"No estas identificado en el sistema"}');
}