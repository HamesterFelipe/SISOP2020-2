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
					cpu.encerraProcesso();
					menu();
					break;
				case 7:
					cpu.mostraProgramas();
					menu();
					break;
				case 8:
					cpu.executaProg();
					menu();
					break;
				case 9:
					closed = true;
					break;
				default:
					System.err.print("Opção não encontrado!\n");
			}
			s.nextLine();
		}
		s.close();
	}
	
	//CRIAR NOVOS limpar memoria(todas paginas), limpar pagina(só uma pagina), ao selecionar o programa descobrir em qual frame de qual pagina botar(e retornar)
	private static void menu() {
		System.out.println("=========THE ULTIMATE VIRTUAL MACHINE==========");
		System.out.println("|Escolha uma das programas abaixo:             |");
		System.out.println("|1 = Fibonacci-10                              |");
		System.out.println("|2 = Fibonacci-n                               |");
		System.out.println("|3 = Fatorial                                  |");
		System.out.println("|4 = Bubblesort                                |");
		System.out.println("|5 = Mostrar memoria                           |");
		System.out.println("|6 = Encerrar programa                         |");
		System.out.println("|7 = Listar programas em memoria               |");
		System.out.println("|8 = Sair                                      |");
		System.out.println("=========THE ULTIMATE VIRTUAL MACHINE==========");
	}
}