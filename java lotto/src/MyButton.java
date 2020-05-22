import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class MyButton extends JButton{
	private Color txtColor = Color.black;
	private Color bgColor = Color.blue;
	public MyButton(String name) {
		super(name);
		setBorderPainted(false);
		setOpaque(false);
	}
	public void setTxtColor(Color c) {
		txtColor = c;
	}
	public void setBgColor(Color c) {
		bgColor = c;
	}
	@Override
	public void paint(Graphics g) {
		int w = getWidth();
		int h = getHeight();
		
		g.setColor(bgColor);
		g.fillRoundRect(0, 0, w, h, 50, 50);
		
		g.setColor(txtColor);
		g.drawString(getText(), getWidth()/2-12, getWidth()/2+3);
		
	}
}
