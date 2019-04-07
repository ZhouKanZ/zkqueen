package comzkqueen.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import comzkqueen.customview.utils.OtherDevicePermissionUtils;

/**
 * @author : zk
 * @date : 2019/4/2
 * @desc :
 */
public class PermissionActivity extends AppCompatActivity {

    private static final String TAG = "PermissionActivity";

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permission_layout);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean granted = OtherDevicePermissionUtils.getInstance().hasCameraAndAudioPermission();
                Log.d(TAG, "onClick: " + granted);
            }
        });
    }
}
