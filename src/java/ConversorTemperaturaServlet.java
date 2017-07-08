import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
       String[] selecionado = request.getParameterValues("selecionado");
       double temperatura = Double.parseDouble(request.getParameter("valor"));;
       double resposta;
       String texto;
       if(selecionado[0].equalsIgnoreCase("celsiusToFahrenheit")){
            resposta = (temperatura*9/5)+32;
            texto = ""+temperatura+  " Celsius = "+resposta+ " Fahrenheit.";
        }
        else{
            resposta = ((temperatura - 32.0)*5)/9;
            texto = ""+temperatura+  " Fahrenheit = "+resposta+ " Celsius.";
            }
       
       try (PrintWriter out = response.getWriter()) {
       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+texto+" </h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}