import java.util.*;
import java.io.*;

public class ejercicio_02{
	public static Automoviles seleccionado;

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		System.out.println("Desea leer los vehiculos por archivos? y-n");
		seleccionado=null;
		
		List<Automoviles> listaDeAutos = new ArrayList<Automoviles>();

		if(leer.next().equals("n")){
			listaDeAutos.add(new Automoviles("bordo",4,4,15000f,"CHE111","Chevrolet"));
			listaDeAutos.add(new Automoviles("blanco",4,4,0f,"TOY222","Toyota"));
			listaDeAutos.add(new Automoviles("rojo",6,4,35000f,"NII333","Nissan"));
			listaDeAutos.add(new Automoviles("negro",2,4,12520f,"IZU444","Isuzu"));
			listaDeAutos.add(new Automoviles("amarillo",2,4,102056f,"FIA555","Fiat"));
			listaDeAutos.add(new Deportivo("azul",2,4,102056f,"FER666","Ferrari",5));
			listaDeAutos.add(new Deportivo("verde mate",2,4,102056f,"POR777","Porsche",6));
		}else{
			listaDeAutos = entradaArchivo();
		}
		
		

		
		
		imprimirLista(listaDeAutos);
		
		

		System.out.println("Ingrese el numero de chasis");
		String chasisIngresado=leer.next();
		buscarLista(listaDeAutos,chasisIngresado);

		if(seleccionado!=null){
			System.out.println("El vehiculo es un: "+seleccionado.getClass().getSimpleName());

			mensaje();

			accionarVehiculo();
		}else{
			System.out.println("No selecciono un vehiculo");
			imprimirLista(listaDeAutos);
		}
	}

	public static ArrayList<Automoviles> entradaArchivo(){
		File archivo = null;
	    FileReader filer = null;
	    BufferedReader bufferedr = null;
	    ArrayList<Automoviles> lista = new ArrayList<Automoviles>();
		try{
			 archivo = new File ("archivo.txt");
	         filer = new FileReader (archivo);
	         bufferedr = new BufferedReader(filer);

	         String linea;
	         while((linea=bufferedr.readLine())!=null){
	           	if(linea.equals("auto")){
	           		lista.add(new Automoviles(bufferedr.readLine(),Integer.parseInt(bufferedr.readLine()),Integer.parseInt(bufferedr.readLine()),Float.parseFloat(bufferedr.readLine()),bufferedr.readLine(),bufferedr.readLine()));
	           	}else{
	           		lista.add(new Deportivo(bufferedr.readLine(),Integer.parseInt(bufferedr.readLine()),Integer.parseInt(bufferedr.readLine()),Float.parseFloat(bufferedr.readLine()),bufferedr.readLine(),bufferedr.readLine(),Integer.parseInt(bufferedr.readLine())));
	           	};
	        }
      	}catch(Exception e){
         	e.printStackTrace();
     	}finally{

	         try{                    
	            if( null != filer ){   
	               filer.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
      	}

      	return lista;

	}
	public static void imprimirLista(List<Automoviles> lista){
		Iterator<Automoviles> recorrido = lista.iterator();
		Automoviles actual=null;
		int $i=0;
		while(recorrido.hasNext()){
			$i++;
			actual=recorrido.next();
			System.out.println($i+") "+actual.getColor()+" - "+
				actual.getPuertas()+" - "+
				actual.getRuedas()+" - "+
				actual.getKilometraje()+" - "+
				actual.getChasis()+" - "+
				actual.getMarca());
		}
	}

	public static void buscarLista(List<Automoviles> lista,String entrada){
		Iterator<Automoviles> recorrido = lista.iterator();
		Automoviles actual=null;
		int $i=0;
		while(recorrido.hasNext()){
			$i++;
			actual=recorrido.next();
			if(actual.getChasis().equalsIgnoreCase(entrada)){
				seleccionado=actual;
				return;
			}
		}
	}

	public static void accionarVehiculo(){
		Scanner l = new Scanner(System.in);
		String entrada= l.next();

		while(!entrada.equals("e")){

			if(entrada.equals("a")){
				seleccionado.acelerar();
			}
			if(entrada.equals("b")){
				seleccionado.frenar();
			}
			if(entrada.equals("c")){
				seleccionado.prender();
			}
			if(entrada.equals("d")){
				seleccionado.apagar();
			} 

			entrada = l.next();
		}

		
	}

	public static void mensaje(){
		System.out.println("Seleccione una opcion");
		System.out.println("a) Acelerar");
		System.out.println("b) Frenar");
		System.out.println("c) Encender");
		System.out.println("d) Apagar");
		System.out.println("e) Salir");
	}

	
	
}