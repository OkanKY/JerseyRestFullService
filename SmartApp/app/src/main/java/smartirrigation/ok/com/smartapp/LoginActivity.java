package smartirrigation.ok.com.smartapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ok.item.LoginItem;
import com.ok.rest.client.LoginCallback;
import com.ok.rest.client.IrrigationApi;

/**
 * Created by Okan on 22.3.2016.
 */
public class LoginActivity extends ActionBarActivity implements View.OnClickListener {
    private Button loginButton;
    private ProgressBar loginProgress;
    private EditText userNameText,passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    private void init()
    {
        userNameText=(EditText)findViewById(R.id.txt_email);
        passwordText=(EditText)findViewById(R.id.txt_password);
        loginProgress=(ProgressBar)findViewById(R.id.login_progress);
    loginButton=(Button)findViewById(R.id.sign_in_button);
    loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==loginButton)
        {
            String name=userNameText.getText().toString();
            String password=passwordText.getText().toString();
            checkLogin(name,password);
        }
    }
    private void checkLogin(String userName,String password)
    {
        loginProgress.setVisibility(View.VISIBLE);
        IrrigationApi irrigationApi=IrrigationApi.create();
        irrigationApi.checkLogin(userName,password, new LoginCallback() {
            @Override
            public void onSuccess(LoginItem result) {
                loginProgress.setVisibility(View.INVISIBLE);
               showMessage(""+result.getResult());
                startMainActivity();
            }

            @Override
            public void onFailure(Throwable t) {
            showMessage(t.getMessage().toString());
                loginProgress.setVisibility(View.INVISIBLE);
            }
        });

    }
    private void showMessage(String message)
    {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
    private void startMainActivity()
    {
        Intent mIntent=new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(mIntent);
    }
}
