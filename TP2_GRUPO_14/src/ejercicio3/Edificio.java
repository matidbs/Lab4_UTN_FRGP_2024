package ejercicio3;

public abstract class Edificio {

	private double SuperficieEdificio;
	
	public Edificio() {
		
	}
	
	public Edificio(double SuperficieEdificio) {
		this.SuperficieEdificio = SuperficieEdificio;
	}

	public double getSuperficieEdificio() {
		return SuperficieEdificio;
	}

	public void setSuperficieEdificio(double superficieEdificio) {
		SuperficieEdificio = superficieEdificio;
	}

	@Override
	public String toString() {
		return "\nSuperficie del Edificio: " + SuperficieEdificio;
	}
	
	
}
