package Visual;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.ls.LSProgressEvent;

import Logica.Persona;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class juanitoPagina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int i = 0;
	private Persona juanito = new Persona(100);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					juanitoPagina frame = new juanitoPagina();
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
	public juanitoPagina() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 100, 800, 800);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//no se cambia
		JLabel lblNewLabel = new JLabel("Juanito");
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 44));
		lblNewLabel.setBounds(338, 11, 150, 56);
		contentPane.add(lblNewLabel);
		//----------------
		// BARRITA QUE INDICA LA SACIEDAD DE JUANITO
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(102, 87, 616, 25);
		progressBar.setMaximum(juanito.getCapacidad());
		progressBar.setMinimum(0);
		contentPane.add(progressBar);
		
		// BOTON DE COMER
		JButton comer = new JButton("COMER");
		comer.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
		
		comer.setBounds(161, 151, 207, 64);
		contentPane.add(comer);
		// BOTON DE DE SI ESTA LLENO O NO 
		JLabel llenedad = new JLabel("¿ESTA LLENO?");
		
		llenedad.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
		llenedad.setBounds(161, 298, 207, 64);
		contentPane.add(llenedad);
		// BOTON QUE SI SE PRESIONA SU ESTOMAGO CRECE
		JButton crecer = new JButton("CRECER");
		crecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juanito.crecer();
				progressBar.setMaximum(juanito.getCapacidad());
				
			}
		});
		crecer.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
		crecer.setBounds(161, 466, 207, 64);
		contentPane.add(crecer);
		// BOTON DE DIGERIR SI SE PRESIONA SU ESTOMAGO VUELVE A 0 
		JButton digerir = new JButton("DIGERIR");
		digerir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juanito.digerir();
				progressBar.setValue(0);
			}
		});
		digerir.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
		digerir.setBounds(161, 623, 207, 64);
		contentPane.add(digerir);
		// CARTEL DE AFIRMACION SI ESTA LLENO O NO Y SU METODO
		JLabel afirmacion = new JLabel("SI");
		afirmacion.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 41));
		afirmacion.setVisible(false);
		afirmacion.setBounds(591, 300, 73, 47);
		contentPane.add(afirmacion);
		
		

		// CARTEL DE ESTOMAGO
		JLabel estomago = new JLabel("ESTOMAGO");
		estomago.setFont(new Font("Segoe UI Historic", Font.PLAIN, 17));
		estomago.setBounds(102, 57, 112, 25);
		contentPane.add(estomago);
		
		// SPINNER Y SU METODO
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Segoe UI Historic", Font.BOLD, 23));
		spinner.setBounds(580, 164, 84, 50);
		contentPane.add(spinner);
		
		comer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = (int) spinner.getValue();
				juanito.comer(i);
				progressBar.setValue(juanito.getCantidadComida());
				if(juanito.tienePanzaLlena()) {
					afirmacion.setText("SI");
				}else {
					afirmacion.setText("NO");
				}
				afirmacion.setVisible(true);
			}
		
		});
		
	}
}
