package Calculator;

import java.awt.*;
import java.awt.event.*;
import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Calculator extends JFrame implements MouseListener {

	String value = null, labelV = null;
	double op1 = 0, op2 = 0;
	int check = 0;
	boolean parenthesis = false, isEqual = false;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bDot, div, mul, sub, add, equals, plusMinus, openP, closeP, arrow,
			mod, CE, C, backspace, bA, bB, bC, bD, bE, bF, hex, dec, oct, bin, h0, d0, o0, b0_, dots, circle, qword, MS,
			M, Lsh, Rsh, Or, Xor, Not, And, Byte, dword, word;
	JPanel digits, title, field, top, middle, middle1, middle2, hdob, zeroes, labelP, PANEL;
	JLabel Programmer, field0, label;
	Color lightBlue = new Color(0, 145, 255, 255);
	Color lighterGray = new Color(215, 215, 215, 255);
	Color grayish = new Color(205, 205, 205, 255);
	GridBagConstraints c = new GridBagConstraints();
	GridBagConstraints d = new GridBagConstraints();
	GridBagConstraints f = new GridBagConstraints();

	public Calculator() {
		dword = new JButton("DWORD");
		word = new JButton("WORD");
		Byte = new JButton("BYTE");
		dword.setBorderPainted(false);
		dword.setForeground(lightBlue);
		dword.setFont(new Font("Arial", Font.BOLD, 14));
		word.setBorderPainted(false);
		word.setForeground(lightBlue);
		word.setFont(new Font("Arial", Font.BOLD, 14));
		Byte.setBorderPainted(false);
		Byte.setForeground(lightBlue);
		Byte.setFont(new Font("Arial", Font.BOLD, 14));

		top = new JPanel();
		middle = new JPanel();
		PANEL = new JPanel();

		title = new JPanel();
		title.setLayout(new FlowLayout(FlowLayout.LEFT));

		field = new JPanel();
		field.setLayout(new FlowLayout(FlowLayout.RIGHT));

		labelP = new JPanel();
		labelP.setLayout(new FlowLayout(FlowLayout.RIGHT));

		hdob = new JPanel();
		hdob.setLayout(new GridLayout(4, 1));

		zeroes = new JPanel();
		zeroes.setLayout(new GridLayout(4, 1));

		middle1 = new JPanel();
		middle1.setLayout(new GridBagLayout());
		middle1.setBorder(BorderFactory.createLineBorder(lighterGray));

		digits = new JPanel();
		digits.setBackground(lighterGray);
		digits.setLayout(new GridBagLayout());

		Programmer = new JLabel("PROGRAMMER");
		Programmer.setFont(new Font("Arial", Font.BOLD, 16));
		title.add(Programmer);

		field0 = new JLabel("0");
		field0.setFont(new Font("Arial", Font.BOLD, 28));
		field.add(field0);

		label = new JLabel("0");
		label.setForeground(Color.gray);
		labelP.add(label);

		hex = new JButton("HEX");
		dec = new JButton("DEC");
		oct = new JButton("OCT");
		bin = new JButton("BIN");
		hex.setFont(new Font("Arial", Font.BOLD, 14));
		dec.setFont(new Font("Arial", Font.BOLD, 14));
		oct.setFont(new Font("Arial", Font.BOLD, 14));
		bin.setFont(new Font("Arial", Font.BOLD, 14));
		hex.setForeground(Color.DARK_GRAY);
		dec.setForeground(lightBlue);
		oct.setForeground(Color.DARK_GRAY);
		bin.setForeground(Color.DARK_GRAY);
		hex.setBorderPainted(false);
		dec.setBorderPainted(false);
		oct.setBorderPainted(false);
		bin.setBorderPainted(false);
		hdob.add(hex);
		hdob.add(dec);
		hdob.add(oct);
		hdob.add(bin);

		d0 = new JButton("0");
		h0 = new JButton("0");
		o0 = new JButton("0");
		b0_ = new JButton("0");
		h0.setForeground(Color.gray);
		d0.setForeground(lightBlue);
		o0.setForeground(Color.gray);
		b0_.setForeground(Color.gray);
		h0.setFont(new Font("Arial", Font.BOLD, 14));
		d0.setFont(new Font("Arial", Font.BOLD, 14));
		o0.setFont(new Font("Arial", Font.BOLD, 14));
		b0_.setFont(new Font("Arial", Font.BOLD, 14));
		h0.setBorderPainted(false);
		d0.setBorderPainted(false);
		o0.setBorderPainted(false);
		b0_.setBorderPainted(false);
		h0.setHorizontalAlignment(SwingConstants.LEFT);
		d0.setHorizontalAlignment(SwingConstants.LEFT);
		o0.setHorizontalAlignment(SwingConstants.LEFT);
		b0_.setHorizontalAlignment(SwingConstants.LEFT);
		zeroes.add(h0);
		zeroes.add(d0);
		zeroes.add(o0);
		zeroes.add(b0_);

		top.setLayout(new GridLayout(3, 1));
		top.add(title);
		top.add(labelP);
		top.add(field);

		middle.setLayout(new FlowLayout(FlowLayout.LEFT));
		middle.add(hdob);
		middle.add(zeroes);

		d.insets = new Insets(5, 0, 5, 0);
		c.insets = new Insets(15, 0, 15, 0);

		dots = new JButton("⋮⋮⋮");
		d.gridx = 0;
		d.gridy = 0;
		d.gridwidth = 1;
		middle1.add(dots, d);
		circle = new JButton("::");
		d.gridx = 1;
		d.gridy = 0;
		d.gridwidth = 1;
		middle1.add(circle, d);
		qword = new JButton("QWORD");
		d.gridx = 2;
		d.gridy = 0;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridwidth = 2;
		middle1.add(qword, d);
		MS = new JButton("MS");
		d.gridx = 4;
		d.gridy = 0;
		d.gridwidth = 1;
		middle1.add(MS, d);
		M = new JButton("M");
		d.gridx = 5;
		d.gridy = 0;
		d.gridwidth = 1;
		middle1.add(M, d);
		Lsh = new JButton("Lsh");
		d.gridx = 0;
		d.gridy = 1;
		middle1.add(Lsh, d);
		Rsh = new JButton("Rsh");
		d.gridx = 1;
		d.gridy = 1;
		middle1.add(Rsh, d);
		Or = new JButton("Or");
		d.gridx = 2;
		d.gridy = 1;
		middle1.add(Or, d);
		Xor = new JButton("Xor");
		d.gridx = 3;
		d.gridy = 1;
		middle1.add(Xor, d);
		Not = new JButton("Not");
		d.gridx = 4;
		d.gridy = 1;
		middle1.add(Not, d);
		And = new JButton("And");
		d.gridx = 5;
		d.gridy = 1;
		middle1.add(And, d);
		dots.setBorderPainted(false);
		circle.setBorderPainted(false);
		qword.setBorderPainted(false);
		MS.setBorderPainted(false);
		M.setBorderPainted(false);
		qword.setForeground(lightBlue);
		qword.setFont(new Font("Arial", Font.BOLD, 14));
		MS.setForeground(Color.GRAY);
		M.setForeground(Color.GRAY);
		Lsh.setBorderPainted(false);
		Rsh.setBorderPainted(false);
		Or.setBorderPainted(false);
		Xor.setBorderPainted(false);
		Not.setBorderPainted(false);
		And.setBorderPainted(false);
		Lsh.setForeground(Color.DARK_GRAY);
		Rsh.setForeground(Color.DARK_GRAY);
		Or.setForeground(Color.DARK_GRAY);
		Xor.setForeground(Color.DARK_GRAY);
		Not.setForeground(Color.DARK_GRAY);
		And.setForeground(Color.DARK_GRAY);

		arrow = new JButton("↑");
		c.gridx = 0;
		c.gridy = 4;
		digits.add(arrow, c);
		mod = new JButton("Mod");
		c.gridx = 1;
		c.gridy = 4;
		digits.add(mod, c);
		CE = new JButton("CE");
		c.gridx = 2;
		c.gridy = 4;
		digits.add(CE, c);
		C = new JButton("C");
		c.gridx = 3;
		c.gridy = 4;
		digits.add(C, c);
		backspace = new JButton("⤆");
		c.gridx = 4;
		c.gridy = 4;
		digits.add(backspace, c);
		div = new JButton("÷");
		c.gridx = 5;
		c.gridy = 4;
		digits.add(div, c);

		arrow.setBorderPainted(false);
		mod.setBorderPainted(false);
		CE.setBorderPainted(false);
		C.setBorderPainted(false);
		backspace.setBorderPainted(false);
		div.setBorderPainted(false);
		div.setFont(new Font("Calibri", Font.PLAIN, 18));

		bA = new JButton("A");
		c.gridx = 0;
		c.gridy = 5;
		bA.setEnabled(false);
		digits.add(bA, c);
		bB = new JButton("B");
		c.gridx = 1;
		c.gridy = 5;
		bB.setEnabled(false);
		digits.add(bB, c);
		b7 = new JButton("7");
		c.gridx = 2;
		c.gridy = 5;
		digits.add(b7, c);
		b8 = new JButton("8");
		c.gridx = 3;
		c.gridy = 5;
		digits.add(b8, c);
		b9 = new JButton("9");
		c.gridx = 4;
		c.gridy = 5;
		digits.add(b9, c);
		mul = new JButton("x");
		c.gridx = 5;
		c.gridy = 5;
		digits.add(mul, c);

		bA.setBorderPainted(false);
		bB.setBorderPainted(false);
		b7.setBorderPainted(false);
		b8.setBorderPainted(false);
		b9.setBorderPainted(false);
		mul.setBorderPainted(false);
		bA.setFont(new Font("Calibri", Font.PLAIN, 18));
		bB.setFont(new Font("Calibri", Font.PLAIN, 18));
		b7.setFont(new Font("Calibri", Font.PLAIN, 18));
		b8.setFont(new Font("Calibri", Font.PLAIN, 18));
		b9.setFont(new Font("Calibri", Font.PLAIN, 18));
		mul.setFont(new Font("Calibri", Font.PLAIN, 18));

		bC = new JButton("C");
		c.gridx = 0;
		c.gridy = 6;
		bC.setEnabled(false);
		digits.add(bC, c);
		bD = new JButton("D");
		c.gridx = 1;
		c.gridy = 6;
		bD.setEnabled(false);
		digits.add(bD, c);
		b4 = new JButton("4");
		c.gridx = 2;
		c.gridy = 6;
		digits.add(b4, c);
		b5 = new JButton("5");
		c.gridx = 3;
		c.gridy = 6;
		digits.add(b5, c);
		b6 = new JButton("6");
		c.gridx = 4;
		c.gridy = 6;
		digits.add(b6, c);
		sub = new JButton("-");
		c.gridx = 5;
		c.gridy = 6;
		digits.add(sub, c);

		bC.setBorderPainted(false);
		bD.setBorderPainted(false);
		b4.setBorderPainted(false);
		b5.setBorderPainted(false);
		b6.setBorderPainted(false);
		sub.setBorderPainted(false);
		bC.setFont(new Font("Calibri", Font.PLAIN, 18));
		bD.setFont(new Font("Calibri", Font.PLAIN, 18));
		b4.setFont(new Font("Calibri", Font.PLAIN, 18));
		b5.setFont(new Font("Calibri", Font.PLAIN, 18));
		b6.setFont(new Font("Calibri", Font.PLAIN, 18));
		sub.setFont(new Font("Calibri", Font.PLAIN, 18));

		bE = new JButton("E");
		c.gridx = 0;
		c.gridy = 7;
		bE.setEnabled(false);
		digits.add(bE, c);
		bF = new JButton("F");
		c.gridx = 1;
		c.gridy = 7;
		bF.setEnabled(false);
		digits.add(bF, c);
		b1 = new JButton("1");
		c.gridx = 2;
		c.gridy = 7;
		digits.add(b1, c);
		b2 = new JButton("2");
		c.gridx = 3;
		c.gridy = 7;
		digits.add(b2, c);
		b3 = new JButton("3");
		c.gridx = 4;
		c.gridy = 7;
		digits.add(b3, c);
		add = new JButton("+");
		c.gridx = 5;
		c.gridy = 7;
		digits.add(add, c);

		bE.setBorderPainted(false);
		bF.setBorderPainted(false);
		b1.setBorderPainted(false);
		b2.setBorderPainted(false);
		b3.setBorderPainted(false);
		add.setBorderPainted(false);
		bE.setFont(new Font("Calibri", Font.PLAIN, 18));
		bF.setFont(new Font("Calibri", Font.PLAIN, 18));
		b1.setFont(new Font("Calibri", Font.PLAIN, 18));
		b2.setFont(new Font("Calibri", Font.PLAIN, 18));
		b3.setFont(new Font("Calibri", Font.PLAIN, 18));
		add.setFont(new Font("Calibri", Font.PLAIN, 18));

		openP = new JButton("(");
		c.gridx = 0;
		c.gridy = 8;
		digits.add(openP, c);
		closeP = new JButton(")");
		c.gridx = 1;
		c.gridy = 8;
		digits.add(closeP, c);
		plusMinus = new JButton("±");
		c.gridx = 2;
		c.gridy = 8;
		digits.add(plusMinus, c);
		b0 = new JButton("0");
		c.gridx = 3;
		c.gridy = 8;
		digits.add(b0, c);
		bDot = new JButton(".");
		c.gridx = 4;
		c.gridy = 8;
		digits.add(bDot, c);
		equals = new JButton("=");
		c.gridx = 5;
		c.gridy = 8;
		digits.add(equals, c);

		openP.setBorderPainted(false);
		closeP.setBorderPainted(false);
		plusMinus.setBorderPainted(false);
		b0.setBorderPainted(false);
		bDot.setBorderPainted(false);
		equals.setBorderPainted(false);
		openP.setFont(new Font("Calibri", Font.PLAIN, 18));
		closeP.setFont(new Font("Calibri", Font.PLAIN, 18));
		plusMinus.setFont(new Font("Calibri", Font.PLAIN, 18));
		b0.setFont(new Font("Calibri", Font.PLAIN, 18));
		bDot.setFont(new Font("Calibri", Font.PLAIN, 18));
		equals.setFont(new Font("Calibri", Font.PLAIN, 18));

		PANEL.setLayout(new GridBagLayout());
		f.gridx = 0;
		f.gridy = 0;
		f.gridheight = 3;
		f.fill = GridBagConstraints.VERTICAL;
		f.gridwidth = 4;
		f.fill = GridBagConstraints.HORIZONTAL;
		PANEL.add(top, f);
		f.gridx = 0;
		f.gridy = 3;
		f.gridheight = 2;
		f.fill = GridBagConstraints.VERTICAL;
		f.gridwidth = 4;
		f.fill = GridBagConstraints.HORIZONTAL;
		PANEL.add(middle, f);
		f.gridx = 0;
		f.gridy = 5;
		f.gridwidth = 4;
		f.fill = GridBagConstraints.HORIZONTAL;
		f.gridheight = 2;
		f.fill = GridBagConstraints.VERTICAL;
		PANEL.add(middle1, f);
		f.gridx = 0;
		f.gridy = 7;
		f.gridheight = 5;
		f.fill = GridBagConstraints.VERTICAL;
		f.gridwidth = 4;
		f.fill = GridBagConstraints.HORIZONTAL;
		PANEL.add(digits, f);

		add(PANEL);

		bDot.addActionListener(new ButtonDotLogic());
		b0.addActionListener(new Button0Logic());
		b1.addActionListener(new Button1Logic());
		b2.addActionListener(new Button2Logic());
		b3.addActionListener(new Button3Logic());
		b4.addActionListener(new Button4Logic());
		b5.addActionListener(new Button5Logic());
		b6.addActionListener(new Button6Logic());
		b7.addActionListener(new Button7Logic());
		b8.addActionListener(new Button8Logic());
		b9.addActionListener(new Button9Logic());
		bA.addActionListener(new ButtonALogic());
		bB.addActionListener(new ButtonBLogic());
		bC.addActionListener(new ButtonCLogic());
		bD.addActionListener(new ButtonDLogic());
		bE.addActionListener(new ButtonELogic());
		bF.addActionListener(new ButtonFLogic());
		add.addActionListener(new ButtonAddLogic());
		sub.addActionListener(new ButtonSubLogic());
		mul.addActionListener(new ButtonMulLogic());
		div.addActionListener(new ButtonDivLogic());
		mod.addActionListener(new ButtonModLogic());
		equals.addActionListener(new ButtonEqualsLogic());
		C.addActionListener(new ButtonC_Logic());
		CE.addActionListener(new ButtonCELogic());
		backspace.addActionListener(new ButtonBackspaceLogic());
		plusMinus.addActionListener(new ButtonPMLogic());
		hex.addActionListener(new ButtonHexLogic());
		dec.addActionListener(new ButtonDecLogic());
		oct.addActionListener(new ButtonOctLogic());
		bin.addActionListener(new ButtonBinLogic());
		label.addAncestorListener(new LabelLogic());
		openP.addActionListener(new ButtonOpenPLogic());
		closeP.addActionListener(new ButtonClosePLogic());
		qword.addActionListener(new ButtonQWordLogic());
		dword.addActionListener(new ButtonDwordLogic());
		word.addActionListener(new ButtonWordLogic());
		Byte.addActionListener(new ButtonByteLogic());

		arrow.addMouseListener(this);
		mod.addMouseListener(this);
		CE.addMouseListener(this);
		C.addMouseListener(this);
		backspace.addMouseListener(this);
		div.addMouseListener(this);
		bA.addMouseListener(this);
		bB.addMouseListener(this);
		b7.addMouseListener(this);
		b8.addMouseListener(this);
		b9.addMouseListener(this);
		mul.addMouseListener(this);
		bC.addMouseListener(this);
		bD.addMouseListener(this);
		b4.addMouseListener(this);
		b5.addMouseListener(this);
		b6.addMouseListener(this);
		sub.addMouseListener(this);
		bE.addMouseListener(this);
		bF.addMouseListener(this);
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		b3.addMouseListener(this);
		add.addMouseListener(this);
		openP.addMouseListener(this);
		closeP.addMouseListener(this);
		plusMinus.addMouseListener(this);
		b0.addMouseListener(this);
		bDot.addMouseListener(this);
		equals.addMouseListener(this);
	}

	class LabelLogic implements AncestorListener {
		public void ancestorAdded(AncestorEvent event) {
		}

		public void ancestorMoved(AncestorEvent event) {
		}

		@Override
		public void ancestorRemoved(AncestorEvent event) {
			nullify();
		}
	}

	class ButtonQWordLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			middle1.remove(qword);
			d.gridx = 2;
			d.gridy = 0;
			d.fill = GridBagConstraints.HORIZONTAL;
			d.gridwidth = 2;
			middle1.add(dword, d);
			middle1.revalidate();
		}
	}

	class ButtonDwordLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			middle1.remove(dword);
			d.gridx = 2;
			d.gridy = 0;
			d.fill = GridBagConstraints.HORIZONTAL;
			d.gridwidth = 2;
			middle1.add(word, d);
			middle1.revalidate();
		}
	}

	class ButtonWordLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			middle1.remove(word);
			d.gridx = 2;
			d.gridy = 0;
			d.fill = GridBagConstraints.HORIZONTAL;
			d.gridwidth = 2;
			middle1.add(Byte, d);
			middle1.revalidate();
		}
	}

	class ButtonByteLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			middle1.remove(Byte);
			d.gridx = 2;
			d.gridy = 0;
			d.fill = GridBagConstraints.HORIZONTAL;
			d.gridwidth = 2;
			middle1.add(qword, d);
			middle1.revalidate();
		}
	}

	class ButtonDotLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			value = field0.getText().trim();
			labelV = label.getText();
			if (value == "0") {
				field0.setText("0.");
				d0.setText("0.");
				label.setText("0.");
				if (labelV == "( ") {
					label.setText("( 0.");
				} else
					label.setText("0.");
			} else {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += ".");
				label.setText(labelV += ".");
				d0.setText(field0.getText());
			}
		}
	}

	class ButtonOpenPLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			parenthesis = true;
			labelV = label.getText();
			if (isEqual == true) {
				label.setText("0");
				isEqual = false;
			}
			if (labelV == "0") {
				label.setText("( ");
			} /*
				 * else if (labelV.contains(")")) { int index = 0; for (int i = 0; i <
				 * labelV.length(); i++) { if (labelV.charAt(i) == ')') { index = i + 1; break;
				 * } } String s = labelV.substring(index + 1, labelV.length());
				 * label.setText(labelV.substring(0, index) + conversion(s) + " ( "); } else if
				 * (labelV != "0" && !labelV.contains(")")) { label.setText(conversion(labelV) +
				 * " ( "); }
				 */else {
				labelV = label.getText();
				label.setText(labelV += "( ");
			}
		}
	}

	class ButtonClosePLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			parenthesis = false;
			labelV = label.getText();
			if (labelV == "0") {
				label.setText(")");
			} /*
				 * else if (labelV.contains("(")) { int index = 0; for (int i = labelV.length()
				 * - 2; i >= 0; i--) { if (labelV.charAt(i) == ' ') { index = i + 1; break; } }
				 * String s = labelV.substring(index, labelV.length());
				 * label.setText(labelV.substring(0, index) + conversion(s) + " ) "); }
				 */ else {
				labelV = label.getText();
				label.setText(labelV += " )");
			}
		}
	}

	class Button0Logic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("0");
				h0.setText("0");
				d0.setText("0");
				o0.setText("0");
				b0_.setText("0");
				if (label.getText() == "( ") {
					label.setText("( 0");
				} else
					label.setText("0");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += 0);
				label.setText(labelV += 0);
				if (hex.getForeground() == lightBlue) {
					if (boundsCheckHex(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(field0.getText());
							o0.setText(hextoOct(field0.getText()));
							b0_.setText(hextoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(hextoDec(field0.getText()));
					} else {
						max();

					}
				} else if (dec.getForeground() == lightBlue) {
					if (Double.parseDouble(field0.getText()) <= Long.MAX_VALUE) {
						if (!field0.getText().contains(".")) {
							h0.setText(dectoHex(Long.parseLong(field0.getText())));
							o0.setText(dectoOct(Long.parseLong(field0.getText())));
							b0_.setText(dectoBin(Long.parseLong(field0.getText())));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(field0.getText());
					} else {
						max();
					}

				} else if (oct.getForeground() == lightBlue) {
					if (boundsCheckOct(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(octtoHex(field0.getText()));
							o0.setText(field0.getText());
							b0_.setText(octtoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(octtoDec(field0.getText()));
					} else {
						max();

					}
				} else if (bin.getForeground() == lightBlue) {
					if (boundsCheckBin(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(bintoHex(field0.getText()));
							o0.setText(bintoOct(field0.getText()));
							b0_.setText(field0.getText());
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(bintoDec(field0.getText()));
					} else {
						max();
					}
				}
			}
		}
	}

	class Button1Logic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("1");
				h0.setText("1");
				d0.setText("1");
				o0.setText("1");
				b0_.setText("1");
				if (label.getText() == "( ") {
					label.setText("( 1");
				} else
					label.setText("1");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += 1);
				label.setText(labelV += 1);
				if (hex.getForeground() == lightBlue) {
					if (boundsCheckHex(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(field0.getText());
							o0.setText(hextoOct(field0.getText()));
							b0_.setText(hextoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(hextoDec(field0.getText()));
					} else {
						max();

					}
				} else if (dec.getForeground() == lightBlue) {
					if (Double.parseDouble(field0.getText()) <= Long.MAX_VALUE) {
						if (!field0.getText().contains(".")) {
							h0.setText(dectoHex(Long.parseLong(field0.getText())));
							o0.setText(dectoOct(Long.parseLong(field0.getText())));
							b0_.setText(dectoBin(Long.parseLong(field0.getText())));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(field0.getText());
					} else {
						max();
					}

				} else if (oct.getForeground() == lightBlue) {
					if (boundsCheckOct(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(octtoHex(field0.getText()));
							o0.setText(field0.getText());
							b0_.setText(octtoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(octtoDec(field0.getText()));
					} else {
						max();

					}
				} else if (bin.getForeground() == lightBlue) {
					if (boundsCheckBin(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(bintoHex(field0.getText()));
							o0.setText(bintoOct(field0.getText()));
							b0_.setText(field0.getText());
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(bintoDec(field0.getText()));
					} else {
						max();
					}
				}
			}
		}
	}

	class Button2Logic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("2");
				h0.setText("2");
				d0.setText("2");
				o0.setText("2");
				b0_.setText("2");
				if (label.getText() == "( ") {
					label.setText("( 2");
				} else
					label.setText("2");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += 2);
				label.setText(labelV += 2);
				if (hex.getForeground() == lightBlue) {
					if (boundsCheckHex(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(field0.getText());
							o0.setText(hextoOct(field0.getText()));
							b0_.setText(hextoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(hextoDec(field0.getText()));
					} else {
						max();

					}
				} else if (dec.getForeground() == lightBlue) {
					if (Double.parseDouble(field0.getText()) <= Long.MAX_VALUE) {
						if (!field0.getText().contains(".")) {
							h0.setText(dectoHex(Long.parseLong(field0.getText())));
							o0.setText(dectoOct(Long.parseLong(field0.getText())));
							b0_.setText(dectoBin(Long.parseLong(field0.getText())));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(field0.getText());
					} else {
						max();
					}

				} else if (oct.getForeground() == lightBlue) {
					if (boundsCheckOct(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(octtoHex(field0.getText()));
							o0.setText(field0.getText());
							b0_.setText(octtoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(octtoDec(field0.getText()));
					} else {
						max();
					}
				}
			}
		}
	}

	class Button3Logic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("3");
				h0.setText("3");
				d0.setText("3");
				o0.setText("3");
				b0_.setText("3");
				if (label.getText() == "( ") {
					label.setText("( 3");
				} else
					label.setText("3");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += 3);
				label.setText(labelV += 3);
				if (hex.getForeground() == lightBlue) {
					if (boundsCheckHex(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(field0.getText());
							o0.setText(hextoOct(field0.getText()));
							b0_.setText(hextoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(hextoDec(field0.getText()));
					} else {
						max();
					}

				} else if (dec.getForeground() == lightBlue) {
					if (Double.parseDouble(field0.getText()) <= Long.MAX_VALUE) {
						if (!field0.getText().contains(".")) {
							h0.setText(dectoHex(Long.parseLong(field0.getText())));
							o0.setText(dectoOct(Long.parseLong(field0.getText())));
							b0_.setText(dectoBin(Long.parseLong(field0.getText())));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(field0.getText());
					} else {
						max();
					}
				} else if (oct.getForeground() == lightBlue) {
					if (boundsCheckOct(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(octtoHex(field0.getText()));
							o0.setText(field0.getText());
							b0_.setText(octtoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(octtoDec(field0.getText()));
					} else {
						max();
					}
				}
			}
		}
	}

	class Button4Logic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("4");
				h0.setText("4");
				d0.setText("4");
				o0.setText("4");
				b0_.setText("4");
				if (label.getText() == "( ") {
					label.setText("( 4");
				} else
					label.setText("4");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += 4);
				label.setText(labelV += 4);
				if (hex.getForeground() == lightBlue) {
					if (boundsCheckHex(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(field0.getText());
							o0.setText(hextoOct(field0.getText()));
							b0_.setText(hextoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(hextoDec(field0.getText()));
					} else {
						max();
					}

				} else if (dec.getForeground() == lightBlue) {
					if (Double.parseDouble(field0.getText()) <= Long.MAX_VALUE) {
						if (!field0.getText().contains(".")) {
							h0.setText(dectoHex(Long.parseLong(field0.getText())));
							o0.setText(dectoOct(Long.parseLong(field0.getText())));
							b0_.setText(dectoBin(Long.parseLong(field0.getText())));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(field0.getText());
					} else {
						max();
					}
				} else if (oct.getForeground() == lightBlue) {
					if (boundsCheckOct(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(octtoHex(field0.getText()));
							o0.setText(field0.getText());
							b0_.setText(octtoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(octtoDec(field0.getText()));
					} else {
						max();
					}
				}
			}
		}
	}

	class Button5Logic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("5");
				h0.setText("5");
				d0.setText("5");
				o0.setText("5");
				b0_.setText("5");
				if (label.getText() == "( ") {
					label.setText("( 5");
				} else
					label.setText("5");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += 5);
				label.setText(labelV += 5);
				if (hex.getForeground() == lightBlue) {
					if (boundsCheckHex(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(field0.getText());
							o0.setText(hextoOct(field0.getText()));
							b0_.setText(hextoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(hextoDec(field0.getText()));
					} else {
						max();
					}
				} else if (dec.getForeground() == lightBlue) {
					if (Double.parseDouble(field0.getText()) <= Long.MAX_VALUE) {
						if (!field0.getText().contains(".")) {
							h0.setText(dectoHex(Long.parseLong(field0.getText())));
							o0.setText(dectoOct(Long.parseLong(field0.getText())));
							b0_.setText(dectoBin(Long.parseLong(field0.getText())));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(field0.getText());
					} else {
						max();
					}
				} else if (oct.getForeground() == lightBlue) {
					if (boundsCheckOct(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(octtoHex(field0.getText()));
							o0.setText(field0.getText());
							b0_.setText(octtoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(octtoDec(field0.getText()));
					} else {
						max();
					}
				}
			}
		}
	}

	class Button6Logic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("6");
				h0.setText("6");
				d0.setText("6");
				o0.setText("6");
				b0_.setText("6");
				if (label.getText() == "( ") {
					label.setText("( 6");
				} else
					label.setText("6");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += 6);
				label.setText(labelV += 6);
				if (hex.getForeground() == lightBlue) {
					if (boundsCheckHex(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(field0.getText());
							o0.setText(hextoOct(field0.getText()));
							b0_.setText(hextoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(hextoDec(field0.getText()));
					} else {
						max();
					}
				} else if (dec.getForeground() == lightBlue) {
					if (Double.parseDouble(field0.getText()) <= Long.MAX_VALUE) {
						if (!field0.getText().contains(".")) {
							h0.setText(dectoHex(Long.parseLong(field0.getText())));
							o0.setText(dectoOct(Long.parseLong(field0.getText())));
							b0_.setText(dectoBin(Long.parseLong(field0.getText())));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(field0.getText());
					} else {
						max();
					}
				} else if (oct.getForeground() == lightBlue) {
					if (boundsCheckOct(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(octtoHex(field0.getText()));
							o0.setText(field0.getText());
							b0_.setText(octtoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(octtoDec(field0.getText()));
					} else {
						max();
					}
				}
			}
		}
	}

	class Button7Logic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("7");
				h0.setText("7");
				d0.setText("7");
				o0.setText("7");
				b0_.setText("7");
				if (label.getText() == "( ") {
					label.setText("( 7");
				} else
					label.setText("7");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += 7);
				label.setText(labelV += 7);
				if (hex.getForeground() == lightBlue) {
					if (boundsCheckHex(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(field0.getText());
							o0.setText(hextoOct(field0.getText()));
							b0_.setText(hextoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(hextoDec(field0.getText()));
					} else {
						max();
					}
				} else if (dec.getForeground() == lightBlue) {
					if (Double.parseDouble(field0.getText()) <= Long.MAX_VALUE) {
						if (!field0.getText().contains(".")) {
							h0.setText(dectoHex(Long.parseLong(field0.getText())));
							o0.setText(dectoOct(Long.parseLong(field0.getText())));
							b0_.setText(dectoBin(Long.parseLong(field0.getText())));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(field0.getText());
					} else {
						max();
					}
				} else if (oct.getForeground() == lightBlue) {
					if (boundsCheckOct(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(octtoHex(field0.getText()));
							o0.setText(field0.getText());
							b0_.setText(octtoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(octtoDec(field0.getText()));
					} else {
						max();
					}
				}
			}
		}
	}

	class Button8Logic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("8");
				h0.setText("8");
				d0.setText("8");
				o0.setText("8");
				b0_.setText("8");
				if (label.getText() == "( ") {
					label.setText("( 8");
				} else
					label.setText("8");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += 8);
				label.setText(labelV += 8);
				if (hex.getForeground() == lightBlue) {
					if (boundsCheckHex(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(field0.getText());
							o0.setText(hextoOct(field0.getText()));
							b0_.setText(hextoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(hextoDec(field0.getText()));
					} else {
						max();
					}
				} else if (dec.getForeground() == lightBlue) {
					if (Double.parseDouble(field0.getText()) <= Long.MAX_VALUE) {
						if (!field0.getText().contains(".")) {
							h0.setText(dectoHex(Long.parseLong(field0.getText())));
							o0.setText(dectoOct(Long.parseLong(field0.getText())));
							b0_.setText(dectoBin(Long.parseLong(field0.getText())));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(field0.getText());
					} else {
						max();
					}
				}
			}
		}
	}

	class Button9Logic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("9");
				h0.setText("9");
				d0.setText("9");
				o0.setText("9");
				b0_.setText("9");
				if (label.getText() == "( ") {
					label.setText("( 9");
				} else
					label.setText("9");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += 9);
				label.setText(labelV += 9);
				if (hex.getForeground() == lightBlue) {
					if (boundsCheckHex(field0.getText())) {
						if (!field0.getText().contains(".")) {
							h0.setText(field0.getText());
							o0.setText(hextoOct(field0.getText()));
							b0_.setText(hextoBin(field0.getText()));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(hextoDec(field0.getText()));
					} else {
						max();
					}
				} else if (dec.getForeground() == lightBlue) {
					if (Double.parseDouble(field0.getText()) <= Long.MAX_VALUE) {
						if (!field0.getText().contains(".")) {
							h0.setText(dectoHex(Long.parseLong(field0.getText())));
							o0.setText(dectoOct(Long.parseLong(field0.getText())));
							b0_.setText(dectoBin(Long.parseLong(field0.getText())));
						} else {
							h0.setText("0");
							o0.setText("0");
							b0_.setText("0");
						}
						d0.setText(field0.getText());
					} else {
						max();
					}
				}
			}
		}
	}

	class ButtonALogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("A");
				h0.setText("A");
				d0.setText("10");
				o0.setText("12");
				b0_.setText("1010");
				if (label.getText() == "( ") {
					label.setText("( A");
				} else
					label.setText("A");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += "A");
				label.setText(labelV += "A");
				if (boundsCheckHex(field0.getText())) {
					h0.setText(field0.getText());
					d0.setText(hextoDec(field0.getText()));
					o0.setText(hextoOct(field0.getText()));
					b0_.setText(hextoBin(field0.getText()));
				} else {
					max();
				}
			}
		}
	}

	class ButtonBLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("B");
				h0.setText("B");
				d0.setText("11");
				o0.setText("13");
				b0_.setText("1011");
				if (label.getText() == "( ") {
					label.setText("( B");
				} else
					label.setText("B");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += "B");
				label.setText(labelV += "B");
				if (boundsCheckHex(field0.getText())) {
					h0.setText(field0.getText());
					d0.setText(hextoDec(field0.getText()));
					o0.setText(hextoOct(field0.getText()));
					b0_.setText(hextoBin(field0.getText()));
				} else {
					max();
				}
			}
		}
	}

	class ButtonCLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("C");
				h0.setText("C");
				d0.setText("12");
				o0.setText("14");
				b0_.setText("1100");
				if (label.getText() == "( ") {
					label.setText("( C");
				} else
					label.setText("C");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += "C");
				label.setText(labelV += "C");
				if (boundsCheckHex(field0.getText())) {
					h0.setText(field0.getText());
					d0.setText(hextoDec(field0.getText()));
					o0.setText(hextoOct(field0.getText()));
					b0_.setText(hextoBin(field0.getText()));
				} else {
					max();
				}
			}
		}
	}

	class ButtonDLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("D");
				h0.setText("D");
				d0.setText("13");
				o0.setText("15");
				b0_.setText("1101");
				if (label.getText() == "( ") {
					label.setText("( D");
				} else
					label.setText("D");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += "D");
				label.setText(labelV += "D");
				if (boundsCheckHex(field0.getText())) {
					h0.setText(field0.getText());
					d0.setText(hextoDec(field0.getText()));
					o0.setText(hextoOct(field0.getText()));
					b0_.setText(hextoBin(field0.getText()));
				} else {
					max();
				}
			}
		}
	}

	class ButtonELogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("E");
				h0.setText("E");
				d0.setText("14");
				o0.setText("16");
				b0_.setText("1110");
				if (label.getText() == "( ") {
					label.setText("( E");
				} else
					label.setText("E");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += "E");
				label.setText(labelV += "E");
				if (boundsCheckHex(field0.getText())) {
					h0.setText(field0.getText());
					d0.setText(hextoDec(field0.getText()));
					o0.setText(hextoOct(field0.getText()));
					b0_.setText(hextoBin(field0.getText()));
				} else {
					max();
				}
			}
		}
	}

	class ButtonFLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (isEqual == true) {
				label.setText("0");
				field0.setText("0");
				isEqual = false;
			}
			value = field0.getText().trim();
			if (value == "0") {
				field0.setText("F");
				h0.setText("F");
				d0.setText("15");
				o0.setText("17");
				b0_.setText("1111");
				if (label.getText() == "( ") {
					label.setText("( F");
				} else
					label.setText("F");
			} else if (value != "0") {
				value = field0.getText().trim();
				labelV = label.getText();
				field0.setText(value += "F");
				label.setText(labelV += "F");
				if (boundsCheckHex(field0.getText())) {
					h0.setText(field0.getText());
					d0.setText(hextoDec(field0.getText()));
					o0.setText(hextoOct(field0.getText()));
					b0_.setText(hextoBin(field0.getText()));
				} else {
					max();
				}
			}
		}
	}

	class ButtonAddLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			check = 1;
			if (isEqual == true) {
				label.setText(field0.getText());
				isEqual = false;
			}
			labelV = label.getText();
			op1 = Double.parseDouble(d0.getText());
			field0.setText(" ");

			/*
			 * if (parenthesis == true) { label.setText(convert(labelV) + " + "); } else
			 */
			label.setText(labelV += " + ");

		}
	}

	class ButtonSubLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			check = 2;
			if (isEqual == true) {
				label.setText(field0.getText());
				isEqual = false;
			}
			labelV = label.getText();
			op1 = Double.parseDouble(d0.getText());
			field0.setText(" ");
			/*
			 * if (parenthesis == true) { label.setText(convert(labelV) + " - "); } else
			 */
			label.setText(labelV += " - ");
		}
	}

	class ButtonMulLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			check = 3;
			if (isEqual == true) {
				label.setText(field0.getText());
				isEqual = false;
			}
			labelV = label.getText();
			op1 = Double.parseDouble(d0.getText());
			field0.setText(" ");
			/*
			 * if (parenthesis == true) { label.setText(convert(labelV) + " × "); } else
			 */
			label.setText(labelV += " × ");
		}
	}

	class ButtonDivLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			check = 4;
			if (isEqual == true) {
				label.setText(field0.getText());
				isEqual = false;
			}
			labelV = label.getText();
			op1 = Double.parseDouble(d0.getText());
			field0.setText(" ");
			/*
			 * if (parenthesis == true) { label.setText(convert(labelV) + " ÷ "); } else
			 */
			label.setText(labelV += " ÷ ");
		}
	}

	class ButtonModLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			check = 5;
			if (isEqual == true) {
				label.setText(field0.getText());
				isEqual = false;
			}
			labelV = label.getText();
			op1 = Double.parseDouble(d0.getText());
			field0.setText(" ");
			/*
			 * if (parenthesis == true) { label.setText(convert(labelV) + " % "); } else
			 */
			label.setText(labelV += " % ");
		}
	}

	class ButtonC_Logic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int a = field0.getText().trim().length();
			int b = label.getText().length() - a;
			String s = label.getText().substring(0, b);
			label.setText(s);
			field0.setText(" ");
			h0.setText("0");
			d0.setText("0");
			o0.setText("0");
			b0_.setText("0");
			op2 = 0;
		}
	}

	class ButtonCELogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			reset();
			if (hex.getForeground() == lightBlue) {
				resetHex();
			} else if (dec.getForeground() == lightBlue) {
				resetDec();
			} else if (oct.getForeground() == lightBlue) {
				resetOct();
			} else if (bin.getForeground() == lightBlue) {
				resetBin();
			}
		}
	}

	class ButtonBackspaceLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String temp = field0.getText().trim();
			String temp1 = label.getText();
			int size = temp.length(), size1 = temp1.length();
			String newStr = null, newStr1 = null;
			if (size != 0 && size1 != 0) {
				newStr = bSpace(temp);
				field0.setText(" " + newStr);
				newStr1 = bSpace(temp1);
				label.setText(newStr1);
			} else if (size == 0 && size1 != 0) {
				newStr1 = bSpace(temp1);
				label.setText(newStr1);
				op2 = 0;
				check = 0;
			} else if (size == 0 && size1 == 0) {
				backspace.setEnabled(false);
				reset();
				nullify();
			}
		}
	}

	class ButtonPMLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String labelString = label.getText();
			String currentValue = d0.getText();
			String newValue = PM(currentValue);
			double nV = Double.parseDouble(newValue);
			String forLabelnField0 = null;
			if (field0.getText() == " ") {
				nullify();
				reset();
				label.setText("ERROR");
			} else if (nV == 0) {
				isEqual = true;
			} else {
				h0.setText(dectoHex(nV));
				d0.setText(newValue);
				o0.setText(dectoOct(nV));
				b0_.setText(dectoBin(nV));
				if (hex.getForeground() == lightBlue) {
					forLabelnField0 = h0.getText();
				} else if (dec.getForeground() == lightBlue) {
					forLabelnField0 = d0.getText();
				} else if (oct.getForeground() == lightBlue) {
					forLabelnField0 = o0.getText();
				} else if (bin.getForeground() == lightBlue) {
					forLabelnField0 = b0_.getText();
				}
				field0.setText(forLabelnField0);
				int index = getSubStrIndex(labelString);
				String subStr = labelString.substring(0, index);
				label.setText(subStr + forLabelnField0);
			}
		}
	}

	class ButtonEqualsLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			isEqual = true;
			labelV = label.getText();
			String op = d0.getText();
			op2 = Double.parseDouble(op);
			if (!labelV.contains("(")) {
				if (labelV.charAt(labelV.length() - 1) == ' ') {
					labelV += op;
				}
				String decimal = conversion(labelV);
				String answer = operation(decimal);
				label.setText(labelV + " =");
				setText(answer);
			} else if (labelV.contains("(")) {
				if (labelV.charAt(labelV.length() - 2) != ')') {
					if (Character.isDigit(labelV.charAt(labelV.length() - 1))
							|| Character.isLetter(labelV.charAt(labelV.length() - 1))) {
						if (!labelV.contains(")"))
							labelV += " )";
					} else
						labelV += (op + " )");
				}
				if (d0.getForeground() != lightBlue) {
					labelV = conversion(labelV);
					/*
					 * String s = null; if (labelV.charAt(labelV.length() - 2) != ')') { try { s =
					 * convert(labelV); label.setText(s + " ="); setText(operation(s)); } catch
					 * (EmptyStackException a) { label.setText("FORMAT ERROR 1"); nullify(); } catch
					 * (NullPointerException a) { label.setText("FORMAT ERROR 2"); nullify(); }
					 * catch (NumberFormatException a) { label.setText("FORMAT ERROR 3"); nullify();
					 * } } else { s = labelV; label.setText(s + " ="); setText(operation(s));
					 */
				}
				label.setText(labelV + " =");
				setText(operation(labelV));
			}
		}
	}

	class ButtonHexLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText(h0.getText());
			field0.setText(h0.getText());
			resetHex();
		}
	}

	class ButtonDecLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText(d0.getText());
			field0.setText(d0.getText());
			resetDec();
		}
	}

	class ButtonOctLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			field0.setText(o0.getText());
			label.setText(o0.getText());
			resetOct();
		}
	}

	class ButtonBinLogic implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			field0.setText(b0_.getText());
			label.setText(b0_.getText());
			resetBin();
		}

	}

	public String hextoDec(String hex) {
		long decimal = 0;
		try {
			decimal = Long.parseLong(hex, 16);
		} catch (NumberFormatException e) {
			label.setText("INPUT ERROR");
			nullify();
		}
		return Long.toString(decimal);
	}

	public String hextoOct(String hex) {
		long decimal = 0;
		try {
			decimal = Long.parseLong(nonFloat(hex), 16);
		} catch (NumberFormatException e) {
			label.setText("INPUT ERROR");
			nullify();
		}
		String octal = dectoOct(decimal);
		return octal;
	}

	public String hextoBin(String hex) {
		long decimal = 0;
		try {
			decimal = Long.parseLong(nonFloat(hex), 16);
		} catch (NumberFormatException e) {
			label.setText("INPUT ERROR");
			nullify();
		}
		String binary = dectoBin(decimal);
		return binary;

	}

	public String dectoHex(double dec) {
		String hex = null;
		if (dec < 0) {
			dec = 0 - dec;
			hex = "-" + Long.toHexString((long) dec).toUpperCase();
		} else
			hex = Long.toHexString((long) dec).toUpperCase();
		return hex;

	}

	public String dectoOct(double dec) {
		String octal = null;
		if (dec < 0) {
			dec = 0 - dec;
			octal = "-" + Long.toOctalString((long) dec);
		} else
			octal = Long.toOctalString((long) dec);
		return octal;

	}

	public String dectoBin(double dec) {
		String binary = null;
		if (dec < 0) {
			binary = Long.toBinaryString((long) dec);
		} else
			binary = Long.toBinaryString((long) dec);
		return binary;
	}

	public String octtoHex(String oct) {
		long decimal = 0;
		try {
			decimal = Long.parseLong(nonFloat(oct), 8);
		} catch (NumberFormatException e) {
			label.setText("INPUT ERROR");
			nullify();
		}
		String hex = dectoHex(decimal);
		return hex;
	}

	public String octtoDec(String oct) {
		long decimal = 0;
		try {
			Long.parseLong(nonFloat(oct), 8);
		} catch (NumberFormatException e) {
			label.setText("INPUT ERROR");
			nullify();
		}
		return Long.toString(decimal);
	}

	public String octtoBin(String oct) {
		long decimal = 0;
		try {
			Long.parseLong(nonFloat(oct), 8);
		} catch (NumberFormatException e) {
			label.setText("INPUT ERROR");
			nullify();
		}
		String binary = dectoBin(decimal);
		return binary;
	}

	public String bintoHex(String bin) {
		long decimal = 0;
		try {
			Long.parseLong(nonFloat(bin), 2);
		} catch (NumberFormatException e) {
			label.setText("INPUT ERROR");
			nullify();
		}
		String hex = dectoHex(decimal);
		return hex;
	}

	public String bintoDec(String bin) {
		long decimal = 0;
		try {
			Long.parseLong(nonFloat(bin), 2);
		} catch (NumberFormatException e) {
			label.setText("INPUT ERROR");
			nullify();
		}
		return Long.toString(decimal);
	}

	public String bintoOct(String bin) {
		long decimal = 0;
		try {
			Long.parseLong(nonFloat(bin), 2);
		} catch (NumberFormatException e) {
			label.setText("INPUT ERROR");
			nullify();
		}
		String octal = dectoOct(decimal);
		return octal;
	}

	public String operation(String expression) {
		char[] exp = expression.toCharArray();
		int s = exp.length;
		Stack<Double> operands = new Stack<Double>();
		Stack<Character> operators = new Stack<Character>();
		for (int i = 0; i < s; i++) {
			if (exp[i] == ' ') {
				continue;
			} else if (Character.isDigit(exp[i])) {
				StringBuffer sbuf = new StringBuffer();
				while (i < exp.length && (Character.isDigit(exp[i]) || exp[i] == '.')) {
					sbuf.append(exp[i++]);
				}
				operands.push(Double.parseDouble(sbuf.toString()));
			} else if (exp[i] == '(') {
				operators.push(exp[i]);
			} else if (exp[i] == ')') {
				while (operators.peek() != '(') {
					char op = operators.pop();
					double op2 = operands.pop();
					double op1 = operands.pop();
					double ans = operate(op1, op2, op);
					operands.push(ans);
				}
				operators.pop();
			} else if (exp[i] == '+' || exp[i] == '×' || exp[i] == '÷' || exp[i] == '%') {
				while (!operators.isEmpty() && precedence(exp[i]) < precedence(operators.peek())) {
					char op = operators.pop();
					double op2 = operands.pop();
					double op1 = operands.pop();
					double ans = operate(op1, op2, op);
					operands.push(ans);
				}
				operators.push(exp[i]);
			} else if (exp[i] == '-') {
				if (Character.isDigit(exp[i + 1])) {
					double positive = Integer.parseInt(exp[i + 1] + "");
					double negative = 0 - positive;
					operands.push(negative);
					i++;
				} else if (exp[i + 1] == ' ') {
					while (!operators.isEmpty() && precedence(exp[i]) < precedence(operators.peek())) {
						char op = operators.pop();
						double op2 = operands.pop();
						double op1 = operands.pop();
						double ans = operate(op1, op2, op);
						operands.push(ans);
					}
					operators.push(exp[i]);
				} else {
					label.setText("error");
					field0.setText("error");
				}
			}
		}
		while (!operators.isEmpty()) {
			char op = operators.pop();
			double op2 = operands.pop();
			double op1 = operands.pop();
			double ans = operate(op1, op2, op);
			operands.push(ans);
		}
		return operands.pop().toString();
	}

	public int precedence(char op) {
		int precedence = 0;
		if (op == '×' || op == '÷' || op == '%') {
			precedence = 2;
		} else if (op == '+' || op == '-') {
			precedence = 1;
		}
		return precedence;
	}

	public double operate(double op1, double op2, char op) {
		double answer = 0;
		if (op == '+') {
			answer = op1 + op2;
		} else if (op == '-') {
			answer = op1 - op2;
		} else if (op == '×') {
			answer = op1 * op2;
		} else if (op == '÷') {
			try {
				answer = op1 / op2;
			} catch (ArithmeticException e) {
				label.setText("ERROR");
				field0.setText("ERROR");
			}
		} else if (op == '%') {
			answer = op1 % op2;
		}
		return answer;
	}

	public void max() {
		String max = "MAX";
		field0.setText(max);
		h0.setText(max);
		d0.setText(max);
		o0.setText(max);
		b0_.setText(max);
		label.setVisible(false);
	}

	public String conversion(String str) {
		String dec_ = null, sFinal = null;
		String s = str.replaceAll("\\+ ", "").replaceAll("\\- ", "").replaceAll("\\× ", "").replaceAll("\\÷ ", "")
				.replaceAll("\\( ", "").replaceAll("\\)", "");
		String[] a = s.split(" ");
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(""))
				continue;
			if (hex.getForeground() == lightBlue) {
				dec_ = hextoDec(a[i]);
			} else if (dec.getForeground() == lightBlue) {
				dec_ = a[i];
			} else if (oct.getForeground() == lightBlue) {
				dec_ = octtoDec(a[i]);
			} else if (bin.getForeground() == lightBlue) {
				dec_ = bintoDec(a[i]);
			}
			sFinal = str.replaceAll(a[i], dec_);
			str = sFinal;
		}
		return sFinal;
	}

	public String nonFloat(String str) {
		int index = str.length();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.') {
				index = i;
			}
		}
		return str.substring(0, index);
	}

	public int getSubStrIndex(String str) {
		int n = str.length(), index = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (str.charAt(i) == ' ') {
				index = i + 1;
				break;
			}
		}
		return index;
	}

	/*
	 * public String convert(String str) { int index = getSubStrIndex(str), n =
	 * str.length(); String st = null; String s = str.substring(index, n); if
	 * (hex.getForeground() == lightBlue) { st = str.substring(0, index) +
	 * hextoDec(s); } else if (dec.getForeground() == lightBlue) { st =
	 * str.substring(0, index) + s; } else if (oct.getForeground() == lightBlue) {
	 * st = str.substring(0, index) + octtoDec(s); } else if (bin.getForeground() ==
	 * lightBlue) { st = str.substring(0, index) + bintoDec(s); } return st; }
	 */

	public String PM(String currentValue) {
		String newValue = null;
		if (currentValue.contains("-")) {
			newValue = currentValue.substring(1, currentValue.length());
		} else if (currentValue == "0" || currentValue == "0.0" || currentValue == ".0") {
			newValue = "0";
		} else
			newValue = "-" + currentValue;
		return newValue;
	}

	public void setText(String expression) {
		String f = field0.getText();
		String h = h0.getText();
		String d = d0.getText();
		String o = o0.getText();
		String b = b0_.getText();
		double ans = Double.parseDouble(expression);
		String ansStr = null;
		if (hex.getForeground() == lightBlue) {
			if (ans < 0) {
				ans = 0 - ans;
				ansStr = "-" + dectoHex((long) ans);
			} else
				ansStr = dectoHex((long) ans);
			field0.setText(ansStr);
			h0.setText(ansStr);
			d0.setText(hextoDec(ansStr));
			o0.setText(hextoOct(ansStr));
			b0_.setText(hextoBin(ansStr));
		} else if (dec.getForeground() == lightBlue) {
			ansStr = Double.toString(ans);
			field0.setText(ansStr);
			h0.setText(dectoHex((long) ans));
			d0.setText(ansStr);
			o0.setText(dectoOct((long) ans));
			b0_.setText(dectoBin((long) ans));
		} else if (oct.getForeground() == lightBlue) {
			if (ans < 0) {
				ans = 0 - ans;
				ansStr = "-" + dectoOct((long) ans);
			} else
				ansStr = dectoOct((long) ans);
			field0.setText(ansStr);
			h0.setText(octtoHex(ansStr));
			d0.setText(octtoDec(ansStr));
			o0.setText(ansStr);
			b0_.setText(octtoBin(ansStr));
		} else if (bin.getForeground() == lightBlue) {
			if (ans < 0) {
				ans = 0 - ans;
				ansStr = "-" + dectoBin((long) ans);
			} else
				ansStr = dectoBin((long) ans);
			field0.setText(ansStr);
			h0.setText(bintoHex(ansStr));
			d0.setText(bintoDec(ansStr));
			o0.setText(bintoOct(ansStr));
			b0_.setText(ansStr);
		} else {
			field0.setText(f);
			h0.setText(h);
			d0.setText(d);
			o0.setText(o);
			b0_.setText(b);
		}
		check = 0;
	}

	public String bSpace(String a) {
		int size = a.length();
		if (size > 0) {
			StringBuilder strB = new StringBuilder(a);
			strB.deleteCharAt(size - 1);
			a = strB.toString();
		}
		return a;
	}

	public boolean boundsCheckHex(String str) {
		boolean within = false;
		try {
			if (Long.parseLong(str, 16) < Long.MAX_VALUE)
				within = true;
		} catch (NumberFormatException e) {
			label.setText("FORMAT ERROR");
			nullify();
		}
		return within;
	}

	public boolean boundsCheckOct(String str) {
		boolean within = false;
		try {
			if (Long.parseLong(str, 8) < Long.MAX_VALUE)
				within = true;
		} catch (NumberFormatException e) {
			label.setText("FORMAT ERROR");
			nullify();
		}
		return within;
	}

	public boolean boundsCheckBin(String str) {
		boolean within = false;
		try {
			if (Long.parseLong(str, 2) < Long.MAX_VALUE)
				within = true;
		} catch (NumberFormatException e) {
			label.setText("FORMAT ERROR");
			nullify();
		}
		return within;
	}

	public void reset() {
		h0.setText("0");
		d0.setText("0");
		o0.setText("0");
		b0_.setText("0");
		field0.setText("0");
		label.setText("0");
		op1 = 0;
		op2 = 0;
		check = 0;
		isEqual = false;
	}

	public void resetHex() {
		hex.setForeground(lightBlue);
		dec.setForeground(Color.DARK_GRAY);
		oct.setForeground(Color.DARK_GRAY);
		bin.setForeground(Color.DARK_GRAY);
		h0.setForeground(lightBlue);
		d0.setForeground(Color.gray);
		o0.setForeground(Color.gray);
		b0_.setForeground(Color.gray);
		b0.setEnabled(true);
		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
		b7.setEnabled(true);
		b8.setEnabled(true);
		b9.setEnabled(true);
		bA.setEnabled(true);
		bB.setEnabled(true);
		bC.setEnabled(true);
		bD.setEnabled(true);
		bE.setEnabled(true);
		bF.setEnabled(true);
		bDot.setEnabled(false);
		resetOps();
	}

	public void resetDec() {
		hex.setForeground(Color.DARK_GRAY);
		dec.setForeground(lightBlue);
		oct.setForeground(Color.DARK_GRAY);
		bin.setForeground(Color.DARK_GRAY);
		h0.setForeground(Color.gray);
		d0.setForeground(lightBlue);
		o0.setForeground(Color.gray);
		b0_.setForeground(Color.gray);
		bA.setEnabled(false);
		bB.setEnabled(false);
		bC.setEnabled(false);
		bD.setEnabled(false);
		bE.setEnabled(false);
		bF.setEnabled(false);
		b0.setEnabled(true);
		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
		b7.setEnabled(true);
		b8.setEnabled(true);
		b9.setEnabled(true);
		bDot.setEnabled(true);
		resetOps();
	}

	public void resetOct() {
		hex.setForeground(Color.DARK_GRAY);
		dec.setForeground(Color.DARK_GRAY);
		oct.setForeground(lightBlue);
		bin.setForeground(Color.DARK_GRAY);
		h0.setForeground(Color.gray);
		d0.setForeground(Color.gray);
		o0.setForeground(lightBlue);
		b0_.setForeground(Color.gray);
		bA.setEnabled(false);
		bB.setEnabled(false);
		bC.setEnabled(false);
		bD.setEnabled(false);
		bE.setEnabled(false);
		bF.setEnabled(false);
		b0.setEnabled(true);
		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
		b7.setEnabled(true);
		b8.setEnabled(false);
		b9.setEnabled(false);
		bDot.setEnabled(false);
		resetOps();
	}

	public void resetBin() {
		hex.setForeground(Color.DARK_GRAY);
		dec.setForeground(Color.DARK_GRAY);
		oct.setForeground(Color.DARK_GRAY);
		bin.setForeground(lightBlue);
		h0.setForeground(Color.gray);
		d0.setForeground(Color.gray);
		o0.setForeground(Color.gray);
		b0_.setForeground(lightBlue);
		bA.setEnabled(false);
		bB.setEnabled(false);
		bC.setEnabled(false);
		bD.setEnabled(false);
		bE.setEnabled(false);
		bF.setEnabled(false);
		b0.setEnabled(true);
		b1.setEnabled(true);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		b7.setEnabled(false);
		b8.setEnabled(false);
		b9.setEnabled(false);
		bDot.setEnabled(false);
		resetOps();
	}

	public void nullify() {
		bA.setEnabled(false);
		bB.setEnabled(false);
		bC.setEnabled(false);
		bD.setEnabled(false);
		bE.setEnabled(false);
		bF.setEnabled(false);
		b0.setEnabled(false);
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		b7.setEnabled(false);
		b8.setEnabled(false);
		b9.setEnabled(false);
		bDot.setEnabled(false);
		add.setEnabled(false);
		sub.setEnabled(false);
		mul.setEnabled(false);
		div.setEnabled(false);
		mod.setEnabled(false);
		backspace.setEnabled(false);
		C.setEnabled(false);
		equals.setEnabled(false);
		openP.setEnabled(false);
		closeP.setEnabled(false);
		arrow.setEnabled(false);
		plusMinus.setEnabled(false);
	}

	public void resetOps() {
		add.setEnabled(true);
		sub.setEnabled(true);
		mul.setEnabled(true);
		div.setEnabled(true);
		mod.setEnabled(true);
		backspace.setEnabled(true);
		C.setEnabled(true);
		equals.setEnabled(true);
		openP.setEnabled(true);
		closeP.setEnabled(true);
		arrow.setEnabled(true);
		plusMinus.setEnabled(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (hex.getForeground() == lightBlue) {
			if (e.getSource() == bA) {
				bA.setBackground(Color.lightGray);
				bA.setOpaque(true);
			} else if (e.getSource() == bB) {
				bB.setBackground(Color.lightGray);
				bB.setOpaque(true);
			} else if (e.getSource() == b7) {
				b7.setBackground(Color.lightGray);
				b7.setOpaque(true);
			} else if (e.getSource() == b8) {
				b8.setBackground(Color.lightGray);
				b8.setOpaque(true);
			} else if (e.getSource() == b9) {
				b9.setBackground(Color.lightGray);
				b9.setOpaque(true);
			} else if (e.getSource() == bC) {
				bC.setBackground(Color.lightGray);
				bC.setOpaque(true);
			} else if (e.getSource() == bD) {
				bD.setBackground(Color.lightGray);
				bD.setOpaque(true);
			} else if (e.getSource() == b4) {
				b4.setBackground(Color.lightGray);
				b4.setOpaque(true);
			} else if (e.getSource() == b5) {
				b5.setBackground(Color.lightGray);
				b5.setOpaque(true);
			} else if (e.getSource() == b6) {
				b6.setBackground(Color.lightGray);
				b6.setOpaque(true);
			} else if (e.getSource() == bE) {
				bE.setBackground(Color.lightGray);
				bE.setOpaque(true);
			} else if (e.getSource() == bF) {
				bF.setBackground(Color.lightGray);
				bF.setOpaque(true);
			} else if (e.getSource() == b1) {
				b1.setBackground(Color.lightGray);
				b1.setOpaque(true);
			} else if (e.getSource() == b2) {
				b2.setBackground(Color.lightGray);
				b2.setOpaque(true);
			} else if (e.getSource() == b3) {
				b3.setBackground(Color.lightGray);
				b3.setOpaque(true);
			}
			if (e.getSource() == plusMinus) {
				plusMinus.setBackground(Color.lightGray);
				plusMinus.setOpaque(true);
			} else if (e.getSource() == b0) {
				b0.setBackground(Color.lightGray);
				b0.setOpaque(true);
			}
		} else if (dec.getForeground() == lightBlue) {
			if (e.getSource() == b7) {
				b7.setBackground(Color.lightGray);
				b7.setOpaque(true);
			} else if (e.getSource() == b8) {
				b8.setBackground(Color.lightGray);
				b8.setOpaque(true);
			} else if (e.getSource() == b9) {
				b9.setBackground(Color.lightGray);
				b9.setOpaque(true);
			} else if (e.getSource() == b4) {
				b4.setBackground(Color.lightGray);
				b4.setOpaque(true);
			} else if (e.getSource() == b5) {
				b5.setBackground(Color.lightGray);
				b5.setOpaque(true);
			} else if (e.getSource() == b6) {
				b6.setBackground(Color.lightGray);
				b6.setOpaque(true);
			} else if (e.getSource() == b1) {
				b1.setBackground(Color.lightGray);
				b1.setOpaque(true);
			} else if (e.getSource() == b2) {
				b2.setBackground(Color.lightGray);
				b2.setOpaque(true);
			} else if (e.getSource() == b3) {
				b3.setBackground(Color.lightGray);
				b3.setOpaque(true);
			} else if (e.getSource() == b0) {
				b0.setBackground(Color.lightGray);
				b0.setOpaque(true);
			} else if (e.getSource() == bDot) {
				bDot.setBackground(Color.lightGray);
				bDot.setOpaque(true);
			}
		} else if (oct.getForeground() == lightBlue) {
			if (e.getSource() == b7) {
				b7.setBackground(Color.lightGray);
				b7.setOpaque(true);
			} else if (e.getSource() == b4) {
				b4.setBackground(Color.lightGray);
				b4.setOpaque(true);
			} else if (e.getSource() == b5) {
				b5.setBackground(Color.lightGray);
				b5.setOpaque(true);
			} else if (e.getSource() == b6) {
				b6.setBackground(Color.lightGray);
				b6.setOpaque(true);
			} else if (e.getSource() == b1) {
				b1.setBackground(Color.lightGray);
				b1.setOpaque(true);
			} else if (e.getSource() == b2) {
				b2.setBackground(Color.lightGray);
				b2.setOpaque(true);
			} else if (e.getSource() == b3) {
				b3.setBackground(Color.lightGray);
				b3.setOpaque(true);
			} else if (e.getSource() == b0) {
				b0.setBackground(Color.lightGray);
				b0.setOpaque(true);
			}
		} else if (bin.getForeground() == lightBlue) {
			if (e.getSource() == b1) {
				b1.setBackground(Color.lightGray);
				b1.setOpaque(true);
			} else if (e.getSource() == b0) {
				b0.setBackground(Color.lightGray);
				b0.setOpaque(true);
			}
		}
		if (e.getSource() == arrow) {
			arrow.setBackground(Color.lightGray);
			arrow.setOpaque(true);
		} else if (e.getSource() == mod) {
			mod.setBackground(Color.lightGray);
			mod.setOpaque(true);
		} else if (e.getSource() == CE) {
			CE.setBackground(Color.lightGray);
			CE.setOpaque(true);
		} else if (e.getSource() == C) {
			C.setBackground(Color.lightGray);
			C.setOpaque(true);
		} else if (e.getSource() == backspace) {
			backspace.setBackground(Color.lightGray);
			backspace.setOpaque(true);
		} else if (e.getSource() == div) {
			div.setBackground(Color.lightGray);
			div.setOpaque(true);
		} else if (e.getSource() == mul) {
			mul.setBackground(Color.lightGray);
			mul.setOpaque(true);
		} else if (e.getSource() == sub) {
			sub.setBackground(Color.lightGray);
			sub.setOpaque(true);
		} else if (e.getSource() == add) {
			add.setBackground(Color.lightGray);
			add.setOpaque(true);
		} else if (e.getSource() == openP) {
			openP.setBackground(Color.lightGray);
			openP.setOpaque(true);
		} else if (e.getSource() == closeP) {
			closeP.setBackground(Color.lightGray);
			closeP.setOpaque(true);
		} else if (e.getSource() == plusMinus) {
			plusMinus.setBackground(Color.lightGray);
			plusMinus.setOpaque(true);
		} else if (e.getSource() == equals) {
			equals.setBackground(Color.lightGray);
			equals.setOpaque(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (hex.getForeground() == lightBlue) {
			if (e.getSource() == bA) {
				bA.setBackground(grayish);
				bA.setOpaque(true);
			} else if (e.getSource() == bB) {
				bB.setBackground(grayish);
				bB.setOpaque(true);
			} else if (e.getSource() == b7) {
				b7.setBackground(grayish);
				b7.setOpaque(true);
			} else if (e.getSource() == b8) {
				b8.setBackground(grayish);
				b8.setOpaque(true);
			} else if (e.getSource() == b9) {
				b9.setBackground(grayish);
				b9.setOpaque(true);
			} else if (e.getSource() == bC) {
				bC.setBackground(grayish);
				bC.setOpaque(true);
			} else if (e.getSource() == bD) {
				bD.setBackground(grayish);
				bD.setOpaque(true);
			} else if (e.getSource() == b4) {
				b4.setBackground(grayish);
				b4.setOpaque(true);
			} else if (e.getSource() == b5) {
				b5.setBackground(grayish);
				b5.setOpaque(true);
			} else if (e.getSource() == b6) {
				b6.setBackground(grayish);
				b6.setOpaque(true);
			} else if (e.getSource() == bE) {
				bE.setBackground(grayish);
				bE.setOpaque(true);
			} else if (e.getSource() == bF) {
				bF.setBackground(grayish);
				bF.setOpaque(true);
			} else if (e.getSource() == b1) {
				b1.setBackground(grayish);
				b1.setOpaque(true);
			} else if (e.getSource() == b2) {
				b2.setBackground(grayish);
				b2.setOpaque(true);
			} else if (e.getSource() == b3) {
				b3.setBackground(grayish);
				b3.setOpaque(true);
			}
			if (e.getSource() == plusMinus) {
				plusMinus.setBackground(grayish);
				plusMinus.setOpaque(true);
			} else if (e.getSource() == b0) {
				b0.setBackground(grayish);
				b0.setOpaque(true);
			}
		} else if (dec.getForeground() == lightBlue) {
			if (e.getSource() == b7) {
				b7.setBackground(grayish);
				b7.setOpaque(true);
			} else if (e.getSource() == b8) {
				b8.setBackground(grayish);
				b8.setOpaque(true);
			} else if (e.getSource() == b9) {
				b9.setBackground(grayish);
				b9.setOpaque(true);
			} else if (e.getSource() == b4) {
				b4.setBackground(grayish);
				b4.setOpaque(true);
			} else if (e.getSource() == b5) {
				b5.setBackground(grayish);
				b5.setOpaque(true);
			} else if (e.getSource() == b6) {
				b6.setBackground(grayish);
				b6.setOpaque(true);
			} else if (e.getSource() == b1) {
				b1.setBackground(grayish);
				b1.setOpaque(true);
			} else if (e.getSource() == b2) {
				b2.setBackground(grayish);
				b2.setOpaque(true);
			} else if (e.getSource() == b3) {
				b3.setBackground(grayish);
				b3.setOpaque(true);
			} else if (e.getSource() == b0) {
				b0.setBackground(grayish);
				b0.setOpaque(true);
			} else if (e.getSource() == bDot) {
				bDot.setBackground(grayish);
				bDot.setOpaque(true);
			}
		} else if (oct.getForeground() == lightBlue) {
			if (e.getSource() == b7) {
				b7.setBackground(grayish);
				b7.setOpaque(true);
			} else if (e.getSource() == b4) {
				b4.setBackground(grayish);
				b4.setOpaque(true);
			} else if (e.getSource() == b5) {
				b5.setBackground(grayish);
				b5.setOpaque(true);
			} else if (e.getSource() == b6) {
				b6.setBackground(grayish);
				b6.setOpaque(true);
			} else if (e.getSource() == b1) {
				b1.setBackground(grayish);
				b1.setOpaque(true);
			} else if (e.getSource() == b2) {
				b2.setBackground(grayish);
				b2.setOpaque(true);
			} else if (e.getSource() == b3) {
				b3.setBackground(grayish);
				b3.setOpaque(true);
			} else if (e.getSource() == b0) {
				b0.setBackground(grayish);
				b0.setOpaque(true);
			}
		} else if (bin.getForeground() == lightBlue) {
			if (e.getSource() == b1) {
				b1.setBackground(grayish);
				b1.setOpaque(true);
			} else if (e.getSource() == b0) {
				b0.setBackground(grayish);
				b0.setOpaque(true);
			}
		}
		if (e.getSource() == arrow) {
			arrow.setBackground(grayish);
			arrow.setOpaque(true);
		} else if (e.getSource() == mod) {
			mod.setBackground(grayish);
			mod.setOpaque(true);
		} else if (e.getSource() == CE) {
			CE.setBackground(grayish);
			CE.setOpaque(true);
		} else if (e.getSource() == C) {
			C.setBackground(grayish);
			C.setOpaque(true);
		} else if (e.getSource() == backspace) {
			backspace.setBackground(grayish);
			backspace.setOpaque(true);
		} else if (e.getSource() == div) {
			div.setBackground(grayish);
			div.setOpaque(true);
		} else if (e.getSource() == mul) {
			mul.setBackground(grayish);
			mul.setOpaque(true);
		} else if (e.getSource() == sub) {
			sub.setBackground(grayish);
			sub.setOpaque(true);
		} else if (e.getSource() == add) {
			add.setBackground(grayish);
			add.setOpaque(true);
		} else if (e.getSource() == openP) {
			openP.setBackground(grayish);
			openP.setOpaque(true);
		} else if (e.getSource() == closeP) {
			closeP.setBackground(grayish);
			closeP.setOpaque(true);
		} else if (e.getSource() == plusMinus) {
			plusMinus.setBackground(grayish);
			plusMinus.setOpaque(true);
		} else if (e.getSource() == equals) {
			equals.setBackground(grayish);
			equals.setOpaque(true);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == arrow) {
			arrow.setBackground(lighterGray);
			arrow.setOpaque(true);
		} else if (e.getSource() == mod) {
			mod.setBackground(lighterGray);
			mod.setOpaque(true);
		} else if (e.getSource() == CE) {
			CE.setBackground(lighterGray);
			CE.setOpaque(true);
		} else if (e.getSource() == C) {
			C.setBackground(lighterGray);
			C.setOpaque(true);
		} else if (e.getSource() == backspace) {
			backspace.setBackground(lighterGray);
			backspace.setOpaque(true);
		} else if (e.getSource() == div) {
			div.setBackground(lighterGray);
			div.setOpaque(true);
		} else if (e.getSource() == bA) {
			bA.setBackground(lighterGray);
			bA.setOpaque(true);
		} else if (e.getSource() == bB) {
			bB.setBackground(lighterGray);
			bB.setOpaque(true);
		} else if (e.getSource() == b7) {
			b7.setBackground(lighterGray);
			b7.setOpaque(true);
		} else if (e.getSource() == b8) {
			b8.setBackground(lighterGray);
			b8.setOpaque(true);
		} else if (e.getSource() == b9) {
			b9.setBackground(lighterGray);
			b9.setOpaque(true);
		} else if (e.getSource() == mul) {
			mul.setBackground(lighterGray);
			mul.setOpaque(true);
		} else if (e.getSource() == bC) {
			bC.setBackground(lighterGray);
			bC.setOpaque(true);
		} else if (e.getSource() == bD) {
			bD.setBackground(lighterGray);
			bD.setOpaque(true);
		} else if (e.getSource() == b4) {
			b4.setBackground(lighterGray);
			b4.setOpaque(true);
		} else if (e.getSource() == b5) {
			b5.setBackground(lighterGray);
			b5.setOpaque(true);
		} else if (e.getSource() == b6) {
			b6.setBackground(lighterGray);
			b6.setOpaque(true);
		} else if (e.getSource() == sub) {
			sub.setBackground(lighterGray);
			sub.setOpaque(true);
		} else if (e.getSource() == bE) {
			bE.setBackground(lighterGray);
			bE.setOpaque(true);
		} else if (e.getSource() == bF) {
			bF.setBackground(lighterGray);
			bF.setOpaque(true);
		} else if (e.getSource() == b1) {
			b1.setBackground(lighterGray);
			b1.setOpaque(true);
		} else if (e.getSource() == b2) {
			b2.setBackground(lighterGray);
			b2.setOpaque(true);
		} else if (e.getSource() == b3) {
			b3.setBackground(lighterGray);
			b3.setOpaque(true);
		} else if (e.getSource() == add) {
			add.setBackground(lighterGray);
			add.setOpaque(true);
		} else if (e.getSource() == openP) {
			openP.setBackground(lighterGray);
			openP.setOpaque(true);
		} else if (e.getSource() == closeP) {
			closeP.setBackground(lighterGray);
			closeP.setOpaque(true);
		} else if (e.getSource() == plusMinus) {
			plusMinus.setBackground(lighterGray);
			plusMinus.setOpaque(true);
		} else if (e.getSource() == b0) {
			b0.setBackground(lighterGray);
			b0.setOpaque(true);
		} else if (e.getSource() == bDot) {
			bDot.setBackground(lighterGray);
			bDot.setOpaque(true);
		} else if (e.getSource() == equals) {
			equals.setBackground(lighterGray);
			equals.setOpaque(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
