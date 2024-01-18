package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.component.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
