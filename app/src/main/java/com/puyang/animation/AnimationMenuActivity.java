package com.puyang.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.puyang.justforfun.R;

/**
 * Created by yangpu on 2/22/16.
 */
public class AnimationMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_list);

        ListView animationListView = (ListView)findViewById(R.id.animation_listview);
        animationListView.setAdapter(new AnimationListAdapter(this));

        animationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position,
                                    long id) {
                Intent animationIntent = new Intent(AnimationMenuActivity.this, AllAnimation.class);
                switch (position) {
                    case 0:
                        animationIntent.putExtra("value", "windows");
                        break;
                    case 1:
                        animationIntent.putExtra("value", "hangout");
                        break;
                    case 2:
                        animationIntent.putExtra("value", "leftright");
                        break;
                    case 3:
                        animationIntent.putExtra("value", "foursquare");
                        break;
                    case 4:
                        animationIntent.putExtra("value", "incrementingloading");
                        break;

                    default:
                        break;
                }
                startActivity(animationIntent);
            }
        });

    }
}
