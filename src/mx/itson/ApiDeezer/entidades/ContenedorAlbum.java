/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.ApiDeezer.entidades;

import com.google.gson.annotations.SerializedName;
import itson.mx.ApiDeezer.utilerias.RetrofitUtil;
import java.util.List;
import mx.itson.ApiDeezer.vistas.Principal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Esta clase es donde se llama al metodo de deserializar los datos obtenidos desde la API hacia una lista, donde se almacenan los album.
 * 
* @author Carlos Soto Pacheco
 * @author Jesus Alberto Rivera Lopez
 * @author Raul Ernesto Molina Lizarraga
 * @author Sebastian Santana
 */
public class ContenedorAlbum {

    @SerializedName("data")
    private List<Albumes> listaAlbumes;

    /**
     * @return the listaAlbumes
     */
    public List<Albumes> getListaAlbumes() {
        return listaAlbumes;
    }

    /**
     * @param listaAlbumes the listaAlbumes to set
     */
    public void setListaAlbumes(List<Albumes> listaAlbumes) {
        this.listaAlbumes = listaAlbumes;
    }
/**
 * 
 * @param artista recibe un dato String colocado desde un label.
 * el dato colocado desde el teclado se agrega al link de la llamada de la API para obtener los artistas con sus albums.
 * 
 */
    public static void buscarAlbumes(String artista) {
       
        
        String q="artist:\""+artista+"\"";
        Call<ContenedorAlbum> llamada = RetrofitUtil.getBuscarAlbum().getBuscarAlbum(q);

        llamada.enqueue(new Callback<ContenedorAlbum>() {
            @Override
            public void onResponse(Call<ContenedorAlbum> call, Response<ContenedorAlbum> rspns) {

                if (rspns.isSuccessful()) {
                    ContenedorAlbum o = rspns.body();
                   Principal.llenarTablaAlbumes(o);

                }
            }

            @Override
            public void onFailure(Call<ContenedorAlbum> call, Throwable thrwbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

   

  

}
