package org.joshpeters.learning.infrastructure
import groovy.util.logging.Slf4j
import org.joshpeters.learning.domain.ProblemDetail
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver
import org.springframework.web.util.NestedServletException

import javax.servlet.http.HttpServletRequest

@ControllerAdvice
@Slf4j
class ErrorHandler extends ExceptionHandlerExceptionResolver {
  @ExceptionHandler([RuntimeException, Error])
  ResponseEntity<ProblemDetail> handle(HttpServletRequest request, Exception ex) {
    log.error('an error occurred', ex)
    Throwable throwable = (ex instanceof NestedServletException) ? ex.cause : ex
    new ResponseEntity(
      new ProblemDetail(
        type: throwable?.class,
        title: throwable?.cause ? throwable?.cause?.message : throwable?.message,
        detail: throwable?.message,
        instance: request.pathInfo
      ),
      HttpStatus.INTERNAL_SERVER_ERROR
    )
  }
}
