package com.pengjun.main;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);

		int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth();
		int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight();
		frame.setLocation((screenWidth - frame.getWidth()) / 2,
				(screenHeight - frame.getHeight()) / 2);
	}

}
