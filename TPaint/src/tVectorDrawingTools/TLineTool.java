package tVectorDrawingTools;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import tShapes.DashType;
import tShapes.TLine;
import tShapes.TShape;

public class TLineTool extends TVectorDrawingTool {
	public TLineTool(TShape shape, Boolean isMousePressed, List<TShape> shapes) {
		super(shape, isMousePressed, shapes);
		// TODO Auto-generated constructor stub
	}

	private TLine line;

	

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
			this.line = new TLine(Color.black, 2, DashType.simple, arg0.getPoint(), null);
			this.getShapes().add(this.line);
		}
	}

	@Override
	public void toolMouseReleased(MouseEvent arg0) {
		if (this.getIsMousePressed()) {
			this.setIsMousePressed(false);
			line.setP2(arg0.getPoint());
		}
	}

}
