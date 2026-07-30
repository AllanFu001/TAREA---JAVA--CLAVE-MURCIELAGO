package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class Archivo {

    private File archivoActual;

    public void abrir(JTextArea area) {

        JFileChooser selector = new JFileChooser();

        int opcion = selector.showOpenDialog(null);

        if (opcion == JFileChooser.APPROVE_OPTION) {

            archivoActual = selector.getSelectedFile();

            try {

                BufferedReader lector = new BufferedReader(
                        new FileReader(archivoActual));

                String linea;
                area.setText("");

                while ((linea = lector.readLine()) != null) {

                    area.append(linea + "\n");

                }

                lector.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

    public void guardar(JTextArea area) {

        if (archivoActual == null) {

            guardarComo(area);

        } else {

            escribir(area);

        }

    }

    public void guardarComo(JTextArea area) {

        JFileChooser selector = new JFileChooser();

        int opcion = selector.showSaveDialog(null);

        if (opcion == JFileChooser.APPROVE_OPTION) {

            archivoActual = selector.getSelectedFile();

            escribir(area);

        }

    }

    private void escribir(JTextArea area) {

        try {

            BufferedWriter escritor = new BufferedWriter(
                    new FileWriter(archivoActual));

            escritor.write(area.getText());

            escritor.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}