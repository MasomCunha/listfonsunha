package www.github.MasomCunha.weblist;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import www.github.MasomCunha.weblist.persistence.dao.jpa.EntityManagerUtil;
import www.github.MasomCunha.weblist.persistence.dao.jpa.JpaListDao;
import www.github.MasomCunha.weblist.persistence.dao.jpa.JpaUserDao;
import www.github.MasomCunha.weblist.persistence.models.jpa.List;
import www.github.MasomCunha.weblist.persistence.models.jpa.User;
import www.github.MasomCunha.weblist.services.ListServiceImp;
import www.github.MasomCunha.weblist.services.UserServiceImp;

import javax.persistence.EntityManager;
import java.sql.SQLException;

import static org.h2.tools.Server.createWebServer;

public class App {

    private static final int SERVER_PORT = 8080;
    private static final String CONTEXT_PATH = "/";
    private static final String SPECIFIC_PATH = "/api/*";
    private static final String H2_PORT = "8081";

    public static void main(String[] args) throws SQLException {
        startH2Server();
        Server server = new Server(SERVER_PORT);
        server.setHandler(getJerseyHandler());
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            server.destroy();
        }
    }

    private static void startH2Server() throws SQLException{
        createWebServer(new String[]{"-web", "-webAllowOthers", "-webPort", H2_PORT}).start();
        EntityManagerUtil.getEm();

        populateDB();
    }

    private static void populateDB() {

        UserServiceImp usi = new UserServiceImp();
        ListServiceImp lsi = new ListServiceImp();

        usi.setListService(lsi);
        lsi.setUserServiceImp(usi);

        usi.createUser("Fonseca");
        usi.createUser("Manel");
        usi.createUser("Marcia");
        usi.createUser("Juliana");

        usi.getUsers().forEach(user -> System.out.println(user.toString()));

        lsi.createList("compras", 3);

        usi.getUsers().forEach(user -> System.out.println(user.toString()));

        usi.deleteUser(1);
        usi.getUsers().forEach(user -> System.out.println(user.toString()));

        lsi.removeList(5);
        usi.getUsers().forEach(user -> System.out.println(user.toString()));

        lsi.createList("compras1", 3);
        lsi.createList("compras2", 3);
        lsi.createList("compras3", 3);
        lsi.createList("compras4", 3);
        lsi.createList("compras5", 3);

        System.out.println(usi.getUser(3));

    }

    private static Handler getJerseyHandler() {
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath(CONTEXT_PATH);

        ServletHolder servletHolder = handler.addServlet(ServletContainer.class, SPECIFIC_PATH);
        servletHolder.setInitOrder(1);
        servletHolder.setInitParameter("javax.ws.rs.Application", "www.github.MasomCunha.weblist.AppConfig");
        return handler;
    }
}
