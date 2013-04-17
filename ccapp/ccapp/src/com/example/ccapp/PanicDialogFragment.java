package com.example.ccapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PanicDialogFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(R.string.call)
		
		.setPositiveButton(R.string.call_execute, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id){
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:2152790135"));
				callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
				startActivity(callIntent);
			}
		})
		
		.setNegativeButton(R.string.call_cancel, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id){
				dialog.dismiss();
			}
		});
		
		return builder.create();
		
	}

}
