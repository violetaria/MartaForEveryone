package com.itsmarta.apps.martaforeveryone.clients;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;


public class MartaAPIClient {
	private static final String BASE_URL = "http://developer.itsmarta.com/";

	private static final String API_KEY = "81ece4c7-dca3-43e1-8e9a-e87a92b58a89";

	private static AsyncHttpClient client = new AsyncHttpClient();

	public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
		client.get(getAbsoluteUrl(url), params, responseHandler);
	}

    public static void getRealTimeTrainData(AsyncHttpResponseHandler responseHandler){
        client.get(getAbsoluteUrl("RealtimeTrain/RestServiceNextTrain/GetRealtimeArrivals"), null, responseHandler);
    }

    public static void getRealTimeBusData(AsyncHttpResponseHandler responseHandler){
        client.get(getAbsoluteUrl("BRDRestService/RestBusRealTimeService/GetAllBus "), null, responseHandler);
    }

	private static String getAbsoluteUrl(String relativeUrl) {
		return BASE_URL + relativeUrl + "?apikey=" + API_KEY;
	}
}