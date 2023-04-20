import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class test extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
        toClient.println(Utils.header("Product"));
        toClient.println("<table border='1'>");

        Vector<ProductDataMockup> productList = ProductDataMockup.getProductList();
        ProductDataMockup product = productList.elementAt(2);
        toClient.println("Product id: " + product.productId + "<\n>");
        toClient.println("Name: " + product.productName + "<\n>");
        toClient.println("Supplier: " + product.supplierId + "<\n>");
        toClient.println("Company name: " + product.companyName + "<\n>");
        toClient.println("Price: " + product.unitPrice);
        
        toClient.println("</table>");
        toClient.println(Utils.footer("Product"));
        toClient.close();
    }
}