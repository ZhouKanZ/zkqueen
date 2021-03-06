package comzkqueen.customview.mvp;

/**
 * @author : zk
 * @date : 2019/4/16
 * @desc :
 */
public interface IPresenter<V extends IView>{

    /**
     * @param view 绑定
     */
    void attachView(V view);

    /**
     * 防止内存的泄漏,清楚presenter与activity之间的绑定
     */
    void detachView();

    /**
     *
     * @return 获取View
     */
    V getView();

    void onCreate();

    void onDestroy();
}
