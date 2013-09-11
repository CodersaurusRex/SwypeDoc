package workspace;

public class WorkSpace {
	private String name;
	private Panel canvas = new CanvasPanel();
	private Panel list = new ListPanel();
	public WorkSpace(String name){
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the canvas
	 */
	public Panel getCanvas() {
		return canvas;
	}
	/**
	 * @return the list
	 */
	public Panel getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(Panel list) {
		this.list = list;
	}
}
