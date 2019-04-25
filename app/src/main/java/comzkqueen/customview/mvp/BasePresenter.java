package comzkqueen.customview.mvp;

import java.lang.ref.WeakReference;

/**
 * @author : zk
 * @date : 2019/4/16
 * @desc :
 */
public abstract class BasePresenter<V extends IView> implements IPresenter {

    private WeakReference<V> mViewRef;
    private V mProxyView;

    @Override
    public void attachView(IView view) {
        this.mViewRef = new WeakReference(view);
        mProxyView = mViewRef.get();

    }

    public boolean isAttached() {
        if (mViewRef != null && mViewRef.get() != null) {
            return true;
        }

        return false;
    }

    @Override
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    @Override
    public V getView() {
        return mProxyView;
    }

}
