import java.util.Scanner;
import CPU.Cpu;

public class Main {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		Cpu cpu = new Cpu();
		boolean closed = false;

		menu();

		while (!closed) {
			System.out.print("> ");
			int p = s.nextInt();
			switch (p) {
				case 1:
					cpu.execP1();
					menu();
					break;
				case 2:
					cpu.execP2();
					menu();
					break;
				case 3:
					cpu.execP3();
					menu();
					break;
				case 4:
					cpu.execP4();
					menu();
					break;
				case 5:
					cpu.memoriaToString();
					menu();
					break;
				case 6:
					closed = true;
					break;
				default:
					System.err.print("Programa não encontrado!\n");
			}
			s.nextLine();
		}
		s.close();
	}
	
	//CRIAR NOVOS limpar memoria(todas paginas), limpar pagina(só uma pagina), ao selecionar o programa descobrir em qual frame de qual pagina botar(e retornar)
	private static void menu() {
		System.out.println("=========THE ULTIMATE VIRTUAL MACHINE==========");
		System.out.println("|Escolha um dos programas abaixo:             |");
		System.out.println("|1 = fibonacci-10                             |");
		System.out.println("|2 = fibonacci-n                              |");
		System.out.println("|3 = fatorial                                 |");
		System.out.println("|4 = bubblesort                               |");
		System.out.println("|5 = mostrar memoria                          |");
		System.out.println("|6 = sair                                     |");
		System.out.println("=========THE ULTIMATE VIRTUAL MACHINE==========");
	}
}