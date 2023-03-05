package Tandon.Instagram.repository;

import Tandon.Instagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
