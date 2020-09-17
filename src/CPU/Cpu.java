package CPU;

import Programas.Programas;
import GM.Gm;
import java.util.Scanner;

public class Cpu {

	private static final int TAM = 1024;
	private static Palavra memoria[] = new Palavra[TAM];
	private static int[] registradores = new int[8];
	private static int progCount = 0;
	public static PCB[] processos = new PCB[64];
	public static Gm gm = new Gm();

	public Cpu() {}


	public void execP1() {
		Palavra p[] = new Programas().fibonacci10();
		alocaPrograma(p);
		memoriaToString();
	}

	public void execP2() {
		Palavra p[] = new Programas().fibonaccin();
		alocaPrograma(p);
		memoriaToString();
	}

	public void execP3() {
		Palavra p[] = new Programas().fatorial();
		alocaPrograma(p);
		memoriaToString();
	}

	public void execP4() {
		Palavra p[] = new Programas().bubblesort();
		alocaPrograma(p);
		memoriaToString();
	}


	private void leMemoria() {
		boolean stopped = false;

		while (!stopped) {
			if (progCount >= memoria.length)
				break;

			Palavra pos = memoria[progCount];
			switch (memoria[progCount].OPCode) {
				case "STOP":
					stopped = true;
					break;
				case "JMP":
					JMP(pos.num);
					break;
				case "JMPI":
					JMPI(pos.r1);
					break;
				case "JMPIG":
					JMPIG(pos.r1, pos.r2);
					break;
				case "JMPIL":
					JMPIL(pos.r1, pos.r2);
					break;
				case "JMPIE":
					JMPIE(pos.r1, pos.r2);
					break;
				case "ADDI":
					ADDI(pos.r1, pos.num);
					break;
				case "SUBI":
					SUBI(pos.r1, pos.num);
					break;
				case "LDI":
					LDI(pos.r1, pos.num);
					break;
				case "LDD":
					LDD(pos.r1, pos.num);
					break;
				case "STD":
					STD(pos.num, pos.r2);
					break;
				case "ADD":
					ADD(pos.r1, pos.r2);
					break;
				case "SUB":
					SUB(pos.r1, pos.r2);
					break;
				case "MULT":
					MULT(pos.r1, pos.r2);
					break;
				case "LDX":
					LDX(pos.r1, pos.r2);
					break;
				case "STX":
					STX(pos.r1, pos.r2);
					break;
				case "SWAP":
					SWAP(pos.r1, pos.r2);
					break;
				default:
					System.err.println("Operacao invalida: " + pos.label);
					System.exit(1);
			}
			printRegistradores();
			progCount++;
		}
	}

	//aloca o programa chamado a partir do program counter(TEM QUE VERIFICAR SE TEM ESPAÇO)
	// private void carregaMemoria(Palavra[] p) {
	// 	for (int i = progCount; i < (progCount + p.length); i++) // Load program into memoria
	// 		memoria[i] = p[i];
	// 	leMemoria(); // Read loaded program
	// }

	private void carregaMemoria(Palavra[] p, int programInitialPosition, int memoryInitialPosition){
		for(int i=0; i < 16; i++){
			if(programInitialPosition == p.length - 1) break;
			memoria[memoryInitialPosition + i] = p[programInitialPosition];

			programInitialPosition++;
		}
	}

	private void alocaPrograma(Palavra[] p){
		int[] framesLivres = gm.getLivres();

		int tamanhoPrograma = p.length;
		int framesOcupados = tamanhoPrograma / 16;
		if(tamanhoPrograma%16 != 0) framesOcupados += 1;

		if(framesOcupados > framesLivres.length - 1){
			System.out.println("Não existe espaço disponível na memória");
			return;
		}

		int[] frames = new int[framesOcupados];

		//Percorre todos os frames que o programa deve ocupar, alocando ele:
	    for(int i = 0; i < framesOcupados ; i++){

			frames[i] = framesLivres[i];
			int programInitialPosition = 16 * i;
			int memoryInitialPosition = gm.alocar(framesLivres[i]);

			//Carrega Programa no Frame livre:
			carregaMemoria(p, programInitialPosition, memoryInitialPosition);
		}
		
		for(int j = 0; j< processos.length -1; j++){
			if(processos[j] == null){
				System.out.println("Frames: " + frames[0]);
				PCB processo = new PCB(j, frames);
				processos[j] = processo;
				break;
			}
		}

	}

	private static int getRegistrador(String registrador) {
		switch (registrador) {
			case "r0":
				return 0;
			case "r1":
				return 1;
			case "r2":
				return 2;
			case "r3":
				return 3;
			case "r4":
				return 4;
			case "r5":
				return 5;
			case "r6":
				return 6;
			case "r7":
				return 7;
			default:
				throw new IllegalArgumentException("Registrador Invalido");
		}
	}

	public void JMP(int k) {
		progCount = k;
	}

	public void JMPI(String Rs) {
		int aux = getRegistrador(Rs);
		progCount = registradores[aux];
	}

	public void JMPIG(String Rs, String Rc) {
		int aux1 = getRegistrador(Rc);
		int aux2 = getRegistrador(Rs);

		if (registradores[aux1] > 0) {
			progCount = registradores[aux2];
		}
	}

	public void JMPIL(String Rs, String Rc) {
		int aux1 = getRegistrador(Rc);
		int aux2 = getRegistrador(Rs);

		if (registradores[aux1] < 0) {
			progCount = registradores[aux2];
		}
	}

	public void JMPIE(String Rs, String Rc) {
		int aux1 = getRegistrador(Rc);
		int aux2 = getRegistrador(Rs);

		if (registradores[aux1] == 0) {
			progCount = registradores[aux2];
		}
	}

	public void ADDI(String Rd, int k) {
		int aux = getRegistrador(Rd);
		registradores[aux] += k;
	}

	public void SUBI(String Rd, int k) {
		int aux = getRegistrador(Rd);
		registradores[aux] -= k;
	}

	public void LDI(String Rd, int k) {
		int aux = getRegistrador(Rd);
		registradores[aux] = k;
	}

	private void LDD(String Rd, int n) {
		registradores[getRegistrador(Rd)] = memoria[n].num;
	}

	private void STD(int n, String Rs) {
		memoria[n] = new Palavra(registradores[getRegistrador(Rs)]);
	}

	public void ADD(String Rd, String Rs) {
		int aux_d = getRegistrador(Rd);
		int aux_s = getRegistrador(Rs);
		registradores[aux_d] += registradores[aux_s];
	}

	public void SUB(String Rd, String Rs) {
		int aux_d = getRegistrador(Rd);
		int aux_s = getRegistrador(Rs);
		registradores[aux_d] -= registradores[aux_s];
	}

	public void MULT(String Rd, String Rs) {
		int aux_d = getRegistrador(Rd);
		int aux_s = getRegistrador(Rs);
		registradores[aux_d] *= registradores[aux_s];
	}

	private void LDX(String Rd, String Rs) {
		int aux_d = getRegistrador(Rd);
		int aux_s = getRegistrador(Rs);
		registradores[aux_d] = memoria[registradores[aux_s]].num;
	}

	private void STX(String Rd, String Rs) {
		int aux_d = getRegistrador(Rd);
		int aux_s = getRegistrador(Rs);
		memoria[registradores[aux_d]] = new Palavra(registradores[aux_s]);
	}

	private void SWAP(String Rd, String Rs) {
		int aux_d = getRegistrador(Rd);
		int aux_s = getRegistrador(Rs);
		
		memoria[registradores[aux_d]] = memoria[registradores[aux_d+aux_s]];
		memoria[registradores[aux_s]] = memoria[registradores[aux_d-aux_s]];
		memoria[registradores[aux_d]] = memoria[registradores[aux_d-aux_s]];
	}

	public void printRegistradores() {
		StringBuilder sb = new StringBuilder();
		sb.append("R0: ").append(registradores[0]).append("\tR1: ").append(registradores[1]).append("\tR2: ").append(registradores[2])
				.append("\tR3: ").append(registradores[3]).append("\tR4: ").append(registradores[4]).append("\tR5: ").append(registradores[5])
				.append("\tR6: ").append(registradores[6]).append("\tR7: ").append(registradores[7]);

		System.out.println(sb.toString());
	}

	public void memoriaToString() {
		StringBuilder sb = new StringBuilder("\n");
		boolean prevIsNull = false;
		for (int i = 0; i < memoria.length; i++) {
			if (memoria[i] != null) {
				sb.append(i).append(".\t").append(memoria[i].label).append("\n");
				prevIsNull = false;
			} else {
				if (!prevIsNull) {
					sb.append("...null...\n");
					prevIsNull = true;
				}
			}
		}
		System.out.println(sb.toString());
	}

	public void desalocaMemoria(int n) {
        memoria[n] = null;
    }

	public void mostraProgramas(){
		for(int i= 0; i< processos.length; i++){
			if(processos[i] != null){
				System.out.println(processos[i].toString());
			}
		}
	}

	 //encerraProcesso recebendo id do processo
	 public void encerraProcesso(){
		System.out.println("Informe o ID do processo que deseja encerrar:");
		Scanner scan = new Scanner(System.in);

		int id = scan.nextInt();

		for(int i = 0; i < 64; i++){
			
			if(processos[i] != null && processos[i].getID() == id){
                int[] aux = processos[i].getFrames(); 
				for(int j = 0; j < aux.length; j++){
					gm.Desaloca(aux[j]);
					for (int x = aux[j] * 16; x <= (((aux[j]+1)*16))-1; x++) {
						desalocaMemoria(x);
					}
                }
                processos[i] = null;
			}
        }        
    }
}
