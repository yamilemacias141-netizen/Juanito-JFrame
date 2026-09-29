package Logica;

public class Persona {
private int capacidadEstomago;
private int cantidadDeComidaIngerida;

public Persona(int cap) {
	capacidadEstomago = cap;
}

public void digerir() {
	cantidadDeComidaIngerida = 0;
}

public boolean tienePanzaLlena() {
	if(cantidadDeComidaIngerida >= capacidadEstomago*0.9f) {
		return true;
	}
	else {
		return false;
	}
}

public void crecer() 
{
	if(tienePanzaLlena())
	{
		capacidadEstomago = capacidadEstomago +45;
	}

	
	 
}

public void aprender() {
	if(tienePanzaLlena()) {
		System.out.println("¡Aprendi!");
	}
	else {
		System.out.println("No aprendi :c");
	}
}

public void comer(int cantidadAlimento) {
	if(tienePanzaLlena()) {
		System.out.println("No estoy comiendo");
	}
	else {
		System.out.println("Estoy comiendo");
		cantidadDeComidaIngerida = cantidadAlimento + cantidadDeComidaIngerida;
		if(cantidadDeComidaIngerida > capacidadEstomago) {
			cantidadDeComidaIngerida = capacidadEstomago;
		}
		
	}
}

public int getCapacidad() {
	return capacidadEstomago;
}

public int getCantidadComida() {
	return cantidadDeComidaIngerida;
}
}