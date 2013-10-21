package text;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.pengjun.utils.SwingUtils;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private ShowPanel showPanel;
	protected ControllerPanel ctrlPanle;

	public MainFrame() {
		showPanel = new ShowPanel();
		ctrlPanle = new ControllerPanel();
		this.add(showPanel, BorderLayout.CENTER);
		this.add(ctrlPanle, BorderLayout.PAGE_END);
	}

	private class ControllerPanel extends JPanel {

		private static final long serialVersionUID = 1L;
		private JButton button = new JButton("开始转换");

		public ControllerPanel() {
			this.add(button, BorderLayout.SOUTH);
			this.button.addActionListener(startListener);
		}

		private ActionListener startListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] contentArr = showPanel.getTextStr().split("\n");
				List<String> strList = new ArrayList<String>();
				for (String str : contentArr) {
					strList.add(TextProcess.formatSingleLine(str));
				}
				StringBuffer sb = new StringBuffer();
				for (String str : strList) {
					sb.append(str);
					sb.append("\n");
				}

				showPanel.setTextStr(sb.toString());
			}
		};

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}
	}

	public static void main(String[] args) {

		MainFrame frame = new MainFrame();

		SwingUtils.createFrame(frame, 800, 450);
		SwingUtils.setFrameCenter(frame);

	}

}
