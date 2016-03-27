package iuryamorim.postagem.adapter;

import android.content.Context;
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
import iuryamorim.postagem.domain.Mix;
import iuryamorim.postagem.interfaces.RecyclerViewOnClickListenerHack;

public class MixAdapter extends RecyclerView.Adapter<MixAdapter.MyViewHolder> {
    private List<Mix> mList;
    private LayoutInflater mLayoutInflater;
    private RecyclerViewOnClickListenerHack mRecyclerViewOnClickListenerHack;

    public MixAdapter(){

    }
    public MixAdapter(Context c, List<Mix> l) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_mix, parent, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.fotoCardMix.setImageResource(mList.get(position).getFoto());
        holder.titleCardMix.setText(mList.get(position).getTitulo());
        //holder.subTitleCardMix.setText(mList.get(position).getSubTitulo());

        YoYo.with(Techniques.Landing).duration(700).playOn(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView fotoCardMix;
        public TextView titleCardMix, subTitleCardMix;

        public MyViewHolder(View itemView) {
            super(itemView);

            fotoCardMix = (ImageView) itemView.findViewById(R.id.fotoCardMix);
            titleCardMix = (TextView) itemView.findViewById(R.id.titleCardMix);
           // subTitleCardMix = (TextView) itemView.findViewById(R.id.subTitleCardMix);

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
