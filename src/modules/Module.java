package modules;

import java.util.LinkedList;
import java.util.List;


public class Module {

	private static int currentID = 1;
	private int id;
	private String name;
	private String text;
	private List<String> notes = new LinkedList<String>();
	private List<String> tags = new LinkedList<String>();
	
	/**
	 * Create a new blank module
	 */
	public Module(String n) {
		this.id = currentID + 1;
		currentID++;
		setName(n);
	}
	
	/**
	 * Create a new module
	 * 't' is the text that will be contained in the module
	 */
	public Module(String n, String t) {
		this.id = currentID + 1;
		currentID++;
		this.text = t;
		setName(n);
	}
	
	/**
	 * Create a new module
	 * 't' is the text that will be contained in the module
	 * 'n' is the note text for the module
	 */
	public Module(String n, String t, String[] notes)
	{
		this.id = currentID + 1;
		currentID++;
		setName(n);
		
		for(String s : notes)
			this.notes.add(s);
		
	}
	
	/**
	 * Create a new module with a unique id
	 * 
	 * @param n the name of the module
	 * @param t I think this needs to be removed
	 * @param notes The notes for this module
	 * @param tg
	 */
	public Module(String n, String t, String[] notes, String[] tg)
	{
		this.id = currentID + 1;
		currentID++;
		setName(n);
		
		for(String s : notes)
			this.notes.add(s);
		for(String s : tg)
			this.notes.add(s);
	}
	
	/*
	 * Here are some changes some inline comment
	 */

	/**
	 * Get the unique ID of this module
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * @return the _name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param _name the _name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Get the text of this module
	 */
	public String getText() {
		return this.text;
	}
	
	/*
	 * Set the text of this module
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/*
	 * Get the notes for this module in an array
	 */
	public String[] getNotes() {
		if(this.notes.isEmpty()) return null;
		String[] notes = new String[this.notes.size()];
		for(int i = 0; i < this.notes.size(); i++) {
			notes[i] = this.notes.get(i);
		}
		return notes;
	}
	
	/*
	 * add a note to the list of notes
	 */
	public void addNote(String text) {
		this.notes.add(text);
	}
	
	/*
	 * Removes a note given a string
	 * this probably needs to be changed!!!!!!!!!!!!!!!!!!!!!!!!!
	 */
	public boolean removeNote(String text){
		return removeFromList(this.notes, text);
	}

	/*
	 * Get the tags for this module in an array
	 */
	public String[] getTags() {
		if(this.tags.isEmpty()) return null;
		String[] notes = new String[this.tags.size()];
		for(int i = 0; i < this.tags.size(); i++) {
			notes[i] = this.tags.get(i);
		}
		return notes;
	}
	
	/*
	 * add a tag to the list of notes
	 */
	public void addTag(String text) {
		this.tags.add(text);
	}
	
	/*
	 * Removes a note given a string
	 * this probably needs to be changed!!!!!!!!!!!!!!!!!!!!!!!!!
	 */
	public boolean removeTag(String text){
		return removeFromList(this.tags, text);
	}
	
	/*
	 * remove a given string from a give linked list of strings
	 */
	public boolean removeFromList(List<String> tags2, String S){
		for(int i = 0;i<tags2.size(); i++){
			if(tags2.get(i) == S){
				tags2.remove(i);
				return true;
			}
		}
		return false;
	}
}
