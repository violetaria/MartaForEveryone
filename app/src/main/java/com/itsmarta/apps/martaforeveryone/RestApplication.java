package com.itsmarta.apps.martaforeveryone;

import android.content.Context;

import com.itsmarta.apps.martaforeveryone.clients.MartaAPIClient;

/*
 * This is the Android application itself and is used to configure various settings
 * including the image cache in memory and on disk. This also adds a singleton
 * for accessing the relevant rest client.
 *
 *     MartaAPIClient client = RestApplication.getRestClient();
 *     // use client to send requests to API
 *
 */
public class RestApplication extends com.activeandroid.app.Application {
	private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		RestApplication.context = this;
	}

	public static MartaAPIClient getMartaAPIClient() {
		return new MartaAPIClient();
	}


}