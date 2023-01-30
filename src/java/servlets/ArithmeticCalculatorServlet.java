
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ArithmeticAnswer = "----";
        request.setAttribute("ArithmeticAnswer", ArithmeticAnswer);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String operation = request.getParameter("operation");
        
        int firstValid;
        int lastValid;
        String ArithmeticAnswer;
        
        // Validation Check - Null
        if (first == null || first.equals("") || last == null || last.equals("")) {
            ArithmeticAnswer = "invalid";
            request.setAttribute("ArithmeticAnswer", ArithmeticAnswer);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
        // Validation Check - String
        try {
            Integer.parseInt(first);
            // Valid
            firstValid = Integer.valueOf(first);
        }
        // Invalid
        catch (NumberFormatException e) {
            ArithmeticAnswer = "invalid";
            request.setAttribute("ArithmeticAnswer", ArithmeticAnswer);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
        try {
            Integer.parseInt(last);
            // Valid
            lastValid = Integer.valueOf(last);
        }
        // Invalid
        catch (NumberFormatException e) {
            ArithmeticAnswer = "invalid";
            request.setAttribute("ArithmeticAnswer", ArithmeticAnswer);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
        
        // Proccessed Correctly
        switch (operation) {
            case "+": 
                ArithmeticAnswer = Integer.toString(firstValid + lastValid);
                break;
            case "-": 
                ArithmeticAnswer = Integer.toString(firstValid - lastValid);
                break;
            case "*": 
                ArithmeticAnswer = Integer.toString(firstValid * lastValid);
                break;
            case "%": 
                ArithmeticAnswer = Integer.toString(firstValid % lastValid);
                break;
            default:
                ArithmeticAnswer = "invalid";
        }
        request.setAttribute("ArithmeticAnswer", ArithmeticAnswer);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

}
