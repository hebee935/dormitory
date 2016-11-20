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
                    new FragmentBuy(),
                    new RecentPostsFragment(),
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
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch(position){
                    case 1:
                        findViewById(R.id.fab_new_post).setVisibility(View.GONE);
                        findViewById(R.id.fab_add_buy).setVisibility(View.VISIBLE);
                        findViewById(R.id.fab_delete_buy).setVisibility(View.VISIBLE);
                        break;
                    case 0:case 3:
                        findViewById(R.id.fab_new_post).setVisibility(View.GONE);
                        findViewById(R.id.fab_add_buy).setVisibility(View.GONE);
                        findViewById(R.id.fab_delete_buy).setVisibility(View.GONE);
                        break;
                    case 2: findViewById(R.id.fab_new_post).setVisibility(View.VISIBLE);
                        findViewById(R.id.fab_add_buy).setVisibility(View.GONE);
                        findViewById(R.id.fab_delete_buy).setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Button launches NewPostActivity
        findViewById(R.id.fab_new_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewPostActivity.class));
            }
        });
        findViewById(R.id.fab_add_buy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.fab_delete_buy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DialogFragmentBuy.class));
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
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}
