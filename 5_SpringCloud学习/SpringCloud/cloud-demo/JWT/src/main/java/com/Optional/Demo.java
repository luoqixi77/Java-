package com.Optional;

import com.Stream.entity.Author;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo {
    public static void main(String[] args) {

        Optional<Author> authorOptional = getAuthorOptional();
        Optional<Author> author = testFilter();
//        Author author = authorOptional.orElseGet(() -> new Author());
        author.ifPresent(author1 -> System.out.println(author1.getName()));

   /*     Author author = getAuthor();
        Optional<Author> optionalAuthor = Optional.ofNullable(author);
        optionalAuthor.ifPresent(author1 -> System.out.println(author1.getName()));*/

//        Optional<Author> authorOptional = getAuthorOptional();
//        authorOptional.ifPresent(author -> System.out.println(author));


    }

    private static Optional<Author> testFilter() {
        Optional<Author> authorOptional = getAuthorOptional();
        return authorOptional.filter(author -> author.getAge()>17);
    }


    public static Optional<Author> getAuthorOptional() {
        Author author = new Author(3L, "洛天依", 18, "洛水河畔，与你相依", null);
        return Optional.ofNullable(author);
    }

    public static Author getAuthor() {
        Author author = new Author(3L, "洛天依", 18, "洛水河畔，与你相依", null);
        return author;
    }

}