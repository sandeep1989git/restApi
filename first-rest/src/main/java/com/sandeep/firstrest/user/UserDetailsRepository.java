package com.sandeep.firstrest.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetail, Long> {

}
