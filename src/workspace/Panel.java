package workspace;

import modules.ModuleList;

public abstract class Panel {
	private ModuleList listOfModules = new ModuleList();
	
	public abstract void Draw();

	/**
	 * @return the listOfModules
	 */
	public ModuleList getListOfModules() {
		return listOfModules;
	}

	/**
	 * @param listOfModules the listOfModules to set
	 */
	public void setListOfModules(ModuleList listOfModules) {
		this.listOfModules = listOfModules;
	}

}
