package pl.bykowski.springbootjdbc;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Route
public class BookAdder extends VerticalLayout {

    private BookDao bookDao;

    @Autowired
    public BookAdder(BookDao bookDao) {
        TextField textFieldId = new TextField("Id");
        TextField textFieldTitle = new TextField("Title");
        TextField textFieldAuthor = new TextField("Author");
        DatePicker datePicker = new DatePicker("Publish date");
        Button button = new Button("add book");

        button.addClickListener(clickEvent -> {
            Book book = new Book();
            book.setId(Long.parseLong(textFieldId.getValue()));
            book.setTitle(textFieldTitle.getValue());
            book.setAuthor(textFieldAuthor.getValue());
            book.setYear(datePicker.getValue());
            bookDao.save(book);

            Notification notification = new Notification("Book added!", 3000);
            notification.open();
        });

        add(textFieldId, textFieldTitle, textFieldAuthor, datePicker, button);
    }
}
