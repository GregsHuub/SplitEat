//package pl.gregsApp.GlobalExceptionHandler;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    private static Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody
//    public String handleRuntimeException(RuntimeException e){
//        LOG.error(e.getMessage());
//        return e.getMessage();
//    }
//}

