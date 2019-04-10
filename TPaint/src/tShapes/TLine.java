package tShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class TLine extends T2PShape {

	

	public TLine(Color borderColor, double borderWidth, DashType borderDashType, Point p1, Point p2) {
		super(borderColor, borderWidth, borderDashType, p1, p2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.getBorderColor());
		g2.drawLine(this.getP1().x, this.getP1().y, this.getP2().x, this.getP2().y);
	}
	
	@Override
	public void Draw(Graphics g, Point estimatedPoint) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.getBorderColor());
		g2.drawLine(this.getP1().x, this.getP1().y, estimatedPoint.x, estimatedPoint.y);
	}


}
