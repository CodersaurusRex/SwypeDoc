package user;

import java.util.LinkedList;
import java.util.List;

import workspace.WorkSpace;

public class User {
	
	private String userName;
	private String password;
	private List<WorkSpace> workSpaces = new LinkedList<WorkSpace>();
	
	public User(String name, String password) {
		this.setUserName(name);
		this.setPassword(password);
		
		WorkSpace w = new WorkSpace("WorkSpace1");
		workSpaces.add(w);
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public boolean checkPassword(String password) {
		if(this.password == password)
			return true;
		return false;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Create a new workspace
	 */
	public void createNewWorkspace(String name){
		WorkSpace w = new WorkSpace(name);
		workSpaces.add(w);
	}
}
