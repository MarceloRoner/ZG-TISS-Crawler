package zg.crawler
import org.apache.http.conn.routing.RouteInfo
import static groovyx.net.http.JavaHttpBuilder.configure
import org.jsoup.Jsoup

class App {
    static void main(String[] args) {
        //MARCELO RONER

            def url = "https://www.gov.br/ans/pt-br/assuntos/prestadores/padrao-para-troca-de-informacao-de-saude-suplementar-2013-tiss"
            def doc = Jsoup.connect(url).get()
            def link1 = doc.select("a:contains(Clique aqui para acessar a versão Março/2025)").first()
            def url2 = link1.absUrl("href")
            def doc2 = Jsoup.connect(url2).get()
            def links = doc2.select("a")
            def linkComunicacao = links.find{
                it.text().toLowerCase().contains("componente de comunicação") &&
                it.attr("href").toLowerCase().endsWith(".zip")
            }

        def linkFile = linkComunicacao.absUrl("href")
        def destino = new File("./Arquivos_padrao_TISS/comunicacao.zip")

        def http = configure {
            request.uri = linkFile

        }

        http.get{
            response.success {fromServer, inputStream ->
                destino.parentFile.mkdirs()
                destino.withOutputStream {out->
                    out << inputStream
                }
            }
        }

        def link2 = doc.select("a:contains(Clique aqui para acessar todas as versões dos Componentes)").first()
        def url3 = link2.absUrl("href")
        def doc3 = Jsoup.connect(url3).get()
        def linhas = doc3.select("table tbody tr")
        def arquivo = new File("dados_tiss.csv")
        arquivo.withWriter("UTF-8") { writer ->
            writer.writeLine("Competência;Publicação;Início de Vigência")
            for (def linha : linhas){
                def colunas = linha.select("td")
                def competencia = colunas[0].text()
                def convertido = converterCompetencia(competencia)
                if (convertido > 201601) {
                    def publicacao = colunas[1].text()
                    def inicioVigencia = colunas[2].text()
                    writer.writeLine("${competencia};${publicacao};${inicioVigencia}")
                }
            }
        }
        def link3 = doc.select("a:contains(Clique aqui para acessar as planilhas)").first()
        def url4 = link3.absUrl("href")
        def doc4 = Jsoup.connect(url4).get()

        def linkErro = doc4.select("a").find{
            it.text().toLowerCase().contains("tabela de erros")
        }
        def urlErro = linkErro.absUrl("href")

        def destino1 = new File("./Tabelas/tabela_erros_envio.xls")
        def http2 = configure { request.uri = urlErro }

        http2.get {
            response.success { fs, input ->
                destino1.parentFile.mkdirs()
                destino1.withOutputStream { out -> out << input }
            }
        }


    }

    static int converterCompetencia(String comp){
        def mapa = [
                'jan': '01', 'fev': '02', 'mar': '03', 'abr': '04',
                'mai': '05', 'jun': '06', 'jul': '07', 'ago': '08',
                'set': '09', 'out': '10', 'nov': '11', 'dez': '12'
        ]

        def partes = comp.split("/")
        def mes = mapa[partes[0].toLowerCase()]
        def ano = partes[1]
        return (ano + mes) as int
    }

}
