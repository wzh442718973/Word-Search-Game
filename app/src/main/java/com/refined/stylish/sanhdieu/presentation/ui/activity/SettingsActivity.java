package com.refined.stylish.sanhdieu.presentation.ui.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import android.view.MenuItem;

import com.refined.stylish.sanhdieu.R;

/**
 * Created by abdularis on 21/07/17.
 */

public class SettingsActivity extends AppCompatPreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.settings);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
