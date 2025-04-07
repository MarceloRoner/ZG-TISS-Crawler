package zg.crawler

class EmailService {
    static final String ARQUIVO_EMAILS = "./emails.txt"

    static List<String> listarEmails(){
        def arquivo = new File(ARQUIVO_EMAILS)
        return arquivo.exists() ? arquivo.readLines() : []
    }

    static void adicionarEmails(String email){
        def arquivo = new File(ARQUIVO_EMAILS)
        arquivo << email + System.lineSeparator()
    }

    static void removerEmails(String email){
        def emails = listarEmails()
        def atualizados = emails.findAll{it -> it != email}
        new File(ARQUIVO_EMAILS).text = atualizados.join(System.lineSeparator())
    }

    static void limparEmails() {
        new File(ARQUIVO_EMAILS).delete()
    }

}
