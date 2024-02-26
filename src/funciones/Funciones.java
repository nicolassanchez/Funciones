package funciones;

import java.util.List;
import java.util.ArrayList;

/*
 *  Crea una clase Funciones.java que contenga la implementación y las pruebas de la siguiente funcionalidades: 
 *  
 *  1. Dada una lista de números reales, diseñar funciones que devuelvan la suma, la media, el máximo, 
 *     el mínimo y la varianza.
 *  
 *  2. Dada una cadena de caracteres con todos ellos en mayúsculas, diseñar una función que devuelva  
 *     otra con todos los caracteres en minúsculas salvo el comienzo de cada palabra que debe quedar 
 *     en mayúscula.
 *  
 *  3. Dada una lista con números enteros, diseñar una función que devuelva otra lista con las diferencias
 *     entre cada valor y el anterior.
 *     
 *  4. Dado un número entero n >1 diseñar una función para decidir si es primo o no.
 *  
 *  5. Dado un número entero n >1 diseñar una función que devuelva una lista con sus divisores ordenados
 *     de menor a mayor.
 *  
 *  6. Dada una lista de cadenas de caracteres, diseñar una función que devuelva la cadena más larga.
 */

public class Funciones {
		
	/* 
	 * Dada una lista de números reales, diseñar funciones que devuelvan la suma, 
	 * la media, el máximo y el mínimo.
	 */
	
	public static Integer suma(List<Integer> numeros) {
		
		if (numeros.size() == 0) {
			throw new IllegalArgumentException("La lista está vacía");
		}
		
		Integer s = 0;
		
		for (int i=0; i < numeros.size(); i++){
			s += numeros.get(i);
		}
		
		// Otra forma de hacerlo		
		// for (Integer n : numeros) {
		//		s += n;
		// }
		
		return s;
	}

	public static Double media(List<Integer> numeros) {
		
		if (numeros.size() == 0) {
			throw new IllegalArgumentException("La lista está vacía");
		}
		
		Integer sumaNumeros = 0; 
		Integer numElementos = 0;
		 		
		for (Integer n : numeros) {			
			sumaNumeros += n;
			numElementos++;
		}
		
		return sumaNumeros * 1. / numElementos;  // Debe devolver un Double (1.)
	}

	public static Integer maximo(List<Integer> numeros) {
		
		if (numeros.size() == 0) {
			throw new IllegalArgumentException("La lista está vacía");
		}
			
		Integer numMaximo = Integer.MIN_VALUE;
		
		for (Integer n : numeros) {
			if (n > numMaximo) {
				numMaximo = n;
			}
		}
		return numMaximo;
	}
	
	public static Integer minimo(List<Integer> numeros) {
		
		if (numeros.size() == 0) {
			throw new IllegalArgumentException("La lista está vacía");
		}
		
		Integer minNumero = Integer.MAX_VALUE;
		
		for (Integer n : numeros) {
			if (n < minNumero) {
				minNumero = n;
			}
		}
		return minNumero;
	}
 
	/*
	 * Dada una cadena de caracteres con todos ellos en mayúsculas, diseñar una función que devuelva 
	 * otra con todos los caracteres en minúsculas, salvo el comienzo de cada palabra que debe quedar 
	 * en mayúscula. 
	 */
	
	private static String capitalizarPalabra(String p) {
		return String.valueOf(p.charAt(0)) + p.substring(1).toLowerCase();
	}
	
	public static String pasaAminusculas(String cadena)  {
		
		if (cadena == null || cadena.isBlank() ) {
			throw new IllegalArgumentException("El cadena está vacia o contiene solo espacios en blanco");
		}
		
		for (int i = 0; i < cadena.length(); i++) {
		
			if (Character.isLowerCase(cadena.charAt(i))) {
				throw new IllegalArgumentException("La cadena contiene algún caracter en minúsculas");
			}
		}
		
		String res = "";
		String[] palabras = cadena.split(" ");
	
		for (String p : palabras) {
			res += capitalizarPalabra(p)  + " ";
		}
		
		return res.substring(0, res.length()-1);	
	}

	/*
	 * Dada una lista con números enteros, diseñar una función que devuelva otra lista con las 
	 * diferencias entre cada valor y el anterior.
	 */
	
	static List<Integer> diferencias(List<Integer> numeros) {
		
		if (numeros.size() == 0) {
			throw new IllegalArgumentException("La lista está vacía");
		}
		
		List<Integer> res = new ArrayList<>();
		
		for (int i = 1; i < numeros.size(); i++) {
			res.add(numeros.get(i) - numeros.get(i - 1));
		}
		return res;
	}
	
	/*
	 * Dado un número entero n >1 diseñar una función para decidir si es primo o no.
	 */

	public static boolean esPrimo(Integer n) {
		
		if (n == null || n <= 1) {
			throw new IllegalArgumentException("El número es nulo o es menor que 2");
		}
		
		boolean res = true;
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			
			if (n % i == 0) {
				res = false;
				break;
			}
		}
		return res;
	}

	/*
	 * Dado un número entero n > 1 diseñar una función que devuelva una lista con sus 
	 * divisores ordenados de menor a mayor.
	 */
	
	public static List<Integer> divisores(Integer n) {
		
		if (n == null || n <= 1) {
			throw new IllegalArgumentException("El número es nulo o es menor que 2");
		}
		
		List<Integer> l = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				l.add(i);
			}
		}
		
		return l;
	}

	/*
	 * Dada una lista de cadenas de caracteres, diseñar una función que devuelva la cadena más larga 
	 */
	
	public static String cadenaMasLarga(List<String> cadenas) {
		
		if (cadenas.size() == 0) {
			throw new IllegalArgumentException("La lista está vacía");
		}
				
		String res = cadenas.get(0);
		
		for (String cadena : cadenas) {
			
			if (cadena.length() > res.length()) {				
				res = cadena;
			}
		}
		
		if (res.isBlank()) {
			throw new IllegalArgumentException("La lista solo contenia espacios en blanco o cadenas vacías");
		}
		
		return res;
	}
	
	//****************************************** Test ***************************************
	public static void main(String[] args) {
		
		List<Integer> l = List.of(1,2,3,5,8);
		List<Integer> l1 = List.of();
		String s0 = "EL QUIJOTE DE LA MANCHA";
		String s1 = null;
		
		try {
			
			System.out.println("suma: " + suma(l));
			System.out.println("media: " + media(l));
			System.out.println("máximo: " + maximo(l));
			System.out.println("mínimo: " + minimo(l));
			System.out.println("mínimo: " + minimo(l1));

		}catch(Exception e) {
			System.out.println("\tHa habido un error en alguna función: " + 
		e.getMessage() );
		}
		
		try {
			
			System.out.println("Se pasa el texto '" + s0 + "' a minúsculas : " + pasaAminusculas(s0));
			System.out.println("a minúsculas: " + pasaAminusculas("EL error DE LA MANCHA"));
		
		}catch(Exception e) {
			System.out.println("\tHa habido un error en alguna función: " + e.getMessage());
		}
		
		try {
				
		    System.out.println("a minúsculas: " + pasaAminusculas(s1));
	
		}catch(Exception e) {
			System.out.println("\tHa habido un error en alguna función: " + e.getMessage());
		}
		    
		System.out.println("diferencias: " + diferencias(l));
		
		//System.out.println("diferencias: " + diferencias(l1));

		System.out.println("es primo el número 1217?: " + esPrimo(1217));
		System.out.println("es primo el número 144?: " + esPrimo(144));
		//Integer n = null;
		//System.out.println("es primo el número 1217?: " + esPrimo(n));

		System.out.println("divisores de 30: " + divisores(30));
		//System.out.println("divisores de 1: " + divisores(1));

		System.out.println("cadena más larga: " + cadenaMasLarga(List.of("aaa3", "aaaa4", "aaaaa5")));
		//System.out.println("cadena más larga: " + cadenaMasLarga(List.of("", "", "")));
		
	}
}