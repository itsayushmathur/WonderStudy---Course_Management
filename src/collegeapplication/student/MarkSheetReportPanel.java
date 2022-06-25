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
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import collegeapplication.admin.AdminMain;
import collegeapplication.course.Course;
import collegeapplication.course.CourseData;
import collegeapplication.faculty.FacultyMain;
import collegeapplication.subject.SubjectData;

/**
 * @author Ayush Mathur
 * @mail: mathurayush121@gmail.com
 */

@SuppressWarnings("serial")
public class MarkSheetReportPanel extends JPanel implements ActionListener {

	private JComboBox<String> coursenamecombo;
	private JComboBox<String> semoryearcombo;
	private JComboBox<String> subjectorrollcombo;
	private JTable table;
	private JScrollPane scrollPane;
	private int totalstudent=0;
	private JLabel Errorlabel;
	private JButton studentWisebutton;
	private JButton classWisebutton;
	private JButton subjectWisebutton;
	private JButton fetchdetailsbutton;
	private JLabel label3;
	private JLabel label1;
	private JLabel label2;
	private JButton declareresultbutton;
	private JButton submitbutton;
	private JLabel nodatafoundlabel;
	
	/**
	 * Create the panel.
	 */
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(1096,this.getHeight());
		
	}
	
	private MarkSheetReportPanel() {
		
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		this.setSize(1116, 544);
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(10, 0, 1077, 183);
		add(panel);
		panel.setLayout(null);
		JLabel headingLabel = new JLabel("Marksheet Report");
		headingLabel.setIcon(null);
		headingLabel.setBounds(10, 65, 272, 44);
		panel.add(headingLabel);
		headingLabel.setBackground(Color.RED)
		;
		headingLabel.setHorizontalAlignment(SwingConstants.LEFT);
		headingLabel.setForeground(Color.WHITE);
		headingLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
		headingLabel.setOpaque(true);
		
		declareresultbutton = new JButton("Declare Result");
		declareresultbutton.setForeground(Color.RED);
		declareresultbutton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		declareresultbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		declareresultbutton.setBackground(Color.WHITE);
		declareresultbutton.setBounds(417, 139, 146, 33);
		declareresultbutton.setFocusable(false);
		this.disableButton(declareresultbutton);
		declareresultbutton.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						activeButton(declareresultbutton);
						disableButton(classWisebutton);
						disableButton(subjectWisebutton);
						disableButton(studentWisebutton);
						semoryearcombo.setVisible(false);
						subjectorrollcombo.setVisible(false);
						label2.setVisible(false);
						label3.setVisible(false);
						scrollPane.setVisible(false);
						fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(), semoryearcombo.getY());
						scrollPane.setLocation(scrollPane.getX(), subjectorrollcombo.getY());
						coursenamecombo.setSelectedIndex(0);
						
					}
					
				});
		panel.add(declareresultbutton);
		
		subjectWisebutton = new JButton("Subject Wise");
		subjectWisebutton.setForeground(Color.RED);
		subjectWisebutton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		subjectWisebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		subjectWisebutton.setBackground(Color.WHITE);
		subjectWisebutton.setBounds(577, 139, 146, 33);

		panel.add(subjectWisebutton);
		
		studentWisebutton = new JButton("Student Wise");
		studentWisebutton.setForeground(Color.RED);
		studentWisebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		studentWisebutton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		studentWisebutton.setBackground(Color.WHITE);
		studentWisebutton.setBounds(742, 139, 146, 33);

		panel.add(studentWisebutton);
		
		classWisebutton = new JButton("Class Wise");
		classWisebutton.setForeground(Color.RED);
		classWisebutton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		classWisebutton.setBackground(Color.WHITE);
		classWisebutton.setBounds(907, 139, 146, 33);
		classWisebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		panel.add(classWisebutton);
		  
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
		
		scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(21, 460, 1055, 84);
		scrollPane.getVerticalScrollBar().setUnitIncrement(80);
		for(Component c:scrollPane.getComponents())
		{
			c.setBackground(Color.white);
		}
		add(scrollPane);
		scrollPane.setVisible(false);
		table = new JTable();
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setForeground(new Color(0, 0, 0));
		table.setRowHeight(40);
		table.getTableHeader().setBackground(new Color(32,178,170));
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setFont(new Font("Arial",Font.BOLD,20));
		table.setFont(new Font("Segoe UI",Font.PLAIN,20));
		table.getTableHeader().setPreferredSize(new Dimension(50,40));
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
	    activeButton(subjectWisebutton);
		disableButton(studentWisebutton);
		disableButton(classWisebutton);
		disableButton(declareresultbutton);
		
		fetchdetailsbutton = new JButton("Fetch Details");
		fetchdetailsbutton.setForeground(Color.BLACK);
		fetchdetailsbutton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		fetchdetailsbutton.setFocusPainted(false);
		fetchdetailsbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		fetchdetailsbutton.addActionListener(this);
		fetchdetailsbutton.setBorder(new LineBorder(new Color(255, 255, 255)));
		fetchdetailsbutton.setBackground(Color.WHITE);
		fetchdetailsbutton.setBounds(926, 399, 151, 37);
		add(fetchdetailsbutton);
		
		submitbutton = new JButton("Declare Result");
		submitbutton.setForeground(Color.WHITE);
		submitbutton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		submitbutton.setVisible(false);
		submitbutton.setFocusPainted(false);
		submitbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		submitbutton.addActionListener(new DeclareResult());
		submitbutton.setBorder(new LineBorder(new Color(255, 255, 255)));
		submitbutton.setBackground(new Color(32, 178, 170));
		submitbutton.setBounds(926, 399, 151, 37);
		add(submitbutton);
		
		nodatafoundlabel=new JLabel("");
		nodatafoundlabel.setHorizontalAlignment(SwingConstants.CENTER);
		try 
		{
			
			Image image= ImageIO.read(new File("./assets/notfound2.png"));
			nodatafoundlabel.setIcon(new ImageIcon(image.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
			
		} catch (IOException e) 
		{
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
	
	
	public MarkSheetReportPanel(AdminMain am)
	{
		this();
		 table.addMouseListener(new MouseAdapterForTable(am));
		subjectWisebutton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				activeButton(subjectWisebutton);
				disableButton(studentWisebutton);
				disableButton(classWisebutton);
				disableButton(declareresultbutton);
				
				label2.setVisible(true);
				coursenamecombo.setVisible(true);
				semoryearcombo.setVisible(true);
				subjectorrollcombo.setVisible(true);
				label3.setVisible(true);
				fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(),subjectorrollcombo.getY()+65);
				scrollPane.setLocation(scrollPane.getX(), fetchdetailsbutton.getY()+60);
				label3.setText("Select Subject :");
				subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new String[] {""}));	
				coursenamecombo.setSelectedIndex(0);
				semoryearcombo.setModel(new DefaultComboBoxModel<String>(new String[]{""}));
				scrollPane.setVisible(false);
			}
			
		}
		);
		studentWisebutton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				activeButton(studentWisebutton);
				disableButton(subjectWisebutton);
				disableButton(classWisebutton);
				disableButton(declareresultbutton);
				label2.setVisible(true);
				coursenamecombo.setVisible(true);
				semoryearcombo.setVisible(true);
				label3.setVisible(true);
				subjectorrollcombo.setVisible(true);
				label3.setText("Select Roll Number :");
				fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(),subjectorrollcombo.getY()+65);
				scrollPane.setLocation(scrollPane.getX(), fetchdetailsbutton.getY()+60);
				subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new String[] {""}));	
				coursenamecombo.setSelectedIndex(0);
				semoryearcombo.setModel(new DefaultComboBoxModel<String>(new String[]{""}));
				scrollPane.setVisible(false);
				
			}
			
		}
		);
		classWisebutton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				subjectWisebutton.setName("Active");
				coursenamecombo.setVisible(true);
				semoryearcombo.setVisible(true);
				activeButton(classWisebutton);
				disableButton(studentWisebutton);
				disableButton(subjectWisebutton);
				disableButton(declareresultbutton);
				label2.setVisible(true);
				subjectorrollcombo.setVisible(false);
				label3.setVisible(false);
				fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(),subjectorrollcombo.getY());
				scrollPane.setLocation(scrollPane.getX(), fetchdetailsbutton.getY()+60);
				coursenamecombo.setSelectedIndex(0);
				semoryearcombo.setModel(new DefaultComboBoxModel<String>(new String[]{""}));
				scrollPane.setVisible(false);
			}
			
		}
		);
		
	}
	public MarkSheetReportPanel(FacultyMain fm)
	{
	
		this();
		declareresultbutton.setVisible(false);
		coursenamecombo.setSelectedItem(new CourseData().getcoursename(fm.f.getCourseCode()));
		semoryearcombo.setModel(new DefaultComboBoxModel<String>(new CourseData().getSemorYear(coursenamecombo.getSelectedItem()+"")));
		String[] totalsub=new SubjectData().getSubjectinCourse(fm.f.getCourseCode(), fm.f.getSemorYear());	
		subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(totalsub));
		semoryearcombo.setSelectedIndex(fm.f.getSemorYear());
		subjectorrollcombo.setSelectedItem(fm.f.getSubject());
		coursenamecombo.setVisible(false);
		semoryearcombo.setVisible(false);
		label3.setLocation(label1.getLocation());
		label1.setVisible(false);
		label2.setVisible(false);
		subjectorrollcombo.setLocation(coursenamecombo.getLocation());
		this.fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(),semoryearcombo.getY());
		scrollPane.setLocation(scrollPane.getX(),fetchdetailsbutton.getY()+50);
		 table.addMouseListener(new MouseAdapter()
			{
				public void mousePressed(MouseEvent e)
				{
					if(e.getClickCount()>1  && e.getButton()==MouseEvent.BUTTON1)
					{
					
						JTable t=(JTable) e.getSource();
						int row=t.getSelectedRow();
						
						String  strsem=table.getValueAt(row, 2)+"";
						int sem=Integer.parseInt(strsem.substring(strsem.indexOf('-')+1));
						String coursecode=strsem.substring(0,strsem.indexOf('-'));
						String strroll=table.getValueAt(row, 0)+"";
						long rollnumber=Long.parseLong(strroll);
						Student s=new StudentData().getStudentDetails(coursecode,sem,rollnumber);
						
						fm.viewstudentpanel=new ViewStudentPanel(s,fm,fm.marksheetreportpanelscroll);
						fm.viewstudentpanel.setVisible(true);
						fm.marksheetreportpanelscroll.setVisible(false);
						fm.viewstudentpanel.setLocation(fm.panelx,0);
						fm.viewstudentpanel.setVisible(true);
						fm.viewstudentpanel.setFocusable(true);
						fm.contentPane.add(fm.viewstudentpanel);
					}
				
				}
			});
		studentWisebutton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				activeButton(studentWisebutton);
				disableButton(subjectWisebutton);
				disableButton(classWisebutton);
				disableButton(declareresultbutton);
				label3.setVisible(true);
				subjectorrollcombo.setVisible(true);
				label3.setText("Select Roll Number :");
				fetchdetailsbutton.setVisible(true);
				subjectorrollcombo.setLocation(coursenamecombo.getLocation());
				fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(),semoryearcombo.getY());
				scrollPane.setLocation(scrollPane.getX(),fetchdetailsbutton.getY()+50);
				subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new StudentData().getRollNumber(fm.f.getCourseCode(), semoryearcombo.getSelectedIndex())));		
				scrollPane.setVisible(false);
				
			}
			
		}
		);
		subjectWisebutton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				activeButton(subjectWisebutton);
				disableButton(studentWisebutton);
				disableButton(classWisebutton);
				disableButton(declareresultbutton);
				label3.setVisible(true);
				subjectorrollcombo.setVisible(true);
				label3.setText("Select Subject :");
				fetchdetailsbutton.setVisible(true);
				subjectorrollcombo.setLocation(coursenamecombo.getLocation());
				fetchdetailsbutton.setLocation(fetchdetailsbutton.getX(),semoryearcombo.getY());
				scrollPane.setLocation(scrollPane.getX(),fetchdetailsbutton.getY()+50);
				String[] totalsub=new SubjectData().getSubjectinCourse(fm.f.getCourseCode(), fm.f.getSemorYear());	
				subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(totalsub));
				scrollPane.setVisible(false);
				
			}
			
		}
		);
		classWisebutton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				subjectWisebutton.setName("Active");
				activeButton(classWisebutton);
				disableButton(studentWisebutton);
				disableButton(subjectWisebutton);
				disableButton(declareresultbutton);
				subjectorrollcombo.setVisible(false);
				label3.setVisible(false);
				scrollPane.setLocation(scrollPane.getX(), coursenamecombo.getY());
				fetchdetailsbutton.setVisible(false);
				createtablemodel();
			}
			
		}
		);
		
	}
	public void activeButton(JButton button)
	{
		if(submitbutton!=null)
		{
		submitbutton.setVisible(false);
		}
		button.setBorder(new LineBorder(new Color(255, 255, 255)));
		button.setForeground(new Color(0, 139, 139));
		button.setBackground(new Color(255, 255, 255));
		button.setFocusPainted(false);
		button.setName("Active");		
	}
	public void disableButton(JButton button)
	{

		button.setBorder(new LineBorder(new Color(255, 255, 255)));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(32, 178, 170));
		button.setFocusPainted(false);
		button.setName("Deactive");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Errorlabel.setVisible(false);
		if(e.getSource()==coursenamecombo)
		{
			coursenamecombo.setFocusable(false);
			
			subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
			if(coursenamecombo.getSelectedIndex()==0)
			{
				semoryearcombo.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
				
			}
			else
			{
			 String course=(String) coursenamecombo.getSelectedItem();
			
			 semoryearcombo.setModel(new DefaultComboBoxModel<String>(new CourseData().getSemorYear(course)));
			}
		 
		}
		if(e.getSource()==semoryearcombo && semoryearcombo.getSelectedIndex()>0)
		{
			 String course=(String) coursenamecombo.getSelectedItem();
			
			 if(subjectWisebutton.getName().equals("Active"))
			 {
				String[] totalsub=new SubjectData().getSubjectinCourse(new CourseData().getCoursecode(course), semoryearcombo.getSelectedIndex());
				if(totalsub!=null)
				{
					subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(totalsub));
				}
				else
				{
				
						subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new String[] {"No Subject Found"}));
				}
			 }
			 else if(studentWisebutton.getName().equals("Active"))
			 {
					 subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new StudentData().getRollNumber(new CourseData().getCoursecode(course), semoryearcombo.getSelectedIndex())));
			 }
		}
		else if(e.getSource()==semoryearcombo)
		{
			subjectorrollcombo.setModel(new DefaultComboBoxModel<String>(new String[] {""}));	
		}
		if(e.getSource()==fetchdetailsbutton)
		{
			
			if(declareresultbutton.getName().equals("Active"))
			{
				
				if(coursenamecombo.getSelectedIndex()==0)
				{
					showerror(coursenamecombo);
				}
				else
				{
					createTableForDeclareResult(coursenamecombo.getSelectedItem()+"");
				}
			}
			else
			{
				if(coursenamecombo.getSelectedIndex()==0)
				{
					showerror(coursenamecombo);
				}
				else if(semoryearcombo.getSelectedIndex()==0)
				{
					showerror(semoryearcombo);
				}
				else if(subjectorrollcombo.isVisible() && subjectorrollcombo.getSelectedItem().equals("No Subject Found"))
				{
					Component tf=subjectorrollcombo;
					Errorlabel.setVisible(true);
					Errorlabel.setText("No Subject Found !");
					Errorlabel.setBounds(tf.getX(), tf.getY()+tf.getHeight()-5, 400,26);
				}
				else if(subjectorrollcombo.isVisible() && subjectorrollcombo.getSelectedIndex()==0)
				{
					showerror(subjectorrollcombo);
				}
			
				else
				{
					this.createtablemodel();
					
				}
			}
		}
	}
	public void showerror(JComponent tf)
	{
		Errorlabel.setVisible(true);
		Errorlabel.setText("This is required question !");
		Errorlabel.setBounds(tf.getX(), tf.getY()+tf.getHeight()-5, 400,26);
	}
	public void createTableForDeclareResult(String course)
	{
		submitbutton.setVisible(true);
		String columnname[]= {"Course","Sem","Course Name",""};
		DefaultTableModel model=new DefaultTableModel(columnname,0)
				{
					boolean isEdit[]= {false,false,false,true};
					@Override
					public boolean isCellEditable(int row,int column)
					{
						return isEdit[column];
					}
					@Override
					public Class<?> getColumnClass(int column)
					{
						switch(column)
						{
						case 0: return String.class;
						case 1: return String.class;
						case 2:return String.class;
						case 3:return Boolean.class;
						default:return String.class;
						}
					}
				};
		ArrayList<Course> list=new CourseData().getCoursesForDeclareResult(course);
		for(int i=0; i<list.size(); i++)
		{
			model.addRow(new Object[0]);
			Course c=list.get(i);
			model.setValueAt(c.getCourseCode(), i, 0);
			model.setValueAt(c.getSemorYear(), i, 1);
			model.setValueAt(c.getCourseName(), i, 2);
			model.setValueAt(c.getIsDeclared(), i, 3);
			
		}
		table.setModel(model);
		totalstudent=list.size();
		scrollPane.setSize(scrollPane.getWidth(), 40+(totalstudent*40));
		submitbutton.setLocation(submitbutton.getX(), scrollPane.getY()+scrollPane.getHeight()+20);
		this.setSize(1116, scrollPane.getY()+80+totalstudent*40+40);
	
		
		
		 table.getColumnModel().getColumn(3).setHeaderRenderer(
		            new HeaderRendererForCheckBox(table.getTableHeader(),3));
		 
		 	DefaultTableCellRenderer cellrenderer=new DefaultTableCellRenderer();
			cellrenderer.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(cellrenderer);
			table.getColumnModel().getColumn(1).setCellRenderer(cellrenderer);
			table.getColumnModel().getColumn(2).setCellRenderer(cellrenderer);
			table.setSelectionBackground(new Color(240, 255, 255));
			table.setSelectionForeground(Color.black);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			this.setIcons(table, 3, new ImageIcon("./assets/unselectedcheckboxicon.png"), new ImageIcon("./assets/selectedcheckboxicon.png"));
			scrollPane.setVisible(true);
			if(list.size()==0)
			{
				noDataFound();
			}
	}
	public void setIcons(JTable table, int column, Icon icon, Icon selectedIcon) {
	    JCheckBox cellRenderer = (JCheckBox) table.getCellRenderer(0, column);
	    cellRenderer.setSelectedIcon(selectedIcon);
	    cellRenderer.setIcon(icon);

	    DefaultCellEditor cellEditor = (DefaultCellEditor) table.getCellEditor(0, column);
	    JCheckBox editorComponent = (JCheckBox) cellEditor.getComponent();
	    editorComponent.setSelectedIcon(selectedIcon);
	    editorComponent.setIcon(icon);
	}
	public void createtablemodel()
	{
		nodatafoundlabel.setVisible(false);
		Marks m=new Marks();
		m.setCourseCode(new CourseData().getCoursecode(coursenamecombo.getSelectedItem()+""));
		m.setSemorYear(semoryearcombo.getSelectedIndex());
		if(subjectWisebutton.getName().equals("Active"))
		{
		m.setSubjectName(subjectorrollcombo.getSelectedItem()+"");
		m.setSubjectCode(new SubjectData().getSubjectCode(m.getCourseCode(), m.getSemorYear(), m.getSubjectName()));
		}
		else if(classWisebutton.getName().equals("Active"))
		{
			m.setSubjectName("All");
		}
		else if(studentWisebutton.getName().equals("Active"))
		{
			m.setRollNumber(Long.parseLong(subjectorrollcombo.getSelectedItem()+""));
		}
		table.setModel(createModel(m));
		scrollPane.setSize(scrollPane.getWidth(), 40+(totalstudent*40));
		this.setSize(1116, scrollPane.getY()+scrollPane.getHeight()+40);
	
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(250);
		table.getColumnModel().getColumn(2).setMaxWidth(200);
		table.getColumnModel().getColumn(3).setMaxWidth(250);
		table.getColumnModel().getColumn(4).setMaxWidth(230);
		table.getColumnModel().getColumn(5).setMaxWidth(200);
		DefaultTableCellRenderer cellrenderer=new DefaultTableCellRenderer();
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
		if(totalstudent==0)
		{
			noDataFound();
		}
		
	}
	public DefaultTableModel  createModel(Marks m)
	{
		String Column[]= {"Roll Number","Student Name","Class","Subject","Total Marks","Obtained Marks"};
	
		DefaultTableModel model=new DefaultTableModel(Column,0)
				{
					boolean isEdit[]= {false,false,false,false,false,false};
					@Override
					public boolean isCellEditable(int row,int column)
					{
					return 	isEdit[column];
					}
				};	
				
		ArrayList<Marks> list=null;
			if(studentWisebutton.getName().equals("Active"))
			{
				list=new StudentData().getMarkssheetOfStudent(m.getCourseCode(), m.getSemorYear(), m.getRollNumber());
			}
			else if(subjectWisebutton.getName().equals("Active"))
			{
				list=new StudentData().getMarksheetReportBySubject(m);
			}
			else if(classWisebutton.getName().equals("Active"))
			{
				list=new StudentData().getMarksheetReportByClass(m);
			}
			for(int i=0; i<list.size(); i++)
			{
				
				model.addRow(new Object[0]);
				model.setValueAt(list.get(i).getRollNumber(), i, 0);
				model.setValueAt(list.get(i).getStudentName(), i, 1);
				model.setValueAt(m.getCourseCode()+"-"+m.getSemorYear(), i, 2);
				model.setValueAt(list.get(i).getSubjectName(), i, 3);
				model.setValueAt(list.get(i).getMaxPracticalMarks()+list.get(i).getMaxTheoryMarks(), i, 4);
				model.setValueAt(list.get(i).getPracticalMarks()+list.get(i).getTheoryMarks(), i, 5);
			}
			totalstudent=list.size();
			table.setEnabled(true);
			return model;
		
	}
	public void noDataFound()
	{
		scrollPane.setVisible(false);
		nodatafoundlabel.setVisible(true);
		nodatafoundlabel.setLocation(nodatafoundlabel.getX(), scrollPane.getY()-100);
		
	}
	class MouseAdapterForTable extends MouseAdapter
	{
		AdminMain am=null;
		public MouseAdapterForTable(AdminMain am)
		{
		this.am=am;
		}
			public void mousePressed(MouseEvent e)
			{
				if(e.getClickCount()>1  && e.getButton()==MouseEvent.BUTTON1&&!declareresultbutton.getName().equals("Active"))
				{
				
			JTable t=(JTable) e.getSource();
			int row=t.getSelectedRow();
			
			String  strsem=table.getValueAt(row, 2)+"";
			int sem=Integer.parseInt(strsem.substring(strsem.indexOf('-')+1));
			String coursecode=strsem.substring(0,strsem.indexOf('-'));
			String strroll=table.getValueAt(row, 0)+"";
			long rollnumber=Long.parseLong(strroll);
			Student s=new StudentData().getStudentDetails(coursecode,sem,rollnumber);
			
			am.viewstudentpanel=new ViewStudentPanel(s,am,am.marksheetreportpanelscroll);
			am.viewstudentpanel.setVisible(true);
			am.marksheetreportpanelscroll.setVisible(false);
			am.viewstudentpanel.setLocation(am.panelx,0);
			am.viewstudentpanel.setVisible(true);
			am.viewstudentpanel.setFocusable(true);
			am.contentPane.add(am.viewstudentpanel);
			}
			
		}
	
	}
	private class DeclareResult implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			for(int i=0; i<table.getRowCount(); i++)
			{
				Course course=new Course();
				course.setCourseCode(table.getValueAt(i, 0)+"");
				course.setSemorYear(Integer.parseInt(table.getValueAt(i, 1)+""));
				course.setIsDeclared(Boolean.parseBoolean(table.getValueAt(i, 3)+""));
				new CourseData().declareResult(course);
			}
			JOptionPane.showMessageDialog(null, "Result Declared");
			scrollPane.setVisible(false);
			submitbutton.setVisible(false);
			setSize(getWidth(),600);
		}
		
	}
}

	

