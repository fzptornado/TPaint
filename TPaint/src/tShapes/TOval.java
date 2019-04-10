package tShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class TOval extends T2PCloseShape {

	

	public TOval(Color borderColor, double borderWidth, DashType borderDashType, Point p1, Point p2, Color bgColor,
			Boolean isFilled) {
		super(borderColor, borderWidth, borderDashType, p1, p2, bgColor, isFilled);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Draw(Graphics g) {
		Point p1 = this.getP1();
		Point p2 = this.getP2();
		int x = Math.min(p1.x, p2.x);
		int y = Math.min(p1.y, p2.y);
		int width = Math.abs(p1.x - p2.x);
		int height = Math.abs(p1.y - p2.y);

		Graphics2D g2 = (Graphics2D) g;
		
		if(this.getIsFilled()){
			g2.setBackground(this.getBgColor());
			g2.fillOval(x, y, width, height);
		}
		g2.setColor(this.getBorderColor());
		g2.drawOval(x, y, width, height);
		
				
	}
	
	@Override
	public void Draw(Graphics g, Point estimatedPoint) {
		Point p1 = this.getP1();
		Point p2 = estimatedPoint;
		int x = Math.min(p1.x, p2.x);
		int y = Math.min(p1.y, p2.y);
		int width = Math.abs(p1.x - p2.x);
		int height = Math.abs(p1.y - p2.y);

		Graphics2D g2 = (Graphics2D) g;
		
		if(this.getIsFilled()){
			g2.setBackground(this.getBgColor());
			g2.fillOval(x, y, width, height);
		}
		g2.setColor(this.getBorderColor());
		g2.drawOval(x, y, width, height);
	}

}
