package com.assigment.chat.service.user;

import com.assigment.chat.model.User;
import com.assigment.chat.protocol.registration.RegistrationForm;
import com.assigment.chat.protocol.user.UserChatDto;
import com.assigment.chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("User not found :" + login));
    }

    @Override
    public UserChatDto getUserChatDtoByLogin(String login) {
        User user = getUserByLogin(login);
        return UserChatDto.builder()
                .idUser(user.getIdUser())
                .name(user.getName())
                .build();
    }

    @Override
    public Boolean loginIsExists(String login) {
        return userRepository.findByLogin(login).isPresent();
    }

    @Override
    public void createUser(RegistrationForm registrationForm) {
        userRepository.save(
                User.builder()
                        .name(registrationForm.getName())
                        .login(registrationForm.getLogin())
                        .password(passwordEncoder.encode(registrationForm.getPassword()))
                .build()
        );
    }
}
