package tVectorDrawingTools;

import java.awt.Point;
import java.util.List;

import gPaint.shapeType;
import tShapes.TShape;

public  class TVectorDrawingToolFactory {
	public static TVectorDrawingTool getTVectorDrawingTool(shapeType shtype,TShape shape,Boolean isMousePressed,List<TShape> shapes){
		switch (shtype) {
		case line:
			return new TLineTool(shape, isMousePressed, shapes);
		case Oval:
			return new TOvalTool(shape, isMousePressed,shapes);
		case pencil:
			return new TPencilTool(shape, isMousePressed, shapes);
		case Polygon:
			return new TPolygonTool(shape, isMousePressed, shapes);
		case rectangle:
			return new TRectTool(shape, isMousePressed, shapes);
		case triangle:
			return new TTriangleTool(shape, isMousePressed, shapes);
		}
		return null;
	}

}
