package smartirrigation.ok.com.smartapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.ok.rest.client.IrrigationApi;
import com.ok.rest.client.ResultCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * User: special
 * Date: 13-12-22
 * Time: 下午3:26
 * Mail: specialcyci@gmail.com
 */
public class CalendarFragment extends Fragment {

    private View parentView;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> calendarList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.calendar, container, false);
        listView   = (ListView) parentView.findViewById(R.id.listView);
        initView();
        return parentView;
    }

    private void initView(){
        calendarList = new ArrayList<String>();
         arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                calendarList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "Clicked item!", Toast.LENGTH_LONG).show();
            }
        });
        getCalendarData();
    }

    private void getCalendarData(){
        IrrigationApi irrigationApi=IrrigationApi.create();
        irrigationApi.getUserFieldList("okan", "1234", new ResultCallback() {
            @Override
            public void onSuccess(Object result) {
                calendarList.add(result.toString());
               // arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        calendarList.add("New Year's Day");
        calendarList.add("St. Valentine's Day");
        calendarList.add("Easter Day");
    }
}
