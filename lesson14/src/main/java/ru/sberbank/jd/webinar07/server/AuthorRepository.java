package ru.sberbank.jd.webinar07.server;

import java.util.HashMap;

public class AuthorRepository {

    private HashMap<Integer, Author> map = new HashMap<>();

    public Author create(Author author) {
        int size = map.size() + 1;
        author.setId(size);

        map.put(size, author);
        return author;
    }
}
