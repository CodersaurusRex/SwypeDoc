package nz.ac.waikato.cms.spaceys;

import com.example.swypedoc.R;
import com.example.swypedoc.R.id;
import com.example.swypedoc.R.layout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class AddTemplateDialogFragment  extends DialogFragment {
	
	EditText title;
	EditText content;
	Modules mod;
	@Override
	public Dialog onCreateDialog (Bundle savedInstanceState) {
		mod =  (Modules)
	     		getFragmentManager().findFragmentById(R.id.module_fragment);
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View v = inflater.inflate(R.layout.dialog_add, null);
		
		builder.setView(v);

		builder.setMessage("Adding A New Template");
		title = (EditText) v.findViewById(R.id.editText1Add);
		content = (EditText) v.findViewById(R.id.editText2Add);
			builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {
					title = title.getText().toString();
					
					if(mod.listOfTitles.contains(title)) {
						mod.Toasty("This title already exists, please choose another");
						popUpTitle.dismiss();
						onButtonAddClick();
					}
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {	
					AddTemplateDialogFragment.this.getDialog().cancel();
				}
			});
		return builder.create();
	}
}