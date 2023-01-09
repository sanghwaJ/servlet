package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {
    // ControllerV1과 같지만, 반환을 MyView로 처리함
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
