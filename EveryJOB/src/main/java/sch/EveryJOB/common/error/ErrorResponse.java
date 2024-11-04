package sch.EveryJOB.common.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class ErrorResponse {
    
    private int status;
    private String error;
    
}

