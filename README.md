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

## 🚀 Tecnologias utilizadas

- Groovy 2.5.4
- Java 8
- Jsoup
- HTTPBuilder-NG
- Gradle

---

## ▶️ Como executar

```bash
./gradlew run
```

---

## 📁 Estrutura esperada

```
ZG-TISS-Crawler/
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
                    └── App.groovy
```

---

## 📄 Exemplos de arquivos gerados

| Arquivo | Conteúdo |
|--------|----------|
| `dados_tiss.csv` | Competência, Publicação e Início de Vigência desde jan/2016 |
| `comunicacao.zip` | Documento oficial do componente de comunicação |
| `tabela_erros_envio.xls` | Tabela de erros no envio à ANS |

---

## 👤 Autor

**Marcelo Roner**  
Desenvolvedor apaixonado por resolver problemas com código limpo e eficiente 🚀