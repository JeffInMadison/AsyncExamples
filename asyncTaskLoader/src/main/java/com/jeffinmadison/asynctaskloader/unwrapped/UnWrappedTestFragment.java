package com.jeffinmadison.asynctaskloader.unwrapped;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Jeff on 7/10/2014.
 * Copyright JeffInMadison.com 2014
 */
public class UnWrappedTestFragment extends Fragment implements LoaderManager.LoaderCallbacks<TestLoader> {
    @Override
    public Loader<TestLoader> onCreateLoader(final int id, final Bundle args) {
        return new Loader<TestLoader>(getActivity());
    }

    @Override
    public void onLoadFinished(final Loader<TestLoader> loader, final TestLoader data) {

    }

    @Override
    public void onLoaderReset(final Loader<TestLoader> loader) {

    }

}
