package com.jeffinmadison.asynctaskloader.unwrapped;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff on 7/10/2014.
 * Copyright JeffInMadison.com 2014
 */
public class TestLoader extends AsyncTaskLoader<List<String>> {

    public TestLoader(final Context context) {
        super(context);
    }

    @Override
    public List<String> loadInBackground() {
        return new ArrayList<String>();
    }
}
