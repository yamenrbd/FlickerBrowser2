package com.yamenrbdgmail.flickerbrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by German Center on 06/02/2017.
 */

public class FlickerRecycleViewAdapter extends RecyclerView.Adapter<FlickerImageViewHolder> {
    private List<Photo> mPhotoList;
    private Context mContext;

    public FlickerRecycleViewAdapter(Context context, List<Photo> mPhotoList) {
        mContext = context;
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
    public void onBindViewHolder(FlickerImageViewHolder flickerImageViewHolder, int i) {
        Photo photoItem =mPhotoList.get(i);
       // Log.d(LOG_TAG,"processing "+photoItem.getMtitle()+"--> "+Integer.toString(i));

        Picasso.with(mContext).load(photoItem.getmImage())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(flickerImageViewHolder.thumbnail);
        flickerImageViewHolder.title.setText(photoItem.getMtitle());

    }
}
