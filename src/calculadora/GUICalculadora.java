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
import java.util.LinkedList;
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
	private LinkedList<String> operaciones;
	private String[] operadores;
	private int posicionUltimoOperador = 0;

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
		operaciones = new LinkedList<>();
		laCalculadora = new Calculadora();
		operadores = new String[6];
		operadores[0] = "+";
		operadores[1] = "-";
		operadores[2] = "*";
		operadores[3] = "/";
		operadores[4] = "!";
		operadores[5] = "P";
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
					pantalla.setText(eliminaUltimoElementoDePantalla());
				
			}
		});
		bBackSpace.setBounds(12, 100, 55, 55);
		frame.getContentPane().add(bBackSpace);

		bBorrar = new JButton("C");
		bBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operaciones.clear();
				posicionUltimoOperador = 0;
				pantalla.setText("");
				
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
				
					if ((operaciones.isEmpty() && (pantalla.getText() == null || pantalla.getText().equals("")))) {
						cometidoErrorSintaxis();
						
					} 	else if (!operaciones.isEmpty() && calculaElementoNuevo(pantalla.getText()).equals("") && elUltimoElementoEsOperacion()) {
						operaciones.pollLast();
						operaciones.add(operadores[0]);
						pantalla.setText(operacionesACadena());
						System.out.println("ha entrado por el elseif");
					}
					else {
						String elementoNuevo = calculaElementoNuevo(pantalla.getText());
						operaciones.add(elementoNuevo);
						operaciones.add(operadores[0]);
						posicionUltimoOperador = operaciones.size();
						pantalla.setText(operacionesACadena());
					}
				
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
				

					if ((operaciones.isEmpty() && (pantalla.getText() == null || pantalla.getText().equals("")))
							|| (!operaciones.isEmpty() && elUltimoElementoEsOperacion())) {
						pantalla.setText("-");
					}

					else {
						operaciones.add(pantalla.getText());
						operaciones.add(operadores[1]);
						pantalla.setText("");
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
				
					if ((operaciones.isEmpty() && (pantalla.getText() == null || pantalla.getText().equals("")))
							|| (!operaciones.isEmpty() && operaciones.peekLast().equals(operadores[2]) && (pantalla.getText() == null || pantalla.getText().equals("")))) {
						cometidoErrorSintaxis();
					} else {
						operaciones.add(pantalla.getText());
						operaciones.add(operadores[2]);
						pantalla.setText("");
					}
				

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
				
					if ((operaciones.isEmpty() && (pantalla.getText() == null || pantalla.getText().equals("")))
							|| (!operaciones.isEmpty() && operaciones.peekLast().equals(operadores[3]) && (pantalla.getText() == null || pantalla.getText().equals("")))) {
						cometidoErrorSintaxis();
					} else {
						operaciones.add(pantalla.getText());
						operaciones.add(operadores[3]);
						pantalla.setText("");
					}
				
			}
		});
		bDividir.setBounds(246, 301, 55, 55);
		frame.getContentPane().add(bDividir);

		bComa = new JButton(".");
		bComa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(pantalla.getText().length() == 0) {
						pantalla.setText(pantalla.getText() + "0");
					}
					pantalla.setText(pantalla.getText() + bComa.getText());
				
			}
		});
		bComa.setBounds(90, 368, 55, 55);
		frame.getContentPane().add(bComa);

		bPrimo = new JButton("P?");
		bPrimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if ((operaciones.isEmpty() && (pantalla.getText() == null || pantalla.getText().equals("")))
							|| (!operaciones.isEmpty() && operaciones.peekLast().equals(operadores[5]))) {
						cometidoErrorSintaxis();
					} else {
						operaciones.add(pantalla.getText());
						operaciones.add(operadores[5]);
					
				}
			}
		});
		bPrimo.setBounds(168, 368, 55, 55);
		frame.getContentPane().add(bPrimo);

		bFactorial = new JButton("!");
		bFactorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if ((operaciones.isEmpty() && (pantalla.getText() == null || pantalla.getText().equals("")))
							|| (!operaciones.isEmpty() && operaciones.peekLast().equals(operadores[4]))) {
						cometidoErrorSintaxis();
					} else {
						operaciones.add(pantalla.getText());
						operaciones.add(operadores[4]);
					}
				}
			
		});
		bFactorial.setBounds(246, 368, 55, 55);
		frame.getContentPane().add(bFactorial);

		JButton bIgual = new JButton("=");
		bIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//					if(operaciones.size() < 3 && (operaciones.peekLast().equals(operadores[4]) || operaciones.peekLast().equals(operadores[5]))) {
//						pantalla.setText(procesa(false));
//					} else if(operaciones.size() > 2 && !elUltimoElementoEsOperacion()) {
//						pantalla.setText(procesa(true));
//					} else {
//						cometidoErrorSintaxis();
//					}
				pantalla.setText(operaciones.toString());
				
			}
		});
		bIgual.setFont(new Font("Dialog", Font.BOLD, 14));
		bIgual.setBounds(12, 435, 289, 40);
		frame.getContentPane().add(bIgual);
	}

	private void cometidoErrorSintaxis() {
		pantalla.setText(operaciones.toString());
		;
	}
	private boolean elUltimoElementoEsOperacion() {
		boolean resultado = false;
		int contador = 0;
		String ultimo = operaciones.peekLast();
		while (contador < operadores.length) {
			if (ultimo.equals(operadores[contador])) {
				resultado = true;
			}
			contador++;
		}
		return resultado;
	}
	private String eliminaUltimoElementoDePantalla () {
		StringBuffer nuevaPantalla = new StringBuffer(pantalla.getText());
		nuevaPantalla.deleteCharAt(nuevaPantalla.length() - 1);
		return (nuevaPantalla.toString());
	}
	private String operacionesACadena() {
		String resultado = "";
		int contador = 0;
		int tamanyo = operaciones.size();
		while (contador < tamanyo) {
			resultado += operaciones.get(contador++);
		}
		return resultado;
	}
	
	private String calculaElementoNuevo(String cadenaNueva) {
		String resultado = "";
		int contador = posicionUltimoOperador;
		int size = cadenaNueva.length();
		while (contador < size) {
			resultado += cadenaNueva.charAt(contador++);
		}
		System.out.println(cadenaNueva + " EL RESULTADO: " + resultado + "y la posicion ultima es " + posicionUltimoOperador);
		return resultado;
	}

	private String procesa(boolean esDosVariables) {
		String resultado = "";
		if(esDosVariables) {
			resultado = "DOS VARIABLES";
		} else {
			resultado = "UNA VARIABLE";
		}
		return resultado;
	}
}
