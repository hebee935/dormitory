package emirim.hs.kr.dormitory;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Eun bee on 2016-11-18.
 */

public class OpenRoomActivity extends AppCompatActivity implements View.OnClickListener{
    Button makeRoom,enterRoom;
    EditText roomPwSet,roomPwChk;
    EditText roomNumber,roomPw;
    TextView roomNumberRandom;
    int canClose=0;
    public void onCreate(Bundle savedInstanceState){
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_room);
        makeRoom = (Button)findViewById(R.id.makeRoom);
        enterRoom = (Button)findViewById(R.id.enterRoom);

        makeRoom.setOnClickListener(this);
        enterRoom.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.makeRoom:
                LayoutInflater inflater1=getLayoutInflater();
                final View dialogView1= inflater1.inflate(R.layout.activity_room_form, null);

                AlertDialog.Builder buider1= new AlertDialog.Builder(this);
                buider1.setTitle("방 생성하기");
                buider1.setView(dialogView1);
                roomNumberRandom = (TextView)dialogView1.findViewById(R.id.room_ran_num);
                roomNumberRandom.setText("새ㅔ빈");
                roomPwSet = (EditText) dialogView1.findViewById(R.id.room_pw_set);
                roomPwChk = (EditText)dialogView1.findViewById(R.id.room_pw_chk);
                buider1.setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                buider1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(OpenRoomActivity.this, "방 생성을 취소합니다", Toast.LENGTH_SHORT).show();
                    }
                });
                final AlertDialog dialog1=buider1.create();
                dialog1.show();
                dialog1.getButton(AlertDialog.BUTTON_POSITIVE)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Boolean wantToCloseDialog = true;
                                if(roomPwSet.getText().toString().equals(roomPwChk.getText().toString())) {
                                    Toast.makeText(OpenRoomActivity.this, "새로운 방을 생성했습니다", Toast.LENGTH_SHORT).show();
                                    wantToCloseDialog = true;
                                }else{
                                    Toast.makeText(OpenRoomActivity.this, "비밀번호가 서로 다릅니다. 동일하게 입력해주세요.", Toast.LENGTH_SHORT).show();
                                    wantToCloseDialog = false;
                                }
                                if (wantToCloseDialog) {
                                    dialog1.dismiss();
                                    startActivity(new Intent(OpenRoomActivity.this, MainActivity.class));
                                }
                            }
                        });
                break;
            case R.id.enterRoom:
                LayoutInflater inflater2=getLayoutInflater();
                final View dialogView2= inflater2.inflate(R.layout.dialog_enter_room, null);
                AlertDialog.Builder buider2= new AlertDialog.Builder(this);
                buider2.setTitle("방 입장하기");
                buider2.setView(dialogView2);
                roomNumber = (EditText) dialogView2.findViewById(R.id.inputRoomNumber);
                roomPw = (EditText)dialogView2.findViewById(R.id.inputPasswd);
                buider2.setPositiveButton("Complite", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                buider2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(OpenRoomActivity.this, "방 입장을 취소합니다", Toast.LENGTH_SHORT).show();
                    }
                });
                final AlertDialog dialog2=buider2.create();
                dialog2.show();
                dialog2.getButton(AlertDialog.BUTTON_POSITIVE)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Boolean wantToCloseDialog = true;
                                if(roomPwSet.getText().toString().equals(roomPwChk.getText().toString())) {
                                    Toast.makeText(OpenRoomActivity.this, "방에 입장하셨습니다. 어서오세요", Toast.LENGTH_SHORT).show();
                                    wantToCloseDialog = true;
                                }else{
                                    //Toast.makeText(OpenRoomActivity.this, "방 번호와 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                                    wantToCloseDialog = false;
                                }
                                if (wantToCloseDialog) {
                                    dialog2.dismiss();
                                    startActivity(new Intent(OpenRoomActivity.this,MainActivity.class));
                                }
                            }
                        });
                break;
        }
    }
}
