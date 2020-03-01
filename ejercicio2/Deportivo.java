public class Deportivo extends Automoviles{
	private int tiempo_0_a_100;

	Deportivo(String color, int puertas, int ruedas, float kilometraje, String chasis, String marca,int tiempo){
		super(color,puertas,ruedas,kilometraje,chasis,marca);
		this.tiempo_0_a_100=tiempo;
	}

	public void acelerar(){
		if(this.prender){
			this.acelerar=true;
			this.frenar=false;
			System.out.println("El vehiculo acelera");
			System.out.println("El vehiculo acelera de 0 a 100 en: "+this.tiempo_0_a_100);
		}else{
			System.out.println("No puede acelerar un vehiculo apagado");
		}
		
	}
}