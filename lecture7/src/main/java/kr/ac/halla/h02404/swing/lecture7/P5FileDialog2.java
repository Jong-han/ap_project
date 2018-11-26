package kr.ac.halla.h02404.swing.lecture7;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class P5FileDialog2 extends JFrame {

	JFrame frame = this;
	JTextArea rcode = null;
	JButton sbutton = null;
	JTextArea area = null;

	public P5FileDialog2() {
		setTitle("Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout());

		JLabel text = new JLabel("The text will be shown");
		contentPane.add(text);
		JButton submit = new JButton("Open File Save Dialog");
		contentPane.add(submit);
		area = new JTextArea(20, 20);
		contentPane.add(area);

		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int result = chooser.showSaveDialog(frame);

				// Return if no file choosen
				if (result != JFileChooser.APPROVE_OPTION)
					return;

				String filePath = chooser.getSelectedFile().getPath();

				BufferedWriter writer;
				try {
					writer = new BufferedWriter(new FileWriter(filePath));
					writer.write(area.getText());
					writer.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});

		setSize(300, 450);
		setVisible(true);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		P5FileDialog2 frame = new P5FileDialog2();
	}
}
