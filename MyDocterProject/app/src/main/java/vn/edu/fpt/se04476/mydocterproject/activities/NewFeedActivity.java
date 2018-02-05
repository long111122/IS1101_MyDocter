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
import vn.edu.fpt.se04476.mydocterproject.adapters.PostPageAdapter;
import vn.edu.fpt.se04476.mydocterproject.entities.PostInformation;

public class NewFeedActivity extends AppCompatActivity implements View.OnClickListener {

    private List<PostInformation> samplePostList;
    private PostPageAdapter postPageAdapter;
    private RecyclerView rvPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_feed);
        identifyVariable();
        setupUI();

    }

    private void identifyVariable() {
        if (samplePostList == null) {
            samplePostList = new ArrayList<>();
        }
        samplePostList.add(new PostInformation(
                samplePostList.size(),
                R.drawable.avar_sample_1,
                R.drawable.ic_sample_post,
                "Adam",
                "Jebruary 5 2018",
                getResources().getString(R.string.sample_content),
                "Demo Post - Sample",
                null,
                false
        ));
        samplePostList.add(new PostInformation(
                samplePostList.size(),
                R.drawable.avar_sample_2,
                R.drawable.ic_sample_post,
                "Eva",
                "Jebruary 5 2018",
                getResources().getString(R.string.sample_content),
                "Demo Post - Sample",
                null,
                false
        ));
        samplePostList.add(new PostInformation(
                samplePostList.size(),
                R.drawable.avar_sample_3,
                R.drawable.ic_sample_post,
                "MR.A",
                "Jebruary 5 2018",
                getResources().getString(R.string.sample_content),
                "Demo Post - Sample",
                null,
                false
        ));
        samplePostList.add(new PostInformation(
                samplePostList.size(),
                R.drawable.avar_sample_4,
                R.drawable.ic_sample_post,
                "Mrs.B",
                "Jebruary 5 2018",
                getResources().getString(R.string.sample_content),
                "Demo Post - Sample",
                null,
                false
        ));
        samplePostList.add(new PostInformation(
                samplePostList.size(),
                R.drawable.avar_sample_5,
                R.drawable.ic_sample_post,
                "Asuka kirara",
                "Jebruary 5 2018",
                getResources().getString(R.string.sample_content),
                "Demo Post - Sample",
                null,
                false
        ));
    }

    private void setupUI() {
        rvPost = findViewById(R.id.rv_post);
        postPageAdapter = new PostPageAdapter(samplePostList, this.getApplicationContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                getApplicationContext(),
                1,
                LinearLayoutManager.VERTICAL,
                false
        );
        rvPost.setAdapter(postPageAdapter);
        rvPost.setLayoutManager(gridLayoutManager);
        postPageAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
