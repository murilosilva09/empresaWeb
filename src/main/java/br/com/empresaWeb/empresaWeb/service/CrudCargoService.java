package br.com.empresaWeb.empresaWeb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.empresaWeb.empresaWeb.entidades.Cargo;
import br.com.empresaWeb.empresaWeb.repository.CargoRepository;

@Service
public class CrudCargoService {

	private final CargoRepository cargoRepository;
	private boolean isTrue;
	private Boolean system = true;
	

	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("Qual acao de cargo deseja executar: ");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar cargo novo");
			System.out.println("2 - Visualizar cargos registrados");
			System.out.println("3 - Atualizar cargo existente atraves do ID");
			System.out.println("4 - Deletar cargo existente atraves do ID");

			int action = scanner.nextInt();

			switch (action) {

			case 1:
				salvar(scanner);
				break;
			case 2:
				visualizar();
				break;
			case 3:
				atualizar(scanner);
				break;
			case 4:
				deletar(scanner);
			default:
				system = false;
				break;
			}
		}

	}

	public void salvar(Scanner scanner) {
		System.out.println("Descricao do Cargo: ");
		String descricao = scanner.next();

		List<Cargo> cargos = cargo(scanner);
		Cargo cargo = new Cargo();

		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo!");
	}

	private List<Cargo> cargo(Scanner scanner) {
		setTrue(true);
		List<Cargo> cargos = new ArrayList<>();
		return cargos;
	}

	public boolean isTrue() {
		return isTrue;
	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	public void atualizar(Scanner scanner) {
		System.out.println("Digite o cargoId");
	    Integer cargoId = scanner.nextInt();
	    
	    System.out.println("Digite o novo cargo: ");
	    String cargonov = scanner.next();
	    
	    Cargo cargonovo = new Cargo();
	    
	    cargonovo.setId(cargoId);
	    cargonovo.setDescricao(cargonov);
	    
	    Optional<Cargo> cargo = cargoRepository.findById(cargoId);
	    
	    cargoRepository.save(cargonovo);
	    System.out.println("Alterado");
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Digite o Id para deletar: ");
		int id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Deletado");
	}
	
}
