package com.commonsware.empublite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.commonsware.empublite.prefs.DisplayPreferenceActivity;

public class EmPubLiteActivity extends FragmentActivity {
    private static final String MODEL = "model";
    private ViewPager pager = null;
    private ContentsAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportFragmentManager().findFragmentByTag(MODEL) == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(new ModelFragment(), MODEL)
                    .commit();
        }

        setContentView(R.layout.main);

        pager = (ViewPager) findViewById(R.id.pager);
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.options, menu);
        return (super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                pager.setCurrentItem(0, false);
                return (true);

            case R.id.menu_item_about:
                Intent i = new Intent(this, SimpleContentActivity.class);

                i.putExtra(SimpleContentActivity.EXTRA_FILE,
                        "file:///android_asset/misc/about.html");
                startActivity(i);

                return (true);

            case R.id.menu_item_help:
                i = new Intent(this, SimpleContentActivity.class);
                i.putExtra(SimpleContentActivity.EXTRA_FILE,
                        "file:///android_asset/misc/help.html");

                startActivity(i);

                return (true);

            case R.id.menu_item_settings:

                Intent intent = new Intent(this, DisplayPreferenceActivity.class);
                startActivity(intent);

                return true;
        }

        return (super.onOptionsItemSelected(item));
    }

    void setupPager(BookContents contents) {
        adapter = new ContentsAdapter(this, contents);
        pager.setAdapter(adapter);

        findViewById(R.id.progressBar1).setVisibility(View.GONE);
        findViewById(R.id.pager).setVisibility(View.VISIBLE);
    }
}
