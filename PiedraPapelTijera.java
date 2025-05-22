import javax.swing.JOptionPane;

public class PiedraPapelTijera {
    public static void main(String[] args) {
        int jugadorPuntos = 0;
        int computadoraPuntos = 0;

        int rondas = Integer.parseInt(
            JOptionPane.showInputDialog("¿Cuántas rondas deseas jugar?")
        );

        for (int ronda = 1; ronda <= rondas; ronda++) {
            String jugador = JOptionPane.showInputDialog(
                "Ronda " + ronda + "\nElige: piedra, papel o tijera"
            ).toLowerCase();

            int jugadorValor = -1;

            // Asignar valor numérico a la elección del jugador
            if (jugador.equals("piedra")) {
                jugadorValor = 0;
            } else if (jugador.equals("papel")) {
                jugadorValor = 1;
            } else if (jugador.equals("tijera")) {
                jugadorValor = 2;
            } else {
                JOptionPane.showMessageDialog(null, "Opción inválida. Intenta de nuevo.");
                ronda--; // Repetir esta ronda
                continue;
            }

            // Elección aleatoria de la computadora
            int computadoraValor = (int)(Math.random() * 3 + 1); // genera 1, 2 o 3
            String computadora;
            if (computadoraValor == 1) {
                computadora = "piedra";
            } else if (computadoraValor == 2) {
                computadora = "papel";
            } else {
                  computadora = "tijera";
            }

            //Lógica del juego con operadores lógicos
            String resultado = "";

            if (jugadorValor == computadoraValor) {
                resultado = "Empate.";
            } else if (
                (jugadorValor == 0 && computadoraValor == 2) || // piedra gana a tijera
                (jugadorValor == 1 && computadoraValor == 0) || // papel gana a piedra
                (jugadorValor == 2 && computadoraValor == 1)    // tijera gana a papel
            ) {
                resultado = "¡Ganaste esta ronda!";
                jugadorPuntos++;
            } else {
                resultado = "La computadora gana esta ronda.";
                computadoraPuntos++;
            }

            // Mostrar resultado de la ronda
            JOptionPane.showMessageDialog(null,
                "Tú elegiste: " + jugador +
                "\nLa computadora eligió: " + computadora +
                "\n" + resultado +
                "\nPuntos: Tú = " + jugadorPuntos + " | Computadora = " + computadoraPuntos
            );
        }

        // Mostrar resultado final
        String finalMensaje = "";
        if (jugadorPuntos > computadoraPuntos) {
            finalMensaje = "¡Ganaste el juego!";
        } else if (jugadorPuntos < computadoraPuntos) {
            finalMensaje = "La computadora ganó el juego.";
        } else {
            finalMensaje = "El juego terminó en empate.";
        }

        JOptionPane.showMessageDialog(null,
            "Resultado final:\nTú = " + jugadorPuntos + " | Computadora = " + computadoraPuntos +
            "\n" + finalMensaje
        );
    }
}
