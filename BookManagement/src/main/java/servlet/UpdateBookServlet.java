package servlet;

import dao.BookDAO;
import model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class UpdateBookServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("book", new BookDAO().getBookById(id));
            req.getRequestDispatcher("updateBook.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Book b = new Book();
            b.setId(Integer.parseInt(req.getParameter("id")));
            b.setTitle(req.getParameter("title"));
            b.setAuthor(req.getParameter("author"));
            b.setPrice(Double.parseDouble(req.getParameter("price")));

            new BookDAO().updateBook(b);
            resp.sendRedirect("list");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
