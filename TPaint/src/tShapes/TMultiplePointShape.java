package tShapes;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

public abstract class TMultiplePointShape extends TShape {
	private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public TMultiplePointShape(Color borderColor, double borderWidth, DashType borderDashType, List<Point> points) {
		super(borderColor, borderWidth, borderDashType);
		this.points = points;
	}
	public abstract void addPoint(Point point);
	
}
