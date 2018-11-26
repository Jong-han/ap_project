package kr.ac.halla.h02404.swing.lecture7;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class P3OptionDialog extends JFrame {

	JFrame frame = this;
	JTextArea rcode = null;
	JButton sbutton = null;
	JLabel text = null;

	public P3OptionDialog() {
		setTitle("Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout());

		text = new JLabel("The answer will be shown");
		contentPane.add(text);
		JButton submit = new JButton("Open JOptionPane");
		contentPane.add(submit);

		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frame, "Y, N, or cancel");
				if (result == JOptionPane.OK_OPTION)
					text.setText("YES");
				else if (result == JOptionPane.NO_OPTION)
					text.setText("NO");
				else if (result == JOptionPane.CANCEL_OPTION)
					text.setText("Cancel");
			}
		});

		setSize(300, 150);
		setVisible(true);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		P3OptionDialog frame = new P3OptionDialog();
	}
}
