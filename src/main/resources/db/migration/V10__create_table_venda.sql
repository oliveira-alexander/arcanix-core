create table vendas(
    id bigserial primary key,
    forma_pagamento_id bigserial,
    cliente_id bigserial,
    dataVenda date,
    horaVenda time
);

CREATE INDEX IDX_VENDAS_ID ON VENDAS(ID);