package iuryamorim.postagem.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import iuryamorim.postagem.MainActivity;
import iuryamorim.postagem.R;
import iuryamorim.postagem.domain.Video;
import iuryamorim.postagem.interfaces.RecyclerViewOnClickListenerHack;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {
    private List<Video> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public VideoAdapter(Context c, List<Video> l) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_video, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.titleCardVideo.setText(mList.get(position).getTitulo());
        holder.fotoCardVideo.setImageResource(mList.get(position).getFoto());
        holder.descricaoCardVideo.setText(mList.get(position).getDescricao());

        YoYo.with(Techniques.Landing).duration(700).playOn(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView fotoCardVideo;
        public TextView titleCardVideo, descricaoCardVideo;

        public MyViewHolder(View itemView) {
            super(itemView);

            fotoCardVideo = (ImageView) itemView.findViewById(R.id.fotoCardVideo);
            titleCardVideo = (TextView) itemView.findViewById(R.id.titleCardVideo);
            descricaoCardVideo = (TextView) itemView.findViewById(R.id.descricaoCardVideo);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mRecyclerViewOnClickListenerHack != null) {
                mRecyclerViewOnClickListenerHack.onClickListener(view, getPosition());
            }
        }
    }
}
