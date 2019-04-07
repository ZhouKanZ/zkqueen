package comzkqueen.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import comzkqueen.customview.utils.Utils;

/**
 * @author : zk
 * @date : 2019/4/7
 * @desc : 贝塞尔曲线
 */
public class LikeAnimView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path bezierPath;
    private int width;
    private int height;

    public LikeAnimView(Context context) {
        super(context);
    }

    public LikeAnimView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LikeAnimView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setColor(Color.parseColor("#3154bf"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.dp2px(2));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getWidth();
        height = getHeight();
        bezierPath = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.translate(width / 2, height / 2);

        bezierPath.moveTo(width / 2, height / 2);
        bezierPath.cubicTo(width / 2 - 200, height / 2 - 100,
                width / 2 + 150, height / 2 - 150,
                width / 2, height / 2 - 250);
        bezierPath.quadTo(width / 2 - 60,height / 2 - 300,width / 2, height / 2 - 350);
        canvas.drawPath(bezierPath, paint);
        paint.setColor(Color.RED);
        canvas.drawPoint(width / 2,height / 2,paint);
        canvas.drawPoint(width / 2 - 200,height / 2 - 100,paint);
        canvas.drawPoint(width / 2 + 150,height / 2 - 150,paint);
        canvas.drawPoint(width / 2,height / 2 - 250,paint);

    }

}
