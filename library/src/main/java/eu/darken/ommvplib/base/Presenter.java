package eu.darken.ommvplib.base;


import android.os.Bundle;
import android.support.annotation.Nullable;

public interface Presenter<ViewT extends Presenter.View> {
    void onCreate(@Nullable Bundle savedInstanceState);

    void onBindChange(@Nullable ViewT view);

    void onSaveInstanceState(Bundle outState);

    void onDestroy();

    interface View {

    }
}
