
📄 README — Nowaste

Nowaste

📌 Sobre

O Nowaste é um sistema desenvolvido em Java com foco no controle de validade de produtos em estoque, voltado para empresas como supermercados.
O diferencial do sistema é que o controle é feito por lote, permitindo que um mesmo produto tenha múltiplas datas de validade, tornando o gerenciamento mais preciso e evitando desperdícios.

🎯 Problema

Empresas que trabalham com estoque enfrentam dificuldades como:

controlar validade de produtos por lote
identificar produtos próximos do vencimento
evitar perdas e prejuízos
💡 Solução

O Nowaste resolve isso através de:

cadastro de produtos organizados por categoria
cadastro de lotes com validade individual
análise automática da validade dos lotes
⚙️ Funcionalidades implementadas (Sprint 0)
Cadastro de produtos
Cadastro de lotes com data de validade
Associação entre produto e lote
Organização por categoria
Verificação de validade dos lotes
🧠 Regras de negócio
Um produto pode ter vários lotes
Cada lote possui sua própria data de validade
O sistema define automaticamente o status do lote:
VÁLIDO
PRÓXIMO DO VENCIMENTO
VENCIDO

## 🧱 Estrutura do projeto

```bash
src/
├── domain/    # entidades
├── service/   # regras de negócio
├── infra/     # persistência em memória
└── ui/        # interface em console
```
 
📦 Principais classes(ainda podem ser mudadas ao decorrer do desenvolvimento)
📦 Domain
Produto
Lote
Fornecedor
StatusProduto (enum)
⚙️ Service
ProdutoService
LoteService
💾 Infra
ProdutoRepositoryMemoria
LoteRepositoryMemoria
🖥️ UI
ConsoleUI
Menu
▶️ Como executar
Clonar o repositório:
git clone https://github.com/gabszinn/Nowaste.git
Abrir na IDE (IntelliJ / Eclipse)
Executar a classe principal (Main ou ConsoleUI)
🧪 Testes

🚧 Ainda em desenvolvimento

Planejado:

Testes unitários com JUnit
Testes BDD com Cucumber
📊 Status do projeto

✔ Sprint 0 concluída

Estrutura inicial criada
Primeira funcionalidade implementada (criação de login)
🚀 Próximos passos
Listagem de lotes
Produtos que vencem no mês
Produtos prestes a vencer
Alertas de vencimento
Testes automatizados
As funcionalidades detalhadas estão disponíveis no backlog do projeto (GitHub Issues).
👥 Integrantes

Gabriel Felipe, Isadora Rodrigues, Weslley Carvalho, Henrique Cezar
