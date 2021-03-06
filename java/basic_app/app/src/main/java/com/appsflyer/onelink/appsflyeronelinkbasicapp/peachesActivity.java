package com.appsflyer.onelink.appsflyeronelinkbasicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.appsflyer.deeplink.DeepLink;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static com.appsflyer.onelink.appsflyeronelinkbasicapp.AppsflyerBasicApp.LOG_TAG;

public class peachesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peaches);

        Intent intent = getIntent();
        DeepLink dlData= new Gson().fromJson(intent.getStringExtra(AppsflyerBasicApp.DL_ATTRS),DeepLink.class);
        if (dlData != null) {
            TextView dlAttrsText = findViewById(R.id.peaches_deeplinkparams);
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(dlData.toString());
                dlAttrsText.setText(jsonObject.toString(4).replaceAll("\\\\",""));// 4 is no of spaces for indent
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            TextView dlTitleText = findViewById(R.id.peaches_deeplinktitle);
            dlTitleText.setText("No Deep Linking Happened");
        }

    }
}
