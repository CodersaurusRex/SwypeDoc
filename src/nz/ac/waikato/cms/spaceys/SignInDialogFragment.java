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
import android.widget.Toast;

public class SignInDialogFragment  extends DialogFragment {
	
	EditText username;
	EditText password;
	@Override
	public Dialog onCreateDialog (Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View v = inflater.inflate(R.layout.dialog_signin, null);
		
		
		builder.setView(v);
		username = (EditText) v.findViewById(R.id.username);
		password = (EditText) v.findViewById(R.id.password);
			builder.setPositiveButton("Sign In", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {
					Toast.makeText(getActivity(), "Welcome, " + username.getText().toString() + "!", Toast.LENGTH_LONG).show();
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {	
					SignInDialogFragment.this.getDialog().cancel();
				}
			});
		return builder.create();
	}
}
