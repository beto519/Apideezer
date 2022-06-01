/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itson.mx.ApiDeezer.utilerias;
import itson.mx.ApiDeezer.interfaces.DezeerAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Esta clase define dos metodos, en uno se obtiene el artista y en el otro los albums.
 * @author Carlos Soto Pacheco
 * @author Jesus Alberto Rivera Lopez
 * @author Raul Ernesto Molina Lizarraga
 * @author Sebastian Santana
 */
public class RetrofitUtil {
    /**
     * Metodo getBuscarArtista() que obtiene los datos desde una URL.
     * 
     */
   
     public static DezeerAPI getBuscarArtista(){
    
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.deezer.com/search/artist/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(DezeerAPI.class);
    
    }
     /**
      * Metodo getBuscarAlbum() que obtiene los datos desde una URL.
      * 
      */
      public static DezeerAPI getBuscarAlbum(){
    
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.deezer.com/search/album/")
                
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(DezeerAPI.class);
    
    }
}
