package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Entidades.Cargo;

@Repository
public interface cargoRepository extends CrudRepository <Cargo, Integer>{

}
