package maquinaExpendedoraJR;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MaquinaExpendedora2 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel bebidas;
	private JLabel precio;
	private JLabel pago;

	private JRadioButton agua;
	private JRadioButton chocolate;
	private JRadioButton cafe;

	private JTextField precioArea = null;

	private JLabel euros;
	private JLabel centimos;
	private JLabel vueltas;

	private JComboBox<Integer> eurosBox;
	private JComboBox<Object> centimosBox;
	private JTextField vueltasArea;

	private JButton extraer;

	MaquinaExpendedora2 (){
		
	}

	void progMaquina() {
		setLayout(null);

		bebidas = new JLabel("BEBIDAS");
		bebidas.setBounds(30, 5, 120, 40);
		add(bebidas);

		agua = new JRadioButton("Agua");
		agua.setBounds(30, 50, 120, 40);
		add(agua);
		agua.addActionListener(this);

		chocolate = new JRadioButton("Chocolate");
		chocolate.setBounds(30, 100, 120, 40);
		add(chocolate);
		chocolate.addActionListener(this);

		cafe = new JRadioButton("Café");
		cafe.setBounds(30, 150, 120, 40);
		add(cafe);
		cafe.addActionListener(this);

		precio = new JLabel("PRECIO");
		precio.setBounds(170, 5, 120, 40);
		add(precio);

		precioArea = new JTextField();
		precioArea.setBounds(170, 50, 50, 125);
		add(precioArea);
		precioArea.setHorizontalAlignment(JTextField.CENTER);

		pago = new JLabel("PAGO");
		pago.setBounds(290, 5, 120, 40);
		add(pago);

		euros = new JLabel("Euros");
		euros.setBounds(275, 50, 120, 40);
		add(euros);

		eurosBox = new JComboBox();
		eurosBox.setBounds(350, 62, 100, 20);

		for (int x = 0; x <= 5; x++) {
			eurosBox.addItem(x);
		}
		add(eurosBox);

		centimos = new JLabel("Centimos");
		centimos.setBounds(275, 85, 120, 40);
		add(centimos);

		centimosBox = new JComboBox();
		centimosBox.setBounds(350, 98, 100, 20);
		for (double x = 0.00D; x <= 1.00D; x = x + 0.05D) {
			DecimalFormat df = new DecimalFormat("0.00");
			centimosBox.addItem(df.format(x).replace(",", "."));
		}

		add(centimosBox);

		vueltas = new JLabel("VUELTAS");
		vueltas.setBounds(275, 130, 120, 40);
		add(vueltas);

		vueltasArea = new JTextField();
		vueltasArea.setBounds(350, 135, 130, 40);
		add(vueltasArea);
		vueltasArea.setHorizontalAlignment(JTextField.CENTER);

		extraer = new JButton("Extraer");
		extraer.setBounds(170, 200, 250, 40);
		add(extraer);
		extraer.addActionListener(this);

		setTitle("                                                   ELIGE TU BEBIDA");
	}

	public void actionPerformed(ActionEvent e) {
		Font fuente = new Font("Calibri", 1, 15);
		precioArea.setFont(fuente);
		if (e.getSource() == agua) {
			;
			precioArea.setText("0.40");
			chocolate.setSelected(false);
			cafe.setSelected(false);
		} else {
			if (e.getSource() == chocolate) {
				precioArea.setText("0.55");
				agua.setSelected(false);
				cafe.setSelected(false);
			} else {
				if (e.getSource() == cafe) {
					precioArea.setText("0.70");
					agua.setSelected(false);
					chocolate.setSelected(false);
				}
			}
		}
		if (e.getSource() == extraer) {
			String rdo;

			if (!precioArea.getText().equals("0.40") && !precioArea.getText().equals("0.55")
					&& !precioArea.getText().equals("0.70")) {
				vueltasArea.setFont(fuente);
				vueltasArea.setText("TECLEA BEBIDA");
			} else {
				BigDecimal n1 = new BigDecimal(eurosBox.getSelectedItem().toString());
				BigDecimal n2 = new BigDecimal(centimosBox.getSelectedItem().toString());
				n1 = n1.add(n2);
				BigDecimal n3 = new BigDecimal((String) precioArea.getText());
				n1 = n1.subtract(n3);
				rdo = String.valueOf(n1);
				if (n1.signum() >= 0) {
					vueltasArea.setFont(fuente);
					Color darkGreen = new Color(0, 153, 0);
					vueltasArea.setForeground(darkGreen);
					vueltasArea.setText(rdo + "€");
					setTitle("                                                 EXTRAYENDO BEBIDA");
				} else {
					vueltasArea.setFont(fuente);
					vueltasArea.setForeground(Color.RED);
					vueltasArea.setText(rdo.replace("-", "FALTAN ") + "€");
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaquinaExpendedora2 interfaz = new MaquinaExpendedora2();
		interfaz.progMaquina();
		interfaz.setBounds(300, 150, 500, 300);
		interfaz.setVisible(true);
		interfaz.setResizable(false);
		interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



}
