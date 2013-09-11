package nz.ac.waikato.cms.spaceys;

import java.util.List;

import com.example.swypedoc.R;
import com.example.swypedoc.R.id;
import com.example.swypedoc.R.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SelectedAdapter extends ArrayAdapter{

	// used to keep selected position in ListView
	private int selectedPos = -1;	// init value for not-selected

	public SelectedAdapter(Context context, int textViewResourceId,
                       List objects) {
		super(context, textViewResourceId, objects);
	}

	public void setSelectedPosition(int pos){
		selectedPos = pos;
		// inform the view of this change
		notifyDataSetChanged();
	}

	public int getSelectedPosition(){
		return selectedPos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	    View v = convertView;

	    // only inflate the view if it's null
	    if (v == null) {
	        LayoutInflater vi
                        = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        v = vi.inflate(R.layout.selectrow, null);
	    }

	    // get text view
        TextView label = (TextView)v.findViewById(R.id.txtExample);

        // change the row color based on selected state
        if(selectedPos == position){
        	label.setBackgroundColor(Color.CYAN);
        }else{
        	label.setBackgroundColor(Color.WHITE);
        }

        label.setText(this.getItem(position).toString());
        /*
        // to use something other than .toString()
        MyClass myobj = (MyClass)this.getItem(position);
        label.setText(myobj.myReturnsString());
        */
        return(v);
	}
}