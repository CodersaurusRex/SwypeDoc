package modules;

import java.util.LinkedList;
import java.util.List;


public class ModuleList {
	private List<Module> modules = new LinkedList<Module>();

	/**
	 * @return the modules
	 */
	public List<Module> getModules() {
		return modules;
	}

	public void addModule(Module m){
		modules.add(m);
	}
	
	public boolean removeModule(Module m){
		if(modules.contains(m)){
			modules.remove(m);
			return true;
		}
		return false;
	}
}
