package emirim.hs.kr.dormitory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Eun bee on 2016-11-01.
 */

public class FragmentTimeBoard extends Fragment {

    ImageView imgV;
    public FragmentTimeBoard(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        RelativeLayout v=(RelativeLayout) inflater.inflate(R.layout.fragment_timeboard, container, false);
        imgV=(ImageView)v.findViewById(R.id.add);
        imgV.setOnClickListener(mHandler);
        return v;
    }

    View.OnClickListener mHandler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            FragmentManager fm = getFragmentManager();
            FragmentTransaction tr = fm.beginTransaction();
            FragmentSetTime dialog = new FragmentSetTime();
            dialog.show(tr,"dialog");
        }
    };
}