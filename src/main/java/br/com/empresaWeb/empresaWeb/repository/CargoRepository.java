package br.com.empresaWeb.empresaWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.empresaWeb.empresaWeb.entidades.Cargo;

@Repository
public interface CargoRepository extends CrudRepository <Cargo, Integer>{

}
