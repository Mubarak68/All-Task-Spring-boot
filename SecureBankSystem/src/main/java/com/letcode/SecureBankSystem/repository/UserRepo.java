package com.letcode.SecureBankSystem.repository;


import com.letcode.SecureBankSystem.entity.UserEntity;
import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> , Optional<UserEntity>{
    void findByUsername(String username);
}
