package dominio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class VentanaEjercicio3 extends JFrame {

	private static final long serialVersionUID = 3L;
	private JPanel contentPane;
	private JTextField txtHoras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEjercicio3 frame = new VentanaEjercicio3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEjercicio3() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 462);
		setTitle("Ejercicio 3");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaOperativo = new JLabel("Elige un sistema operativo");
		lblSistemaOperativo.setBounds(53, 38, 199, 20);
		contentPane.add(lblSistemaOperativo);
		
		JRadioButton rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setBounds(247, 34, 97, 29);
		rdbtnWindows.setActionCommand(rdbtnWindows.getText());
		contentPane.add(rdbtnWindows);
		
		JRadioButton rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setBounds(351, 34, 59, 29);
		rdbtnMac.setActionCommand(rdbtnMac.getText());
		contentPane.add(rdbtnMac);
		
		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setBounds(417, 34, 71, 29);
		rdbtnLinux.setActionCommand(rdbtnLinux.getText());
		contentPane.add(rdbtnLinux);
		
		ButtonGroup bgSistemaOperativo = new ButtonGroup();
		bgSistemaOperativo.add(rdbtnWindows);
		bgSistemaOperativo.add(rdbtnMac);
		bgSistemaOperativo.add(rdbtnLinux);
		
		JLabel lblEligeUnaEspecialidad = new JLabel("Elige una especialidad");
		lblEligeUnaEspecialidad.setBounds(53, 186, 161, 20);
		contentPane.add(lblEligeUnaEspecialidad);
		
		JCheckBox chckbxProgramacin = new JCheckBox("Programaci\u00F3n");
		chckbxProgramacin.setBounds(260, 138, 139, 29);
		contentPane.add(chckbxProgramacin);
		
		JCheckBox chckbxAdministracin = new JCheckBox("Administraci\u00F3n");
		chckbxAdministracin.setBounds(260, 182, 139, 29);
		contentPane.add(chckbxAdministracin);
		
		JCheckBox chckbxDiseoGrfico = new JCheckBox("Dise\u00F1o Gr\u00E1fico");
		chckbxDiseoGrfico.setBounds(260, 229, 139, 29);
		contentPane.add(chckbxDiseoGrfico);
		
		List<JCheckBox> listaCheckBoxes = new ArrayList<>();
		listaCheckBoxes.add(chckbxProgramacin);
		listaCheckBoxes.add(chckbxAdministracin);
		listaCheckBoxes.add(chckbxDiseoGrfico);
		
		JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas en el computador:");
		lblCantidadDeHoras.setBounds(53, 297, 272, 20);
		contentPane.add(lblCantidadDeHoras);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(342, 294, 146, 26);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);
		txtHoras.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char character = e.getKeyChar();
				if (!Character.isDigit(character) && (character != (char)KeyEvent.VK_BACK_SPACE)) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Las horas en el computador deben ser un número");
				}
				
			}
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(427, 344, 115, 29);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(rdbtnWindows.isSelected() || rdbtnMac.isSelected() || rdbtnLinux.isSelected())) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un sistema operativo");
				} else if (!(chckbxProgramacin.isSelected() || chckbxAdministracin.isSelected() || chckbxDiseoGrfico.isSelected())) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar por lo menos una especialidad");
				} else if (txtHoras.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un valor de horas");
				} else {
					String output = bgSistemaOperativo.getSelection().getActionCommand() + " - ";
					for (JCheckBox jCheckBox : listaCheckBoxes) {
						if (jCheckBox.isSelected()) {
							output += jCheckBox.getText() + " - ";
						}
					}
					output += txtHoras.getText() + "Hs";
					JOptionPane.showMessageDialog(null, output);
				}
				
				
			}
		});
		
	}

	public void cambiarVisible(boolean estado) {
		setVisible(estado);
	}
}
