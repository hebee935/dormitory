package emirim.hs.kr.dormitory;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Eun bee on 2016-11-02.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    private int tabCount;
    public TabPagerAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentProfile tabFragment1 = new FragmentProfile();
                return tabFragment1;
            case 1:
                FragmentBuy tabFragment2 = new FragmentBuy();
                return tabFragment2;
            case 2:
                FragmentTimeBoard tabFragment3 = new FragmentTimeBoard();
                return tabFragment3;
            case 3:
                FragmentNotice tabFragment4 = new FragmentNotice();
                return tabFragment4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
