package collegeapplication.student;

import collegeapplication.subject.Subject;

/**
 * @author Ayush Mathur
 * @mail: mathurayush121@gmail.com
 */


public class Attendance extends Subject {
	private String studentname;
	private String date;
	private int attendance;
	private int totalattendance;
	private long rollnumber;
	private boolean present;

	public void setAttendanceDate(String date) {
		this.date = date;
	}

	public void setStudentName(String studentname) {
		this.studentname = studentname;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public void setTotalAttendance(int totalattendance) {
		this.totalattendance = totalattendance;
	}

	public void setPresentStatus(boolean presentstatus) {
		this.present = presentstatus;
	}

	public void setRollNumber(long rollnumber) {
		this.rollnumber = rollnumber;
	}

	public String getStudentName() {
		return studentname;
	}

	public long getRollNumber() {
		return rollnumber;
	}

	public int getAttendance() {
		return attendance;
	}

	public int getTotalAttendance() {
		return totalattendance;
	}

	public String getAttendanceDate() {
		return date;
	}

	public boolean getPresentStatus() {
		return present;
	}

}