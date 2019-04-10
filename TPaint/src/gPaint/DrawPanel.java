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

import tShapes.TShape;
import tVectorDrawingTools.TVectorDrawingTool;
import tVectorDrawingTools.TVectorDrawingToolFactory;

public class DrawPanel extends JComponent implements MouseMotionListener, MouseListener {
	private boolean isMousePressed = false;	
	private shapeType shapeType;
	private TVectorDrawingTool vdTool;
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
						
			if(vdTool.getIsMousePressed() && (i+1)==shapes.size())
				shapes.get(i).Draw(g,pTemp);
			else
				shapes.get(i).Draw(g);
				
		}

	}

	public void setShapeType(shapeType type) {
		this.shapeType = type;
		this.isMousePressed = false;
		this.vdTool = TVectorDrawingToolFactory.getTVectorDrawingTool(this.shapeType, null, this.isMousePressed, this.shapes);
		repaint();
	}

	private void Initialize(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.darkGray);
		g2.setColor(new Color(210, 210, 210));
		g2.drawRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
		g2.fillRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.infoPanel.setXYLocation(e.getPoint());
		this.setToolTipText(e.getX() + " " + e.getY());		
		pTemp = e.getPoint();
		this.vdTool.mouseDragged(e);
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
		this.vdTool.mousePressed(e);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.infoPanel.setMouseReleasedLocation(e.getPoint());
		this.vdTool.mouseReleased(e);

	}

	public void clearPanel() {
		shapes.clear();
		repaint();
	}	
}
