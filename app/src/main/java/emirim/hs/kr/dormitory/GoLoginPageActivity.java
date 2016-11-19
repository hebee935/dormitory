package emirim.hs.kr.dormitory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Eun bee on 2016-10-25.
 */
public class GoLoginPageActivity extends AppCompatActivity implements View.OnClickListener{
    Button goLogin;
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_login);

        //Splash(로딩화면) 띄우기
        startActivity(new Intent(this,SplashActivity.class));
        goLogin = (Button)findViewById(R.id.goLogin);
        goLogin.setOnClickListener(this);
    }

    public void onClick(View v){
        startActivity(new Intent(this,FacebookLoginActivity.class));

    }
}
