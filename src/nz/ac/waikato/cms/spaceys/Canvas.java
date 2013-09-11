package nz.ac.waikato.cms.spaceys;

import com.example.swypedoc.R;
import com.example.swypedoc.R.id;
import com.example.swypedoc.R.layout;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Canvas extends Fragment implements View.OnClickListener {

	private Button buttonAdd;
	private Button buttonDelete;
	private Button buttonDeleteAll;
	private Button buttonEdit;
	private EditText blah;
	CanvasListener activityCallback;
	
	public interface CanvasListener {
		public void onButtonAddClick ();
		public void onButtonDeleteClick ();
		public void onButtonDeleteAll();
		public void onButtonEdit();
	}
	
	@Override
	//Called when the fragment is first attached to the activity.
	//The activity must implement CanvasListener 
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			activityCallback = (CanvasListener) activity;
		}
		catch(ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement CanvasListener");
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.canvas, container, false);
		
		blah = (EditText) view.findViewById(R.id.editText1Canvas);
		
		buttonAdd =	(Button) view.findViewById(R.id.buttonAdd);
		buttonEdit = (Button) view.findViewById(R.id.buttonEdit);
		buttonDelete = (Button) view.findViewById(R.id.buttonDelete);
		buttonDeleteAll = (Button) view.findViewById(R.id.buttonDeleteAll);
		
		buttonAdd.setOnClickListener(this);
		buttonEdit.setOnClickListener(this);
		buttonDelete.setOnClickListener(this);
		buttonDeleteAll.setOnClickListener(this);
		
		return view;
	}
	@Override
	public void onClick(View view) {
		if (view.equals(buttonAdd))
			activityCallback.onButtonAddClick();
		if (view.equals(buttonDelete))
			activityCallback.onButtonDeleteClick();
		if (view.equals(buttonDeleteAll))
			activityCallback.onButtonDeleteAll();
		if (view.equals(buttonEdit))
			activityCallback.onButtonEdit();
		
	}
	
	public void setText(String text) {
		blah.setText(text);
	}

}
