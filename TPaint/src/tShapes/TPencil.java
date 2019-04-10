package tShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

public class TPencil extends TMultiplePointShape {

	public TPencil(Color borderColor, double borderWidth, DashType borderDashType, List<Point> points) {
		super(borderColor, borderWidth, borderDashType, points);
	}

	@Override
	public void Draw(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.getBorderColor());
		for (int i = 0; i < this.getPoints().size() - 1; i++) {
			Point p1 = this.getPoints().get(i);
			Point p2 = this.getPoints().get(i + 1);
			g2.drawLine(p1.x, p1.y, p2.x, p2.y);
		}
	}

	@Override
	public void Draw(Graphics g, Point estimatedPoint) {
		Graphics2D g2 = (Graphics2D) g;
		Point p1=new Point();
		Point p2=new Point();
		g2.setColor(this.getBorderColor());
		for (int i = 0; i < this.getPoints().size() - 1; i++) {
			p1 = this.getPoints().get(i);
			p2 = this.getPoints().get(i + 1);
			g2.drawLine(p1.x, p1.y, p2.x, p2.y);
		}
		g2.drawLine(p2.x, p2.y, estimatedPoint.x, estimatedPoint.y);
		
	}

	@Override
	public void addPoint(Point point) {
		this.getPoints().add(point);
		
	}

	

}
