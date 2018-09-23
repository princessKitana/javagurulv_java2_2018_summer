package mvc_temp.mvc;

import javax.servlet.http.HttpServletRequest;

public interface MVCController {

    MVCModel processGet(HttpServletRequest request);

    //MVCModel processPost(HttpServletRequest request);

}
