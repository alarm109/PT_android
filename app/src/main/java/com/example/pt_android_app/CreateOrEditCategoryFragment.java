package com.example.pt_android_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateOrEditCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateOrEditCategoryFragment extends Fragment {
    private EditText nameIn;
    private EditText descriptionIn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreateOrEditCategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateOrEditCategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateOrEditCategoryFragment newInstance(String param1, String param2) {
        CreateOrEditCategoryFragment fragment = new CreateOrEditCategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_or_edit_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameIn = (EditText) view.findViewById(R.id.cat_create_name);
        descriptionIn = (EditText) view.findViewById(R.id.cat_create_description);

        view.findViewById(R.id.cat_save_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CategoryActivity categoryActivity = (CategoryActivity) getActivity();
                if (categoryActivity != null) {
                    String name = nameIn.getText().toString();
                    String description = descriptionIn.getText().toString();

                    categoryActivity.createCategory(name, description);

                    NavHostFragment.findNavController(CreateOrEditCategoryFragment.this)
                            .popBackStack();
                    categoryActivity.populateCategories();
                }
            }
        });
    }
}