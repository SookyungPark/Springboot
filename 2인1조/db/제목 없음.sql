CREATE TABLE trip_schedule (
    ID            NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    TRIP_NAME     VARCHAR2(100),
    SCHEDULE_DATA CLOB,
    CREATED_AT    TIMESTAMP(6)  default sysdate
);
commit;

select * from trip_schedule;


select * from member_tbl_11;

create table memberacorn (
    id varchar2(10)  ,
    pwd varchar2(10) ,
    name varchar2(10) 
  ); 
  
  select * from memberacorn;
  
  insert into memberacorn values('t9','1234','kim');
  commit;
  
  
  
  //장바구니테이블
create table cart_tbl(
  cartNO  number(4)  primary key ,
  memberId varchar2(10) ,
  goodsNo  varchar2(10),
  cartQty     number(4)
);


insert into cart_tbl  values( 1, 'test01' , 'g001' ,3);
insert into cart_tbl  values( 2, 'test01' , 'g002' ,1);
insert into cart_tbl  values( 3, 'test02' , 'g002' ,1);
	 
// 상품테이블
create table goods_tbl (
  goodsNo  varchar2(10)  primary key,
  name varchar2(10) ,
  price number(4)
);

insert into goods_tbl  values( 'g001' ,'pants' , 2500);
insert into goods_tbl  values( 'g002' , 't-shirts', 3000);
insert into goods_tbl  values( 'g003' , 'vest', 4000);

 
create table ordertbl  (
   orderNo number(4)  primary key,
   memberId varchar2(10)  , 
   goodsNo varchar2(10) ,
   goodsName varchar2(10),
    qty varchar2(4) , 
   amount number(10) ,
   addr1 varchar2(20) ,
   addr2 varchar2(20 ),
   tel varchar2(13),
   name varchar2(20)
);

select   *  from  membertbl;
create sequence order_seq_num ;



drop table membertbl;
drop table boardt;


CREATE TABLE boardt (
    board_no NUMBER PRIMARY KEY,
    title    VARCHAR2(200),
    writer   VARCHAR2(100),
    content  VARCHAR2(100)
);


CREATE TABLE membertbl (
    id   varchar2(10) primary key  ,
    name VARCHAR2(50),
    email VARCHAR2(50)
);



INSERT INTO boardt (board_no, title, writer, content)
VALUES (1, '첫 번째 게시글', '변우석', '자바 다형성이 뭔가요? ');

INSERT INTO boardt (board_no, title, writer, content)
VALUES (2, '두 번째 게시글', '공유', ' toString()매서드 오버라이드 해야 하나요');

INSERT INTO boardt (board_no, title, writer, content)
VALUES (3, '세 번째 게시글', '브래드피트', '생성자와 접근제어자를 두는 이유는 뭔가요');


INSERT INTO boardt (board_no, title, writer, content)
VALUES (4, '세 번째 게시글', '한효주', 'Comparator.comparing(  item -> item.getName )  이 내용설명해주세요 ');



insert into membertbl values('acorn','권지언','aaa@naver.com');
insert into membertbl values('acorn3','윤현기','bbb@goole.com');
insert into membertbl values('acorn4','박예린','ccc@naver.com');
commit;

select * from membertbl;

--name = '' 이거나  뒤에 조건은 무조건 참이 되므로  조건이 만족해서 모든 고객정보가 조회됨
--SELECT * FROM acorntbl WHERE name = '황예지';
--SELECT * FROM acorntbl WHERE name = ' ' OR '1'='1';

insert into acorntbl values('admin','1234','관리자');
commit;

select * from acorntbl where id='admin';

select * from boardt;
select * from boardt  where  content  like '%다형성%';
select * from boardt  where  content  like '%' || '다형성'   ||'%';




---------- 2인1조 테이블 시작
CREATE TABLE bang (
    name varchar2(10),
    dateA date default sysdate,
    pw VARCHAR2(20),
    content varchar2(50)
);



INSERT INTO bang (name,  pw, content)
VALUES ('이수민',  '1234', '집에 가고싶어오');


commit;
select * from bang;


--drop table bang;

---------- 2인1조 테이블 끝


--------------------------------------------------------------------------------------------
---------- 2인1조 테이블 시작
CREATE TABLE board_tbl(
 board_no varchar2(1000) PRIMARY KEY,
 writer varchar2(10),
 title  varchar2(20) NOT NULL,
 content varchar2(100), 
 board_pw varchar2(30),
 hit varchar2(1000) DEFAULT 0,
 creat_at DATE DEFAULT sysdate,
 CONSTRAINT fk_writer_name FOREIGN KEY (writer) REFERENCES board_user_tbl(name)
);


DROP TABLE board_tbl;
DELETE board_tbl;



INSERT INTO board_tbl (board_no, writer, title, content, board_pw)
values('1','test1', 'testtitle1','testcontents1', '5555' );


INSERT INTO board_tbl (board_no, writer, title, content, board_pw)
values('2','test2', 'testtitle1','testcontents1', '1234' );

insert into board_tbl(writer, title, content, board_pw)
values('test2','title1','contnet1','1234');

commit;

SELECT * FROM board_tbl;






---------- 2인1조 테이블 끝

CREATE TABLE board_tbl(
 board_no varchar2(1000) PRIMARY KEY,
 writer varchar2(10),
 title  varchar2(20) NOT NULL,
 content varchar2(100), 
 board_pw varchar2(30),
 hit varchar2(1000) DEFAULT 0,
 creat_at DATE DEFAULT sysdate,
 CONSTRAINT fk_writer_name FOREIGN KEY (writer) REFERENCES board_user_tbl(name)
);


CREATE SEQUENCE board_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOORDER;


-- 시퀀스 삭제
DROP SEQUENCE board_tbl;


CREATE OR REPLACE TRIGGER trg_board_tbl
BEFORE INSERT ON board_tbl
FOR EACH ROW
BEGIN
    IF :NEW.board_no IS NULL THEN
        SELECT board_seq.NEXTVAL -- 1 = 시퀀스 트리거를 실행할 때 자리수를 뜻함
        INTO :NEW.board_no
        FROM DUAL;
    END IF;
END;
/
SELECT * FROM user_errors WHERE type = 'TRIGGER' AND name = 'TRG_BOARD_TBL';
DROP TRIGGER trg_board_tbl;
