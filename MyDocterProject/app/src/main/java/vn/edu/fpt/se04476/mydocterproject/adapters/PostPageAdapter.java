package vn.edu.fpt.se04476.mydocterproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import vn.edu.fpt.se04476.mydocterproject.R;
import vn.edu.fpt.se04476.mydocterproject.entities.PostInformation;

/**
 * Created by EDGY on 2/4/2018.
 */

public class PostPageAdapter extends RecyclerView.Adapter<PostPageAdapter.PostPageViewHolder> {
    private List<PostInformation> postInformationList;
    private Context context;
    private View.OnClickListener onClickListener;

    public PostPageAdapter(List<PostInformation> postInformationList, Context context) {
        this.postInformationList = postInformationList;
        this.context = context;
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public PostPageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_list_postpage, parent, false);
        itemView.setOnClickListener(onClickListener);
        return new PostPageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostPageViewHolder holder, int position) {
        holder.setData(postInformationList.get(position));
    }

    @Override
    public int getItemCount() {
        return postInformationList.size();
    }

    public class PostPageViewHolder extends RecyclerView.ViewHolder{
        View view;
        private ImageView ivAvatar;
        private TextView tvUsername;
        private TextView tvPostTime;
        private TextView tvTitle;
        private TextView tvContent;
        private ImageView ivPostInclude;

        public PostPageViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            setupUI();
        }

        private void setupUI() {
            ivAvatar = view.findViewById(R.id.iv_avatar);
            tvUsername = view.findViewById(R.id.tv_user_name);
            tvPostTime = view.findViewById(R.id.tv_post_time);
            tvTitle = view.findViewById(R.id.tv_post_title);
            tvContent = view.findViewById(R.id.tv_content);
            ivPostInclude = view.findViewById(R.id.iv_post_image);
        }

        public void setData(PostInformation postInformation){
            //1. Set avatar and image included
            Picasso.with(context).load(postInformation.getAvaImage()).transform(new CropCircleTransformation()).into(ivAvatar);
            Picasso.with(context).load(postInformation.getPostImage()).into(ivPostInclude);

            //2. Set text to header
            tvUsername.setText(postInformation.getUser());
            tvPostTime.setText(postInformation.getStartTime());

            //3. Set text to content
            tvTitle.setText(postInformation.getTitle());
            tvContent.setText(postInformation.getContent());

        }
    }
}
