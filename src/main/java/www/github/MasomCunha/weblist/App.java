package www.github.MasomCunha.weblist;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import www.github.MasomCunha.weblist.persistence.dao.jpa.EntityManagerUtil;
import www.github.MasomCunha.weblist.persistence.models.List;
import www.github.MasomCunha.weblist.persistence.models.User;

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
        EntityManager em = EntityManagerUtil.getEm();
        User user = new User();
        user.setFullName("Fonseca");
        em.getTransaction().begin();
        User pUser = em.merge(user);
        em.getTransaction().commit();

        List list = new List();
        list.setOwner(pUser);
        list.setListName("compras");
        em.getTransaction().begin();
        pUser.addToLists(list);
        em.merge(pUser);
        em.getTransaction().commit();

        List list2 = new List();
        list2.setOwner(pUser);
        list2.setListName("veterinário");
        em.getTransaction().begin();
        pUser.addToLists(list2);
        em.merge(pUser);
        em.getTransaction().commit();


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
