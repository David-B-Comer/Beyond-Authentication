package com.okta.examples.jpa.BeyondAuthentication;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {

    List<UserEvent> findByName(String name);
    List<UserEvent> findByToken(String token);
    List<UserEvent> findByUserId(String userId);
}