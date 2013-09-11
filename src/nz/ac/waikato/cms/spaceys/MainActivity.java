package nz.ac.waikato.cms.spaceys;

import com.example.swypedoc.R;
import com.example.swypedoc.R.id;
import com.example.swypedoc.R.layout;
import com.example.swypedoc.R.menu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

public class MainActivity extends Activity implements Canvas.CanvasListener, View.OnClickListener{

	Dialog dialog;
	 PopupWindow popUpTitle;
     EditText popUpEditTextTitle;
     Button buttonConfirmTitle;
     Button buttonCancelTitle;
     
     PopupWindow popUpContent;
     EditText popUpEditTextContent;
     Button buttonConfirmContent;
     Button buttonCancelContent;
     
     PopupWindow popUpEdit;
     EditText popUpEditTextEdit;
     Button buttonConfirmEdit;
     Button buttonCancelEdit;
     
     //0 = AddTitle, 1 = AddContent, 2 = EditContent
     int popUpState = 0;
     Modules mod;
     Canvas can;
     String title;
     String content;
     
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.workspace);
		
		SignInDialogFragment bleh = new SignInDialogFragment();
		bleh.show(getFragmentManager(), title);
		LayoutInflater inflater = (LayoutInflater)
				this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		

		
		View layoutTitle = inflater.inflate(R.layout.popup_title, null, false);
		popUpTitle = new PopupWindow(layoutTitle, 100, 100, true);
		popUpEditTextTitle = (EditText) layoutTitle.findViewById(R.id.popup_editTextTitle);
		buttonConfirmTitle = (Button) layoutTitle.findViewById(R.id.buttonConfirmTitle);
		buttonCancelTitle = (Button) layoutTitle.findViewById(R.id.buttonCancelTitle);
		
		View layoutContent = inflater.inflate(R.layout.popup_content, null, false);
		popUpContent = new PopupWindow(layoutContent, 100, 100, true);
		popUpEditTextContent = (EditText) layoutContent.findViewById(R.id.popup_editTextContent);
		buttonConfirmContent = (Button) layoutContent.findViewById(R.id.buttonConfirmContent);
		buttonCancelContent = (Button) layoutContent.findViewById(R.id.buttonCancelContent);
		
		View layoutEdit = inflater.inflate(R.layout.dialog_edit, null, false);
		//popUpEdit = new PopupWindow(layoutEdit, 100, 100, true);
		//popUpEditTextEdit = (EditText) layoutEdit.findViewById(R.id.popup_editTextEdit);
		
		mod = (Modules)
	     		getFragmentManager().findFragmentById(R.id.module_fragment);
		can = (Canvas)
				getFragmentManager().findFragmentById(R.id.canvas_fragment);
		
	
		
		buttonConfirmTitle.setOnClickListener(this);
		buttonCancelTitle.setOnClickListener(this);
		buttonConfirmContent.setOnClickListener(this);
		buttonCancelContent.setOnClickListener(this);		
	}

	
	@Override
	public void onClick(View v) {
		if (v.equals(buttonConfirmTitle) && popUpState == 0) {

			title = popUpEditTextTitle.getText().toString();
			
			if(mod.listOfTitles.contains(title)) {
				mod.Toasty("This title already exists, please choose another");
				popUpTitle.dismiss();
				onButtonAddClick();
			}
		}
		if (v.equals(buttonCancelTitle) && popUpState == 0)
			popUpTitle.dismiss();
		if(v.equals(buttonConfirmContent) && popUpState == 1) {
			mod.listOfTitles.add(title);
			content = popUpEditTextContent.getText().toString();
			popUpContent.dismiss();
			mod.addValue(title + "\n\n" + content);
		}
		if (v.equals(buttonCancelContent) && popUpState == 1)
			popUpContent.dismiss();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onButtonAddClick () {
		AddTemplateDialogFragment atdf = new AddTemplateDialogFragment();
		atdf.show(getFragmentManager(), title);
	}

	@Override
	public void onButtonDeleteClick() {
		DeleteTemplateDialogFragment dtdf = new DeleteTemplateDialogFragment();
		dtdf.show(getFragmentManager(), title);	
	}

	@Override
	public void onButtonDeleteAll() {
		DeleteAllTemplatesDialogFragment datdf = new DeleteAllTemplatesDialogFragment();
		datdf.show(getFragmentManager(), title);
	}

	@Override
	public void onButtonEdit() {
		EditTextDialogFragment etdf = new EditTextDialogFragment();
		etdf.show(getFragmentManager(), content);
	}
}
