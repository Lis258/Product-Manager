package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void shouldRemoveById() {
        ProductRepository repository = new ProductRepository();
        Product book1 = new Book(1, "BookName1", 1200, "Author1");
        Product book2 = new Book(2, "BookName2", 600, "Author2");
        repository.save(book1);
        repository.save(book2);
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }
}