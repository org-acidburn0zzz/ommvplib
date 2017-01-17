package eu.darken.ommvplib.example.screens.counting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eu.darken.ommvplib.example.R;
import eu.darken.ommvplib.example.screens.BasePagerFragment;
import eu.darken.ommvplib.injection.fragment.FragmentComponentBuilderSource;

public class CountingFragment extends BasePagerFragment<CountingView, CountingPresenter, CountingComponent> implements CountingView {

    @BindView(R.id.fragment_text) TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_counting, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showText(String text) {
        textView.setText(text);
    }

    @OnClick(R.id.fragment_button)
    void onCountClick() {
        getPresenter().onCountClick();
    }

    @Override
    public CountingComponent createComponent() {
        CountingComponent.Builder builder = ((FragmentComponentBuilderSource) getActivity()).getComponentBuilder(CountingFragment.class);
        builder.module(new CountingModule());
        return builder.build();
    }

    @Override
    public Class<? extends CountingPresenter> getTypeClazz() {
        return CountingPresenter.class;
    }
}
