package edu.leo.common.exception;

public class SSHSampleException extends Exception {

    private static final long serialVersionUID = -398022476830388739L;

    private String errorCd;

    public SSHSampleException(String message) {
        super(message);
    }

    public SSHSampleException(String errorCd, String message) {
        super(message);
        this.errorCd = errorCd;
    }

    public String getErrorCd() {
        return errorCd;
    }
}
