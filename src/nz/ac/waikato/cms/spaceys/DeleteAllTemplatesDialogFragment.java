package nz.ac.waikato.cms.spaceys;

import com.example.swypedoc.R;
import com.example.swypedoc.R.id;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class DeleteAllTemplatesDialogFragment  extends DialogFragment {
	
	Modules mod;
	@Override
	public Dialog onCreateDialog (Bundle savedInstanceState) {
		mod =  (Modules)
	     		getFragmentManager().findFragmentById(R.id.module_fragment);
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		builder.setMessage("You are about to delete all " + mod.adapter.getCount() +" fragments. Continue?");
			builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {
					mod.deleteAll();
					mod.getListView().invalidateViews();
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {	
					DeleteAllTemplatesDialogFragment.this.getDialog().cancel();
				}
			});
		return builder.create();
	}

}
