package pers.qingyu.snowslide.sql.semantic;

import pers.qingyu.snowslide.exception.FastsqlException;

public class SemanticException extends FastsqlException  {
    public SemanticException(String message) {
        super(message);
    }
}
