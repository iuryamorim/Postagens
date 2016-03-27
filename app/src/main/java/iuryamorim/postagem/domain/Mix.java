package iuryamorim.postagem.domain;

import java.io.Serializable;

public class Mix implements Serializable{
    private String titulo;
    private int foto;

    public Mix() {
    }

    public Mix(String mTitulo, int mFoto) {
        titulo = mTitulo;
        foto = mFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
