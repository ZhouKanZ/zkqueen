package comzkqueen.customview;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import comzkqueen.customview.widget.RedPacketPopupWindow;

/**
 * @author : zk
 * @date : 2019/4/4
 * @desc :
 */
public class RedPacketActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRedPacket;
    RedPacketPopupWindow redPacketPoppuWindow;
    ConstraintLayout redPacketParent;
    ValueAnimator valueAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.red_packet_layout);

        btnRedPacket = findViewById(R.id.btn_red_packet);
        btnRedPacket.setOnClickListener(this);

        redPacketParent = findViewById(R.id.red_packet_parent);
        redPacketPoppuWindow = new RedPacketPopupWindow(this);
        valueAnimator = new ValueAnimator();
    }

    @Override
    public void onClick(View v) {
        // show red packet
        redPacketPoppuWindow.showAtLocation(redPacketParent, Gravity.CENTER,0,0);
        redPacketPoppuWindow.startAnimation();
    }
}
