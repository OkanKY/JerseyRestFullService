package smartirrigation.ok.com.smartapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Okan on 22.3.2016.
 */
public class LoginActivity extends ActionBarActivity implements View.OnClickListener {
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    private void init()
    {
    loginButton=(Button)findViewById(R.id.sign_in_button);
    loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==loginButton)
        {
        startMainActivity();
        }
    }
    private void startMainActivity()
    {
        Intent mIntent=new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(mIntent);

    }
}
