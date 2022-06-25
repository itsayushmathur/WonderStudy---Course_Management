package collegeapplication.course;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import collegeapplication.common.ScrollPaneUtil;
import net.proteanit.sql.DbUtils;

import javax.swing.border.EmptyBorder;

/**
 * @author Ayush Mathur
 * @mail: mathurayush121@gmail.com
 */


@SuppressWarnings("serial")
public class CoursePanel extends JPanel implements ActionListener {
	private JScrollPane scrollPane;
	private JButton addcourse, rollgenerator;

	private JTable table;

	/**
	 * Create the panel.
	 */
	public CoursePanel() {

		setForeground(Color.GRAY);
		setBackground(Color.WHITE);
		this.setSize(1116, 705);
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(10, 200, 1096, 494);
		for (Component c : scrollPane.getComponents()) {
			c.setBackground(Color.white);
		}
		add(scrollPane);

		table = new JTable();
		table.setBorder(new LineBorder(new Color(192, 192, 192)));
		table.setForeground(Color.DARK_GRAY);
		table.setRowHeight(40);

		table.getTableHeader().setBackground(new Color(32, 178, 170));

		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		table.getTableHeader().setPreferredSize(new Dimension(50, 40));
		table.setDragEnabled(false);

		table.setGridColor(Color.LIGHT_GRAY);
		table.getTableHeader().setReorderingAllowed(false);
		this.updatetableData();
		table.setEnabled(false);
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(10, 0, 1096, 183);
		add(panel);
		panel.setLayout(null);

		JLabel allCourseslbl = new JLabel("All Courses");
		allCourseslbl.setForeground(new Color(255, 255, 255));
		allCourseslbl.setFont(new Font("Segoe UI", Font.BOLD, 30));
		allCourseslbl.setBounds(10, 65, 321, 34);
		panel.add(allCourseslbl);

		rollgenerator = new JButton("Roll Generator");
		rollgenerator.setBounds(782, 135, 147, 33);
		panel.add(rollgenerator);
		rollgenerator.setBorder(new EmptyBorder(0, 0, 0, 0));
		rollgenerator.setForeground(Color.BLACK);
		rollgenerator.setFocusable(false);
		rollgenerator.setFont(new Font("Segoe UI", Font.BOLD, 15));
		rollgenerator.setBackground(new Color(255, 255, 255));
		rollgenerator.setVisible(true);
		rollgenerator.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rollgenerator.addActionListener(this);

		addcourse = new JButton("Add Course");
		addcourse.setBounds(939, 135, 147, 33);
		panel.add(addcourse);
		addcourse.setBorder(new EmptyBorder(0, 0, 0, 0));
		addcourse.setForeground(Color.BLACK);
		addcourse.setBackground(new Color(255, 255, 255));
		addcourse.setFocusable(false);
		addcourse.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addcourse.addActionListener(this);
		addcourse.setFont(new Font("Segoe UI", Font.BOLD, 15));

	}

	public void updatetableData() {

		CourseData c = new CourseData();
		ResultSet st = c.getCourseinfo();
		table.setModel(DbUtils.resultSetToTableModel(st));
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(250);
		table.getColumnModel().getColumn(2).setMaxWidth(400);
		table.getColumnModel().getColumn(3).setMaxWidth(200);
		table.getColumnModel().getColumn(4).setMaxWidth(250);
		table.getColumnModel().getColumn(5).setMaxWidth(250);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == rollgenerator) {
			RollGeneratorDialog r = new RollGeneratorDialog();
			r.setLocation(400, 100);
			r.setVisible(true);

		}
		if (e.getSource() == addcourse) {
			AddCourseDialog ac = new AddCourseDialog(this);
			ac.setLocationRelativeTo(null);
			ac.setVisible(true);
			ScrollPaneUtil.scrollToBottom(scrollPane);
		}

	}
}
