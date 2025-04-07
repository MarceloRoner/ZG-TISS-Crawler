package zg.crawler

import java.util.Scanner

class EmailCLI {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in)

        while (true) {
            println "\n📬 GERENCIADOR DE E-MAILS"
            println "1. Listar e-mails"
            println "2. Adicionar e-mail"
            println "3. Remover e-mail"
            println "4. Limpar todos os e-mails"
            println "5. Sair"
            print "Escolha uma opção: "
            String opcao = scanner.nextLine().trim()

            switch(opcao) {
                case "1":
                    println "\n📋 Lista de e-mails:"
                    def emails = EmailService.listarEmails()
                    if (emails) emails.eachWithIndex { email, i -> println "${i + 1}. ${email}" }
                    else println "⚠️ Nenhum e-mail cadastrado."
                    break

                case "2":
                    print "Digite o e-mail a ser adicionado: "
                    String novoEmail = scanner.nextLine().trim()
                    EmailService.adicionarEmails(novoEmail)
                    println "✅ E-mail adicionado com sucesso!"
                    break

                case "3":
                    print "Digite o e-mail a ser removido: "
                    String emailRemover = scanner.nextLine().trim()
                    EmailService.removerEmails(emailRemover)
                    println "🗑️ E-mail removido (se existir na lista)."
                    break

                case "4":
                    EmailService.limparEmails()
                    println "🧹 Lista de e-mails limpa com sucesso!"
                    break

                case "5":
                    println "👋 Encerrando o gerenciador..."
                    return

                default:
                    println "❌ Opção inválida. Tente novamente."
            }
        }
    }
}
