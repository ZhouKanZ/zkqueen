package comzkqueen.customview.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.huiian.timinglibrary.base.BaseActivity;

/**
 * @author : zk
 * @date : 2019/4/16
 * @desc :
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements IView {

    protected View contentView;
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        //hideStatusBar(true);

        setContentView(getContentView());
        mPresenter = loadPresenter();
        initCommonData();
        initData();
        afterInitData();

        if (mPresenter != null) {
            mPresenter.onCreate();
        }

    }

    private void hideStatusBar(boolean isHide) {

        if (isHide) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(lp);
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        } else {
            WindowManager.LayoutParams attr = getWindow().getAttributes();
            attr.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setAttributes(attr);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    private void initCommonData() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    public View getContentView() {
        if (contentView == null) {
            contentView = View.inflate(this, getLayoutId(), null);
        }
        return contentView;
    }

    public String getStringByRes(@StringRes int resId) {
        return getResources().getString(resId);
    }

    protected abstract P loadPresenter();

    protected abstract int getLayoutId();

    // 实例化数据
    protected abstract void initData();

    // 实例化监听
    protected abstract void afterInitData();

}