package kz.college.user.mapper;


import kz.college.user.entity.UserEntity;
import kz.college.user.model.User;
import org.mapstruct.*;

/**
 * Mapper that convert UserEntity
 */
@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface UserMapper {

    UserEntity toEntity(User user);

    User toModel(UserEntity user);

    void toUpdateEntity(@MappingTarget UserEntity entity, User model);

}
