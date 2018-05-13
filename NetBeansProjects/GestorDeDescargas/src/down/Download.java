/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package down;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * @author eduard
 */
public class Download {

    private URL url;
    private URLConnection conexion;
    private File file;
    private boolean terminate;

    public Download(File file) {
        this.file = file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isTerminate() {
        return terminate;
    }

    public void loadURL(String sURL) throws MalformedURLException {
        this.url = new URL(sURL);
    }

    public URLConnection openConexion() throws IOException {
        conexion = url.openConnection();
        conexion.connect();
        return conexion;
    }

    public void descarga(final JProgressBar pbBarra, final JLabel label, final Timer timer) throws IOException {
        String array[] = url.toString().split("/");
        final String salida = array[array.length - 1].replaceAll("%20", " ");
        final double completo = (double) ((double) (conexion.getContentLength() / 1000) / 1000);

        final BufferedInputStream buffer = new BufferedInputStream(conexion.getInputStream());
        final BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file + "/" + salida));

        timer.start();
        final byte datos[] = new byte[1000];
        new Thread() {
            @Override
            public void run() {
                try {
                    int read;
                    int length = 0;
                    read = buffer.read(datos);
                    while (read > 0) {
                        length += read;
                        pbBarra.setValue(length);
                        out.write(datos, 0, read);
                        double size = (double) ((double) (length / 1000) / 1000);
                        pbBarra.setString(salida + " [ " + (int) ((pbBarra.getPercentComplete()) * 100) + " %]");
                        label.setText("Descargando " + size + " MB de " + completo + " MB  [ " + (int) ((pbBarra.getPercentComplete()) * 100) + " % ]");
                        read = buffer.read(datos);
                    }
                    buffer.close();
                    out.close();
                    label.setText("Descarga Terminada");
                    timer.stop();
                } catch (IOException ex) {
                    System.out.println("ERROR --> " + ex);
                }
            }
        }.start();
    }
}
