/**
 ** NOMBRE CLASE: 
 **	  VentanaPrincipal.java
 **
 ** DESCRIPCION:
 **       Ventana principal de la aplicación que contiene todos los paneles que la componen
 *        asímismo es la encargada de registrar todos los listeners de cada widget haciendo uso de 
 *        los controladores diseñados para cada sección de la misma.
 **       
 **
 ** DESARROLLADO POR:
 *          Mario Orozco Borrego (MOB)
 **         José Ángel González Molina (JGM)
 **        
 **
 ** SUPERVISADO POR:
 **          
 **
 ** HISTORIA:
 ** 	000 - Mar 20, 2012 - JGM - Creacion
 *      001 - Mar 21, 2012 - JGM - Adición de los métodos para mostrar cada una de las vistas
 **     002 - Mar 22, 2012 - MOB - Profunda reestructuración de toda la interfaz gráfica
 **     003 - Mar 23, 2012 - MOB - Modificación del contructor de la clase para que empiece obteniendo todos los controladores
 *      004 - Mar 23, 2012 - MOB - Registro de los listeners de toda la interfaz en el constructor de la clase
 *      005 - Mar 25, 2012 - MOB - Refactoring de los metodos que muestran las vistas, ahora su nombre es mas descriptivo
 *      006 - Mar 25, 2012 - MOB - Finalización del diseño de la interfaz
 **
 ** NOTAS:
 **   
 **
 */

package Vista;

import Controlador.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Mario Orozco Borrego
 */
public class VentanaPrincipal extends javax.swing.JFrame {

	private static VentanaPrincipal instancia;
        
        public static VentanaPrincipal getInstance(){
            if (instancia == null)
                instancia = new VentanaPrincipal();
            return instancia;
        }
	
        /**
	 * Crea la ventana principal que contendrá todos los elementos que la componene, además
         * registra todos los listeners para cada uno de los widgets usando el controlador requerido 
         * para cada caso
         * 
         * 
         * @see ControladorPrincipal
         * @see ControladorBeneficiario
         * @see ControladorContabilidad
         * @see ControladorVoluntarios
         * @see ControladorAyuda
         * 
         * @see ActionListener
	 */
	private VentanaPrincipal() {
		initComponents();
                
                
                /**
                 * Se obtienen las instancias de todos los controladores que maneja la aplicación
                 */
                ControladorPrincipal cPrincipal = ControladorPrincipal.getInstance();
                ControladorBeneficiario cBeneficiario = ControladorBeneficiario.getInstance();
                ControladorContabilidad cContabilidad = ControladorContabilidad.getInstance();
                ControladorVoluntarios cVoluntarios = ControladorVoluntarios.getInstance();
                ControladorAyuda cAyuda = ControladorAyuda.getInstance();
               
               /**
                * Se le pasa como parámetro a cada uno de ellos la ventana padre que tienen asocidada
                */ 
                cPrincipal.setVentanaPrincipal(this);
                cBeneficiario.setVentanaPrincipal(this);
                cContabilidad.setVentanaPrincipal(this);
                cVoluntarios.setVentanaPrincipal(this);
                cAyuda.setVentanaPrincipal(this);
                
                
                /** 
                 * REGISTRAR LISTENERS PARA EL PANEL DE IDENTIFICACION
                 */
                btConectarse.addActionListener(cPrincipal);
                
                /**
                 * REGISTRAR LISTENERS PARA EL PANEL DE INICIO PRINCIPAL
                 */
                
                btBeneficiario.addActionListener(cPrincipal);
                btBolsaTrabajo.addActionListener(cPrincipal);
                btSocio.addActionListener(cPrincipal);
                btVoluntario.addActionListener(cPrincipal);
                
                
                /**
                 * REGISTRAR LISTENERS PARA EL PANEL DE INICIO DE BENEFICIARIOS
                 */
                btBuscarBeneficiario.addActionListener(cBeneficiario);
                btNuevoBeneficiario.addActionListener(cBeneficiario);
                navToMainFromBeneficiarios.addActionListener(cBeneficiario);
                
                
                
                /**
                 * REGISTRAR LISTENERS PARA EL PANEL DE CONTABILIDAD
                 */
                btnObtenerContabilidad.addActionListener(cContabilidad);
                navToMainFromContabilidad.addActionListener(cContabilidad);
                navToVoluntariosFromContabilidad.addActionListener(cContabilidad);
                
                
                /**
                 * REGISTRAR LISTENERS PARA EL PANEL DE VOLUNTARIOS
                 */
                btAyudas.addActionListener(cVoluntarios);
                btBuscarVoluntario.addActionListener(cVoluntarios);
                btContabilidad.addActionListener(cVoluntarios);
                btNuevoVoluntario.addActionListener(cVoluntarios);
                navToMainFromVoluntarios.addActionListener(cVoluntarios);
                
                 
                /**
                 * REGISTRAR LOS LISTENERS PARA EL PANEL DE AYUDAS
                 */
                navToMainFromAyudas.addActionListener(cAyuda);
                navToVoluntariosFromAyudas.addActionListener(cAyuda);
                btnBuscarBeneficiario.addActionListener(cAyuda);
                btnGuardarTipoAyuda.addActionListener(cAyuda);
                btnEliminarTipoAyuda.addActionListener(cAyuda);
                
                
                /** 
                 * REGISTRAR LOS LISTENERS PARA EL PANEL DE BUSQUEDA DE BENEFICIARIO
                 */
                navToMainFromBuscarBeneficiario.addActionListener(cBeneficiario);
                navToBeneficiariosFromBuscarBeneficiario.addActionListener(cBeneficiario);
                btBuscarBeneficiarioDNI.addActionListener(cBeneficiario);
                btVerBeneficiarioBusqueda.addActionListener(cBeneficiario);
                
                
                /**
                 * REGISTRAR LOS LISTENERS PARA EL PANEL DE BUSQUEDA DE VOLUNTARIO
                 */
                navToMainFromBuscarVoluntario.addActionListener(cVoluntarios);
                navToVoluntariosFromBuscarVoluntario.addActionListener(cVoluntarios);
                btBuscarVoluntarioDNI.addActionListener(cVoluntarios);
                btVerVoluntarioBusqueda.addActionListener(cVoluntarios);
                
                
                /** 
                 * REGISTRAR LOS LISTENERES PARA EL PANEL DE DATOS DE VOLUNTARIOS
                 */
                navToMainFromDatosVoluntario.addActionListener(cVoluntarios);
                navToVoluntariosFromDatosVoluntario.addActionListener(cVoluntarios);
                btBorrar.addActionListener(cVoluntarios);
                btGuardar.addActionListener(cVoluntarios);
                
                /**
                 * REGISTRAR LOS LISTENERS PARA EL PANEL DE DATOS DE BENEFICIARIOS
                 */
                navToMainFromBeneficiarioDatos.addActionListener(cBeneficiario);
                navToBeneficiariosFromBeneficiarioDatos.addActionListener(cBeneficiario);
                
                
                /** Esta ventana principal será visible y mostrará la ventana de identificación */
                
                this.setVisible(true);
                this.mostrarVistaIdentificacion();   
                 
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelIdentificacion = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        labelContrasena = new javax.swing.JLabel();
        textFieldIdUsuario = new javax.swing.JTextField();
        btConectarse = new javax.swing.JButton();
        textFieldContrasena = new javax.swing.JPasswordField();
        PanelInicio = new javax.swing.JPanel();
        btSocio = new javax.swing.JButton();
        btBeneficiario = new javax.swing.JButton();
        btVoluntario = new javax.swing.JButton();
        btBolsaTrabajo = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        PanelBeneficiarioInicio = new javax.swing.JPanel();
        separadorBeneficiario = new javax.swing.JSeparator();
        senalaBeneficiario = new javax.swing.JLabel();
        labSBenef = new javax.swing.JLabel();
        btNuevoBeneficiario = new javax.swing.JButton();
        btBuscarBeneficiario = new javax.swing.JButton();
        navToMainFromBeneficiarios = new javax.swing.JButton();
        PanelBeneficiarioBuscar = new javax.swing.JPanel();
        separadorBeneficiario1 = new javax.swing.JSeparator();
        senalaBeneficiario1 = new javax.swing.JLabel();
        navToMainFromBuscarBeneficiario = new javax.swing.JButton();
        navToBeneficiariosFromBuscarBeneficiario = new javax.swing.JButton();
        senalaBeneficiario2 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        textBusquedaBeneficiarioDNI = new javax.swing.JTextField();
        btBuscarBeneficiarioDNI = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        cbTipoBusquedaBeneficiario = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaBusquedaBeneficiario = new javax.swing.JTable();
        btVerBeneficiarioBusqueda = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        PanelBeneficiarioDatos = new javax.swing.JPanel();
        separadorBeneficiario3 = new javax.swing.JSeparator();
        senalaBeneficiario5 = new javax.swing.JLabel();
        navToMainFromBeneficiarioDatos = new javax.swing.JButton();
        navToBeneficiariosFromBeneficiarioDatos = new javax.swing.JButton();
        senalaBeneficiario6 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        textTelefonoBeneficiario = new javax.swing.JTextField();
        textCPBeneficiario = new javax.swing.JTextField();
        textApellidosBeneficiario = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        cbEstadoCivilBeneficiario = new javax.swing.JComboBox();
        textProfesionBeneficiario = new javax.swing.JTextField();
        textProvinciaNacimientoBeneficiario = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        cbNivelEstudiosBeneficiario = new javax.swing.JComboBox();
        textNacionalidadBenficiario = new javax.swing.JTextField();
        textNombreBeneficiario = new javax.swing.JTextField();
        textNIFBeneficiario = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        textDomicilioBeneficiario = new javax.swing.JTextField();
        textLocalidadBeneficiario = new javax.swing.JTextField();
        textObservacionesBeneficiario = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        textFechaNacimientoBeneficiario = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        cbTipoViviendaBeneficiario = new javax.swing.JComboBox();
        textPrecioViviendaBeneficiario = new javax.swing.JTextField();
        textEspecificarTipoVivienda = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        textEstadoCivilBeneficiario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        cbParentescoBeneficiario = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        btEliminarFamiliarBeneficiario = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        listDatosFamiliarBeneficiario = new javax.swing.JTable();
        textObservacionesFamiliarBeneficiario = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        btGuardarFamiliarBeneficiario = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        textNIFFamiliarBeneficiario = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();
        textObservacionesIntervencionBeneficiario = new javax.swing.JTextField();
        textConceptoBeneficiario = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        textImporteBeneficiario = new javax.swing.JTextField();
        PanelVoluntarioInicio = new javax.swing.JPanel();
        separadorVoluntario = new javax.swing.JSeparator();
        senalaVoluntario = new javax.swing.JLabel();
        labSVolunt = new javax.swing.JLabel();
        btNuevoVoluntario = new javax.swing.JButton();
        btBuscarVoluntario = new javax.swing.JButton();
        btContabilidad = new javax.swing.JButton();
        btAyudas = new javax.swing.JButton();
        navToMainFromVoluntarios = new javax.swing.JButton();
        panelVoluntarioDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textNIF = new javax.swing.JTextField();
        textNacionalidad = new javax.swing.JTextField();
        textNivelEstudios = new javax.swing.JTextField();
        textDomicilio = new javax.swing.JTextField();
        textLocalidad = new javax.swing.JTextField();
        textObservaciones = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textApellidos = new javax.swing.JTextField();
        textProfesion = new javax.swing.JTextField();
        textCP = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        cbEstadoCivil = new javax.swing.JComboBox();
        textFechaNacimiento = new javax.swing.JFormattedTextField();
        btGuardar = new javax.swing.JButton();
        btBorrar = new javax.swing.JButton();
        separadorVoluntario1 = new javax.swing.JSeparator();
        senalaVoluntario1 = new javax.swing.JLabel();
        navToMainFromDatosVoluntario = new javax.swing.JButton();
        navToVoluntariosFromDatosVoluntario = new javax.swing.JButton();
        senalaVoluntario2 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        PanelVoluntarioContabilidad = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelListaGastos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelListaIngresos = new javax.swing.JTable();
        fieldFechaInicio = new javax.swing.JFormattedTextField();
        fieldFechaFin = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnObtenerContabilidad = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        cuadroBalance = new javax.swing.JTextField();
        separadorVoluntario2 = new javax.swing.JSeparator();
        senalaVoluntario3 = new javax.swing.JLabel();
        navToMainFromContabilidad = new javax.swing.JButton();
        navToVoluntariosFromContabilidad = new javax.swing.JButton();
        senalaVoluntario4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        PanelVoluntarioBuscar = new javax.swing.JPanel();
        separadorBeneficiario2 = new javax.swing.JSeparator();
        senalaBeneficiario3 = new javax.swing.JLabel();
        navToMainFromBuscarVoluntario = new javax.swing.JButton();
        navToVoluntariosFromBuscarVoluntario = new javax.swing.JButton();
        senalaBeneficiario4 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        textBusquedaVoluntarioDNI = new javax.swing.JTextField();
        btBuscarVoluntarioDNI = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        cbTipoBusquedaVoluntario = new javax.swing.JComboBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaBusquedaVoluntario = new javax.swing.JTable();
        btVerVoluntarioBusqueda = new javax.swing.JButton();
        PanelVoluntarioAyudas = new javax.swing.JPanel();
        separadorVoluntario3 = new javax.swing.JSeparator();
        senalaVoluntario5 = new javax.swing.JLabel();
        navToMainFromAyudas = new javax.swing.JButton();
        navToVoluntariosFromAyudas = new javax.swing.JButton();
        senalaVoluntario6 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnBuscarBeneficiario = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btnEliminarTipoAyuda = new javax.swing.JButton();
        btnGuardarTipoAyuda = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Diaketas Manage");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(135, 170, 235));
        setBounds(new java.awt.Rectangle(0, 0, 1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout(10, 10));

        PanelIdentificacion.setBackground(new java.awt.Color(255, 254, 254));
        PanelIdentificacion.setBounds(new java.awt.Rectangle(0, 0, 1000, 600));
        PanelIdentificacion.setMaximumSize(new java.awt.Dimension(1000, 600));
        PanelIdentificacion.setMinimumSize(new java.awt.Dimension(1000, 600));
        PanelIdentificacion.setPreferredSize(new java.awt.Dimension(1000, 600));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/Acceso_Usuarios.jpg"))); // NOI18N

        labelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 0, 0));
        labelTitulo.setText("BIENVENIDO A DIAKETAS");

        labelUsuario.setText("USUARIO");

        labelContrasena.setText("CONTRASEÑA");

        btConectarse.setText("Entrar");
        btConectarse.setActionCommand("accionLogin");

        org.jdesktop.layout.GroupLayout PanelIdentificacionLayout = new org.jdesktop.layout.GroupLayout(PanelIdentificacion);
        PanelIdentificacion.setLayout(PanelIdentificacionLayout);
        PanelIdentificacionLayout.setHorizontalGroup(
            PanelIdentificacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelIdentificacionLayout.createSequentialGroup()
                .add(PanelIdentificacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, PanelIdentificacionLayout.createSequentialGroup()
                        .add(464, 464, 464)
                        .add(labelTitulo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(PanelIdentificacionLayout.createSequentialGroup()
                        .add(PanelIdentificacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(PanelIdentificacionLayout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(labelContrasena))
                            .add(PanelIdentificacionLayout.createSequentialGroup()
                                .add(120, 120, 120)
                                .add(imgLogo)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(labelUsuario)))
                        .add(25, 25, 25)
                        .add(PanelIdentificacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(textFieldIdUsuario)
                            .add(textFieldContrasena)
                            .add(PanelIdentificacionLayout.createSequentialGroup()
                                .add(0, 0, Short.MAX_VALUE)
                                .add(btConectarse, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .add(201, 201, 201))
        );
        PanelIdentificacionLayout.setVerticalGroup(
            PanelIdentificacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, PanelIdentificacionLayout.createSequentialGroup()
                .add(148, 148, 148)
                .add(PanelIdentificacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(imgLogo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(PanelIdentificacionLayout.createSequentialGroup()
                        .add(labelTitulo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(135, 135, 135)
                        .add(PanelIdentificacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(textFieldIdUsuario)
                            .add(labelUsuario, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(PanelIdentificacionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(textFieldContrasena)
                            .add(labelContrasena, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(18, 18, 18)
                        .add(btConectarse)
                        .add(34, 34, 34)))
                .add(143, 143, 143))
        );

        getContentPane().add(PanelIdentificacion, "card2");

        PanelInicio.setBackground(new java.awt.Color(255, 255, 255));
        PanelInicio.setBounds(new java.awt.Rectangle(0, 0, 1000, 600));
        PanelInicio.setMaximumSize(new java.awt.Dimension(1000, 600));
        PanelInicio.setPreferredSize(new java.awt.Dimension(1000, 600));

        btSocio.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/socio.png"))); // NOI18N
        btSocio.setText("SOCIOS");
        btSocio.setToolTipText("Acceso a Socios");
        btSocio.setActionCommand("entrarAPanelSocios");
        btSocio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btSocio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSocio.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btSocio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btBeneficiario.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btBeneficiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/bene.png"))); // NOI18N
        btBeneficiario.setText("BENEFICIARIOS");
        btBeneficiario.setActionCommand("entrarAPanelBeneficiarios");
        btBeneficiario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btBeneficiario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btVoluntario.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btVoluntario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/imgVolunt.jpg"))); // NOI18N
        btVoluntario.setText("VOLUNTARIOS");
        btVoluntario.setActionCommand("entrarAPanelVoluntarios");
        btVoluntario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btVoluntario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btBolsaTrabajo.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btBolsaTrabajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/imgBolsa.jpg"))); // NOI18N
        btBolsaTrabajo.setText("BOLSA DE TRABAJO");
        btBolsaTrabajo.setActionCommand("entrarAPanelBolsaTrabajo");
        btBolsaTrabajo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btBolsaTrabajo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel21.setText("PANEL PRINCIPAL");

        org.jdesktop.layout.GroupLayout PanelInicioLayout = new org.jdesktop.layout.GroupLayout(PanelInicio);
        PanelInicio.setLayout(PanelInicioLayout);
        PanelInicioLayout.setHorizontalGroup(
            PanelInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelInicioLayout.createSequentialGroup()
                .add(29, 29, 29)
                .add(jLabel21)
                .addContainerGap(843, Short.MAX_VALUE))
            .add(PanelInicioLayout.createSequentialGroup()
                .add(99, 99, 99)
                .add(PanelInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(btSocio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 215, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btVoluntario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 215, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 350, Short.MAX_VALUE)
                .add(PanelInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btBeneficiario)
                    .add(btBolsaTrabajo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 215, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(121, 121, 121))
        );
        PanelInicioLayout.setVerticalGroup(
            PanelInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, PanelInicioLayout.createSequentialGroup()
                .add(26, 26, 26)
                .add(jLabel21)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 64, Short.MAX_VALUE)
                .add(PanelInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btSocio)
                    .add(btBeneficiario))
                .add(72, 72, 72)
                .add(PanelInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(btVoluntario)
                    .add(btBolsaTrabajo))
                .add(55, 55, 55))
        );

        PanelInicioLayout.linkSize(new java.awt.Component[] {btBeneficiario, btBolsaTrabajo, btSocio, btVoluntario}, org.jdesktop.layout.GroupLayout.VERTICAL);

        getContentPane().add(PanelInicio, "card3");

        PanelBeneficiarioInicio.setBackground(new java.awt.Color(255, 255, 255));
        PanelBeneficiarioInicio.setBounds(new java.awt.Rectangle(0, 0, 1000, 600));
        PanelBeneficiarioInicio.setMaximumSize(new java.awt.Dimension(1000, 600));
        PanelBeneficiarioInicio.setPreferredSize(new java.awt.Dimension(1000, 600));

        senalaBeneficiario.setForeground(new java.awt.Color(153, 153, 153));
        senalaBeneficiario.setText(">");

        labSBenef.setText("Beneficiarios");

        btNuevoBeneficiario.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btNuevoBeneficiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/usu.png"))); // NOI18N
        btNuevoBeneficiario.setText("NUEVO BENEFICIARIO");
        btNuevoBeneficiario.setActionCommand("nuevoBeneficiario");
        btNuevoBeneficiario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNuevoBeneficiario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btBuscarBeneficiario.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btBuscarBeneficiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/lupa (1).png"))); // NOI18N
        btBuscarBeneficiario.setText("BUSCAR");
        btBuscarBeneficiario.setActionCommand("buscarBeneficiario");
        btBuscarBeneficiario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btBuscarBeneficiario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        navToMainFromBeneficiarios.setForeground(new java.awt.Color(0, 0, 255));
        navToMainFromBeneficiarios.setText("DIAKETAS");
        navToMainFromBeneficiarios.setActionCommand("navToMainFromBeneficiarios");
        navToMainFromBeneficiarios.setBorderPainted(false);

        org.jdesktop.layout.GroupLayout PanelBeneficiarioInicioLayout = new org.jdesktop.layout.GroupLayout(PanelBeneficiarioInicio);
        PanelBeneficiarioInicio.setLayout(PanelBeneficiarioInicioLayout);
        PanelBeneficiarioInicioLayout.setHorizontalGroup(
            PanelBeneficiarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelBeneficiarioInicioLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelBeneficiarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(separadorBeneficiario)
                    .add(PanelBeneficiarioInicioLayout.createSequentialGroup()
                        .add(navToMainFromBeneficiarios)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(senalaBeneficiario)
                        .add(18, 18, 18)
                        .add(labSBenef)
                        .add(0, 768, Short.MAX_VALUE)))
                .addContainerGap())
            .add(PanelBeneficiarioInicioLayout.createSequentialGroup()
                .add(121, 121, 121)
                .add(btNuevoBeneficiario)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 282, Short.MAX_VALUE)
                .add(btBuscarBeneficiario)
                .add(165, 165, 165))
        );

        PanelBeneficiarioInicioLayout.linkSize(new java.awt.Component[] {btBuscarBeneficiario, btNuevoBeneficiario}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        PanelBeneficiarioInicioLayout.setVerticalGroup(
            PanelBeneficiarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelBeneficiarioInicioLayout.createSequentialGroup()
                .add(11, 11, 11)
                .add(PanelBeneficiarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(senalaBeneficiario)
                    .add(labSBenef)
                    .add(navToMainFromBeneficiarios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(separadorBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(174, 174, 174)
                .add(PanelBeneficiarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btNuevoBeneficiario)
                    .add(btBuscarBeneficiario))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        getContentPane().add(PanelBeneficiarioInicio, "card4");

        PanelBeneficiarioBuscar.setBackground(new java.awt.Color(255, 255, 255));
        PanelBeneficiarioBuscar.setBounds(new java.awt.Rectangle(0, 0, 1000, 600));
        PanelBeneficiarioBuscar.setMaximumSize(new java.awt.Dimension(1000, 600));
        PanelBeneficiarioBuscar.setPreferredSize(new java.awt.Dimension(1000, 600));

        senalaBeneficiario1.setForeground(new java.awt.Color(153, 153, 153));
        senalaBeneficiario1.setText(">");

        navToMainFromBuscarBeneficiario.setForeground(new java.awt.Color(0, 0, 255));
        navToMainFromBuscarBeneficiario.setText("DIAKETAS");
        navToMainFromBuscarBeneficiario.setActionCommand("navToMainFromBuscarBeneficiario");
        navToMainFromBuscarBeneficiario.setBorderPainted(false);

        navToBeneficiariosFromBuscarBeneficiario.setForeground(new java.awt.Color(0, 0, 255));
        navToBeneficiariosFromBuscarBeneficiario.setText("Beneficiarios");
        navToBeneficiariosFromBuscarBeneficiario.setActionCommand("navToBeneficiariosFromBuscarBeneficiario");
        navToBeneficiariosFromBuscarBeneficiario.setBorderPainted(false);

        senalaBeneficiario2.setForeground(new java.awt.Color(153, 153, 153));
        senalaBeneficiario2.setText(">");

        jLabel27.setText("Buscar Beneficiario");

        btBuscarBeneficiarioDNI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/buscar.png"))); // NOI18N
        btBuscarBeneficiarioDNI.setActionCommand("buscarBeneficiarioDNI");

        jLabel29.setText("Criterio de búsqueda");

        cbTipoBusquedaBeneficiario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tablaBusquedaBeneficiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo Búsqueda", "DNI", "Nombre y Apellidos", "Fecha Nacimiento"
            }
        ));
        jScrollPane5.setViewportView(tablaBusquedaBeneficiario);

        btVerBeneficiarioBusqueda.setText("Ver beneficiario");
        btVerBeneficiarioBusqueda.setActionCommand("verBeneficiarioBusqueda");

        jLabel63.setText("Introduzca el DNI para buscar al beneficiario");

        org.jdesktop.layout.GroupLayout PanelBeneficiarioBuscarLayout = new org.jdesktop.layout.GroupLayout(PanelBeneficiarioBuscar);
        PanelBeneficiarioBuscar.setLayout(PanelBeneficiarioBuscarLayout);
        PanelBeneficiarioBuscarLayout.setHorizontalGroup(
            PanelBeneficiarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelBeneficiarioBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelBeneficiarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelBeneficiarioBuscarLayout.createSequentialGroup()
                        .add(PanelBeneficiarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(separadorBeneficiario1)
                            .add(PanelBeneficiarioBuscarLayout.createSequentialGroup()
                                .add(PanelBeneficiarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(PanelBeneficiarioBuscarLayout.createSequentialGroup()
                                        .add(20, 20, 20)
                                        .add(jLabel63)
                                        .add(18, 18, 18)
                                        .add(textBusquedaBeneficiarioDNI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(btBuscarBeneficiarioDNI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(PanelBeneficiarioBuscarLayout.createSequentialGroup()
                                        .add(navToMainFromBuscarBeneficiario)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(senalaBeneficiario1)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(navToBeneficiariosFromBuscarBeneficiario)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(senalaBeneficiario2)
                                        .add(26, 26, 26)
                                        .add(jLabel27)))
                                .add(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, PanelBeneficiarioBuscarLayout.createSequentialGroup()
                        .add(0, 20, Short.MAX_VALUE)
                        .add(PanelBeneficiarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(PanelBeneficiarioBuscarLayout.createSequentialGroup()
                                .add(jLabel29)
                                .add(18, 18, 18)
                                .add(cbTipoBusquedaBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 138, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(PanelBeneficiarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(btVerBeneficiarioBusqueda)
                                .add(jScrollPane5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 948, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(26, 26, 26))))
        );
        PanelBeneficiarioBuscarLayout.setVerticalGroup(
            PanelBeneficiarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelBeneficiarioBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelBeneficiarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(senalaBeneficiario1)
                    .add(navToMainFromBuscarBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(navToBeneficiariosFromBuscarBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(senalaBeneficiario2)
                    .add(jLabel27))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(separadorBeneficiario1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(PanelBeneficiarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(PanelBeneficiarioBuscarLayout.createSequentialGroup()
                        .add(13, 13, 13)
                        .add(PanelBeneficiarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel63)
                            .add(textBusquedaBeneficiarioDNI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(PanelBeneficiarioBuscarLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btBuscarBeneficiarioDNI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(PanelBeneficiarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel29)
                    .add(cbTipoBusquedaBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(14, 14, 14)
                .add(jScrollPane5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btVerBeneficiarioBusqueda)
                .add(10, 10, 10))
        );

        getContentPane().add(PanelBeneficiarioBuscar, "card10");

        PanelBeneficiarioDatos.setBackground(new java.awt.Color(255, 255, 255));
        PanelBeneficiarioDatos.setBounds(new java.awt.Rectangle(0, 0, 1000, 600));
        PanelBeneficiarioDatos.setMaximumSize(new java.awt.Dimension(1000, 600));
        PanelBeneficiarioDatos.setPreferredSize(new java.awt.Dimension(1000, 600));

        senalaBeneficiario5.setForeground(new java.awt.Color(153, 153, 153));
        senalaBeneficiario5.setText(">");

        navToMainFromBeneficiarioDatos.setForeground(new java.awt.Color(0, 0, 255));
        navToMainFromBeneficiarioDatos.setText("DIAKETAS");
        navToMainFromBeneficiarioDatos.setActionCommand("navToMainFromBeneficiarioDatos");
        navToMainFromBeneficiarioDatos.setBorderPainted(false);

        navToBeneficiariosFromBeneficiarioDatos.setForeground(new java.awt.Color(0, 0, 255));
        navToBeneficiariosFromBeneficiarioDatos.setText("Beneficiarios");
        navToBeneficiariosFromBeneficiarioDatos.setActionCommand("navToBeneficiariosFromBeneficiarioDatos");
        navToBeneficiariosFromBeneficiarioDatos.setBorderPainted(false);

        senalaBeneficiario6.setForeground(new java.awt.Color(153, 153, 153));
        senalaBeneficiario6.setText(">");

        jLabel33.setText("Datos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel49.setText("Telefono");

        cbEstadoCivilBeneficiario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel35.setText("Nombre");

        jLabel38.setText("Nacionalidad");

        jLabel37.setText("NIF/DNI/Pasaporte");

        jLabel39.setText("Nivel de estudios");

        cbNivelEstudiosBeneficiario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel42.setText("Observaciones");

        jLabel40.setText("Domicilio");

        jLabel41.setText("Localidad");

        jLabel46.setText("en");

        jLabel47.setText("Profesion");

        jLabel48.setText("CP");

        jLabel44.setText("Nacido el");

        jLabel45.setText("Estado civil");

        jLabel55.setText("Apellidos");

        jLabel34.setForeground(new java.awt.Color(255, 0, 0));
        jLabel34.setText("Datos personales");

        jLabel50.setForeground(new java.awt.Color(255, 0, 0));
        jLabel50.setText("Vivienda");

        jLabel51.setText("Tipo");

        jLabel52.setText("Especificar");

        jLabel53.setText("Precio");

        cbTipoViviendaBeneficiario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel54.setText("Descripción de la situación económica");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane7.setViewportView(jTextArea1);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel34)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel38)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel37)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel35)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel39)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel40)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel41)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel42)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel51)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel52))
                            .add(jLabel50))
                        .add(34, 34, 34)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(textNacionalidadBenficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                        .add(textLocalidadBeneficiario)
                                        .add(textNombreBeneficiario)
                                        .add(textDomicilioBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(textNIFBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(28, 28, 28)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jLabel49)
                                    .add(jLabel48)
                                    .add(jLabel45)
                                    .add(jLabel44)
                                    .add(jLabel55))
                                .add(18, 18, 18)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(textFechaNacimientoBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jPanel2Layout.createSequentialGroup()
                                        .add(textApellidosBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(jLabel46)
                                        .add(18, 18, 18)
                                        .add(textProvinciaNacimientoBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(textTelefonoBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(textCPBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(cbTipoViviendaBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(51, 51, 51)
                                .add(jLabel53)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(textPrecioViviendaBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(textEspecificarTipoVivienda, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel2Layout.createSequentialGroup()
                                        .add(cbEstadoCivilBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(159, 159, 159)
                                        .add(textEstadoCivilBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(textObservacionesBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 403, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jPanel2Layout.createSequentialGroup()
                                        .add(cbNivelEstudiosBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(82, 82, 82)
                                        .add(jLabel47)
                                        .add(18, 18, 18)
                                        .add(textProfesionBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(45, 45, 45)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel54)
                                    .add(jScrollPane7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel34)
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel35)
                            .add(textNombreBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(6, 6, 6)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(textNIFBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel37)
                            .add(jLabel44)
                            .add(textApellidosBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel46)
                            .add(textProvinciaNacimientoBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel55)
                        .add(textFechaNacimientoBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel38)
                            .add(textNacionalidadBenficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel45)
                            .add(cbEstadoCivilBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textEstadoCivilBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel39)
                                .add(cbNivelEstudiosBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel47)
                                .add(textProfesionBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel40)
                            .add(textDomicilioBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel49)
                            .add(textTelefonoBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel41)
                            .add(textLocalidadBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel48)
                            .add(textCPBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(textObservacionesBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel42))
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(33, 33, 33)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel51)
                                    .add(cbTipoViviendaBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel53)
                                    .add(textPrecioViviendaBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(jLabel50)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(textEspecificarTipoVivienda, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel52)))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel54)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jScrollPane7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 241, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cbParentescoBeneficiario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel57.setText("Parentesco");

        btEliminarFamiliarBeneficiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/limpiar.png"))); // NOI18N

        listDatosFamiliarBeneficiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre y Apellidos", "Fecha nacimiento", "Parentesco", "Ocupacion"
            }
        ));
        jScrollPane9.setViewportView(listDatosFamiliarBeneficiario);

        jLabel58.setText("Observaciones");

        btGuardarFamiliarBeneficiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/save_f2.png"))); // NOI18N

        jLabel43.setForeground(new java.awt.Color(255, 0, 0));
        jLabel43.setText("Situación Socio/Familiar");

        textNIFFamiliarBeneficiario.setText("jTextField3");

        jLabel56.setText("NIF/DNI/Pasaporte del familiar");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jScrollPane9)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btEliminarFamiliarBeneficiario)
                    .add(btGuardarFamiliarBeneficiario)))
            .add(jPanel3Layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel56)
                        .add(18, 18, 18)
                        .add(textNIFFamiliarBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jLabel57)
                        .add(18, 18, 18)
                        .add(cbParentescoBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel43)
                        .addContainerGap(741, Short.MAX_VALUE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel58)
                        .add(18, 18, 18)
                        .add(textObservacionesFamiliarBeneficiario)
                        .add(91, 91, 91))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(jLabel43)
                .add(12, 12, 12)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel56)
                    .add(textNIFFamiliarBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel57)
                    .add(cbParentescoBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 280, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(btGuardarFamiliarBeneficiario)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btEliminarFamiliarBeneficiario)))
                .add(72, 72, 72)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel58)
                    .add(textObservacionesFamiliarBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/save_f2.png"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/limpiar.png"))); // NOI18N

        jLabel59.setForeground(new java.awt.Color(255, 0, 0));
        jLabel59.setText("Intervenciones realizadas");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Concepto", "Importe", "Observaciones"
            }
        ));
        jScrollPane10.setViewportView(jTable3);

        jLabel60.setText("Importe");

        jLabel62.setText("Observaciones");

        jLabel61.setText("Concepto");

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(27, 27, 27)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jScrollPane10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jLabel62)
                        .add(18, 18, 18)
                        .add(textObservacionesIntervencionBeneficiario)
                        .add(39, 39, 39))
                    .add(jLabel59)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(763, 763, 763)
                        .add(jButton1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton2))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(jLabel61)
                                .add(32, 32, 32))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4Layout.createSequentialGroup()
                                .add(jLabel60)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .add(18, 18, 18)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(textConceptoBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 717, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textImporteBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(new java.awt.Component[] {textConceptoBeneficiario, textObservacionesIntervencionBeneficiario}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .add(jLabel59)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 244, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(24, 24, 24)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel60)
                    .add(textImporteBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(12, 12, 12)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textConceptoBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel61))
                .add(12, 12, 12)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel62)
                    .add(textObservacionesIntervencionBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        org.jdesktop.layout.GroupLayout PanelBeneficiarioDatosLayout = new org.jdesktop.layout.GroupLayout(PanelBeneficiarioDatos);
        PanelBeneficiarioDatos.setLayout(PanelBeneficiarioDatosLayout);
        PanelBeneficiarioDatosLayout.setHorizontalGroup(
            PanelBeneficiarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelBeneficiarioDatosLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelBeneficiarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(PanelBeneficiarioDatosLayout.createSequentialGroup()
                        .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 941, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(separadorBeneficiario3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                    .add(PanelBeneficiarioDatosLayout.createSequentialGroup()
                        .add(navToMainFromBeneficiarioDatos)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(senalaBeneficiario5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(navToBeneficiariosFromBeneficiarioDatos)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(senalaBeneficiario6)
                        .add(26, 26, 26)
                        .add(jLabel33)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelBeneficiarioDatosLayout.setVerticalGroup(
            PanelBeneficiarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelBeneficiarioDatosLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelBeneficiarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(senalaBeneficiario5)
                    .add(navToMainFromBeneficiarioDatos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(navToBeneficiariosFromBeneficiarioDatos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(senalaBeneficiario6)
                    .add(jLabel33))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(PanelBeneficiarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(separadorBeneficiario3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(PanelBeneficiarioDatos, "card10");

        PanelVoluntarioInicio.setBackground(new java.awt.Color(255, 255, 255));
        PanelVoluntarioInicio.setBounds(new java.awt.Rectangle(0, 0, 1000, 600));
        PanelVoluntarioInicio.setMaximumSize(new java.awt.Dimension(1000, 600));
        PanelVoluntarioInicio.setMinimumSize(new java.awt.Dimension(1000, 600));
        PanelVoluntarioInicio.setPreferredSize(new java.awt.Dimension(1000, 600));

        senalaVoluntario.setForeground(new java.awt.Color(153, 153, 153));
        senalaVoluntario.setText(">");

        labSVolunt.setText("Voluntarios");

        btNuevoVoluntario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/vol.png"))); // NOI18N
        btNuevoVoluntario.setActionCommand("nuevoVoluntario");

        btBuscarVoluntario.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btBuscarVoluntario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/lupa.png"))); // NOI18N
        btBuscarVoluntario.setText("BUSCAR");
        btBuscarVoluntario.setActionCommand("buscarVoluntario");
        btBuscarVoluntario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btBuscarVoluntario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btContabilidad.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btContabilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/contabilidad.jpg"))); // NOI18N
        btContabilidad.setText("Contabilidad");
        btContabilidad.setActionCommand("contabilidad");
        btContabilidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btContabilidad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btAyudas.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btAyudas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/images.jpg"))); // NOI18N
        btAyudas.setText("AYUDAS");
        btAyudas.setActionCommand("ayudas");
        btAyudas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAyudas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        navToMainFromVoluntarios.setForeground(new java.awt.Color(0, 0, 255));
        navToMainFromVoluntarios.setText("DIAKETAS");
        navToMainFromVoluntarios.setActionCommand("navToMainFromVoluntarios");
        navToMainFromVoluntarios.setBorderPainted(false);

        org.jdesktop.layout.GroupLayout PanelVoluntarioInicioLayout = new org.jdesktop.layout.GroupLayout(PanelVoluntarioInicio);
        PanelVoluntarioInicio.setLayout(PanelVoluntarioInicioLayout);
        PanelVoluntarioInicioLayout.setHorizontalGroup(
            PanelVoluntarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelVoluntarioInicioLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelVoluntarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelVoluntarioInicioLayout.createSequentialGroup()
                        .add(navToMainFromVoluntarios)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(senalaVoluntario)
                        .add(32, 32, 32)
                        .add(labSVolunt)
                        .add(0, 762, Short.MAX_VALUE))
                    .add(separadorVoluntario))
                .addContainerGap())
            .add(PanelVoluntarioInicioLayout.createSequentialGroup()
                .add(96, 96, 96)
                .add(PanelVoluntarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btNuevoVoluntario)
                    .add(PanelVoluntarioInicioLayout.createSequentialGroup()
                        .add(104, 104, 104)
                        .add(btContabilidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 166, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 243, Short.MAX_VALUE)
                .add(PanelVoluntarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btBuscarVoluntario)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btAyudas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 166, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(108, 108, 108))
        );
        PanelVoluntarioInicioLayout.setVerticalGroup(
            PanelVoluntarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelVoluntarioInicioLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelVoluntarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(navToMainFromVoluntarios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(senalaVoluntario)
                    .add(labSVolunt))
                .add(4, 4, 4)
                .add(separadorVoluntario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(47, 47, 47)
                .add(PanelVoluntarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(btNuevoVoluntario, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btBuscarVoluntario))
                .add(66, 66, 66)
                .add(PanelVoluntarioInicioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btAyudas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 183, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btContabilidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 183, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        getContentPane().add(PanelVoluntarioInicio, "card7");

        panelVoluntarioDatos.setBackground(new java.awt.Color(255, 255, 255));
        panelVoluntarioDatos.setMaximumSize(new java.awt.Dimension(1000, 600));
        panelVoluntarioDatos.setMinimumSize(new java.awt.Dimension(1000, 600));
        panelVoluntarioDatos.setPreferredSize(new java.awt.Dimension(1000, 600));
        panelVoluntarioDatos.setSize(new java.awt.Dimension(1000, 600));

        jLabel2.setText("Nombre");

        jLabel3.setText("NIF/DNI/Pasaporte");

        jLabel4.setText("Nacionalidad");

        jLabel5.setText("Nivel de estudios");

        jLabel6.setText("Domicilio");

        jLabel7.setText("Localidad");

        jLabel8.setText("Observaciones");

        jLabel1.setText("Apellidos");

        jLabel9.setText("Nacido el");

        jLabel10.setText("Estado Civil");

        jLabel11.setText("Profesión");

        jLabel12.setText("CP");

        jLabel13.setText("Teléfono");

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Casado", "Soltero", "NS/NC" }));

        textFechaNacimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/save_f2.png"))); // NOI18N
        btGuardar.setActionCommand("guardarDatosVoluntario");

        btBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/limpiar.png"))); // NOI18N
        btBorrar.setActionCommand("borrarDatosVoluntario");

        senalaVoluntario1.setForeground(new java.awt.Color(153, 153, 153));
        senalaVoluntario1.setText(">");

        navToMainFromDatosVoluntario.setForeground(new java.awt.Color(0, 0, 255));
        navToMainFromDatosVoluntario.setText("DIAKETAS");
        navToMainFromDatosVoluntario.setActionCommand("navToMainFromDatosVoluntario");
        navToMainFromDatosVoluntario.setBorderPainted(false);

        navToVoluntariosFromDatosVoluntario.setForeground(new java.awt.Color(0, 0, 255));
        navToVoluntariosFromDatosVoluntario.setText("Voluntarios");
        navToVoluntariosFromDatosVoluntario.setActionCommand("navToVoluntariosFromDatosVoluntario");
        navToVoluntariosFromDatosVoluntario.setBorderPainted(false);

        senalaVoluntario2.setForeground(new java.awt.Color(153, 153, 153));
        senalaVoluntario2.setText(">");

        jLabel22.setText("Datos Voluntario");

        org.jdesktop.layout.GroupLayout panelVoluntarioDatosLayout = new org.jdesktop.layout.GroupLayout(panelVoluntarioDatos);
        panelVoluntarioDatos.setLayout(panelVoluntarioDatosLayout);
        panelVoluntarioDatosLayout.setHorizontalGroup(
            panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelVoluntarioDatosLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelVoluntarioDatosLayout.createSequentialGroup()
                        .add(navToMainFromDatosVoluntario)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(senalaVoluntario1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(navToVoluntariosFromDatosVoluntario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(senalaVoluntario2)
                        .add(27, 27, 27)
                        .add(jLabel22)
                        .add(0, 591, Short.MAX_VALUE))
                    .add(separadorVoluntario1)))
            .add(panelVoluntarioDatosLayout.createSequentialGroup()
                .add(129, 129, 129)
                .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(jLabel4)
                    .add(jLabel5)
                    .add(jLabel6)
                    .add(jLabel7)
                    .add(jLabel8))
                .add(45, 45, 45)
                .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(panelVoluntarioDatosLayout.createSequentialGroup()
                        .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(panelVoluntarioDatosLayout.createSequentialGroup()
                                .add(textLocalidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabel13))
                            .add(panelVoluntarioDatosLayout.createSequentialGroup()
                                .add(textDomicilio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabel12))
                            .add(panelVoluntarioDatosLayout.createSequentialGroup()
                                .add(textNivelEstudios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabel11))
                            .add(panelVoluntarioDatosLayout.createSequentialGroup()
                                .add(textNacionalidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabel10))
                            .add(panelVoluntarioDatosLayout.createSequentialGroup()
                                .add(textNIF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabel9))
                            .add(panelVoluntarioDatosLayout.createSequentialGroup()
                                .add(textNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 172, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(68, 68, 68)
                                .add(jLabel1)))
                        .add(50, 50, 50)
                        .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(textApellidos)
                            .add(textFechaNacimiento)
                            .add(textProfesion)
                            .add(textCP)
                            .add(textTelefono, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 172, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(cbEstadoCivil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(textObservaciones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 521, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 0, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelVoluntarioDatosLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(btGuardar)
                .add(185, 185, 185)
                .add(btBorrar)
                .add(346, 346, 346))
        );

        panelVoluntarioDatosLayout.linkSize(new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        panelVoluntarioDatosLayout.linkSize(new java.awt.Component[] {textApellidos, textCP, textDomicilio, textFechaNacimiento, textLocalidad, textNIF, textNacionalidad, textNivelEstudios, textNombre, textProfesion, textTelefono}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        panelVoluntarioDatosLayout.setVerticalGroup(
            panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelVoluntarioDatosLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(navToMainFromDatosVoluntario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(senalaVoluntario1)
                    .add(navToVoluntariosFromDatosVoluntario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(senalaVoluntario2)
                    .add(jLabel22))
                .add(4, 4, 4)
                .add(separadorVoluntario1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 134, Short.MAX_VALUE)
                .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1)
                    .add(textApellidos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(12, 12, 12)
                .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textNIF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9)
                    .add(textFechaNacimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(9, 9, 9)
                .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textNacionalidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10)
                    .add(cbEstadoCivil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textNivelEstudios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel11)
                    .add(textProfesion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textDomicilio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel12)
                    .add(textCP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textLocalidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel13)
                    .add(textTelefono, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textObservaciones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(35, 35, 35)
                .add(panelVoluntarioDatosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btGuardar)
                    .add(btBorrar))
                .add(109, 109, 109))
        );

        panelVoluntarioDatosLayout.linkSize(new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8}, org.jdesktop.layout.GroupLayout.VERTICAL);

        getContentPane().add(panelVoluntarioDatos, "card5");

        PanelVoluntarioContabilidad.setBackground(new java.awt.Color(255, 255, 255));
        PanelVoluntarioContabilidad.setBounds(new java.awt.Rectangle(0, 0, 1000, 600));
        PanelVoluntarioContabilidad.setMaximumSize(new java.awt.Dimension(1000, 600));
        PanelVoluntarioContabilidad.setPreferredSize(new java.awt.Dimension(1000, 600));

        panelListaGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Ingreso", "Dni", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelListaGastos.setToolTipText("");
        jScrollPane1.setViewportView(panelListaGastos);

        panelListaIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Gasto", "Dni", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(panelListaIngresos);

        fieldFechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        fieldFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jLabel16.setText("Fecha inicio");

        jLabel17.setText("Fecha fin");

        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Listado de ingresos");

        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Listado de gastos");

        btnObtenerContabilidad.setText("Obtener Contabilidad");
        btnObtenerContabilidad.setActionCommand("obtenerContabilidad");

        jLabel20.setText("Balance");

        senalaVoluntario3.setForeground(new java.awt.Color(153, 153, 153));
        senalaVoluntario3.setText(">");

        navToMainFromContabilidad.setForeground(new java.awt.Color(0, 0, 255));
        navToMainFromContabilidad.setText("DIAKETAS");
        navToMainFromContabilidad.setActionCommand("navToMainFromContabilidad");
        navToMainFromContabilidad.setBorderPainted(false);

        navToVoluntariosFromContabilidad.setForeground(new java.awt.Color(0, 0, 255));
        navToVoluntariosFromContabilidad.setText("Voluntarios");
        navToVoluntariosFromContabilidad.setActionCommand("navToVoluntariosFromContabilidad");
        navToVoluntariosFromContabilidad.setBorderPainted(false);

        senalaVoluntario4.setForeground(new java.awt.Color(153, 153, 153));
        senalaVoluntario4.setText(">");

        jLabel23.setText("Contabilidad");

        org.jdesktop.layout.GroupLayout PanelVoluntarioContabilidadLayout = new org.jdesktop.layout.GroupLayout(PanelVoluntarioContabilidad);
        PanelVoluntarioContabilidad.setLayout(PanelVoluntarioContabilidadLayout);
        PanelVoluntarioContabilidadLayout.setHorizontalGroup(
            PanelVoluntarioContabilidadLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelVoluntarioContabilidadLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelVoluntarioContabilidadLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelVoluntarioContabilidadLayout.createSequentialGroup()
                        .add(navToMainFromContabilidad)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(senalaVoluntario3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(navToVoluntariosFromContabilidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(senalaVoluntario4)
                        .add(27, 27, 27)
                        .add(jLabel23)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(separadorVoluntario2))
                .addContainerGap())
            .add(PanelVoluntarioContabilidadLayout.createSequentialGroup()
                .add(14, 14, 14)
                .add(PanelVoluntarioContabilidadLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE)
                    .add(jScrollPane1)
                    .add(jLabel19)
                    .add(PanelVoluntarioContabilidadLayout.createSequentialGroup()
                        .add(jLabel16)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(fieldFechaInicio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jLabel17)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(fieldFechaFin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(btnObtenerContabilidad))
                    .add(PanelVoluntarioContabilidadLayout.createSequentialGroup()
                        .add(jLabel18)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel20)
                        .add(18, 18, 18)
                        .add(cuadroBalance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 178, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(0, 19, Short.MAX_VALUE))
        );

        PanelVoluntarioContabilidadLayout.linkSize(new java.awt.Component[] {fieldFechaFin, fieldFechaInicio}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        PanelVoluntarioContabilidadLayout.setVerticalGroup(
            PanelVoluntarioContabilidadLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelVoluntarioContabilidadLayout.createSequentialGroup()
                .add(9, 9, 9)
                .add(PanelVoluntarioContabilidadLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(navToMainFromContabilidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(senalaVoluntario3)
                    .add(navToVoluntariosFromContabilidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(senalaVoluntario4)
                    .add(jLabel23))
                .add(4, 4, 4)
                .add(separadorVoluntario2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(PanelVoluntarioContabilidadLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel16)
                    .add(fieldFechaInicio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel17)
                    .add(fieldFechaFin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnObtenerContabilidad))
                .add(6, 6, 6)
                .add(PanelVoluntarioContabilidadLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel18)
                    .add(jLabel20)
                    .add(cuadroBalance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 217, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel19)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 212, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 11, Short.MAX_VALUE))
        );

        PanelVoluntarioContabilidadLayout.linkSize(new java.awt.Component[] {jScrollPane1, jScrollPane2}, org.jdesktop.layout.GroupLayout.VERTICAL);

        getContentPane().add(PanelVoluntarioContabilidad, "card6");

        PanelVoluntarioBuscar.setBackground(new java.awt.Color(255, 255, 255));
        PanelVoluntarioBuscar.setBounds(new java.awt.Rectangle(0, 0, 1000, 600));
        PanelVoluntarioBuscar.setMaximumSize(new java.awt.Dimension(1000, 600));
        PanelVoluntarioBuscar.setPreferredSize(new java.awt.Dimension(1000, 600));

        senalaBeneficiario3.setForeground(new java.awt.Color(153, 153, 153));
        senalaBeneficiario3.setText(">");

        navToMainFromBuscarVoluntario.setForeground(new java.awt.Color(0, 0, 255));
        navToMainFromBuscarVoluntario.setText("DIAKETAS");
        navToMainFromBuscarVoluntario.setActionCommand("navToMainFromBuscarVoluntario");
        navToMainFromBuscarVoluntario.setBorderPainted(false);

        navToVoluntariosFromBuscarVoluntario.setForeground(new java.awt.Color(0, 0, 255));
        navToVoluntariosFromBuscarVoluntario.setText("Voluntarios");
        navToVoluntariosFromBuscarVoluntario.setActionCommand("navToVoluntariosFromBuscarVoluntario");
        navToVoluntariosFromBuscarVoluntario.setBorderPainted(false);

        senalaBeneficiario4.setForeground(new java.awt.Color(153, 153, 153));
        senalaBeneficiario4.setText(">");

        jLabel30.setText("Buscar Voluntario");

        jLabel31.setText("Introduzca el DNI para buscar al voluntario");

        btBuscarVoluntarioDNI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/buscar.png"))); // NOI18N
        btBuscarVoluntarioDNI.setActionCommand("buscarVoluntarioDNI");

        jLabel32.setText("Criterio de búsqueda");

        cbTipoBusquedaVoluntario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tablaBusquedaVoluntario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo Búsqueda", "DNI", "Nombre y Apellidos", "Fecha Nacimiento"
            }
        ));
        jScrollPane6.setViewportView(tablaBusquedaVoluntario);

        btVerVoluntarioBusqueda.setText("Ver Voluntario");
        btVerVoluntarioBusqueda.setActionCommand("verVoluntarioBusqueda");

        org.jdesktop.layout.GroupLayout PanelVoluntarioBuscarLayout = new org.jdesktop.layout.GroupLayout(PanelVoluntarioBuscar);
        PanelVoluntarioBuscar.setLayout(PanelVoluntarioBuscarLayout);
        PanelVoluntarioBuscarLayout.setHorizontalGroup(
            PanelVoluntarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelVoluntarioBuscarLayout.createSequentialGroup()
                .add(PanelVoluntarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelVoluntarioBuscarLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(PanelVoluntarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(separadorBeneficiario2)
                            .add(PanelVoluntarioBuscarLayout.createSequentialGroup()
                                .add(navToMainFromBuscarVoluntario)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(senalaBeneficiario3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(navToVoluntariosFromBuscarVoluntario)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(senalaBeneficiario4)
                                .add(26, 26, 26)
                                .add(jLabel30)
                                .add(0, 0, Short.MAX_VALUE))))
                    .add(PanelVoluntarioBuscarLayout.createSequentialGroup()
                        .add(26, 26, 26)
                        .add(PanelVoluntarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(PanelVoluntarioBuscarLayout.createSequentialGroup()
                                .add(jLabel32)
                                .add(18, 18, 18)
                                .add(cbTipoBusquedaVoluntario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 138, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(PanelVoluntarioBuscarLayout.createSequentialGroup()
                                .add(jLabel31)
                                .add(18, 18, 18)
                                .add(textBusquedaVoluntarioDNI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btBuscarVoluntarioDNI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jScrollPane6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 952, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, PanelVoluntarioBuscarLayout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(btVerVoluntarioBusqueda)
                .add(14, 14, 14))
        );
        PanelVoluntarioBuscarLayout.setVerticalGroup(
            PanelVoluntarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelVoluntarioBuscarLayout.createSequentialGroup()
                .add(11, 11, 11)
                .add(PanelVoluntarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(senalaBeneficiario3)
                    .add(navToMainFromBuscarVoluntario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(navToVoluntariosFromBuscarVoluntario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(senalaBeneficiario4)
                    .add(jLabel30))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(separadorBeneficiario2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(PanelVoluntarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelVoluntarioBuscarLayout.createSequentialGroup()
                        .add(21, 21, 21)
                        .add(jLabel31))
                    .add(PanelVoluntarioBuscarLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(PanelVoluntarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, btBuscarVoluntarioDNI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textBusquedaVoluntarioDNI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(22, 22, 22)
                .add(PanelVoluntarioBuscarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel32)
                    .add(cbTipoBusquedaVoluntario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(7, 7, 7)
                .add(jScrollPane6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 410, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 12, Short.MAX_VALUE)
                .add(btVerVoluntarioBusqueda)
                .addContainerGap())
        );

        getContentPane().add(PanelVoluntarioBuscar, "card8");

        PanelVoluntarioAyudas.setBackground(new java.awt.Color(255, 255, 255));
        PanelVoluntarioAyudas.setBounds(new java.awt.Rectangle(0, 0, 1000, 600));
        PanelVoluntarioAyudas.setMaximumSize(new java.awt.Dimension(1000, 600));
        PanelVoluntarioAyudas.setMinimumSize(new java.awt.Dimension(1000, 600));
        PanelVoluntarioAyudas.setPreferredSize(new java.awt.Dimension(1000, 600));

        senalaVoluntario5.setForeground(new java.awt.Color(153, 153, 153));
        senalaVoluntario5.setText(">");

        navToMainFromAyudas.setForeground(new java.awt.Color(0, 0, 255));
        navToMainFromAyudas.setText("DIAKETAS");
        navToMainFromAyudas.setActionCommand("navToMainFromAyudas");
        navToMainFromAyudas.setBorderPainted(false);

        navToVoluntariosFromAyudas.setForeground(new java.awt.Color(0, 0, 255));
        navToVoluntariosFromAyudas.setText("Voluntarios");
        navToVoluntariosFromAyudas.setActionCommand("navToVoluntariosFromAyudas");
        navToVoluntariosFromAyudas.setBorderPainted(false);

        senalaVoluntario6.setForeground(new java.awt.Color(153, 153, 153));
        senalaVoluntario6.setText(">");

        jLabel36.setText("Ayudas");

        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("Listado de ayudas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jLabel24.setText("Beneficiario");

        jTextField1.setText("jTextField1");

        btnBuscarBeneficiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/buscar.png"))); // NOI18N
        btnBuscarBeneficiario.setActionCommand("buscarBeneficiarioAyuda");

        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("Gestión tipos de ayudas");

        jLabel26.setText("Nombre de un tipo");

        jTextField2.setText("jTextField2");

        btnEliminarTipoAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/limpiar.png"))); // NOI18N
        btnEliminarTipoAyuda.setActionCommand("eliminarTipoAyuda");

        btnGuardarTipoAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/images/save_f2.png"))); // NOI18N
        btnGuardarTipoAyuda.setActionCommand("guardarTipoAyuda");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        org.jdesktop.layout.GroupLayout PanelVoluntarioAyudasLayout = new org.jdesktop.layout.GroupLayout(PanelVoluntarioAyudas);
        PanelVoluntarioAyudas.setLayout(PanelVoluntarioAyudasLayout);
        PanelVoluntarioAyudasLayout.setHorizontalGroup(
            PanelVoluntarioAyudasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelVoluntarioAyudasLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelVoluntarioAyudasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelVoluntarioAyudasLayout.createSequentialGroup()
                        .add(navToMainFromAyudas)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(senalaVoluntario5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(navToVoluntariosFromAyudas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(senalaVoluntario6)
                        .add(27, 27, 27)
                        .add(jLabel36)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(separadorVoluntario3)))
            .add(PanelVoluntarioAyudasLayout.createSequentialGroup()
                .add(19, 19, 19)
                .add(PanelVoluntarioAyudasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelVoluntarioAyudasLayout.createSequentialGroup()
                        .add(PanelVoluntarioAyudasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(PanelVoluntarioAyudasLayout.createSequentialGroup()
                                .add(jLabel24)
                                .add(18, 18, 18)
                                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jLabel14))
                        .add(18, 18, 18)
                        .add(btnBuscarBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 392, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(21, 21, 21)
                .add(PanelVoluntarioAyudasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelVoluntarioAyudasLayout.createSequentialGroup()
                        .add(PanelVoluntarioAyudasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(PanelVoluntarioAyudasLayout.createSequentialGroup()
                                .add(jLabel26)
                                .add(18, 18, 18)
                                .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 199, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jLabel25))
                        .add(32, 32, 32)
                        .add(btnGuardarTipoAyuda)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnEliminarTipoAyuda))
                    .add(PanelVoluntarioAyudasLayout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 469, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        PanelVoluntarioAyudasLayout.linkSize(new java.awt.Component[] {jScrollPane3, jScrollPane4}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        PanelVoluntarioAyudasLayout.setVerticalGroup(
            PanelVoluntarioAyudasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(PanelVoluntarioAyudasLayout.createSequentialGroup()
                .addContainerGap()
                .add(PanelVoluntarioAyudasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(navToMainFromAyudas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(senalaVoluntario5)
                    .add(navToVoluntariosFromAyudas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(senalaVoluntario6)
                    .add(jLabel36))
                .add(4, 4, 4)
                .add(separadorVoluntario3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(PanelVoluntarioAyudasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(PanelVoluntarioAyudasLayout.createSequentialGroup()
                        .add(PanelVoluntarioAyudasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel24))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel14))
                    .add(btnBuscarBeneficiario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(PanelVoluntarioAyudasLayout.createSequentialGroup()
                        .add(jLabel25)
                        .add(18, 18, 18)
                        .add(PanelVoluntarioAyudasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel26)
                            .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(btnGuardarTipoAyuda)
                    .add(btnEliminarTipoAyuda))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(PanelVoluntarioAyudasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .add(jScrollPane4))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(PanelVoluntarioAyudas, "card9");

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBeneficiarioBuscar;
    private javax.swing.JPanel PanelBeneficiarioDatos;
    private javax.swing.JPanel PanelBeneficiarioInicio;
    private javax.swing.JPanel PanelIdentificacion;
    private javax.swing.JPanel PanelInicio;
    private javax.swing.JPanel PanelVoluntarioAyudas;
    private javax.swing.JPanel PanelVoluntarioBuscar;
    private javax.swing.JPanel PanelVoluntarioContabilidad;
    private javax.swing.JPanel PanelVoluntarioInicio;
    private javax.swing.JButton btAyudas;
    private javax.swing.JButton btBeneficiario;
    private javax.swing.JButton btBolsaTrabajo;
    private javax.swing.JButton btBorrar;
    private javax.swing.JButton btBuscarBeneficiario;
    private javax.swing.JButton btBuscarBeneficiarioDNI;
    private javax.swing.JButton btBuscarVoluntario;
    private javax.swing.JButton btBuscarVoluntarioDNI;
    private javax.swing.JButton btConectarse;
    private javax.swing.JButton btContabilidad;
    private javax.swing.JButton btEliminarFamiliarBeneficiario;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btGuardarFamiliarBeneficiario;
    private javax.swing.JButton btNuevoBeneficiario;
    private javax.swing.JButton btNuevoVoluntario;
    private javax.swing.JButton btSocio;
    private javax.swing.JButton btVerBeneficiarioBusqueda;
    private javax.swing.JButton btVerVoluntarioBusqueda;
    private javax.swing.JButton btVoluntario;
    private javax.swing.JButton btnBuscarBeneficiario;
    private javax.swing.JButton btnEliminarTipoAyuda;
    private javax.swing.JButton btnGuardarTipoAyuda;
    private javax.swing.JButton btnObtenerContabilidad;
    private javax.swing.JComboBox cbEstadoCivil;
    private javax.swing.JComboBox cbEstadoCivilBeneficiario;
    private javax.swing.JComboBox cbNivelEstudiosBeneficiario;
    private javax.swing.JComboBox cbParentescoBeneficiario;
    private javax.swing.JComboBox cbTipoBusquedaBeneficiario;
    private javax.swing.JComboBox cbTipoBusquedaVoluntario;
    private javax.swing.JComboBox cbTipoViviendaBeneficiario;
    private javax.swing.JTextField cuadroBalance;
    private javax.swing.JFormattedTextField fieldFechaFin;
    private javax.swing.JFormattedTextField fieldFechaInicio;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labSBenef;
    private javax.swing.JLabel labSVolunt;
    private javax.swing.JLabel labelContrasena;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTable listDatosFamiliarBeneficiario;
    private javax.swing.JButton navToBeneficiariosFromBeneficiarioDatos;
    private javax.swing.JButton navToBeneficiariosFromBuscarBeneficiario;
    private javax.swing.JButton navToMainFromAyudas;
    private javax.swing.JButton navToMainFromBeneficiarioDatos;
    private javax.swing.JButton navToMainFromBeneficiarios;
    private javax.swing.JButton navToMainFromBuscarBeneficiario;
    private javax.swing.JButton navToMainFromBuscarVoluntario;
    private javax.swing.JButton navToMainFromContabilidad;
    private javax.swing.JButton navToMainFromDatosVoluntario;
    private javax.swing.JButton navToMainFromVoluntarios;
    private javax.swing.JButton navToVoluntariosFromAyudas;
    private javax.swing.JButton navToVoluntariosFromBuscarVoluntario;
    private javax.swing.JButton navToVoluntariosFromContabilidad;
    private javax.swing.JButton navToVoluntariosFromDatosVoluntario;
    private javax.swing.JTable panelListaGastos;
    private javax.swing.JTable panelListaIngresos;
    private javax.swing.JPanel panelVoluntarioDatos;
    private javax.swing.JLabel senalaBeneficiario;
    private javax.swing.JLabel senalaBeneficiario1;
    private javax.swing.JLabel senalaBeneficiario2;
    private javax.swing.JLabel senalaBeneficiario3;
    private javax.swing.JLabel senalaBeneficiario4;
    private javax.swing.JLabel senalaBeneficiario5;
    private javax.swing.JLabel senalaBeneficiario6;
    private javax.swing.JLabel senalaVoluntario;
    private javax.swing.JLabel senalaVoluntario1;
    private javax.swing.JLabel senalaVoluntario2;
    private javax.swing.JLabel senalaVoluntario3;
    private javax.swing.JLabel senalaVoluntario4;
    private javax.swing.JLabel senalaVoluntario5;
    private javax.swing.JLabel senalaVoluntario6;
    private javax.swing.JSeparator separadorBeneficiario;
    private javax.swing.JSeparator separadorBeneficiario1;
    private javax.swing.JSeparator separadorBeneficiario2;
    private javax.swing.JSeparator separadorBeneficiario3;
    private javax.swing.JSeparator separadorVoluntario;
    private javax.swing.JSeparator separadorVoluntario1;
    private javax.swing.JSeparator separadorVoluntario2;
    private javax.swing.JSeparator separadorVoluntario3;
    private javax.swing.JTable tablaBusquedaBeneficiario;
    private javax.swing.JTable tablaBusquedaVoluntario;
    private javax.swing.JTextField textApellidos;
    private javax.swing.JTextField textApellidosBeneficiario;
    private javax.swing.JTextField textBusquedaBeneficiarioDNI;
    private javax.swing.JTextField textBusquedaVoluntarioDNI;
    private javax.swing.JTextField textCP;
    private javax.swing.JTextField textCPBeneficiario;
    private javax.swing.JTextField textConceptoBeneficiario;
    private javax.swing.JTextField textDomicilio;
    private javax.swing.JTextField textDomicilioBeneficiario;
    private javax.swing.JTextField textEspecificarTipoVivienda;
    private javax.swing.JTextField textEstadoCivilBeneficiario;
    private javax.swing.JFormattedTextField textFechaNacimiento;
    private javax.swing.JFormattedTextField textFechaNacimientoBeneficiario;
    private javax.swing.JPasswordField textFieldContrasena;
    private javax.swing.JTextField textFieldIdUsuario;
    private javax.swing.JTextField textImporteBeneficiario;
    private javax.swing.JTextField textLocalidad;
    private javax.swing.JTextField textLocalidadBeneficiario;
    private javax.swing.JTextField textNIF;
    private javax.swing.JTextField textNIFBeneficiario;
    private javax.swing.JTextField textNIFFamiliarBeneficiario;
    private javax.swing.JTextField textNacionalidad;
    private javax.swing.JTextField textNacionalidadBenficiario;
    private javax.swing.JTextField textNivelEstudios;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNombreBeneficiario;
    private javax.swing.JTextField textObservaciones;
    private javax.swing.JTextField textObservacionesBeneficiario;
    private javax.swing.JTextField textObservacionesFamiliarBeneficiario;
    private javax.swing.JTextField textObservacionesIntervencionBeneficiario;
    private javax.swing.JTextField textPrecioViviendaBeneficiario;
    private javax.swing.JTextField textProfesion;
    private javax.swing.JTextField textProfesionBeneficiario;
    private javax.swing.JTextField textProvinciaNacimientoBeneficiario;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JTextField textTelefonoBeneficiario;
    // End of variables declaration//GEN-END:variables
	
	
    /**
	 *  Muestra la vista de identificación
	 */
	public void mostrarVistaIdentificacion(){
		PanelIdentificacion.setVisible(true);
		//Todos los demas paneles se ponen a false
		PanelInicio.setVisible(false);
		 PanelVoluntarioAyudas.setVisible(false);
		PanelBeneficiarioInicio.setVisible(false);
		PanelVoluntarioInicio.setVisible(false);
                panelVoluntarioDatos.setVisible(false);
                PanelVoluntarioContabilidad.setVisible(false);
                PanelBeneficiarioBuscar.setVisible(false);
                PanelVoluntarioBuscar.setVisible(false);
                PanelBeneficiarioDatos.setVisible(false);
                
	}
	
	/**
	 * Muestra la vista principal
	 */
	public void mostrarVistaPrincipal(){
		
		PanelInicio.setVisible(true);
		//Todos los demas paneles se ponen a false
		PanelIdentificacion.setVisible(false);
		 PanelVoluntarioAyudas.setVisible(false);
		PanelBeneficiarioInicio.setVisible(false);
		PanelVoluntarioInicio.setVisible(false);
                panelVoluntarioDatos.setVisible(false);
		PanelVoluntarioContabilidad.setVisible(false);
                PanelBeneficiarioBuscar.setVisible(false);
                PanelVoluntarioBuscar.setVisible(false);
                PanelBeneficiarioDatos.setVisible(false);
	}
	
	/**
	 * Muestra la vista de los beneficiarios
	 */
	public void mostrarVistaBeneficiarios(){
		
		PanelBeneficiarioInicio.setVisible(true);
		//Todos los demas paneles se ponen a false
		PanelInicio.setVisible(false);
		PanelIdentificacion.setVisible(false);
		 PanelVoluntarioAyudas.setVisible(false);
		PanelVoluntarioInicio.setVisible(false);
                panelVoluntarioDatos.setVisible(false);
		PanelVoluntarioContabilidad.setVisible(false);
                PanelBeneficiarioBuscar.setVisible(false);
                PanelVoluntarioBuscar.setVisible(false);
                PanelBeneficiarioDatos.setVisible(false);
	}
	
	/**
	 *  Muestra la vista de datos de un beneficiario
	 */
	public void mostrarVistaDatosBeneficiario(){
		
                PanelBeneficiarioDatos.setVisible(true);
		//Todos los demas paneles se ponen a false
		PanelInicio.setVisible(false);
		PanelIdentificacion.setVisible(false);
		 PanelVoluntarioAyudas.setVisible(false);
		PanelVoluntarioInicio.setVisible(false);
                panelVoluntarioDatos.setVisible(false);
		PanelVoluntarioContabilidad.setVisible(false);
                PanelBeneficiarioBuscar.setVisible(false);
                PanelVoluntarioBuscar.setVisible(false);
                PanelBeneficiarioInicio.setVisible(false);
	}
	
	/**
	 * Muestra la vista de buscar beneficiarios
	 */
	public void mostrarVistaBuscarBeneficiario(){
		
		PanelBeneficiarioBuscar.setVisible(true);
		//Todos los demas paneles se ponen a false
		PanelInicio.setVisible(false);
		PanelIdentificacion.setVisible(false);
		 PanelVoluntarioAyudas.setVisible(false);
		PanelVoluntarioInicio.setVisible(false);
                panelVoluntarioDatos.setVisible(false);
		PanelVoluntarioContabilidad.setVisible(false);
                PanelBeneficiarioInicio.setVisible(false);
                PanelVoluntarioBuscar.setVisible(false);
                PanelBeneficiarioDatos.setVisible(false);
	}
	
	/**
	 * Muestra la vista de los voluntarios
	 */
	public void mostrarVistaVoluntarios(){
		
		PanelVoluntarioInicio.setVisible(true);
		//Todos los demas paneles se ponen a false
		PanelInicio.setVisible(false);
		PanelIdentificacion.setVisible(false);
		 PanelVoluntarioAyudas.setVisible(false);
		PanelBeneficiarioInicio.setVisible(false);
                panelVoluntarioDatos.setVisible(false);
		PanelVoluntarioContabilidad.setVisible(false);
                PanelBeneficiarioBuscar.setVisible(false);
                PanelVoluntarioBuscar.setVisible(false);
                PanelBeneficiarioDatos.setVisible(false);
	}
	
	/**
	 * Muestra la vista de datos un voluntario
	 */
	public void mostarVistaDatosVoluntario(){
		
		panelVoluntarioDatos.setVisible(true);
		//Todos los demas paneles se ponen a false
		PanelInicio.setVisible(false);
		PanelIdentificacion.setVisible(false);
		PanelVoluntarioAyudas.setVisible(false);
		PanelVoluntarioInicio.setVisible(false);
                PanelVoluntarioContabilidad.setVisible(false);
                PanelBeneficiarioBuscar.setVisible(false);
                PanelVoluntarioBuscar.setVisible(false);
                PanelBeneficiarioDatos.setVisible(false);
                PanelBeneficiarioInicio.setVisible(false);

	}
	
	/**
	 * Muestra la vista buscar voluntarios
	 */
	public void mostrarVistaBuscarVoluntario(){
		
		PanelVoluntarioBuscar.setVisible(true);
		//Todos los demas paneles se ponen a false
		PanelInicio.setVisible(false);
		PanelIdentificacion.setVisible(false);
		 PanelVoluntarioAyudas.setVisible(false);
		PanelVoluntarioInicio.setVisible(false);
                panelVoluntarioDatos.setVisible(false);
		PanelVoluntarioContabilidad.setVisible(false);
                PanelBeneficiarioBuscar.setVisible(false);
                PanelBeneficiarioInicio.setVisible(false);
                PanelBeneficiarioDatos.setVisible(false);
	}
	
	/**
	 * Muestra la vista de contabilidad
	 */
	public void mostrarVistaContabilidad(){
		
		PanelVoluntarioContabilidad.setVisible(true);
		//Todos los demas paneles se ponen a false
                panelVoluntarioDatos.setVisible(false); 
                PanelBeneficiarioInicio.setVisible(false);
		PanelInicio.setVisible(false);
		PanelIdentificacion.setVisible(false);
		PanelVoluntarioAyudas.setVisible(false);
		PanelVoluntarioInicio.setVisible(false);
                PanelBeneficiarioBuscar.setVisible(false);
                PanelVoluntarioBuscar.setVisible(false);
                PanelBeneficiarioDatos.setVisible(false);
	}
	
	/**
	 * Muestra la vista de ayudas
	 */
	public void mostrarVistaAyuda(){
		
		PanelVoluntarioAyudas.setVisible(true);
		//Todos los demas paneles se ponen a false
		PanelInicio.setVisible(false);
		PanelIdentificacion.setVisible(false);
		PanelVoluntarioBuscar.setVisible(false);
		PanelVoluntarioInicio.setVisible(false);
                panelVoluntarioDatos.setVisible(false);
                PanelVoluntarioContabilidad.setVisible(false);
                PanelBeneficiarioInicio.setVisible(false);
                PanelBeneficiarioBuscar.setVisible(false);
                PanelBeneficiarioDatos.setVisible(false);
	}
        
        /**
	 *  Muestra la vista de datos de Voluntarios
	 */
	public void mostrarVistaDatosVoluntarios(){
		
                panelVoluntarioDatos.setVisible(true); 
		//Todos los demas paneles se ponen a false
                PanelBeneficiarioInicio.setVisible(false);
		PanelInicio.setVisible(false);
		PanelIdentificacion.setVisible(false);
                PanelVoluntarioAyudas.setVisible(false);
		PanelVoluntarioInicio.setVisible(false);
                PanelVoluntarioContabilidad.setVisible(false);
                PanelBeneficiarioBuscar.setVisible(false);
                PanelVoluntarioBuscar.setVisible(false);
                PanelBeneficiarioDatos.setVisible(false);
	}  
        
}
