package vn.edu.fpt.se04476.mydocterproject.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import vn.edu.fpt.se04476.mydocterproject.R;
import vn.edu.fpt.se04476.mydocterproject.adapters.ListAppliedMedicalAdapter;
import vn.edu.fpt.se04476.mydocterproject.entities.MedicalDetail;

public class AppliedMedicalActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private List<MedicalDetail> medicalDetailList;
    private ListAppliedMedicalAdapter listAppliedMedicalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applied_medical);
        identifyVariable();
        setupUI();
    }

    private void identifyVariable() {
        if (medicalDetailList == null){
            medicalDetailList = new ArrayList<>();
        }
        medicalDetailList.add(new MedicalDetail(
                R.drawable.ic_sample_location,
                    "FPT University"
                )
        );
        medicalDetailList.add(new MedicalDetail(
                        R.drawable.ic_sample_location,
                        "Medical 1"
                )
        ); medicalDetailList.add(new MedicalDetail(
                        R.drawable.ic_sample_location,
                        "Medical 2"
                )
        );
        medicalDetailList.add(new MedicalDetail(
                        R.drawable.ic_sample_location,
                        "Medical 3"
                )
        );

    }

    private void setupUI() {
        recyclerView = findViewById(R.id.rv_applied_medical);
        listAppliedMedicalAdapter = new ListAppliedMedicalAdapter(medicalDetailList, getApplicationContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                getApplicationContext(),
                1,
                LinearLayoutManager.VERTICAL,
                false
        );
        recyclerView.setAdapter(listAppliedMedicalAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        listAppliedMedicalAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
