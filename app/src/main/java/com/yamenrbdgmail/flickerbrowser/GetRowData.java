package com.yamenrbdgmail.flickerbrowser;

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
    }
}
