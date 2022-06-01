/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.ApiDeezer.entidades;

import com.google.gson.annotations.SerializedName;
import java.net.URL;

/**
 *Esta clase define los datos generales de las canciones de un cierto album.
 * titulo es un dato de tipo String .
 * duracion es un dato de tipo int que almacena la cantidad de duracion de cierta cancion.
 * link es un dato de tipo URL.
 * artista es un dato de tipo Artista que contiene los datos generales de un artista.
 * 
* @author Carlos Soto Pacheco
 * @author Jesus Alberto Rivera Lopez
 * @author Raul Ernesto Molina Lizarraga
 * @author Sebastian Santana
 */
public class CancionesAlbum {

    @SerializedName("title")
    private String titulo;
    @SerializedName("duration")
    private int duracion;
    private URL link;
    @SerializedName("artist")
    private Artista artista;
    
    
    
    
    

    
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
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the link
     */
    public URL getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(URL link) {
        this.link = link;
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
