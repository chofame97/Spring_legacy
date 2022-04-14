-- customer 테이블 생성
create table customer (
  id      number constraint customer_id_pk primary key,
  name    varchar2(50) not null,
  gender  varchar2(3) default '여' not null,
  email   varchar2(50),
  phone   varchar2(13)
);

desc customer;

-- 시퀀스 생성 : seq_customer
create SEQUENCE seq_customer START WITH 1 INCREMENT BY 1;


-- 레코드 삽입 (홍길동, 남)
insert into customer (id, name, gender)
VALUES (seq_customer.nextval, '홍길동', '남');

commit;

select * from customer;

-- 트리거 생성 : trg_customer
create trigger trg_customer
  before insert on customer -- customer table에 insert가 되기 전에
  for each row              -- 모든 행에 대하여 
begin                       -- 시작한다.
  select seq_customer.nextval into :new.id from dual;
  -- sequence의 데이터를 담고 있는 테이블은 없으므로 더미 테이블(dual)에서 조회한다
end;
/     -- 끝 슬래쉬까지 기재해야 함.
;

-- 레코드 삽입 (박문수, 남)
insert into customer(name, gender)
values ('박문수', '남');



-- 회원관리 테이블 (member) 생성
create table member (
   id     varchar2(100),
   name   varchar2(20),
   pw     varchar2(20),
   addr   varchar2(200),
   post   varchar2(10),
   tel    varchar2(20),
   gender varchar2(3) default '여',
   email  varchar2(100),
   birth  varchar2(30),
   naver  varchar2(100),
   kakao  varchar2(100),
constraint member_id_pk primary key(id)
);
select * from member;

insert into member (id, name, pw)
values ('hanul', '한울', 'hanul');

insert into member (id, name, pw)
values ('admin', '관리자', 'admin');

commit; 

select * from member;

desc member;

-- member 테이블에 admin 컬럼 추가
alter table member
add (admin  varchar2(1) default 'N');

-- 관리자 구분을 위하여 'admin' 에 'Y' 값을 부여하여 구분
update member set admin = 'Y'
where id = 'admin';

select * from member
where id = 'admin';

-- 공지사항(notice) Table 생성
create table notice (
  id          number constraint notice_id_pk primary key,
  title       varchar2(300) not null,
  content     varchar2(4000) not null,
  writer      varchar2(50)  not null
          constraint notice_writer_fk REFERENCES member(id) on delete cascade,
  writedate   date  default sysdate,
  readcnt     number  default 0,
  filename    varchar2(300),
  filepath    varchar2(500)
);
-- on delete cascade : 참조되는 부모 테이블의 행에 대한 Delete를 허용한다.
-- 즉, 참조되는 부모테이블 값이 삭제되면 연쇄적으로 자식테이블 값 역시 삭제됨


-- 공지사항(notice) Table 생성
create table notice (
  id        number,
  title     varchar2(300) not null,
  content   varchar2(4000) not null,
  writer    varchar2(50) not null,
  writedate date  default sysdate,
  readcnt   number default 0,
  filename  varchar2(300),
  filepath  varchar2(500),
  
  constraint notice_id_pk primary key(id),
  constraint notice_writer_fk foreign key(writer) references member(id) on delete cascade
   
);

-- 시퀀스 (seq_notice) 생성
create sequence seq_notice
start with 1 increment by 1;
-- 1부터 시작하여 1씩 증가하는 시퀀스(seq_notice)를 생성

-- 아래 2건의 데이터 추가
-- id       title                       content                      writer
-- 1   첫 번째 공지글입니다.   관리자가 작성한 공지사항입니다.        admin
-- 2   두 번째 공지글입니다.   관리자가 작성한 2번째 공지글입니다.    admin

insert into notice (id, title, content, writer)
values (seq_notice.nextval, '첫 번째 공지글입니다.','관리자가 작성한 공지사항입니다.', 'admin');

insert into notice (id, title, content, writer)
values (seq_notice.nextval, '두 번째 공지글입니다.','관리자가 작성한 2번째 공지글입니다.', 'admin');

select * from notice;
commit;







