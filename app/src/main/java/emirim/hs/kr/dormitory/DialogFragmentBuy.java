package emirim.hs.kr.dormitory;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import emirim.hs.kr.dormitory.models.Buy;

/**
 * Created by Eun bee on 2016-delete_things-10.
 */

public class DialogFragmentBuy extends DialogFragment {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    Button ok_btn;
    String needThings,number;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_fragment_buy);
        return dialog;
    }
}
