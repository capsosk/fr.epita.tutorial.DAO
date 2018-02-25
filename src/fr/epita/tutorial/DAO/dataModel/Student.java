package fr.epita.tutorial.DAO.dataModel;

public class Student {
	private String Name;
	private String SID;
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	public String getSID() {
		return SID;
	}
	public void setSID(String sID) {
		SID = sID;
	}

	@Override
	public String toString() {
		return "Student [Name=" + Name + ", SID=" + SID + "]";
	}
	
	
	
}
