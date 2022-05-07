package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Control.Controller;
import Control.Controller;
import Utils.DisabledPanel;
import Utils.TextPrompt;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MyView {

	private JFrame frmBusquedas;
	private JTextField tf_cantidadRegistros;
	private JTextField tf_claveBuscar;
	private JTextField tf_claveAnadir;
	private JTextField tf_valorAnadir;

	private Controller controller;

	public void setVisible(boolean prmValue) {
		this.frmBusquedas.setVisible(prmValue);
	}

	/**
	 * Create the application.
	 */
	public MyView() {
		initialize();
		this.frmBusquedas.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.controller = new Controller();

		frmBusquedas = new JFrame();
		frmBusquedas.getContentPane().setBackground(new Color(216, 217, 215));
		frmBusquedas.setTitle("Busquedas");
		frmBusquedas.setIconImage(
				Toolkit.getDefaultToolkit().getImage(MyView.class.getResource("/Resources/database.png")));
		frmBusquedas.setFont(new Font("Calibri", Font.PLAIN, 18));
		frmBusquedas.setBackground(Color.BLACK);
		frmBusquedas.setBounds(100, 100, 800, 650);
		frmBusquedas.setLocationRelativeTo(null);
		frmBusquedas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBusquedas.getContentPane().setLayout(null);

		JLabel lbl_Archivos = new JLabel("Archivo");
		lbl_Archivos.setForeground(Color.BLACK);
		lbl_Archivos.setFont(new Font("Calibri", Font.PLAIN, 30));
		lbl_Archivos.setBounds(20, 20, 130, 50);
		frmBusquedas.getContentPane().add(lbl_Archivos);

		JLabel lbl_crearNuevoArchivo = new JLabel("Crear un nuevo archivo");
		lbl_crearNuevoArchivo.setForeground(Color.BLACK);
		lbl_crearNuevoArchivo.setFont(new Font("Calibri", Font.PLAIN, 20));
		lbl_crearNuevoArchivo.setBounds(60, 100, 200, 40);
		frmBusquedas.getContentPane().add(lbl_crearNuevoArchivo);

		JLabel lbl_cantidadRegistros = new JLabel("Cantidad de registros");
		lbl_cantidadRegistros.setForeground(Color.BLACK);
		lbl_cantidadRegistros.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbl_cantidadRegistros.setBounds(70, 140, 160, 20);
		frmBusquedas.getContentPane().add(lbl_cantidadRegistros);

		tf_cantidadRegistros = new JTextField();
		TextPrompt tp1 = new TextPrompt("Ingrese la cantidad de registros", tf_cantidadRegistros);
		tp1.setForeground(new Color(153, 153, 153));
		tp1.setFont(new Font("Calibri", Font.PLAIN, 14));
		tf_cantidadRegistros.setFont(new Font("Calibri", Font.PLAIN, 14));
		tf_cantidadRegistros.setForeground(new Color(0, 0, 0));
		tf_cantidadRegistros.setBounds(70, 160, 220, 30);
		frmBusquedas.getContentPane().add(tf_cantidadRegistros);
		tf_cantidadRegistros.setColumns(10);

		JButton btn_crear = new JButton("Crear");

		btn_crear.setFocusPainted(false);
		btn_crear.setBackground(new Color(209, 21, 40));
		btn_crear.setForeground(Color.WHITE);
		btn_crear.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_crear.setBounds(120, 200, 120, 30);
		frmBusquedas.getContentPane().add(btn_crear);
		btn_crear.setBorderPainted(false);

		JSeparator separator_ver = new JSeparator();
		separator_ver.setOrientation(SwingConstants.VERTICAL);
		separator_ver.setBounds(350, 10, 5, 290);
		frmBusquedas.getContentPane().add(separator_ver);

		JPanel rightside_panel = new JPanel();
		// rightside_panel.setEnabled(true);
		rightside_panel.setBounds(355, 0, 424, 304);
		frmBusquedas.getContentPane().add(rightside_panel);
		rightside_panel.setLayout(null);
		rightside_panel.setBackground(new Color(216, 217, 215));

		JLabel lbl_registros = new JLabel("Registros");
		lbl_registros.setForeground(Color.BLACK);
		lbl_registros.setBounds(10, 11, 130, 50);
		rightside_panel.add(lbl_registros);
		lbl_registros.setFont(new Font("Calibri", Font.PLAIN, 30));

		JLabel lbl_anadirRegistro = new JLabel("Anadir nuevo registro");
		lbl_anadirRegistro.setForeground(Color.BLACK);
		lbl_anadirRegistro.setFont(new Font("Calibri", Font.PLAIN, 20));
		lbl_anadirRegistro.setBounds(60, 80, 200, 40);
		rightside_panel.add(lbl_anadirRegistro);

		JLabel lbl_claveanadir = new JLabel("Clave");
		lbl_claveanadir.setForeground(Color.BLACK);
		lbl_claveanadir.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbl_claveanadir.setBounds(70, 120, 160, 20);
		rightside_panel.add(lbl_claveanadir);

		tf_claveAnadir = new JTextField();
		TextPrompt tp3 = new TextPrompt("Ingrese clave del registro", tf_claveAnadir);
		tp3.setForeground(new Color(153, 153, 153));
		tp3.setFont(new Font("Calibri", Font.PLAIN, 14));
		tf_claveAnadir.setForeground(new Color(0, 0, 0));
		tf_claveAnadir.setFont(new Font("Calibri", Font.PLAIN, 14));
		tf_claveAnadir.setColumns(10);
		tf_claveAnadir.setBounds(70, 140, 220, 30);
		rightside_panel.add(tf_claveAnadir);

		JLabel lbl_valor = new JLabel("Valor");
		lbl_valor.setForeground(Color.BLACK);
		lbl_valor.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbl_valor.setBounds(70, 180, 160, 20);
		rightside_panel.add(lbl_valor);

		tf_valorAnadir = new JTextField();
		TextPrompt tp4 = new TextPrompt("Ingrese valor del registro", tf_valorAnadir);
		tp4.setForeground(new Color(153, 153, 153));
		tp4.setFont(new Font("Calibri", Font.PLAIN, 14));
		tf_valorAnadir.setForeground(new Color(0, 0, 0));
		tf_valorAnadir.setFont(new Font("Calibri", Font.PLAIN, 14));
		tf_valorAnadir.setColumns(10);
		tf_valorAnadir.setBounds(70, 200, 220, 30);
		rightside_panel.add(tf_valorAnadir);

		JButton btn_ingresar = new JButton("Ingresar");

		btn_ingresar.setFocusPainted(false);
		btn_ingresar.setBackground(new Color(209, 21, 40));
		btn_ingresar.setForeground(new Color(255, 255, 255));
		btn_ingresar.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_ingresar.setBounds(120, 240, 120, 30);
		rightside_panel.add(btn_ingresar);
		btn_ingresar.setBorderPainted(false);

		JPanel bottom_panel = new JPanel();
		bottom_panel.setBackground(new Color(39, 30, 66));
		// bottom_panel.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		bottom_panel.setBounds(0, 310, 784, 301);
		frmBusquedas.getContentPane().add(bottom_panel);
		bottom_panel.setLayout(null);

		JLabel lbl_busqueda = new JLabel("Busqueda");
		lbl_busqueda.setForeground(new Color(255, 255, 255));
		lbl_busqueda.setFont(new Font("Calibri", Font.PLAIN, 30));
		lbl_busqueda.setBounds(20, 20, 130, 50);
		bottom_panel.add(lbl_busqueda);

		JLabel lbl_buscarRegistro = new JLabel("Buscar Registro");
		lbl_buscarRegistro.setForeground(new Color(255, 255, 255));
		lbl_buscarRegistro.setFont(new Font("Calibri", Font.PLAIN, 20));
		lbl_buscarRegistro.setBounds(60, 70, 200, 40);
		bottom_panel.add(lbl_buscarRegistro);

		JLabel lbl_claveBuscar = new JLabel("Clave");
		lbl_claveBuscar.setForeground(new Color(255, 255, 255));
		lbl_claveBuscar.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbl_claveBuscar.setBounds(70, 100, 160, 20);
		bottom_panel.add(lbl_claveBuscar);

		tf_claveBuscar = new JTextField();
		TextPrompt tp2 = new TextPrompt("Ingrese clave a buscar", tf_claveBuscar);
		tp2.setForeground(new Color(153, 153, 153));
		tp2.setFont(new Font("Calibri", Font.PLAIN, 14));
		tf_claveBuscar.setFont(new Font("Calibri", Font.PLAIN, 14));
		tf_claveBuscar.setForeground(new Color(0, 0, 0));
		tf_claveBuscar.setBounds(70, 120, 220, 30);
		bottom_panel.add(tf_claveBuscar);
		tf_claveBuscar.setColumns(10);

		JButton btn_runBusquedaIndexada = new JButton("Busqueda indexada");

		btn_runBusquedaIndexada.setFocusPainted(false);
		btn_runBusquedaIndexada.setBackground(new Color(209, 21, 40));
		btn_runBusquedaIndexada.setForeground(new Color(255, 255, 255));
		btn_runBusquedaIndexada.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_runBusquedaIndexada.setBounds(84, 170, 200, 30);
		bottom_panel.add(btn_runBusquedaIndexada);
		btn_runBusquedaIndexada.setBorderPainted(false);

		JButton btn_runBusquedaNormal = new JButton("Busqueda no indexada");

		btn_runBusquedaNormal.setFocusPainted(false);
		btn_runBusquedaNormal.setBackground(new Color(209, 21, 40));
		btn_runBusquedaNormal.setForeground(new Color(255, 255, 255));
		btn_runBusquedaNormal.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_runBusquedaNormal.setBounds(84, 220, 200, 30);
		bottom_panel.add(btn_runBusquedaNormal);
		btn_runBusquedaNormal.setBorderPainted(false);

		JLabel lbl_resultadoBusqueda = new JLabel("Resultado de busqueda");
		lbl_resultadoBusqueda.setForeground(new Color(255, 255, 255));
		lbl_resultadoBusqueda.setFont(new Font("Calibri", Font.PLAIN, 20));
		lbl_resultadoBusqueda.setBounds(350, 20, 200, 40);
		bottom_panel.add(lbl_resultadoBusqueda);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(360, 50, 400, 200);
		bottom_panel.add(scrollPane);


		JTable table_resultadoBusqueda = new JTable(
				new DefaultTableModel(new Object[][]{}, 
						new String[]{ "Clave", "Valor", "Tiempo (nano)", "Busqueda" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scrollPane.setViewportView(table_resultadoBusqueda);
		table_resultadoBusqueda.getTableHeader().setBackground(Color.WHITE);
		table_resultadoBusqueda.getTableHeader().setReorderingAllowed(false);
		table_resultadoBusqueda.getColumn("Clave").setResizable(false);
		table_resultadoBusqueda.getColumn("Valor").setResizable(false);
		table_resultadoBusqueda.getColumn("Tiempo (nano)").setPreferredWidth(150);
		table_resultadoBusqueda.getColumn("Tiempo (nano)").setResizable(false);

		if (!controller.isFileCreated()) {
			DisabledPanel.setPanelEnabled(rightside_panel, false);
			DisabledPanel.setPanelEnabled(bottom_panel, false);
		}

		btn_crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.parseInt(tf_cantidadRegistros.getText());

					if (controller.isValidNumRecords(a)) {
						controller.createFile(a);
						JOptionPane.showMessageDialog(null, "Archivo creado exitosamente con " + a + " registros");
						DefaultTableModel model = (DefaultTableModel) table_resultadoBusqueda.getModel();
						while (model.getRowCount()>0) {
							model.removeRow(0);
						}
						DisabledPanel.setPanelEnabled(rightside_panel, true);
						DisabledPanel.setPanelEnabled(bottom_panel, true);
					} else {
						JOptionPane.showMessageDialog(null, "Numero de registros no valido", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Entrada no valida", "Error", JOptionPane.ERROR_MESSAGE);
				} finally {
					tf_cantidadRegistros.setText("");
				}
			}
		});

		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a = Integer.parseInt(tf_claveAnadir.getText());
					int b = Integer.parseInt(tf_valorAnadir.getText());
					if (controller.isInRange(a) && controller.isInRange(b)) {
						boolean flag = controller.addRecord(a, b);
						if (flag) {
							JOptionPane.showMessageDialog(null, "Dato agregado exitosamente");
						} else {
							JOptionPane.showMessageDialog(null, "Entrada ya existente", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Dato fuera de rango", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Entrada no valida", "Error", JOptionPane.ERROR_MESSAGE);
				} finally {
					tf_claveAnadir.setText("");
					tf_valorAnadir.setText("");
				}

			}
		});

		btn_runBusquedaIndexada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (controller.isFileCreated()) {
						int a = Integer.parseInt(tf_claveBuscar.getText());
						Object[] varFila = controller.indexSearch(a);
						if (varFila != null) {
							varFila[3] = "Indexada";
							JOptionPane.showMessageDialog(null,
									"Registro con clave: " + varFila[0] + " valor: " + varFila[1] + " encontrado en: "
											+ varFila[2] + " nanosegundos",
									"Registro Encontrado", JOptionPane.PLAIN_MESSAGE);
							DefaultTableModel model = (DefaultTableModel) table_resultadoBusqueda.getModel();
							model.addRow(varFila);
						} else {
							JOptionPane.showMessageDialog(null, "Registro con clave: " + a + " no encontrado",
									"Registro no Encontrado", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "No se ha generado el archivo", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Entrada no valida", "Error", JOptionPane.ERROR_MESSAGE);
				} finally {
					tf_claveBuscar.setText("");
				}
			}
		});

		btn_runBusquedaNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (controller.isFileCreated()) {
						int a = Integer.parseInt(tf_claveBuscar.getText());
						Object[] varFila = controller.secuencialSearch(a);
						if (varFila != null) {
							varFila[3] = "Secuencial";
							JOptionPane.showMessageDialog(null,
									"Registro con clave: " + varFila[0] + " y valor: " + varFila[1] + " encontrado en: "
											+ varFila[2] + " nanosegundos",
									"Registro Encontrado", JOptionPane.PLAIN_MESSAGE);
							DefaultTableModel model = (DefaultTableModel) table_resultadoBusqueda.getModel();
							model.addRow(varFila);
						} else {
							JOptionPane.showMessageDialog(null, "Registro con clave: " + a + " no encontrado",
									"Registro no Encontrado", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "No se ha generado el archivo", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Entrada no valida", "Error", JOptionPane.ERROR_MESSAGE);
				} finally {
					tf_claveBuscar.setText("");
				}

			}
		});
	}

}
