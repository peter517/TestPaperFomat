package text;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShowPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextArea textArea;

	public ShowPanel() {
		textArea = new JTextArea(30, 30);
		this.add(textArea, BorderLayout.NORTH);
	}

	public String getTextStr() {
		return textArea.getText();
	}

	public void setTextStr(String str) {
		textArea.setText(str);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
