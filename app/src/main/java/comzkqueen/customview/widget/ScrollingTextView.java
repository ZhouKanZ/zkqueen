package comzkqueen.customview.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import comzkqueen.customview.utils.Utils;

public class ScrollingTextView extends View {

    private static final String TAG = "ScrollingTextView";

    public static final int BOUND_SIZE = 3;

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private String text = "我爱你中华";
    private Rect rect = new Rect();
    private float startX = 0;

    public ScrollingTextView(Context context) {
        this(context, null);
    }

    public ScrollingTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollingTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(Utils.dp2px(9));
        paint.setColor(Color.parseColor("#000000"));
        // 文字五线谱的各各数值
        paint.getTextBounds(text, 0, text.length(), rect);
    }

    public float getStartX() {
        return startX;
    }

    public void setStartX(float startX) {
        this.startX = startX;
        invalidate();
    }

    /**
     * 当配置发生改变的时候触发该方法，在onDraw之前被调用；常用来做初始化工作
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        startX = getPaddingLeft();
        startAnim(getWidth(), BOUND_SIZE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int resultWidth = (int) (paint.measureText(text) + getPaddingLeft() + getPaddingRight());
        int resultHeight = (int) (paint.getFontSpacing() + getPaddingTop() + getPaddingBottom());

        setMeasuredDimension(getDefaultSize(resultWidth, widthMeasureSpec), getDefaultSize(resultHeight, heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(text, startX, getPaddingTop() + paint.getFontSpacing() + 1, paint);
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }

    /**
     * @param width     view的宽度
     * @param boundSize 边界值
     */
    public void startAnim(float width, int boundSize) {
        Log.d(TAG, "startAnim: " + width);
        if (text.length() <= boundSize) {
            return;
        }
        float length = paint.measureText(text);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "startX", width, -length);
        objectAnimator.setDuration((long) ((width + length) / 6) * 60);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setRepeatCount(-1);
        objectAnimator.start();
    }

}

