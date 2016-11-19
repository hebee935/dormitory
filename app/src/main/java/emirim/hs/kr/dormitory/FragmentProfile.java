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

/**
 * Created by Eun bee on 2016-11-01.
 */

public class FragmentProfile extends Fragment {
    ImageView addFriends;
    String appLinkUrl, previewImageUrl;
    public FragmentProfile() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout v = (RelativeLayout) inflater.inflate(R.layout.fragment_profile, container, false);
        addFriends = (ImageView) v.findViewById(R.id.plus);
        addFriends.setOnClickListener(bHandler);
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
