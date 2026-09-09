package dev.brunopablo.smartlocck.exception;

import org.springframework.http.ProblemDetail;

public abstract class SmartStockException extends RuntimeException{

    public SmartStockException(String message) {
        super(message);
    }

    public ProblemDetail toProblemDetail(){
        
        var pd = ProblemDetail.forStatus(500);

        pd.setTitle("Internal Server Error!");

        pd.setDetail("Please Contact The Support Team!");

        return pd;
    }
}