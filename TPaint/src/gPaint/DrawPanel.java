package gPaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;

import javax.swing.JComponent;

public class DrawPanel extends JComponent implements MouseMotionListener, MouseListener {
	private boolean isMousePressed = false;
	private shapeType shapeType;
	private List<TShape> shapes;
	private Color color;
	Point p1;
	Point p2;
	Point pTemp;

	private InfoPanel infoPanel;

	public DrawPanel(InfoPanel infoPanel) {
		super();
		this.infoPanel = infoPanel;
		this.setPreferredSize(new Dimension(TMain.tWidth - 240, TMain.tHeight - 50));
		this.setBackground(Color.gray);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		this.shapeType = shapeType.Oval;
		shapes = new ArrayList<TShape>();

		p1 = new Point();
		p2 = new Point();

		color = Color.black;
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		this.Initialize(g);

		g.setColor(Color.GREEN);

		for (int i = 0; i < shapes.size();i++) {
			TShape tShape = shapes.get(i);
			TShape tempShape = new TShape(new ArrayList<>(tShape.points), tShape.type, tShape.color);
			if(isMousePressed && (i+1)==shapes.size())
				tempShape.points.add(pTemp);
			switch (tempShape.type) {
			case line:
				drawLine(g, tempShape);
				break;
			case rectangle:
				drawRectangle(g, tempShape);
				break;

			case Oval:
				drawOval(g, tempShape);
				break;
			case Polygon:
				drawPolygon(g, tempShape);
				break;
			case pencil:
				drawPolygon(g, tempShape);
				break;
			case triangle:
				drawPolygon(g, tempShape);
				break;
			default:
				break;
			}
		}

	}

	public void setShapeType(shapeType type) {
		this.shapeType = type;
		this.isMousePressed = false;
		repaint();
	}

	private void Initialize(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.darkGray);
		g2.setColor(new Color(210, 210, 210));
		g2.drawRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
		g2.fillRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
	}

	private void drawLine(Graphics g, TShape shape) {

		Point p1 = shape.points.get(0);
		Point p2 = shape.points.get(1);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(shape.color);
		g2.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

	private void drawRectangle(Graphics g, TShape shape) {

		Point p1 = shape.points.get(0);
		Point p2 = shape.points.get(1);
		int x = Math.min(p1.x, p2.x);
		int y = Math.min(p1.y, p2.y);
		int width = Math.abs(p1.x - p2.x);
		int height = Math.abs(p1.y - p2.y);

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(shape.color);
		g2.drawRect(x, y, width, height);
	}

	private void drawOval(Graphics g, TShape shape) {

		Point p1 = shape.points.get(0);
		Point p2 = shape.points.get(1);
		int x = Math.min(p1.x, p2.x);
		int y = Math.min(p1.y, p2.y);
		int width = Math.abs(p1.x - p2.x);
		int height = Math.abs(p1.y - p2.y);

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(shape.color);
		g2.drawOval(x, y, width, height);
	}

	private void drawPolygon(Graphics g, TShape shape) {

		int x = Math.min(p1.x, p2.x);
		int y = Math.min(p1.y, p2.y);
		int width = Math.abs(p1.x - p2.x);
		int height = Math.abs(p1.y - p2.y);

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(shape.color);
		for (int i = 0; i < shape.points.size() - 1; i++) {
			Point p1 = shape.points.get(i);
			Point p2 = shape.points.get(i + 1);
			g2.drawLine(p1.x, p1.y, p2.x, p2.y);
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.infoPanel.setXYLocation(e.getPoint());
		this.setToolTipText(e.getX() + " " + e.getY());
		if (this.shapeType == shapeType.pencil) {
			p1 = e.getPoint();
			this.shapes.get(this.shapes.size() - 1).points.add(p1);
		}

		//p2 = e.getPoint();
		pTemp = e.getPoint();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.infoPanel.setXYLocation(e.getPoint());
		this.setToolTipText(e.getX() + " " + e.getY());
		pTemp = e.getPoint();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// this.infoPanel.setMousePressedLocation(e.getPoint());

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.infoPanel.setMousePressedLocation(e.getPoint());
		if (!this.isMousePressed) {
			this.isMousePressed = true;
			p1 = e.getPoint();
			List<Point> points = new ArrayList<Point>();
			this.shapes.add(new TShape(points, this.shapeType, this.color));
			this.shapes.get(this.shapes.size() - 1).points.add(p1);
		}
		else{
			if (this.shapeType == shapeType.Polygon) {
				p1 = this.shapes.get(this.shapes.size() - 1).points.get(0);
				p2 = e.getPoint();
				if (isExitDrawPolygon(p1, p2) && this.shapes.get(this.shapes.size() - 1).points.size() >= 2) {
					this.shapes.get(this.shapes.size() - 1).points.add(p1);
					this.isMousePressed = false;
				} else {
					this.shapes.get(this.shapes.size() - 1).points.add(p2);
				}
			}
			else if (this.shapeType == shapeType.triangle) {
				p1 = this.shapes.get(this.shapes.size() - 1).points.get(0);
				p2 = e.getPoint();
				if (this.shapes.get(this.shapes.size() - 1).points.size() == 2) {
					this.shapes.get(this.shapes.size() - 1).points.add(p2);
					this.shapes.get(this.shapes.size() - 1).points.add(p1);
					this.isMousePressed = false;
				} else {
					this.shapes.get(this.shapes.size() - 1).points.add(p2);
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.infoPanel.setMouseReleasedLocation(e.getPoint());
		if (this.isMousePressed) {

			if (this.shapeType == shapeType.pencil) {
				this.isMousePressed = false;
				p2 = e.getPoint();
				this.shapes.get(this.shapes.size() - 1).points.add(p2);
			} 
			else if (this.shapeType == shapeType.triangle || this.shapeType == shapeType.Polygon){
				
			}
			else {
				this.isMousePressed = false;
				List<Point> points = new ArrayList<Point>();
				p2 = e.getPoint();
				this.shapes.get(this.shapes.size() - 1).points.add(p2);
			}
			this.repaint();
			p1 = new Point();
			p2 = new Point();
		}

	}

	public void clearPanel() {
		shapes.clear();
		repaint();
	}

	private Boolean isExitDrawPolygon(Point p1, Point p2) {
		double distance = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
		if (distance < 10)
			return true;
		return false;
	}
}
