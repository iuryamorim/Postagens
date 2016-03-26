package iuryamorim.postagem.domain;

import java.io.Serializable;
import java.util.Date;

public class Artigo implements Serializable {
    private String titulo;
    private String subTitulo;
    private String texto;
    private int foto;

    public Artigo() {
    }

    public Artigo(String mTitulo, String mSubTitulo, String mTexto, int mFoto) {
        titulo = mTitulo;
        subTitulo = mSubTitulo;
        texto = mTexto;
        foto = mFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
