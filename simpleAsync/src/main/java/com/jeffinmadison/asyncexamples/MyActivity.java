package com.jeffinmadison.asyncexamples;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends ActionBarActivity implements View.OnClickListener {

    private final DummyAsyncTask mDummyAsyncTask;
    private TextView mOrientationTextView;
    private TextView mStatusTextView;
    private Button mNewActivityButton;

    public MyActivity() {
        mDummyAsyncTask = new DummyAsyncTask();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mNewActivityButton = (Button) findViewById(R.id.newActivityButton);
        mNewActivityButton.setOnClickListener(this);
        mOrientationTextView = (TextView) findViewById(R.id.orientationTextView);
        mStatusTextView = (TextView) findViewById(R.id.statusTextView);
        int orientation = getResources().getConfiguration().orientation;
        mOrientationTextView.setText(updateOrientationLabel(orientation));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDummyAsyncTask.execute(null,null,null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDummyAsyncTask.cancel(true);
    }

    @Override
    public void onClick(final View v) {
        startActivity(new Intent(this, DummyActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String updateOrientationLabel(int orientation) {
        switch (orientation) {
            case Configuration.ORIENTATION_LANDSCAPE:
                return "Landscape";
            case Configuration.ORIENTATION_PORTRAIT:
                return "Portrait";
            default:
                return "unknown";
        }
    }

    private class DummyAsyncTask extends AsyncTask<Void,Void,Void> {
        boolean mCancelCalled;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mStatusTextView.setText("started");
        }

        @Override
        protected Void doInBackground(final Void... params) {
            for (int ii = 0; ii < 4; ii++) {
                if (mCancelCalled) {
                    break;
                } else {
                    SystemClock.sleep(1000);
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(final Void aVoid) {
            super.onPostExecute(aVoid);
            if (mCancelCalled) {
                mStatusTextView.setText("cancelled" +
                        "");
            } else {
                mStatusTextView.setText("ended");
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            mCancelCalled = true;
        }
    }
}
