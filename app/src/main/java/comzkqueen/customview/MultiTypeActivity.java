package comzkqueen.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zkqueen.diffname.Config;

/**
 * @author : zk
 * @date : 2019/4/9
 * @desc :
 */
public class MultiTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_type_activity);
        ((TextView)findViewById(R.id.tv_multi_port)).setText(Config.PORT);
    }
}
