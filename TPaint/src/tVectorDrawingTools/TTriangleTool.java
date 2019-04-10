package tVectorDrawingTools;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import tShapes.DashType;
import tShapes.TOval;
import tShapes.TPolygon;
import tShapes.TShape;

public class TTriangleTool extends TVectorDrawingTool {

	private TPolygon triangle;

	public TTriangleTool(TShape shape, Boolean isMousePressed, List<TShape> shapes) {
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
			this.triangle = new TPolygon(Color.black, 2, DashType.simple, new ArrayList<Point>(), false);
			this.triangle.addPoint(arg0.getPoint());
			this.getShapes().add(this.triangle);
		} else {
			Point p1 = this.triangle.getPoints().get(0);
			Point p2 = arg0.getPoint();
			if (this.triangle.getPoints().size() == 2) {
				this.triangle.addPoint(p2);
				this.triangle.addPoint(p1);
				this.setIsMousePressed(false);
			} else {
				this.triangle.addPoint(p2);

			}
		}

	}

	@Override
	public void toolMouseReleased(MouseEvent arg0) {
	}

}
