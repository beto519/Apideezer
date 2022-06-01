/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.ApiDeezer.entidades;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import itson.mx.ApiDeezer.utilerias.RetrofitUtil;
import mx.itson.ApiDeezer.vistas.Principal;

/**
 *Esta clase es donde se llama al metodo de deserializar los datos obtenidos desde la API hacia una lista, donde se almacenan los artistas.
 * 
* @author Carlos Soto Pacheco
 * @author Jesus Alberto Rivera Lopez
 * @author Raul Ernesto Molina Lizarraga
 * @author Sebastian Santana
 */
public class ContenedorArtista {

    @SerializedName("data")
    private List<Artista> resultados;
   
    /**
     * 
     * @param buscar recibe un dato de tipo String donde se realiza la busqueda del nombre seleccionado desde teclado.
     * 
     */
    public static void buscarArtista(String buscar) {
        
        
        Call<ContenedorArtista> llamada = RetrofitUtil.getBuscarArtista().getBuscarArtista(buscar);
        llamada.enqueue(new Callback<ContenedorArtista>() {
            @Override
            public void onResponse(Call<ContenedorArtista> call, Response<ContenedorArtista> rspns) {

                if (rspns.isSuccessful()) {
                    ContenedorArtista o = rspns.body();
                    Principal.llenarResultados(o);

                }
            }

            @Override
            public void onFailure(Call<ContenedorArtista> call, Throwable thrwbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }
    
   
    

    /**
     * @return the resultados
     */
    public List<Artista> getResultados() {
        return resultados;
    }

    /**
     * @param resultados the resultados to set
     */
    public void setResultados(List<Artista> resultados) {
        this.resultados = resultados;
    }


}
