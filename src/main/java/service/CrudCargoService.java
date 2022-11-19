package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import Entidades.Cargo;
import repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private boolean isTrue;
	private Boolean system = true;
	private final CargoRepository cargoRepository;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
public void inicial(Scanner scanner) {
		
		while(system) {
			System.out.println("Qual acao de cargo deseja executar: ");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			
			int action = scanner.nextInt();
			
			switch(action) {
			
			case 1:
				salvar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
		
	}

public void salvar(Scanner scanner) {
	System.out.println("Descricao do Cargo: ");
	String descricao = scanner.next();
	
	List<Cargo> cargos = cargo (scanner);
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
}
