package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "BookName1", 1200, "Author1");
    Product book2 = new Book(2, "BookName2", 600, "Author2");
    Product book3 = new Book(3, "BookName3", 750, "Author3");
    Product book4 = new Book(4, "BookName4", 900, "Author3");
    Product smartphone1 = new Smartphone(5, "SmartphoneName1", 25000, "Manufacturer1");
    Product smartphone2 = new Smartphone(6, "SmartphoneName2", 33000, "Manufacturer2");
    Product smartphone3 = new Smartphone(7, "SmartphoneName3", 57000, "Manufacturer3");
    Product smartphone4 = new Smartphone(8, "SmartphoneName4", 72000, "Manufacturer2");

    @BeforeEach
    public void addProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
    }

    @Test
    void shouldSearchBookName() {
        Product[] actual = manager.searchBy("BookName3");
        Product[] expected = new Product[]{book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchAuthorName() {
        Product[] actual = manager.searchBy("Author2");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneName() {
        Product[] actual = manager.searchBy("SmartphoneName1");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneManufacturer() {
        Product[] actual = manager.searchBy("Manufacturer3");
        Product[] expected = new Product[]{smartphone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSameAuthorName() {
        Product[] actual = manager.searchBy("Author3");
        Product[] expected = new Product[]{book3, book4};
        assertArrayEquals(expected, actual);
    }


}