package iuryamorim.postagem.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Video implements Serializable {
    private String titulo;
    private String descricao;
    private String url;
    private int foto;
    private int position;
    private String tags;

    public Video(){}
    public Video(String mTitulo, String mDescricao, String mUrl, int mFoto, String mTags, int mPosition){
        titulo = mTitulo;
        descricao = mDescricao;
        url = mUrl;
        foto = mFoto;
        tags = mTags;
        position = mPosition;
    }
    public Video(String mTitulo, String mDescricao, String mUrl, int mFoto){
        titulo = mTitulo;
        descricao = mDescricao;
        url = mUrl;
        foto = mFoto;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
