<?php
/**
 *
 * Gestión de las consultas y modificaciones en la base de datos con 
 * todo lo referente a las Cuotas.
 * @author Jose A. Escobar
 *
 */
require_once 'DriverBD.php';
class CuotaBD{
	private static $instancia;

	private function __construct(){
	}
	
	/* Patrón singleton */
	public static function getInstancia(){
		if (  !self::$instancia instanceof self)
		{
			self::$instancia = new self;
		}
		return self::$instancia;
	}
	
	/*
	 * Obtiene los datos de la última cuota en curso del Socio
	 */
	public function obtenerDatos($socioOID){
		try{
			$conex=DriverBD::getInstancia()->conectar();
			$conex->exec("SET CHARACTER SET utf8");
			$stmt=$conex->prepare("SELECT * FROM Cuota WHERE OIDSocio=:oid AND FechaFin IS NULL");
			$stmt->bindParam(":oid",$socioOID);
			$stmt->execute();
			$datos = $stmt->fetch(PDO::FETCH_OBJ);
			DriverBD::getInstancia()->desconectar();
			return $datos;
		}catch(PDOException $e){
			return false;
		}
	}
	
	/*
	 * Cancela la cuota actual del Socio
	 */
	public function cancelarCuota($socioOID){
		try{
			$conex=DriverBD::getInstancia()->conectar();
			$stmt=$conex->prepare("UPDATE Cuota SET FechaFin=:fecha WHERE OIDSocio=:oid AND FechaFin IS NULL");
			$fecha = date("Y-m-d",time());
			$stmt->bindParam(":fecha",$fecha);
			$stmt->bindParam(":oid",$socioOID);
			$stmt->execute();
			DriverBD::getInstancia()->desconectar();
			return true;
		}catch(PDOException $e){
			return false;
		}
	}
	
	/*
	 * Modifica los datos de la cuota actual, cancelando esta a fecha actual
	 * y creando una nueva con dichos datos y la fecha actual como inicio
	 */
	public function modificarCuota($socioOID,$OID,$cantidad,$intervaloPagos,$fechaFin){
		try{
			$conex=DriverBD::getInstancia()->conectar();
			$stmt=$conex->prepare("UPDATE Cuota SET FechaFin=:fecha WHERE OID=:oid AND FechaFin IS NULL");
			$stmt->bindParam(":oid",$OID);
			$stmt->bindParam(":fecha",$fechaFin);
			$stmt->execute();
			$stmt=$conex->prepare("INSERT INTO Cuota (OIDSocio,Cantidad,IntervalosPagos,FechaInicio) VALUES (:oid,:cantidad,:intervalo,:fecha)");
			$stmt->bindParam(":oid",$socioOID);
			$stmt->bindParam(":cantidad",$cantidad);
			$stmt->bindParam(":intervalo",$intervaloPagos);
			$stmt->bindParam(":fecha",$fechaFin);
			$stmt->execute();
			DriverBD::getInstancia()->desconectar();
			return true;
		}catch(PDOException $e){
			return false;
		}
		
	}
}
?>