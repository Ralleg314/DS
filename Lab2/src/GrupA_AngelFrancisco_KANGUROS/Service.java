/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrupA_AngelFrancisco_KANGUROS;

import java.util.Date;

/**
 *
 * @author EVA-00
 */
public class Service {

    Worker w;
    Client c;
    Date d;

    public Service(Worker w, Client c) {
        this.w = w;
        this.c = c;
        this.d = new Date();
    }

    public Date getDate() {
        return d;
    }
}
