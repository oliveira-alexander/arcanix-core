CREATE TABLE formas_pagamento(
    id bigserial primary key,
    descricao varchar(50) not null,
    qtd_dias_recebimento int,
    taxa_percentual numeric(3,2)
);

CREATE INDEX IDX_FORMAS_PAGAMENTO_ID ON formas_pagamento(ID);