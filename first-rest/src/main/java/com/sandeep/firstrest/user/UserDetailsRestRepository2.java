package com.sandeep.firstrest.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDetailsRestRepository2 extends PagingAndSortingRepository<UserDetail, Long> {

}
