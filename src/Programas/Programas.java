package Programas;

import CPU.Palavra;

public class Programas {
	
	//Fibonacci-10
	private static Palavra[] p1 = new Palavra[] {
		new Palavra("LDI", "r1", 0),
		new Palavra("STD", 250, "r1"),
		new Palavra("LDI", "r2", 1),
		new Palavra("STD", 251, "r2"),
		new Palavra("LDI", "r0", 252),
		new Palavra("LDI", "r6", 5),
		new Palavra("LDI", "r7", 261),
		new Palavra("LDI", "r3", 0),
		new Palavra("ADD", "r3", "r1"),
		new Palavra("LDI", "r1", 0),
		new Palavra("ADD", "r1", "r2"),
		new Palavra("ADD", "r2", "r3"),
		new Palavra("STX", "r0", "r2"),
		new Palavra("ADDI", "r0", 1),
		new Palavra("SUB", "r7", "r0"),
		new Palavra("JMPIG", "r6", "r7"),
		new Palavra("STOP"),
	};

	private static Palavra[] p2 = new Palavra[] {
		new Palavra("LDI", "r4", 5), 		
		new Palavra("LDI", "r5", 5),		
		new Palavra("JMPIL", "r5", "r4"),	
		new Palavra("STD", 49, "r4"), 		
		new Palavra("LDI", "r0", 51), 		
		new Palavra("LDI", "r1", 0), 		
		new Palavra("STD", 50, "r1"), 		
		new Palavra("LDI", "r2", 1), 		
		new Palavra("STD", 51, "r2"), 		
		new Palavra("LDI", "r6", 8), 		
		new Palavra("LDD", "r7", 49),		
		new Palavra("ADDI", "r7", 52), 	
		new Palavra("LDI", "r3", 0), 		
		new Palavra("ADD", "r3", "r1"), 	
		new Palavra("LDI", "r1", 0), 		
		new Palavra("ADD", "r1", "r2"), 	
		new Palavra("ADD", "r2", "r3"), 	
		new Palavra("STX", "r0", "r2"), 	
		new Palavra("ADDI", "r0", 1), 		
		new Palavra("SUB", "r7", "r0"), 	
		new Palavra("JMPIG", "r6", "r7"), 	
		new Palavra("STOP"), 				
		new Palavra("LDI", "r4", -1),		
		new Palavra("STD", 50, "r4"),		
		new Palavra("STOP")				
	};
	
	private static Palavra[] p3 = new Palavra[] {
		new Palavra("LDI", "r0", 3), 			
		new Palavra("LDI", "r5", 11), 
		new Palavra("JMPIL", "r5", "r0"), 
		new Palavra("LDI", "r6", 6),
		new Palavra("LDI", "r1", 0),
		new Palavra("ADD", "r1", "r0"), 
		new Palavra("SUBI", "r1", 1), 
		new Palavra("MULT", "r0", "r1"), 
		new Palavra("SUBI", "r1", 1), 
		new Palavra("JMPIG", "r6", "r1"), 
		new Palavra("STD", 50, "r0"),
		new Palavra("STOP"),
		new Palavra("LDI", "r0", -1),
		new Palavra("STD", 50, "r0"),
		new Palavra("STOP")
	};
	
	private static Palavra[] p4 = new Palavra[] {
		new Palavra("LDI", "r0", 0),
		new Palavra("STD", 50, "r0"),
		new Palavra("LDI", "r0", 5),
		new Palavra("STD", 52, "r0"),
		new Palavra("LDI", "r0", 1),
		new Palavra("STD", 53, "r0"),
		new Palavra("LDI", "r0", 4),
		new Palavra("STD", 54, "r0"),
		new Palavra("LDI", "r3", 4),
		new Palavra("LDI", "r4", 0),
		new Palavra("LDI", "r5", 16),
		new Palavra("LDI", "r6", 29),
		new Palavra("LDI", "r7", 34),
		new Palavra("LDI", "r0", 50),
		new Palavra("JMPIE", "r6", "r3"),
		new Palavra("SUBI", "r3", 1),
		new Palavra("LDX", "r1", "r0"),
		new Palavra("ADDI", "r0", 1),
		new Palavra("LDX", "r2", "r0"),
		new Palavra("SUB", "r2", "r1"),
		new Palavra("JMPIG", "r5", "r2"),
		new Palavra("LDX", "r2", "r0"),
		new Palavra("STX", "r0", "r1"),
		new Palavra("SUBI", "r0", 1),
		new Palavra("STX", "r0", "r2"),
		new Palavra("ADDI", "r0", 1),
		new Palavra("JMPI", "r5", "r0"),
		new Palavra("JMPIE", "r7", "r4"),
		new Palavra("SUBI", "r4", 1),
		new Palavra("LDI", "r3", 4),
		new Palavra("JMPIG", "r5", "r0"),
		new Palavra("STOP")
	};
	
	public Programas() {
	
	}
	
	public Palavra[] fibonacci10() {
		return p1;
	}
	
	public Palavra[] fibonaccin() {
		return p2;
	}
	
	public Palavra[] fatorial() {
		return p3;
	}
	
	public Palavra[] bubblesort() {
		return p4;
	}
}