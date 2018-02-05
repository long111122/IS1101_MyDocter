package vn.edu.fpt.se04476.mydocterproject.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.edu.fpt.se04476.mydocterproject.R;
import vn.edu.fpt.se04476.mydocterproject.entities.FunctionType;
import vn.edu.fpt.se04476.mydocterproject.fragments.HomePageForGuest;

/**
 * Created by EDGY on 2/1/2018.
 */

public class HomePageFunctionAdapter extends RecyclerView.Adapter<HomePageFunctionAdapter.HomePageFunctionViewHolder> {
    private List<FunctionType> listFunction;
    private Context context;

    private View.OnClickListener onClickListener;

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onClickListener = onItemClickListener;
    }

    public HomePageFunctionAdapter(List<FunctionType> listFunction, Context context) {
        this.listFunction = listFunction;
        this.context = context;
    }

    @Override
    public HomePageFunctionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_list_function, parent, false);
        itemView.setOnClickListener(onClickListener);

        //Return new viewhodler
        return new HomePageFunctionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomePageFunctionViewHolder holder, int position) {
        holder.setData(listFunction.get(position));
    }

    @Override
    public int getItemCount() {
        return listFunction.size();
    }

    public class HomePageFunctionViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_function_name)
        TextView tvFunctionName;
        @BindView(R.id.iv_function_image)
        ImageView ivFunctionImage;
        ImageView ivBackground;
        View view;

        public HomePageFunctionViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            setupUI();
        }

        private void setupUI() {
            ivFunctionImage = view.findViewById(R.id.iv_function_image);
            tvFunctionName = view.findViewById(R.id.tv_function_name);
            ivBackground = view.findViewById(R.id.iv_background);
        }

        public void setData(FunctionType functionType){
            Picasso.with(context).load(functionType.getImageResource()).into(ivFunctionImage);
            ivFunctionImage.setBackgroundColor(Color.parseColor(functionType.getBackgroundColor()));
            ivBackground.setBackgroundColor(Color.parseColor(functionType.getBackgroundColor()));
            tvFunctionName.setText(functionType.getType());
            view.setTag(functionType);
        }
    }

}
