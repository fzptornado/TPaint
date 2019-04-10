package gPaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBox extends JPanel {

	private DrawPanel drawPanel;
	private JPanel shapeBox;
	private JButton lineBtn;
	private JButton rectangleBtn;
	private JButton triangleBtn;
	private JButton ovalBtn;
	private JButton pencilBtn;
	private JButton polygonBtn;

	private JPanel QuickOperationBox;
	private JButton clearBtn;
	private JButton undoBtn;
	private JButton redoBtn;

	public ToolBox(DrawPanel drawPanel) {
		super();

		this.setOpaque(true);
		this.setBackground(Color.blue);
		this.setPreferredSize(new Dimension(100, TMain.tHeight - 50));
		this.drawPanel = drawPanel;

		// QuickOperationBox
		QuickOperationBox = new JPanel();
		QuickOperationBox.setOpaque(true);
		QuickOperationBox.setLayout(new FlowLayout());
		QuickOperationBox.setPreferredSize(new Dimension(90, 100));

		QuickOperationBox.setBackground(Color.white);
		this.add(QuickOperationBox);

		// clearBtn
		clearBtn = new JButton("خالی");
		clearBtn.setPreferredSize(new Dimension(40, 30));
		clearBtn.setMargin(new Insets(0, 0, 0, 0));
		clearBtn.setFont(new Font("b koodak", 0, 12));
		clearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawPanel.clearPanel();

			}
		});
		QuickOperationBox.add(clearBtn);
		// undoBtn
		undoBtn = new JButton("به عقب");
		undoBtn.setPreferredSize(new Dimension(40, 30));
		undoBtn.setMargin(new Insets(0, 0, 0, 0));
		undoBtn.setFont(new Font("b koodak", 0, 12));
		undoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// drawPanel.setShapeType(shapeType.line);

			}
		});
		QuickOperationBox.add(undoBtn);
		// redoBtn
		redoBtn = new JButton("به جلو");
		redoBtn.setPreferredSize(new Dimension(40, 30));
		redoBtn.setMargin(new Insets(0, 0, 0, 0));
		redoBtn.setFont(new Font("b koodak", 0, 12));
		redoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// drawPanel.setShapeType(shapeType.line);

			}
		});
		QuickOperationBox.add(redoBtn);
		// shapeBox;
		shapeBox = new JPanel();
		shapeBox.setOpaque(true);
		shapeBox.setLayout(new FlowLayout());
		shapeBox.setPreferredSize(new Dimension(90, 100));

		shapeBox.setBackground(Color.white);
		this.add(shapeBox);

		// lineBtn
		lineBtn = new JButton("خط");
		lineBtn.setPreferredSize(new Dimension(40, 30));
		lineBtn.setMargin(new Insets(0, 0, 0, 0));
		lineBtn.setFont(new Font("b koodak", 0, 12));
		lineBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawPanel.setShapeType(shapeType.line);

			}
		});
		shapeBox.add(lineBtn);

		// rectangleBtn
		rectangleBtn = new JButton("مستطیل");
		rectangleBtn.setPreferredSize(new Dimension(40, 30));
		rectangleBtn.setMargin(new Insets(0, 0, 0, 0));
		rectangleBtn.setFont(new Font("b koodak", 0, 12));
		rectangleBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawPanel.setShapeType(shapeType.rectangle);

			}
		});
		shapeBox.add(rectangleBtn);

		// triangleBtn
		triangleBtn = new JButton("مثلث");
		triangleBtn.setPreferredSize(new Dimension(40, 30));
		triangleBtn.setMargin(new Insets(0, 0, 0, 0));
		triangleBtn.setFont(new Font("b koodak", 0, 12));
		triangleBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawPanel.setShapeType(shapeType.triangle);

			}
		});
		shapeBox.add(triangleBtn);

		// ovalBtn
		ovalBtn = new JButton("بیضی");
		ovalBtn.setPreferredSize(new Dimension(40, 30));
		ovalBtn.setMargin(new Insets(0, 0, 0, 0));
		ovalBtn.setFont(new Font("b koodak", 0, 12));
		ovalBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawPanel.setShapeType(shapeType.Oval);

			}
		});
		shapeBox.add(ovalBtn);

		// pencilBtn
		pencilBtn = new JButton("مداد");
		pencilBtn.setPreferredSize(new Dimension(40, 30));
		pencilBtn.setMargin(new Insets(0, 0, 0, 0));
		pencilBtn.setFont(new Font("b koodak", 0, 12));
		pencilBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawPanel.setShapeType(shapeType.pencil);

			}
		});
		shapeBox.add(pencilBtn);

		// polygonBtn
				polygonBtn = new JButton("چندضلعی");
				polygonBtn.setPreferredSize(new Dimension(40, 30));
				polygonBtn.setMargin(new Insets(0, 0, 0, 0));
				polygonBtn.setFont(new Font("b koodak", 0, 12));
				polygonBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						drawPanel.setShapeType(shapeType.Polygon);

					}
				});
				shapeBox.add(polygonBtn);
	}
}
