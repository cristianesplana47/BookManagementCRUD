package dao;

import model.Book;
import util.DBConnection;
import java.sql.*;
import java.util.*;

public class BookDAO {

    public void addBook(Book book) throws Exception {
        String sql = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.executeUpdate();
        }
    }

    public List<Book> getAllBooks() throws Exception {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getDouble("price"));
                list.add(b);
            }
        }
        return list;
    }

    public Book getBookById(int id) throws Exception {
        String sql = "SELECT * FROM books WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Book b = new Book();
                b.setId(id);
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getDouble("price"));
                return b;
            }
        }
        return null;
    }

    public void updateBook(Book book) throws Exception {
        String sql = "UPDATE books SET title=?, author=?, price=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getId());
            ps.executeUpdate();
        }
    }

    public void deleteBook(int id) throws Exception {
        String sql = "DELETE FROM books WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
