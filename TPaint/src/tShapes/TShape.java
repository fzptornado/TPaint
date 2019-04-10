package tShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class TShape{

	private Color borderColor;
	private double borderWidth;
	private DashType borderDashType;
	
	
	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public double getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(double borderWidth) {
		this.borderWidth = borderWidth;
	}

	public DashType getBorderDashType() {
		return borderDashType;
	}

	public void setBorderDashType(DashType borderDashType) {
		this.borderDashType = borderDashType;
	}


	
	public TShape(Color borderColor, double borderWidth, DashType borderDashType) {
		super();
		this.borderColor = borderColor;
		this.borderWidth = borderWidth;
		this.borderDashType = borderDashType;
	}


	public void Draw(Graphics g){		
		
	}
	
	public void Draw(Graphics g,Point estimatedPoint){		
		
	}

	
}
