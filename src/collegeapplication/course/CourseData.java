package collegeapplication.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import collegeapplication.common.DataBaseConnection;
import collegeapplication.common.Notification;
import collegeapplication.common.NotificationData;
import collegeapplication.common.TimeUtil;

/**
 * @author Ayush Mathur
 * @mail: mathurayush121@gmail.com
 */


public class CourseData
{
	
	static Connection con=DataBaseConnection.getConnection();

	public static void closeConnection() throws SQLException
	{
		con.close();
	}
	public int addCourse(String coursecode,String coursename,String semoryear,int totalyearorsem)
	{
		int result=0;
		try 
		{
		String query="insert into courses values(?,?,?,?,?)";
		PreparedStatement pr=con.prepareStatement(query);
		pr.setInt(1,0);
		pr.setString(2, coursecode.toUpperCase());
		pr.setString(3, coursename);
		pr.setString(4, semoryear);
		pr.setInt(5, totalyearorsem);
		result=pr.executeUpdate();
			
			pr.close();
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return result;
	}
	
	public  ResultSet getCourseinfo()
	{
	
		ResultSet st=null;
		try
		{
			String query="select c.sr_no as 'Index no.',c.coursecode as 'Course Code' ,c.coursename as 'Course Name',(select count(*) from subject where subject.coursecode=c.coursecode) as 'Subjects' ,(select count(*) from students where students.coursecode=c.coursecode) as 'Students',concat(c.totalsemoryear,' ',c.semoryear) as 'Total Sem/Year' from courses c;";
			PreparedStatement pr=con.prepareStatement(query);
			
			st=pr.executeQuery();
			return st;
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return st;
	}
	public int getTotalCourse()
	{
		int totalrow=0;
		try
		{
			Statement pr=con.createStatement();
			ResultSet st=pr.executeQuery("select * from courses");
			while(st.next())
			{
				totalrow++;
			}
			pr.close();
		
			return totalrow;
			
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return totalrow;
	}
	
	
	
	public String[] getCourseName()
	{
				String coursename[];
				int i=0;
				coursename=new String[getTotalCourse()+1];
				coursename[i++]="---Select Course---";
		
				try
				{
					Statement pr=con.createStatement();
					ResultSet st=pr.executeQuery("select coursename from courses");
					
					
					while(st.next())
					{
						coursename[i++]=st.getString(1);
					}
					pr.close();
					st.close();
					return coursename;
					
				}
				catch(Exception exp)
				{
					exp.printStackTrace();
				}
		return coursename;
		
	}
	public int getRollTotalCourse()
	{
		int totalrow=0;
		try
		{
			Statement pr=con.createStatement();
			ResultSet st=pr.executeQuery("select coursename from courses where coursecode Not IN(select distinct coursecode from rollgenerator)");             
			while(st.next())
			{
				totalrow++;
			}
			pr.close();
			st.close();
			return totalrow;
			
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return totalrow;
	}
	public String[] getRollCourseName()
	{
				String coursename[];
				int i=0;
				coursename=new String[getRollTotalCourse()+1];
				coursename[i++]="---select---";
		
				try
				{
					Statement pr=con.createStatement();
					ResultSet st=pr.executeQuery("select coursename from courses where coursecode NOT IN(select distinct coursecode from rollgenerator)");
					
					
					while(st.next())
					{
						coursename[i++]=st.getString(1);
					}
					pr.close();
					st.close();
					return coursename;
					
				}
				catch(Exception exp)
				{
					exp.printStackTrace();
				}
		return coursename;
		
	}
	public String[] getSemorYear(String Coursename)
	{
		String query="select semoryear, totalsemoryear from courses where coursename='"+Coursename+"'";
		String totalsem[]=new String[1];
		totalsem[0]="---Select Sem/Year---";
		if(!Coursename.contains("--select--"))
		{
			try
			{
				Statement pr=con.createStatement();
				ResultSet st=pr.executeQuery(query);
				st.next();
				String semoryear=st.getString(1);
				int totalsemoryear=st.getInt(2);	
				
				totalsem=new String[totalsemoryear+1];
				if(semoryear.contains("sem"))
				{
					semoryear="Semester";
				}
				else
				{
					semoryear="Year";
				}
				totalsem[0]="---Select "+semoryear+"---";
				for(int i=1; i<=totalsemoryear; i++)
				{
					totalsem[i]=semoryear+" "+i;
				}
				pr.close();
				st.close();
				return totalsem;
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
			}
		}
		return totalsem;
		
	}
	public String[] getCoursecode()
	{
		String coursecode[]=new String[this.getTotalCourse()];
		String query="select coursecode from courses";
		try
		{
			Statement pr=con.createStatement();
			ResultSet st=pr.executeQuery(query);
			int i=0;
			while(st.next())
			{
				coursecode[i++]=st.getString(1);
			}
			pr.close();
			st.close();
			
			return coursecode;
			
			
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return coursecode;
		
		
	}
	public String getCoursecode(String coursename)
	{
		String query="select coursecode from courses where coursename='"+coursename+"'";
		String coursecode=null;
		try
		{
			Statement pr=con.createStatement();
			ResultSet st=pr.executeQuery(query);
	
				st.next();
				coursecode=st.getString(1);
			
				pr.close();
				st.close();
			return coursecode;
			
			
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return coursecode;
	}
	public String getsemoryear(String coursecode)
	{
		String query="select semoryear from courses where coursecode='"+coursecode+"'";
		String semoryear=null;
		try
		{
			Statement pr=con.createStatement();
			ResultSet st=pr.executeQuery(query);
	
				st.next();
				semoryear=st.getString(1);
			
				pr.close();
				st.close();
			return semoryear;
			
			
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return semoryear;
	}
	public String getcoursename(String coursecode)
	{
		String query="select coursename from courses where coursecode='"+coursecode+"'";
		String coursename=null;
		try
		{
			Statement pr=con.createStatement();
			ResultSet st=pr.executeQuery(query);
	
				st.next();
				coursename=st.getString(1);
			
				pr.close();
				st.close();
			return coursename;
			
			
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return coursename;
	}
	public int getTotalsemoryear(String coursename)
	{
		String query="select totalsemoryear from courses where coursename='"+coursename+"'";
		int totalsemoryear=0;
		try
		{
			Statement pr=con.createStatement();
			ResultSet st=pr.executeQuery(query);
			while(st.next())
			{
			totalsemoryear=st.getInt(1);
			}
			pr.close();
			st.close();
			
			return totalsemoryear;
			
			
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return totalsemoryear;
	}
	public boolean isCourseCodeExist(String coursecode)
	{
		try
		{
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(*) from courses where coursecode='"+coursecode+"'");
			rs.next();
			if(rs.getInt(1)>0)
			{
				return true;
			}
			rs.close();
			st.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean isCourseNameExist(String coursename)
	{
		try
		{
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(*) from courses where coursename='"+coursename+"'");
			rs.next();
			if(rs.getInt(1)>0)
			{
				return true;
			}
			rs.close();
			st.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean isDeclared(String coursecode,int semoryear)
	{
		boolean isdeclared=false;
		try
		{
			String query="select isdeclared from result where coursecode='"+coursecode+"' and semoryear="+semoryear;
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
			isdeclared=rs.getBoolean(1);
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return isdeclared;
	}
	public ArrayList<Course> getCoursesForDeclareResult(String coursename)
	{
		ArrayList<Course> list=new ArrayList<Course>();
		try
		{
			String query="select coursename,coursecode,totalsemoryear from courses where coursename='"+coursename+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				int totalsem=rs.getInt(3);
				for(int i=0; i<totalsem; i++)
				{
					Course course=new Course();
					course.setCourseName(rs.getString(1));
					course.setCourseCode(rs.getString(2));
					course.setSemorYear((i+1));
					course.setIsDeclared(isDeclared(rs.getString(2),(i+1)));
					list.add(course);
				}
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return list;
	}
	public int updateResult(Course c)
	{
		int result=0;
		try
		{
			String query="update result set isdeclared="+c.getIsDeclared()+" where coursecode='"+c.getCourseCode()+"' and semoryear="+c.getSemorYear();
			PreparedStatement pr=con.prepareStatement(query);
			result=pr.executeUpdate();
		}
		catch(Exception exp) 
		{
			exp.printStackTrace();
		}
		return result;
	}
	public void declareResult(Course c)
	{
		try
		{		if(c.getIsDeclared())
				{
					Notification n=new Notification();
					n.setUserProfile("Student");
					n.setCourseCode(c.getCourseCode());
					n.setSemorYear(c.getSemorYear());
					n.setTitle("Result");
					n.setUserId("Admin");
					n.setMessage("Your result is declared. now you can see your marksheet.");
					n.setTime(TimeUtil.getCurrentTime());
					new NotificationData().addNotification(n);
					n.setMessage( c.getCourseCode()+" "+getsemoryear(c.getCourseCode())+"-"+c.getSemorYear()+" result is declared. now you can see student's marksheet.");
					n.setUserProfile("Faculty");
					new NotificationData().addNotification(n);
				}
				if(updateResult(c)==0)
				{
				String query="insert into result values(?,?,?)";
				PreparedStatement pr=con.prepareStatement(query);
				pr.setString(1,c.getCourseCode());
				pr.setInt(2, c.getSemorYear());
				pr.setBoolean(3, c.getIsDeclared());
				pr.executeUpdate();
				}
				
				
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
	}
	
}

