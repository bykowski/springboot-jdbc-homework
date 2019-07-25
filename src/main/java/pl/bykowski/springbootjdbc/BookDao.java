package pl.bykowski.springbootjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public class BookDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Book book) {
        String sql = "INSERT INTO books VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getYear());
    }

    public Book read(long id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, id);

        Book book = new Book();
        for (Map<String, Object> map : maps) {
            book.setId((Long) map.get("id"));
            book.setAuthor(map.get("author").toString());
            book.setTitle(map.get("title").toString());
            book.setYear(LocalDate.parse(map.get("year").toString()));
        }
        return book;
    }

    // todo
    // pobieranie wszystkich elementow
    // update elementow
    // usuwanie elementow
}
