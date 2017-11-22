package huisedebi.zjb.mylibrary.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import huisedebi.zjb.mylibrary.R;
import huisedebi.zjb.mylibrary.util.DpUtils;


/**
 * Created by zhangjiebo on 2017/10/28 0028.
 *
 * @author ZhangJieBo
 */
public class ConnerView extends View {


    private float lineWidth;
    private float lineJianGE;
    private int conner;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int width;
    private int height;
    Path path = new Path();


    public ConnerView(Context context) {
        super(context);
    }

    public ConnerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ConnerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        lineWidth = DpUtils.convertDpToPixel(1f, context);
        lineJianGE = DpUtils.convertDpToPixel(3f, context);
        paint.setColor(getResources().getColor(R.color.basic_color));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(lineWidth);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        conner = height / 2;
        paint.setPathEffect(null);
        RectF rectFleft = new RectF(-conner, 0 + lineWidth / 2, conner, height - lineWidth / 2);
        canvas.drawOval(rectFleft, paint);
        RectF rectFright = new RectF(width - conner, 0 + lineWidth / 2, getWidth() + conner, height - lineWidth / 2);
        canvas.drawOval(rectFright, paint);


        canvas.save();
        PathEffect pathEffect = new DashPathEffect(new float[]{lineJianGE, lineJianGE}, 0);
        paint.setPathEffect(pathEffect);
        path.moveTo(0 + conner + DpUtils.convertDpToPixel(10f, getContext()), conner);
        path.lineTo(width - conner - DpUtils.convertDpToPixel(10f, getContext()), conner);
        canvas.drawPath(path, paint);
        canvas.restore();
    }

}
