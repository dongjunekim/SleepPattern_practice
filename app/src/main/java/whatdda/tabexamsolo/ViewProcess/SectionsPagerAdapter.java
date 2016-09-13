package whatdda.tabexamsolo.ViewProcess;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import whatdda.tabexamsolo.View.FirstFragment;
import whatdda.tabexamsolo.View.SecondFragment;

/**
 * Created by dongj on 2016-04-21.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        switch (position) {

            case 0:
                return FirstFragment.newInstance(position + 1);
            case 1:
                return SecondFragment.newInstance(position + 2);
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
        }
        return null;
    }
}
