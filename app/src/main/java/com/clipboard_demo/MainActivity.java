package com.clipboard_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static EditText text;
    private static Button copy_text, show_text;
    private static TextView clipboardData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setClickListeners();
    }

    /*  Init all views  */
    private void initViews() {

        text = (EditText) findViewById(R.id.text);
        copy_text = (Button) findViewById(R.id.copy_text);
        show_text = (Button) findViewById(R.id.show_text);
        clipboardData = (TextView) findViewById(R.id.clipboard_data);

    }

    /*  Set Click Listeners  */
    private void setClickListeners() {

        copy_text.setOnClickListener(this);
        show_text.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.copy_text:

                //Copy data to Clipboard
                String data = text.getText().toString().trim();
                if (!data.equals(""))
                    Clipboard_Utils.copyToClipboard(MainActivity.this, data);
                break;
            case R.id.show_text:

                //Get Data from Clipboard and set over TextView
                String text = Clipboard_Utils.getDataFromClipboard(MainActivity.this);
                if (!text.equals(""))
                    clipboardData.setText(text);
                else
                    Toast.makeText(MainActivity.this, "Clipboard is empty.", Toast.LENGTH_SHORT).show();
                break;
        }

    }


}
