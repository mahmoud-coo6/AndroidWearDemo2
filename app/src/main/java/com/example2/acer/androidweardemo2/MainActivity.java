package com.example2.acer.androidweardemo2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements WearableListView.ClickListener {
    //  private TextView mTextView;
    String[] elements={"List 1","List 2","List 3","List 4"};

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        Integer tag=(Integer) viewHolder.itemView.getTag();
        Toast.makeText(getApplicationContext(),Integer.toString(tag),Toast.LENGTH_LONG).show();
      //  Log.i("AppInfo","ItamTapped "+Integer.toString(tag));
    }

    @Override
    public void onTopEmptyRegionClick() {

    }

    private static final class MyAdapter extends WearableListView.Adapter{

        private String[] mDataset;
        private final Context nContext;
        private final LayoutInflater mInFilter;

        public MyAdapter(Context context,String[] dataset){
            nContext=context;
            mInFilter=LayoutInflater.from(context);
            mDataset=dataset;
        }
        public static class ItemViewHolder extends WearableListView.ViewHolder{
            private TextView textView;
            public ItemViewHolder(View itemView) {
                super(itemView);
                textView=(TextView)itemView.findViewById(R.id.name);
            }
        }
        public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ItemViewHolder(mInFilter.inflate(R.layout.list_item,null));
        }

        @Override
        public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
            ItemViewHolder itemHolder=(ItemViewHolder)holder;
            TextView view=itemHolder.textView;
            view.setText(mDataset[position]);
            holder.itemView.setTag(position);
        }

        @Override
        public int getItemCount() {
            return mDataset.length;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {

                WearableListView listView=(WearableListView)findViewById(R.id.wearable_list);
                listView.setAdapter(new MyAdapter(MainActivity.this,elements));
                 listView.setClickListener(MainActivity.this);

                /*
                mTextView = (TextView) stub.findViewById(R.id.text);
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                CardFragment cardFragment=CardFragment.create("Hi Mahmoud!","How are you today?",android.R.drawable.btn_plus);
                fragmentTransaction.add(R.id.frame_layout,cardFragment);
                fragmentTransaction.commit();
                */

            }
        });
    }
}
