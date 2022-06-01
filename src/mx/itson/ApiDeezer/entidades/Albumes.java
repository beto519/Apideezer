/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.ApiDeezer.entidades;

import com.google.gson.annotations.SerializedName;
import java.net.URL;

/**
 * Esta clase serializa los nombres obtenidos desde la API de dezzer y define los objetos.
 * titulo de la cancion es un dato de tipo String.
 * numeroCanciones es un dato de tipo int.
 * imagen obtiene una URL con destino de la imagen.
 * artista obtiene datos generales de la clase Artista.
 * 
 * @author Carlos Soto Pacheco
 * @author Jesus Alberto Rivera Lopez
 * @author Raul Ernesto Molina Lizarraga
 * @author Sebastian Santana
 */
public class Albumes {

    private int id;
    @SerializedName("title")
    private String titulo;
    @SerializedName("nb_tracks")
    private int numeroCanciones;
    @SerializedName("cover")
    private URL imagen;
    @SerializedName("artist")
    private Artista artista;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the numeroCanciones
     */
    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    /**
     * @param numeroCanciones the numeroCanciones to set
     */
    public void setNumeroCanciones(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    /**
     * @return the imagen
     */
    public URL getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(URL imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the artista
     */
    public Artista getArtista() {
        return artista;
    }

    /**
     * @param artista the artista to set
     */
    public void setArtista(Artista artista) {
        this.artista = artista;
    }

}
