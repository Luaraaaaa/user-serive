package kz.college.user.service;

import kz.college.user.entity.UserEntity;
import kz.college.user.mapper.UserMapper;
import kz.college.user.model.User;
import kz.college.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User service
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private static final String USER_NOT_FOUND = "User not found";
    private static final String USER_NOT_VALID = "User first name is missing";

    private final UserRepository repository;
    private final UserMapper mapper;

    @Transactional
    public User saveUser(User user) {
        user.setId(null);
        if (StringUtils.isBlank(user.getFirstName()))
            throw new IllegalArgumentException(USER_NOT_VALID);
        UserEntity entity = mapper.toEntity(user);
        repository.save(entity);
        return mapper.toModel(entity);
    }

    @Transactional
    public User updateUser(String id, User user) {
        user.setId(null);
        UserEntity entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND));
        mapper.toUpdateEntity(entity, user);
        repository.save(entity);
        return mapper.toModel(entity);
    }

    @Transactional
    public void deleteUser(String id) {
        repository.deleteById(id);
    }

    public User getUser(String id) {
        UserEntity entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND));
        return mapper.toModel(entity);
    }

    public List<User> getUsers() {
        List<UserEntity> entities = repository.findAll();
        return entities.stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

}
