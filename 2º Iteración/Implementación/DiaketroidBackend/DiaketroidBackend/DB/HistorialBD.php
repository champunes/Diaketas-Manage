<?php
/**
 *
 * Gestión de las consultas y modificaciones en la base de datos con
 * todo lo referente al historial de pagos y colaboracioens del socio
 * @author Jose A. Escobar
 *
 */
require_once 'DriverBD.php';
class HistorialBD{
	private static $instancia;

	private function __construct(){
	}
	
	/*
	 * Patrón Singleton
	 */
	public static function getInstancia(){
		if (  !self::$instancia instanceof self)
		{
			self::$instancia = new self;
		}
		return self::$instancia;
	}
	
	/*
	 * Obtiene todos los pagos y colaboraciones del socio para un periodo
	 * de tiempo específico.
	 */
	public function obtenerDatos($socioOID,$fechaInicio,$fechaFin){
		try{
			$conex=DriverBD::getInstancia()->conectar();
			$conex->exec("SET CHARACTER SET utf8");
			$stmt=$conex->prepare("SELECT 'Cuota' AS Type, m.* FROM PagoCuota p, Movimiento m WHERE p.OID = m.OID AND p.OIDSocio=:oid AND :ini<=m.fecha AND :fin>=m.fecha");
			$stmt->bindParam(":oid",$socioOID);
			$stmt->bindParam(":ini",$fechaInicio);
			$stmt->bindParam(":fin",$fechaFin);
			$stmt->execute();
			$datos1 = $stmt->fetchAll(PDO::FETCH_ASSOC);
			$stmt=$conex->prepare("SELECT 'Colab.' AS Type, m.* FROM Colaboracion c, Movimiento m WHERE c.OID = m.OID AND c.OIDColaborador=:oid AND :ini<=m.fecha AND :fin>=m.fecha");
			$stmt->bindParam(":oid",$socioOID);
			$stmt->bindParam(":ini",$fechaInicio);
			$stmt->bindParam(":fin",$fechaFin);
			$stmt->execute();
			$datos2 = $stmt->fetchAll(PDO::FETCH_ASSOC);
			DriverBD::getInstancia()->desconectar();
			return array_merge($datos1,$datos2);
			
		}catch(PDOException $e){
			echo $e->getMessage();
			return false;
		}
	}
}