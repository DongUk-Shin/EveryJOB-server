package sch.EveryJOB.common.exception;

import lombok.Getter;
import sch.EveryJOB.common.error.ErrorCodeIfs;

@Getter
public class CustomException extends RuntimeException {
    
    private final ErrorCodeIfs errorCodeIfs;
    private final String errorDescription;
    
    public CustomException(ErrorCodeIfs errorCodeIfs){
        super(errorCodeIfs.getErrorDescription());
        this.errorCodeIfs = errorCodeIfs;
        this.errorDescription = errorCodeIfs.getErrorDescription();
    }
    
}
