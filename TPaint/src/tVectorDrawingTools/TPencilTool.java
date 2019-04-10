package tVectorDrawingTools;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import tShapes.DashType;
import tShapes.TPencil;
import tShapes.TPolygon;
import tShapes.TShape;

public class TPencilTool extends TVectorDrawingTool {
	private TPencil pencil;

	public TPencilTool(TShape shape, Boolean isMousePressed, List<TShape> shapes) {
		super(shape, isMousePressed, shapes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void toolMouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (this.getIsMousePressed()) {

			this.pencil.addPoint(arg0.getPoint());
		}
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
			this.pencil = new TPencil(Color.black, 2, DashType.simple, new ArrayList<Point>());
			this.pencil.addPoint(arg0.getPoint());
			this.getShapes().add(this.pencil);
		}

	}

	@Override
	public void toolMouseReleased(MouseEvent arg0) {
		if (this.getIsMousePressed()) {

			this.setIsMousePressed(false);
			this.pencil.addPoint(arg0.getPoint());
		}

	}

}
