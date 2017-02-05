package com.yamenrbdgmail.flickerbrowser;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by German Center on 01/02/2017.
 */
enum DownloadStatus{IDLE,PROCESSING,NOT_INITIALISED,FAILED_OR_EMPTY,OK};

public class GetRowData {
    private String LOG_TAG = GetRowData.class.getSimpleName();
    private String mRowUrl;
    private String mData;
    private DownloadStatus mDownloadStatus;

    public GetRowData(String mRowUrl) {
        this.mRowUrl = mRowUrl;
        this.mDownloadStatus = DownloadStatus.IDLE;

    }

    public void setmRowUrl(String mRowUrl) {
        this.mRowUrl = mRowUrl;
    }

    public void reset (String mRowUrl){
        this.mRowUrl=null;
        this.mData=null;
        this.mDownloadStatus=DownloadStatus.IDLE;
    }

    public DownloadStatus getmDownloadStatus() {
        return mDownloadStatus;
    }

    public String getmData() {
        return mData;
    }
    public void execute(){
        this.mDownloadStatus = mDownloadStatus.PROCESSING;
        DownloadRawData downloadRawData = new DownloadRawData();
        downloadRawData.execute(mRowUrl);

    }

    public class DownloadRawData extends AsyncTask<String , Void , String>{
        protected void onPostExecute(String webData){
            //TODO fill later
            mData =webData;
            Log.v(LOG_TAG,"data returned was "+mData);
            if (mData==null){
                if(mDownloadStatus==null){
                    mDownloadStatus=DownloadStatus.NOT_INITIALISED;
                }
                else{
                    mDownloadStatus=DownloadStatus.FAILED_OR_EMPTY;

                }
            }else{
                //sucsses
                mDownloadStatus=DownloadStatus.OK;
            }
        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            if(params==null){
                return null;
            }
            try{
                URL url =  new URL(params[0]);
                urlConnection=(HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream = urlConnection.getInputStream();

                if (inputStream == null){
                    return null;
                }

                StringBuffer buffer = new StringBuffer();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while((line= reader.readLine())!=null){
                    buffer.append(line+ "\n");
                }
                return buffer.toString();

            }catch(IOException e){
                Log.e(LOG_TAG,"error",e);
                return null;

            }finally{
                if (urlConnection!=null){
                    urlConnection.disconnect();
                }
                if (reader!=null){
                    try{
                    reader.close();
                    }catch (final IOException e){
                        Log.e(LOG_TAG,"error closing string",e);
                    }
                }
            }

        }
    }
}
