package com.job.portal.services;

import com.job.portal.model.User;

public interface TokenService {
    String insertToken(String token);
    String getToken();
    User getUser(String uname);
}
