package emirim.hs.kr.dormitory;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import emirim.hs.kr.dormitory.models.Buy;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Eun bee on 2016-11-10.
 */

public class DialogFragmentBuy extends DialogFragment {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    Button ok_btn;
    String needThings,number;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_fragment_buy);
        ok_btn = (Button) dialog.findViewById(R.id.add_buy);
        ok_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(((EditText)dialog.findViewById(R.id.edit_things)).getText().toString()!=null)
                    needThings = ((EditText)dialog.findViewById(R.id.edit_things)).getText().toString();
                if(((EditText)dialog.findViewById(R.id.edit_number)).getText().toString()!=null)
                    number = ((EditText)dialog.findViewById(R.id.edit_number)).getText().toString();
                Buy buy = new Buy(needThings,Integer.parseInt(number));
                databaseReference.child("Buy").push().setValue(buy);
                dismiss();
            }
        });
        return dialog;
    }
}
