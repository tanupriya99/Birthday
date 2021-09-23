package com.example.birthday.slider_name;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.birthday.R;

import org.jetbrains.annotations.NotNull;

public class helper extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    private MediaPlayer mediaPlayer;

    public helper(Context context) {
        this.context = context;
    }

    int[] images = {
            R.drawable.assign,
            R.drawable.exam,
            R.drawable.hardt_new,
            R.drawable.angry,
            R.drawable.speci
    };
    int[] headings ={R.string.str5,R.string.str6,R.string.str7,R.string.str8,R.string.str9};
    int[] song_1 ={R.raw.likeyou,R.raw.thatsall,R.raw.chahedukh,R.raw.honey,R.raw.kehti};
    int[] descriptions ={R.string.str1,R.string.str2,R.string.str3,R.string.str4,R.string.str10};
    @Override
    public int getCount() {
        return headings.length;
    }
    @Override
    public boolean isViewFromObject(@NotNull View view,@NotNull Object object) {
        return view== object;
    }
    @NotNull
    @Override
    public Object instantiateItem(@NonNull  ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slides_layout,container,false);
        ImageView imageView=view.findViewById(R.id.slider_image);
        TextView heading=view.findViewById(R.id.slider_heading);
        TextView desc=view.findViewById(R.id.slider_desc);
        Button button_start=view.findViewById(R.id.button_start);
        Button button_stop=view.findViewById(R.id.button_stop);
        button_start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer=MediaPlayer.create(context,song_1[position]);
                mediaPlayer.start();
            }
        });
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });
        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        desc.setText(descriptions[position]);
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(@NonNull  ViewGroup container, int position, @NonNull  Object object) {
        container.removeView((ConstraintLayout)object);
    }
}