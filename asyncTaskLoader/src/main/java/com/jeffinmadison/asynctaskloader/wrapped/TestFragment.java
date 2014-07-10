package com.jeffinmadison.asynctaskloader.wrapped;

import android.content.Loader;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jeffinmadison.common.loaderwrapper.AbstractAsyncTaskLoader;
import com.jeffinmadison.common.loaderwrapper.WrappedLoaderCallbacks;
import com.jeffinmadison.common.loaderwrapper.WrappedLoaderResult;

/**
 * Created by Jeff on 7/10/2014.
 * Copyright JeffInMadison.com 2014
 */
public class TestFragment extends Fragment implements WrappedLoaderCallbacks<String> {
    @Override
    public Loader<WrappedLoaderResult<String>> onCreateLoader(final int id, final Bundle args) {
        return new AbstractAsyncTaskLoader<String>(getActivity()) {
            @Override
            public String load() throws Exception {
                return null;
            }
        };
    }

    @Override
    public void onLoadFinished(final Loader<WrappedLoaderResult<String>> loader, final WrappedLoaderResult<String> data) {
    }

    @Override
    public void onLoaderReset(final Loader<WrappedLoaderResult<String>> loader) {

    }
}
