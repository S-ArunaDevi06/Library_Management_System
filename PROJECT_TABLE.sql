drop table fines;
drop table books_lent;
drop table employee;
drop table users;
drop table author;
drop table supply_source;
drop table supplier_book_details;
drop table branch_book_details;
drop table book_details;
drop table supplier;
drop table branch;

--branch
create table branch (branch_id varchar2(100) constraint branch_pk primary key,
branch_name varchar2(100) constraint branch_name_nn not null,
branch_address varchar2(100) constraint branch_address_nn not null,
branch_stock number constraint branch_stock_check check(branch_stock>0),
constraint branch_id_check check(branch_id like 'BR%'));


-- supplier
create table supplier(
    s_id varchar2(100) constraint s_pk primary key,
    name varchar2(100) constraint supplier_name_nn not null,
    phone number(10) constraint supplier_phone_nn not null,
    mail varchar2(100) constraint supplier_mail_nn not null
);

--book_details
--book_details
create table book_details(
book_id varchar2(100) constraint book_pk primary key,
book_titles varchar2(100) constraint book_details_title_nn not null,
book_type varchar2(100),
category_book varchar2(100) constraint category_nn not null,
edition_book number(10) constraint edition_check check(edition_book>=0),
press_book varchar2(100)constraint press_nn not null);

--branch_book_details
create table branch_book_details(
    book_id varchar2(100) constraint branch_book_details_book_id_fk references book_details(book_id),
    branch_id varchar2(100) constraint branch_book_details_fk references branch(branch_id),
    stock number constraint stock_check check(stock>=0),
    remaining_book number constraint remaining_book_check check(remaining_book>0),
    primary key(book_id,branch_id)
);


-- supplier_book_details
create table supplier_book_details(
    s_id varchar2(100) references supplier(s_id),
    book_id varchar2(100) references book_details(book_id),
    branch_id varchar2(100) references branch(branch_id),
    supplied_date date,
    stock number constraint supplier_book_stock_check check(stock>0),
    cost number constraint supplier_book_cost_check check(cost>0),
    primary key(s_id,book_id,branch_id,supplied_date)
);


--supply_source
create table supply_source(
    branch_id varchar2(100) references branch(branch_id),
    book_id varchar2(100) references book_details(book_id),
    s_id varchar2(100) references supplier(s_id),
    primary key(branch_id,book_id,s_id)
);

-- author
create table author(
    book_id varchar2(100) constraint author_book_id references book_details(book_id),
    author_name varchar2(100),
    primary key(book_id,author_name)
);


--users
create table users(user_id varchar2(100) constraint user_id_pk primary key,
name varchar2(100) constraint user_id_nn not null,
phone number(10) constraint users_phone_nn not null,
mail varchar2(100)constraint users_mail_nn not null,
address varchar2(100)constraint users_address_nn not null,
constraint users_user_id_check check(user_id like 'U%'));

-- employee
create table employee(
    e_id varchar2(100) constraint e_pk primary key,
    name varchar2(100) constraint name_nn not null,
    branch_id varchar2(100) constraint employee_branch_id references branch(branch_id),
    position varchar2(100) constraint position_nn not null,
    mail varchar2(100) constraint mail_nn not null,
    phone number(10) constraint phone_nn not null,
    dob date,
    supervisor_id varchar2(100) constraint supervisor_id_fk references employee(e_id),
    constraint e_id_pk_check check(e_id like 'E%')
);


-- books_lent
create table books_lent(
    user_id varchar2(100) constraint books_lent_user_id_fk references users(user_id),
    book_id varchar2(100) constraint books_lent_books_fk references book_details(book_id),
    branch_id varchar2(100) constraint books_lent_branch_fk references branch(branch_id), 
    issue_date date,
    due_date date,
    primary key(user_id,book_id,branch_id,issue_date)
);


-- fines
create table fines(
    user_id varchar2(100) constraint fines_user_id_fk references users(user_id),
    book_id varchar2(100) constraint fines_book_id_fk references book_details(book_id),
    renewal_count number constraint fines_renewal_check check(renewal_count>0),
    due_amount number constraint due_amount_check check(due_amount>=0),
    paid_status varchar2(100) constraint paid_status_check check(paid_status in ('paid','not paid','not applicable')),
    primary key(user_id,book_id)
);


-->insert on supplier_book_details --> insert or not in supply_source -->update in branch_book_details -->update in branch;

create or replace trigger supply_books
before insert on supplier_book_details
for each row

declare
    supplier_check supplier_book_details.s_id%type;
    branch_id_check branch.branch_id%type;
    book_id_check book_details.book_id%type;
    s_id_check supplier.s_id%type;
    stock_check supplier_book_details.stock%type;

begin
    
    select :new.branch_id into branch_id_check from dual;
    select :new.book_id into book_id_check from dual;
    select :new.s_id into s_id_check from dual;
    select :new.stock into stock_check from dual;

    select s_id into supplier_check
    from supply_source
    where supply_source.branch_id=branch_id_check and supply_source.book_id=book_id_check and supply_source.s_id=s_id_check;

    if supplier_check is NULL then
       insert into supply_source values(branch_id_check,book_id_check,s_id_check);
    end if;

    update branch_book_details
    set stock=stock+stock_check , remaining_book=remaining_book+stock_check
    where branch_id=branch_id_check and book_id=book_id_check;

    update branch
    set branch_stock=branch_stock+stock_check
    where branch_id=branch_id_check;

end;
/





insert into supplier_book_details values('S3','B002','BR001','12-JUN-2023',100,2000); 




delete from supplier_book_details where s_id='S3' and book_id='B002' and branch_id='BR001' and supplied_date='12-JUN-2023';




--==modified

create or replace trigger supply_books
before insert on supplier_book_details
for each row

declare
    supplier_check supplier_book_details.s_id%type;
    branch_id_check branch.branch_id%type;
    book_id_check book_details.book_id%type;
    s_id_check supplier.s_id%type;
    stock_check supplier_book_details.stock%type;

begin

    
    select :new.branch_id into branch_id_check from dual;
    select :new.book_id into book_id_check from dual;
    select :new.s_id into s_id_check from dual;
    select :new.stock into stock_check from dual;

    select s_id into supplier_check
    from supply_source
    where supply_source.branch_id=branch_id_check and supply_source.book_id=book_id_check and supply_source.s_id=s_id_check;
 
    
    update branch
    set branch_stock=branch_stock+stock_check
    where branch_id=branch_id_check;
   
    EXCEPTION
       WHEN NO_DATA_FOUND then
          insert into supply_source values(branch_id_check,book_id_check,s_id_check);


        update branch
        set branch_stock=branch_stock+stock_check
        where branch_id=branch_id_check;
end;
/
















--trigger for branch_book
create or replace trigger supply_books_branch_book
before insert on supplier_book_details
for each row

declare
    supplier_check supplier_book_details.s_id%type;
    branch_id_check branch.branch_id%type;
    book_id_check book_details.book_id%type;
    s_id_check supplier.s_id%type;
    stock_check supplier_book_details.stock%type;

begin

    
    select :new.branch_id into branch_id_check from dual;
    select :new.book_id into book_id_check from dual;
    select :new.s_id into s_id_check from dual;
    select :new.stock into stock_check from dual;

    select branch_id into branch_id_check
    from branch_book_details
    where branch_book_details.branch_id=branch_id_check and branch_book_details.book_id=book_id_check;


    update branch_book_details
    set stock=stock+stock_check , remaining_book=remaining_book+stock_check
    where branch_id=branch_id_check and book_id=book_id_check;
    


    dbms_output.put_line(''||branch_id_check||' '||book_id_check||' '||s_id_check||' '||stock_check);

    EXCEPTION
       WHEN NO_DATA_FOUND then

           insert into branch_book_details values(book_id_check,branch_id_check,stock_check,stock_check);

end;
/



create or replace procedure calculate_fines (
    p_user_id in varchar2,
    p_fine_rate in number default 1
) as
    v_due_date date;
    v_return_date date;
    v_overdue_days number;
    v_due_amount number;
    v_book_id varchar2(100);
    cursor overdue_books_cursor is
        select bd.book_id, bd.issue_date, bd.due_date
        from books_lent bd
        where bd.user_id = p_user_id
          and bd.due_date is not null
          and (bd.due_date - bd.issue_date) > 14;
begin
    open overdue_books_cursor;
    loop
        fetch overdue_books_cursor into v_book_id, v_due_date, v_return_date;
        exit when overdue_books_cursor%notfound;
        
        v_overdue_days := v_return_date - v_due_date - 14;
        v_due_amount := v_overdue_days * p_fine_rate;

        update fines
        set due_amount = v_due_amount,
            paid_status = 'paid'
        where user_id = p_user_id
          and book_id = v_book_id;
          
        -- Display the calculated fine
        dbms_output.put_line('Book ID: ' || v_book_id || ', Overdue Days: ' || v_overdue_days || ', Fine Amount: ' || v_due_amount);
    end loop;

    close overdue_books_cursor;
exception
    when others then
        dbms_output.put_line('Error: ' || sqlerrm);
end calculate_fines;
/


-- procedure for renewal count


create or replace procedure renew_count(
	fin_user_id in fines.user_id%TYPE,
    fin_book_id in fines.book_id%TYPE
)
IS
    cursor fines_cursor IS
        SELECT f.renewal_count,bl.due_date
        FROM fines f,books_lent bl
        WHERE bl.user_id=f.user_id and
        bl.book_id=f.book_id and
        f.user_id=fin_user_id and
        f.book_id=fin_book_id;

    rc fines.renewal_count%TYPE;
    dd books_lent.due_date%TYPE;

begin
    open fines_cursor;
    loop
        fetch fines_cursor into rc,dd;
        exit when fines_cursor%notfound;
        if rc>0 THEN
            rc:=rc-1;
            select sysdate+14 into dd from dual;
            dbms_output.put_line('Due date extended by 14 days');
            update fines 
            set renewal_count = rc
            where user_id=fin_user_id and
            book_id=fin_book_id;
             update books_lent 
            set due_date =dd
            where user_id=fin_user_id and
            book_id=fin_book_id;
        elsif rc=0 THEN
            dbms_output.put_line('No more renewals');
        else
            dbms_output.put_line('No such record');
        end if;
    end loop;
    close fines_cursor;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        dbms_output.put_line('No such user or book');
END;
/



-- return book

create or replace procedure return_book(
    bl_user_id in books_lent.user_id%TYPE,
    bl_book_id in books_lent.book_id%TYPE
) IS
    cursor bl_cursor is 
        select f.due_amount, f.paid_status, bbd.remaining_book 
        from books_lent bl,fines f,branch_book_details bbd
        where bl.user_id=bl_user_id and 
        bl.book_id=bl_book_id and bbd.book_id=bl_book_id;
    
    da fines.due_amount%type;
    ps fines.paid_status%type;
    rb branch_book_details.remaining_book%type;
begin
    open bl_cursor;
    loop
        fetch bl_cursor into da,ps,rb;
        exit when bl_cursor%notfound;
        if(da=0 or ps='paid') then
            delete from books_lent bl
            where bl.user_id=bl_user_id and 
            bl.book_id=bl_book_id;
            delete from fines f 
            where f.user_id=bl_user_id and
            f.book_id=bl_book_id;
            rb:=rb+1;
            update branch_book_details 
            set remaining_book=rb 
            where book_id=bl_book_id;
        elsif(da!=0 and ps='not paid') then 
            dbms_output.put_line('Pay fine');
        else
            dbms_output.put_line('No such record');
        end if;
    end loop;
    close bl_cursor;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        dbms_output.put_line('No such user or book');
END;
/


CREATE OR REPLACE PROCEDURE calculate_fines (
    p_user_id IN VARCHAR2,
    p_fine_rate IN NUMBER DEFAULT 1
) AS
    v_due_date DATE;
    v_return_date DATE;
    v_overdue_days NUMBER;
    v_due_amount NUMBER;
    v_book_id VARCHAR2(100);
    v_renewal_count NUMBER;
    v_issue_date DATE;
    CURSOR overdue_books_cursor IS
        SELECT bd.book_id, bd.issue_date, bd.due_date
        FROM books_lent bd
        WHERE bd.user_id = p_user_id
          AND bd.due_date IS NOT NULL
          AND (bd.due_date - bd.issue_date) > 14;
BEGIN
    OPEN overdue_books_cursor;
    SELECT SYSDATE INTO v_return_date FROM dual;
    LOOP
        FETCH overdue_books_cursor INTO v_book_id, v_due_date,v_issue_date;
        EXIT WHEN overdue_books_cursor%NOTFOUND;
        v_overdue_days := v_return_date - v_due_date;
        v_due_amount := v_overdue_days * p_fine_rate;
        v_renewal_count := FLOOR(v_overdue_days / 14); -- Example logic to calculate renewal_count
        UPDATE fines
        SET due_amount = v_due_amount,
            paid_status = 'paid',
            renewal_count = v_renewal_count
        WHERE user_id = p_user_id
          AND book_id = v_book_id;
        -- Display the calculated fine
       -- DBMS_OUTPUT.PUT_LINE('Book ID: ' || v_book_id || ', Overdue Days: ' || v_overdue_days || ',
    END LOOP;
    CLOSE overdue_books_cursor;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END calculate_fines;
/
