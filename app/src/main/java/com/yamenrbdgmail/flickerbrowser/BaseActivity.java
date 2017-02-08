package com.yamenrbdgmail.flickerbrowser;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by German Center on 08/02/2017.
 */

public class BaseActivity extends AppCompatActivity{
    private Toolbar mToolBar;

    protected Toolbar activateToolBar(){
        if(mToolBar == null){
            mToolBar = (Toolbar) findViewById(R.id.app_bar);
            if(mToolBar != null){
                setSupportActionBar(mToolBar);
            }
        }
        return mToolBar;
    }
}
