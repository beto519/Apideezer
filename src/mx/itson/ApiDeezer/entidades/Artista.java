/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.ApiDeezer.entidades;

import com.google.gson.annotations.SerializedName;
import java.net.URL;

/**
 *Esta clase define los datos generales de un artista.
 * nombre es un dato de tipo String.
 *id es un dato de tipo int.
 * imagenPequeña es un dato de tipo URL con la direccion a la imagen de un tamaño pequeño.
 * imagenMediana es un dato de tipo URL con la direccion a la imagen de un tamaño mediano.
 * numeroAlbumes es un  dato de tipo long que es la cantidad de album que contiene cierto artista.
 * fans es un dato de tipo long que es la cantidad de fans que cuenta cierto artista.
 * @author Carlos Soto Pacheco
 * @author Jesus Alberto Rivera Lopez
 * @author Raul Ernesto Molina Lizarraga
 * @author Sebastian Santana
 */
public class Artista {

    @SerializedName("name")
    private String nombre;
    private int id;
    @SerializedName("picture_small")
    private URL imagen_pequeña;
    @SerializedName("picture_medium")
    private URL imagenMediana;
    @SerializedName("nb_album")
    private long numeroAlbumes;
    @SerializedName("nb_fan")
    private long fans;

    /**
     * @return the imagenMediana
     */
    
    public URL getImagenMediana() {
        return imagenMediana;
    }

    /**
     * @param imagenMediana the imagenMediana to set
     */
    public void setImagenMediana(URL imagenMediana) {
        this.imagenMediana = imagenMediana;
    }

    /**
     * @return the fans
     */
    public long getFans() {
        return fans;
    }

    /**
     * @param fans the fans to set
     */
    public void setFans(long fans) {
        this.fans = fans;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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
     * @return the imagen_pequeña
     */
    public URL getImagen_pequeña() {
        return imagen_pequeña;
    }

    /**
     * @param imagen_pequeña the imagen_pequeña to set
     */
    public void setImagen_pequeña(URL imagen_pequeña) {
        this.imagen_pequeña = imagen_pequeña;
    }

    /**
     * @return the numeroAlbumes
     */
    public long getNumeroAlbumes() {
        return numeroAlbumes;
    }

    /**
     * @param numeroAlbumes the numeroAlbumes to set
     */
    public void setNumeroAlbumes(long numeroAlbumes) {
        this.numeroAlbumes = numeroAlbumes;
    }

}
