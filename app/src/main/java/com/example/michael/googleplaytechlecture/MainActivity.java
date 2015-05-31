package com.example.michael.googleplaytechlecture;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnDetails = (Button) findViewById(R.id.btnDetails);
        btnDetails.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String appPackageName = "com.smule.singandroid";// = getPackageName(); // from Context or Activity object
                try { // If Google Play is installed:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException e) { // Otherwise, open browser
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }
            }
        });
        final Button btnBrowser = (Button) findViewById(R.id.btnBrowser);
        btnBrowser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String appPackageName = "com.smule.singandroid";// = getPackageName(); // from Context or Activity object
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
        });
        final Button btnAllApps = (Button) findViewById(R.id.btnAllApps);
        btnAllApps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String publisherName = "Smule, Inc";
                try { // If Google Play is installed:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:" + publisherName)));
                } catch (android.content.ActivityNotFoundException e) { // Otherwise, open browser
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/search?q=pub:" + publisherName)));
                }
            }
        });
        final Button btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String searchQuery = ((EditText) findViewById(R.id.editSearch)).getText().toString();
                try { // If Google Play is installed:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=" + searchQuery + "&c=apps")));
                } catch (android.content.ActivityNotFoundException e) { // Otherwise, open browser
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/search?q=" + searchQuery + "&c=apps")));
                }
            }
        });
        final Button btnCollection = (Button) findViewById(R.id.btnCollection);
        btnCollection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String collectionName = "topselling_paid";
                try { // If Google Play is installed:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://apps/collection/" + collectionName)));
                } catch (android.content.ActivityNotFoundException e) { // Otherwise, open browser
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/collection/" + collectionName)));
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
