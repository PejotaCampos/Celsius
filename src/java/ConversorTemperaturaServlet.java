import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conversor;
/**
 *
 * @author Pedro
 */
@WebServlet(urlPatterns = {"/converter"})
public class ConversorTemperaturaServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       response.setContentType("text/html;charset=UTF-8");
       Conversor conversor = new Conversor();
       request.setAttribute("texto", conversor.converter(Double.parseDouble(request.getParameter("valor")), request.getParameter("selecionado") ));
       
       request.getRequestDispatcher("respostajsp.jsp").forward(request, response);
       
    }
}