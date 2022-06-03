package noncom.nickz.carpartsdemo.exception;

public class DuplicateRequestException extends RuntimeException {

  public DuplicateRequestException(String message) {
    super(message);
  }
}
