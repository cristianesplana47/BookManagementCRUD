package servlet;

import dao.BookDAO;
import model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AddBookServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Book book = new Book();
        book.setTitle(req.getParameter("title"));
        book.setAuthor(req.getParameter("author"));
        book.setPrice(Double.parseDouble(req.getParameter("price")));

        try {
            new BookDAO().addBook(book);
            resp.sendRedirect("list");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
