package smartirrigation.ok.com.smartapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ok.item.LoginItem;
import com.ok.rest.client.IrrigationApi;
import com.ok.rest.client.LoginCallback;


public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings, container, false);
    }
    private void checkLogin(String userName,String password)
    {
        IrrigationApi irrigationApi=IrrigationApi.create();
        irrigationApi.checkLogin(userName,password, new LoginCallback() {
            @Override
            public void onSuccess(LoginItem result) {

            }

            @Override
            public void onFailure(Throwable t) {
                showMessage(t.getMessage().toString());
            }
        });

    }
    private void showMessage(String message)
    {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

}
