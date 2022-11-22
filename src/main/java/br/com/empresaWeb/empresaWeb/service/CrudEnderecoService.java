package br.com.empresaWeb.empresaWeb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.empresaWeb.empresaWeb.entidades.Cargo;
import br.com.empresaWeb.empresaWeb.entidades.Endereco;
import br.com.empresaWeb.empresaWeb.repository.EnderecoRepository;

@Service
public class CrudEnderecoService {

	private boolean isTrue;
	private Boolean system = true;
	private EnderecoRepository enderecoRepository;

	public CrudEnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("Qual acao do Endereco voce deseja executar: ");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");

			int action = scanner.nextInt();

			switch (action) {

			case 1:
				salvar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}

	}

	private void salvar(Scanner scanner) {
		// TODO Auto-generated method stub

		System.out.println("Digite o logradouro: ");
		String logradouro = scanner.next();
		
		System.out.println("Digite o numero: ");
		int numero = scanner.nextInt();
		
		System.out.println ("Digite o bairro: ");
		String bairro = scanner.next();
		
		System.out.println ("Digite sua cidade: ");
		String cidade = scanner.next();
		
		System.out.println ("Digite seu estado: ");
		String estado = scanner.next();
		
		List<Endereco> enderecos = endereco(scanner);
		Endereco endereco = new Endereco();

		endereco.setLogradouro(logradouro);
		enderecoRepository.save(endereco);
		System.out.println("Salvo!");
	}

	private List<Endereco> endereco(Scanner scanner) {
		setTrue(true);
		List<Endereco> enderecos = new ArrayList<>();
		return enderecos;
	}

	public boolean isTrue() {
		return isTrue;
	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}
}
