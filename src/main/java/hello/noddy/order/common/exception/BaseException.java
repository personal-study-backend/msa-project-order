package hello.noddy.order.common.exception;

import hello.noddy.order.common.response.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BaseException extends RuntimeException {

  private ErrorCode errorCode;

  public BaseException(ErrorCode errorCode) {
    super(errorCode.getErrorMsg());
    this.errorCode = errorCode;
  }

  public BaseException(String message, ErrorCode errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  public BaseException(String message, ErrorCode errorCode, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }
}
