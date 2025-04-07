# 🤖 ZG TISS Crawler

Este projeto é um bot desenvolvido em **Groovy** utilizando as bibliotecas **Jsoup** e **HttpBuilder-NG**, com o objetivo de automatizar a coleta de informações públicas da Agência Nacional de Saúde Suplementar (ANS) relacionadas ao **Padrão TISS**.

---

## ✅ Funcionalidades

| Task | Descrição |
|------|-----------|
| 1️⃣ | Baixa o arquivo mais recente do **Componente de Comunicação** do padrão TISS |
| 2️⃣ | Coleta as competências a partir de **jan/2016** com datas de publicação e início de vigência |
| 3️⃣ | Baixa a **Tabela de Erros no envio para a ANS** |

---

## 📨 Funcionalidade extra: Envio de e-mails

Este projeto também implementa uma **automação completa de envio de e-mails** contendo os arquivos gerados pelo crawler. As funcionalidades extras implementadas são:

| Funcionalidade                  | Descrição                                                                 |
|--------------------------------|---------------------------------------------------------------------------|
| 📬 CRUD de e-mails interessados | É possível **adicionar, listar, remover e limpar** os e-mails em `emails.txt` |
| 📎 Envio automático de anexos   | Ao final da execução, os arquivos `.zip`, `.csv` e `.xls` são enviados automaticamente |
| 🛠️ Configurável                 | A lista de e-mails pode ser editada manualmente ou via terminal           |

---

## 🚀 Tecnologias utilizadas

- Groovy 2.5.4  
- Java 8  
- Jsoup  
- HTTPBuilder-NG  
- JavaMail (javax.mail)  
- Gradle  

---

## ▶️ Como executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/ZG-TISS-Crawler.git
cd ZG-TISS-Crawler
```

2. Adicione os e-mails dos interessados:

Crie ou edite o arquivo `emails.txt` (um e-mail por linha):

```
exemplo1@email.com
exemplo2@email.com
```

3. Execute o projeto:

```bash
./gradlew run
```

---

## 📁 Estrutura esperada

```
ZG-TISS-Crawler/
├── emails.txt
├── Arquivos_padrao_TISS/
│   └── comunicacao.zip
├── Tabelas/
│   └── tabela_erros_envio.xls
├── dados_tiss.csv
└── src/
    └── main/
        └── groovy/
            └── zg/
                └── crawler/
                    ├── App.groovy
                    ├── CrawlerANS.groovy
                    ├── EmailCLI.groovy
                    ├── EmailSender.groovy
                    └── EmailService.groovy
```

---

## 📄 Exemplos de arquivos gerados

| Arquivo                 | Conteúdo                                                      |
|-------------------------|---------------------------------------------------------------|
| `dados_tiss.csv`        | Competência, Publicação e Início de Vigência desde jan/2016   |
| `comunicacao.zip`       | Documento oficial do componente de comunicação                |
| `tabela_erros_envio.xls`| Tabela de erros no envio à ANS                                |

---

## 👤 Autor

**Marcelo Roner**  
Desenvolvedor apaixonado por resolver problemas com código limpo e eficiente 🚀
