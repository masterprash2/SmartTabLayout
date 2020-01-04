package com.ogaclejapan.smarttablayout;

import androidx.viewpager.widget.ViewPager;

public class ViewPagerTabCallbacks implements TabsCallback {

    private final ViewPager viewPager;

    public ViewPagerTabCallbacks(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    @Override
    public void setCurrentIndex(int i) {
        viewPager.setCurrentItem(i);
    }

    @Override
    public int getCurrentIndex() {
        return viewPager.getCurrentItem();
    }

    @Override
    public TabsAdapter getAdapter() {
        return new TabsAdapter() {
            @Override
            public CharSequence getPageTitle(int position) {
                return viewPager.getAdapter().getPageTitle(position);
            }

            @Override
            public int getCount() {
                return viewPager.getAdapter().getCount();
            }
        };
    }

    @Override
    public void addOnTabChangeListener(final OnTabContainerChangeListener listener) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                listener.onContainerScrolled(position,positionOffset,positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                listener.onContainerSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                listener.onContainerScrollStateChanged(State.values()[state]);
            }
        });
    }
}
