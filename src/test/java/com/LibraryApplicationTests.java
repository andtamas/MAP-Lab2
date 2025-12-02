package com;

import com.example.Library.LibraryApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LibraryApplication.class) // <-- SPECIFICAȚI EXPLICIT CLASA
class LibraryApplicationTests {

    @Test
    void contextLoads() {
    }

}