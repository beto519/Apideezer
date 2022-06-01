/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.ApiDeezer.entidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Esta clase es donde se llama al metodo de deserializar los datos obtenidos, desde la API hacia una lista, donde se almacenan las canciones.
 *
 * @author Carlos Soto Pacheco
 * @author Jesus Alberto Rivera Lopez
 * @author Raul Ernesto Molina Lizarraga
 * @author Sebastian Santana
 */
public class ContenedorCanciones {

    @SerializedName("data")
    private List<CancionesAlbum> canciones;

    /**
     * @return the canciones
     */
    public List<CancionesAlbum> getCanciones() {
        return canciones;
    }

    /**
     * @param canciones the canciones to set
     */
    public void setCanciones(List<CancionesAlbum> canciones) {
        this.canciones = canciones;
    }

    /**
     *
     * @param idAlbum recibe un dato de tipo int donde su funcion es ser el dato que se buscara para obtener cierto album.
     * @return canciones que se almacena en el contendorCanciones en una lista.
     * @throws Exception se espera una excepcion.
     */
    public static ContenedorCanciones buscarCanciones(int idAlbum) throws Exception {

        String link = "https://api.deezer.com/album/" + idAlbum + "/tracks";

        /**
         * Esto es lo que vamos a devolver.
         */
        StringBuilder resultado = new StringBuilder();

        /**
         * Crear un objeto de tipo URL.
         */
        URL url;
        try {
            url = new URL(link);

            /**
             * Abrir la conexión e indicar que será de tipo GET.
             */
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
           
            /**
             *Búferes para leer.
             */
            BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
     
            /**
             * Mientras el BufferedReader se pueda leer, agregar contenido a resultado.
             */
            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
            }
        
            /**
             *Cerrar el BufferedReader.
             */
            rd.close();
        } catch (MalformedURLException ex) {

        }
        String cadena = resultado.toString();

        try {
            Gson gson = new GsonBuilder().create();
            ContenedorCanciones canciones = gson.fromJson(cadena, ContenedorCanciones.class);

            return canciones;
        } catch (Exception e) {
        }
        return null;
    }

}
