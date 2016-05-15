/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brugerautorisation.transport.soap;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author kenzo
 */
public class Brugeraut implements ILogIn {

    /**
     * @param username
     * @param password
     * @return 
     */
    @Override
    public boolean login(String username, String password) {
        try {
            URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
            QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
            Service service = Service.create(url, qname);
            System.out.println(service);
            Brugeradmin ba = service.getPort(Brugeradmin.class);
            Bruger b = ba.hentBruger(username, password);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    } 
    
    
}
