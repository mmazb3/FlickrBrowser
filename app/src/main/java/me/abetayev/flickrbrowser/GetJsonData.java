package me.abetayev.flickrbrowser;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by mmazb3 on 01.03.2018.
 *  this class downloads JSON from Flickr
 */

class GetJsonData {
    private static final String TAG = "GetJsonData";

    public void downloadJson(String url) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // called when response HTTP status is "200 OK"
                Log.d(TAG, "JSON: " + response.toString());

                // parse JSON to get the price of bitcoin. Because parsing JCON could fail,
                // wrap it in try-catch block.
                try {
                    String price = response.getString("last");
//                    updateUI(price);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.d(TAG, "Request fail! Status code: " + statusCode);
                Log.d(TAG, "Fail response: " + response);
                Log.e(TAG, e.toString());
            }
        });

    }

}
