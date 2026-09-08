package dev.brunopablo.smartlocck.exception;

import org.springframework.http.ProblemDetail;

public class NotAuthorizedException extends SmartStockException{

    private final String detail;

    public NotAuthorizedException(String detail) {
        super(detail);
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        
        var pd = ProblemDetail.forStatus(401);

        pd.setTitle("Unauthorized");

        pd.setDetail(detail);

        return pd;
    }
}