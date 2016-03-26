package iuryamorim.postagem;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appinvite.AppInviteInvitation;

import iuryamorim.postagem.domain.Artigo;

public class ArtigoActivity extends AppCompatActivity {
    private Artigo artigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){
            artigo = getIntent().getExtras().getParcelable("artigo");
        }else {
            artigo = savedInstanceState.getParcelable("artigo");
        }

        setContentView(R.layout.activity_artigo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        artigo = (Artigo) getIntent().getExtras().getSerializable("artigo");

        ImageView fotoCardArtigo = (ImageView) findViewById(R.id.fotoCardArtigo);
        TextView titleCardArtigo = (TextView) findViewById(R.id.titleCardArtigo);
        TextView subTitleCardArtigo = (TextView) findViewById(R.id.subTitleCardArtigo);
        TextView textoCardArtigo = (TextView) findViewById(R.id.textoCardArtigo);

        titleCardArtigo.setText(artigo.getTitulo());
        fotoCardArtigo.setImageResource(artigo.getFoto());
        subTitleCardArtigo.setText(artigo.getSubTitulo());
        textoCardArtigo.setText(artigo.getTexto());

       // getSupportActionBar().setTitle(titleCardArtigo.getText().toString());

        Button comp = (Button) findViewById(R.id.compartilhar);
    }

    public void compartilhar(View v){
        inviteCall();
    }

    private  void inviteCall(){
        Intent intent = new AppInviteInvitation.IntentBuilder("Postagem")
                .setMessage("Veja as nossa postagem!")
                .setDeepLink(Uri.parse(artigo.getSubTitulo() + "/" + artigo.getTitulo()))
                .build();
       // startActivity(intent);

        startActivityForResult(intent, MainActivity.REQUEST_INVITE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MainActivity.REQUEST_INVITE){
            if (resultCode == RESULT_OK){
                String ids[] = AppInviteInvitation.getInvitationIds(resultCode,data);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
}
