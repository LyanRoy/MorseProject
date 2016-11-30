package traductormorse;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author Heydi y sus cabras del monte
 */
public class Beep {
    
    /*
    * En esta parte se modifica el sonido tomando en cuenta los estándares del 
    * código morse como lo son sus ppm (recomendado poner a 20ppm) las cuales 
    * definen la velocidad del este, por ejemplo un dit es equivalente a 
    * T=1200/ppm , un dah es 3 veces un dit, el espacio enntre letra y letra es 
    * igual al de un dit y el espacio entre palabra y palabra es 7 veces el 
    * valor de un dit.
    */

    public static void tono(int msecs) throws LineUnavailableException {
        byte[] buf = new byte[msecs * 8];
        for (int i = 0; i < buf.length; i++) {
            double angle = i / (8000.0 / 700) * 2.0 * Math.PI;
            buf[i] = (byte) (Math.sin(angle) * 127.0);
        }
        for (int i = 0; i < 80 && i < buf.length / 2; i++) {
            buf[i] = (byte) (buf[i] * i / 80.0);
            buf[buf.length - 1 - i] = (byte) (buf[buf.length - 1 - i] * i / 80.0);
        }
        AudioFormat af = new AudioFormat(8000f, 8, 1, true, false);
        try (SourceDataLine sdl = AudioSystem.getSourceDataLine(af)) {
            sdl.open(af);
            sdl.start();
            sdl.write(buf, 0, buf.length);
            sdl.drain();
        }
    }

    public void beeper(char x, int ppm) throws Exception {
        int tiempo = 1200 / ppm;
        int dit = tiempo;
        int dah = tiempo * 3;
        int espacio = tiempo * 5;
        if (x == '.') {
            Beep.tono(dit);
            Thread.sleep(dit);
        } else {
            if (x == '-') {
                Beep.tono(dah);
            } else {
                if (x == ' ') {
                    Thread.sleep(dit);
                } else {
                    Thread.sleep(espacio);
                }
            }
        }
    }
}
