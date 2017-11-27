package huisedebi.zjb.mylibrary.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ScrollViewWithListener extends ScrollView {
	/***
	 * 接收外部传入的监听
	 */
	private OnScrollChangedListener listener;


	public interface OnScrollChangedListener {
		void onScrollChanged(int ScrollMove);
	}

	public void setOnScrollChangedListener(OnScrollChangedListener listener) {
		this.listener = listener;
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		listener.onScrollChanged(t);
		super.onScrollChanged(l, t, oldl, oldt);
	}

	public ScrollViewWithListener(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
}
