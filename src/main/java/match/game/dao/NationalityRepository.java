package match.game.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import match.game.entities.Nationality;


@Repository
public interface NationalityRepository extends JpaRepository<Nationality, Integer> {

}
