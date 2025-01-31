package com.example.galeria.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.galeria.R;

public class GalleryCVAdapter extends BaseAdapter {

    private Context mContext;
    public int[]imgArray = {
            R.drawable.astra,
            R.drawable.brimstone,
            R.drawable.chamber,
            R.drawable.clove,
            R.drawable.fade,
            R.drawable.harbor,
            R.drawable.iso,
            R.drawable.jett,
            R.drawable.neon,
            R.drawable.omen,
            R.drawable.phoenix,
            R.drawable.raze,
            R.drawable.sage,
            R.drawable.reyna,
            R.drawable.cypher,
            R.drawable.gekko,
            R.drawable.viper,
            R.drawable.vyse

    };

    public GalleryCVAdapter(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public int getCount(){
        return imgArray.length;
    }

    @Override
    public Object getItem (int position){
        return imgArray[position];
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){

        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imgArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(340, 350));

        return imageView;
    }


}
