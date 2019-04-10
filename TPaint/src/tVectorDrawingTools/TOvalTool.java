package tVectorDrawingTools;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import tShapes.DashType;
import tShapes.TOval;
import tShapes.TRect;
import tShapes.TShape;

public class TOvalTool extends TVectorDrawingTool{

	private TOval oval;
	public TOvalTool(TShape shape, Boolean isMousePressed, List<TShape> shapes) {
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
			this.oval = new TOval(Color.BLACK, 2, DashType.simple, arg0.getPoint(), null, null, false);
			this.getShapes().add(this.oval);
		}		
	}

	@Override
	public void toolMouseReleased(MouseEvent arg0) {
		if (this.getIsMousePressed()) {
			this.setIsMousePressed(false);
			this.oval.setP2(arg0.getPoint());
		}
		
	}

}
