package br.com.empresaWeb.empresaWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.empresaWeb.empresaWeb.entidades.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository <Endereco, Integer>{

} 
