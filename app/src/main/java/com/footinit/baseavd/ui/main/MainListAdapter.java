package com.footinit.baseavd.ui.main;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.footinit.baseavd.R;
import com.footinit.baseavd.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Abhijit on 02-03-2018.
 */

public class MainListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_NORMAL = 0;


    private List<Drawable> avdList;

    public MainListAdapter(List<Drawable> avdList) {
        this.avdList = avdList;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_avd, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        return VIEW_NORMAL;
    }

    @Override
    public int getItemCount() {
        if (avdList != null && avdList.size() > 0)
            return avdList.size();
        else return 0;
    }

    public void addItems(List<Drawable> drawables) {
        avdList.clear();
        avdList.addAll(drawables);
        notifyDataSetChanged();
    }


    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_avd)
        AppCompatImageView ivAVD;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
            ivAVD.setBackgroundDrawable(null);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            ivAVD.setImageDrawable(avdList.get(position));
            animateDrawable(ivAVD.getDrawable());

            itemView.setOnClickListener(view -> animateDrawable(ivAVD.getDrawable()));
        }
    }

    private void animateDrawable(Drawable drawable) {
        if (drawable != null && drawable instanceof Animatable)
            ((Animatable) drawable).start();
        else if (drawable instanceof AnimatedVectorDrawableCompat)
            ((AnimatedVectorDrawableCompat) drawable).start();
        else if (drawable instanceof AnimatedVectorDrawable)
            ((AnimatedVectorDrawable) drawable).start();
    }
}
