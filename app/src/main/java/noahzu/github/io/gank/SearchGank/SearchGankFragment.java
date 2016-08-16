package noahzu.github.io.gank.SearchGank;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import noahzu.github.io.gank.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchGankFragment extends Fragment {


    public SearchGankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_gank, container, false);
    }

}
