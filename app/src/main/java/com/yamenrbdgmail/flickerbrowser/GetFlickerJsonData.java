package com.yamenrbdgmail.flickerbrowser;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by German Center on 02/02/2017.
 */

public class GetFlickerJsonData extends GetRowData {
    private String LOG_TAG;
    private List<Photo> mPhoto;
    private Uri mDistinationUri;



    public GetFlickerJsonData (String searchCriteria , boolean matchAll){
        super(null);
        createAndUpdateUri( searchCriteria,  matchAll);
        mPhoto = new ArrayList<Photo>();

    }
    public void execute(){
        super.setmRowUrl(mDistinationUri.toString());
        DownlodJsonData downlodJsonData =  new DownlodJsonData();
        Log.v(LOG_TAG,"BULIT URI = "+mDistinationUri.toString());
        downlodJsonData.execute(mDistinationUri.toString());

    }

    public boolean createAndUpdateUri(String searchCriteria, boolean matchAll){

    final String FLICKER_API_BASE_URL ="https://api.flickr.com/services/feeds/photos_public.gne";
        final String TAGS_PARM="tags";
        final String TAGMODE_PARM ="tagmode";
        final String FORMAT_PARM ="format";
        final String NO_JSON_CALL_BACK_PARM="nojsoncallback";

        mDistinationUri = Uri.parse(FLICKER_API_BASE_URL).buildUpon()
                .appendQueryParameter(TAGS_PARM,searchCriteria)
                .appendQueryParameter(TAGMODE_PARM,matchAll ?"ALL":"ANY")
                .appendQueryParameter(FORMAT_PARM,"json")
                .appendQueryParameter(NO_JSON_CALL_BACK_PARM,"1")
                .build();
        return mDistinationUri != null;


    }

    public List<Photo> getMPhoto() {
        return mPhoto;
    }

    public void processResult(){
        if(getmDownloadStatus()!=DownloadStatus.OK){
            Log.e(LOG_TAG,"error downloding file");
            return;
        }
        final String FLICKR_ITEM = "items";
        final String FLICKR_TITLE ="title";
        final String FLICKR_MEIDA = "media";
        final String FLICKR_PHOTO_URL ="m";
        final String FLICKR_AUTHOR = "author";
        final String FLICKR_AUTHOR_ID = "author_id";
        final String FLICKR_LINK="link";
        final String FLICKR_TAGS="tags";

        try{
            JSONObject jsonData = new JSONObject(getmData());
            JSONArray itemArray = jsonData.getJSONArray(FLICKR_ITEM);
            for(int i =0 ; i <itemArray.length();i++){

                JSONObject jsonPhoto = itemArray.getJSONObject(i);
                String title = jsonPhoto.getString(FLICKR_TITLE);
                String author = jsonPhoto.getString(FLICKR_AUTHOR);
                String authorId = jsonPhoto.getString(FLICKR_AUTHOR_ID);
                String link =jsonPhoto.getString(FLICKR_LINK);
                String tags = jsonPhoto.getString(FLICKR_TAGS);

                JSONObject jsonMedia = jsonPhoto.getJSONObject(FLICKR_MEIDA);
                String photoUrl = jsonMedia.getString(FLICKR_PHOTO_URL);
                Photo photoObject = new Photo(title,author,authorId,link,tags,photoUrl);
                this.mPhoto.add(photoObject);

            }
            for(Photo singlePhoto : mPhoto ){
                Log.v(LOG_TAG,singlePhoto.toString());


            }
        }
        catch (JSONException jsone){
            jsone.printStackTrace();
            Log.e(LOG_TAG,"error processing data");
        }
    }

    public class DownlodJsonData extends DownloadRawData{
        @Override
        protected void onPostExecute(String webData) {
            super.onPostExecute(webData);
            processResult();
        }

        @Override
        protected String doInBackground(String... params) {
            String[] par = {mDistinationUri.toString()};
            return super.doInBackground(params);
        }
    }
}
