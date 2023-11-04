package dev.vivek.rest_hateos_app.bindings;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
@Data
@AllArgsConstructor
public class Book extends RepresentationModel<Book>{
    private String isbn;
    private String name;
    private String author;
    private Double price;

}
