package com.job.portal.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.repo.TokenRepo;
import com.job.portal.services.TokenService;

import com.job.portal.model.Token;
import com.job.portal.model.User;

@Service
public class TokenImplementation implements TokenService {
    @Autowired
    private TokenRepo repo;

    @Override
    public String getToken() {
        List<Token> ls = this.repo.findAll();
        return ls.get(ls.size() - 1).getToken();
    }

    @Override
    public User getUser(String username) {
        User ur = new User();
        // if(ur.getPassword().equals(pass)) return ur;
        User us = this.repo.findCustomQuery(username).get(0);
        // ur.setFname(us.getFname());
        // ur.setLname(us.getLname());
        // ur.setEmail(us.getEmail());
        // ur.setPhone(us.getPhone());
        // ur.setUserRoles(us.getUserRoles());
        // ur.setUsername(us.getUsername());
        us.setPassword("");
        // ur.setEnabled("");
        return us;
    }

    @Override
    public String insertToken(String token) {
        Token tk = new Token(token);
        repo.save(tk);
        return tk.getToken();
    }

}
