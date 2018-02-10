package vn.edu.fpt.se04476.mydocterproject.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import vn.edu.fpt.se04476.mydocterproject.R;
import vn.edu.fpt.se04476.mydocterproject.entities.MedicalDetail;

/**
 * Created by EDGY on 2/7/2018.
 */

public class ListAppliedMedicalAdapter extends RecyclerView.Adapter<ListAppliedMedicalAdapter.AppliedMedicalViewHolder>{

    private List<MedicalDetail> medicalDetailList;
    private Context context;
    private View.OnClickListener onItemClickListener;

    public ListAppliedMedicalAdapter(List<MedicalDetail> medicalDetailList, Context context) {
        this.medicalDetailList = medicalDetailList;
        this.context = context;
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public AppliedMedicalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_list_applied_medical, parent, false);
        itemView.setOnClickListener(onItemClickListener);
        return new AppliedMedicalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AppliedMedicalViewHolder holder, int position) {
        holder.setData(medicalDetailList.get(position));
    }

    @Override
    public int getItemCount() {
        return medicalDetailList.size();
    }

    public class AppliedMedicalViewHolder extends RecyclerView.ViewHolder{
        private View view;
        private ImageView ivImage;
        private TextView tvName;

        public AppliedMedicalViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            setupUI();
        }

        private void setupUI() {
            ivImage = view.findViewById(R.id.iv_medical_image);
            tvName = view.findViewById(R.id.tv_medical_name);
        }

        public void setData(MedicalDetail medicalDetail) {
            Picasso.with(context).load(medicalDetail.getImage()).into(ivImage);
            tvName.setText(medicalDetail.getName());
        }

    }
}
