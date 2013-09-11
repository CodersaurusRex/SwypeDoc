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

public class EditTextDialogFragment  extends DialogFragment {
	
	EditText content;
	Modules mod;
	@Override
	public Dialog onCreateDialog (Bundle savedInstanceState) {
		mod =  (Modules)
	     		getFragmentManager().findFragmentById(R.id.module_fragment);
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View v = inflater.inflate(R.layout.dialog_edit, null);
		
		builder.setView(v);

		builder.setMessage(mod.templateTitle + " Editor");
		content = (EditText) v.findViewById(R.id.dialog_editTextEdit);
		content.setText(mod.templateContent);
			builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {
					mod.Editor(mod.adapter.getSelectedPosition(), content.getText().toString());
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {	
					EditTextDialogFragment.this.getDialog().cancel();
				}
			});
		return builder.create();
	}
}
