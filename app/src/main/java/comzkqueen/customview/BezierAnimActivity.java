package comzkqueen.customview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;


/**
 * @author : zk
 * @date : 2019/4/7
 * @desc :
 */
public class BezierAnimActivity extends AppCompatActivity {

    Path bezierPath = new Path();
    Point centerPos = new Point();
    ImageView iv;
    Button btn_start;
    ObjectAnimator bezierAnim,alphaAnim,scaleAnimX,scaleAnimY;
    AnimatorSet set;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bezier_layout);

        iv = findViewById(R.id.iv);
        btn_start = findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnim();
                startAnim();
            }
        });

        iv.post(new Runnable() {
            @Override
            public void run() {

                centerPos.x = (int) (iv.getX() + iv.getWidth()/2);
                centerPos.y = (int) (iv.getY() + iv.getHeight()/2);

                // bezier path
                bezierPath.moveTo(centerPos.x, centerPos.y);
                bezierPath.cubicTo(centerPos.x - 200, centerPos.y - 100,
                        centerPos.x + 150, centerPos.y - 150,
                        centerPos.x, centerPos.y - 250);
                bezierPath.quadTo(centerPos.x - 60,centerPos.y - 300,centerPos.x, centerPos.y - 350);
            }
        });



    }

    /**
     *  初始化动画
     */
    private void initAnim() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

            if (bezierAnim == null){
                bezierAnim = ObjectAnimator.ofFloat(iv,iv.X,iv.Y,bezierPath);
                bezierAnim.setInterpolator(new DecelerateInterpolator());

                alphaAnim = ObjectAnimator.ofFloat(iv,"alpha",1,0);
                alphaAnim.setInterpolator(new AccelerateInterpolator());

                scaleAnimX = ObjectAnimator.ofFloat(iv,"scaleX",1,0);
                scaleAnimX.setInterpolator(new AccelerateInterpolator());

                scaleAnimY = ObjectAnimator.ofFloat(iv,"scaleY",1,0);
                scaleAnimY.setInterpolator(new AccelerateInterpolator());

                set = new AnimatorSet();
                set.playTogether(bezierAnim,alphaAnim,scaleAnimX,scaleAnimY);
                set.setDuration(1500);
            }

        }
    }

    /**
     *  开启动画
     */
    private void startAnim() {
        set.start();
    }
}
