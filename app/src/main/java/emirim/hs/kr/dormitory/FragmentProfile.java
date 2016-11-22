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

import com.facebook.share.model.AppInviteContent;
import com.facebook.share.widget.AppInviteDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

/**
 * Created by Eun bee on 2016-delete_things-01.
 */

public class FragmentProfile extends Fragment {
    ImageView roomLeader,roomate1,roomate2,roomate3;
    String appLinkUrl, previewImageUrl;
    public FragmentProfile() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout v = (RelativeLayout) inflater.inflate(R.layout.fragment_profile, container, false);
        roomLeader = (ImageView)v.findViewById(R.id.roomLeader);
        roomate1 = (ImageView)v.findViewById(R.id.roomate1);
        roomate2 = (ImageView)v.findViewById(R.id.roomate2);
        roomate3 = (ImageView)v.findViewById(R.id.roomate3);
//        Picasso.with(v.getContext())
//                .load()
//                .into(roomLeader);
        return v;
    }
    View.OnClickListener bHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            appLinkUrl = "https://www.mydomain.com/myapplink";
            previewImageUrl = "https://www.mydomain.com/my_invite_image.jpg";
            FragmentManager fm = getFragmentManager();
            FragmentTransaction tr = fm.beginTransaction();
            if (AppInviteDialog.canShow()) {
                AppInviteContent content = new AppInviteContent.Builder()
                        .setApplinkUrl(appLinkUrl)
                        .setPreviewImageUrl(previewImageUrl)
                        .build();
                AppInviteDialog.show(FragmentProfile.this,content);
            }
        }
    };

}
