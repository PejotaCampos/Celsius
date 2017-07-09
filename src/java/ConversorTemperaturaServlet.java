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
    
    private final static String ERROR = "<html><h1 id=\\\"error\\\">Aconteceu um erro, por favor tente novamente apenas com números.</h1></html>";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       response.setContentType("text/html;charset=UTF-8");
       Conversor conversor = new Conversor();
       
       try{
            request.setAttribute("texto", conversor.converter(Double.parseDouble(request.getParameter("valor")), request.getParameter("selecionado") ));
            request.getRequestDispatcher("respostajsp.jsp").forward(request, response);
       }catch(NumberFormatException  e) {
            response.getWriter().print(ERROR);
       }
    }
}