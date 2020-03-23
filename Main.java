import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    System.out.println("Introduzca el nombre del archivo en el que se encuentran");
    System.out.println("los datos de su curriculum (abra el Leame para ver un");
    System.out.println("ejemplo).");
    System.out.print("(No incluya la extensión .txt): ");
    String fileName = s.nextLine();
    getData(fileName);

  }

  /**
   * Función con la que recogemos la información, se pide al usuario que siga la guia 
   * que se le ofrece en el readme
   * @param fileName Nombre del archivo
   */
  public static void getData(String fileName) {

    try {

      BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"));
      String linea = br.readLine();
      Persona persona = new Persona();
      int i = 0;
      boolean bucle = false;
      while (linea != null) {

        if (linea.equals(">>>")) {

          i++;
        }
        switch (i) {

          case 1: //Cogemos el nombre
            linea = br.readLine();
            persona.setNombre(linea);
            break;
          case 2: // Cogemos la edad
            linea = br.readLine();
            persona.setEdad(linea);
            break;
          case 3: // Cogemos el email
            linea = br.readLine();
            persona.setEmail(linea);
            break;
          case 4: // Cogemos el telefono
            linea = br.readLine();
            persona.setTelf(linea);
            break;
          case 5: // Cogemos el nombre de la foto
            linea = br.readLine();
            persona.setFoto(linea);
            break;
          case 6: // Cogemos la direccion
            linea = br.readLine();
            persona.setDirec(linea);
            break;
          case 7: // Recogemos la formacion
            do {

              linea = br.readLine();
              if (!linea.equals(">>>")) {
                String nombre = linea;
                linea = br.readLine();
                String anio = linea;
                persona.addForm(nombre, anio);
              }
              bucle = true;
            } while (linea != null && !linea.equals(">>>"));
            break;
          case 8: // Recogemos la experiencia
            do {

              linea = br.readLine();
              if (linea != null) {
                String nombre = linea;
                linea = br.readLine();
                String time = linea;
                persona.addExp(nombre, time);
              }
            } while (linea != null);
            break;
          default:
            break;
        }       

        if (!bucle) {
          linea = br.readLine();
        }

      }
      br.close();
      createCV(persona);
    } catch(FileNotFoundException fnfe) {

      System.out.println("No se ha podido encontrar el archivo");
    } catch(IOException ioe) {

      System.out.println("Ha ocurrido un error durante la lectura del archivo");
    }
  }

  /**
   * Función que crea el curriculum del usuario
   * @param persona Clase persona con los datos del usuario
   */
  public static void createCV(Persona persona) {

    try {

      BufferedWriter bw = new BufferedWriter(new FileWriter("CV.html"));
      bw.write("<!DOCTYPE html>\r\n" + 
          "<html lang=\"en\">\r\n" + 
          "<head>\r\n" + 
          "    <meta charset=\"UTF-8\">\r\n" + 
          "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
          "    <title>CV " + persona.getNombre() + "</title>");
      bw.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n" + 
          "    <style>\r\n" + 
          "\r\n" + 
          "        .mt-8 {\r\n" + 
          "\r\n" + 
          "            margin-top: 8%;\r\n" + 
          "        }\r\n" + 
          "\r\n" + 
          "        .ml-8 {\r\n" + 
          "\r\n" + 
          "            margin-left: 30%;\r\n" + 
          "        }\r\n" + 
          "        .bg-body {\r\n" + 
          "\r\n" + 
          "            background-color: rgb(236, 236, 236);\r\n" + 
          "        }\r\n" + 
          "    </style>\r\n" + 
          "</head>\r\n" + 
          "<body class=\"bg-body py-4\">\r\n" + 
          "    <main class=\"container-sm w-75 mt-8\">\r\n" + 
          "        <section class=\"bg-white w-75 mx-auto\">\r\n" + 
          "            <div class=\"container-sm m-0 p-0\">\r\n" + 
          "                <div class=\"row\">\r\n" + 
          "                    <div class=\"col m-0 p-0\">\r\n" + 
          "                        <img class=\"img-fluid\" src=\"" + persona.getFoto() + "\" alt=\"profile_picture\">");
      bw.write("</div>\r\n" + 
          "                    <div class=\"col-8 m-3\">");
      bw.write("<h1>" + persona.getNombre() +"</h1>");
      bw.write("<br>\r\n" + 
          "                        <h5><strong>Edad: </strong>" + persona.getEdad() + "</h5>\r\n" + 
          "                        <h5><strong>Direccion: </strong> " + persona.getDirec() + "</h5>\r\n" + 
          "                        <h5><strong>Email: </strong>" + persona.getEmail() + "</h5>\r\n" + 
          "                        <h5><strong>Telefono: </strong>" + persona.getTelf() + "</h5>");
      bw.write("</div>\r\n" + 
          "                </div>\r\n" + 
          "            </div>\r\n" + 
          "        </section>");
      if (!persona.getExperiencia().isEmpty()) {

        bw.write("<section>\r\n" + 
            "            <h1 class=\"text-center m-4\">Formacion</h1>\r\n" + 
            "            <div class=\"container-sm m-0 p-0 bg-white w-75 mx-auto\">");
        for (Map.Entry exp : persona.getExperiencia().entrySet()) {
          bw.write("<div class=\"row m-3 p-3\">\r\n" + 
              "                    <div class=\"col-4\">\r\n" + 
              "                        <h4><strong>Tiempo: </strong>" + exp.getValue() + "</h4>\r\n" + 
              "                    </div>\r\n" + 
              "                    <div class=\"col-8\">\r\n" + 
              "                        <h4>" + exp.getKey() + "</h4>\r\n" + 
              "                    </div>\r\n" + 
              "                </div>");
        }
        bw.write("</div>\r\n" + 
            "        </section>");
      }
      if (!persona.getFormacion().isEmpty()) {

        bw.write("<section>\r\n" + 
            "            <h1 class=\"text-center m-4\">Estudios</h1>\r\n" + 
            "            <div class=\"container-sm m-0 p-0 bg-white w-75 mx-auto\">");
        for (Map.Entry form : persona.getFormacion().entrySet()) {
          bw.write("<div class=\"row m-3 p-3\">\r\n" + 
              "                    <div class=\"col-4\">\r\n" + 
              "                        <h4><strong>Años: </strong>" + form.getValue() + "</h4>\r\n" + 
              "                    </div>\r\n" + 
              "                    <div class=\"col-8\">\r\n" + 
              "                        <h4>" + form.getKey() + "</h4>\r\n" + 
              "                    </div>\r\n" + 
              "                </div>");
        }
      }
      bw.write("</div>\r\n" + 
          "        </section>\r\n" + 
          "    </main>\r\n" + 
          "</body>\r\n" + 
          "</html>");
      bw.close();
      System.out.println("Archivo creado");
    } catch (FileNotFoundException fnfe) {

      System.out.println("No se ha podido encontrar el archivo");
    } catch (IOException ioe) {

      System.out.println("No se ha podido escribir el archivo");
    }
  }
}
