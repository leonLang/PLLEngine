//peter
package com.PLLEngine.Scene;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.PLLEngine.Scene.layerComponents.Button;
import com.PLLEngine.Scene.layerComponents.Text;

@SuppressWarnings("serial")
public class GUI extends JPanel implements SceneComponentInterface {

	private Text[] text;
	private JLabel[] labels;
	private Button[] button;
	private JButton[] buttons;

	// Layout fields
	private String stringLayout;
	private String align;

	public GUI() {
		//System.out.println(BorderLayout.PAGE_START);	//First
		//System.out.println(BorderLayout.PAGE_END);		//Last
		//System.out.println(BorderLayout.LINE_START);	//Before
		//System.out.println(BorderLayout.LINE_END);		//After
		//System.out.println(BorderLayout.CENTER);		//Center
	}

	@Override
	public void draw(Graphics2D g) {

	}

	public Text[] getText() {
		return text;
	}

	public void setText(Text[] text) {
		this.text = text;
		labels = new JLabel[text.length];
		for (int i = 0; i < text.length; i++) {
			labels[i] = new JLabel();
			labels[i].setText(text[i].getText());
			this.add(labels[i]);
		}
	}

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
		buttons = new JButton[button.length];
		for (int i = 0; i < button.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setText(button[i].getText());
			switch (this.stringLayout) {
			case "BorderLayout":
				this.setPreferredSize(new Dimension(button[i].getWidth(),button[i].getHeight()));
				this.add(buttons[i],button[i].getAlign());
				break;
			case "BoxLayout":
				this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
				
				break;
			case "GridLayout":
				this.setLayout(new GridLayout());
				break;
			case "GridBagLayout":
				this.setLayout(new GridBagLayout());
				break;
			default:

			}
		}

	}

	public String getStringLayout() {
		return stringLayout;
	}

	public void setStringLayout(String stringLayout) {
		this.stringLayout = stringLayout;
		switch (stringLayout) {
		case "BorderLayout":
			this.setLayout(new BorderLayout());
			break;
		case "BoxLayout":
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			break;
		case "GridLayout":
			this.setLayout(new GridLayout());
			break;
		case "GridBagLayout":
			this.setLayout(new GridBagLayout());
			break;
		default:

		}
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

}
