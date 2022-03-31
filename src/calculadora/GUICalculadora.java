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
	private JButton bReinicializar;
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
	private JButton bBorrar;
	private JButton bIgual;
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
		pantalla.setEditable(false);

		bReinicializar = new JButton("C");
		bReinicializar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla.setText("");
				operaciones = new StringBuffer();
				// Habilitamos los botones

				b00.setEnabled(true);
				bBorrar.setEnabled(true);
				bSumar.setEnabled(true);
				bSiete.setEnabled(true);
				bCuatro.setEnabled(true);
				bUno.setEnabled(true);
				bCero.setEnabled(true);
				bOcho.setEnabled(true);
				bNueve.setEnabled(true);
				bRestar.setEnabled(true);
				bCinco.setEnabled(true);
				bSeis.setEnabled(true);
				bMultiplicar.setEnabled(true);
				bDos.setEnabled(true);
				bTres.setEnabled(true);
				bDividir.setEnabled(true);
				bComa.setEnabled(true);
				bPrimo.setEnabled(true);
				bFactorial.setEnabled(true);
				bIgual.setEnabled(true);
			}
		});
		bReinicializar.setBounds(90, 100, 55, 55);
		frame.getContentPane().add(bReinicializar);

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

		bIgual = new JButton("=");
		bIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operaciones = new StringBuffer(pantalla.getText());
				
				if (existeOperacionAlFinal() && operaciones.charAt(operaciones.length() - 1) != operadores[4] && operaciones.charAt(operaciones.length() - 1) != operadores[5]) {
					sintaxisInvalida("Error. No se puede calcular la operacion con un operando de dos terminos sin un segundo termino.");
				} else {
					pantalla.setText(procesaOperaciones());
					operaciones = new StringBuffer(pantalla.getText());
				}
			}

		});
		bIgual.setFont(new Font("Dialog", Font.BOLD, 14));
		bIgual.setBounds(12, 435, 289, 40);
		frame.getContentPane().add(bIgual);
		
		bBorrar = new JButton("B");
		bBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuffer nuevo = new StringBuffer(pantalla.getText());
				if(nuevo.length() > 0) {
					nuevo.deleteCharAt(nuevo.length() - 1);
					operaciones = nuevo;
					pantalla.setText(operaciones.toString());
				}
			}
		});
		bBorrar.setBounds(12, 100, 55, 55);
		frame.getContentPane().add(bBorrar);

	}

	private void sintaxisInvalida(String elProblema) {
		pantalla.setText(elProblema + ". Pulsar C para reiniciar calculadora");
		b00.setEnabled(false);
		bBorrar.setEnabled(false);
		bSumar.setEnabled(false);
		bSiete.setEnabled(false);
		bCuatro.setEnabled(false);
		bUno.setEnabled(false);
		bCero.setEnabled(false);
		bOcho.setEnabled(false);
		bNueve.setEnabled(false);
		bRestar.setEnabled(false);
		bCinco.setEnabled(false);
		bSeis.setEnabled(false);
		bMultiplicar.setEnabled(false);
		bDos.setEnabled(false);
		bTres.setEnabled(false);
		bDividir.setEnabled(false);
		bComa.setEnabled(false);
		bPrimo.setEnabled(false);
		bFactorial.setEnabled(false);
		bIgual.setEnabled(false);

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
			sintaxisInvalida("No se puede realizar la operacion " + operador);
		} else if (existeOperacionAlFinal()) {
			operaciones.deleteCharAt(operaciones.length() - 1);
			pantalla.setText(operaciones.toString());
			if (existeOperacionAlFinal()) {
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

	private String procesaOperaciones() {
		String resultado = "";
		//TODO
		return resultado;
	}
}
