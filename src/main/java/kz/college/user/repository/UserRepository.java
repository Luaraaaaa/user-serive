package kz.college.user.repository;

import kz.college.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is the JPA repository for {@link UserEntity}
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
