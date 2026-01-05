package servlet;

import dao.BookDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class DeleteBookServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            new BookDAO().deleteBook(id);
            resp.sendRedirect("list");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
