package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
// 프록시를 안쓰면 이렇게 코드가 길어짐
//    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider;
//    @RequestMapping("log-demo")
//    @ResponseBody
//    public String logDemo(HttpServletRequest request) {
//        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();
//        myLogger.setRequestURL(requestURL);
//        myLogger.log("controller test");
//        logDemoService.logic("testId");
//        return "OK";
//    }
}

