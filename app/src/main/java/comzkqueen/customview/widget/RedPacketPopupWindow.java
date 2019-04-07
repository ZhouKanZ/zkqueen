package comzkqueen.customview.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import comzkqueen.customview.R;
import comzkqueen.customview.utils.Utils;

/**
 * @author : zk
 * @date : 2019/4/4
 * @desc :
 */
public class RedPacketPopupWindow extends PopupWindow implements View.OnClickListener {

    private Context context;
    private int width = ViewGroup.LayoutParams.MATCH_PARENT;
    private int height = ViewGroup.LayoutParams.MATCH_PARENT;
    private ObjectAnimator animScaleX,animScaleY,animRotation;
    private AnimatorSet set;
    private ConstraintLayout clOutside;
    private RelativeLayout rlContent;
    private ImageView ivIcon;

    public RedPacketPopupWindow(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    private void initView() {

        final View view = LayoutInflater.from(this.context).inflate(R.layout.red_packet_popup, null);
        setContentView(view);
        // 需要手动的设置宽高，布局中的宽高不生效
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        setWidth(layoutParams.width);
        setHeight(layoutParams.height);

        ivIcon = view.findViewById(R.id.iv_icon);
        ivIcon.setOnClickListener(this);
//        setAnimationStyle(android.R.style.Animation_Dialog);
        // 点击外部是否可以取消 popupWindow
        setOutsideTouchable(true);
        // 去掉popupWindow的黑边
        setBackgroundDrawable(new BitmapDrawable());
        clOutside = view.findViewById(R.id.cl_outside);
        rlContent = view.findViewById(R.id.rl_content);
        clOutside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        initAnim();

    }

    private void initAnim() {
        animScaleX = ObjectAnimator
                .ofFloat(rlContent, "scaleX", 0, 1);

        animScaleY = ObjectAnimator
                .ofFloat(rlContent, "scaleY", 0, 1);

        set = new AnimatorSet();
        set.playTogether(animScaleX,animScaleY);
        // 关键代码
        set.setInterpolator(new BounceInterpolator());
        set.setDuration(1000);

        animRotation = ObjectAnimator.ofFloat(ivIcon,"rotationY",0,-360);
        animRotation.setDuration(800);

    }

    @Override
    public void onClick(View v) {
        animRotation.start();
    }

    /**
     * 开启动画
     */
    public void startAnimation() {
        set.start();
    }

}
