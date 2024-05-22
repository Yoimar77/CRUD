package app;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.sql.Connection; // Importa la clase java.sql.Connection
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.ImageIcon;
public class FormularioPersona extends JFrame implements ActionListener {
	public static final String URL = "jdbc:mysql://localhost:3306/colegio";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "YoimaR1096671492";
	private JPanel contentPane;
	private JTextField textFieldClave;
	private JTextField textFieldNombre;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreo;
	private JTextField textFieldFecha;
	private JTextField textFieldId;
	private JButton btnGuarda, btnModifica, btnElimina, btnLimpiar, btnBuscar;
	JComboBox comboBoxGenero;

	PreparedStatement ps;
	ResultSet res;
	private JLabel lblNewLabel_2;

	public FormularioPersona() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setTitle("FORMULARIO");
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("INGRESA TUS DATOS.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(193, 0, 148, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("nombre: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(40, 59, 62, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("clave: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(40, 28, 62, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("dirección: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(40, 99, 62, 14);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("telefono:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(40, 130, 62, 14);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("correo electrónico:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_4.setBounds(38, 183, 114, 14);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("fecha de nacimiento:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5.setBounds(40, 238, 142, 14);
		contentPane.add(lblNewLabel_1_5);

		comboBoxGenero = new JComboBox();
		comboBoxGenero.setModel(new DefaultComboBoxModel(new String[] {"seleccione.", "masculino", "femenino", "caballo", "no se bien"}));
		comboBoxGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxGenero.setToolTipText("");
		comboBoxGenero.setBounds(193, 266, 163, 22);
		comboBoxGenero.setBackground(Color.white);
		contentPane.add(comboBoxGenero);

		textFieldClave = new JTextField();
		textFieldClave.setBounds(112, 25, 119, 20);
		contentPane.add(textFieldClave);
		textFieldClave.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(112, 56, 244, 20);
		contentPane.add(textFieldNombre);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(112, 96, 244, 20);
		contentPane.add(textFieldDireccion);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(112, 127, 244, 20);
		contentPane.add(textFieldTelefono);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(155, 180, 201, 20);
		contentPane.add(textFieldCorreo);

		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(165, 235, 194, 20);
		contentPane.add(textFieldFecha);
		textFieldFecha.setColumns(10);

		JLabel lblNewLabel_1_5_1 = new JLabel("genero");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5_1.setBounds(52, 274, 142, 14);
		contentPane.add(lblNewLabel_1_5_1);

		JLabel lblNewLabel_1_5_1_1 = new JLabel("si no tiene correo electrónico omita este campo.");
		lblNewLabel_1_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5_1_1.setBounds(143, 158, 285, 14);
		contentPane.add(lblNewLabel_1_5_1_1);

		JLabel lblNewLabel_1_5_1_2 = new JLabel("formato AÑO-MES-DÏA EJEMPLO 1999-07-04");
		lblNewLabel_1_5_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5_1_2.setBounds(165, 213, 263, 14);
		contentPane.add(lblNewLabel_1_5_1_2);

		btnGuarda = new JButton("GUARDA");
		btnGuarda.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuarda.setBounds(40, 333, 89, 23);
		btnGuarda.addActionListener(this);
		btnGuarda.setBackground(Color.white);
		contentPane.add(btnGuarda);

		btnModifica = new JButton("MODIFICA");
		btnModifica.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModifica.setBounds(143, 333, 89, 23);
		btnModifica.addActionListener(this);
		btnModifica.setBackground(Color.white);
		contentPane.add(btnModifica);

		btnElimina = new JButton("ELIMINA");
		btnElimina.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnElimina.setBounds(252, 333, 89, 23);
		btnElimina.addActionListener(this);
		btnElimina.setBackground(Color.white);
		contentPane.add(btnElimina);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiar.setBounds(366, 333, 89, 23);
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBackground(Color.white);
		contentPane.add(btnLimpiar);

		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(332, 24, 89, 23);
		btnBuscar.addActionListener(this);
		btnBuscar.setBackground(Color.white);
		contentPane.add(btnBuscar);

		textFieldId = new JTextField();
		textFieldId.setEnabled(false);
		textFieldId.setColumns(10);
		textFieldId.setBounds(260, 25, 62, 20);
		contentPane.add(textFieldId);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(FormularioPersona.class.getResource("/img/fondoBlockNotas.jpg")));
		lblNewLabel_2.setBounds(0, 0, 529, 367);
		contentPane.add(lblNewLabel_2);
		textFieldId.setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Connection conexion = null;
		if (btnGuarda == e.getSource()) {
		    try {
		        conexion = obtenerConexion();

		        // Verificar si la clave ya existe en la base de datos
		        if (claveExistente(textFieldClave.getText(), conexion)) {
		            JOptionPane.showMessageDialog(null, "la clave que ingresaste debes cambiarla. Por favor, elija otra clave.");
		        } else {
		            // Si la clave no existe, insertar la nueva persona
		            ps = conexion.prepareStatement("INSERT INTO persona (clave, nombre, direccion, telefono, correo, fechaNacimiento, genero) VALUES (?,?,?,?,?,?,?)");
		            ps.setString(1, textFieldClave.getText());
		            ps.setString(2, textFieldNombre.getText());
		            ps.setString(3, textFieldDireccion.getText());
		            ps.setString(4, textFieldTelefono.getText());
		            ps.setString(5, textFieldCorreo.getText());
		            ps.setDate(6, Date.valueOf(textFieldFecha.getText()));
		            ps.setString(7, comboBoxGenero.getSelectedItem().toString());
		            
		            int res = ps.executeUpdate();
		            if (res > 0) {
		                JOptionPane.showMessageDialog(null, "Los datos se han guardado exitosamente");
		                limpiarCajasDeTexto();
		            } else {
		                JOptionPane.showMessageDialog(null, "Error al guardar.");
		                limpiarCajasDeTexto();
		            }
		        }

		        conexion.close();
		    } catch (SQLException e1) {
		        e1.printStackTrace();
		        JOptionPane.showMessageDialog(null,
		                "Ha ocurrido algún error con la conexión, error: " + e1);
		    }
		}
		
		if(btnBuscar==e.getSource()) {
			try {
				conexion = obtenerConexion();
				ps=conexion.prepareStatement("SELECT*FROM persona WHERE clave=?");//prepara la consulta
				ps.setString(1, textFieldClave.getText());
				res=ps.executeQuery();
				if(res.next()){//si trae una consulta...
					textFieldId.setText(res.getString("id"));
					textFieldNombre.setText(res.getString("nombre"));
					textFieldDireccion.setText(res.getString("direccion"));
					textFieldTelefono.setText(res.getString("telefono"));
					textFieldCorreo.setText(res.getString("correo"));
					textFieldFecha.setText(res.getString("fechaNacimiento"));
					comboBoxGenero.setSelectedItem(res.getString("genero"));

				}else {
					JOptionPane.showMessageDialog(null, " No existe ningina persona registrada con esa clave");
					
				}
				
			}catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, " error de conexión: " + e1); // Muestra un mensaje si ocurre alguna excepción(error)
																										
			}
		}
		if(btnModifica==e.getSource()) {
			try {
				conexion = obtenerConexion();
				ps = conexion.prepareStatement("UPDATE persona SET clave=?, nombre=?, direccion=?, telefono=?, correo=?, fechaNacimiento=?, genero=? WHERE id=?");//prepara la consulta
						ps.setString(1, textFieldClave.getText());
						ps.setString(2, textFieldNombre.getText());
						ps.setString(3, textFieldDireccion.getText());
						ps.setString(4, textFieldTelefono.getText());
						ps.setString(5, textFieldCorreo.getText());
						ps.setDate(6, Date.valueOf(textFieldFecha.getText()));
						ps.setString(7, comboBoxGenero.getSelectedItem().toString());
						ps.setString(8, textFieldId.getText());
						
						int res= ps.executeUpdate();
						if(res>0) {
							JOptionPane.showMessageDialog(null,"Los datos se han modificado");
							limpiarCajasDeTexto();
						}else {
							JOptionPane.showMessageDialog(null,"error al modificar.");
							limpiarCajasDeTexto();
						}
						conexion.close();																											

			} catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "ha ocurrido algún error con la conexión, error: " + e1); // Muestra un mensaje si ocurre alguna excepción(error)
																										
			}
		}
		if(btnElimina==e.getSource()) {
			try {
				conexion = obtenerConexion();
				ps = conexion.prepareStatement("DELETE FROM persona WHERE id=?");//prepara la consulta
						ps.setInt(1, Integer.parseInt(textFieldId.getText()));
						
						int res= ps.executeUpdate();
						if(res>0) {
							JOptionPane.showMessageDialog(null,"persona eliminada");
							limpiarCajasDeTexto();
						}else {
							JOptionPane.showMessageDialog(null,"error al eliminar persona.");
							limpiarCajasDeTexto();
						}
						conexion.close();																											

			} catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "ha ocurrido algún error con la conexión, error: " + e1); // Muestra un mensaje si ocurre alguna excepción(error)
																										
			}
		}
		if(btnLimpiar==e.getSource()) {
			limpiarCajasDeTexto();
		}
	}

	// Método para obtener una conexión a la base de datos
	public static Connection obtenerConexion() {
		Connection c = null; // Declara una variable Connection para almacenar la conexión
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Carga el controlador JDBC de MySQL
			c = DriverManager.getConnection(URL, USERNAME, PASSWORD); // Establece la conexión utilizando la URL, el nombre de usuario y la contraseña  proporcionados
																
			JOptionPane.showMessageDialog(null, "La conexión con la base de datos ha sido exitosa."); // Muestra un mensaje de éxito si la conexion es exitosa.
																										
		} catch (Exception e) { // Captura cualquier excepción que pueda ocurrir durante el proceso de conexión
			System.out.print(e.getMessage()); // Imprime el mensaje de error en la consola
		}
		return c; // Devuelve la conexión establecida (o null si no se pudo establecer)
		
	}
	// esta funcion lo único que hace es limpiar las cajas de texto para cuando se haga alguna acción que requiera que todas las cajas de texto se eliminen
	public void limpiarCajasDeTexto() {
		textFieldClave.setText(null);
		textFieldNombre.setText(null);
		textFieldDireccion.setText(null);
		textFieldTelefono.setText(null);
		textFieldCorreo.setText(null);
		textFieldFecha.setText(null);
		comboBoxGenero.setSelectedIndex(0);
	}
	   private boolean claveExistente(String clave, Connection conexion) throws SQLException {
	        PreparedStatement ps = conexion.prepareStatement("SELECT * FROM persona WHERE clave = ?");
	        ps.setString(1, clave);
	        ResultSet res = ps.executeQuery();
	        return res.next(); // Devuelve true si encuentra algún resultado, lo que indica que la clave ya existe
	    }
}
