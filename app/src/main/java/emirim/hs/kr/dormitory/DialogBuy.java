package emirim.hs.kr.dormitory;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import emirim.hs.kr.dormitory.models.Room;

/**
 * Created by Eun bee on 2016-11-21.
 */

public class DialogBuy extends BaseActivity2{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater1=getLayoutInflater();
        final View dialogView1= inflater1.inflate(R.layout.activity_dialog, null);

        AlertDialog.Builder buider1= new AlertDialog.Builder(this);
        buider1.setTitle("사오렴");
        buider1.setView(dialogView1);
        buider1.setPositiveButton("Create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        buider1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogBuy.this, "방 생성을 취소합니다", Toast.LENGTH_SHORT).show();
            }
        });
        final AlertDialog dialog1=buider1.create();
        dialog1.show();
    }
}
