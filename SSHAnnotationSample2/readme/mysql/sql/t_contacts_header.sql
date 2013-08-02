/*----------------------------------------------------------------------------*/
/*【表名】        連絡先マスタ(t_contacts_header) */
/*【表説明】       */
/*                 */
/*【発行日】      2013/07/03 */
/*【発行者】       */
/*【対象業務】     */
/*----------------------------------------------------------------------------*/
DROP TABLE IF EXISTS t_contacts_header;
CREATE TABLE t_contacts_header(
	contacts_seq                  DECIMAL(18)    	NOT NULL	COMMENT '連絡先連番',
	name                          VARCHAR(94)    	COMMENT '名前',
	name_family                   VARCHAR(30)    	COMMENT '姓',
	name_given                    VARCHAR(30)    	COMMENT '名',
	name_family_phonetic          VARCHAR(50)    	COMMENT '姓（読み）',
	name_given_phonetic           VARCHAR(50)    	COMMENT '名（読み）',
	nick_name                     VARCHAR(30)    	COMMENT 'ニックネーム',
	note                          VARCHAR(4000)  	COMMENT 'メモ',
	website_url                   VARCHAR(200)   	COMMENT 'webサイト',
	last_update_date              datetime       	NOT NULL	COMMENT '最終更新日',
	ins_date                      datetime       	COMMENT '登録日時',
	ins_user_id                   VARCHAR(20)    	COMMENT '登録ユーザーID',
	upd_date                      datetime       	COMMENT '更新日時',
	upd_user_id                   VARCHAR(20)    	COMMENT '更新ユーザーID',
	del_date                      datetime       	COMMENT '削除日時',
	del_user_id                   VARCHAR(20)    	COMMENT '削除ユーザーID',
	del_flg                       VARCHAR(1)     	DEFAULT 0	COMMENT '削除フラグ',
	upd_cnt                       int            	DEFAULT 1	COMMENT '更新回数',
CONSTRAINT PK_t_contacts_header
	PRIMARY KEY  (contacts_seq)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8
COMMENT '連絡先マスタ 【2013/07/03】';
