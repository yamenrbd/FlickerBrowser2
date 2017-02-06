package com.yamenrbdgmail.flickerbrowser;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by German Center on 06/02/2017.
 */

public class FlickerImageViewHolder  extends RecyclerView.ViewHolder{
    protected ImageView thumbnail;
    protected TextView title;

    public FlickerImageViewHolder(View view){
        this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        this.title = (TextView) view.findViewById(R.id.title);

    }
}
