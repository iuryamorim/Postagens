package iuryamorim.postagem;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iuryamorim.postagem.adapter.VideoAdapter;
import iuryamorim.postagem.adapter.VideoRelAdapter;
import iuryamorim.postagem.adapter.ViewPagerAdapter;
import iuryamorim.postagem.domain.Video;
import iuryamorim.postagem.fragments.FragmentArtigos;
import iuryamorim.postagem.fragments.FragmentVideos;
import iuryamorim.postagem.fragments.FragmentVideosRel;
import iuryamorim.postagem.interfaces.RecyclerViewOnClickListenerHack;

public class VideoActivity extends AppCompatActivity {
    private Video video;
    private Button btn;
    private ViewPager viewPager;
    public static List<Video> mListAux;
    public static int click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        video = (Video) getIntent().getExtras().getSerializable("video");

        click = video.getPosition();

        btn = (Button) findViewById(R.id.btnVideo);

        ImageView fotoCardVideo = (ImageView) findViewById(R.id.fotoCardVideo);
        TextView titleCardVideo = (TextView) findViewById(R.id.titleCardVideo);


        fotoCardVideo.setImageResource(video.getFoto());
        titleCardVideo.setText(video.getTitulo());

        getSupportActionBar().setTitle(titleCardVideo.getText().toString());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VideoActivity.this, VideoFullscreenActivity.class);
                i.putExtra("url", video.getUrl());
                startActivity(i);
            }
        });

        mListAux = FragmentVideos.mList;

        viewPager = (ViewPager) findViewById(R.id.viewPagerVideo);
        configurarViewPager(viewPager);
    }

    private void configurarViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentVideosRel(), "Artigos");

        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return true;
    }

}
