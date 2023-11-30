import java.io.*;

public class DatosTXT {
	private static String rutaDatos = null;

	public DatosTXT(String ruta) {
		rutaDatos = ruta;
	}
	public static void cargarDatos() {
		try (BufferedReader lector = new BufferedReader(new FileReader(rutaDatos))) {
			String line;
			String[][] dataMatrix = new String[4][4];
			int fila = 0;

			while ((line = lector.readLine()) != null && fila < 4) {
				String[] partes = line.split(";");

                System.arraycopy(partes, 0, dataMatrix[fila], 0, partes.length);
				fila++;
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					System.out.print(dataMatrix[i][j] + " ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			System.out.print("Se ha ingresado una dirección inválida o el archivo no está en el formato correcto." + e);
		}
	}



}