package Tandon.Instagram.repository;

import Tandon.Instagram.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post,Integer> {
}
