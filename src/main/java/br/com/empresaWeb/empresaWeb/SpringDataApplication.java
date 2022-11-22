package br.com.empresaWeb.empresaWeb;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.empresaWeb.empresaWeb.service.CrudCargoService;


@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

<<<<<<< HEAD
	private final CrudCargoService cargoService;
	
=======
	private    CrudCargoService cargoService;

>>>>>>> refs/remotes/origin/desenvolvimento
	private boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual acao voce quer execustar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Endereco");

			int action = scanner.nextInt();

			if (action == 1) {
				cargoService.inicial(scanner);
			}
			if (action == 2) {
				
			}
			else {
				system = false;
		}

	}

}
	
}