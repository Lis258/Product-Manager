package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void shouldSearchNameBook() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1,"Name1",1200,"Author1");
        Book book2 = new Book(1,"Name2",600,"Author2");
        Book book3 = new Book(1,"Name3",750,"Author3");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual=manager.searchBy("Name3");
        Product[] expected = new Product[]{book3};
        assertArrayEquals(expected, actual);
    }

}