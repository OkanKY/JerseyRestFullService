package smartirrigation.ok.com.smartapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.ok.item.BestPlantItem;
import com.ok.item.FileListItem;
import com.ok.rest.client.BestItemCallback;
import com.ok.rest.client.IrrigationApi;
import com.ok.rest.client.FieldListCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * User: special
 * Date: 13-12-22
 * Time: 下午3:26
 * Mail: specialcyci@gmail.com
 */
public class FieldListFragment extends Fragment implements View.OnClickListener{

    private View parentView;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> calendarList;
    private Button restRequest;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.calendar, container, false);
        listView   = (ListView) parentView.findViewById(R.id.listView);
        restRequest=(Button)parentView.findViewById(R.id.restRequest);
        restRequest.setOnClickListener(this);
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
                IrrigationApi irrigationApi=IrrigationApi.create();
                irrigationApi.getBestPlant("okan",
                        "1234", 1,
                        1, 1,
                        1, 1,
                        1, new BestItemCallback() {
                            @Override
                            public void onSuccess(BestPlantItem result) {
                            showMessage("Best Plant: "+result.getResult());
                            }

                            @Override
                            public void onFailure(Throwable t) {
                            showMessage(t.getMessage());
                            }
                        });
            }
        });
        //get User Field List
        recieveFieldListData();

    }
    @Override
    public void onClick(View v) {
        if(v==restRequest)
        {
            recieveFieldListData();
        }
    }
    private void recieveFieldListData()
    {
        IrrigationApi irrigationApi=IrrigationApi.create();
        irrigationApi.getUserFieldList("okan", "1234", new FieldListCallback() {
            @Override
            public void onSuccess(List<FileListItem> result) {
                updateList(result);
            }

            @Override
            public void onFailure(Throwable t) {
                showMessage(t.getMessage().toString());
            }
        });
    }
    private void updateList(List<FileListItem> items)
    {
        calendarList.clear();
        for (FileListItem item: items) {
            String s=" fieldName: " +item.getFieldName()+
                     "\n fieldInfo : "+item.getFieldInfo();
        calendarList.add(s);
        }
        arrayAdapter.notifyDataSetChanged();
    }
    private void showMessage(String message)
    {
        Toast.makeText(getContext(),""+message,Toast.LENGTH_LONG).show();
    }
}
