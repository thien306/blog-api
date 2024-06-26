package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {

    Optional<Blog> findById(Long id);

    @Query(value = "SELECT * FROM blog join category c on category_id = c.id where c.name like %:name%",nativeQuery = true)
    List<Blog> findAllByCategory(@Param("name") String name);

}
