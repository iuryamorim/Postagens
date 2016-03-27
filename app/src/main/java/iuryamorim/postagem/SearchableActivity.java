package iuryamorim.postagem;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import iuryamorim.postagem.adapter.ArtigoAdapter;
import iuryamorim.postagem.adapter.MixAdapter;
import iuryamorim.postagem.domain.Artigo;
import iuryamorim.postagem.domain.Mix;
import iuryamorim.postagem.domain.Video;
import iuryamorim.postagem.interfaces.RecyclerViewOnClickListenerHack;

public class SearchableActivity extends AppCompatActivity implements RecyclerViewOnClickListenerHack {

    private RecyclerView mRecyclerView;
    private List<Artigo> mListArtigo;
    private List<Video> mListVideo;
    private List<Mix> mListAux;
    private MixAdapter adapter;
    private Toolbar mToolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search);

        getSupportActionBar().setTitle("Buscar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mListAux = new ArrayList<>();
        mListArtigo = (new MainActivity()).getSetArtigoList(10);
        mListVideo = (new MainActivity()).getSetVideoList(10);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addOnItemTouchListener(new RecycleViewTouchListener(this, mRecyclerView, this));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        adapter = new MixAdapter(this, mListAux);
        mRecyclerView.setAdapter(adapter);

        hendleSearch(getIntent());

    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        hendleSearch(intent);
    }

    public void hendleSearch(Intent i) {
        if (i.ACTION_SEARCH.equalsIgnoreCase(i.getAction())) {
            String q = i.getStringExtra(SearchManager.QUERY);

            filter(q);
        }
    }

    public void filter(String q) {
        mListAux.clear();
        for (int i = 0, tamI = mListArtigo.size(); i < tamI; i++) {
            if (mListArtigo.get(i).getTitulo().toLowerCase().startsWith(q.toLowerCase())) {
                Mix m = new Mix(mListArtigo.get(i).getTitulo(),mListArtigo.get(i).getFoto());
                mListAux.add(m);
            }
        }
        for (int i = 0, tamI = mListVideo.size(); i < tamI; i++) {
            if (mListVideo.get(i).getTitulo().toLowerCase().startsWith(q.toLowerCase())) {
                Mix m = new Mix(mListVideo.get(i).getTitulo(),mListVideo.get(i).getFoto());
                mListAux.add(m);
            }
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClickListener(View view, int position) {
        int cont = 0;
        for (int j = 0, tamI = mListArtigo.size(); j < tamI; j++) {
            if (mListArtigo.get(j).getTitulo().toLowerCase().startsWith(mListAux.get(position).getTitulo().toLowerCase())) {
                Intent i = new Intent(this, ArtigoActivity.class);
                i.putExtra("artigo", mListArtigo.get(j));
                startActivity(i);
                cont++;
            }
        }
        if(cont == 0){
            for (int j = 0, tamI = mListVideo.size(); j < tamI; j++) {
                if (mListVideo.get(j).getTitulo().toLowerCase().startsWith(mListAux.get(position).getTitulo().toLowerCase())) {
                    Intent i = new Intent(this, VideoActivity.class);
                    i.putExtra("video", mListVideo.get(j));
                    startActivity(i);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_searchable, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView;
        MenuItem item = menu.findItem(R.id.action_searchable_activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            searchView = (SearchView) item.getActionView();
        } else {
            searchView = (SearchView) MenuItemCompat.getActionView(item);
        }

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint(getResources().getString(R.string.search_hint));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
        }

        return true;
    }

    private static class RecycleViewTouchListener implements RecyclerView.OnItemTouchListener {
        private Context mContext;
        private GestureDetector mGestureDetector;
        private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

        public RecycleViewTouchListener(Context c, final RecyclerView rv, RecyclerViewOnClickListenerHack rvoclh){
            mContext = c;
            mRecyclerViewOnClickListenerHack= rvoclh;

            mGestureDetector = new  GestureDetector(mContext,new GestureDetector.SimpleOnGestureListener(){

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    View cv = rv.findChildViewUnder(e.getX(), e.getY());

                    if(cv != null && mRecyclerViewOnClickListenerHack != null){
                        mRecyclerViewOnClickListenerHack.onClickListener(cv,
                                rv.getChildPosition(cv));
                    }
                    return true;
                }
            });
        }
        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            mGestureDetector.onTouchEvent(e);
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
}
