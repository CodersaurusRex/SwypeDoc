package nz.ac.waikato.cms.spaceys;

import com.example.swypedoc.R;
import com.example.swypedoc.R.id;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class DeleteTemplateDialogFragment  extends DialogFragment {
	
	Modules mod;
	@Override
	public Dialog onCreateDialog (Bundle savedInstanceState) {
		mod =  (Modules)
	     		getFragmentManager().findFragmentById(R.id.module_fragment);
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		builder.setMessage("Are you sure you wish to delete " + mod.templateTitle + "?");
			builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {
					mod.deleteValue(mod.adapter.getSelectedPosition());
					mod.getListView().invalidateViews();
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {	
					DeleteTemplateDialogFragment.this.getDialog().cancel();
				}
			});
		return builder.create();
	}

}
