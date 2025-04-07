package zg.crawler

class App {
    static void main(String[] args) {
        //Marcelo Roner
        println "🚀 Iniciando o ZG TISS Crawler"

        CrawlerANS.executar()

        def arquivos = [
                new File("./Arquivos_padrao_TISS/comunicacao.zip"),
                new File("dados_tiss.csv"),
                new File("./Tabelas/tabela_erros_envio.xls")
        ]
        def destinatarios = EmailService.listarEmails()

        if (destinatarios.isEmpty()) {
            println "⚠️ Nenhum e-mail cadastrado! Use o terminal para adicionar."
        } else {
            EmailSender.enviarEmailComAnexos(destinatarios, arquivos)
        }

        println "\n✅ Processo concluído!"
    }
}
