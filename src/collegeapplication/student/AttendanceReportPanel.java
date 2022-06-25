package collegeapplication.student;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import collegeapplication.admin.AdminMain;
import collegeapplication.course.CourseData;
import collegeapplication.faculty.FacultyMain;
import collegeapplication.subject.SubjectData;

/**
 * @author Ayush Mathur
 * @mail: mathurayush121@gmail.com
 */


public class AttendanceReportPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> coursenamecombo;
	private JComboBox<String> semoryearcombo;
	private JComboBox<String> subjectorrollcombo;
	private JTable table;
	private JScrollPane scrollPane;
	private int totalstudent = 0;
	private JLabel Errorlabel;
	private JButton studentwisebutton;
	private JButton classwisebutton;
	private JButton subjectwisebutton;
	private JButton fetchdetailsbutton;
	private JLabel label3;
	private JLabel label1;
	private JLabel label2;
	private JLabel nodatafoundlabel;
	private JButton backbutton;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1096, scrollPane.getY() + scrollPane.getHeight() + 40);

	}

	private AttendanceReportPanel() {
		setBorder(null);

		setBackground(new Color(255, 255, 255));
		this.setSize(1116, 544);
		setLayout(null);
		panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.RED);
		panel.setBounds(10, 0, 1077, 183);
		add(panel);
		panel.setLayout(null);
		JLabel headinglabel = new JLabel("Attendance Report");
		headinglabel.setIcon(null);
		headinglabel.setBounds(10, 65, 272, 44);
		panel.add(headinglabel);
		headinglabel.setBackground(Color.RED);
		headinglabel.setHorizontalAlignment(SwingConstants.LEFT);
		headinglabel.setForeground(Color.WHITE);
		headinglabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
		headinglabel.setOpaque(true);

		subjectwisebutton = new JButton("Subject Wise");
		subjectwisebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		subjectwisebutton.setForeground(Color.BLACK);
		subjectwisebutton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		subjectwisebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		subjectwisebutton.setBackground(Color.WHITE);
		subjectwisebutton.setBounds(906, 108, 146, 33);

		panel.add(subjectwisebutton);

		studentwisebutton = new JButton("Student Wise");
		studentwisebutton.setForeground(Color.BLACK);
		studentwisebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		studentwisebutton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		studentwisebutton.setBackground(Color.WHITE);
		studentwisebutton.setBounds(906, 65, 146, 33);

		panel.add(studentwisebutton);

		classwisebutton = new JButton("Class Wise");
		classwisebutton.setForeground(Color.BLACK);
		classwisebutton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		classwisebutton.setBackground(Color.WHITE);
		classwisebutton.setBounds(906, 20, 146, 33);
		classwisebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		panel.add(classwisebutton);

		label1 = new JLabel("Course Name   :");
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		label1.setForeground(Color.DARK_GRAY);
		label1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		label1.setBounds(29, 213, 163, 37);
		add(label1);

		label2 = new JLabel("Semester or Years   :");
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		label2.setForeground(Color.DARK_GRAY);
		label2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		label2.setBounds(23, 270, 169, 40);
		add(label2);

		label3 = new JLabel("Select Subject  :");
		label3.setHorizontalAlignment(SwingConstants.RIGHT);
		label3.setForeground(Color.DARK_GRAY);
		label3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		label3.setBounds(29, 339, 163, 32);
		add(label3);

		coursenamecombo = new JComboBox<String>(new CourseData().getCourseName());
		coursenamecombo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		coursenamecombo.addActionListener(this);
		coursenamecombo.setFocusable(false);
		coursenamecombo.setBackground(new Color(255, 255, 255));
		coursenamecombo.setBounds(204, 211, 872, 40);
		add(coursenamecombo);

		semoryearcombo = new JComboBox<String>();
		semoryearcombo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		semoryearcombo.setBackground(Color.WHITE);
		semoryearcombo.setBounds(204, 270, 872, 40);
		semoryearcombo.addActionListener(this);
		semoryearcombo.setFocusable(false);

		add(semoryearcombo);
		subjectorrollcombo = new JComboBox<String>();
		subjectorrollcombo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		subjectorrollcombo.setFocusable(false);
		subjectorrollcombo.addActionListener(this);
		subjectorrollcombo.setBackground(Color.WHITE);
		subjectorrollcombo.setBounds(204, 335, 872, 40);
		add(subjectorrollcombo);

		scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(21, 460, 1055, 84);
		for (Component c : scrollPane.getComponents()) {
			c.setBackground(Color.white);
		}
		add(scrollPane);
		scrollPane.setVisible(false);
		table = new JTable();
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setForeground(new Color(0, 0, 0));
		table.setRowHeight(40);
		table.getTableHeader().setBackground(new Color(32, 178, 170));
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		table.getTableHeader().setPreferredSize(new Dimension(50, 40));
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		table.setDragEnabled(false);
		table.setFocusable(false);
		table.setGridColor(Color.LIGHT_GRAY);
		table.getTableHeader().setReorderingAllowed(false);

		scrollPane.setViewportView(table);
		Errorlabel = new JLabel("This is required question  !");
		Errorlabel.setVisible(false);
		Errorlabel.setForeground(Color.RED);
		Errorlabel.setFont(new Font("Arial", Font.PLAIN, 14));
		Errorlabel.setBounds(233, 45, 225, 17);
		add(Errorlabel);
		enableButton(subjectwisebutton);
		disableButton(studentwisebutton);
		disableButton(classwisebutton);

		fetchdetailsbutton = new JButton("Fetch Details");
		fetchdetailsbutton.setName("Active");
		fetchdetailsbutton.setForeground(Color.BLACK);
		fetchdetailsbutton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		fetchdetailsbutton.setFocusPainted(false);
		fetchdetailsbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		fetchdetailsbutton.addActionListener(this);
		fetchdetailsbutton.setBorder(new LineBorder(new Color(255, 255, 255)));
		fetchdetailsbutton.setBackground(Color.WHITE);
		fetchdetailsbutton.setBounds(926, 399, 151, 37);
		add(fetchdetailsbutton);

		nodatafoundlabel = new JLabel("");
		nodatafoundlabel.setHorizontalAlignment(SwingConstants.CENTER);
		try {

			Image image = ImageIO.read(new File("./assets/notfound2.png"));
			nodatafoundlabel.setIcon(new ImageIcon(image.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

		} catch (IOException e) {
			e.printStackTrace();
		}
		nodatafoundlabel.setText("No Data Found...!");
		nodatafoundlabel.setVerticalTextPosition(JLabel.BOTTOM);
		nodatafoundlabel.setBorder(null);
		nodatafoundlabel.setBackground(new Color(245, 245, 245));
		nodatafoundlabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		nodatafoundlabel.setHorizontalTextPosition(JLabel.CENTER);
		nodatafoundlabel.setIconTextGap(20);
		nodatafoundlabel.setVisible(false);
		nodatafoundlabel.setBounds(300, 380, 480, 321);
		add(nodatafoundlabel);

	}

	public void enableButton(JButton button) {
		button.setBorder(new LineBorder(new Color(255, 255, 255)));
		button.setForeground(new Color(0, 139, 139));
		button.setBackground(new Color(255, 255, 255));
		button.setFocusPainted(false);
		button.setName("Active");
	}

	public void disableButton(JButton button) {

		button.setBorder(new LineBorder(new Color(255, 255, 255)));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(32, 178, 170));
		button.setFocusPainted(false);
		button.setName("Deactive");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Errorlabel.setVisible(false);
		if (e.getSource() == coursenamecombo) {
			coursenamecombo.setFocusable(false);

			subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));
			if (coursenamecombo.getSelectedIndex() == 0) {
				semoryearcombo.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));

			} else {
				String course = (String) coursenamecombo.getSelectedItem();

				semoryearcombo.setModel(new DefaultComboBoxModel<String>(new CourseData().getSemorYear(course)));
			}

		}
		if (e.getSource() == semoryearcombo && semoryearcombo.getSelectedIndex() > 0) {
			String course = (String) coursenamecombo.getSelectedItem();

			if (subjectwisebutton.getName().equals("Active")) {
				String[] totalsub = new SubjectData().getSubjectinCourse(new CourseData().getCoursecode(course),
						semoryearcombo.getSelectedIndex());
				if (totalsub != null) {
					subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(totalsub));
				} else {

					subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new String[] { "No Subject Found" }));
				}
			} else if (studentwisebutton.getName().equals("Active")) {

				subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new StudentData()
						.getRollNumber(new CourseData().getCoursecode(course), semoryearcombo.getSelectedIndex())));

			}
		} else if (e.getSource() == semoryearcombo) {
			subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));
		}
		if (e.getSource() == fetchdetailsbutton) {
			if (coursenamecombo.getSelectedIndex() == 0) {
				showerror(coursenamecombo);
			} else if (semoryearcombo.getSelectedIndex() == 0) {
				showerror(semoryearcombo);
			} else if (subjectorrollcombo.isVisible()
					&& subjectorrollcombo.getSelectedItem().equals("No Subject Found")) {
				Component tf = subjectorrollcombo;
				Errorlabel.setVisible(true);
				Errorlabel.setText("No Subject Found !");
				Errorlabel.setBounds(tf.getX(), tf.getY() + tf.getHeight() - 5, 400, 26);
			} else if (subjectorrollcombo.isVisible() && subjectorrollcombo.getSelectedIndex() == 0) {
				showerror(subjectorrollcombo);
			}

			else {
				this.createtablemodel();
			}
		}
		// TODO Auto-generated method stub

	}

	public void showerror(JComponent tf) {
		Errorlabel.setVisible(true);
		Errorlabel.setText("This is required question !");
		Errorlabel.setBounds(tf.getX(), tf.getY() + tf.getHeight() - 5, 400, 26);
	}

	public AttendanceReportPanel(AdminMain am) {
		this();
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() > 1 && e.getButton() == MouseEvent.BUTTON1) {

					JTable t = (JTable) e.getSource();
					int row = t.getSelectedRow();

					String strsem = table.getValueAt(row, 2) + "";
					int sem = Integer.parseInt(strsem.substring(strsem.indexOf('-') + 1));
					String coursecode = strsem.substring(0, strsem.indexOf('-'));
					String strroll = table.getValueAt(row, 0) + "";
					long rollnumber = Long.parseLong(strroll);
					Student s = new StudentData().getStudentDetails(coursecode, sem, rollnumber);

					am.viewstudentpanel = new ViewStudentPanel(s, am, am.attendancereportpanelscroll);
					am.viewstudentpanel.setVisible(true);
					am.attendancereportpanelscroll.setVisible(false);
					am.viewstudentpanel.setLocation(am.panelx, 0);
					am.viewstudentpanel.setVisible(true);
					am.viewstudentpanel.setFocusable(true);
					am.contentPane.add(am.viewstudentpanel);
				}

			}
		});
		subjectwisebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				enableButton(subjectwisebutton);
				disableButton(studentwisebutton);
				disableButton(classwisebutton);
				subjectorrollcombo.setVisible(true);
				label3.setVisible(true);
				fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(), subjectorrollcombo.getY() + 65);
				scrollPane.setLocation(scrollPane.getX(), fetchdetailsbutton.getY() + 60);
				label3.setText("Select Subject :");
				subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));
				coursenamecombo.setSelectedIndex(0);
				semoryearcombo.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));
				scrollPane.setVisible(false);
			}

		});
		studentwisebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				enableButton(studentwisebutton);
				disableButton(subjectwisebutton);
				disableButton(classwisebutton);
				label3.setVisible(true);
				subjectorrollcombo.setVisible(true);
				label3.setText("Select Roll Number :");
				fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(), subjectorrollcombo.getY() + 65);
				scrollPane.setLocation(scrollPane.getX(), fetchdetailsbutton.getY() + 60);
				subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));
				coursenamecombo.setSelectedIndex(0);
				semoryearcombo.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));
				scrollPane.setVisible(false);

			}

		});
		classwisebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				enableButton(classwisebutton);
				disableButton(studentwisebutton);
				disableButton(subjectwisebutton);
				subjectorrollcombo.setVisible(false);
				label3.setVisible(false);
				fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(), subjectorrollcombo.getY());
				scrollPane.setLocation(scrollPane.getX(), fetchdetailsbutton.getY() + 60);
				coursenamecombo.setSelectedIndex(0);
				semoryearcombo.setModel(new DefaultComboBoxModel<String>(new String[] { "" }));
				scrollPane.setVisible(false);
			}

		});

	}

	public AttendanceReportPanel(FacultyMain fm) {

		this();

		coursenamecombo.setSelectedItem(new CourseData().getcoursename(fm.f.getCourseCode()));
		semoryearcombo.setModel(new DefaultComboBoxModel<String>(
				new CourseData().getSemorYear(coursenamecombo.getSelectedItem() + "")));
		String[] totalsub = new SubjectData().getSubjectinCourse(fm.f.getCourseCode(), fm.f.getSemorYear());
		subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(totalsub));
		semoryearcombo.setSelectedIndex(fm.f.getSemorYear());
		subjectorrollcombo.setSelectedItem(fm.f.getSubject());
		coursenamecombo.setVisible(false);
		semoryearcombo.setVisible(false);
		label3.setLocation(label1.getLocation());
		label1.setVisible(false);
		label2.setVisible(false);
		subjectorrollcombo.setLocation(coursenamecombo.getLocation());
		this.fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(), semoryearcombo.getY());
		scrollPane.setLocation(scrollPane.getX(), fetchdetailsbutton.getY() + 50);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() > 1 && e.getButton() == MouseEvent.BUTTON1) {

					JTable t = (JTable) e.getSource();
					int row = t.getSelectedRow();

					String strsem = table.getValueAt(row, 2) + "";
					int sem = Integer.parseInt(strsem.substring(strsem.indexOf('-') + 1));
					String coursecode = strsem.substring(0, strsem.indexOf('-'));
					String strroll = table.getValueAt(row, 0) + "";
					long rollnumber = Long.parseLong(strroll);
					Student s = new StudentData().getStudentDetails(coursecode, sem, rollnumber);

					fm.viewstudentpanel = new ViewStudentPanel(s, fm, fm.attendancereportpanelscroll);
					fm.viewstudentpanel.setVisible(true);
					fm.attendancereportpanelscroll.setVisible(false);
					fm.viewstudentpanel.setLocation(fm.panelx, 0);
					fm.viewstudentpanel.setVisible(true);
					fm.viewstudentpanel.setFocusable(true);
					fm.contentPane.add(fm.viewstudentpanel);
				}

			}
		});
		studentwisebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				enableButton(studentwisebutton);
				disableButton(subjectwisebutton);
				disableButton(classwisebutton);
				label3.setVisible(true);
				subjectorrollcombo.setVisible(true);
				label3.setText("Select Roll Number :");
				fetchdetailsbutton.setVisible(true);
				subjectorrollcombo.setLocation(coursenamecombo.getLocation());
				fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(), semoryearcombo.getY());
				scrollPane.setLocation(scrollPane.getX(), fetchdetailsbutton.getY() + 50);
				subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(
						new StudentData().getRollNumber(fm.f.getCourseCode(), semoryearcombo.getSelectedIndex())));
				scrollPane.setVisible(false);

			}

		});
		subjectwisebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				enableButton(subjectwisebutton);
				disableButton(studentwisebutton);
				disableButton(classwisebutton);
				label3.setVisible(true);
				subjectorrollcombo.setVisible(true);
				label3.setText("Select Subject :");
				fetchdetailsbutton.setVisible(true);
				subjectorrollcombo.setLocation(coursenamecombo.getLocation());
				fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(), semoryearcombo.getY());
				scrollPane.setLocation(scrollPane.getX(), fetchdetailsbutton.getY() + 50);
				String[] totalsub = new SubjectData().getSubjectinCourse(fm.f.getCourseCode(), fm.f.getSemorYear());
				subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(totalsub));
				scrollPane.setVisible(false);

			}

		});
		classwisebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				subjectwisebutton.setName("Active");
				enableButton(classwisebutton);
				disableButton(studentwisebutton);
				disableButton(subjectwisebutton);
				subjectorrollcombo.setVisible(false);
				label3.setVisible(false);
				scrollPane.setLocation(scrollPane.getX(), coursenamecombo.getY());
				fetchdetailsbutton.setVisible(false);
				createtablemodel();
			}

		});

	}

	public AttendanceReportPanel(StudentMain sm, JComponent lastpanel) {
		this(sm);
		backbutton = new JButton("Back");
		backbutton.setContentAreaFilled(false);
		backbutton.setBorder(new EmptyBorder(0, 0, 0, 0));
		backbutton.setIcon(new ImageIcon(".\\assets\\back.png"));
		backbutton.setFocusable(false);
		backbutton.setForeground(Color.WHITE);
		backbutton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		backbutton.setBackground(new Color(32, 178, 170));
		backbutton.setBounds(10, 141, 88, 36);
		panel.add(backbutton);

		backbutton.addActionListener(e -> {
			sm.attendancereportpanelscroll.setVisible(false);
			lastpanel.setVisible(true);
		});
	}

	public AttendanceReportPanel(StudentMain sm) {
		this();
		classwisebutton.setVisible(false);
		studentwisebutton.setVisible(false);
		subjectwisebutton.setVisible(false);
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		coursenamecombo.setVisible(false);
		subjectorrollcombo.setVisible(false);
		semoryearcombo.setVisible(false);
		this.fetchdetailsbutton.setVisible(false);
		enableButton(studentwisebutton);
		disableButton(subjectwisebutton);
		disableButton(classwisebutton);

		coursenamecombo.setSelectedItem(new CourseData().getcoursename(sm.s.getCourseCode()));
		semoryearcombo.setModel(new DefaultComboBoxModel<String>(
				new CourseData().getSemorYear(coursenamecombo.getSelectedItem() + "")));
		subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(
				new StudentData().getRollNumber(sm.s.getCourseCode(), sm.s.getSemorYear())));
		semoryearcombo.setSelectedIndex(sm.s.getSemorYear());
		subjectorrollcombo.setSelectedItem(sm.s.getRollNumber() + "");
		scrollPane.setLocation(scrollPane.getX(), coursenamecombo.getY());
		scrollPane.setVisible(true);

		this.createtablemodel();
		table.setEnabled(false);
		table.setRowSelectionInterval(totalstudent - 1, totalstudent - 1);
		table.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer());
		table.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer());
		table.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer());
		table.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer());
		table.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer());
		table.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer());

	}

	public void createtablemodel() {
		nodatafoundlabel.setVisible(false);
		if (coursenamecombo.getSelectedIndex() == 0
				|| (semoryearcombo.isVisible() && semoryearcombo.getSelectedIndex() == 0)
				|| (subjectorrollcombo.isVisible() && subjectorrollcombo.getSelectedIndex() == 0)) {
			scrollPane.setVisible(false);
		} else {
			Attendance a = new Attendance();
			a.setCourseCode(new CourseData().getCoursecode(coursenamecombo.getSelectedItem() + ""));
			a.setSemorYear(semoryearcombo.getSelectedIndex());
			if (subjectwisebutton.getName().equals("Active")) {
				a.setSubjectName(subjectorrollcombo.getSelectedItem() + "");
				a.setSubjectCode(
						new SubjectData().getSubjectCode(a.getCourseCode(), a.getSemorYear(), a.getSubjectName()));
			} else if (classwisebutton.getName().equals("Active")) {
				a.setSubjectName("All");
			} else if (studentwisebutton.getName().equals("Active")) {
				a.setRollNumber(Long.parseLong(subjectorrollcombo.getSelectedItem() + ""));

			}
			table.setModel(createModel(a));
			scrollPane.setSize(scrollPane.getWidth(), 40 + (totalstudent * 40));
			this.setSize(1116, scrollPane.getY() + 80 + totalstudent * 40 + 60);

			table.getColumnModel().getColumn(0).setMaxWidth(200);
			table.getColumnModel().getColumn(1).setMaxWidth(250);
			table.getColumnModel().getColumn(2).setMaxWidth(200);
			table.getColumnModel().getColumn(3).setMaxWidth(250);
			table.getColumnModel().getColumn(4).setMaxWidth(230);
			table.getColumnModel().getColumn(5).setMaxWidth(200);
			DefaultTableCellRenderer cellrenderer = new DefaultTableCellRenderer();
			cellrenderer.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(cellrenderer);
			table.getColumnModel().getColumn(2).setCellRenderer(cellrenderer);
			table.getColumnModel().getColumn(3).setCellRenderer(cellrenderer);
			table.getColumnModel().getColumn(4).setCellRenderer(cellrenderer);
			table.getColumnModel().getColumn(5).setCellRenderer(cellrenderer);
			table.setSelectionBackground(new Color(240, 255, 255));
			table.setSelectionForeground(Color.black);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			scrollPane.setVisible(true);
			if (totalstudent == 0) {
				noDataFound();
			}
		}

	}

	public DefaultTableModel createModel(Attendance a) {
		String Column[] = { "Roll Number", "Student Name", "Class", "Subject", "Total Attendance", "Percentage" };

		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(Column, 0) {
			boolean isEdit[] = { false, false, false, false, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return isEdit[column];
			}
		};

		ArrayList<Attendance> list = null;
		if (studentwisebutton.getName().equals("Active")) {
			list = new StudentData().getAttendanceReportByStudent(a);
		} else if (subjectwisebutton.getName().equals("Active")) {
			list = new StudentData().getAttendanceReportBySubject(a);
		} else if (classwisebutton.getName().equals("Active")) {
			list = new StudentData().getAttendanceReportByClass(a);
		}
		for (int i = 0; i < list.size(); i++) {

			model.addRow(new Object[0]);
			model.setValueAt(list.get(i).getRollNumber(), i, 0);
			model.setValueAt(list.get(i).getStudentName(), i, 1);
			model.setValueAt(a.getCourseCode() + "-" + a.getSemorYear(), i, 2);
			model.setValueAt(list.get(i).getSubjectName(), i, 3);
			model.setValueAt(list.get(i).getAttendance() + " out of " + list.get(i).getTotalAttendance(), i, 4);

			try {
				model.setValueAt((list.get(i).getAttendance() * 100) / list.get(i).getTotalAttendance() + " %", i, 5);
			} catch (ArithmeticException exp) {
				model.setValueAt(list.get(i).getTotalAttendance() + " %", i, 5);
			}
		}
		totalstudent = list.size();

		{
			table.setEnabled(true);
			if (!classwisebutton.isVisible() && !studentwisebutton.isVisible() && !subjectwisebutton.isVisible()) {
				try {

					list = new StudentData().getTotalAttendanceReportOfStudent(a);
					Object obj[] = { "", "Total", "", list.get(0).getSubjectName(),
							list.get(0).getAttendance() + " out of " + list.get(0).getTotalAttendance(),
							(list.get(0).getAttendance() * 100) / list.get(0).getTotalAttendance() + " %" };
					model.addRow(obj);
				} catch (ArithmeticException exp) {
					Object obj[] = { "", "Total", "", list.get(0).getSubjectName(),
							list.get(0).getAttendance() + " out of " + list.get(0).getTotalAttendance(),
							list.get(0).getTotalAttendance() + " %" };
					model.addRow(obj);
				}

				totalstudent += 1;
			}
		}
		return model;

	}

	public void noDataFound() {
		scrollPane.setVisible(false);
		nodatafoundlabel.setVisible(true);
		nodatafoundlabel.setLocation(nodatafoundlabel.getX(), scrollPane.getY() - 100);

	}

	@SuppressWarnings("serial")
	private class CellRenderer extends DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			this.setHorizontalAlignment(JLabel.CENTER);
			if (row == (totalstudent - 1)) {

				this.setFont(this.getFont().deriveFont(Font.BOLD));
				if (row == 0) {
					this.setHorizontalAlignment(JLabel.CENTER);
				}

			}
			return this;
		}
	}

}
