package comzkqueen.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comzkqueen.customview.service.MyService;

/**
 * @author : zk
 * @date : 2019/4/11
 * @desc :
 */
public class ServiceTestActivity extends AppCompatActivity {

    @BindView(R.id.btn_start_service)
    Button btnStartService;
    @BindView(R.id.btn_stop_service)
    Button btnStopService;
    @BindView(R.id.btn_bind_service)
    Button btnBindService;
    @BindView(R.id.btn_stop_bind_service)
    Button btnStopBindService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_test_activity);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_start_service, R.id.btn_stop_service, R.id.btn_bind_service, R.id.btn_stop_bind_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_start_service:
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
                break;
            case R.id.btn_stop_service:
                Intent stopService = new Intent(this, MyService.class);
                stopService(stopService);
                break;
            case R.id.btn_bind_service:
                break;
            case R.id.btn_stop_bind_service:
                break;
            default:
        }
    }
}
