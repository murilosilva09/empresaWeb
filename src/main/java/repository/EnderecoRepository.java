package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Entidades.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository <Endereco, Integer>{

} 
