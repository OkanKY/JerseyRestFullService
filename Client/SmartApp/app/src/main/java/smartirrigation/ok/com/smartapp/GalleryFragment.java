package smartirrigation.ok.com.smartapp;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Dean Ding
 */
public class GalleryFragment extends Fragment {
    static final String BASE = "http://i.imgur.com/";
    static final String EXT = ".jpg";
    static final String[] URLS = {
            "https://upload.wikimedia.org/wikipedia/commons/2/26/Felsoetold_Wheat_field,_Hungary.jpg",
            "http://wallpaper.pickywallpapers.com/1920x1080/daisy-field-in-summer.jpg",
            "http://phandroid.s3.amazonaws.com/wp-content/uploads/2015/01/field-5.jpg",
            "https://static.pexels.com/photos/6536/field-flowers-yellow-agriculture.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/2/26/Felsoetold_Wheat_field,_Hungary.jpg",
            "http://fullhdpictures.com/wp-content/uploads/2016/02/Gorgeous-Field-of-Wheat-Wallpaper.jpg",
            "http://d.fastcompany.net/multisite_files/fastcompany/imagecache/1280/poster/2013/10/3020337-poster-p-1-with-farmplicity-the-farm-to-table-movement-meets-the-21st-century.jpg"
,
    };


    private GridView mGrid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gallery, container, false);
        mGrid = (GridView) view.findViewById(R.id.grid);
        mGrid.setAdapter(new SampleGridViewAdapter(getActivity()));
        mGrid.setFocusable(false);
        view.setFocusable(false);
        return view;
    }

    final class SampleGridViewAdapter extends BaseAdapter {
        private final Context context;
        private final List<String> urls = new ArrayList<String>();

        public SampleGridViewAdapter(Context context) {
            this.context = context;

            // Ensure we get a different ordering of images on each run.
            Collections.addAll(urls, URLS);
            Collections.shuffle(urls);

            // Triple up the list.
            ArrayList<String> copy = new ArrayList<String>(urls);
            urls.addAll(copy);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SquaredImageView view = (SquaredImageView) convertView;
            if (view == null) {
                view = new SquaredImageView(context);
                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }

            // Get the image URL for the current position.
            String url = getItem(position);

            // Trigger the download of the URL asynchronously into the image view.
            Picasso.with(context) //
                    .load(url) //
                    .placeholder(R.drawable.placeholder) //
                    .fit() //
                    .tag(context) //
                    .into(view);

            return view;
        }

        @Override
        public int getCount() {
            return urls.size();
        }

        @Override
        public String getItem(int position) {
            return urls.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
    }

    final class SquaredImageView extends ImageView {
        public SquaredImageView(Context context) {
            super(context);
        }

        public SquaredImageView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
        }
    }
}
