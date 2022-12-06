package com.driver.services;

import com.driver.models.Book;
import com.driver.models.Card;
import com.driver.models.Transaction;
import com.driver.models.TransactionStatus;
import com.driver.repositories.BookRepository;
import com.driver.repositories.CardRepository;
import com.driver.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    BookRepository bookRepository5;

    @Autowired
    CardRepository cardRepository5;

    @Autowired
    TransactionRepository transactionRepository5;

    @Value("${books.max_allowed}")
    public int max_allowed_books;

    @Value("${books.max_allowed_days}")
    public int getMax_allowed_days;

    @Value("${books.fine.per_day}")
    public int fine_per_day;

    public String issueBook(int cardId, int bookId) throws Exception {
        //check whether bookId and cardId already exist
//        if(!bookRepository5.findById(bookId).isPresent()){
//            throw new Exception("Book is either unavailable or not present");
//        }
//        if(!cardRepository5.findById(cardId).isPresent()){
//            throw new Exception("Card is invalid");
//        }
//        Card card1 = cardRepository5.getOne(cardId);
//        Book book1 = bookRepository5.getOne(bookId);
//        if(!(card1.getBooks().size()<max_allowed_books)){
//            throw new Exception("Book limit has reached for this card");
//        }
//        Transaction transaction = new Transaction();
//        transactionRepository5.save(transaction);
//        List<Book> b = card1.getBooks();
//        b.add(book1);
//        card1.setBooks(b);


        //conditions required for successful transaction of issue book:
        //1. book is present and available
        // If it fails: throw new Exception("Book is either unavailable or not present");
        //2. card is present and activated
        // If it fails: throw new Exception("Card is invalid");
        //3. number of books issued against the card is strictly less than max_allowed_books
        // If it fails: throw new Exception("Book limit has reached for this card");
        //If the transaction is successful, save the transaction to the list of transactions and return the id

        //Note that the error message should match exactly in all cases

       return null; //return transactionId instead
    }

    public Transaction returnBook(int cardId, int bookId) throws Exception{

        List<Transaction> transactions = transactionRepository5.find(cardId, bookId, TransactionStatus.SUCCESSFUL, true);
        Transaction transaction = transactions.get(transactions.size() - 1);

        //for the given transaction calculate the fine amount considering the book has been returned exactly when this function is called
        //make the book available for other users
        //make a new transaction for return book which contains the fine amount as well
//        Card card1 = cardRepository5.getOne(cardId);
//        Book book1 = bookRepository5.getOne(bookId);
//        int fine = 0;

        Transaction returnBookTransaction  = null;
//        returnBookTransaction = new Transaction(card1,book1,fine);
        return returnBookTransaction; //return the transaction after updating all details
    }
}
