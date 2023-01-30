
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String age = request.getParameter("age");
        String responseMessage = request.getParameter("responseMessage");
        int ageValid;
        
        // Validation Check - Null
        if (age == null || age.equals("")) {
            responseMessage = "You must give your current age.";
            request.setAttribute("responseMessage", responseMessage);
            return;
        }
        // Validation Check - String
        // https://www.studytonight.com/java-examples/check-if-input-is-integer-in-java
        try {
            Integer.parseInt(age);
            // Valid
            ageValid = Integer.valueOf(age);
        }
        // Invalid
        catch (NumberFormatException e) {
            responseMessage = "You must enter a number.";
            request.setAttribute("responseMessage", responseMessage);
            return;
        }
        
        // Proccessed Correctly
        ageValid = ageValid + 1;
        responseMessage = "Your age next birthday will be " + ageValid;
        request.setAttribute("responseMessage", responseMessage);
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }

}
