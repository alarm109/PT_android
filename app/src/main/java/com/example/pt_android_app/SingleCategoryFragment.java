package com.example.pt_android_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pt_android_app.objects.Category;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SingleCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingleCategoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "id";
    private static final String ARG_PARAM2 = "name";
    private static final String ARG_PARAM3 = "description";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private String mParam2;
    private String mParam3;

    public SingleCategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SingleCategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SingleCategoryFragment newInstance(int param1, String param2, String param3) {
        SingleCategoryFragment fragment = new SingleCategoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    public static Bundle getBundle (int param1, String param2, String param3) {
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        return args;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_single_category, container, false);
        TextView name = (TextView) inflatedView.findViewById(R.id.cat_name);
        name.setText(mParam2);
        TextView description = (TextView) inflatedView.findViewById(R.id.cat_description);
        description.setText(mParam3);

        return inflatedView;
    }
}