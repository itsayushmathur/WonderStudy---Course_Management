package collegeapplication.course;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import collegeapplication.common.HintTextField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * @author Ayush Mathur
 * @mail: mathurayush121@gmail.com
 */


@SuppressWarnings("serial")
public class AddCourseDialog extends JDialog implements ActionListener {

	private JTextField coursecodefield;
	private JTextField coursenamefield;
	private JTextField totalsemoryearfield;
	private JComboBox<String> semoryearcombo;
	private JLabel lblError;
	private CoursePanel coursepanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddCourseDialog dialog = new AddCourseDialog();

			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddCourseDialog(CoursePanel coursepanel) {
		this();
		this.coursepanel = coursepanel;
	}

	public AddCourseDialog() {

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 476, 452);
		getContentPane().setLayout(null);

		JLabel lblAddNewCourse = new JLabel("Add New Course");
		lblAddNewCourse.setForeground(new Color(255, 255, 255));
		lblAddNewCourse.setBackground(Color.RED);
		lblAddNewCourse.setOpaque(true);
		lblAddNewCourse.setFont(new Font("Arial", Font.BOLD, 23));
		lblAddNewCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewCourse.setBounds(0, 0, 473, 55);
		getContentPane().add(lblAddNewCourse);

		JLabel lblCourseCode = new JLabel("Course Code ");
		lblCourseCode.setBorder(new EmptyBorder(0, 0, 0, 5));
		lblCourseCode.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblCourseCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblCourseCode.setBounds(10, 79, 139, 24);
		lblCourseCode.setFocusable(true);
		getContentPane().add(lblCourseCode);

		JLabel lblCourseName = new JLabel("Course Name ");
		lblCourseName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCourseName.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblCourseName.setBorder(new EmptyBorder(0, 0, 0, 5));
		lblCourseName.setBounds(10, 147, 139, 24);
		getContentPane().add(lblCourseName);

		JLabel lblSemyear = new JLabel("Sem/Year");
		lblSemyear.setHorizontalAlignment(SwingConstants.LEFT);
		lblSemyear.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblSemyear.setBorder(new EmptyBorder(0, 0, 0, 5));
		lblSemyear.setBounds(10, 218, 139, 24);
		getContentPane().add(lblSemyear);

		coursecodefield = new HintTextField("");
		coursecodefield.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		coursecodefield.setBounds(157, 72, 292, 40);
		getContentPane().add(coursecodefield);
		coursecodefield.setColumns(10);

		coursenamefield = new HintTextField("");
		coursenamefield.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		coursenamefield.setColumns(10);
		coursenamefield.setBounds(159, 141, 292, 40);
		getContentPane().add(coursenamefield);

		totalsemoryearfield = new HintTextField("");
		totalsemoryearfield.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		totalsemoryearfield.setColumns(10);
		totalsemoryearfield.setBounds(157, 278, 292, 40);
		getContentPane().add(totalsemoryearfield);

		semoryearcombo = new JComboBox<String>();
		semoryearcombo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		semoryearcombo
				.setModel(new DefaultComboBoxModel<String>(new String[] { "---Select Sem/Year---", "sem", "year" }));
		semoryearcombo.setBounds(159, 210, 292, 40);
		getContentPane().add(semoryearcombo);

		JLabel lblTotalSemyear = new JLabel("Total Sem/Year");
		lblTotalSemyear.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalSemyear.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblTotalSemyear.setBorder(new EmptyBorder(0, 0, 0, 5));
		lblTotalSemyear.setBounds(10, 284, 139, 24);
		getContentPane().add(lblTotalSemyear);

		JButton addcoursebutton = new JButton("Add Course");
		addcoursebutton.setBackground(Color.WHITE);
		addcoursebutton.setForeground(Color.BLACK);
		addcoursebutton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addcoursebutton.setBounds(310, 373, 139, 37);
		addcoursebutton.addActionListener(this);
		getContentPane().add(addcoursebutton);

		lblError = new JLabel("This is required field !");
		lblError.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 0, 0)));
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Candara", Font.PLAIN, 15));
		lblError.setVisible(false);
		lblError.setBounds(157, 115, 355, 21);
		getContentPane().add(lblError);

		JLabel label = new JLabel("");
		label.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
		label.setBounds(0, 346, 470, 14);
		getContentPane().add(label);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		lblError.setForeground(Color.red);
		lblError.setVisible(false);
		lblError.setText("This is required question !");
		String coursename = coursenamefield.getText();
		String coursecode = coursecodefield.getText();
		String semoryear = (String) semoryearcombo.getSelectedItem();
		String strtotalsemoryear = totalsemoryearfield.getText();
		if (coursecode.isEmpty()) {
			lblError.setVisible(true);
			lblError.setBounds(coursecodefield.getX(), coursecodefield.getY() + coursecodefield.getHeight(),
					lblError.getWidth(), 21);
			coursecodefield.setFocusable(true);
		}

		else if (coursename.isEmpty()) {
			lblError.setVisible(true);
			lblError.setBounds(coursenamefield.getX(), coursenamefield.getY() + coursenamefield.getHeight(),
					lblError.getWidth(), 21);
			coursenamefield.setFocusable(true);
		} else if (semoryearcombo.getSelectedIndex() == 0) {
			lblError.setVisible(true);
			lblError.setBounds(semoryearcombo.getX(), semoryearcombo.getY() + semoryearcombo.getHeight(),
					lblError.getWidth(), 21);

		} else if (strtotalsemoryear.isEmpty()) {

			lblError.setVisible(true);
			lblError.setBounds(totalsemoryearfield.getX(), totalsemoryearfield.getY() + totalsemoryearfield.getHeight(),
					lblError.getWidth(), 21);
			totalsemoryearfield.setFocusable(true);
		}

		else {

			try {
				int totalsemoryear = Integer.parseInt(strtotalsemoryear);
				if (new CourseData().isCourseCodeExist(coursecode.toUpperCase())) {
					lblError.setVisible(true);
					lblError.setBounds(coursecodefield.getX(), coursecodefield.getY() + coursecodefield.getHeight(),
							lblError.getWidth(), 21);
					lblError.setText("Course code already exist !");
				} else if (new CourseData().isCourseNameExist(coursename)) {
					lblError.setVisible(true);
					lblError.setBounds(coursenamefield.getX(), coursenamefield.getY() + coursenamefield.getHeight(),
							lblError.getWidth(), 21);
					coursenamefield.setFocusable(true);
					lblError.setText("Course name already exist !");
				} else if (totalsemoryear < 1) {
					lblError.setVisible(true);
					lblError.setBounds(totalsemoryearfield.getX(),
							totalsemoryearfield.getY() + totalsemoryearfield.getHeight(), lblError.getWidth(), 21);
					lblError.setText("Minimun 1 sem/year required !");
				} else {
					CourseData c = new CourseData();
					int result = c.addCourse(coursecode, coursename, semoryear, totalsemoryear);
					if (result > 0) {

						if (coursepanel != null) {
							coursepanel.updatetableData();
						}
						this.dispose();
					}

				}
			} catch (NumberFormatException nexp) {
				lblError.setVisible(true);
				lblError.setBounds(totalsemoryearfield.getX(),
						totalsemoryearfield.getY() + totalsemoryearfield.getHeight(), lblError.getWidth(), 21);
				lblError.setText("Characters are not allowed !");
			}

		}

	}

}
