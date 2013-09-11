package nz.ac.waikato.cms.spaceys;

import java.util.ArrayList;
import java.util.LinkedList;

import modules.Module;

/**
 * File:		FillList.java
 * 
 * OD:			Rex Chapman
 * Copyright:	Spacey's group
 * License:		All rights reserved TODO proper license	
 * 
 * Notes:		
 * Issues:		Currently finding a way to store more info within the listView to make 
 * 				the manipulation of the modules easier
 * Extends:		Activity
 * 
 */

import android.app.Activity;
import android.view.View;
import android.widget.*;

// Stuff up here
/**
 * This class to to work with the Global to get the lists of modules required to
 * create listViews within the GUI
 * 
 * To display new template list use {@link #createDocumentList(View, String)} To
 * display a Document {@link #createTemplateList(View)}
 * 
 * 
 * @author rc115
 * @since 05/09/2013
 * 
 */
public class FillList extends Activity {

	// two lists, one to hold template modules and one to hold modules that are on the document
	public LinkedList<Module> templateModuleList = new LinkedList<Module>();
	public LinkedList<Module> documentModuleList = new LinkedList<Module>();

	// two filename variables used for saving. One for the filename for the list of template modules...
	// ... and one for the filename of the list of modules on the document.
	private String _templateFileName;
	private String _documentFileName;

	/**
	 * This method will either create a new, empty listView if it is a new
	 * document or it will retrieve a saved document and load modules into a
	 * documentModuleList and create items for the listView in the
	 * document_holder fragment.
	 * 
	 * @date 04/09/2013
	 * @author rc115 Rex Chapman
	 * 
	 * @param listName
	 *            Name of list being accessed or "blank if new document"
	 * @param v
	 *            is for the View passed in, this will give which fragment is to
	 *            be updated
	 */
	public void createDocumentList(View v, String listName) {

		if (listName == "") {
			// TODO
			// this means it is not a template and no name for file is given so
			// we are making a blank...
			// ... document. this means a blank listView is created
		} else if (Global.getCanvas(listName)) {

			_documentFileName = listName;

			// listView with retrieved data

			documentModuleList = Global.getCanvas(listName);

			ArrayList<String> content = new ArrayList<String>();

			for (Module M : documentModuleList) {

				content.add(M.getText());
			}

		} else {
			Toast.makeText(getApplicationContext(),
					"Cannot find document: " + listName, Toast.LENGTH_SHORT)
					.show();
		}

	}

	/**
	 * Stores the templates into a list for future reference - may not need in
	 * future releases
	 * 
	 * Creates the listView for the templates
	 * 
	 * @param v is the view in the GUI to be updated
	 */
	public void createTemplateList(View v) {
		// TODO link to Global which will have a link to workspace which will
		// Return the list of modules
		templateModuleList = Global.getTemplates(); // get list created from
													// file read in from
													// workspace

		ArrayList<String> content = new ArrayList<String>();

		for (Module M : templateModuleList) {
			// TODO create listView to display to module_holder fragment

			content.add(M.getText());

		}

		// find file data associated with the templates (i.e full list for first
		// release)..
		// ... from here read in file and create listView with retrieved data

	}

	public void createTemplateList(View v, String filter) {
		_templateFileName = filter;
		templateModuleList = Global.getTemplates(filter);					// get list created from file read in from workspace
																	
		ArrayList<String> content = new ArrayList<String>();
		
		for (Module M : templateModuleList) {
			// TODO create listView to display to module_holder fragment
			
			content.add(M.getText());
			
		}
		
		
		// find file data associated with the templates (i.e full list for first
		// release)..
		// ... from here read in file and create listView with retrieved data

	}

	/**
	 * Save template back with same filename
	 * 
	 * Calls through to Global and then through to file handler to save module templates
	 */
	public void saveTemplate() {
		Global.saveTemplate(templateModuleList, _templateFileName);

		Toast.makeText(getApplicationContext(),"Saved" , Toast.LENGTH_SHORT).show();
	}

	/**
	 * Save templates with new filename
	 * Most likely to be called when original template list has been modified and the original is to be kept
	 *  
	 * 
	 * @param filename this will come from the save dialog box
	 */
	public void saveTemplateAs(String filename) {
		Global.saveTemplate(templateModuleList, filename);
		_templateFileName = filename;
		
		Toast.makeText(getApplicationContext(),"Saved as: " + filename, Toast.LENGTH_SHORT).show();
	}

	/**
	 * Save document using existing filename or get user to save as if the document has no name
	 * 
	 */
	public void saveDocument() {
		// most likely will be working on existing documents
		if(_documentFileName != ""){
			// save the document using filename and display saved confirmation
			Global.saveDocument(documentModuleList, _documentFileName); // send to global to call file handler
			Toast.makeText(getApplicationContext(),"Saved", Toast.LENGTH_SHORT).show();
		}
		else{
			// if the document is a new document, it will not have a name. So the SAVE AS option will be required
			Toast.makeText(getApplicationContext(), "Please select 'SAVE AS' to save a newly created document", 
							Toast.LENGTH_SHORT).show();
		}
	}
	
	/**
	 * Save document using a user defined filename for the document
	 * 
	 * @param filename user inputted string to set as filename for save
	 */
	public void saveDocumentAs(String filename) {
		Global.saveDocument(documentModuleList, filename); // send to global to call file handler
		// set filename in variable so future saves can just be saved without defining file name. Send save confirmation to the user
		_documentFileName = filename;
		Toast.makeText(getApplicationContext(),"Saved", Toast.LENGTH_SHORT).show();
	}
	
	//TODO
	/**
	 * this method will search for module that is to be edited and will then work with module
	 * check for document first as this is the most likely
	 */
	public void editModule(){
		
	}
	
	/**
	 * this method will get the module and allow its position to be changed.
	 * check for document first as this will be the most likely
	 */
	public void reOrderModule(){
		
	}
	
	/**
	 * this method will give the ability to delete modules and will reoder existing modules accordingly
	 * check for document first as this will be the most likely
	 */
	public void deleteModule(){
		
	}
	
	/**
	 * This method will allow the swyping of Modules and will "Remove" them by putting the at bottom of the list
	 * check for templates first as this is most likey
	 */
	public void removeModule(){
		
	}

}
