package com.example.pt_android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pt_android_app.objects.Category;
import com.example.pt_android_app.ui.login.LoginActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        new GetCategories().execute();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        new GetCategories().execute();
        return true;
    }

    private final class GetCategories extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String output = "";
//            String params = strings[0];
//            System.out.println("**************SENT: " + params);

            try {
                return RESTControl.get("category");
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            System.out.println("************RESULT: " + result);
            if (result != null) {
                try {
                    Type listType = new TypeToken<ArrayList<Category>>(){}.getType();
                    final List<Category> categoryList = new Gson().fromJson(result, listType);
                    ListView listView = (ListView) findViewById(R.id.list);
                    System.out.println(listView);
                    ArrayAdapter<Category> arrayAdapter = new ArrayAdapter<>(CategoryActivity.this, android.R.layout.simple_list_item_1, categoryList);
                    listView.setAdapter(arrayAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Category category = categoryList.get(position);
                            Toast t = Toast.makeText(CategoryActivity.this, "Category selected: " + categoryList.get(position), Toast.LENGTH_LONG);
                            t.show();


                            Bundle bundle = SingleCategoryFragment.getBundle(category.getId(), category.getName(), category.getDescription());

                            NavHostFragment.findNavController(getSupportFragmentManager().findFragmentById(R.id.nav_category_host_fragment))
                                    .navigate(R.id.action_categoryListFragment_to_singleCategoryFragment2, bundle);
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast data = Toast.makeText(CategoryActivity.this, "Error on getting categories", Toast.LENGTH_LONG);
                    data.show();
                }
            }
        }
    }
}