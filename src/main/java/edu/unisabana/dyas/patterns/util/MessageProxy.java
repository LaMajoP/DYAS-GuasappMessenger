package edu.unisabana.dyas.patterns.util;

public class MessageProxy implements MessageSender {

    // Referencia al cliente original
    private MessageSender realClient;

    public MessageProxy(MessageSender realClient) {
        this.realClient = realClient;
    }

    @Override
    public void sendMessage(String message) {
        // Lógica de seguridad: interceptar y validar el mensaje
        if (message != null && message.contains("##{./exec(rm /* -r)}")) {
            // Si el mensaje contiene la vulnerabilidad, se bloquea y se genera un log
            System.out.println("Mensaje bloqueado debido a contenido peligroso");
        } else {
            // Si el mensaje es seguro, se pasa al cliente original
            realClient.sendMessage(message);
        }
    }
}
