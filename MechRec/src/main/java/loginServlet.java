package rbharatr_CSCI201_RecMech;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/**
 * Servlet implementation class LoginValidation
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * Default constructor. 
     */
    public loginServlet() {
        // TODO Auto-generated constructor stub
        
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//      doGet(request, response);
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //Check for 
        if(username == null || password == null) {
            request.setAttribute("errorMessage", "Fields cannot be blank");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            return;
        } else if(username.equals("")|| password.equals("")) {
              request.setAttribute("errorMessage", "Invalid user or password");
              request.getRequestDispatcher("Login.jsp").forward(request, response);
              return;
        } else if(!isUsernameValid(username)) {
            request.setAttribute("errorMessage", "Invalid Username");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            return;
        }
        
        try {
            Connection con = DBConnection.initializeDataBase();
            PreparedStatement st = con.prepareStatement("SELECT email,userID,hashPass,saltHashPass MechRec.Users WHERE (username=?)");
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            String resUsername = "", resEmail = "", resHashPass = "", resSaltHashPass = "";
            while(rs.next()) {
                
                resUsername = rs.getString("userId");
                resEmail = rs.getString("email");
                resHashPass = rs.getString("hashPass");
                resSaltHashPass = rs.getString("saltHashPass");
                
            }
            if(resHashPass.equals(password)) {
                HttpSession sesh = request.getSession();
                sesh.setAttribute("username", resUsername);
                System.out.println("Session created for " + username);
            }else {
                request.setAttribute("errorMessage", "Incorrect email and or password");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                return;
            }
            st.close();
            con.close();
        }catch(Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage","somethign happened on our end");
            return;
        }
        
        request.setAttribute("errorMessage", "logged in");
        request.getRequestDispatcher("MainPage.jsp").forward(request, response);
        
        
    }
    
    private boolean isUsernameValid(String email) {
        return email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }
 
}