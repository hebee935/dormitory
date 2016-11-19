package emirim.hs.kr.dormitory;

        import android.content.Intent;

        import android.graphics.drawable.Icon;
        import android.os.Bundle;
        import android.support.design.widget.TabLayout;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentPagerAdapter;
        import android.support.v4.view.ViewPager;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;

        import com.google.firebase.auth.FirebaseAuth;
        import emirim.hs.kr.dormitory.fragment.RecentPostsFragment;

        import static emirim.hs.kr.dormitory.R.id.tabLayout;

public class  MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    private final int[] ICONS = {
            R.drawable.this1,
            R.drawable.this2,
            R.drawable.this3,
            R.drawable.this4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each section
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[] {
                    new FragmentProfile(),
                    new RecentPostsFragment(),
                    new FragmentTimeBoard(),
                    new FragmentNotice()
            };
            private final String[] mFragmentNames = new String[] {
                    "우리야",
                    "사오렴",
                    "같이해",
                    "모르지"
            };

            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }
            public int getCount() {
                return mFragments.length;
            }
            /*
            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentNames[position];
            }*/
        };
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        for(int i=0;i<tabLayout.getTabCount();i++) {
            tabLayout.getTabAt(i).setIcon(ICONS[i]);
        }

        // Button launches NewPostActivity
        findViewById(R.id.fab_new_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewPostActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.action_logout) {
            new FacebookLoginActivity().signOut();
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}
