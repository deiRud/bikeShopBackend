import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;

@WebServlet("/api/*")
public class JerseyServlet extends ServletContainer {
    @Override
    public void init() throws ServletException {
        super.init();
    }
}
