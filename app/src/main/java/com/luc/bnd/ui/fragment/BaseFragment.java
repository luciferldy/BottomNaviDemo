package com.luc.bnd.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luc.bnd.R;

/**
 * Created by Lucifer on 2016/8/8.
 */
public class BaseFragment extends Fragment {

    public static final String PAGE_NAME = "page name";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_base, container, false);
        Bundle bundle = getArguments();
        if (bundle != null && !bundle.isEmpty()) {
            String pageName = bundle.getString(PAGE_NAME);
            TextView tv = (TextView) root.findViewById(R.id.page_name);
            tv.setText(pageName);
        }
        return root;
    }
}
