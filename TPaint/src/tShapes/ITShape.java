package tShapes;

import java.awt.Graphics;
import java.awt.Point;

public interface ITShape{

	public void Draw(Graphics g);
	public void Draw(Graphics g,Point estimatedPoint);
}
