package com.example.social_network.history;

import com.example.social_network.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionHistory, Integer> {

    @Query("""
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.user.id = :userId
            """)
    Page<BookTransactionHistory> findAllBorrowedBooks(Pageable pageable, int userId);

    @Query("""
            SELECT history
            FROM BookTransactionHistory history
            WHERE history.book.user.id = :userId
            """)
    Page<BookTransactionHistory> findAllReturnedBooks(Pageable pageable, int userId);

    @Query("""
            SELECT
            (COUNT(*) > 0) AS isBorrowed
            FROM BookTransactionHistory bookTransactionHistory
            WHERE bookTransactionHistory.user.id = :userId
            AND bookTransactionHistory.book.id = :bookId
            AND bookTransactionHistory.returnApproved = false
            """)
    boolean isAlreadyBorrowedByUser(Book bookId, int userId);

    @Query("""
            SELECT transaction
            FROM BookTransactionHistory transaction
            WHERE transaction.user.id = :userId
            AND transaction.returned = false
            AND transaction.returnApproved = false
            """)
    Optional<BookTransactionHistory> findByBookIdAndUserId(Integer bookId, int userId);

    @Query("""
            SELECT transaction
            FROM BookTransactionHistory  transaction
            WHERE transaction.book.user.id = :userId
            AND transaction.returned = true
            AND transaction.returnApproved = false
            """)
    Optional<BookTransactionHistory> findByBookIdAndOwnerId(Integer bookId, int userId);
}
