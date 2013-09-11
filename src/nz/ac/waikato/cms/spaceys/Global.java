package nz.ac.waikato.cms.spaceys;

import java.util.*;

import user.User;
import workspace.WorkSpace;

public class Global {
	private static Global globalSingleton;
	public WorkSpace workSpace;
	public User currentUser;
	private List<User> userList = new LinkedList<User>();
	
	private Global(){
		workSpace = new WorkSpace("Test");
	}
	
	/**
	 * Singleton Initializer
	 */
	public static Global getGlobal(){
		if(globalSingleton == null){
			globalSingleton = new Global();
		}
		return globalSingleton;
	}
	
	/**
	 * Create a new user
	 * @param n Is the name of the new user
	 * @param p Is the password for the user
	 */
	public void createUser(String n, String p){
		User u = new User(n,p);
		userList.add(u);
	}
	
	/**
	 * Delete A User
	 */
	public boolean deleteUser(User u){
		if(userList.contains(u)){
			userList.remove(u);
			return true;
		}
		return false;
	}
	
	/**
	 * Switch User
	 */
	public void switchUser(User u){
		currentUser = u;
	}
}
