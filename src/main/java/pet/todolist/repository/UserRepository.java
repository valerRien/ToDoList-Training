package pet.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pet.todolist.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
