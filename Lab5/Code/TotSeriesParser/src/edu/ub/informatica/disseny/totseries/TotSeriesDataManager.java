package edu.ub.informatica.disseny.totseries;

import edu.ub.informatica.disseny.model.Dades;
import java.util.ArrayList;

/**
 * Data manager per TotSeries. Crea les estructures de dades necessàries 
 * per a manegar l'aplicació de gestió de TotSeries.
 * 
 */
public class TotSeriesDataManager {
    
    private static TotSeriesDataManager instance = null;
    Dades data;
    /* -------------------------------------------------------------------
     * Metodes a implementar per vosaltres. En aquests metodes creareu els
     * vostres objectes a partir de la informacio obtinguda del fitxer XML
     * 
     * Podeu esborrar els prints si voleu. Tambe podeu canviar el tipus de
     * dades que retorna el metode, es a dir que sou lliures de
     * modificar-ho al gust, excepte les crides inicials que es fan.
     * -------------------------------------------------------------------
     */
    
    private TotSeriesDataManager(){
        data=Dades.getInstance();
        this.obtenirDades("data/TotSeries.xml");
    }
    
    /**
     *
     * @return
     */
    public static TotSeriesDataManager getInstance(){
        if(instance==null){
            instance=new TotSeriesDataManager();
        }
        return instance;
    }
    /**
     * Obté les dades del fitxer XML passat per paràmetre
     * 
     * @param nomFitxer ruta del fitxer XML del que obtenir les dades
     */
    public void obtenirDades(String nomFitxer) {
            TotSeriesXMLParser parser = new TotSeriesXMLParser(this);
            parser.parse(nomFitxer);
    }

    /**
     * Crea una nova serie a partir de la informacio obtinguda del fitxer XML
     * 
     * @param id id de la serie. El podeu utilitzar o no
     * @param title títol de la serie
     * @param desc descripcio de la serie
     */

    public void crearSerie(String id, String title, String desc) {		

            /*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
             *  d'una nova serie.
             */
            data.crearSerie(id,title,desc);
    }

    /**
     * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
     * 
     * @param numTemporada numero de la temporada
     * @param numEpisodis numero d'episodis
     * @param i
     * 
     */

    public void crearTemporada(String numTemporada, String numEpisodis, int i) {		

            /*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
             *  d'una nova temporada.
             */
            data.crearTemporada(numTemporada, numEpisodis, i);
    }

    /**
     * Crea una nova temporada a partir de la informacio obtinguda del fitxer XML
     * 
     * @param title titol de lepisodi
     * @param duration duració de l'episodi
     * @param idioma idioma de l'episodi V.O.
     * @param description sinopsi de l'episodi
     * @param data data d'estrena de l'episodi
     * @param i
     * @param j
     * 
     */

    public void crearEpisodi(String title, String duration, String idioma, String description, String data, int i, int j) {		

            /*  TODO: A partir d'aqui creeu el vostre objecte que contingui la informacio
             *  d'una nou episodi.
             */
            this.data.crearEpisodi(title,duration,idioma,description,data,i,j);

    }

    /**
     * Crea un nou artista a partir de la informacio obtinguda del fitxer XML
     * 
     * @param id id del artista. El podeu utilitzar o no
     * @param nom nom del artista
     * @param tipus tipus (director\actor) del artista
     * @param idSerie serie a la qual treballa. El podeu utilitzar o no
     * @param nacionalitat 
     */

    public void crearArtista(String id, String nom, String tipus, String idSerie, String nacionalitat) {

            /* TODO: Aqui feu el necessari per a crear els artistes per a la serie
             */
            data.afegirArtista(tipus, id, nom, idSerie, nacionalitat);
    }


    /**
     * Crea productora del fitxer XML
     * 
     * @param id id de la productora
     * @param nom nom de la productora
     * @param idSerie id de la serie que va fer. El podeu utilitzar o no
     */
    public void crearProductora (String id, String nom, String idSerie) {

            /* TODO: Aqui feu el necessari per a crear les productores per a les series
             */
            data.afegirProductora(id, nom, idSerie);
    }

    /**
     * Crea una valoracio a partir de la informacio obtinguda del fitxer XML
     * 
     * @param id id de la valoracio. El podeu utilitzar o no
     * @param client identificador del client. El podeu utilitzar o no
     * @param episodi identificador de la serie. El podeu utilitzar o no
     * @param puntuacio puntuacio donada al episodi
     * @param data data en la que es va fer la puntuacio
     */

    public void crearValoracio(String id, String client, String episodi, String puntuacio, String data) {

            /* TODO: A partir d'aqui creeu la valoracio
             */
    }

    /**
     * Crea un nou admin a partir de la informacio obtinguda del fitxer XML
     * 
     * @param id id del administrador
     * @param nom nom del administrador
     * @param usuari usuari del administrador
     * @param password password del administrador
     */
    public void crearAdmin(String id, String nom, String usuari, String password) {

            /* TODO: Creeu aqui el vostre admin
             */
            data.afegirAdmin(id,nom, usuari, password);
    }

    /**
     * Crea un nou client a partir de la informacio obtinguda del fitxer XML
     * 
     * @param nom nom del client
     * @param dni dni del client
     * @param adreca adreça del client
     * @param usuari usuari al sistema del client
     * @param password password del client
     * @param vip true si el client es vip. false si no
      */

    public void crearClient(String nom, String dni, String adreca, String usuari, String password, String vip) {

            /* TODO: Creeu aqui el vostre client
             */
            data.registrarUsuari(nom, dni, adreca,usuari, password, vip);

    }
    
    /**
     *
     * @param nom
     * @param dni
     * @param adreca
     * @param usuari
     * @param password
     */
    public void crearClient(String nom, String dni, String adreca, String usuari, String password) {

            /* TODO: Creeu aqui el vostre client
             */
            data.registrarUsuari(nom, dni, adreca,usuari, password);

    }
    
    /**
     *
     * @param s
     * @param t
     * @param ep
     */
    public void reproduirEpisodi(int s, int t, int ep){
        if("PENDENT".equals(data.getEstat(s, t, ep))){
            this.data.reproduirEpisodi(s, t, ep);
            data.omplirVists();
        }
    }

    /**
     *
     * @param serie
     * @param temporada
     * @param episodi
     * @param valoracio
     */
    public void valorarEpisodi(int serie, int temporada, int episodi, int valoracio) {
        this.data.valorarEpisodi(serie, temporada, episodi, valoracio);
        data.omplirValorats();
    }

    /**
     *
     * @param serie
     * @param temporada
     * @param episodi
     * @return
     */
    public String getEstat(int serie, int temporada, int episodi) {
        return data.getEstat(serie, temporada, episodi);
    }

    /**
     *
     * @return 
     */
    public ArrayList<String> mostratCataleg() {
        return data.visualitzarCataleg();
    }
    
    /**
     *
     * @param s
     * @return 
     */
    public ArrayList<String> mostratTemporades(int s) {
        return data.visualitzarTemporades(s);
    }
    
    /**
     *
     * @param s
     * @param t
     * @return
     */
    public ArrayList<String> mostratEpisodis(int s, int t) {
        return data.visualitzarEpisodis(s,t);
    }
    public ArrayList<String> mostrarValorats(){
        return data.visualitzarValorats();
    }
    public ArrayList<String> mostrarVists(){
        return data.visualitzarVists();
    }
    /**
     *
     * @return
     */
    public boolean userIsLoged() {
        return data.getLogedUser()!="";
    }
}
