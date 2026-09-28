/* 
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #24
Fecha: 04/09/2026 
*/


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipFiles {
  public static void main(String[] args) {
    String zipFilePath = "D:/07_Recursos/Data.zip";      
    String destDir = "D:/07_Recursos/DataUnzipped";
        
    unzip(zipFilePath, destDir);
  }

  private static void unzip(String zipFilePath, String destDir) {
    File dir = new File(destDir);
    byte[] buffer = new byte[1024];

    // create output directory if it doesn't exist
    if(!dir.exists()) dir.mkdirs();        
    //buffer for read and write data to file
    try {
      FileInputStream fis = new FileInputStream(zipFilePath);
      ZipInputStream zis = new ZipInputStream(fis);
      ZipEntry ze = zis.getNextEntry();
      
      while(ze != null) {
        String fileName = ze.getName();
        File newFile = new File(destDir + File.separator + fileName);
        
        System.out.println("Unzipping to "+newFile.getAbsolutePath());
        //create directories for sub directories in zip
        new File(newFile.getParent()).mkdirs();
        FileOutputStream fos = new FileOutputStream(newFile);
        int len;

        while ((len = zis.read(buffer)) > 0) 
          fos.write(buffer, 0, len);
        fos.close();
        //close this ZipEntry
        zis.closeEntry();
        ze = zis.getNextEntry();
      }
      //close last ZipEntry
      zis.closeEntry();
      zis.close();
      fis.close();
    } catch (IOException e) {  e.printStackTrace();  }
  }


}
