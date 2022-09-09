package com.assigment.chat.service.user;

import com.assigment.chat.model.User;
import com.assigment.chat.protocol.registration.RegistrationForm;
import com.assigment.chat.protocol.user.UserChatDto;

public interface UserService {
    UserChatDto getUserChatDtoByLogin(String login);

    User getUserByLogin(String login);

    Boolean loginIsExists(String login);

    void createUser(RegistrationForm registrationForm);
}
