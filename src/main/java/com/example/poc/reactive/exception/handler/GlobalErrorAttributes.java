//package com.example.poc.reactive.exception.handler;
//
//import org.springframework.boot.web.error.ErrorAttributeOptions;
//import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
//import org.springframework.context.annotation.Primary;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.server.ServerRequest;
//
//import java.util.Map;
//
///**
// * @author Pramosh Shrestha
// * @created 08/07/2023: 13:07
// */
//@Primary
//@Component
//public class GlobalErrorAttributes extends DefaultErrorAttributes {
//
//    @Override
//    public Map<String, Object> getErrorAttributes(ServerRequest request,
//                                                  ErrorAttributeOptions options) {
//        Map<String, Object> map = super.getErrorAttributes(
//                request, options);
//
//        Throwable error = getError(request);
//
//        map.put("status", HttpStatus.BAD_REQUEST);
//        map.put("message", error.getMessage());
//        return map;
//    }
//}
