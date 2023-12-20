create table if not exists invoiceTable
(
    id      uuid  default random_uuid() primary key,
    pdf_url varchar(255),
    user_id varchar(255),
    amount  int
);