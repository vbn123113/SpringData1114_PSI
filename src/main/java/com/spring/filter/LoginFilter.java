package com.spring.filter;

import com.spring.mvc.psi.entities.User;
import com.spring.mvc.psi.repository.UserRepository;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@WebFilter("/mvc/*")
public class LoginFilter extends BaseFilter {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String username = "vincent";
        User user = userRepository.getByName(username);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            chain.doFilter(req, res);
        } else {
            res.getWriter().print("No User !!!");
        }
        chain.doFilter(req, res);
    }

}