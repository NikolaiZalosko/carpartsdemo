package noncom.nickz.carpartsdemo.error;

import noncom.nickz.carpartsdemo.exception.DuplicateRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(DuplicateRequestException.class)
  public ResponseEntity<Object> handleDuplicateRequestException(DuplicateRequestException ex, WebRequest request) {
    return handleExceptionInternal(ex, HttpStatus.BAD_REQUEST);
  }

  private ResponseEntity<Object> handleExceptionInternal(Exception ex, HttpStatus status) {
    return new ResponseEntity<>(ErrorResponse.builder()
        .error(ex.getMessage())
        .build(), status);
  }
}
