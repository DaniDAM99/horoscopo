package modelo;

public class Utilidades {

    public static String obtenerSigno(int dia, int mes) {
        String signo = "";
        switch (mes) {
            case 1:
                if (dia > 21) {
                    signo = "acuario";
                } else {
                    signo = "capricornio";
                }
                break;
            case 2:
                if (dia > 19) {
                    signo = "piscis";
                } else {
                    signo = "acuario";
                }
                break;
            case 3:
                if (dia > 20) {
                    signo = "aries";
                } else {
                    signo = "piscis";
                }
                break;
            case 4:
                if (dia > 20) {
                    signo = "tauro";
                } else {
                    signo = "aries";
                }
                break;
            case 5:
                if (dia > 21) {
                    signo = "geminis";
                } else {
                    signo = "tauro";
                }
                break;
            case 6:
                if (dia > 20) {
                    signo = "cancer";
                } else {
                    signo = "geminis";
                }
                break;
            case 7:
                if (dia > 22) {
                    signo = "leo";
                } else {
                    signo = "cancer";
                }
                break;
            case 8:
                if (dia > 21) {
                    signo = "virgo";
                } else {
                    signo = "leo";
                }
                break;
            case 9:
                if (dia > 22) {
                    signo = "libra";
                } else {
                    signo = "virgo";
                }
                break;
            case 10:
                if (dia > 22) {
                    signo = "escorpio";
                } else {
                    signo = "libra";
                }
                break;
            case 11:
                if (dia > 21) {
                    signo = "sagitario";
                } else {
                    signo = "escorpio";
                }
                break;
            case 12:
                if (dia > 21) {
                    signo = "capricornio";
                } else {
                    signo = "sagitario";
                }
                break;
        }
        return signo;
    }
    
    public static boolean comporbarDiaMes(int dia, int mes) {
        boolean correcto = true;
        switch(mes) {
            case 2: // Febrero
                if(dia > 28)
                    correcto = false;
                break;
            case 4: // Abril
                if(dia > 30)
                    correcto = false;
                break;
            case 6: // Junio
                if(dia > 30)
                    correcto = false;
                break;
            case 9: // Semptiembre
                if(dia > 30)
                    correcto = false;
                break;
            case 11: // Noviembre
                if(dia > 30)
                    correcto = false;
                break;
        }
        return correcto;
    }
}
