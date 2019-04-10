package tShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

public class TPolygon extends TMultiplePointShape{

	private Boolean isFilled;
	public TPolygon(Color borderColor, double borderWidth, DashType borderDashType, List<Point> points,Boolean isFilled) {
		super(borderColor, borderWidth, borderDashType, points);
		this.isFilled = isFilled;
	}
	
	
	public Boolean getIsFilled() {
		return isFilled;
	}


	public void setIsFilled(Boolean isFilled) {
		this.isFilled = isFilled;
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
		g2.setColor(this.getBorderColor());
		Point p1 = new Point();
		Point p2 = new Point();
		for (int i = 0; i < this.getPoints().size() - 1; i++) {
			p1 = this.getPoints().get(i);
			p2 = this.getPoints().get(i + 1);
			g2.drawLine(p1.x, p1.y, p2.x, p2.y);
		}
		p2 = this.getPoints().get(this.getPoints().size() - 1);
		g2.drawLine(p2.x, p2.y, estimatedPoint.x, estimatedPoint.y);
	}


	@Override
	public void addPoint(Point point) {
		this.getPoints().add(point);
		
	}

}
