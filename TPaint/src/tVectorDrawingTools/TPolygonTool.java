package tVectorDrawingTools;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import tShapes.DashType;
import tShapes.TPolygon;
import tShapes.TShape;

public class TPolygonTool extends TVectorDrawingTool {

	private TPolygon poly;

	public TPolygonTool(TShape shape, Boolean isMousePressed, List<TShape> shapes) {
		super(shape, isMousePressed, shapes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void toolMouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toolMouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toolMouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toolMouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toolMouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toolMousePressed(MouseEvent arg0) {
		if (!this.getIsMousePressed()) {
			this.setIsMousePressed(true);
			this.poly = new TPolygon(Color.black, 2, DashType.simple, new ArrayList<Point>(), false);
			this.poly.addPoint(arg0.getPoint());
			this.getShapes().add(this.poly);
		} else {

			Point p1 = this.poly.getPoints().get(0);
			Point p2 = arg0.getPoint();
			if (isExitDrawPolygon(p1, p2) && this.poly.getPoints().size() >= 2) {
				this.poly.addPoint(p1);
				this.setIsMousePressed(false);
			} else {
				this.poly.addPoint(p2);
			}

		}

	}

	@Override
	public void toolMouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	private Boolean isExitDrawPolygon(Point p1, Point p2) {
		double distance = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
		if (distance < 10)
			return true;
		return false;
	}

}
