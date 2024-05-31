package com.skillswap.skillswap_core.exceptions;

import com.skillswap.skillswap_core.transacciones.Logger;

public class GenericErrorException extends RuntimeException {

    private static final Logger LOG = Logger.getLogger(GenericErrorException.class);

    public GenericErrorException(String msg) {
        super(msg);
        LOG.error(msg);
    }

}
