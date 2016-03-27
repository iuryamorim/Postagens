package iuryamorim.postagem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.List;

import iuryamorim.postagem.R;
import iuryamorim.postagem.VideoActivity;
import iuryamorim.postagem.domain.Video;
import iuryamorim.postagem.fragments.FragmentVideosRel;
import iuryamorim.postagem.interfaces.RecyclerViewOnClickListenerHack;

public class VideoRelAdapter extends RecyclerView.Adapter<VideoRelAdapter.MyViewHolder> {
    private List<Video> mList;
    public static List<Video> mListAux;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;
    private int tamanho = 10;

    public VideoRelAdapter(Context c, List<Video> l) {
        mList = VideoActivity.mListAux;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_video_rel, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        tamanho = 10;
        int pos = VideoActivity.click;
        String[] tagPosition = mList.get(pos).getTags().split(",");
        int cont = 0, conta, c2 = 0;
        while (c2 < 10) {
            String[] auxPosition = mList.get(cont).getTags().split(",");
            conta = 0;
            for (int i = 0; i < 4; i++) {
                String a = tagPosition[0];
                String b = auxPosition[i];
                if (a.equals(b)) {
                    if (cont != pos) {
                        conta++;
                    }
                }
            }
            if (conta != 0) {
                Video v = new Video(mList.get(cont).getTitulo(), mList.get(cont).getDescricao(), mList.get(cont).getUrl(), mList.get(cont).getFoto());
                mListAux.add(v);

            }
            cont++;
            c2++;
        }
        tamanho = mListAux.size();
        holder.titleCardVideo.setText(mListAux.get(position).getTitulo());
        holder.fotoCardVideo.setImageResource(mListAux.get(position).getFoto());
        holder.descricaoCardVideo.setText(mListAux.get(position).getDescricao());

        YoYo.with(Techniques.Landing).duration(700).playOn(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return tamanho;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView fotoCardVideo;
        public TextView titleCardVideo, descricaoCardVideo;

        public MyViewHolder(View itemView) {
            super(itemView);

            mListAux = new ArrayList<>();

            fotoCardVideo = (ImageView) itemView.findViewById(R.id.fotoCardVideoRel);
            titleCardVideo = (TextView) itemView.findViewById(R.id.titleCardVideoRel);
            descricaoCardVideo = (TextView) itemView.findViewById(R.id.descricaoCardVideoRel);

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
