package sk.racek;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorChanelFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;

	private int r = 0;
	private int g = 0;
	private int b = 0;

	private JPanel mainPanel = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Color Chooser");
	private JMenuItem colorChanelMenuItem = new JMenuItem("Color Channels...");
	private JMenuItem exitMenuItem = new JMenuItem("Exit");

	SliderFrame sliderFrame = new SliderFrame(this);

	public ColorChanelFrame() {
		createMenu();
		add(mainPanel);

		colorChanelMenuItem.addActionListener((ActionEvent e) -> {
			sliderFrame.setVisible(true);
			sliderFrame.setrRGBSliderValue(r);
			sliderFrame.setgRGBSliderValue(g);
			sliderFrame.setbRGBSliderValue(b);
		});

		exitMenuItem.addActionListener((ActionEvent e) -> {
			sliderFrame.dispose();
			this.dispose();
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		pack();
	}

	private void createMenu() {
		menuBar.add(menu);
		menu.add(colorChanelMenuItem);
		menu.addSeparator();
		menu.add(exitMenuItem);
		setJMenuBar(menuBar);
	}

	public JPanel getJPanel() {
		return mainPanel;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public void setR(int r) {
		this.r = r;
	}

	public void setG(int g) {
		this.g = g;
	}

	public void setB(int b) {
		this.b = b;
	}
}
