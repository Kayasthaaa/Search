package com.example.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Model> ModelList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();

        EditText editText = findViewById(R.id.seacrh);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());

            }
        });


    }


    private void filter(String text){

        ArrayList<Model> filteredList = new ArrayList<>();

        for (Model item : ModelList){

            if (item.getCountry_name().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }

        }

        adapter.filterList(filteredList);

    }

    private void initData() {

        ModelList = new ArrayList<>();

        ModelList.add(new Model(R.drawable.nepal,"Nepal","Kathmandu","Asia","3,01,23,456","China-India","Nepali"));
        ModelList.add(new Model(R.drawable.afgan,"Afganistan","Kabul","Asia","12,34,000","Pakistan-India","Hindi"));
        ModelList.add(new Model(R.drawable.india,"India","New Delhi","Asia","12,97,57,382","China-Pakistan-Nepal-Bhutan","Hindi"));
        ModelList.add(new Model(R.drawable.bhutan,"Bhutan","Thimpu","Asia","2,9,80,000","India","Bhutuneese"));
        ModelList.add(new Model(R.drawable.pak,"Pakistan","Islamabad","Asia","1,90,68,563","Inida-Afganistan","Hindi"));
        ModelList.add(new Model(R.drawable.china,"China","Bejing","Asia","90,25,63,25,632","Nepal-India-Afganistan","Chineese"));
        ModelList.add(new Model(R.drawable.bangladesh,"Bangladesh","Dhaka","Asia","1,23,46,700","India","Bengali"));
        ModelList.add(new Model(R.drawable.male,"Maldives","Male","Asia","2,38,900","India-SriLanka","English"));
        ModelList.add(new Model(R.drawable.lanka,"Srilanka","Colombo","Asia","34,09,086","Maldives","Bengali"));
    }

    private void initRecyclerView() {

        recyclerView = findViewById(R.id.recView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(ModelList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}