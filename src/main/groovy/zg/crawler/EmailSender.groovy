package zg.crawler

import javax.mail.*
import javax.mail.internet.*
import java.util.Properties

class EmailSender {

    static void enviarEmailComAnexos(List<String> destinatarios, List<File> anexos) {
        final String remetente = "marceloroner90@gmail.com"
        final String senha = System.getenv("ZG_CRAWLER_SENHA")

        Properties props = new Properties()
        props.put("mail.smtp.auth", "true")
        props.put("mail.smtp.starttls.enable", "true")
        props.put("mail.smtp.host", "smtp.gmail.com")
        props.put("mail.smtp.port", "587")

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha)
            }
        })

        try {
            MimeMessage mensagem = new MimeMessage(session)
            mensagem.setFrom(new InternetAddress(remetente))
            destinatarios.each {
                mensagem.addRecipient(Message.RecipientType.TO, new InternetAddress(it))
            }
            mensagem.setSubject("Relatório do ZG TISS Crawler")

            Multipart multipart = new MimeMultipart()

            MimeBodyPart corpoTexto = new MimeBodyPart()
            corpoTexto.setText("Segue em anexo os arquivos baixados pelo crawler.")
            multipart.addBodyPart(corpoTexto)

            anexos.each { file ->
                MimeBodyPart anexoPart = new MimeBodyPart()
                anexoPart.attachFile(file)
                multipart.addBodyPart(anexoPart)
            }

            mensagem.setContent(multipart)

            Transport.send(mensagem)
            println "✅ E-mail enviado com sucesso!"
        } catch (Exception e) {
            println "❌ Erro ao enviar e-mail: ${e.message}"
        }
    }
}
