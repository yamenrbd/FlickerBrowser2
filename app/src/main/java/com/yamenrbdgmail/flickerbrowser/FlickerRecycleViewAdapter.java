package com.yamenrbdgmail.flickerbrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by German Center on 06/02/2017.
 */

public class FlickerRecycleViewAdaptern extends RecyclerView.Adapter<FlickerImageViewHolder> {
    private List<Photo> mPhotoList;
    private Context context;

    public FlickerRecycleViewAdaptern(Context context, List<Photo> mPhotoList) {
        this.context = context;
        this.mPhotoList = mPhotoList;
    }


    @Override
    public FlickerImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse,null);
        FlickerImageViewHolder flickerImageViewHolder = new FlickerImageViewHolder(view);
        return flickerImageViewHolder;
    }

    @Override
    public int getItemCount() {
        return (null !=mPhotoList ?mPhotoList.size():0);
    }

    @Override
    public void onBindViewHolder(FlickerImageViewHolder holder, int i) {
        Photo photoItem =mPhotoList.get(i);

    }
}
