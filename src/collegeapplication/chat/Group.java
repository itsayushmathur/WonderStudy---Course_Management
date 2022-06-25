package collegeapplication.chat;

import java.awt.Image;

/**
 * @author Ayush Mathur
 * @mail: mathurayush121@gmail.com
 */


class Group {
	private Image groupimage;
	private String groupname;
	private int members;
	private String coursecode;
	private int semoryear;

	public void setImage(Image image) {
		this.groupimage = image;
	}

	public void setGroupName(String groupname) {
		this.groupname = groupname;
	}

	public void setCourseCode(String coursecode) {
		this.coursecode = coursecode;
	}

	public void setSem(int semoryear) {
		this.semoryear = semoryear;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	public Image getImage() {
		return groupimage;
	}

	public String getGroupName() {
		return groupname;
	}

	public String getCourseCode() {
		return coursecode;
	}

	public int getSemorYear() {
		return semoryear;
	}

	public int getMembers() {
		return members;
	}

}