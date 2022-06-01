/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itson.mx.ApiDeezer.interfaces;

import mx.itson.ApiDeezer.entidades.ContenedorAlbum;
import mx.itson.ApiDeezer.entidades.ContenedorArtista;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Esta interface define dos llamadas, una para la busqueda de los artistas y
 * otra para los albumes.
 *
 * @author Carlos Soto Pacheco
 * @author Jesus Alberto Rivera Lopez
 * @author Raul Ernesto Molina Lizarraga
 * @author Sebastian Santana
 */
public interface DezeerAPI {

    //Busca Artistas
    /**
     *
     * @param artista recibe un dato de tipo String que sirve para buscar los
     * Artistas.
     *
     */
    @GET("Artist")
    Call<ContenedorArtista> getBuscarArtista(@Query("q") String artista);

    /**
     *
     * @param artista recibe un dato de tipo String que sirve para buscar los
     * albumes.
     */
    @GET("Album")
    Call<ContenedorAlbum> getBuscarAlbum(@Query("q") String artista);

}
