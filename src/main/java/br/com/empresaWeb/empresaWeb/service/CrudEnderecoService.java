package br.com.empresaWeb.empresaWeb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
			System.out.println("1 - Salvar endereco novo");
			System.out.println("2 - Visualizar Enderecos registrados");
			System.out.println("3 - Atualizar Endereco existente atraves do ID");
			System.out.println("4 - Deletar Endereco existente atraves do ID");

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
				break;
			default:
				system = false;
				break;

			}

		}

	}


	private void salvar(Scanner scanner) {

		System.out.println("Digite o logradouro: ");
		String logradouro = scanner.next();

		System.out.println("Digite o numero: ");
		int numero = scanner.nextInt();

		System.out.println("Digite o bairro: ");
		String bairro = scanner.next();

		System.out.println("Digite sua cidade: ");
		String cidade = scanner.next();

		System.out.println("Digite seu estado: ");
		String estado = scanner.next();

		endereco(scanner);
		Endereco endereco = new Endereco();

		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);

		enderecoRepository.save(endereco);
		System.out.println("Salvo!");
	}

	private List<Endereco> endereco(Scanner scanner) {
		setTrue(true);
		List<Endereco> enderecos = new ArrayList<>();
		return enderecos;
	}

	public void isTrue() {
		this.isTrue();

	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}

	private void visualizar() {
		Iterable<Endereco> enderecos = enderecoRepository.findAll();
		enderecos.forEach(endereco -> System.out.println(endereco));
	}

	public void atualizar(Scanner scanner) {
		System.out.println("Digite o EnderecoId");
		Integer enderecoId = scanner.nextInt();

		System.out.println("digite um logradouro: ");
		String logradouro = scanner.next();

		System.out.println("digit o numero: ");
		int numero = scanner.nextInt();

		System.out.println("digite um bairro: ");
		String bairro = scanner.next();

		System.out.println("digite a Cidade: ");
		String cidade = scanner.next();

		System.out.println("digite o estado ");
		String estado = scanner.next();

		Endereco endereconovo = new Endereco();

		endereconovo.setId(enderecoId);
		endereconovo.setLogradouro(logradouro);
		endereconovo.setNumero(numero);
		endereconovo.setBairro(bairro);
		endereconovo.setCidade(cidade);
		endereconovo.setEstado(estado);

		enderecoRepository.findById(enderecoId);

		enderecoRepository.save(endereconovo);
		System.out.println("Alterado");
	}
	
	
	private void deletar(Scanner scanner) {
		System.out.println("Digite o Id para deletar: ");
		int id = scanner.nextInt();
		enderecoRepository.deleteById(id);
		System.out.println("Deletado");
	}
}
