package pl.bykowski.springbootjdbc;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route
public class BookReader extends VerticalLayout {

    private BookDao bookDao;

    @Autowired
    public BookReader(BookDao bookDao) {
        TextField textFieldId = new TextField("Give id:");
        Button button = new Button("show book");
        Label label = new Label();

        button.addClickListener(clickEvent -> {
            Book book = bookDao.read(Long.parseLong(textFieldId.getValue()));
            label.setText(book.toString());
        });

        add(textFieldId, button, label);
    }
}
