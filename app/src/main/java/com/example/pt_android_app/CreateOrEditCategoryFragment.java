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

public class CreateOrEditCategoryFragment extends Fragment {
    private EditText nameIn;
    private EditText descriptionIn;

    private static final String ARG_PARAM1 = "id";
    private static final String ARG_PARAM2 = "name";
    private static final String ARG_PARAM3 = "desc";

    private Integer id;
    private String n;
    private String d;

    public CreateOrEditCategoryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(ARG_PARAM1);
            n = getArguments().getString(ARG_PARAM2);
            d = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_or_edit_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameIn = (EditText) view.findViewById(R.id.cat_create_name);
        descriptionIn = (EditText) view.findViewById(R.id.cat_create_description);

        if (n != null) {
            nameIn.setText(n);
            descriptionIn.setText(d);
        }

        view.findViewById(R.id.cat_save_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CategoryActivity categoryActivity = (CategoryActivity) getActivity();
                if (categoryActivity != null) {
                    String name = nameIn.getText().toString();
                    String description = descriptionIn.getText().toString();

                    if (id != null) {
                        categoryActivity.updateCategory("" + id, name, description);
                        NavHostFragment.findNavController(CreateOrEditCategoryFragment.this)
                                .navigate(R.id.action_createOrEditCategoryFragment_to_categoryListFragment);
                    } else {
                        categoryActivity.createCategory(name, description);
                        NavHostFragment.findNavController(CreateOrEditCategoryFragment.this)
                                .popBackStack();
                    }
                    categoryActivity.populateCategories();
                }
            }
        });
    }
}