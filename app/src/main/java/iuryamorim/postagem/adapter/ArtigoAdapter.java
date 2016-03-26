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

import java.util.List;

import iuryamorim.postagem.R;
import iuryamorim.postagem.domain.Artigo;
import iuryamorim.postagem.interfaces.RecyclerViewOnClickListenerHack;

public class ArtigoAdapter extends RecyclerView.Adapter<ArtigoAdapter.MyViewHolder> {
    private List<Artigo> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public ArtigoAdapter(){

    }
    public ArtigoAdapter(Context c, List<Artigo> l) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_artigo, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.fotoCardArtigo.setImageResource(mList.get(position).getFoto());
        holder.titleCardArtigo.setText(mList.get(position).getTitulo());
        holder.subTitleCardArtigo.setText(mList.get(position).getSubTitulo());

        YoYo.with(Techniques.Landing).duration(700).playOn(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView fotoCardArtigo;
        public TextView titleCardArtigo, subTitleCardArtigo;

        public MyViewHolder(View itemView) {
            super(itemView);

            fotoCardArtigo = (ImageView) itemView.findViewById(R.id.fotoCardArtigo);
            titleCardArtigo = (TextView) itemView.findViewById(R.id.titleCardArtigo);
            subTitleCardArtigo = (TextView) itemView.findViewById(R.id.subTitleCardArtigo);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mRecyclerViewOnClickListenerHack != null){
                mRecyclerViewOnClickListenerHack.onClickListener(view, getPosition());
            }
        }
    }
}
