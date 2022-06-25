package collegeapplication.course;

/**
 * @author Ayush Mathur
 * @mail: mathurayush121@gmail.com
 */


public class Course {

	private String coursecode;
	private int semoryear;
	private boolean isdeclared;
	private String coursename;

	public void setCourseName(String coursename) {
		this.coursename = coursename;
	}

	public void setCourseCode(String coursecode) {
		this.coursecode = coursecode;
	}

	public void setSemorYear(int semoryear) {
		this.semoryear = semoryear;
	}

	public void setIsDeclared(boolean isdeclared) {
		this.isdeclared = isdeclared;
	}

	public String getCourseName() {
		return coursename != null ? coursename : new CourseData().getcoursename(coursecode);
	}

	public String getCourseCode() {
		return coursecode;
	}

	public int getSemorYear() {
		return semoryear;
	}

	public boolean getIsDeclared() {
		return isdeclared;
	}
}
