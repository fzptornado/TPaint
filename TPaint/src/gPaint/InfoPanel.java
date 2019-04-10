package gPaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
	private JLabel XYLable;
	private JLabel mousePressedLocationLbl;
	private JLabel mouseReleasedLocationLbl;
	
public InfoPanel(){
	super();
	this.setOpaque(true);
	this.setPreferredSize(new Dimension(100, TMain .tHeight-50));
	this.setBackground(Color.LIGHT_GRAY);
	this.setLayout(new FlowLayout());
	

	XYLable = new JLabel();	
	XYLable.setPreferredSize(new Dimension(90, 30));
	XYLable.setBackground(Color.white);
	//XYLable.setFont(new Font("tahoma", 10, 10));
	XYLable.setOpaque(true);
	XYLable.setText("start");
	this.add(XYLable);

	mousePressedLocationLbl = new JLabel();	
	mousePressedLocationLbl.setPreferredSize(new Dimension(90, 30));
	mousePressedLocationLbl.setBackground(Color.white);
	//XYLable.setFont(new Font("tahoma", 10, 10));
	mousePressedLocationLbl.setOpaque(true);
	mousePressedLocationLbl.setText("start");
	this.add(mousePressedLocationLbl);

	mouseReleasedLocationLbl = new JLabel();	
	mouseReleasedLocationLbl.setPreferredSize(new Dimension(90, 30));
	mouseReleasedLocationLbl.setBackground(Color.white);
	//XYLable.setFont(new Font("tahoma", 10, 10));
	mouseReleasedLocationLbl.setOpaque(true);
	mouseReleasedLocationLbl.setText("start");
	this.add(mouseReleasedLocationLbl);
}

public void setXYLocation(Point p){
	XYLable.setText("(" +p.getX()+ "," +p.getY()+ ")");
}

public void setMousePressedLocation(Point p){
	mousePressedLocationLbl.setText("(" +p.getX()+ "," +p.getY()+ ")");

}

public void setMouseReleasedLocation(Point p){
	mouseReleasedLocationLbl.setText("(" +p.getX()+ "," +p.getY()+ ")");

}


}
