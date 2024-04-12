package org.fullstack4.chap01.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CookieUtil {

    public Cookie getCookie(String name, String value, String path, int time) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        cookie.setMaxAge(time);
        return cookie;
    }

    public String readCookie(HttpServletRequest req) {

        Cookie[] cookies = req.getCookies();
        String cookieId= "고객";

        for(Cookie c : cookies){
            String name =c.getName();
            String value = c.getValue();
            if(name.equals("user_id")){
                cookieId = value;
            }
        }
        return cookieId;
    }
}

