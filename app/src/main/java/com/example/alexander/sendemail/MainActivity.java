package com.example.alexander.sendemail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText emailaddress;
    private EditText subject;
    private EditText body;
    private Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailaddress = (EditText) findViewById(R.id.edit_text_email_address);
        subject = (EditText) findViewById(R.id.edit_text_subject);
        body = (EditText) findViewById(R.id.edit_text_email_body);

        sendEmail = (Button) findViewById(R.id.button_send_email);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { emailaddress.getText().toString() });
                intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent, ""));
                }
                */


                String uriText =
                        "mailto:" + emailaddress.getText().toString() +
                                "?subject=" + Uri.encode(subject.getText().toString()) +
                                "&body=" + Uri.encode(body.getText().toString());

                Uri uri = Uri.parse(uriText);

                Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
                sendIntent.setData(uri);
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(sendIntent, "Send email"));
                }

            }
        });
    }
}
