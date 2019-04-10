package tShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class T2PCloseShape extends T2PShape {

	
	private Color bgColor;
	private Boolean isFilled;
	public Color getBgColor() {
		return bgColor;
	}
	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}
	public Boolean getIsFilled() {
		return isFilled;
	}
	public void setIsFilled(Boolean isFilled) {
		this.isFilled = isFilled;
	}
	public T2PCloseShape(Color borderColor, double borderWidth, DashType borderDashType, Point p1, Point p2,Color bgColor,Boolean isFilled) {
		super(borderColor, borderWidth, borderDashType, p1, p2);

		this.bgColor = bgColor;
		this.isFilled = isFilled;
	}
}
