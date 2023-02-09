package kg.ecomm.kelso.service.book;

import kg.ecomm.kelso.repository.book.BookRepository;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BookMiddleware {
    private final BookRepository bookRepository;

    public BookMiddleware(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public String getNewBookCode(){

        String randomStr = Integer
                .toString(ThreadLocalRandom
                        .current().nextInt(100000, 999999));
        List<String> allBookCode = bookRepository.findAllCode();
        for (int i = 0; i < allBookCode.size(); i++){
            if (randomStr.equals(allBookCode.get(i))){
                return getNewBookCode();
            }
        }

        return randomStr;
    }
}
