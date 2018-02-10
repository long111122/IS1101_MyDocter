package vn.edu.fpt.se04476.mydocterproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import vn.edu.fpt.se04476.mydocterproject.R;

public class SearchAroundActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivMap;
    private RelativeLayout rlContent;
    private Button btnViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_around);
        setupUI();
        ivMap.setOnClickListener(this);
        btnViewDetail.setOnClickListener(this);
    }

    private void setupUI() {
        ivMap = findViewById(R.id.iv_map);
        btnViewDetail = findViewById(R.id.btn_view_detail);
        rlContent = findViewById(R.id.relative_content);
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()){
                case R.id.iv_map:
                    rlContent.setVisibility(View.VISIBLE);
                    break;

                case R.id.btn_view_detail:
                    if (rlContent.getVisibility() == View.VISIBLE){
                        Intent detailIntent = new Intent(this, LocationDetailActivity.class);
                        startActivity(detailIntent);
                    }
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
