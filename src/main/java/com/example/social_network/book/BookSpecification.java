package com.example.social_network.book;

import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<Book> withOwnerId(Integer ownerId) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("user").get("id"), ownerId));
    }
}
