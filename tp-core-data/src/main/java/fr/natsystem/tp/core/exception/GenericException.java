package fr.natsystem.tp.core.exception;

public class GenericException extends Exception {
	private static final long serialVersionUID = 2222751414636375617L;
	
	private String errorCode;
    private String origin;
    private String detail;
    
    public GenericException(String errorCode, String origin, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.origin = origin;
        this.detail = "Une erreur technique a eu lieu : Veuillez contacter le support.";
    }
    
    public GenericException(String messageCode, String origin, String message, Object[] paramMessage) {
        super(message);
        initializeException(messageCode, origin, paramMessage);
    }
    
    public GenericException(String messageCode, String origin, String message, Throwable cause, Object[] paramMessage) {
        super(message, cause);
        initializeException(messageCode, origin, paramMessage);

    }
    
    private void initializeException(String messageCode, String origin, Object[] paramMessage) {
        this.errorCode = messageCode;
        this.origin = origin;
        String detailMsg = errorCode;
        this.detail = detailMsg;
    }
    

    public String getErrorCode() {
        return errorCode;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDetail() {
        return detail;
    }
    
}
