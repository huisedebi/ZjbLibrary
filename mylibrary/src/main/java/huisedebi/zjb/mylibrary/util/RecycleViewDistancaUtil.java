package huisedebi.zjb.mylibrary.util;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/3/14 0014.
 */
public class RecycleViewDistancaUtil {

    /**
     * 已滑动的距离
     */
    public static int getDistance(RecyclerView recyclerView, int ItemPosition) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        View firstVisibItem = recyclerView.getChildAt(0);
        int firstItemPosition = layoutManager.findFirstVisibleItemPosition();
        int itemHeight = firstVisibItem.getHeight();
        int firstItemBottom = layoutManager.getDecoratedBottom(firstVisibItem);
        if (firstItemPosition == ItemPosition) {
            return (firstItemPosition + 1) * itemHeight - firstItemBottom;
        } else {
            return -1;
        }
    }

    public static int getShaiXuanDistance(RecyclerView recyclerView, int ItemPosition) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        View firstVisibItem = recyclerView.getChildAt(0);
        int firstItemPosition = layoutManager.findFirstVisibleItemPosition();
        int itemHeight = firstVisibItem.getHeight();
        int firstItemBottom = layoutManager.getDecoratedBottom(firstVisibItem);
        if (firstItemPosition == ItemPosition) {
            return firstItemBottom;
        } else {
            if (firstItemPosition>3){
                return 0;
            }else {
                return -1;
            }
        }
    }

    /**
     * 获取RecyclerView滚动位置
     */
    public static int getLocation(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        View firstVisibItem = recyclerView.getChildAt(0);
        int firstItemPosition = layoutManager.findFirstVisibleItemPosition();
        int itemCount = layoutManager.getItemCount();
        int recycleViewHeight = recyclerView.getHeight();
        int itemHeight = firstVisibItem.getHeight();
        return (itemCount - firstItemPosition - 1) * itemHeight - recycleViewHeight;
    }

    /**
     * 还能向下滑动多少
     */
    public static int getReDistance(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        View firstVisibItem = recyclerView.getChildAt(0);
        int firstItemPosition = layoutManager.findFirstVisibleItemPosition();
        int itemCount = layoutManager.getItemCount();
        int recycleViewHeight = recyclerView.getHeight();
        int itemHeight = firstVisibItem.getHeight();
        int firstItemBottom = layoutManager.getDecoratedBottom(firstVisibItem);
        return (itemCount - firstItemPosition - 1) * itemHeight - recycleViewHeight + firstItemBottom;
    }
}
