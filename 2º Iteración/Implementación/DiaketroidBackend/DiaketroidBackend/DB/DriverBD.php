<?php
/**
 * 
 * Driver de la base de datos para la comunicaci�n con esta
 * @author Jose A. Escobar
 *
 */
class DriverBD{
	private static $instancia = null;
	private $conexion = null;
	
	/* Datos de conexi�n a la BD */
	private $direccion="sql109.byethost13.com";
	private $baseDeDatos="b13_10564860_diaketas";
	private $usuario="b13_10564860";
	private $password="diaketas";
	
	private function __construct(){}
	
	/*
	 * Patr�n Singleton
	 */
	public static function getInstancia(){
		if (  !self::$instancia instanceof self)
		{
			self::$instancia = new self;
		}
		return self::$instancia;
	}
	
	/*
	 * Establece una nueva conexi�n con la BD, devolviendo un objeto
	 * PDO con la misma
	 */
	public function conectar(){
		try{
			$this->conexion=new PDO("mysql:host=$this->direccion;dbname=$this->baseDeDatos",$this->usuario,$this->password);
			$this->conexion->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
			return $this->conexion;
		}catch(PDOException $e){
			return false;
		} 
	}
	
	/*
	 * Destruye la conexi�n a la BD
	 */
	public function desconectar(){
		$this->conexion=null;
	}
}
?>
	