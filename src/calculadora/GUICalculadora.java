/**
 * @author Florin Babusca Voicu
 * @version 1
 */
package calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GUICalculadora {

	private JFrame frame;
	private JTextField pantalla;
	private JButton bBorrar;
	private JButton b00;
	private JButton bSumar;
	private JButton bSiete;
	private JButton bCuatro;
	private JButton bUno;
	private JButton bCero;
	private JButton bOcho;
	private JButton bNueve;
	private JButton bRestar;
	private JButton bCinco;
	private JButton bSeis;
	private JButton bMultiplicar;
	private JButton bDos;
	private JButton bTres;
	private JButton bDividir;
	private JButton bComa;
	private JButton bPrimo;
	private JButton bFactorial;
	private Calculadora laCalculadora;
	private StringBuffer operaciones;
	private char[] operadores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICalculadora window = new GUICalculadora();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUICalculadora() {
		initialize();
		laCalculadora = new Calculadora();
		operadores = new char[6];
		operadores[0] = '+';
		operadores[1] = '-';
		operadores[2] = '*';
		operadores[3] = '/';
		operadores[4] = '!';
		operadores[5] = 'P';
		operaciones = new StringBuffer();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 329, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		pantalla = new JTextField();
		pantalla.setBounds(12, 12, 291, 59);
		frame.getContentPane().add(pantalla);
		pantalla.setColumns(10);

		JButton bBackSpace = new JButton("B");
		bBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		bBackSpace.setBounds(12, 100, 55, 55);
		frame.getContentPane().add(bBackSpace);

		bBorrar = new JButton("C");
		bBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText("");
				operaciones = new StringBuffer();
			}
		});
		bBorrar.setBounds(90, 100, 55, 55);
		frame.getContentPane().add(bBorrar);

		b00 = new JButton("00");
		b00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantalla.setText(pantalla.getText() + b00.getText());

			}
		});
		b00.setBounds(168, 100, 55, 55);
		frame.getContentPane().add(b00);

		bSumar = new JButton("+");
		bSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anyadeOperacion(operadores[0]);
			}
		});
		bSumar.setBounds(246, 100, 55, 55);
		frame.getContentPane().add(bSumar);

		bSiete = new JButton("7");
		bSiete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantalla.setText(pantalla.getText() + bSiete.getText());

			}
		});
		bSiete.setBounds(12, 167, 55, 55);
		frame.getContentPane().add(bSiete);

		bCuatro = new JButton("4");
		bCuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantalla.setText(pantalla.getText() + bCuatro.getText());

			}
		});
		bCuatro.setBounds(12, 234, 55, 55);
		frame.getContentPane().add(bCuatro);

		bUno = new JButton("1");
		bUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantalla.setText(pantalla.getText() + bUno.getText());

			}
		});
		bUno.setBounds(12, 301, 55, 55);
		frame.getContentPane().add(bUno);

		bCero = new JButton("0");
		bCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantalla.setText(pantalla.getText() + bCero.getText());

			}
		});
		bCero.setBounds(12, 368, 55, 55);
		frame.getContentPane().add(bCero);

		bOcho = new JButton("8");
		bOcho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantalla.setText(pantalla.getText() + bOcho.getText());

			}
		});
		bOcho.setBounds(90, 167, 55, 55);
		frame.getContentPane().add(bOcho);

		bNueve = new JButton("9");
		bNueve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantalla.setText(pantalla.getText() + bNueve.getText());

			}
		});
		bNueve.setBounds(168, 167, 55, 55);
		frame.getContentPane().add(bNueve);

		bRestar = new JButton("-");
		bRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pant = pantalla.getText();
				if (pant.charAt(pant.length() - 1) != operadores[1]) {
					pant += operadores[1];
					operaciones = new StringBuffer(pant);
					pantalla.setText(pant);
				}
			}

		});
		bRestar.setBounds(246, 167, 55, 55);
		frame.getContentPane().add(bRestar);

		bCinco = new JButton("5");
		bCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantalla.setText(pantalla.getText() + bCinco.getText());

			}
		});
		bCinco.setBounds(90, 234, 55, 55);
		frame.getContentPane().add(bCinco);

		bSeis = new JButton("6");
		bSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantalla.setText(pantalla.getText() + bSeis.getText());

			}
		});
		bSeis.setBounds(168, 234, 55, 55);
		frame.getContentPane().add(bSeis);

		bMultiplicar = new JButton("*");
		bMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anyadeOperacion(operadores[2]);
			}
		});
		bMultiplicar.setBounds(246, 234, 55, 55);
		frame.getContentPane().add(bMultiplicar);

		bDos = new JButton("2");
		bDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantalla.setText(pantalla.getText() + bDos.getText());

			}
		});
		bDos.setBounds(90, 301, 55, 55);
		frame.getContentPane().add(bDos);

		bTres = new JButton("3");
		bTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantalla.setText(pantalla.getText() + bTres.getText());

			}
		});
		bTres.setBounds(168, 301, 55, 55);
		frame.getContentPane().add(bTres);

		bDividir = new JButton("/");
		bDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anyadeOperacion(operadores[3]);
			}
		});
		bDividir.setBounds(246, 301, 55, 55);
		frame.getContentPane().add(bDividir);

		bComa = new JButton(".");
		bComa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pant = pantalla.getText();
				if (pant.length() == 0) {
					pant += "0";
				}
				pant += bComa.getText();
				pantalla.setText(pant);
				operaciones = new StringBuffer(pant);

			}
		});
		bComa.setBounds(90, 368, 55, 55);
		frame.getContentPane().add(bComa);

		bPrimo = new JButton("P?");
		bPrimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anyadeOperacion(operadores[5]);
			}
		});
		bPrimo.setBounds(168, 368, 55, 55);
		frame.getContentPane().add(bPrimo);

		bFactorial = new JButton("!");
		bFactorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anyadeOperacion(operadores[4]);
			}

		});
		bFactorial.setBounds(246, 368, 55, 55);
		frame.getContentPane().add(bFactorial);

		JButton bIgual = new JButton("=");
		bIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText(operaciones.toString());
			}
		});
		bIgual.setFont(new Font("Dialog", Font.BOLD, 14));
		bIgual.setBounds(12, 435, 289, 40);
		frame.getContentPane().add(bIgual);
	}

	private void sintaxisInvalida() {
		// TODO hacer los botones inaccesibles
	}

	private boolean existeOperacionAlFinal() {
		boolean resultado = false;
		String textoPantalla = pantalla.getText();
		int tamanyo = textoPantalla.length() - 1;
		if (tamanyo >= 0) {
			for (int i = 0; i < operadores.length; i++) {
				if (textoPantalla.charAt(tamanyo) == operadores[i]) {
					resultado = true;
				}
			}
		}
		return resultado;
	}

	private void anyadeOperacion(char operador) {
		String pant = pantalla.getText();
		if (pant.length() == 0) {
			sintaxisInvalida();
			pantalla.setText("No puedes empezar una operacion con un operador");
		} else if (existeOperacionAlFinal()) {
			operaciones.deleteCharAt(operaciones.length() - 1);
			pantalla.setText(operaciones.toString());
			if(existeOperacionAlFinal()) {
				operaciones.deleteCharAt(operaciones.length() - 1);
			}
			operaciones.append(operador);
			pantalla.setText(operaciones.toString());
			
		} else {
			pant += operador;
			operaciones = new StringBuffer(pant);
			pantalla.setText(pant);
		}
	}
}
