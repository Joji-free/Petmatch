package util;


import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class CorreoUtil {

    public static void enviarVerificacion(String correoDestino) {
        final String remitente = "tucorreo@gmail.com"; // Cambiar
        final String contraseña = "tu_clave_de_aplicacion"; // Usa clave de aplicación, no la real

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, contraseña);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoDestino));
            message.setSubject("Verifica tu cuenta en MatchPet");
            String link = "http://localhost:8080/MatchPet/verificar?correo=" + correoDestino;
            message.setText("Haz clic en el siguiente enlace para verificar tu cuenta:\n\n" + link);

            Transport.send(message);
            System.out.println("Correo de verificación enviado a " + correoDestino);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
