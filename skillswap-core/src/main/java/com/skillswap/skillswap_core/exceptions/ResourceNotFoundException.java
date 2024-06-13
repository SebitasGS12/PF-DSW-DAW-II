package com.skillswap.skillswap_core.exceptions;

import com.skillswap.skillswap_core.constants.CodigoError;

public class ResourceNotFoundException  extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private CodigoError errorCode;  

    public ResourceNotFoundException(String message) {
        super(message);
        errorCode = CodigoError.NOT_FOUND;
    }

    public CodigoError getErrorCode() {
        return errorCode;
    }
}