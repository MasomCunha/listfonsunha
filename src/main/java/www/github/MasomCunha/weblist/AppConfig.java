package www.github.MasomCunha.weblist;

import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {

    public AppConfig() {

        packages("www.github.MasomCunha.weblist.controllers");

    }

}
