package tShapes;

import java.awt.Color;
import java.awt.Point;

public abstract class T2PShape extends TShape {
	private Point p1;
	private Point p2;

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public T2PShape(Color borderColor, double borderWidth, DashType borderDashType, Point p1, Point p2) {
		super(borderColor, borderWidth, borderDashType);
		this.p1 = p1;
		this.p2 = p2;
	}
	

}
