package sk.racek;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class SliderFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 660;
	private static final int DEFAULT_HEIGHT = 250;
	private static final int SLIDER_MIN_VALUE = 0;
	private static final int SLIDER_MAX_VALUE = 255;

	private int valueR = 0;
	private int valueG = 0;
	private int valueB = 0;

	private Font font = new Font("Serif", Font.ITALIC, 15);

	private JPanel panel = new JPanel();

	private JSlider rRGBSlider;
	private JSlider gRGBSlider;
	private JSlider bRGBSlider;

	private JLabel sliderLabelR = new JLabel("R value");
	private JLabel sliderLabelG = new JLabel("G value");
	private JLabel sliderLabelB = new JLabel("B value");

	private JButton okButton = new JButton("OK");
	private JButton cancelButton = new JButton("CANCEL");

	public SliderFrame(ColorChanelFrame frame) {
		addSlidersToPanel(panel);
		panel.add(okButton);
		panel.add(cancelButton);
		add(panel);

		okButton.addActionListener((ActionEvent e) -> {
			frame.setR(rRGBSlider.getValue());
			frame.setG(gRGBSlider.getValue());
			frame.setB(bRGBSlider.getValue());
			frame.getJPanel()
					.setBackground(new Color(rRGBSlider.getValue(), gRGBSlider.getValue(), bRGBSlider.getValue()));
			setVisible(false);
		});

		cancelButton.addActionListener((ActionEvent e) -> {
			setVisible(false);
		});

		setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		pack();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	private void addSlidersToPanel(JPanel panel) {
		rRGBSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, valueR);
		gRGBSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, valueG);
		bRGBSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, valueB);

		rRGBSlider.setPaintTicks(true);
		rRGBSlider.setPaintLabels(true);
		rRGBSlider.setMinorTickSpacing(5);
		rRGBSlider.setMajorTickSpacing(15);
		rRGBSlider.setFont(font);
		rRGBSlider.setPreferredSize(new Dimension(600, 60));
		panel.add(sliderLabelR, BorderLayout.CENTER);
		panel.add(rRGBSlider, BorderLayout.CENTER);

		gRGBSlider.setPaintTicks(true);
		gRGBSlider.setPaintLabels(true);
		gRGBSlider.setMinorTickSpacing(5);
		gRGBSlider.setMajorTickSpacing(15);
		gRGBSlider.setFont(font);
		gRGBSlider.setPreferredSize(new Dimension(600, 60));
		panel.add(sliderLabelG, BorderLayout.CENTER);
		panel.add(gRGBSlider, BorderLayout.CENTER);

		bRGBSlider.setPaintTicks(true);
		bRGBSlider.setPaintLabels(true);
		bRGBSlider.setMinorTickSpacing(5);
		bRGBSlider.setMajorTickSpacing(15);
		bRGBSlider.setFont(font);
		bRGBSlider.setPreferredSize(new Dimension(600, 60));
		panel.add(sliderLabelB, BorderLayout.CENTER);
		panel.add(bRGBSlider, BorderLayout.CENTER);
	}

	public void setrRGBSliderValue(int r) {
		this.rRGBSlider.setValue(r);
	}

	public void setgRGBSliderValue(int g) {
		this.gRGBSlider.setValue(g);
	}

	public void setbRGBSliderValue(int b) {
		this.bRGBSlider.setValue(b);
	}
}
