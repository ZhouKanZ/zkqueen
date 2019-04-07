package comzkqueen.customview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * @author : zhoukan
 * @DATE: : 2019/3/13
 * @DESC :  沉浸式测试
 */
public class ImmersiveActivity extends Activity {

    TextView tv;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_immersive);
        tv = findViewById(R.id.tv);
//        leanBack();
        immersive();
//        stickyImmersive();
    }
    
    private void leanBack(){
        tv.setText("Lean Back");
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
    
    private void immersive(){
        tv.setText("Immersive");
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE|View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
    
    private void stickyImmersive(){
        tv.setText("stickyImmersive");
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}
