package com.example.yogesh.listintenttest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;


public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final Button sms = (Button) findViewById(R.id.sms);
        sms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + Uri.encode("12016169346")));
                intent.putExtra("sms_body","hello");
                startActivity(intent);
            }
        });

        final Button tel = (Button) findViewById(R.id.tel);
        tel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final Intent telintent = new Intent(Intent.ACTION_DIAL);
                telintent.setData(Uri.parse("tel:12016169346"));
                startActivity(telintent);
            }
        });

        final Button web = (Button) findViewById(R.id.web);
        web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Intent webintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(webintent);
            }
        });


        final Button btnmap = (Button) findViewById(R.id.btnmap);
        btnmap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

               // Working Code 1
                /*Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
                startActivity(intent); */

                // Working Code 2
                /*Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?saddr="+38.899533+","+-77.036476+"&daddr="+38.899533+","+-77.036476));
                startActivity(intent);*/

                // Not Working
                /*Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("geo:37.827500,-122.481670"));
                startActivity(i);*/

                // Not Working
               /* startActivity(
                        new Intent(
                                android.content.Intent.ACTION_VIEW,
                                Uri.parse("geo:51.49234,7.43045"))); */

               // Not Working
               /* final String uri= "geo:40.7109684,-74.0047403?z=18";

                btnmap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
                    }
                }); */

                /*double latitude = 13.042206;
                double longitude = 80.17000;
                Uri uri = Uri.parse("geo:" + latitude + "," + longitude + "?z=10");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);*/


                /*double latitude = 40.714728;
                double longitude = -73.998672;
                String label = "ABC Label";
                String uriBegin = "geo:" + latitude + "," + longitude;
                String query = latitude + "," + longitude + "(" + label + ")";
                String encodedQuery = Uri.encode(query);
                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                Uri uri = Uri.parse(uriString);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(intent);*/

                // From Professor
                //String geoUri = String.format("geo:38.899533, -77.036476");
                String geoUri = String.format("geo:18.474667, 73.813324");
                Uri geo = Uri.parse(geoUri);
                final Intent geomap = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(geomap);

                /*try {
                    String geoUri = String.format("geo: 38.899533, -77.036476");
                    Uri geo = Uri.parse(geoUri);
                    Intent geomap = new Intent(Intent.ACTION_VIEW, geo);
                    startActivity(geomap);
                } catch (Exception e){
                }*/
            }
        });

        final Button btnshare = (Button) findViewById(R.id.btnshare);
        btnshare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "CS639");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Join CS639");
                startActivity(Intent.createChooser(shareIntent, "Share the love"));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.my, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId())
        {
            case R.id.myshare:
                Toast.makeText(MyActivity.this, "New Game Option Selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.myshare1:
                Toast.makeText(MyActivity.this, "Share with your friends", Toast.LENGTH_SHORT).show();
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "CS639");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Join CS639");
                startActivity(Intent.createChooser(shareIntent, "Share the love"));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

        /*int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);*/

    }
}
