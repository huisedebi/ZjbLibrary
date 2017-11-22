package huisedebi.zjb.mylibrary.util;

import android.support.v4.view.ViewPager;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/3/21 0021.
 */
public class BannerSettingUtil {
    private ViewPager mViewPager_banner;
    private boolean isFrist = true;
    private boolean mDragging;

    public BannerSettingUtil(ViewPager mViewPager_banner) {
        this.mViewPager_banner = mViewPager_banner;
    }

    public void set() {
        mViewPager_banner.setPageMargin(10);//设置page间间距，自行根据需求设置
        mViewPager_banner.setOffscreenPageLimit(3);//>=3

        //setPageTransformer 决定动画效果
//        mViewPager_banner.setPageTransformer(true, new ScaleInTransformer(new AlphaPageTransformer()));
        setViewPagerScrollSpeed();
        mViewPager_banner.addOnPageChangeListener(new BannerOnPageChangeListener());
        if (isFrist) {
            autoScroll();
        }
    }

    /**
     * 减慢viewpager滑动动作
     */
    private void setViewPagerScrollSpeed() {
        try {
            Field mScroller = null;
            mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(mViewPager_banner.getContext());
            mScroller.set(mViewPager_banner, scroller);
        } catch (NoSuchFieldException e) {

        } catch (IllegalArgumentException e) {

        } catch (IllegalAccessException e) {

        }
    }

    private void autoScroll() {
        mViewPager_banner.postDelayed(new Runnable() {
            @Override
            public void run() {
                int position = mViewPager_banner.getCurrentItem() + 1;
                if (!mDragging) {
                    isFrist = false;
                    try {
                        mViewPager_banner.setCurrentItem(position);
                    } catch (Exception e) {
                    }
                }
                mViewPager_banner.postDelayed(this, 3000);
            }
        }, 3000);
    }

    class BannerOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
                case ViewPager.SCROLL_STATE_IDLE:
                    mDragging = false;
                    break;
                case ViewPager.SCROLL_STATE_DRAGGING:
                    mDragging = true;
                    break;
                case ViewPager.SCROLL_STATE_SETTLING:
                    mDragging = false;
                    break;
                default:
                    break;
            }
        }


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
        }
    }
}
