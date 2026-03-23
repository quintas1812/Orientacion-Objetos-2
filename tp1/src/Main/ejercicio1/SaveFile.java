package Main.ejercicio1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile implements Save {
    private String path;

    public SaveFile(String path) {
        this.path = path;
    }
    @Override
    public void guardar(String datos) {
        File aFile = new File(this.path);
        boolean isNewFile = !aFile.exists();
        try (FileWriter writer = new FileWriter(aFile, true)) { //fileWriter para escribir al final del archivo(append true)
            if (isNewFile) {
                writer.write("Fecha, Curso, Participante\r\n");
            }
            writer.write(datos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
