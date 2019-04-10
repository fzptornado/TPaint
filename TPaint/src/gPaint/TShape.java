package gPaint;

import java.util.*;
import java.awt.Color;
import java.awt.Point;

public class TShape {

	public List<Point> points;
	public shapeType type;
	public Color color;
	
	public TShape(List<Point> p,shapeType t,Color c){
		this.points = p;
		this.type = t;
		this.color = c;
	}
}


