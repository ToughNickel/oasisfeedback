package com.example.rajn.oasisfeedback;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class Description extends AppCompatActivity {

    EditText email;
    EditText feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        final Context context = this;

        email = (EditText) findViewById(R.id.mail);
        feed = (EditText) findViewById(R.id.describe);

        final String emailFeed = email.getText().toString();
        final String feedD = feed.getText().toString();

        final String feel = getIntent().getStringExtra("feel");

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Specifying the components of the portal submission
                String url = "http://oasisfeedback.000webhostapp.com/feed.php";
                String request_method = "GET";
                String email_feed = email.getText().toString();
                //email_feed = "rajn";
                String description_feed = feed.getText().toString();
                //description_feed = "Now testing from button";
                description_feed = description_feed.replace(" " , "+");
                String USER_AGENT = "Mozilla/5.0";
                //--------------------------------------------------

                //Modifying the url to accomodate the form data
                url += "?";
                url += "email=" + email_feed + "%40vmware.com&description=" + description_feed + "&feel="+feel+"&submit=Submit+your+feedback";
                //---------------------------------------------

                //actually submitting the data to the portal
                try {
                    RequestQueue queue = Volley.newRequestQueue(Description.this);
                    JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                            new Response.Listener<JSONObject>()
                            {
                                @Override
                                public void onResponse(JSONObject response) {
                                    // display response
                                    Log.d("Response", response.toString());
                                }
                            },
                            new Response.ErrorListener()
                            {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    //Log.d("Error.Response", response);
                                    System.out.println("Galti ho gayi bhai !! error : " + error.networkResponse);
                                }
                            }
                    );

// add it to the RequestQueue
                    queue.add(getRequest);










                    //alerting with res
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                    // set title
                    alertDialogBuilder.setTitle("Output");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("ho gaya")
                            .setCancelable(false)
                            .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, close
                                    // current activity
                                    Description.this.finish();
                                }
                            });

                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                    //-----------------
                } catch (Exception e) {
                    e.printStackTrace();
                    //Alerting for error
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                    // set title
                    alertDialogBuilder.setTitle("Error in sending");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("error in sending data to the portal")
                            .setCancelable(false)
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, close
                                    // current activity
                                    Description.this.finish();
                                }
                            });

                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                    //------------------
                }


                //------------------------------------------




                //Alerting
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set title
                alertDialogBuilder.setTitle("Data Sent");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Thanks for your feed back")
                        .setCancelable(false)
                        .setPositiveButton("Okay, Great!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
                                Description.this.finish();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
                //--------
            }
        });
    }
}
