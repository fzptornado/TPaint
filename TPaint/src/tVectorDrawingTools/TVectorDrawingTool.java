package tVectorDrawingTools;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import tShapes.TShape;

public abstract class TVectorDrawingTool implements MouseListener, MouseMotionListener {
	

	private TShape shape;
	private Boolean isMousePressed;
	private List<TShape> shapes;
	public TVectorDrawingTool(TShape shape, Boolean isMousePressed,List<TShape> shapes) {
		this.shape = shape;
		this.isMousePressed = isMousePressed;
		this.shapes = shapes;
	}
	public TShape getShape() {
		return shape;
	}

	public void setShape(TShape shape) {
		this.shape = shape;
	}

	public Boolean getIsMousePressed() {
		return isMousePressed;
	}

	public void setIsMousePressed(Boolean isMousePressed) {
		this.isMousePressed = isMousePressed;
	}

	public List<TShape> getShapes() {
		return shapes;
	}
	public void setShapes(List<TShape> shapes) {
		this.shapes = shapes;
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		this.toolMouseDragged(arg0);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		this.toolMouseMoved(arg0);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.toolMouseClicked(arg0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.toolMouseEntered(arg0);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.toolMouseExited(arg0);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		this.toolMousePressed(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		this.toolMouseReleased(arg0);
	}

	public abstract void toolMouseDragged(MouseEvent arg0);

	public abstract void toolMouseMoved(MouseEvent arg0);

	public abstract void toolMouseClicked(MouseEvent arg0);

	public abstract void toolMouseEntered(MouseEvent arg0);

	public abstract void toolMouseExited(MouseEvent arg0);

	public abstract void toolMousePressed(MouseEvent arg0);

	public abstract void toolMouseReleased(MouseEvent arg0);

}
