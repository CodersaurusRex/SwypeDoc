package nz.ac.waikato.cms.spaceys;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.swypedoc.R;
import com.example.swypedoc.R.id;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Modules extends ListFragment {

	List<String> listOfTitles = new LinkedList<String>();
	SelectedAdapter adapter;
	ArrayList entries;
	ListView lv;
	String templateContent;
	String templateTitle;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		entries = new ArrayList();
		lv = (ListView) getView().findViewById(R.id.list);
		adapter = new SelectedAdapter(getActivity(), 0, entries);
		adapter.setNotifyOnChange(true);

		setListAdapter(adapter);
		
		getListView().setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView arg0, View view,
                                           int position, long id) {
				//if user clicks the same item, de-select it
				if(position == adapter.getSelectedPosition()) {
					adapter.setSelectedPosition(-1);
				}
				// user clicked a list item, make it "selected"
				else{
					adapter.setSelectedPosition(position);
					String[] SplitTemplate = ((String) getListView().getItemAtPosition(position)).split("\n\n", 2);
					templateTitle = SplitTemplate[0];
					templateContent = SplitTemplate[1];
				}
			}
        });		
	}
	
	public void Toasty (String text)
	{
		  Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
	}
	  
	public void addValue(String text) {
		  adapter.add(text);
	}
	  
	public void deleteValue(int position) {
			  adapter.remove((String) getListView().getItemAtPosition(position));
			  adapter.setSelectedPosition(-1);
	}
	  
	public void deleteAll() {
		  adapter.clear();
		  adapter.setSelectedPosition(-1);
	}
	
	public void Editor(int index, String text) {
		entries.set(index, templateTitle + "\n\n" + text);
		templateContent = text;
		getListView().invalidateViews();
	}
}
