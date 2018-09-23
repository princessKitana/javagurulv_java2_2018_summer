package mvc_temp.mvc;

import javax.servlet.http.HttpServletRequest;

//@Component
public class UserController implements MVCController{

        @Override
        public MVCModel processGet(HttpServletRequest request) {
            return new MVCModel("/user.jsp", "Mughjfhjchga!");
        }
}
